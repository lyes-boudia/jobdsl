job('node-express') {
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
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        shell("npm install")
    }
}
