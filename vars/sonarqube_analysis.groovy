def call(String SonarQubeAPI, String Projectname, String ProjectKey){
  withSonarQubeEnv("${SonarQubeAPI}"){
      sh "$SONAR_HOME/bin/sonar-scanner -Dsonar.projectName=${Projectname} -Dsonar.projectKey=${ProjectKey} -X"
  }
}

// Parameters:

// SonarQubeAPI: the name of the SonarQube server configuration stored in Jenkins (under Manage Jenkins → Configure System → SonarQube Servers).

// Projectname: the display name of the project in the SonarQube dashboard.

// ProjectKey: the unique key/identifier for the project (used to differentiate projects within SonarQube).

// So this function encapsulates the logic to trigger a SonarQube scan dynamically for any project.

// 🧩 2. withSonarQubeEnv("${SonarQubeAPI}") { ... }

// withSonarQubeEnv is a Jenkins Pipeline DSL function provided by the SonarQube Scanner for Jenkins plugin.

// It:

// Sets up the SonarQube environment variables (like authentication tokens and URLs).

// Configures SONAR_HOST_URL and credentials automatically for the specified SonarQube server (the one named ${SonarQubeAPI}).

// Everything inside the { ... } block runs within that SonarQube environment.

//   sh "$SONAR_HOME/bin/sonar-scanner -Dsonar.projectName=${Projectname} -Dsonar.projectKey=${ProjectKey} -X"

// sh → Executes a shell command inside the Jenkins build agent.
// It’s equivalent to running the command in a terminal.

// Let’s break down the command inside the quotes:

// 🔹 $SONAR_HOME/bin/sonar-scanner

// Executes the SonarQube Scanner CLI installed on the Jenkins node.

// $SONAR_HOME → Environment variable automatically set by Jenkins (the installation path of the Sonar Scanner tool configured under Manage Jenkins → Global Tool Configuration).

// 🔹 -Dsonar.projectName=${Projectname}

// Sets the SonarQube project name to display in the dashboard.

// 🔹 -Dsonar.projectKey=${ProjectKey}

// Sets the SonarQube project key — a unique identifier used to track project scans across builds.

// 🔹 -X

// Enables debug mode for detailed logs (useful for troubleshooting pipeline issues).
