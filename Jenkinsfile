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
                        bat """
                            set "JAVA_HOME=C:\\Program Files\\Java\\jdk-25.0.3"
                            "%JAVA_HOME%\\bin\\java" -version
                            
                            rem Fallback token check
                            if defined SONAR_TOKEN (
                                set "TOKEN_FLAG=-Dsonar.token=%SONAR_TOKEN%"
                            ) else if defined SONAR_AUTH_TOKEN (
                                set "TOKEN_FLAG=-Dsonar.token=%SONAR_AUTH_TOKEN%"
                            ) else (
                                set "TOKEN_FLAG=-Dsonar.login=admin -Dsonar.password=admin"
                            )

                            "${scannerHome}\\bin\\sonar-scanner.bat" -Dsonar.projectKey=sast-demo -Dsonar.projectName=sast-demo -Dsonar.sources=src/main/java -Dsonar.java.binaries=. %TOKEN_FLAG%
                        """
                    }
                }
            }
        }
    }
}
