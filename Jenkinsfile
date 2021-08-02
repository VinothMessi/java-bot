pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Build') {
          steps {
            echo 'Build Step'
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