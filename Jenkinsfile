pipeline{
    agent any
    stages{
       stage('checkout'){
           steps{
           echo 'checkout'
                  checkout scmGit(branches: [[name: '*/develop']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/martwebber/jenkins-pipeline-with-security-integration-springboot.git']])
                }
           }
           	stage('SonarQube analysis') {
                       steps {
           		// Change this as per your Jenkins Configuration
                           withSonarQubeEnv('sonarqube') {
                               sh 'mvn package sonar:sonar'
                           }
                       }
                   }

           	stage("Quality gate") {
                       steps {
                           waitForQualityGate abortPipeline: true
                       }
                   }

               }
    }
}
