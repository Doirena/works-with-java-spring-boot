<b>Rest API</b>  
This project is simple rest API.  
Whole project is made by spring boot gradale, Java 11 all data is save in postgres sql.  
<b>Run application</b>  
To run this application you have to do these steps with docker which creates image for psql:  
`- docker run --name postgres-spring -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres:alpine`   
`- docker port postgres-spring`  
`- docker exec -it 1e7fe2882828 bin/bash`  
`- psql`  
`- bash-5.0# psql -U postgres`  
Create db which we declared in project: 
`- CREATE DATABASE demodb;`  
`- \c demodb`   
Docker should generate UUID format variables:    
`- CREATE EXTENSION "uuid-ossp"`  
Insert data in to table:  
`- INSERT INTO person (id, name) VALUES (uuid_generate_v4(), "Maria Jones");`  
`- INSERT INTO person (id, name) VALUES (uuid_generate_v4(), 'Anna Smith');`  
Get all data from data base:  
`- SELECT * FROM person;`