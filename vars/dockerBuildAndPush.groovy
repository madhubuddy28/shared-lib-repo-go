def call(Map config) {
  def imageTag = "${config.acrName}.azurecr.io/${config.imageName}:${config.tag}"

  sh """
    echo '🐳 Building Docker image: ${imageTag}'
    docker build -t ${imageTag} .

    echo '📤 Pushing Docker image to ACR...'
    docker push ${imageTag}
  """
}
