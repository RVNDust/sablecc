/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

<<<<<<< HEAD
import java.util.*;

public class MCyclicReference {

  private final List<Object> ePackageDeclaration = new LinkedList<Object>();

  public MCyclicReference() {
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
    sb.append("public class MCyclicReference {");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("  private final String pMacroName;");
    sb.append(System.getProperty("line.separator"));
    sb.append("  private final MCyclicReference mCyclicReference = this;");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("  public MCyclicReference(String pMacroName) {");
    sb.append(System.getProperty("line.separator"));
    sb.append("    if(pMacroName == null) throw new NullPointerException();");
    sb.append(System.getProperty("line.separator"));
    sb.append("    this.pMacroName = pMacroName;");
    sb.append(System.getProperty("line.separator"));
    sb.append("  }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("  String pMacroName() {");
    sb.append(System.getProperty("line.separator"));
    sb.append("    return this.pMacroName;");
    sb.append(System.getProperty("line.separator"));
    sb.append("  }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("  private String rMacroName() {");
    sb.append(System.getProperty("line.separator"));
    sb.append("    return this.mCyclicReference.pMacroName();");
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
    sb.append("    sb.append(\"An instance of \\\"\");");
    sb.append(System.getProperty("line.separator"));
    sb.append("    sb.append(rMacroName());");
    sb.append(System.getProperty("line.separator"));
    sb.append("    sb.append(\"\\\" is a cyclic reference to the same instance.\");");
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

=======
public class MCyclicReference {

  private final String pMacroName;
  private final MCyclicReference mCyclicReference = this;

  public MCyclicReference(String pMacroName) {
    if(pMacroName == null) throw new NullPointerException();
    this.pMacroName = pMacroName;
  }

  String pMacroName() {
    return this.pMacroName;
  }

  private String rMacroName() {
    return this.mCyclicReference.pMacroName();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(new MObjectMacroErrorHead().toString());
    sb.append(System.getProperty("line.separator"));
    sb.append("An instance of \"");
    sb.append(rMacroName());
    sb.append("\" is a cyclic reference to the same instance.");
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }

<<<<<<< HEAD
>>>>>>> Mise à jour Visiteur - Build OK
}
=======
}
>>>>>>> Correctifs objectmacro2-java(back)
