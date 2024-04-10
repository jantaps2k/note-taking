# Note Taking

**Setup Steps**
<br/>
1. After cloning add note-taking as gradle project
2. Initial data file can be modified in the data.sql file
3. Run NoteTakingApplication.java to run the application
4. When NoteTakingApplication is running, Documentation and API Specification can be viewed at http://localhost:8080/swagger-ui/index.html
5. Curl commands below may be added to an API Testing tool to use the APIs
6. Notes.postman_collection.json file can be imported as API collection to Postman to use the APIs

<br/>

**APIs and curl commands:**

<u>**Get All Notes**</u>
<br/>
curl --location 'http://localhost:8080/notes'

<u>**Create Note**</u>
<br/>
curl --location 'http://localhost:8080/notes' \
--header 'Content-Type: application/json' \
--data '{
"title" : "Samsung Note 4",
"body" : "The Notes of Notes"
}'

<u>**Get Note**</u>
<br/>
curl --location 'http://localhost:8080/notes/4'

<u>**Update Note**</u>
<br/>
curl --location --request PUT 'http://localhost:8080/notes/4' \
--header 'Content-Type: application/json' \
--data '{
"title" : "IphoneNote4",
"body" : "Note 4"
}'

<u>**Delete Note**</u>
<br/>
curl --location --request DELETE 'http://localhost:8080/notes/4'
