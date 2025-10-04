def call(){
  // dependencyCheck additionalArguments: '--scan ./', odcInstallation: 'OWASP'
  // dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
                sh '''
                dependency-check.sh \
                    --data /var/lib/jenkins/owasp-data \
                    --project "Chat-App" \
                    --scan . \
                    --format "ALL" \
                    --nvdApiKey ${NVD_API_KEY} \
                    --out dependency-check-report
                '''
}
