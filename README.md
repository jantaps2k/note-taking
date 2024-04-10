# Note Taking

**Run Application**
NoteTakingApplication.java

**Initial Data File**
<br/>
data.sql

**To Access API Specification:**
http://localhost:8080/swagger-ui/index.html

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
