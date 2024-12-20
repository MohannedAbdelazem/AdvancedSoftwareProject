#!/bin/sh

http -A bearer -a "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiU1RVREVOVCIsInN1YiI6InRlc3R0ZXN0QG1haWwubWUiLCJpYXQiOjE3MzQ3MDA4MzQsImV4cCI6MTczNDczNjgzNH0.oRNh_T8U31j0VJk24LO5JTD1FrU3nZrFQF1i8AJaNCo" POST http://localhost:8080/api/course/253/enroll
