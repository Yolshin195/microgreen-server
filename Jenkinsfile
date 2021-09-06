pipeline {
    agent any

    stages {
        stage('build') {
            steps {
                sh './mvnw package'
            }
        }

        stage('deploy') {
            steps {
                echo 'Deploy!'
                sh 'sudo /var/CICD/ygreens-server-deploy.sh'
            }
        }
    }
}