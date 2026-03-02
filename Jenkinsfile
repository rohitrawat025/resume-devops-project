pipeline {
    agent { label 'agntnd-1' }

    triggers {
        githubPush()   // Auto build on GitHub push
    }

    options {
        skipDefaultCheckout(true)
        timestamps()
    }

    stages {

        stage('Clean Workspace') {
            steps {
                cleanWs()
            }
        }

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/rohitrawat025/resume-devops-project.git'
            }
        }

        stage('Build Containers') {
            steps {
                sh '''
                    docker compose down -v || true
                    docker compose build --no-cache
                '''
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
        success {
            echo "✅ Deployment Successful"
        }
        failure {
            echo "❌ Deployment Failed"
        }
    }
}
