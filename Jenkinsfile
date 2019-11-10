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
                sh 'docker stop suvin241/tcs-llyods-frontend-ui1 || exit 0'
                sh 'docker kill suvin241/tcs-llyods-frontend-ui1 || exit 0'
                sh 'docker rm suvin241/tcs-llyods-frontend-ui1 || exit 0'
                sh 'docker rmi suvin241/tcs-llyods-frontend-ui1 || exit 0'
                sh 'docker build . -t suvin241/tcs-llyods-frontend-ui1'
               //sh 'docker run --name tcs-llyods-frontend-ui1 -p 8081:8081 -d tcs-llyods-frontend-ui1'
                }
            }

            }

            stage('Build Docker Image For back end'){
            steps{
                dir('/var/lib/jenkins/workspace/TCS-Lyods pipeline/Backend/devops-backend/'){
                sh 'docker stop suvin241/tcs-llyods-backend-s1 || exit 0'
                sh 'docker kill suvin241/tcs-llyods-backend-s1 || exit 0'
                sh 'docker rm suvin241/tcs-llyods-backend-s1 || exit 0'
                sh 'docker rmi suvin241/tcs-llyods-backend-s1 || exit 0'
                sh 'docker build . -t suvin241/tcs-llyods-backend-s1'
               //sh 'docker run --name tcs-llyods-backend-s1 -p 8082:8082 -d tcs-llyods-backend-s1'
                }
            }
            }

            stage('DockerHub Push'){
            steps{
                withCredentials([string(credentialsId: 'docker-hub', variable: 'dockerHubPwd')]) {
                    sh "docker login -u suvin241 -p ${dockerHubPwd}"
                    sh 'docker push suvin241/tcs-llyods-frontend-ui1'
                    sh 'docker push suvin241/tcs-llyods-backend-s1'

                }
            }
        }

        stage('Deploy to k8s'){
            steps{
                sh 'scp -o StrictHostKeyChecking=no services.yml pod.yml'
                    script{
                        try{
                            sh "kubectl apply -f ."
                        }catch(error){
                            sh "kubectl create -f ."
                        }
                    }
            }
        }
        }
    }





