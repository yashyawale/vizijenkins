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
                // Run tests and generate HTML report
                sh 'mvn clean test site -Dsurefire.suiteXmlFiles=src/test/resources/testng.xml'
            }
        }

        stage('Archive Test Results') {
            steps {
                // Publish JUnit XML results
                junit 'target/surefire-reports/*.xml'

                // Archive both XML and HTML reports
                archiveArtifacts artifacts: 'target/surefire-reports/*.xml', allowEmptyArchive: true
                archiveArtifacts artifacts: 'target/site/surefire-report.html', allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            echo 'Pipeline completed.'
        }
    }
}
