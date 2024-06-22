pipeline {
    agent any
    
    environment {
        IMAGE_NAME = "flare-api"
    }

    stages {
        stage('build') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew clean build'
            }
        }
        stage('Dockerize') {
            steps {
                sh 'docker build -t ${IMAGE_NAME} -f Dockerfile .'
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker stop ${IMAGE_NAME}'
                sh 'docker rm ${IMAGE_NAME}'
                sh 'docker run docker run -d --name ${IMAGE_NAME} -p 8080:8080 ${IMAGE_NAME}'
            }
        }
    }
}
