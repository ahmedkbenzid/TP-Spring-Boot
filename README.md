# TP-Spring-Boot - DevOps Learning Project

This project is designed for learning and practicing DevOps concepts, tools, and methodologies.  It uses a Spring Boot application as a demo project to implement various DevOps practices including CI/CD, containerization, orchestration, and automation. 

## Purpose

The main goal of this project is to gain hands-on experience with: 
- Continuous Integration/Continuous Deployment (CI/CD) pipelines
- Containerization with Docker
- Container orchestration with Kubernetes
- Configuration management with Ansible
- Infrastructure automation
- Jenkins pipeline configuration
- Code quality analysis with SonarQube
- Automated testing and deployment
- Monitoring and logging best practices

## Technologies & Tools

- **Application**: Spring Boot (Java)
- **Build Tool**: Maven
- **Containerization**: Docker, Docker Compose
- **Orchestration**:  Kubernetes
- **CI/CD**: Jenkins
- **Code Quality**: SonarQube
- **Configuration Management**: Ansible
- **Version Control**: Git

## Project Structure
```text
TP-Spring-Boot/ ├── src/ # Spring Boot application source code 
                ├── Dockerfile # Docker image configuration 
                ├── docker-compose. yml # Multi-container Docker configuration 
                ├── my-deployment.yaml # Kubernetes deployment manifest 
                ├── service.yaml # Kubernetes service manifest 
                ├── playbookCICD.yaml # Ansible playbook for CI/CD automation 
                ├── jenkins # Jenkins pipeline configuration 
                ├── config # Application configuration files 
                ├── pom.xml # Maven project configuration
                ├── .gitignore # Git ignore rules 
                └── .gitattributes # Git attributes configuration

````
## Getting Started

### Prerequisites

- Java JDK 17 or higher
- Maven (M2_HOME configured)
- Docker and Docker Compose
- Kubernetes cluster (Minikube, Docker Desktop, or cloud provider)
- Jenkins (for CI/CD pipeline)
- SonarQube Server (for code quality analysis)
- Ansible (for automation)
- Git

### Installation

1. Clone the repository:
git clone https://github.com/ahmedkbenzid/TP-Spring-Boot.git
cd TP-Spring-Boot

2. Build the application using Maven:
mvn clean install


## DevOps Practices

### Docker

Build and run the application using Docker:  
docker build -t tp-spring-boot . 
docker run -p 8080:8080 tp-spring-boot

### Kubernetes

Deploy to Kubernetes cluster:
kubectl apply -f my-deployment. yaml 
kubectl apply -f service. yaml


### CI/CD Pipeline with Jenkins

The project includes a comprehensive Jenkins pipeline with the following stages:

1. **Checkout Code**: Pulls the latest code from the master branch
2. **Build Maven**:  Compiles the application and runs tests
   - Generates JUnit test reports
   - Executes `mvn clean install`
3. **SonarQube Analysis**:  Performs code quality and security analysis
   - Project Key: country-service
   - SonarQube Server: http://localhost:9000
4. **Deploy using Ansible**: Automates deployment using Ansible playbook
   - Executes `playbookCICD.yaml` for automated deployment

#### Pipeline Configuration

- **Agent**:  Runs on any available Jenkins agent
- **Tools**: Maven (M2_HOME)
- **Post Actions**: 
  - Workspace cleanup after each build
  - Success/failure notifications

#### Prerequisites for Jenkins Pipeline

- Jenkins server with Maven configured (M2_HOME)
- SonarQube server installation (MySonarQubeServer)
- SonarQube credentials configured in Jenkins
- Ansible installed on Jenkins agent
- Hosts file configured for Ansible

### SonarQube Code Quality Analysis

The project integrates SonarQube for continuous code quality inspection:
mvn sonar:sonar -Dsonar.projectKey=country-service -Dsonar. projectName='country-service' -Dsonar.host.url=http://localhost:9000

Access SonarQube dashboard at:  http://localhost:9000

### Ansible Automation

Run the Ansible playbook for CI/CD automation:
ansible-playbook -i hosts playbookCICD.yaml


## Learning Objectives

- Understanding containerization and microservices architecture
- Implementing automated CI/CD pipelines with Jenkins
- Managing container orchestration with Kubernetes
- Automating infrastructure and deployment with Ansible
- Performing code quality analysis with SonarQube
- Implementing automated testing strategies
- Monitoring and maintaining production-ready applications
- Version control and collaboration best practices
- Understanding DevOps workflow from code commit to production

## CI/CD Workflow

1. Developer pushes code to GitHub repository
2. Jenkins detects changes and triggers pipeline
3. Code is checked out from master branch
4. Maven builds the application and runs unit tests
5. SonarQube analyzes code quality and security vulnerabilities
6. Ansible playbook deploys the application
7. Test results and quality reports are generated
8. Notifications sent on success/failure

## Contributing

This is a learning project. Feel free to fork, experiment, and suggest improvements!  

## Contact

Ahmed K Benzid - @ahmedkbenzid
Project Link: https://github.com/ahmedkbenzid/TP-Spring-Boot
