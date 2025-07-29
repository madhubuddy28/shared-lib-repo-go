def call(Map config = [:]) {
    def release = config.helmRelease
    def chart = config.chartPath
    def namespace = config.namespace
    def acrLoginServer = config.acrLoginServer
    def imageName = config.imageName
    def imageTag = config.imageTag

    sh """
        echo "Deploying ${release} to ${namespace}..."
        helm upgrade --install ${release} ${chart} \
          --namespace ${namespace} --create-namespace \
          --set image.repository=${acrLoginServer}/${imageName} \
          --set image.tag=${imageTag}
    """
}
