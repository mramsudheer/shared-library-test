def call(Map configMap){
    pipeline{
        agent{
            node{
                label 'roboshop'
            }
        }
        stages{
            stage('Testing'){
                script{
                    sh """
                        echo "Project:${configMap.project}"
                    """
                }
            }
        }
        post{
            always{
                echo "I'll execute always"
                //Clean Workspace, Saves Disk Space, 

                //It ensures that the next time the job runs, 
                // it starts with a completely empty folder. 
                // This prevents old files from a previous run 
                // (like old compiled classes or cached config files) from interfering with the new build.

                //If your build handles sensitive data, certificates, or temporary credentials, 
                // cleanWs() ensures those files aren't left sitting on the build agent after 
                // the job is done.

                cleanWs() 
            }
        }
    }
}