def call(String acrName) {
  withCredentials([azureServicePrincipal('sp')]) {
    sh """
      echo '🔐 Logging in to Azure...'
      az login --service-principal -u $AZURE_CLIENT_ID -p="$AZURE_CLIENT_SECRET" -t $AZURE_TENANT_ID
      az acr login --name ${acrName}
    """
  }
}
