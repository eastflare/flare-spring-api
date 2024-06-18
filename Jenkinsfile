pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew clean build'
            }
        }
    }
}
