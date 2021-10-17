
job('NodeJS Docker example') {
    scm {
        git('https://github.com/lyes-boudia/deploy.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('Lyes Boudia')
            node / gitConfigEmail('lyes.boudia@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('lyes/docker-nodejs-demo')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
