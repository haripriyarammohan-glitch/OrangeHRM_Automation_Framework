pipeline {

    agent any

    stages {

        

        stage('Build & Test') {
            steps {
                echo 'Running Maven Tests...'
                bat 'mvn clean test'
            }
        }
    }

    post {

        always {
            echo 'Pipeline Execution Completed'
        }

        success {
            echo 'Build Successful'
        }

        failure {
            echo 'Build Failed'
        }
    }
}