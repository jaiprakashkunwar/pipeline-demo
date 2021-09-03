def call(scm, files) {
    if (scm.class.simpleName == 'GitSCM') {
        def filesAsPaths = files.collect {
            [path: it]
        }

        return checkout([$class                           : 'GitSCM',
                         branches                         : scm.branches,
                         doGenerateSubmoduleConfigurations: scm.doGenerateSubmoduleConfigurations,
                         extensions                       : scm.extensions +
                                 [[$class: 'SparseCheckoutPaths', sparseCheckoutPaths: filesAsPaths]],
                         submoduleCfg                     : scm.submoduleCfg,
                         userRemoteConfigs                : scm.userRemoteConfigs
        ])
    } else {
        // fallback to checkout everything by default
        return checkout(scm)
    }
}
