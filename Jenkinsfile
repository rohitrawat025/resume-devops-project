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
                    echo "Stopping existing containers and clearing volumes..."
                    docker compose down -v --remove-orphans || true
                    
                    echo "Building and starting services with fresh code..."
                    # --build forces an image rebuild, --force-recreate ensures fresh containers
                    docker compose up --build --force-recreate -d
                    
                    echo "Cleaning up unused Docker images..."
                    docker image prune -f
                '''
            }
        }

        stage('Verify Deployment') {
            steps {
                echo "Waiting 30 seconds for Java App and MySQL to be healthy..."
                sh 'sleep 30'
                # Verify that the Nginx proxy is responding correctly on port 81
                sh 'curl -f http://localhost:81/app' 
            }
        }
    }

    post {
        success {
            echo "✅ Deployment Successful: The new UI is now live!"
        }
        failure {
            echo "❌ Deployment Failed: Check docker logs for more info."
        }
    }
}
