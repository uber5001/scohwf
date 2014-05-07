#!/bin/sh
javac -cp .:gson-2.2.4.jar:jdbc.jar *.java
java -cp .:gson-2.2.4.jar:jdbc.jar ParsingUser
