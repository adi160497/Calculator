Framework is created using Selenium WebDriver with Java and testNG. Browser name and environment configuration are added inside the config.properties file. Parallel Execution is added in testNg.xml Standard page object model used. DataProvider annotation is used to pass test data.

Created All four scenarios Addition, Substraction, multiplication and division.

Test suite is working fine against prodcution calculator (All four scenario's passed).

For staging calculator one scenario is failing i.e. multiplication scenario other scenario's are working as expected. So there is one bug in the release that is multiplication functionality not working properly.
