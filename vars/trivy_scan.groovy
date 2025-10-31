def call(){
  sh "trivy fs ."
}

// sh "trivy fs ."

// sh — Jenkins pipeline step used to execute a shell command on the build agent (Linux/Unix environment).

// Everything inside the quotes is passed directly to the shell.

// Let’s break down the command itself:

// 🔹 trivy

// Trivy is an open-source vulnerability scanner developed by Aqua Security.

// It scans for:

// OS package vulnerabilities (like Ubuntu, Alpine, Debian packages)

// Application dependencies (Java, Node.js, Python, etc.)

// Secrets, configuration issues, and misconfigurations.

// 🔹 fs

// fs stands for File System.

// It tells Trivy to scan the file system of the specified directory for known vulnerabilities.

// It detects application dependencies (e.g., package.json, pom.xml, requirements.txt, etc.)

// It also checks system binaries, Dockerfiles, and configuration files.

// 🔹 .

// . (dot) means current directory.

// So, Trivy will recursively scan the entire current workspace (where Jenkins checked out your source code).

// ✅ Full meaning:

// “Run a Trivy file system scan on the current directory to find vulnerabilities.”
