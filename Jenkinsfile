pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Build Step'
        git(url: 'https://github.com/VinothMessi/java-bot.git', branch: 'master', poll: true, changelog: true, credentialsId: 'GIT')
        sh 'mvn compile'
      }
    }

    stage('Test') {
      parallel {
        stage('UnitTest') {
          steps {
            echo 'Unit Testing'
          }
        }

        stage('IntegrationTest') {
          environment {
            agentURL = 'http://localhost:4444/wb/hub'
          }
          steps {
            echo "Integration Testing ${agentURL}"
          }
        }

      }
    }

    stage('Deployment') {
      steps {
        echo 'Deployment process'
        input 'Do you want to deploy?'
      }
    }

  }
}