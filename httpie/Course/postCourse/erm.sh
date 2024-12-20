#!/bin/sh

token=$1

http -A bearer -a "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiSU5TVFJVQ1RPUiIsInN1YiI6InRlc3RpbnN0cnVjdEBtYWlsLm1lIiwiaWF0IjoxNzM0Njg3NjYyLCJleHAiOjE3MzQ3MjM2NjJ9.cLFQ_umXEEmqPYvCyTFYRid4i3kNHsbRQpvdyvGP6_0" POST http://localhost:8080/api/course/instructor @body.json
