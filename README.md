baseversion-maven-plugin
========================

Extracts the base version number from maven project. This will be useful if your project is management in a continuous delivery pipeline and the version number should contain the build number. In this case you have to concat the base version number of your project with the build number digit. See examples below.

## Usage ##

	mvn org.fred4jupiter.baseversion:baseversion-maven-plugin:execute
	
This will generate a `version.properties` file in project root folder with the content like this:

	BASE_VERSION=1.2	

## Configuration ##

    <plugin>
        <groupId>org.fred4jupiter.baseversion</groupId>
        <artifactId>baseversion-maven-plugin</artifactId>
        <version>0.0.1-SNAPSHOT</version>
		<configuration>
			<numberOfDigits>2</numberOfDigits>
		</configuration>
    </plugin>

The default `numberOfDigits` is `2`.

**Examples**:

- numberOfDigits: 1, version: 1.0.0-SNAPSHOT, result: 1
- numberOfDigits: 2, version: 1.0.0-SNAPSHOT, result: 1.0
- numberOfDigits: 3, version: 1.0.0-SNAPSHOT, result: 1.0.0
- numberOfDigits: 3, version: 22.43.128-SNAPSHOT, result: 22.43.128
- numberOfDigits: 4, version: 1.0.0-SNAPSHOT, result: 1.0.0.0
 
