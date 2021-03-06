def git_auth = "5abce53f29643a718c45ae2551d19e1d341594df"

def git_url = "https://github.com/stevenchen0018/myjoy-cloud.git"

def tag = "latest"

def aliyun_url = "registry.cn-shenzhen.aliyuncs.com"

def aliyun_auth = "c4e8b604-450d-4872-97b7-a6475abf6700"

def aliyun_project = "myjoy-cloud"

node {

    //获取当前选择的项目名称
    def projectNames = "${project_name}".split(",")

    //获取当前选择的服务器名称
    def Servers = "${publish_server}".split(",")

	stage('拉取代码') {
		checkout([$class: 'GitSCM', branches: [[name: '*/${branch}']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: "${git_auth}", url: "${git_url}"]]])
	}

	stage('编译，安装公共子工程') {

    	 for(int i=0; i<projectNames.length;i++){

             //获取每个微服务的名字
             def projectInfo = projectNames[i];

             //切割出微服务名
             def projectName = "${projectInfo}".split("@")[0]

             sh "echo 微服务名字: ${projectName}"

             sh "/usr/local/maven/bin/mvn -f ${projectName} clean package dockerfile:build"
         }
    }

    stage('镜像上传至阿里云仓库') {

       for(int i=0; i<projectNames.length;i++){

            //获取每个微服务的名字
            def projectInfo = projectNames[i];

            //切割出微服务名
            def projectName = "${projectInfo}".split("@")[0]

            //切割出port
            def projectPort = "${projectInfo}".split("@")[1]

            //定义镜像名字
            def imageName = "${projectName}:${tag}"

            //为镜像打标签
            sh "docker tag ${imageName}  ${aliyun_url}/${aliyun_project}/${imageName}"

            //凭据登录
            withCredentials([usernamePassword(credentialsId:"${aliyun_auth}", passwordVariable: 'password', usernameVariable: 'username')]) {

             //引用用户名密码登录
             sh "docker login -u ${username} -p ${password} ${aliyun_url}"

             //镜像上传
             sh "docker push ${aliyun_url}/${aliyun_project}/${imageName} && echo 镜像上传成功"

             //登出 Harbor
             sh "docker logout ${aliyun_url}"

            }

            for(int j=0;j<Servers.length;j++){

                //获取当前遍历的服务器名称
                def ServerName = Servers[j]

                // 部署应用
                sshPublisher(publishers: [sshPublisherDesc(configName: "${ServerName}", transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: "/opt/jenkins/deployCluster.sh $aliyun_url $aliyun_project $projectName $tag $projectPort ", execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: '')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
            }
       }

    }
}
