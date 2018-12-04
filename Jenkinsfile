pipeline {
    GIT_COMMIT_HASH = sh (script: "git log -n 1 --pretty=format:'%H'", returnStdout: true)
    agent {
        docker { image 'maven:3.3.3' }
        currentBuild.displayName = env.BRANCH_NAME + GIT_COMMIT_HASH
        currentBuild.description =  env.BRANCH_NAME + GIT_COMMIT_HASH
    }
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