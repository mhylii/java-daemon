pipeline {
  agent any
  stages {
    stage('delete jar') {
      steps {
        sh 'rm -rf /light_cvm/springboot-helloword-0.0.1-SNAPSHOT.jar'
      }
    }

    stage('get code from github') {
      steps {
        git(url: 'https://gitee.com/Zhaoxixaingchu/springboot-helloword.git', branch: 'master', changelog: true)
      }
    }

    stage('build jar') {
      steps {
        sh 'mvn clean & mvn package'
      }
    }

    stage('copy jar') {
      steps {
        sh 'cp /root/.jenkins/workspace/hello_master/target/springboot-helloword-0.0.1-SNAPSHOT.jar /light_cvm/'
      }
    }

    stage('run jar') {
      steps {
        sh 'sh /light_cvm/start.sh'
      }
    }

  }
}