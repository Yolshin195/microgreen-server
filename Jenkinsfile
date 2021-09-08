pipeline {
    agent any

    stages {
        stage('build') {
            environment {
                JAVA_HOME   = '/usr/java/openjdk/jdk-16.0.2/'
                db_host     = 'localhost'
                ygreens_postgres = credentials('ygreens_postgres')
                db_username = '${ygreens_postgres_USR}'
                db_password = '${ygreens_postgres_PSW}'
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