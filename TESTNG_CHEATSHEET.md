# TestNG Cheatsheet

A quick reference guide for TestNG framework commonly used annotations, assertions, and configurations.

---

## Table of Contents
1. [Annotations](#annotations)
2. [Assertions](#assertions)
3. [Test Configuration](#test-configuration)
4. [Grouping Tests](#grouping-tests)
5. [Parameterization](#parameterization)
6. [Dependency Management](#dependency-management)
7. [Test Listeners](#test-listeners)
8. [Parallel Execution](#parallel-execution)
9. [Reporting](#reporting)
10. [Best Practices](#best-practices)

---

## Annotations

### Test Method Annotations

| Annotation | Purpose | Example |
|-----------|---------|---------|
| `@Test` | Marks a method as a test method | `@Test public void loginTest() {}` |
| `@BeforeMethod` | Runs before each test method | `@BeforeMethod public void setUp() {}` |
| `@AfterMethod` | Runs after each test method | `@AfterMethod public void tearDown() {}` |
| `@BeforeClass` | Runs once before all test methods (static) | `@BeforeClass public static void setup() {}` |
| `@AfterClass` | Runs once after all test methods (static) | `@AfterClass public static void tearDown() {}` |
| `@BeforeSuite` | Runs once before the entire test suite | `@BeforeSuite public void setupSuite() {}` |
| `@AfterSuite` | Runs once after the entire test suite | `@AfterSuite public void tearDownSuite() {}` |
| `@BeforeTest` | Runs before each `<test>` tag in XML | `@BeforeTest public void beforeTest() {}` |
| `@AfterTest` | Runs after each `<test>` tag in XML | `@AfterTest public void afterTest() {}` |
| `@BeforeGroups` | Runs before a group of tests | `@BeforeGroups(groups = "smoke")` |
| `@AfterGroups` | Runs after a group of tests | `@AfterGroups(groups = "smoke")` |

### Test Method Annotation Attributes

```java
@Test(
    enabled = true,           // Enable/disable test
    priority = 1,             // Execution priority (lower runs first)
    timeOut = 5000,           // Max execution time in milliseconds
    expectedExceptions = ArithmeticException.class,  // Expected exception
    dependsOnMethods = {"method1", "method2"},       // Dependent methods
    groups = {"smoke", "regression"},                // Test groups
    description = "Login test case"                  // Test description
)
public void testLogin() {}
```

---

## Assertions

### Basic Assertions

```java
import org.testng.Assert;

// Equality
Assert.assertEquals(actual, expected);
Assert.assertEquals(actual, expected, "Custom failure message");
Assert.assertNotEquals(actual, expected);

// Boolean
Assert.assertTrue(condition);
Assert.assertFalse(condition);

// Null checks
Assert.assertNull(object);
Assert.assertNotNull(object);

// Object comparison
Assert.assertSame(object1, object2);      // Same reference
Assert.assertNotSame(object1, object2);   // Different reference

// Array comparison
Assert.assertEquals(actual[], expected[]);

// Soft assertions (continue on failure)
SoftAssert softAssert = new SoftAssert();
softAssert.assertEquals(actual1, expected1);
softAssert.assertEquals(actual2, expected2);
softAssert.assertAll();  // Report all failures at end
```

### AssertJ Assertions (Fluent API)

```java
import static org.assertj.core.api.Assertions.*;

assertThat(actual).isEqualTo(expected);
assertThat(actual).isNotEqualTo(expected);
assertThat(value).isGreaterThan(10);
assertThat(value).isLessThan(100);
assertThat(text).contains("substring");
assertThat(list).hasSize(5);
assertThat(list).containsExactly(1, 2, 3);
```

---

## Test Configuration

### Basic Test Class Structure

```java
public class LoginTests {
    
    private WebDriver driver;
    private LoginPage loginPage;
    
    @BeforeSuite
    public static void setupSuite() {
        System.out.println("Suite setup");
    }
    
    @BeforeClass
    public static void setupClass() {
        System.out.println("Class setup");
    }
    
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }
    
    @Test
    public void validLoginTest() {
        boolean isLoginSuccessful = loginPage.login("user", "password");
        Assert.assertTrue(isLoginSuccessful);
    }
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Class teardown");
    }
    
    @AfterSuite
    public static void tearDownSuite() {
        System.out.println("Suite teardown");
    }
}
```

---

## Grouping Tests

### Using Groups

```java
public class UserTests {
    
    @Test(groups = {"smoke", "regression"})
    public void createUserTest() {
        // Test code
    }
    
    @Test(groups = {"regression"})
    public void updateUserTest() {
        // Test code
    }
    
    @Test(groups = {"smoke"})
    public void deleteUserTest() {
        // Test code
    }
}
```

### XML Configuration for Groups

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Suite">
    <test name="Smoke Tests">
        <groups>
            <run>
                <include name="smoke" />
            </run>
        </groups>
        <classes>
            <class name="com.test.UserTests" />
        </classes>
    </test>
    
    <test name="Regression Tests">
        <groups>
            <run>
                <include name="regression" />
                <exclude name="smoke" />
            </run>
        </groups>
        <classes>
            <class name="com.test.UserTests" />
        </classes>
    </test>
</suite>
```

---

## Parameterization

### Data Provider

```java
public class LoginTests {
    
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
            {"user1@email.com", "password1", true},
            {"user2@email.com", "password2", true},
            {"invalid", "wrong", false}
        };
    }
    
    @Test(dataProvider = "loginData")
    public void parameterizedLoginTest(String username, String password, boolean expected) {
        boolean result = login(username, password);
        Assert.assertEquals(result, expected);
    }
}
```

### XML-Based Parameterization

```xml
<suite name="Suite">
    <test name="Parameterized Test">
        <parameter name="username" value="testuser" />
        <parameter name="password" value="testpass" />
        <classes>
            <class name="com.test.LoginTests" />
        </classes>
    </test>
</suite>
```

```java
public class LoginTests {
    
    @Parameters({"username", "password"})
    @Test
    public void parameterizedTest(String username, String password) {
        Assert.assertTrue(login(username, password));
    }
}
```

---

## Dependency Management

### Method Dependencies

```java
public class OrderTests {
    
    @Test
    public void testCreateOrder() {
        System.out.println("Creating order");
    }
    
    @Test(dependsOnMethods = {"testCreateOrder"})
    public void testPaymentOrder() {
        System.out.println("Payment order");
    }
    
    @Test(dependsOnMethods = {"testPaymentOrder"})
    public void testShipOrder() {
        System.out.println("Ship order");
    }
}
```

### Group Dependencies

```java
@Test(dependsOnGroups = {"database", "network"})
public void complexTest() {
    // Runs only after all tests in "database" and "network" groups
}
```

---

## Test Listeners

### Implementing ITestListener

```java
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomTestListener implements ITestListener {
    
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getName());
    }
    
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
    }
    
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
        System.out.println("Failure: " + result.getThrowable());
    }
    
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
    }
    
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test failed but within success percentage");
    }
    
    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test suite started");
    }
    
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test suite finished");
    }
}
```

### Registering Listener

**Via Annotation:**
```java
@Listeners(CustomTestListener.class)
public class LoginTests {
    // Test methods
}
```

**Via XML:**
```xml
<suite name="Suite">
    <listeners>
        <listener class-name="com.test.listeners.CustomTestListener" />
    </listeners>
    <test name="Test">
        <classes>
            <class name="com.test.LoginTests" />
        </classes>
    </test>
