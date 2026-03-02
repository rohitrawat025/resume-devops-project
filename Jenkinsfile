pipeline {
    agent { label 'agntnd-1' }

    options { timestamps() }

    triggers {
        githubPush()
    }

    stages {

        stage('Clean Workspace') {
            steps { cleanWs() }
        }

        stage('Checkout Code') {
            steps { checkout scm }
        }

        stage('Build Docker Images') {
            steps {
                sh 'docker compose down || true'
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
                sh 'sleep 15'
                sh 'curl -f http://localhost:80/api/profile'
            }
        }
    }

    post {
        success { echo '✅ Deployment Successful' }
        failure { echo '❌ Deployment Failed' }
    }
}
