pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Build Step'
        git(url: 'https://github.com/VinothMessi/java-bot.git', branch: 'master', poll: true, changelog: true, credentialsId: 'GIT')
        bat 'mvn compile'
      }
    }

  }
}