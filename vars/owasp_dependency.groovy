def call(){
    dependencyCheck additionalArguments: "--scan ./ --format ALL --out ./dependency-check-report --nvdApiKey ${NVD_API_KEY}",
                                odcInstallation: 'OWASP'
    dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}

// 2. dependencyCheck ...

// This line runs the OWASP Dependency-Check plugin in Jenkins.

// It scans your project dependencies for known security vulnerabilities (CVEs) by referencing the National Vulnerability Database (NVD).

// It takes several arguments:

// 🔸 additionalArguments: "--scan ./ --format ALL --out ./dependency-check-report --nvdApiKey ${NVD_API_KEY}"

// Let’s break that string apart:

// --scan ./
// → Scans the current directory (./) recursively for dependencies (like JARs, package manifests, etc.).

// --format ALL
// → Generates the scan report in all available formats, typically including:

// HTML

// XML

// JSON

// CSV

// --out ./dependency-check-report
// → Specifies the output directory where the report files will be saved (here, a folder named dependency-check-report inside your workspace).

// --nvdApiKey ${NVD_API_KEY}
// → Supplies the NVD API Key (stored in Jenkins as an environment variable).

// The NVD (National Vulnerability Database) now requires API keys to fetch data efficiently.

// ${NVD_API_KEY} is dynamically substituted with the value from the environment.

// So this line customizes how the dependency check runs — what to scan, how to format output, and where to store results.

// 🔸 odcInstallation: 'OWASP'

// Refers to the Dependency-Check installation name configured in Jenkins (under Manage Jenkins → Global Tool Configuration → OWASP Dependency-Check).

// 'OWASP' is the tool’s name in Jenkins configuration.

// This tells Jenkins which installed version of OWASP Dependency-Check CLI to use.

// 🧩 3. dependencyCheckPublisher pattern: '**/dependency-check-report.xml'

// This publishes the scan results to the Jenkins UI after the build.

// dependencyCheckPublisher is a post-build step provided by the OWASP Dependency-Check Jenkins plugin.

// It takes a pattern argument to locate the generated report file.

// Breakdown:

// pattern: '**/dependency-check-report.xml'

// Uses a glob pattern to search for any file named dependency-check-report.xml in any directory within the workspace.

// Jenkins reads this XML report and displays:

// Detected vulnerabilities,

// Their severity levels,

// A summary dashboard inside the build report.