</suite>
```

---

## Parallel Execution

### XML Configuration

```xml
<suite name="Suite" parallel="methods" thread-count="4">
    <test name="Parallel Test" parallel="tests" thread-count="2">
        <classes>
            <class name="com.test.LoginTests" />
            <class name="com.test.UserTests" />
        </classes>
    </test>
</suite>
```

**Parallel Modes:**
- `methods` - Run test methods in parallel
- `tests` - Run tests in parallel
- `classes` - Run classes in parallel
- `instances` - Run instances in parallel
- `none` - No parallel execution

---

## Reporting

### TestNG HTML Report

TestNG automatically generates HTML reports in the `test-output` directory:
- `index.html` - Main report
- `testng-results.xml` - XML format results
- `emailable-report.html` - Email-friendly report

### Programmatic Reporting

```java
import org.testng.Reporter;

public class LoginTests {
    
    @Test
    public void loginTest() {
        Reporter.log("Starting login test");
        Reporter.log("Entering username");
        
        boolean result = login("user", "pass");
        
        Reporter.log("Login result: " + result);
        Assert.assertTrue(result);
    }
}
```

---

## Best Practices

### 1. Test Naming Convention
```java
@Test
public void testLoginWithValidCredentials() { }

@Test
public void testLoginWithInvalidPassword() { }

