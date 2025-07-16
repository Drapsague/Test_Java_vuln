/**
 * @name Custom XPath Injection
 * @description Detects possible XPath injection in Java code
 * @kind problem
 * @problem.severity error
 * @id custom/java/xpath-injection
 */

import java

from MethodAccess ma
where ma.getMethod().hasName("evaluate")
  and ma.getMethod().getDeclaringType().getASupertype*().hasQualifiedName("javax.xml.xpath", "XPath")
  and
    // VERY basic: check if argument involves concatenation with a variable
    exists(Addition add | ma.getArgument(0) = add and add.getLeftOperand() instanceof VariableAccess)
select ma, "Possible XPath injection: dynamic argument to evaluate()"
