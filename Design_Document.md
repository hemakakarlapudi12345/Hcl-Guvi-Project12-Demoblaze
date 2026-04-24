# Test Framework Design

## Framework Type

Page Object Model (POM)

---

## Features

* Config-driven execution using `config.properties`
* Reusable Page methods using POM design
* WebDriverManager for driver setup (no manual setup)
* Explicit waits using WebDriverWait (no Thread.sleep)
* Screenshot capture on test failure
* ExtentReports for HTML reporting
* Modular and maintainable framework structure

---

## Test Coverage

* User Signup (new user registration)
* Login (valid & invalid scenarios)
* Logout functionality
* Product browsing by category (Phones, Laptops, Monitors)
* Product details verification
* Add to Cart functionality
* Multiple products in cart
* Delete product from cart
* Order placement and confirmation
* Form validations (empty fields, invalid inputs)

---
## Project Structure
```
DemoBlaze
│
├── src/main/java
│   ├── com.srm.base
│   │   ├── BasePage.java
│   │   └── BaseTest.java
│   │
│   ├── com.srm.pages
│   │   ├── HomePage.java
│   │   ├── LoginPage.java
│   │   ├── ProductPage.java
│   │   ├── CartPage.java
│   │   └── OrderPage.java
│   │
│   ├── com.srm.utils
│   │   ├── ConfigReader.java
│   │   ├── DriverFactory.java
│   │   ├── ExtentManager.java
│   │   └── ScreenshotUtil.java
│
├── src/main/resources
│   └── config.properties
│
├── src/test/java
│   ├── com.srm.listeners
│   │   └── TestListener.java
│   │
│   └── com.srm.tests
│       ├── SignupTest.java
│       ├── LoginTest.java
│       ├── ProductTest.java
│       ├── CartTest.java
│       └── OrderTest.java
│
├── reports
│   
│
├── screenshots
│   
│
├── testng.xml
├── pom.xml




```
---
## Tools & Technologies

* Java  
* Selenium WebDriver  
* TestNG  
* Maven  
* WebDriverManager  
* ExtentReports  
* WebDriverWait for dynamic elements  



---
