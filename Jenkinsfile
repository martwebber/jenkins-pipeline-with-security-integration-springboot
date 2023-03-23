pipeline{
    agent any
    stages{
       stage('checkout'){
           steps{
                  echo 'checkout...'
                }
           }
           stage('build'){
               steps{
                echo 'building...'
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