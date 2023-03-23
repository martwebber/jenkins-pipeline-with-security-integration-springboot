pipeline{
    agent any
    stages{
       stage('checkout'){
           steps{
                  checkout scmGit(branches: [[name: '*/develop']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/martwebber/jenkins-pipeline-with-security-integration-springboot.git']])
                }
           }
           stage('build'){
               steps{
                sh 'mvn clean install'
               }
           }
           stage('test'){
               steps{
               echo 'Testing....'
               }
           }
            //SonarQube analysis
                   stage('SonarQube analysis') {
                       steps {
                        echo 'sonarqube...'
                       }
                   }
    }
}
