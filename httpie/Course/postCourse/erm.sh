#!/bin/sh

http -A bearer -a "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiQURNSU4iLCJzdWIiOiJ0ZXNzdEBtYWlsLm1lIiwiaWF0IjoxNzM0NTQ3ODQ5LCJleHAiOjE3MzQ1ODM4NDl9.Z7lgDcCPF375yoz9LVpDGdswpgyaB49_PlBQa63guac" POST http://localhost:8080/api/course @body.json
