def call(){
    dependencyCheck additionalArguments: "--scan ./ --format ALL --nvdApiKey ${NVD_API_KEY}",
                                odcInstallation: 'OWASP',
                                outdir: 'dependency-check-report'
    dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}
