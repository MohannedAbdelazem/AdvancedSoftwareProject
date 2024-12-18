#!/bin/sh

http -A bearer -a "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiVVNFUiIsInN1YiI6InRlc3QyQG1haWwubWUiLCJpYXQiOjE3MzQ1NTI0MDAsImV4cCI6MTczNDU4ODQwMH0.icz-vgkOgxAoqA9m3UTRnBEDZKAHHEeiXSAaxv30aV8" GET http://localhost:8080/api/course 
