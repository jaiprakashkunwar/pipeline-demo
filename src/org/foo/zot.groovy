package org.foo
def checkOutFrom(repo) {
    echo "hello repo"
    git url: "git@github.com:jenkinsci/${repo}"
}
return this
