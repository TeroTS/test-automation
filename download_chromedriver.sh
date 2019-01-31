#!/bin/bash

latest=`curl http://chromedriver.storage.googleapis.com/LATEST_RELEASE`
curl -o /tmp/chromedriver_mac64.zip https://chromedriver.storage.googleapis.com/$latest/chromedriver_mac64.zip
unzip /tmp/chromedriver_mac64.zip -d /usr/local/bin
chmod +x /usr/local/bin/chromedriver
