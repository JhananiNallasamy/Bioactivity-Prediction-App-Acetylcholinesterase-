import subprocess
import sys
import os

# Download Miniconda installer
miniconda_installer_url = "https://repo.anaconda.com/miniconda/Miniconda3-latest-Windows-x86_64.exe"
miniconda_installer_file = "Miniconda3-latest-Windows-x86_64.exe"

subprocess.run(["curl", "-O", miniconda_installer_url], check=True)

# Install Miniconda
subprocess.run([miniconda_installer_file, "/InstallationType=JustMe", "/RegisterPython=0", "/S", "/D=C:\\Miniconda3"], check=True)

# Update PATH environment variable
os.environ['PATH'] = f"C:\\Miniconda3;{os.environ['PATH']}"

# Install RDKit
subprocess.run(["conda", "install", "-c", "rdkit", "rdkit", "-y"], check=True)

# Add Miniconda Python to sys.path
sys.path.append("C:\\Miniconda3\\lib\\site-packages")
