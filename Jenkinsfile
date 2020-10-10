pipeline {

  agent any

  stages {

    stage('Checkout Source') {
      steps {
        git url:'https://github.com/JMagnoJunior/kubetest.git', branch:'main'
      }
    }

    stage('Gradle Build') {
        steps {
            script{
                sh './gradlew clean build'
            }
        }
    }

      stage("Build image") {
            steps {
                script {
                    myapp = docker.build("jmagnojunior/kubetest:${env.BUILD_ID}")
                }
            }
        }

      stage("Push image") {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', '279557e8-e6b3-4c5b-a89e-c6fb00f11e86') {
                            myapp.push("latest")
                            myapp.push("${env.BUILD_ID}")
                    }
                }
            }
        }

  }

}