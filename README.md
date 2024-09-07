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

![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/ddddd690-5ba3-42ce-9ecd-18cd6d2bb392/d30a0713-86c5-4948-8ae0-6b50fdc92066/image.png)

## AWS EC2:

![aws.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/ddddd690-5ba3-42ce-9ecd-18cd6d2bb392/e1445a95-1663-43fa-8efb-e293d2a023f5/aws.png)

## Pipeline Stage view:

![cicd.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/ddddd690-5ba3-42ce-9ecd-18cd6d2bb392/e3c6deca-7461-4d22-8868-b3ce6e3e8950/cicd.png)

## SonarQube Analysis:

![sonarqube.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/ddddd690-5ba3-42ce-9ecd-18cd6d2bb392/fe5907f7-c931-4bc8-bd71-551b8bbe4b1d/sonarqube.png)
![sonarqube1.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/ddddd690-5ba3-42ce-9ecd-18cd6d2bb392/326b86d1-0abb-410f-8128-34f50b6acde0/sonarqube1.png)

## DockerHub:

![dh.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/ddddd690-5ba3-42ce-9ecd-18cd6d2bb392/5aaee794-fd34-4ce2-9e8f-a9fb1f5aa8b7/dh.png)

## Pipeline code is in Jenkinsfile

