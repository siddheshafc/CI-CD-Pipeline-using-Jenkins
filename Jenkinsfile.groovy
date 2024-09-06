pipeline{
    agent any

    tools{
        nodejs 'nodejs'
    }

    environment {
        SCANNER_HOME=tool 'sonar-scanner'
    }

    stages {
        
        stage('Checkout from Git'){
            steps{
                git branch: 'main', url: 'https://github.com/siddheshafc/CI-CD-Pipeline-using-Jenkins.git'
            }
        }

        stage("Sonarqube Analysis"){
            steps{
                withSonarQubeEnv('sonar-server') {
                    sh '''$SCANNER_HOME/bin/sonar-scanner -Dsonar.projectName=cicdjenkins \
                    -Dsonar.projectKey=cicdjenkins -Dsonar.exclusions=node_modules/**,**/node_modules/**'''
                }
            }
        }     
        
        stage('Install NPM Dependencies') {
            steps {
                sh "npm install"
            }
        }
    
        stage('Trivy FS Scan') {
            steps {
                sh "trivy fs . > trivyfs.txt"
            }
        }

        stage("Docker Build & Push to DockerHub") {
            steps {
                script {
                    def imageTag = "ci-cd-using-jenkins:${env.BUILD_NUMBER}" // Tag with build number for traceability
                    def latestTag = "ci-cd-using-jenkins:latest"
                    def dockerImage = "siddheshdhuri02/${imageTag}"

                    withDockerRegistry(credentialsId: 'dockerhub-cred', toolName: 'docker') {   
                        try {
                          
                            sh "docker build -t ${dockerImage} -t siddheshdhuri02/${latestTag} ."

                    
                            sh "docker push ${dockerImage}"
                            sh "docker push siddheshdhuri02/${latestTag}"

                        } catch (Exception err) {
                            error "Docker build and push failed: ${err}"
                        }
                    }
                }  
            }
        }
        

        stage("Trivy Image Scan"){
            steps{
                sh "trivy image siddheshdhuri02/ci-cd-using-jenkins:latest > trivy.txt" 
            }
        }

        stage('Deploy to container'){
            steps{
                sh 'docker run -d --name ci-cd-using-jenkins -p 3000:3000 siddheshdhuri02/ci-cd-using-jenkins:latest'
            }
        }
    }
}
