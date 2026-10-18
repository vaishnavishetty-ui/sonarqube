pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/vaishnavishetty-ui/sonarqube.git'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {
                    def scannerHome = tool 'SonarQube-Scanner'
                    withSonarQubeEnv('SonarQube-Server') {
                        withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {
                            bat """
                                set "JAVA_HOME=C:\\Program Files\\Java\\jdk-25.0.3"
                                "%JAVA_HOME%\\bin\\java" -version
                                "${scannerHome}\\bin\\sonar-scanner.bat" -Dsonar.projectKey=sast-demo -Dsonar.projectName=sast-demo -Dsonar.sources=src/main/java -Dsonar.java.binaries=. -Dsonar.token=%SONAR_TOKEN%
                            """
                        }
                    }
                }
            }
        }
    }
}
