#!/bin/bash

./gradlew clean test -Pall -Penv=local
# open build/testng-output/emailable-report.html
