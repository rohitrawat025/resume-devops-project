pipeline {
    agent { label 'agntnd-1' }

    stages {
        stage('Cleanup') {
            steps {
                // Deletes the fake directory if it exists
                sh 'rm -rf ./nginx/default.conf'
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker compose down'
                sh 'docker compose build'
                sh 'docker compose up -d'
            }
        }
    }
}
