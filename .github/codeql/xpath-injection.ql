/**
 * @name XPath Injection via String Concatenation
 * @description Detects XPath injection vulnerabilities where user input is directly concatenated into XPath expressions
 * @kind path-problem
 * @problem.severity error
 * @security-severity 8.5
 * @precision high
 * @id java/xpath-injection-string-concat
 * @tags security
 *       external/cwe/cwe-643
 */

import java
import semmle.code.java.dataflow.TaintTracking
import semmle.code.java.security.XPath

/**
 * A taint-tracking configuration for XPath injection vulnerabilities.
 */
class XPathInjectionConfig extends TaintTracking::Configuration {
  override predicate isSource(DataFlow::Node source) {
    // File input sources
    exists(MethodAccess ma |
      ma.getMethod().hasName("readLine") and
      source.asExpr() = ma
    )
    or
    // Command line arguments
    exists(Parameter p |
      p.getType().(Array).getElementType().(RefType).hasQualifiedName("java.lang", "String") and
      source.asParameter() = p
    )
  }

  override predicate isSink(DataFlow::Node sink) {
    // XPath evaluation methods
    exists(MethodAccess ma |
      ma.getMethod().hasName("evaluate") and
      ma.getMethod().getDeclaringType().getASupertype*().hasQualifiedName("javax.xml.xpath", "XPath") and
      sink.asExpr() = ma.getArgument(0)
    )
  }

  override predicate isSanitizer(DataFlow::Node node) {
    // Add sanitization logic here if needed
    none()
  }
}

from XPathInjectionConfig config, DataFlow::PathNode source, DataFlow::PathNode sink
where config.hasFlowPath(source, sink)
select sink.getNode(), source, sink, "XPath expression may be tainted by $@.", source.getNode(), "user input"
