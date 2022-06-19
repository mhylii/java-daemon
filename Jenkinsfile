pipeline {
  agent any
  stages {
    stage('删除旧的jar') {
      steps {
        sh 'rm -rf /light_cvm/springboot-helloword-0.0.1-SNAPSHOT.jar'
      }
    }

    stage('拉取代码') {
      steps {
        git(url: 'https://github.com/Zhaoxixiangchu/springboot-helloword.git', branch: 'master', changelog: true)
      }
    }

    stage('编译构建') {
      steps {
        sh 'mvn clean & mvn package'
      }
    }

    stage('移动jar') {
      steps {
        sh 'cp /root/.jenkins/workspace/hello/springboot-helloword/target/springboot-helloword-0.0.1-SNAPSHOT.jar /light_cvm/'
      }
    }

    stage('运行') {
      steps {
        sh 'nohup java -jar springboot-helloword-0.0.1-SNAPSHOT.jar > out.log &'
        qyWechatNotification(webhookUrl: 'https://qyapi.weixin.qq.com/cgi-bin/webhook/send?key=a302192a-55dd-48bd-be57-a551f7b776c9')
      }
    }

  }
}