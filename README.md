Nebulae Currency Converter
=========

Nebulae Converter is a fictional product from xTrade company, destinated for all merchants from galaxy to help evaluate the currency for some materials.

*All code is also available on a private bitbucket repository, request to join project

Requirements
----
Java 1.7

Maven 3

How to compile
--------------
inside source folder execute
```
mvn clean install
```
Maven will resolve the dependencies, compile and run all tests (some exceptions are expected, they are part of the tests, please wait for 'Build Success')

A jar file will be created inside target folder, to generate a jar with all dependencies included please execute:
```
mvn compile assembly:single
```
This command will generate a jar with "jar-with-dependencies" appended

How to execute
--------------
You should execute the jar giving a path for a file with the currency commands like the example:
```
$ java -jar nebulae-converter-0.0.1-SNAPSHOT-jar-with-dependencies.jar ./input.txt
```
This will result:
```
pish tegj glob glob is 42
glob prok  SILVER is 68.00 Credits
glob prok  GOLD is 57800.00 Credits
glob prok  IRON is 782.00 Credits
I have no idea what you are talking about
```
A file with the commands used on this example could be found on /src/test/resources
