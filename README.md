# pipedrive_challenge

Backend project done with Java and springboot.

Here you can find 4 endpoints: 
  /getAllOrganizations -> Get request: returns all organizations in our Database.
  /getOrganization -> Get request: Receives a name and return an Organization with that name or parent
  /uploadFile -> Post request: Send a multipart file (csv file) and write the content to our Database.
  /createOrganization -> Post request: Send a name and a parent and create a new organization to our database.
  
  In the file application.properties you can find the configuration to connect to a postgresql Database.
