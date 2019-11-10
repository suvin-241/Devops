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
        stage('Build Docker Image'){
            steps{
                sh "docker build . -t tcs-llyods/nodeapp:${DOCKER_TAG}"
            }
        }
    }
}

def getDockerTag(){
    def tag  = sh script: 'git rev-parse HEAD', returnStdout: true
    return tag
}
