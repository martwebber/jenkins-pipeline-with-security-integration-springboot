pipeline{
    agent any
    stages{
       stage('checkout'){
           steps{
           echo 'checkout'
                  checkout scmGit(branches: [[name: '*/develop']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/martwebber/jenkins-pipeline-with-security-integration-springboot.git']])
                }
           }
           stage('build'){
               steps{
               echo 'build'
                //sh 'mvn clean install'
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
