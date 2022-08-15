# pipedrive_challenge

Backend project done with Java and springboot.

Here you can find 4 endpoints: 
  /getAllOrganizations -> Get request: returns all organizations in our Database.
  /getOrganization -> Get request: Receives a name and return an Organization with that name or parent
  /uploadFile -> Post request: Send a multipart file (csv file) and write the content to our Database.
  BONUS: /createOrganization -> Post request: Send a name and a parent and create a new organization to our database.
  
  All the GET endpoints return the list order alphabetic by name.
  
  In the file application.properties you can find the configuration to connect to a postgresql Database.
  About the database, just need to create a simple postgresql database with the configuration found in application.properties.
    username: postgres
    password: postgres
    database: postgres
    port: 5432
    url to connect: jdbc:postgresql://localhost:5432/postgres
    
  
  If the project launches an error on start, try to maven clean and then maven install.
