package org.sablecc.objectmacro.codegeneration.java.macro;

<<<<<<< HEAD
import java.util.*;

public class MIncorrectType {

  private final List<Object> ePackageDeclaration = new LinkedList<Object>();

  public MIncorrectType() {
  }

  public MPackageDeclaration newPackageDeclaration(String pPackageName) {
    MPackageDeclaration lPackageDeclaration = new MPackageDeclaration(pPackageName);
    this.ePackageDeclaration.add(lPackageDeclaration);
    return lPackageDeclaration;
=======
public class MIncorrectType {

  private final String pType;
  private final String pParamName;
  private final MIncorrectType mIncorrectType = this;

  public MIncorrectType(String pType, String pParamName) {
    if(pType == null) throw new NullPointerException();
    this.pType = pType;
    if(pParamName == null) throw new NullPointerException();
    this.pParamName = pParamName;
  }

  String pType() {
    return this.pType;
  }

  String pParamName() {
    return this.pParamName;
  }

  private String rType() {
    return this.mIncorrectType.pType();
  }

  private String rParamName() {
    return this.mIncorrectType.pParamName();
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
    sb.append("public class MIncorrectType {");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("  private final String pType;");
    sb.append(System.getProperty("line.separator"));
    sb.append("  private final String pParamName;");
    sb.append(System.getProperty("line.separator"));
    sb.append("  private final MIncorrectType mIncorrectType = this;");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("  public MIncorrectType(String pType, String pParamName) {");
    sb.append(System.getProperty("line.separator"));
    sb.append("    if(pType == null) throw new NullPointerException();");
    sb.append(System.getProperty("line.separator"));
    sb.append("    this.pType = pType;");
    sb.append(System.getProperty("line.separator"));
    sb.append("    if(pParamName == null) throw new NullPointerException();");
    sb.append(System.getProperty("line.separator"));
    sb.append("    this.pParamName = pParamName;");
    sb.append(System.getProperty("line.separator"));
    sb.append("  }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("  String pType() {");
    sb.append(System.getProperty("line.separator"));
    sb.append("    return this.pType;");
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
    sb.append("  private String rType() {");
    sb.append(System.getProperty("line.separator"));
    sb.append("    return this.mIncorrectType.pType();");
    sb.append(System.getProperty("line.separator"));
    sb.append("  }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("  private String rParamName() {");
    sb.append(System.getProperty("line.separator"));
    sb.append("    return this.mIncorrectType.pParamName();");
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
    sb.append("    sb.append(new MObjectMacroErrorHead().toString());");
    sb.append(System.getProperty("line.separator"));
    sb.append("    sb.append(System.getProperty(\"line.separator\"));");
    sb.append(System.getProperty("line.separator"));
    sb.append("    sb.append(rType());");
    sb.append(System.getProperty("line.separator"));
    sb.append("    sb.append(\" was not expected in parameter '\");");
    sb.append(System.getProperty("line.separator"));
    sb.append("    sb.append(rParamName());");
    sb.append(System.getProperty("line.separator"));
    sb.append("    sb.append(\"'.\");");
    sb.append(System.getProperty("line.separator"));
    sb.append("    sb.append(System.getProperty(\"line.separator\"));");
    sb.append(System.getProperty("line.separator"));
    sb.append("    return sb.toString();");
    sb.append(System.getProperty("line.separator"));
    sb.append("  }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("}");
=======
    sb.append(new MObjectMacroErrorHead().toString());
    sb.append(System.getProperty("line.separator"));
    sb.append(rType());
    sb.append(" was not expected in parameter '");
    sb.append(rParamName());
    sb.append("'.");
>>>>>>> object-macro2.1
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }

}