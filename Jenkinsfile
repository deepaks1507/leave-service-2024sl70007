pipeline {
      agent any

      environment {
          SONAR_TOKEN = credentials('sonar-token')
      }

      stages {
          stage('Checkout') {
              steps {
                  checkout scm
              }
          }

          stage('Build and Test') {
              steps {
                  sh 'mvn clean verify'
              }
              post {
                  always {
                      junit '**/surefire-reports/*.xml'
                  }
              }
          }

          stage('SonarQube Code Inspection') {
              steps {
                  sh """
                      mvn sonar:sonar \
                        -Dsonar.projectKey=leave-service-2024sl70007 \
                        -Dsonar.host.url=http://localhost:9000 \
                        -Dsonar.login=${SONAR_TOKEN}
                  """
              }
          }
      }
  }
