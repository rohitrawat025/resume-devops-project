pipeline {
    agent { label 'agntnd-1' }

    stages {
   stage('Deploy') {
     steps {
       sh 'docker compose down'
       sh 'docker compose build'
       sh 'docker compose up -d'
     }
   }
 }
}
