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
                    docker compose down -v --remove-orphans || true
                    docker compose up --build --force-recreate -d
                    docker image prune -f
                '''
            }
        }

        stage('Verify Deployment') {
            steps {
                echo "Waiting 30 seconds for services to stabilize..."
                sh 'sleep 30'
                // Verification call
                sh 'curl -f http://localhost:81/app' 
            }
        }
    }

    post {
        success {
            echo "✅ Deployment Successful"
        }
        failure {
            echo "❌ Deployment Failed - Check the console output above for errors."
        }
    }
}
