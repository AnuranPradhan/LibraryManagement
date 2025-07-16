# Library Management System <br>
A robust library management solution built with Spring Boot and Bootstrap, featuring comprehensive CRUD operations with complex many-to-many relationships between all entities.<br>
Core Entities & Relationships
Entity Structure
Book:

Title, Description, ISBN (unique)

Quantity, Available Copies

Publication Year, Cover Image

Relationships: Authors (many-to-many), Categories (many-to-many), Publisher (many-to-one)

Category:

Name

Description

Relationship: Books (many-to-many)

Publisher:

Name

Address

Contact Information

Relationship: Books (many-to-many)

Author:

Name

Biography

Nationality

Relationship: Books (many-to-many)


Comprehensive CRUD Operations
Book Management
Operation	Functionality	Interface
Add Book	Create new books with authors, categories, and publisher	Form with multi-select fields
Edit Book	Modify all book details including relationships	Pre-populated edit form
View Books	See all books with cover images and availability status	Card-based layout with filters
Delete Book	Remove books from the system	Confirmation dialog
Category Management
Operation	Functionality	Interface
Add Category	Create new book categories	Simple form
Edit Category	Update category name and description	Inline editing
Delete Category	Remove unused categories	Confirmation with relationship check
Publisher Management
Operation	Functionality	Interface
Add Publisher	Register new publishing companies	Form with contact details
Edit Publisher	Modify publisher information	Detail edit view
Delete Publisher	Remove publisher records	Validation for associated books
Author Management
Operation	Functionality	Interface
Add Author	Create new author profiles	Form with biography field
Edit Author	Update author details and publications	Author detail page
Delete Author	Remove author records	Validation for associated books
Technology Stack
Frontend
Bootstrap 5 - Responsive UI components and layout

Thymeleaf - Dynamic server-side templating

JavaScript - Interactive functionality

jQuery - AJAX operations and DOM manipulation

Font Awesome - Iconography

Backend
Spring Boot 3 - Application framework

Spring Data JPA - Database operations and ORM

Spring MVC - Web layer implementation

Hibernate - Relationship management

Spring Validation - Data integrity enforcement

Database
H2 Database - In-memory relational database

Liquibase - Database migration management
