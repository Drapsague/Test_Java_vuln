# Test Java Vulnerability Demo

This repository contains a deliberately vulnerable Java application designed for security testing and analysis.

## Security Vulnerabilities

### 1. XPath Injection (CWE-643)
**Location**: `App.java:98-105`
**Description**: User input from external file is directly concatenated into XPath query without sanitization.

**Vulnerable Code**:
```java
String query = "//users/user[login/text()='" + username + 
               "' and pass/text()='" + password + "']" +
               "/secret/text()";
String secret = (String)xPath.evaluate(query, inputXml, XPathConstants.STRING);
```

**Taint Flow**:
- **Source**: External file read from `data.txt`
- **Processing**: Data split by `||` delimiter
- **Sink**: Direct concatenation into XPath query
- **Risk**: Attacker can inject XPath expressions to bypass authentication or extract unauthorized data

### 2. Path Traversal Potential
**Location**: `App.java:9`
**Description**: Application reads from file paths that could potentially be manipulated.

### 3. Information Disclosure
**Location**: XML file contains sensitive information
**Description**: Hardcoded secrets in XML configuration file.

## Taint Analysis

The application demonstrates a clear taint flow:
1. **Tainted Source**: File input from `data.txt` (external source)
2. **Data Flow**: Input is split and processed but not sanitized
3. **Vulnerable Sink**: XPath query construction using unsanitized input
4. **Attack Vector**: Malicious input like `admin' or '1'='1` in the data file

## Building and Running

### Prerequisites
- Java 17 or higher
- Maven 3.6+

### Build
```bash
mvn clean compile
```

### Run
```bash
mvn exec:java -Dexec.mainClass="App"
```

## Security Testing

### GitHub Actions CI/CD
This project includes automated security scanning via GitHub Actions:
- **CodeQL Analysis**: Detects security vulnerabilities including XPath injection
- **Dependency Check**: Scans for vulnerable dependencies
- **Build Verification**: Ensures code compiles successfully

### Sample Attack Scenarios

1. **XPath Injection via data.txt**:
   ```
   admin' or '1'='1||password
   ```

2. **Information Disclosure**:
   - Accessing unauthorized user secrets through XPath manipulation

## Files Structure

```
src/
├── main/java/App.java          # Main vulnerable application
├── testcases/ident2/ident3.xml # XML data with user credentials
data.txt                        # Input data file
.github/workflows/ci.yml        # CI/CD with security scanning
```

## Security Remediation

To fix the vulnerabilities:
1. **Use parameterized XPath queries** or input validation
2. **Implement proper input sanitization**
3. **Use secure file handling practices**
4. **Encrypt sensitive data in configuration files**

## Disclaimer

This code is intentionally vulnerable and should only be used for:
- Security research and education
- Testing security tools
- Demonstrating vulnerability patterns

**Do not deploy this code in production environments.**