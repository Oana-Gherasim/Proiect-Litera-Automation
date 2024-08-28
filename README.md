# Proiect-Litera-Automation
For this project, I chose the website "Litera.ro" and created automated tests to verify functionalities such as: search bar, shopping cart, and order placement.

The project was implemented using the Java programming language with the help of IntelliJ, Selenium WebDriver, JUnit, and TestNG frameworks.

I divided the code into three packages, each with its corresponding classes, for easier navigation, identification, and execution.

BaseTest is a base class that prepares the "ground" for the following more specific tests, i.e., it ensures that each test starts with the browser open, the browser window maximized, and handles cookies if present. It also contains a method that closes the browser after each test.
This base class is extended by the other test classes in the Test package to inherit common configuration and finalization methods.

HelpMethods is a class that contains a collection of methods that are common to multiple test cases and will be used to interact with the web browser. This class was created to separate the test logic from the page interaction logic, to avoid code duplication, making everything easier to read and maintain.

The Test package contains 21 test cases that verify the 3 functionalities. Each test in this package contains the @Test annotation that identifies them as test cases.
