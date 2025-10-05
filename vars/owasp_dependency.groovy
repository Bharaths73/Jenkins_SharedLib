def call(){
    dependencyCheck additionalArguments: "--scan ./ --format ALL --out ./dependency-check-report --nvdApiKey ${NVD_API_KEY}",
                                odcInstallation: 'OWASP'
    dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}