@Test
public void testLoginWithEmptyUsername() { }
```

### 2. Use Proper Assertions
```java
// Good
Assert.assertEquals(actualValue, expectedValue, "User login should be successful");

// Avoid
Assert.assertTrue(actualValue == expectedValue);
```

### 3. Test Independence
```java
// Good - Each test is independent
@Test
public void test1() {
    setupTestData();
    // Execute test
}

@Test
public void test2() {
    setupTestData();
    // Execute test
}

// Avoid - Tests dependent on execution order
```

### 4. Use BeforeMethod/AfterMethod for Setup/Teardown
```java
@BeforeMethod
public void setUp() {
    driver = new ChromeDriver();
}

@AfterMethod
public void tearDown() {
    driver.quit();
}
```

### 5. Group Related Tests
```java
@Test(groups = {"smoke"})
public void criticalTest() { }

@Test(groups = {"regression"})
public void regressionTest() { }

@Test(groups = {"sanity"})
public void sanityTest() { }
```

### 6. Use DataProviders for Multiple Scenarios
```java
@DataProvider(name = "testData")
public Object[][] getTestData() {
    return new Object[][] { /* data */ };
}

@Test(dataProvider = "testData")
public void testWithData(String param1, String param2) { }
```

### 7. Use Soft Assertions for Multiple Validations
```java
SoftAssert softAssert = new SoftAssert();
softAssert.assertEquals(actual1, expected1);
softAssert.assertEquals(actual2, expected2);
softAssert.assertTrue(condition);
softAssert.assertAll();
```

### 8. Enable/Disable Tests Conditionally
```java
@Test(enabled = false)  // Skip this test
public void skipTest() { }

@Test(expectedExceptions = NullPointerException.class)
public void testException() { }
```

### 9. Use Test Priority
```java
@Test(priority = 1)
public void test1() { }

@Test(priority = 2)
public void test2() { }

@Test(priority = 3)
public void test3() { }
```

### 10. Add Timeout for Long-Running Tests
```java
@Test(timeOut = 10000)  // 10 seconds
public void longRunningTest() {
    // Test code
}
```

---

## Common Maven Dependencies

```xml
<!-- TestNG -->
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.8.1</version>
    <scope>test</scope>
</dependency>

<!-- Selenium (for UI testing) -->
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.15.0</version>
    <scope>test</scope>
</dependency>

<!-- AssertJ (Fluent Assertions) -->
<dependency>
    <groupId>org.assertj</groupId>
    <artifactId>assertj-core</artifactId>
    <version>3.24.1</version>
    <scope>test</scope>
</dependency>

<!-- TestNG Reports -->
<dependency>
    <groupId>com.aventstack</groupId>
    <artifactId>extentreports</artifactId>
    <version>5.1.1</version>
    <scope>test</scope>
</dependency>
```

---

## Quick Command Reference

```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=LoginTests

# Run specific test method
mvn test -Dtest=LoginTests#validLoginTest

# Run tests in parallel
mvn test -DsuiteXmlFile=testng.xml -DparallelMode=methods -DthreadCount=4

# Generate HTML report
# (Automatically generated in test-output directory)
```

---

## Resources

- [TestNG Official Documentation](https://testng.org/)
- [TestNG GitHub Repository](https://github.com/cbeust/testng)
- [TestNG Maven Plugin](https://maven.apache.org/plugins/maven-surefire-plugin/)

---

**Last Updated:** 2026-05-14