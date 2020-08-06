def git_auth = "5abce53f29643a718c45ae2551d19e1d341594df"

def git_url = "https://github.com/stevenchen0018/myjoy-cloud.git"

node {

	stage('拉取代码') {
		checkout([$class: 'GitSCM', branches: [[name: '*/${branch}']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: "${git_auth}", url: "${git_url}"]]])
	}
}
