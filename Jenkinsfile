pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/YOUR_GITHUB_USERNAME/sast-demo.git'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {
                    def scannerHome = tool 'SonarQube-Scanner'
                    withSonarQubeEnv('SonarQube-Server') {
                        sh "${scannerHome}/bin/sonar-scanner \
                            -Dsonar.projectKey=sast-demo \
                            -Dsonar.projectName=sast-demo \
                            -Dsonar.sources=src/main/java \
                            -Dsonar.java.binaries=."
                    }
                }
            }
        }
    }
}
