pipeline {
    agent { docker { image 'maven:3.3.3' } }
    stages {
        stage('clean') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('install') {
            steps {
                sh 'mvn install'
            }
        }
    }
}