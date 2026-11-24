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

         stage('Build Docker Image') {
              steps {
                  sh 'mvn clean package -DskipTests'
                  sh 'docker build -t leave-service:2024sl70007 .'
              }
          }

          stage('Deploy to Staging') {
              steps {
                  sh 'docker rm -f leave-staging || true'
                  sh 'docker run -d --name leave-staging -e APP_ENV=staging -p 8085:8080 leave-service:2024sl70007'
                  sh 'sleep 3'
                  sh 'docker logs leave-staging'
              }
          }
      }
  }
