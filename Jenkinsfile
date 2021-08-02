pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Build') {
          steps {
            echo 'Build Step'
            git(url: 'https://github.com/VinothMessi/java-bot.git', branch: 'master', poll: true, changelog: true, credentialsId: 'GIT')
          }
        }

        stage('Test') {
          steps {
            echo 'Integration Tests'
          }
        }

      }
    }

    stage('Deploy') {
      steps {
        echo 'Deployment process'
      }
    }

  }
}