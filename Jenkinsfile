pipeline {
    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven3'
    }

    environment {
        CHROME_BIN = "/usr/bin/google-chrome"
    }

    stages {
        stage('Checkout Source Code') {
            steps {
                git branch: 'main', url: 'https://github.com/yashyawale/vizijenkins.git'
            }
        }

        stage('Install Google Chrome') {
            steps {
                sh '''
                    sudo apt-get update
                    sudo apt-get install -y google-chrome-stable || true
                '''
            }
        }

        stage('Run TestNG Tests') {
            steps {
                sh 'mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testng.xml'
            }
        }

        stage('Archive Test Results') {
            steps {
                junit 'target/surefire-reports/*.xml'
                archiveArtifacts artifacts: 'target/surefire-reports/*.xml', allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            echo 'Pipeline completed.'
        }
    }
}

