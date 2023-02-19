pipeline{
    agent any
    stages{
       stage('checkout'){
           steps{
                script{
                   scmVars = checkout(scm)
                   env.BRANCH_NAME =  scmVars.GIT_BRANCH
                   env.SHORT_COMMIT = "${scmVars.GIT_COMMIT[0..7]}"
                   REPO_NAME = scmVars.GIT_URL.replaceFirst(/^.*\/([^\/]+?).git$/, '$1')
                   DATE = sh(returnStdout: true, script: "date -u +'%Y%m%d'").trim()

                   if (BRANCH_NAME=="main") {
                           env.artifact_name = "dxl_master"
                       }
                   if (BRANCH_NAME=="develop") {
                           env.artifact_name = "dxl_develop"
                       }
                   stash "stash-${env.SHORT_COMMIT}"
                   }
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
