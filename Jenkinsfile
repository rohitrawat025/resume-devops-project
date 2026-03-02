pipeline {

    agent { label 'agntnd-1' }

    triggers {
        githubPush()     // 🔥 Auto trigger on GitHub push
    }

    options {
        disableConcurrentBuilds()
        timestamps()
    }

    environment {
        COMPOSE_FILE = "docker-compose.yml"
    }

    stages {

        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Docker Cleanup') {
            steps {
                sh '''
                    docker compose down || true
                    docker system prune -f || true
                '''
            }
        }

        stage('Build Images') {
            steps {
                sh 'docker compose build --no-cache'
            }
        }

        stage('Deploy Containers') {
            steps {
                sh 'docker compose up -d'
            }
        }

        stage('Verify Deployment') {
            steps {
                sh 'docker ps'
            }
        }
    }

    post {
        success {
            echo "✅ Deployment Successful"
        }
        failure {
            echo "❌ Deployment Failed"
        }
    }
}
