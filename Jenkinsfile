pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Srienath2205/EmployeeServiceRepository.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                script {
                    docker.build('jenkinsdelta_employee_service_img', '-f Dockerfile .')
                }
            }
        }

        stage('Run Docker') {
            steps {
                bat 'docker run -d -p 5372:5372 --name employee_service jenkinsdelta_employee_service_img'
            }
        }
    }
}
