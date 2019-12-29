Sample OAuth server

To test the application

Using Postman
 
1. Access the public page should be possible as there is no restriction on this page
http://localhost:8093/public 

2. Now get the oauth token 
POST request : http://localhost:8093/oauth/token
Enable 'Basic Auth' in Authorization
	username/password as client/password
Body (x-www-form-urlencoded):	
	password : secret
	username : admin
	grant_type : password

Response:
	{
    "access_token": "0dc1069d-0f78-4bba-80ba-a50bd990d15f",
    "token_type": "bearer",
    "refresh_token": "eabbfaa7-5c19-46ad-b523-c219b82709d8",
    "expires_in": 3599,
    "scope": "read write"
	}

3. Use the access_token and access the following page
	http://localhost:8093/admin

4. Perform the step-2 with username as 'user' , retrieve the access_token and access the following page
	http://localhost:8093/private

	
Curl commands

1. To get the oauth token 
curl -X POST --user 'user:<encrypted password>' -d 'grant_type=password&username=user&password=password' http://localhost:8093/oauth/token

2. To access protected APIs
curl -i -H "Accept: application/json" -H "Content-Type: application/json" -H "Authorization: Bearer $TOKEN" -X GET http://localhost:8093/private
or
curl -i -H "Accept: application/json" -H "Content-Type: application/json" -H "Authorization: Bearer $TOKEN" -X GET http://localhost:8093/admin