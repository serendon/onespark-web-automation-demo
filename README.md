# OneSpark Web Automation Tests

This project contains automated tests for the OneSpark web application.

### Prerequisites
- Java 11 or higher
- Maven
- TestNG compatible IDE (e.g., IntelliJ IDEA, Eclipse)

### Plugins
- Cucumber for Java
- Gherkin

### Dependencies
- Cucumber
- Selenium WebDriver
- WebDriverManager
- TestNG

### maven commands:

```bash
mvn clean test
mvn clean test -Dconfig.file=config-production.properties
mvn clean test -Dconfig.file=config-uat.properties
```

## Test runner class
File path: src/test/java/TestRunner/CucumberRunnerTests.java

## View Test Report
File path: target/cucumber.html

## Page Object Model Design Pattern
The Tests are created using Page Object Model (POM) which is a design pattern used in test automation to enhance the maintainability, readability, and reusability of automated tests. It organizes test code into logical units called "Page Objects," each representing a separate page or component of the application under test.

## Config File Reader
Java class ConfigFileReader is responsible for reading configuration properties from a properties file.
There's a static block that initializes the properties object. Inside the block it attempts to read a configuration file specified by the system property "config.file". If no system property is set, it defaults to "config-production.properties".

## ReUsableMethods
This Java class, named ReUsableMethods, contains reusable methods commonly used in Selenium WebDriver test automation. Here's an overview of its functionalities:

## HelperClass
The helper class encapsulates common WebDriver setup and teardown logic, promotes code reuse, and facilitates efficient management of WebDriver instances in Selenium test automation projects.

## Hooks Class
This Java class, named Hooks, is used in Cucumber-based test automation frameworks to define setup and teardown actions that need to be executed before and after each scenario.

## CucumberRunnerTests Class
The CucumberRunnerTests class is used to configure and execute Cucumber tests using TestNG. It specifies the locations of feature files and step definitions, as well as the plugins to use for generating test reports. When executed, it runs the Cucumber scenarios defined in the feature files and produces test reports based on the specified plugins.

## Feature Files and Step Definitions
Feature files provide a human-readable description of the behavior of the application, while step definitions provide the executable implementation of that behavior. Together, they enable collaboration between technical and non-technical stakeholders and facilitate the automated testing of software applications based on user requirements.

## Reference links
https://qaautomation.expert/2023/10/09/page-object-model-with-selenium-cucumber-and-testng/
