baseversion-maven-plugin
========================

Extracts the base version number from maven project. E.g. base version of 1.0.0-SNAPSHOT is 1.0

## Usage ##

	mvn org.fred4jupiter.baseversion:baseversion-maven-plugin:execute
	
This will generate a `version.properties` file in project root folder with the content like this:

	BASE_VERSION=1.2	
