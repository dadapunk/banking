## Banking app

- The full documentation is in JavaDocs and published in GithubPages https://sebastian-velasquez.dev/banking/
- The PostMan Collection is here [Banking.postman_collection.json](Banking.postman_collection.json)
- Class Diagram ![class_diagram.png](diagrams%2Fclass_diagram.png)
- Use Cases Diagram ![use_case_diagram.png](diagrams%2Fuse_case_diagram.png)

# Bank API

## Description

This project is a RESTful API for a banking system built using Spring Boot.

## Features

- Create, update, and delete account holders
- Create, update, and delete accounts
- Perform transactions between accounts
- Retrieve account and transaction history

## Technologies Used

- Java
- Spring Boot
- Hibernate
- MySQL
- JUnit

## Setup

1. Clone this repository
2. Install MySQL and create a new database named `banking`
3. Run the SQL scripts in the `src/main/resources/sql` folder to create the necessary tables
4. Update the `application.properties` file with your MySQL username and password
5. Run the application using your IDE or with the command `mvn spring-boot:run`


## Contributing

Contributions are welcome! Please submit a pull request with your changes.

## License

This project is licensed under the GNU v3 License. See the `LICENSE` file for more information.
