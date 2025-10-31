def call(){
  timeout(time: 10, unit: "MINUTES"){
      waitForQualityGate abortPipeline: false
  }
}

// timeout(time: 10, unit: "MINUTES") { ... }

// This is a Jenkins pipeline step that limits how long the enclosed block can run.

// If the block inside takes longer than 10 minutes, Jenkins will automatically abort it.

// Here it’s used to ensure Jenkins doesn’t wait indefinitely for the SonarQube Quality Gate result.

// ✅ Example:

// SonarQube analysis might take some time to complete.

// If SonarQube is delayed or unresponsive, this timeout ensures your pipeline won’t hang forever.

// 🔹 3. waitForQualityGate abortPipeline: false

// This is a Jenkins SonarQube plugin step.

// It waits until the SonarQube scanner analysis (triggered in the previous stage) finishes and the Quality Gate status becomes available.

// Then it retrieves that result (e.g., Passed, Failed, In Progress).

// Parameters:

// abortPipeline: false →

// If the Quality Gate fails, the pipeline will not stop automatically.

// It will continue executing the next stages.

// This gives you flexibility to handle failures manually (e.g., send notification, mark unstable, etc.).

// 🔸 If you set:

// waitForQualityGate abortPipeline: true


The pipeline will stop immediately if the Quality Gate fails (commonly used in strict CI/CD pipelines).
