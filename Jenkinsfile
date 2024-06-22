pipeline {
    agent any
    
    environment {
        IMAGE_NAME = "flareapi"
        DOCKER_IMAGE = "eastflare/flare-spring-api:latest"
        DOCKER_REGISTRY = "https://index.docker.io/v1/"
        DOCKER_CREDENTIALS_ID = "docker-account"
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
                sh 'docker build -t ${DOCKER_IMAGE} -f Dockerfile .'
            }
        }
        stage('Push to Registry') {
            steps {
                withDockerRegistry([credentialsId: "${DOCKER_CREDENTIALS_ID}", url: "${DOCKER_REGISTRY}"]) {
                    sh 'docker push ${DOCKER_IMAGE}'
                }
            }
        }
        stage('Deploy') {
            steps {
                sh """
                    cat /var/jenkins_home/my_password.txt | docker login --username=${DOCKER_ID} --password-stdin
                    docker pull ${DOCKER_IMAGE}
                    docker stop ${IMAGE_NAME} || true
                    docker rm ${IMAGE_NAME} || true
                    docker run -d --name ${IMAGE_NAME} -p 8080:8080 ${DOCKER_IMAGE}
                """
            }
        }
    }
}
