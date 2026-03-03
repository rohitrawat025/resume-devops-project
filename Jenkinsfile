pipeline {
    agent { label 'agntnd-1' }

    triggers {
        githubPush()
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

        stage('Build & Deploy') {
            steps {
                sh '''
                    docker compose down -v || true
                    docker compose up --build -d
                '''
            }
        }

        stage('Verify Deployment') {
            steps {
                echo "Waiting for service to stabilize..."
                sh 'sleep 30'
                // Targeting the updated /app path on port 81
                sh 'curl -f http://localhost:81/app' 
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
