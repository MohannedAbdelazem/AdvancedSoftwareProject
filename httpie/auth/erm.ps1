# Define the path to the JSON file
$jsonFilePath = ".\body.json"

# Define the URL for the POST request
$url = "http://localhost:8080/auth/register"

# Define the bearer token
# $token = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiQURNSU4iLCJzdWIiOiJ0ZXNzdEBtYWlsLm1lIiwiaWF0IjoxNzM0NTQ3ODQ5LCJleHAiOjE3MzQ1ODM4NDl9.Z7lgDcCPF375yoz9LVpDGdswpgyaB49_PlBQa63guac"

# Construct the HTTPie command
$httpieCommand = "http POST $url Authorization:`"Bearer $token`" @`"$jsonFilePath`""

# Execute the HTTPie command
Invoke-Expression $httpieCommande