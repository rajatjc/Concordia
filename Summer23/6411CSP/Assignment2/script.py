import os
import sys
from github import Github

# Check if the input file exists
if os.path.isfile("script.txt"):
    # Read the stored inputs from the file
    with open("script.txt", "r") as file:
        inputs = file.readlines()

    # Assign the stored inputs to variables
    REPO_NAME = inputs[0].strip()
    LOCAL_REPO_PATH = os.getcwd()  # Set the current directory as the LOCAL_REPO_PATH
    BRANCH_NAME = inputs[1].strip()
else:
    # Prompt the user for inputs and store them in the file
    REPO_NAME = input("Enter the repository name: ")
    LOCAL_REPO_PATH = os.getcwd()  # Set the current directory as the LOCAL_REPO_PATH
    BRANCH_NAME = input("Enter the branch name: ")

    with open("script.txt", "w") as file:
        file.write(f"{REPO_NAME}\n{BRANCH_NAME}")

# Check if ".gitignore" file exists and if the entries are already present
if os.path.isfile(".gitignore"):
    with open(".gitignore", "r") as file:
        gitignore_entries = file.read()

    if "script.txt" not in gitignore_entries:
        with open(".gitignore", "a") as file:
            file.write("\nscript.txt")
    
    if "script.py" not in gitignore_entries:
        with open(".gitignore", "a") as file:
            file.write("\nscript.py")
else:
    # Create or append to the .gitignore file
    with open(".gitignore", "w") as file:
        file.write("script.txt\nscript.py")

# Rest of the script
# Replace with your GitHub username and personal access token
USERNAME = "rajatjc"
TOKEN = "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"

# Check if the commit message is provided as a command-line argument
if len(sys.argv) > 1:
    commit_message = sys.argv[1]
else:
    print("Please provide a commit message as a command-line argument.")
    sys.exit(1)

# Change the current working directory to the local repository path
os.chdir(LOCAL_REPO_PATH)

# Add all files to the staging area
os.system("git add -A")

# Commit the changes with the provided commit message
os.system(f"git commit -m '{commit_message}'")

# Create a GitHub instance using your credentials
g = Github(USERNAME, TOKEN)

# Get the repository
repo = g.get_user().get_repo(REPO_NAME)

# Push the changes to the remote repository on the specified branch
os.system(f"git push origin {BRANCH_NAME}")

