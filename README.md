# CI/CD using Jenkins

### Overview
This CI/CD pipeline automates the process of building, testing, security scanning, and deploying a React frontend and Node.js backend application. The pipeline runs on Jenkins with the following tools:

-   **SonarQube**: For static code analysis and code quality checks.
-   **Trivy**: For container security and vulnerability scanning.
-   **Docker**: To build and containerize the application.
-   **DockerHub**: To store the built images.
-   **AWS**: Jenkins and SonarQube instances are hosted on AWS EC2.


## Pipeline Features

1.  **Code Quality Check**: Uses SonarQube to analyze code quality.
2.  **Security Scanning**: Uses Trivy to scan Docker images for vulnerabilities.
3.  **Containerization**: Uses Docker to build the React and Node.js application.
4.  **DockerHub Push**: Automatically pushes the Docker images to DockerHub after a successful build.
5.  **Deployment**: Future plans can include deployment to AWS ECS or Kubernetes.

Before setting up the pipeline, ensure you have the following:

-   AWS EC2 instances running **Jenkins** and **SonarQube**, machine should be t2.medium or larger.
-   Docker and DockerHub account.
-   Trivy installed on Jenkins instance.
-   Node.js and React source code.
-   Jenkins plugins installed such as: Docker, NPM, SonarQube

## Pipeline Workflow

The Jenkins pipeline is defined in the `Jenkinsfile` and includes the following stages:

1.  **Checkout**: Pulls the code from the GitHub repository.
2.  **Install Dependencies**: Installs dependencies for both React and Node.js projects.
3.  **Build Application**: Builds the React frontend and Node.js backend.
4.  **Code Quality Analysis**: Runs SonarQube for static code analysis.
5.  **Docker Build**: Builds Docker images for both frontend and backend.
6.  **Trivy Security Scan**: Scans the built Docker images using Trivy.
7.  **DockerHub Push**: Pushes the built Docker images to DockerHub.
8.  **Post Actions**: Notifications or further actions can be configured here.

## Workflow Diagram:

![image](https://github.com/user-attachments/assets/fc3a3df0-f92a-4cd3-9471-bc4a9c2f5d61)

## AWS EC2:

![image](https://github.com/user-attachments/assets/16ed273e-6363-4c3f-aff2-37007d788430)

## Pipeline Stage view:

![image](https://github.com/user-attachments/assets/99dcb610-9eab-4b8c-a784-b1a441a9ada5)

## SonarQube Analysis:

![image](https://github.com/user-attachments/assets/7e309a8b-6517-409d-ac0c-fe636d886c59)
![image](https://github.com/user-attachments/assets/d4aeab45-b26b-43b1-a219-661c40283a6e)

## DockerHub:

![image](https://github.com/user-attachments/assets/cf5e6c52-91b0-41b8-aa16-626f5a5a4a06)

## Pipeline code is in Jenkinsfile

