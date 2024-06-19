pipeline {
    agent any
    tools {
        dockerTool 'Jenkins-Docker'
    }

    environment {
        IMAGE_NAME = "flare-spring-api"
        DOCKER_IMAGE = "eastflare/flare-spring-api"
        DOCKER_CREDENTIALS = "docker-hub"
        DOCKER_REGISTRY = "https://registry.hub.docker.com"
        TARGET_HOST = "bbnerino@heyhey.i234.me"
        ContainerPort = "3333"
        LocalPort = "3333"
        DOCKER_USER="bbnerino"
        DOCKER_PASS="****"
    }

    stages {
        stage('build') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew clean build'
            }
        }
        stage('docker build and push') {
            steps {
                script {
                    docker.withRegistry( ${DOCKER_REGISTRY}, 'docker-account') {
                        def image = docker.build("eastflare/flare-spring-api:v1")
                        image.push()
                    }
                }
            }
        }
    }
}
