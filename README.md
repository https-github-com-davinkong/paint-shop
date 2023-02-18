
![Logo](https://i.ibb.co/tK0LDHh/Screen-Shot-2023-02-18-at-4-12-07-PM.png)




Welcome to PaintersPro, a Java and Spring Boot web application. PaintersPro helps shop owners track and manage their projects. Shop owners can see all upcoming scheduled jobs along with client and product information. Additionally, contractors are able to view their upcoming jobs. 

## Technologies Used

- Backend: Java, Spring Boot, PostgreSQL, Hibernate;
- Frontend: JavaScript, HTML, CSS, Bootstrap, Thymeleaf



## Features

 - 📹 Full video walk-through: Coming Soon
### Login and Register
- Contractors can add themselves to the database. We use BCryptPasswordEncoder to encode the user’s password to the hash string for better security. 
-  We also set the role if users are contractors or shopOwner, by using boolean isAdmin true or false.

![Register](https://i.ibb.co/c2nwfmT/register.png)
### Clients 
- On the clients page, a user can add clients to the database.
- All clients are listed in the table below.
- The user can remove a client from the database with the delete button.

![Clients](https://i.ibb.co/gmC7bWp/clients.png)

### Products
- For the products page the user can add products to the database. 
- Under the form is a table that shows all the products that have been assigned to the job.
![Products](https://i.ibb.co/sRL14pS/products.png)
### Jobs   
- The jobs page provides a form that allows contractors and shop owners to add a new job to the system.
- The job object is then saved, and the corresponding Contractors object is marked as having a job assigned.  
![Jobs](https://i.ibb.co/sC4KDy3/jobs.png)

### Shop Owner Home
- On the shop owner page, we implemented a getJobsByContractorId to retrieve any active jobs for each contractor as well as product, and client.
![shopowner](https://i.ibb.co/cXGzbpY/shop-owner.png)

- On the view all Contractors page, contractor’s information uses findAll method from JpaRepository. 
- ![viewAllContractors](https://i.ibb.co/kG1GqC5/contractors.png)

### Contractors Home Page
- For the contractor page, if there is an active job for a contractor, findAllByContractorsEquals from the job repository will show the job, product, and client.






