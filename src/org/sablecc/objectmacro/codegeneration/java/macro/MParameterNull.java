/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

<<<<<<< HEAD
import java.util.*;

public class MParameterNull {

  private final List<Object> ePackageDeclaration = new LinkedList<Object>();

  public MParameterNull() {
  }

  public MPackageDeclaration newPackageDeclaration(String pPackageName) {
    MPackageDeclaration lPackageDeclaration = new MPackageDeclaration(pPackageName);
    this.ePackageDeclaration.add(lPackageDeclaration);
    return lPackageDeclaration;
=======
public class MParameterNull {

  private final String pParamName;
  private final MParameterNull mParameterNull = this;

  public MParameterNull(String pParamName) {
    if(pParamName == null) throw new NullPointerException();
    this.pParamName = pParamName;
  }

  String pParamName() {
    return this.pParamName;
  }

  private String rParamName() {
    return this.mParameterNull.pParamName();
>>>>>>> object-macro2.1
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
<<<<<<< HEAD
    sb.append(new MHeader().toString());
    if(this.ePackageDeclaration.size() > 0) {
      sb.append(System.getProperty("line.separator"));
    }
    for(Object oPackageDeclaration : this.ePackageDeclaration) {
      sb.append(oPackageDeclaration.toString());
    }
    sb.append(System.getProperty("line.separator"));
    sb.append("public class MParameterNull {");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("  private final String pParamName;");
    sb.append(System.getProperty("line.separator"));
    sb.append("  private final MParameterNull mParameterNull = this;");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("  public MParameterNull(String pParamName) {");
    sb.append(System.getProperty("line.separator"));
    sb.append("    if(pParamName == null) throw new NullPointerException();");
    sb.append(System.getProperty("line.separator"));
    sb.append("    this.pParamName = pParamName;");
    sb.append(System.getProperty("line.separator"));
    sb.append("  }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("  String pParamName() {");
    sb.append(System.getProperty("line.separator"));
    sb.append("    return this.pParamName;");
    sb.append(System.getProperty("line.separator"));
    sb.append("  }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("  private String rParamName() {");
    sb.append(System.getProperty("line.separator"));
    sb.append("    return this.mParameterNull.pParamName();");
    sb.append(System.getProperty("line.separator"));
    sb.append("  }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("  @Override");
    sb.append(System.getProperty("line.separator"));
    sb.append("  public String toString() {");
    sb.append(System.getProperty("line.separator"));
    sb.append("    StringBuilder sb = new StringBuilder();");
    sb.append(System.getProperty("line.separator"));
    sb.append("    sb.append(\"Parameter '\");");
    sb.append(System.getProperty("line.separator"));
    sb.append("    sb.append(rParamName());");
    sb.append(System.getProperty("line.separator"));
    sb.append("    sb.append(\"' cannot be null.\");");
    sb.append(System.getProperty("line.separator"));
    sb.append("    sb.append(System.getProperty(\"line.separator\"));");
    sb.append(System.getProperty("line.separator"));
    sb.append("    return sb.toString();");
    sb.append(System.getProperty("line.separator"));
    sb.append("  }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("}");
    sb.append(System.getProperty("line.separator"));
=======
    sb.append("Parameter '");
    sb.append(rParamName());
    sb.append("' cannot be null.");
>>>>>>> object-macro2.1
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }

}
