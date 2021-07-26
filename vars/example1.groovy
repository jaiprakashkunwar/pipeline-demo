def call(String name = "Alice") {
    echo "Insise call of example"
    script {
        sh """
            echo Hi ${name}
        """
    }
}
