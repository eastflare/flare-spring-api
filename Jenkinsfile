pipeline {
    agent any
    
    environment {
        IMAGE_NAME = "flare-api"
        DOCKER_IMAGE = "eastflare/flare-api"
        DOCKER_REGISTRY = "https://registry.hub.docker.com"
        CREDENTIAL_ID = "docker-account"
        DOCKER_ID = "eastflare"
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
                script {
                    docker.withRegistry( ${DOCKER_REGISTRY}, ${DOCKER_ACCOUNT}) {
                        def image = docker.build("${DOCKER_IMAGE}:v1")
                        image.push()
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker login -u eastflare -p 1!jdmesnga'
                sh 'docker pull ${DOCKER_IMAGE}'
                sh 'docker stop ${IMAGE_NAME} || true'
                sh 'docker rm ${IMAGE_NAME} || true'
                sh 'docker run docker run -d --name ${IMAGE_NAME} -p 8080:8080 ${DOCKER_IMAGE}:v1'
            }
        }
    }
}
