pipeline {
 agent any

 stages {

   stage('Checkout') {
     steps {
       git 'https://github.com/YOUR_USERNAME/resume-devops-project.git'
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
