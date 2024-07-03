This assignment focuses on developing a Spring Boot application designed to handle both RESTful and SOAP-based APIs. The application utilizes the MVC (Model-View-Controller) architectural pattern. Key components include controllers for API endpoints, services for business logic, repositories for data access, and models to represent data structures.

Components
Model Layer: Contains entities and data structures representing the application's domain model. View Layer: Handles DTOs (Data Transfer Objects) that shape data for presentation.

Controller Layer: Handles incoming HTTP requests, Processes requests by interacting with services and manages the flow of data, Responsible for returning appropriate HTTP responses.

Service Layer: Implements business logic and use cases of the application, Acts as an intermediary between controllers and repositories.

Repository Layer: Manages data persistence and retrieval.

Exception Handling: Ensures consistent error responses throughout the application. Utility Classes: Provides helper functions and shared functionalities across the application.

Endpoints
Summary of REST endpoints provided by the application:

    1. /api/iso: Fetch ISO code for a country name from SOAP API.
    2. /api/country: Fetch full country information by ISO Code from SOAP API.
    3. /api/country/create: Store Country object.
    4. /api/countries: Fetch all stored countries.
    5. /api/country/fetch/{id}: Fetch country information by ID.
    6. /api/country/update/{id}: Update country information.
    7. /api/country/delete/{id}: Delete country information.

Pre requisites

    Database Setup:
    1. Ensure MySQL server is installed and running.
    2. Create a database named case_study.
    3.  Configure the database connection in application.properties file.
    
    Application Build and Deployment:
    1. Java JDK installed
    2. Maven or Gradle for dependency management.
    3.  IDE (IntelliJ IDEA, Eclipse) for development.

Steps for Running and Testing the Application

    1. Clone the repository from GitHub:
        git clone https://github.com/njorogegwanjiru/TakeAwayCaseStudy.git
    3. Navigate to the project directory:
        cd case-study
    4. Build the application using Maven:
        mvn clean install
    5. Start the application using Maven:
        mvn spring-boot:run. Application will start at http://localhost:8080.
    6. Test the application using Maven:
        mvn test
