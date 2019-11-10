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
                sh 'docker stop tcs-llyods-frontend-ui1 || exit 0'
                sh 'docker kill tcs-llyods-frontend-ui1 || exit 0'
                sh 'docker rm tcs-llyods-frontend-ui1 || exit 0'
                sh 'docker rmi tcs-llyods-frontend-ui1 || exit 0'
                sh 'docker build . -t tcs-llyods-frontend-ui1'
                sh 'docker run --name tcs-llyods-frontend-ui1 -p 8081:8081 -d tcs-llyods-frontend-ui1'
                }
            }

            }

            stage('Build Docker Image For back end'){
            steps{
                dir('/var/lib/jenkins/workspace/TCS-Lyods pipeline/Backend/devops-backend/'){
                sh 'docker stop tcs-llyods-backend-s1 || exit 0'
                sh 'docker kill tcs-llyods-backend-s1 || exit 0'
                sh 'docker rm tcs-llyods-backend-s1 || exit 0'
                sh 'docker rmi tcs-llyods-backend-s1 || exit 0'
                sh 'docker build . -t tcs-llyods-backend-s1'
                sh 'docker run --name tcs-llyods-backend-s1 -p 8081:8081 -d tcs-llyods-backend-s1'
                }
            }
            }
        }
    }





