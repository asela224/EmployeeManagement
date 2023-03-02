

node {
    def WORKSPACE = "/projects/EmployeeManagement-deploy"
    def dockerImageTag = "EmployeeManagement-deploy${env.BUILD_NUMBER}"

    try{
         stage('Clone Repo') {

            git url: 'https://gitlab.com/gpranataAsyst/springboot-demodeploy.git',
                credentialsId: 'githubCredentials01',
                branch: 'main'
         }
          stage('Build docker') {
                 dockerImage = docker.build("EmployeeManagement-deploy:${env.BUILD_NUMBER}")
          }

          stage('Deploy docker'){
                  echo "Docker Image Tag Name: ${dockerImageTag}"
                  sh "docker stop EmployeeManagement-deploy || true && docker rm EmployeeManagement-deploy || true"
                  sh "docker run --name EmployeeManagement-deploy -d -p 8081:8081 EmployeeManagement-deploy:${env.BUILD_NUMBER}"
          }
    }catch(e){
//         currentBuild.result = "FAILED"
        throw e
    }finally{
//         notifyBuild(currentBuild.result)
    }
}

def notifyBuild(String buildStatus = 'STARTED'){

// build status of null means successful
  buildStatus =  buildStatus ?: 'SUCCESSFUL'
  // Default values
  def colorName = 'RED'
  def colorCode = '#FF0000'
  def now = new Date()
  // message
  def subject = "${buildStatus}, Job: ${env.JOB_NAME} FRONTEND - Deployment Sequence: [${env.BUILD_NUMBER}] "
  def summary = "${subject} - Check On: (${env.BUILD_URL}) - Time: ${now}"
  def subject_email = "Employee Management Deployment"
  def details = """<p>${buildStatus} JOB </p>
    <p>Job: ${env.JOB_NAME} - Deployment Sequence: [${env.BUILD_NUMBER}] - Time: ${now}</p>
    <p>Check console output at "<a href="${env.BUILD_URL}">${env.JOB_NAME}</a>"</p>"""


  // Email notification
    emailext (
         to: "asela224@gmail.com",
         subject: subject_email,
         body: details,
         recipientProviders: [[$class: 'DevelopersRecipientProvider']]
       )
}









