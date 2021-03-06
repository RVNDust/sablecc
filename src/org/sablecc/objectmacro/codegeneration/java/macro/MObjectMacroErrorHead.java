/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

import java.util.*;

public class MObjectMacroErrorHead {

  private final List<Object> ePackageDeclaration = new LinkedList<Object>();

  public MObjectMacroErrorHead() {
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
    sb.append("class MObjectMacroErrorHead {");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("  MObjectMacroErrorHead() {");
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
    sb.append("    sb.append(\"*** OBJECT MACRO ERROR ***\");");
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