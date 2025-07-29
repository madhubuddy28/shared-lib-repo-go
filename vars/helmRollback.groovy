def call(String releaseName, String namespace) {
  sh """
    echo '↩️ Rolling back Helm release: ${releaseName} in ${namespace}...'
    helm rollback ${releaseName} --namespace ${namespace}
  """
}
