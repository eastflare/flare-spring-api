pipeline {
    agent any

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
                        def image = docker.build("eastflare/flare-spring-api:v1")
                        image.push()
                    }
                }
            }
        }
    }
}
