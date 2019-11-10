pipeline {
    agent any
    
    environment{
        DOCKER_TAG = getDockerTag()
    }
    stages{
    stage('Get code from hithub'){
        steps{
            echo('welcome')
        }
    }
        stage('Build Docker Image For front end'){
            steps{
                dir('/Frontend/my-app'){
                sh "docker build . -t tcs-llyods/frontend:${DOCKER_TAG}"
                sh "docker run --name tcs-llyods/frontend:${DOCKER_TAG} -p 8081:8081 -d s-llyods/frontend:${DOCKER_TAG} "
                }
            }

            }
        }
    }


def getDockerTag(){
    def tag  = sh script: 'git rev-parse HEAD', returnStdout: true
    return tag
}


