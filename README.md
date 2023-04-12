# Book Management Application
This is a CRUD (Create, Read, Update, Delete) application for managing books. The application allows users to create, read, update, and delete books, as well as search for books by various criteria. The application also allows for the management of authors.
## Technologies Used
This application was built using the following technologies:
* Java EE technologies such as Servlets, JSP, and JPA.
* Hibernate.
* MySQL database.
* HTML, CSS.

### Database Setup
* Create a MySQL database with the name gestion_livres. 
* Run the schema.sql file provided in the project to create the necessary tables.

### Running the Application
* Import the project into your IDE (intellij or other). 
* Run the application on a local server such as Apache Tomcat.
* Access the application in a web browser at http://localhost:<port>/<context-root>.

## Authentication

Before accessing the application, the user must be authenticated. The user is required to enter a login (valid email) and password. User login and passwords are stored in the user table in the database. The role field in the user table is used to manage access to certain resources in the application. There are two roles: Admin and Visitor. The Admin role allows full access to the application, while the Visitor role only allows access to the list of books.

## Features
### Visitor Role

A user with the Visitor role can only view the list of books. The user can search the list of books using various criteria such as author, publication date, or title.
### Admin Role
A user with the Admin role can create, update, or delete books, as well as authors.