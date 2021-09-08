pipeline {
    agent any

    stages {
        stage('build') {
            environment {
                JAVA_HOME   = '/usr/java/openjdk/jdk-16.0.2/'
                db_host     = 'localhost'
                db_username = credentials('ygreens_postgres_USR')
                db_password = credentials('ygreens_postgres_PSW')
            }
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