# Mobile Automation Assignment

This assignment is created using **Appium** with **Selenium** and **Java 11**.

https://user-images.githubusercontent.com/25913495/229532301-4a546726-beaf-4705-82f1-7f7f3aea0863.mp4

## Prerequisites
- Install **Node.js** and set the environment variable
- Install **Java 11** and set the environment variable. 
- **Java 17** also works fine with IDE, but test execution from cmd gives errors if the java version is not < 15 (surefire plugin has issues).
- Install **Android** and set environment variable
- Install an **Appium Inspector** to locate locators.
- Install **Appium Doctor** to check project health.
- Install **Appium 1.22.3** (recommended). 1.22 is the last stable version. Appium 2.0 faced many issues because of the instability of the version.
- Install **Maven** and set environment variable. It’s needed to run maven scripts from cmd.
- Install **Android Studio** for the emulator.  
- Generate sdk using APK combo (chrome extension)

## Goal
The goal is to create a test suite to verify the Settings screen.

## System Design:
- **POM** (Page Object Model)
- **Page Factory** from Selenium WebDriver to support Page Object Design pattern
- **Base Test/Base App**
- **Test Data Factory**

## Framework Overview
The project structure includes the following packages:  
- **apps**: It includes sdk/ipa needed for testing.
- **main:** Includes configs, driver, pages, reports, and resources.
- **config:** The class ConfigManager is the connection between the property files capabilities.properties and authorization.properties located in *src/main/resources/*.  
 The *@Config.Sources* load the properties file and matches the attributes with the *@Key*, so you automatically have the value.  
 This strategy uses the *Owner* library.
- **driver:** It includes everything that is needed to set the Appium driver using provided desired capabilities.
- **page:** It includes BasePage that contains reusable actions.
- **report:** It includes TestNG listeners and logs to improve reporting.
- **pages:** Pages are extending BaseClass and include page locators and actions.
- **resources:** Includes desired capabilities and authentication properties. It also includes logs.properties for printing logs at cmd.
- **test:** It contains BaseTest, Test classes for pages, and resources.
- **base:** BaseTest provides everything the test classes need to execute i-e authentication, driver, and tear down.
- **tests:** It includes test classes.

## Covered Test Scenarios
The project covers the following test scenarios:
- Verify the user’s full name on the Settings page.
- Verify the user’s email on the Settings page.
- Verify the user’s image is displayed on the Settings page.  

## Test Execution
- Java 11 for cmd. For IDE, Java 17 also works.
- Add sdk in apps folder.
- Add authentication parameters at *src/main/resources/authenticationConfig.properties*
- Run *Android Emulator*, *Pixel 4*,*version 11*.
- Run Appium server in cmd:  
`appium --allow-insecure chromedriver_autodownload`
- Tests can be run in the following ways:  

  - Run tests from the suite.xml: *src/test/resources/suite.xml*  
  - Run tests from cmd:  
  `mvn clean test`
  - Run individually from inside the test class.

## Test Reports
Test results are generated using **Allure Reports**, **TestNG Listeners**, and **Log4j**.  
The test report includes logs of execution at cmd and HTML report that opens in the browser.  
![allure_success](https://user-images.githubusercontent.com/25913495/229533723-4f40592f-8af1-48af-95d0-66a514ac8424.png)

Screenshots will be taken on assert failures.

https://user-images.githubusercontent.com/25913495/229531959-a7080ca9-1f64-4b35-a34c-1cdf267406f3.mp4  

  
After running tests:
1. The following command can be executed from cmd to open the report in the browser:  
`allure serve build/allure-results`  
(requires allure installation and environment variable setup)
2. HTML report can be found at *build/reports/tests/test/index.html* after every test execution.
![allure_broken](https://user-images.githubusercontent.com/25913495/229533963-532fa973-8b81-4745-8425-9c113801bcb0.png)

## Tools Used

The project was built using the following tools:

- Appium 
- Selenium
- TestNG
- Java 11
- Maven
- Owner
- Log4j
- Allure Report
- Supporting dependencies: Android Emulator

## Flakiness

Due to time constraints, I couldn’t focus on the following issues:

1. When Google Chrome opens for the first time, it shows a welcome screen. It is possible to dismiss the welcome screen by clicking continue, but if we do that, the XPath locator for the password field doesn’t work anymore. It needs to be investigated.
2. Thread.sleep() is used before the device activation screen because of inconsistent behavior of the screen. Sometimes device activation and walkthrough screens appear multiple times.
3. The login password xpath locator is not located sometimes. The id should be available so we can avoid using XPath. 

## Future Enhancements

- Since Login is a pre-requisite so it should not be done at FE but BE. It makes tests less flaky and faster. I did implement this approach but the credentials shared for FE are for production and BE credentials are from Demo or test environment, so I had to switch to FE.
- CI/CD
- Using tags to annotate/group test cases/classes/packages
- Cucumber
- Physical devices setup. Currently, I don’t have an android to try on.
- IOS setup
- Automate the retry step on device activation. 
- Browser cookies need to be cleared before each test. For now, the user account is deleted from the login screen after each test in tearDown().  
- User credentials will be removed from reports. For demo purposes I post them in reports.

