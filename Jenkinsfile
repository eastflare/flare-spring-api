pipeline {
    agent any
    
    environment {
        IMAGE_NAME = "flare-api"
        DOCKER_IMAGE = "eastflare/flare-spring-api"
        DOCKER_REGISTRY = "https://registry.hub.docker.com"
        DOCKER_CREDENTIALS = "docker-account"
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
                sh 'docker build -t ${IMAGE_NAME} -f Dockerfile .'
                sh 'docker tag ${IMAGE_NAME} ${DOCKER_IMAGE}'
            }
        }
        stage('Push to Registry') {
            steps {
                withDockerRegistry([credentialsId: "${DOCKER_CREDENTIALS}", url: "${DOCKER_REGISTRY}"]) {
                    sh 'docker push ${DOCKER_IMAGE}'
                }
            }
        }
        stage('Deploy') {
            steps {
                sh """
                    docker login -u eastflare -p 1!jdmesnga
                    docker pull ${DOCKER_IMAGE}
                    docker stop ${IMAGE_NAME} || true
                    docker rm ${IMAGE_NAME} || true
                    docker run docker run -d --name ${IMAGE_NAME} -p 8080:8080 ${DOCKER_IMAGE}:latest
                """
            }
        }
    }
}
