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
<<<<<<< HEAD
                   stage('SonarQube analysis') {
                       steps {
                        echo 'sonarqube...'
                       }
                   }
    }
}
=======
//                    stage('SonarQube analysis') {
//                        steps {
//                            script {
//                                try {
//                                    def scannerHome = tool 'sonar-scanner';
//                                    withSonarQubeEnv('SonarQube') {
//                                        sh "${tool("sonar-scanner")}/bin/sonar-scanner"
//                                    }
//                                } catch (Error|Exception e){
//                                    echo "failed but we continue"
//                                }
//                            }
//                        }
//                    }
        
         stage("build & SonarQube analysis") {
            steps {
              withSonarQubeEnv('My SonarQube Server') {
                sh 'mvn clean package sonar:sonar'
              }
            }
          }
          stage("Quality Gate") {
            steps {
              timeout(time: 1, unit: 'HOURS') {
                waitForQualityGate abortPipeline: true
              }
            }
          }
        
   }
}
>>>>>>> 2e82e2093cb1f55679d2e24f9ce732a8fa8bec77
