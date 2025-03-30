# SMTP Java Spring Boot Project

This project demonstrates how to send emails using Java and Spring Boot with the Gmail SMTP server.

## Prerequisites

- Java 11 or higher
- Maven
- A Gmail account

## Getting Started

1. **Clone the repository:**
    ```sh
    git clone https://github.com/your-username/smtp-java.git
    cd smtp-java
    ```

2. **Configure the application:**
    Update the `src/main/resources/application.properties` file with your Gmail account credentials:
    ```ini
    spring.mail.username=your-email@gmail.com
    spring.mail.password=your-password
    ```

3. **Build the project:**
    ```sh
    mvn clean install
    ```

4. **Run the application:**
    ```sh
    mvn spring-boot:run
    ```

## Usage

Send a POST request to `http://localhost:8080/email/send` with the following parameters:
- `to`: Recipient's email address
- `subject`: Email subject
- `body`: Email body

Example using `curl`:
```sh
curl -X POST http://localhost:8080/email/send \
    -d "to=recipient@example.com" \
    -d "subject=Test Email" \
    -d "body=This is a test email."
```

## Tutorial
For more details, check out the full tutorial at https://amoelcodigo.com/posts/smtp-java-springboot/