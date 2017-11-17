/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

import java.util.*;

public class MSetInternal {

  private final String pMacroName;
  private final String pParamName;
  private final String pContext;
  private final MSetInternal mSetInternal = this;
<<<<<<< HEAD
<<<<<<< HEAD
  private final List<Object> eParamRef_StringBuilderBuild = new LinkedList<Object>();
=======
  private final List<Object> eMacroArg_StringBuilderBuild = new LinkedList<Object>();
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
  private final List<Object> eParamRef_StringBuilderBuild = new LinkedList<Object>();
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name

  public MSetInternal(String pMacroName, String pParamName, String pContext) {
    if(pMacroName == null) throw new NullPointerException();
    this.pMacroName = pMacroName;
    if(pParamName == null) throw new NullPointerException();
    this.pParamName = pParamName;
    if(pContext == null) throw new NullPointerException();
    this.pContext = pContext;
  }

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
  public MParamRef newParamRef(String pName) {
    MParamRef lParamRef = new MParamRef(pName);
    this.eParamRef_StringBuilderBuild.add(lParamRef);
    return lParamRef;
<<<<<<< HEAD
=======
  public MMacroArg newMacroArg(String pName) {
    MMacroArg lMacroArg = new MMacroArg(pName);
    this.eMacroArg_StringBuilderBuild.add(lMacroArg);
    return lMacroArg;
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
  }

  public MStringBuilderBuild newStringBuilderBuild(String pIndexBuilder) {
    MStringBuilderBuild lStringBuilderBuild = new MStringBuilderBuild(pIndexBuilder);
<<<<<<< HEAD
<<<<<<< HEAD
    this.eParamRef_StringBuilderBuild.add(lStringBuilderBuild);
=======
    this.eMacroArg_StringBuilderBuild.add(lStringBuilderBuild);
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
    this.eParamRef_StringBuilderBuild.add(lStringBuilderBuild);
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
    return lStringBuilderBuild;
  }

  String pMacroName() {
    return this.pMacroName;
  }

  String pParamName() {
    return this.pParamName;
  }

  String pContext() {
    return this.pContext;
  }

  private String rMacroName() {
    return this.mSetInternal.pMacroName();
  }

  private String rParamName() {
    return this.mSetInternal.pParamName();
  }

  private String rContext() {
    return this.mSetInternal.pContext();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("        m");
    sb.append(rMacroName());
    sb.append(".set");
    sb.append(rParamName());
    sb.append("(");
    sb.append(rContext());
    sb.append(", ");
<<<<<<< HEAD
<<<<<<< HEAD
    for(Object oParamRef_StringBuilderBuild : this.eParamRef_StringBuilderBuild) {
      sb.append(oParamRef_StringBuilderBuild.toString());
=======
    for(Object oMacroArg_StringBuilderBuild : this.eMacroArg_StringBuilderBuild) {
      sb.append(oMacroArg_StringBuilderBuild.toString());
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
    for(Object oParamRef_StringBuilderBuild : this.eParamRef_StringBuilderBuild) {
      sb.append(oParamRef_StringBuilderBuild.toString());
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
    }
    sb.append(");");
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }

}
