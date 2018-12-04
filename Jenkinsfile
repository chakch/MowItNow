pipeline {
    agent {
        docker { image 'maven:3.3.3' }
    }
    stages {
        def GIT_COMMIT_HASH = sh (script: "git log -n 1 --pretty=format:'%H'", returnStdout: true)
        currentBuild.displayName = env.BRANCH_NAME + GIT_COMMIT_HASH
        currentBuild.description =  env.BRANCH_NAME + GIT_COMMIT_HASH
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