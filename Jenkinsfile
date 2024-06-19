pipeline {
    agent any
    tools {
        dockerTool 'Jenkins-Docker'
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
                    docker.withRegistry('https://registry.hub.docker.com', 'docker-account') {
                        echo '도커 빌드'
                    }
                }
            }
        }
    }
}
