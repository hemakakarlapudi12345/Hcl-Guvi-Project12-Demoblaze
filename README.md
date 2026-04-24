# DemoBlaze Test Automation Framework

**Author:** Hema K  
**Application Under Test:** [DemoBlaze](https://www.demoblaze.com)  
**Framework Type:** Page Object Model (POM)

---

## Overview

This is a Selenium-based test automation framework built in Java to validate the end-to-end functionality of the DemoBlaze e-commerce web application. The framework follows the Page Object Model (POM) design pattern for clean separation of concerns, maintainability, and scalability.

---

## Tech Stack

| Tool / Technology     | Version    | Purpose                          |
|-----------------------|------------|----------------------------------|
| Java                  | 11+        | Core programming language        |
| Selenium WebDriver    | 4.41.0     | Browser automation               |
| TestNG                | 7.10.2     | Test execution and management    |
| Maven                 | 3.x+       | Build and dependency management  |
| WebDriverManager      | 5.7.0      | Automatic driver setup           |
| ExtentReports         | 5.1.1      | HTML test reporting              |
| Apache POI            | 5.2.5      | Excel data support               |
| Log4j                 | 2.22.1     | Logging                          |

---

## Project Structure

```
DemoBlaze-Application-main/
│
├── src/main/java/com/srm/
│   ├── base/
│   │   ├── BasePage.java          # Common WebDriver utility methods (click, type, wait, alerts)
│   │   └── BaseTest.java          # Test setup and teardown (WebDriver init/quit)
│   │
│   ├── pages/
│   │   ├── HomePage.java          # Home page actions (category nav, product selection)
│   │   ├── LoginPage.java         # Login/signup page interactions
│   │   ├── ProductPage.java       # Product detail page actions
│   │   ├── CartPage.java          # Cart page actions (open, delete items)
│   │   └── OrderPage.java         # Order placement and confirmation
│   │
│   └── utils/
│       ├── ConfigReader.java      # Reads config.properties file
│       ├── DriverFactory.java     # Initializes Chrome/Firefox WebDriver
│       ├── ExtentManager.java     # Manages ExtentReports HTML report
│       └── ScreenshotUtil.java    # Captures screenshots on test failure
│
├── src/main/resources/
│   └── config.properties          # Browser, base URL, and timeout config
│
├── src/test/java/com/srm/
│   ├── listeners/
│   │   └── TestListener.java      # TestNG listener for reports and screenshots
│   │
│   └── tests/
│       ├── SignupTest.java         # User signup tests
│       ├── LoginTest.java          # Login and logout tests
│       ├── ProductTest.java        # Product browsing and details tests
│       ├── CartTest.java           # Cart management tests (add, delete, negative)
│       └── OrderTest.java          # Order placement and validation tests
│
├── reports/
│   └── ExtentReport.html          # Generated HTML test report
│
├── screenshots/                   # Auto-captured screenshots on failures
├── testng.xml                     # TestNG suite configuration
└── pom.xml                        # Maven project configuration
```

---

## Test Coverage

### Signup Tests
- New user registration with alert verification

### Login Tests
- Valid login with credential verification
- Welcome message validation after login

### Product Tests
- Phones category loading and product count verification
- Product details display validation
- Home page reloads all products after category navigation

### Cart Tests
- Add a single product to cart and verify it
- Add multiple products and verify count
- Delete a product from cart
- **Negative:** Verify wrong product is NOT in cart (intentional failure test)

### Order Tests
- Place a successful order and verify "Thank you for your purchase!" message
- **Negative:** Attempt order without a name — detects bug if order goes through

---

## Framework Features

- **Config-Driven Execution** — browser, URL, and timeout managed via `config.properties`
- **Page Object Model** — reusable page classes for clean and maintainable code
- **WebDriverManager** — eliminates manual driver binary setup
- **Explicit Waits** — `WebDriverWait` used throughout; no `Thread.sleep()`
- **Screenshot on Failure** — captured automatically by `TestListener` + `ScreenshotUtil`
- **ExtentReports** — rich HTML reports generated after each test run
- **Multi-Browser Support** — Chrome and Firefox supported via `DriverFactory`

---

## Configuration

Edit `src/main/resources/config.properties` to change test settings:

```properties
browser=chrome        # chrome or firefox
baseUrl=https://www.demoblaze.com
timeout=20            # Explicit wait timeout in seconds
```

---

## Prerequisites

- Java JDK 11 or higher
- Maven 3.x or higher
- Chrome or Firefox browser installed
- Internet connection (WebDriverManager downloads drivers automatically)

---

## How to Run

### Run all tests via Maven:
```bash
mvn test
```

### Run via TestNG XML:
```bash
mvn test -DsuiteXmlFile=testng.xml
```

### Run a specific test class:
```bash
mvn test -Dtest=CartTest
```

---

## Test Reports

After execution, the HTML report is generated at:

```
reports/ExtentReport.html
```

Open this file in any browser to view detailed test results with pass/fail status, duration, and logs.

---

## Screenshots

Failure screenshots are auto-saved in the `screenshots/` directory with the format:

```
<TestName>_<yyyyMMdd>_<HHmmss>.png
```

Example:
```
signUpTest_20260419_235919.png
placeOrderTest_20260419_202802.png
```

---

## TestNG Suite Structure

```xml
<suite name="DemoBlaze Suite" parallel="false">
    <listeners>
        <listener class-name="com.srm.listeners.TestListener"/>
    </listeners>

    <test name="Signup Test">
        <classes>
            <class name="com.srm.tests.SignupTest"/>
        </classes>
    </test>

    <test name="DemoBlaze Tests">
        <classes>
            <class name="com.srm.tests.LoginTest"/>
            <class name="com.srm.tests.ProductTest"/>
            <class name="com.srm.tests.CartTest"/>
            <class name="com.srm.tests.OrderTest"/>
        </classes>
    </test>
</suite>
```

---

## Author

**Hema K**  
Selenium Test Automation Framework for DemoBlaze E-Commerce Application
