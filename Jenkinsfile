pipeline {
    agent any
    
    
    stages{
    stage('Get code from hithub'){
        steps{
            echo('welcome')
        }
    }
        
        stage('Build Docker Image For front end'){
            steps{
                dir('/var/lib/jenkins/workspace/TCS-Lyods pipeline/Frontend/my-app/'){
                sh 'docker stop suvin241/frontend-ui2 || exit 0'
                sh 'docker kill suvin241/frontend-ui2 || exit 0'
                sh 'docker rm suvin241/frontend-ui2 || exit 0'
                sh 'docker rmi suvin241/frontend-ui2 || exit 0'
                sh 'docker build . -t suvin241/frontend-ui2'
               //sh 'docker run --name frontend-ui1 -p 8081:8081 -d frontend-ui1'
                }
            }

            }
        

            stage('Build Docker Image For back end'){
            steps{
                dir('/var/lib/jenkins/workspace/TCS-Lyods pipeline/Backend/devops-backend/'){
                sh 'docker stop suvin241/backend-s2 || exit 0'
                sh 'docker kill suvin241/backend-s2 || exit 0'
                sh 'docker rm suvin241/backend-s2 || exit 0'
                sh 'docker rmi suvin241/backend-s2 || exit 0'
                sh 'docker build . -t suvin241/backend-s2'
               //sh 'docker run --name backend-s1 -p 8082:8082 -d backend-s1'
                }
            }
            }

            stage('DockerHub Push'){
            steps{
                withCredentials([string(credentialsId: 'docker-hub', variable: 'dockerHubPwd')]) {
                    sh "docker login -u suvin241 -p ${dockerHubPwd}"
                    sh 'docker push suvin241/frontend-ui2'
                    sh 'docker push suvin241/backend-s2'

                }
            }
        }

        stage('Deploy to k8s'){
            steps{
                sshagent(['kubernets']) {
                sh 'scp -o StrictHostKeyChecking=no services-backend.yml services-frontend.yml pods-backend.yml pods-frontend.yml ubuntu@172.31.11.224:/home/ubuntu'
                    script{
                        try{
                            sh "ssh ubuntu@172.31.11.224 kubectl apply services-frontend.yml pods-frontend.yml"
                            sh "ssh ubuntu@172.31.11.224 kubectl apply services-backend.yml pods-backend.yml"

                        }catch(error){
                            sh "ssh ubuntu@172.31.11.224 kubectl create -f services-frontend.yml pods-frontend.yml"
                            sh "ssh ubuntu@172.31.11.224 kubectl create -f services-backend.yml pods-backend.yml"

                        }
                    }
            }
        }
        }
        }
    }





