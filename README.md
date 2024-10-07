# QA Automation - Technical test
## Overview
This project is a technical test to a QA automation role. The requirement was automating the verifying of a user sign-up form in a page web with the next requirements :

* Full name (mandatory field)
* Email (mandatory field and validated by format)
* Password (mandatory field and validated by complexity)
    * Password confirmation (mandatory field and must match the password field)
* Register user (button to confirm registration)

It utilizes Selenium WebDriver for web automation and TestNG as the testing framework.

# Project Structure

    demoqa-automation/
    │
    ├── reports/
    │   └── index.html
    │
    ├── src/
    │   │
    │   │
    │   └── test/
    │       ├── java/
    │       │   ├── Components/
    │       │   │    ├── config/
    │       │   │    │   ├── PageBase.java
    │       │   │    │   └── TestBase.java       
    │       │   │    └── utilities/
    │       │   │        └── report/
    │       │   │              ├── ExtentReporterNG
    │       │   │              └── Listeners
    │       │   │    
    │       │   ├── Pages/        
    │       │   │    ├── HeaderMenuComponent.java
    │       │   │    ├── RegisterPage.java
    │       │   │    └── SuccessRegisterPage.java
    │       │   │
    │       │   ├── Tests/
    │       │   │    └── RegisterTest.java
    │       │   │
    │       │   └── TestSuites 
    │       │         └── Register.xml
    │       │
    │       └── resources
    │           └── config.properties
    │
    ├── pom.xml                # Maven project configuration
    └── README.md              

# Features
- Page Object Model (POM): The project follows the POM design pattern to maintain separation between test code and page-specific code.
- Reporting: Test execution reports are generated for easy analysis and troubleshooting.

# Setup
1. You need to have java downloaded
2. [Install and configure Maven](https://youtu.be/YTvlb6eny_0?si=swpCpuEUvu0vnnKi)
3. Clone the repository:

       git clone: https://github.com/JorgeSanchez112/AutomateSignUpCenet.git
4. Run tests using Maven:
>[!NOTE]
> You can do the next steps with the terminal.
 
    First clean the project dependencies contain in POM, You can do it using the next command.

    mvn clean

   <sub> Run all Register Tests </sub>
        
    mvn test -P=RegisterTests

# Test Execution
- Tests are executed using TestNG test runner.
- Test reports are generated in HTML format and can be found in the reports directory it should be created automatically when a test suite has finished.
