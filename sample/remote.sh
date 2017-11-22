#!/bin/bash

mvn clean test -Dtest=GoogleExampleTest -DseleniumGridURL=http://ip:port/wd/hub -Dremote=true
