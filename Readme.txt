Introduction
Automation is done using Selenium TestNG Framework (Maven Project)
Project Name-Gurukula
Package description
1. com.automation.pagelibrary.gurukula
gurukula.java:It consists of following
a. Page object definition
b. generic methods(For e.g. waitForElementToDisplay,clickWebelement etc)
c. Application related functions(For e.g. Login,Logout,createnewbranch etc)

2. com.automation.testcases.gurukula
It consist of two program files
a. GurukulaBranchScenarios.java-It consist of test cases related Branch functionality
b. GurkulaStaffScenarios-It consist of test cases related Staff functionality.

3. com.automation.testutilities
It consist of two program files
a. ConfigRead.java-This is responsible for loading the configurations from properties files located at /src/test/resources/configuration/config.properties 
b.Testbase.java-This is responsible for Initializing the WebDriver.

How to Run
1. In IDE just right click on testng.xml file and click on Run as 'TestNG Suite' will invoke  tests
2. It can be executed from command line also using maven command- mvn test(required maven dependencies are added in pom.xml)

Test report
1.It is a default TestNG report generated in test output folder(index.html,emailable-report.html)
2.If run using maven command (mvn test),report can be found in folder target\surefire-reports(index.html,emailable-report.html)




