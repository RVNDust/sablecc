/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

import java.util.*;

public class MMacroNullInList {

  private final List<Object> ePackageDeclaration = new LinkedList<Object>();

  public MMacroNullInList() {
  }

  public MPackageDeclaration newPackageDeclaration(String pPackageName) {
    MPackageDeclaration lPackageDeclaration = new MPackageDeclaration(pPackageName);
    this.ePackageDeclaration.add(lPackageDeclaration);
    return lPackageDeclaration;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(new MHeader().toString());
    if(this.ePackageDeclaration.size() > 0) {
      sb.append(System.getProperty("line.separator"));
    }
    for(Object oPackageDeclaration : this.ePackageDeclaration) {
      sb.append(oPackageDeclaration.toString());
    }
    sb.append(System.getProperty("line.separator"));
    sb.append("public class MMacroNullInList {");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("  private final String pIndex;");
    sb.append(System.getProperty("line.separator"));
    sb.append("  private final String pParamName;");
    sb.append(System.getProperty("line.separator"));
    sb.append("  private final MMacroNullInList mMacroNullInList = this;");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("  public MMacroNullInList(String pIndex, String pParamName) {");
    sb.append(System.getProperty("line.separator"));
    sb.append("    if(pIndex == null) throw new NullPointerException();");
    sb.append(System.getProperty("line.separator"));
    sb.append("    this.pIndex = pIndex;");
    sb.append(System.getProperty("line.separator"));
    sb.append("    if(pParamName == null) throw new NullPointerException();");
    sb.append(System.getProperty("line.separator"));
    sb.append("    this.pParamName = pParamName;");
    sb.append(System.getProperty("line.separator"));
    sb.append("  }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("  String pIndex() {");
    sb.append(System.getProperty("line.separator"));
    sb.append("    return this.pIndex;");
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
    sb.append("  private String rIndex() {");
    sb.append(System.getProperty("line.separator"));
    sb.append("    return this.mMacroNullInList.pIndex();");
    sb.append(System.getProperty("line.separator"));
    sb.append("  }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("  private String rParamName() {");
    sb.append(System.getProperty("line.separator"));
    sb.append("    return this.mMacroNullInList.pParamName();");
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
    sb.append("    sb.append(\"A macro is null at index \");");
    sb.append(System.getProperty("line.separator"));
    sb.append("    sb.append(rIndex());");
    sb.append(System.getProperty("line.separator"));
    sb.append("    sb.append(\" in the list '\");");
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
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }

}