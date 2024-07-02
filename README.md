#Shawhere
# Share Any Where( Personal Sharing Medium)

## Overview

The Personal Sharing Medium is a platform designed for sharing data temporarily among friends. 
Users can upload and download various types of objects within specified limits, 
facilitating easy and temporary data exchange.

## Features

- **Upload Files**: Users can upload files to share with their friends.
- **Download Files**: Friends can download shared files within a specified time limit.
- **Temporary Sharing**: Data shared is available temporarily, ensuring privacy and security.
- **Object Listing**: Ability to list all uploaded objects for easy access.

## Usage

### Prerequisites

- Java 8 or higher installed on your system.
- AWS S3 credentials (Access Key ID and Secret Access Key) for storage.

### Setup

1. **Clone the Repository**

   ```bash
   git clone https://github.com/your/repository.git
   cd repository
   ```

2. **Configure AWS Credentials**

   Set your AWS credentials using environment variables:

   ```bash
   export AWS_ACCESS_KEY_ID=your_access_key_id
   export AWS_SECRET_ACCESS_KEY=your_secret_access_key
   ```

3. **Build and Run the Application**

   ```bash
   ./gradlew build
   java -jar build/libs/personal-sharing-medium.jar
   ```

   Replace `personal-sharing-medium.jar` with the actual name of your generated JAR file.

### Usage Examples

1. **Upload a File**

   ```bash
   curl -F "file=@/path/to/your/file.txt" http://localhost:8080/upload?user=username
   ```

   Replace `http://localhost:8080` with your application's endpoint.

2. **List Uploaded Objects**

   ```bash
   curl http://localhost:8080/list?user=username
   ```

3. **Download a File**

   ```bash
   curl -o downloaded_file.txt http://localhost:8080/download?key=file_key&user=username
   ```

   Replace `file_key` with the key of the file you want to download.

### Limits

- Each user is allowed to upload and share up to 1GB of data.
- Shared data is available for download for up to 24 hours.

## Contributors

- Your Name <shubhamchikhalkar25@gmail.com>

## Acknowledgments

- Thanks to AWS SDK and Spring Boot for making development easier.
- Inspired by the need for easy and secure temporary data sharing among friends.

---

Feel free to customize this README based on your specific application features,
technology stack, and any additional details you find relevant. 
This template provides a structured approach to introducing your application and guiding users 
on how to set up and utilize it effectively.