# CucumberHybridFramework

A **hybrid automation framework** built using **Selenium, Java, Cucumber, Gherkin, and JUnit**, following the **Page Object Model (POM)** design pattern. This framework is designed for automated testing of web applications and supports a modular, scalable, and maintainable structure.

---

## Table of Contents

1. Overview
2. Project Structure
3. Tech Stack
4. Installation
5. How to Run Tests
6. Features
7. Framework Details
8. Contributing
9. License

---

## Overview

This project is a **Cucumber-based hybrid automation framework**. It uses **Selenium WebDriver** for browser automation, **Cucumber & Gherkin** for behavior-driven development (BDD), and **JUnit** for test execution.

The framework follows the **Page Object Model (POM)** design pattern, making it easy to maintain and extend.

It includes all necessary packages like:

* `factory` – for WebDriver initialization
* `hooks` – for Cucumber Before/After hooks
* `runner` – for executing test suites
* `stepDefinitions` – for mapping Gherkin steps to Java code
* `pages` – Page Object Model classes
* `utils` – utility/helper classes including configuration files
* `features` – `.feature` files containing Gherkin scenarios

---

## Project Structure

```
CucumberHybridFramework/
│
├─ src/main/java/
│   ├─ pages/            # Page Object classes
│   └─ utils/            # Utility/helper classes including config
│
├─ src/test/java/
│   ├─ factory/          # WebDriver initialization
│   ├─ hooks/            # Cucumber hooks (Before/After)
│   ├─ runner/           # Test runners for executing feature files
│   └─ stepDefinitions/  # Step definitions for feature files
│
├─ src/test/resources/
│   └─ features/         # Cucumber feature files (Gherkin syntax)
│
├─ pom.xml               # Maven dependencies
└─ README.md             # Project documentation
```

---

## Tech Stack

* **Language:** Java
* **Automation Tool:** Selenium WebDriver
* **BDD Framework:** Cucumber (Gherkin syntax)
* **Test Runner:** JUnit
* **Build Tool:** Maven
* **Design Pattern:** Page Object Model (POM)

---

## Installation

1. **Clone the repository:**

```bash
git clone <repository_url>
cd CucumberHybridFramework
```

2. **Open the project** in your preferred IDE (IntelliJ IDEA, Eclipse).

3. **Install dependencies** (Maven will download them automatically):

```bash
mvn clean install
```

4. **Configure environment settings** (if required) in `utils/config.properties`:

```
url=https://example.com
browser=chrome
```

---

## How to Run Tests

You can run tests using the **JUnit runner** or **Maven command line**.

### 1. Using IDE:

* Open the `runner` package
* Run the `TestRunner.java` file
* The tests will execute based on the feature files and generate reports

### 2. Using Maven:

```bash
mvn test
```

### 3. Cucumber Reports:

* Reports are generated in `/target/cucumber-reports/` (optional: use `ExtentReports` for better reporting)

---

## Features

* Supports **cross-browser testing**
* Modular framework with **Page Object Model**
* **Reusable steps** with Cucumber step definitions
* Supports **multiple feature files and scenarios**
* Easy to maintain and extend with new tests
* **Custom utility methods** for common actions (click, input, waits, etc.)

---

## Framework Details

* **factory** – Initializes WebDriver based on browser config
* **hooks** – Runs before and after each scenario (setup and teardown)
* **runner** – Executes the feature files using JUnit
* **stepDefinitions** – Implements Gherkin steps in Java
* **pages** – Contains all web page classes with WebElements and actions
* **utils** – Includes helper functions and configuration files
* **features** – Contains `.feature` files with BDD scenarios

---

## Contributing

1. Fork the repository
2. Create your feature branch: `git checkout -b feature/my-feature`
3. Commit your changes: `git commit -m 'Add new feature'`
4. Push to branch: `git push origin feature/my-feature`
5. Open a Pull Request

---

## License

This project is licensed under the MIT License.
