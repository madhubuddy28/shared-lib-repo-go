def call(String resourceGroup, String clusterName) {
  withCredentials([azureServicePrincipal('sp')]) {
    sh """
      echo '🔐 Authenticating to Azure and AKS...'
      az login --service-principal -u $AZURE_CLIENT_ID -p="$AZURE_CLIENT_SECRET" -t $AZURE_TENANT_ID
      az aks get-credentials --resource-group ${resourceGroup} --name ${clusterName} --overwrite-existing
    """
  }
}
