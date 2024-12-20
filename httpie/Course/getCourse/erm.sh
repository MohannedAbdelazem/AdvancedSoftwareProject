#!/bin/sh

http -A bearer -a "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiU1RVREVOVCIsInN1YiI6InRlc3R0ZXN0QG1haWwubWUiLCJpYXQiOjE3MzQ2ODczNjcsImV4cCI6MTczNDcyMzM2N30.Jo6E2q4nmp8KjVzZ-8nzrin9H0cer90uibUpQrbXrQo" GET http://localhost:8080/api/course/
