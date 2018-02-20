/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

import java.util.*;

public class MConstructor {

  private final String pName;
  private final MConstructor mConstructor = this;
<<<<<<< HEAD
<<<<<<< HEAD
  private final List<Object> eStringParam = new LinkedList<Object>();
  private final List<Object> eSetParam = new LinkedList<Object>();
  private final List<Object> eInitMacroParam_InitMacroInternal_InitStringInternal = new LinkedList<Object>();
<<<<<<< HEAD
<<<<<<< HEAD
  private final List<Object> eInitInternalValue = new LinkedList<Object>();
=======
  private final List<Object> eStringParam_MacroParam = new LinkedList<Object>();
=======
  private final List<Object> eStringParam = new LinkedList<Object>();
>>>>>>> Removed in constructor initialization and add lazy initialization
  private final List<Object> eSetParam = new LinkedList<Object>();
  private final List<Object> eInitMacroInternal_InitStringInternal = new LinkedList<Object>();
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
>>>>>>> Init internals before building the macro instead at the add or addAll methods
=======
  private final List<Object> eInitInternalValue = new LinkedList<Object>();
>>>>>>> Add structure which contains list of macros and the context associated

  public MConstructor(String pName) {
    if(pName == null) throw new NullPointerException();
    this.pName = pName;
  }

  public MStringParam newStringParam(String pName) {
    MStringParam lStringParam = new MStringParam(pName);
<<<<<<< HEAD
<<<<<<< HEAD
    this.eStringParam.add(lStringParam);
    return lStringParam;
  }

=======
    this.eStringParam_MacroParam.add(lStringParam);
    return lStringParam;
  }

  public MMacroParam newMacroParam(String pName) {
    MMacroParam lMacroParam = new MMacroParam(pName);
    this.eStringParam_MacroParam.add(lMacroParam);
    return lMacroParam;
  }

>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
    this.eStringParam.add(lStringParam);
    return lStringParam;
  }

>>>>>>> Removed in constructor initialization and add lazy initialization
  public MSetParam newSetParam(String pName) {
    MSetParam lSetParam = new MSetParam(pName);
    this.eSetParam.add(lSetParam);
    return lSetParam;
  }

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Init internals before building the macro instead at the add or addAll methods
  public MInitMacroParam newInitMacroParam(String pName) {
    MInitMacroParam lInitMacroParam = new MInitMacroParam(pName);
    this.eInitMacroParam_InitMacroInternal_InitStringInternal.add(lInitMacroParam);
    return lInitMacroParam;
  }

<<<<<<< HEAD
  public MInitMacroInternal newInitMacroInternal(String pName) {
    MInitMacroInternal lInitMacroInternal = new MInitMacroInternal(pName);
    this.eInitMacroParam_InitMacroInternal_InitStringInternal.add(lInitMacroInternal);
=======
  public MInitMacroInternal newInitMacroInternal(String pName) {
    MInitMacroInternal lInitMacroInternal = new MInitMacroInternal(pName);
    this.eInitMacroInternal_InitStringInternal.add(lInitMacroInternal);
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
  public MInitMacroInternal newInitMacroInternal(String pName) {
    MInitMacroInternal lInitMacroInternal = new MInitMacroInternal(pName);
    this.eInitMacroParam_InitMacroInternal_InitStringInternal.add(lInitMacroInternal);
>>>>>>> Init internals before building the macro instead at the add or addAll methods
    return lInitMacroInternal;
  }

  public MInitStringInternal newInitStringInternal(String pName) {
    MInitStringInternal lInitStringInternal = new MInitStringInternal(pName);
<<<<<<< HEAD
<<<<<<< HEAD
    this.eInitMacroParam_InitMacroInternal_InitStringInternal.add(lInitStringInternal);
    return lInitStringInternal;
  }

  public MInitInternalValue newInitInternalValue(String pParamName) {
    MInitInternalValue lInitInternalValue = new MInitInternalValue(pParamName);
    this.eInitInternalValue.add(lInitInternalValue);
    return lInitInternalValue;
  }

=======
    this.eInitMacroInternal_InitStringInternal.add(lInitStringInternal);
=======
    this.eInitMacroParam_InitMacroInternal_InitStringInternal.add(lInitStringInternal);
>>>>>>> Init internals before building the macro instead at the add or addAll methods
    return lInitStringInternal;
  }

<<<<<<< HEAD
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
  public MInitInternalValue newInitInternalValue(String pParamName) {
    MInitInternalValue lInitInternalValue = new MInitInternalValue(pParamName);
    this.eInitInternalValue.add(lInitInternalValue);
    return lInitInternalValue;
  }

>>>>>>> Add structure which contains list of macros and the context associated
  String pName() {
    return this.pName;
  }

  private String rName() {
    return this.mConstructor.pName();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("    public M");
    sb.append(rName());
    sb.append("(");
    {
      boolean first = true;
<<<<<<< HEAD
<<<<<<< HEAD
      for(Object oStringParam : this.eStringParam) {
=======
      for(Object oStringParam_MacroParam : this.eStringParam_MacroParam) {
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
      for(Object oStringParam : this.eStringParam) {
>>>>>>> Removed in constructor initialization and add lazy initialization
        if(first) {
          first = false;
        }
        else {
          sb.append(", ");
        }
<<<<<<< HEAD
<<<<<<< HEAD
        sb.append(oStringParam.toString());
=======
        sb.append(oStringParam_MacroParam.toString());
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
        sb.append(oStringParam.toString());
>>>>>>> Removed in constructor initialization and add lazy initialization
      }
    }
    sb.append("){");
    sb.append(System.getProperty("line.separator"));
    if(this.eSetParam.size() > 0) {
      sb.append(System.getProperty("line.separator"));
    }
    for(Object oSetParam : this.eSetParam) {
      sb.append(oSetParam.toString());
    }
<<<<<<< HEAD
<<<<<<< HEAD
    if(this.eInitMacroParam_InitMacroInternal_InitStringInternal.size() > 0) {
      sb.append(System.getProperty("line.separator"));
    }
    for(Object oInitMacroParam_InitMacroInternal_InitStringInternal : this.eInitMacroParam_InitMacroInternal_InitStringInternal) {
      sb.append(oInitMacroParam_InitMacroInternal_InitStringInternal.toString());
    }
    if(this.eInitInternalValue.size() > 0) {
      sb.append(System.getProperty("line.separator"));
    }
    for(Object oInitInternalValue : this.eInitInternalValue) {
      sb.append(oInitInternalValue.toString());
=======
    if(this.eInitMacroInternal_InitStringInternal.size() > 0) {
      sb.append(System.getProperty("line.separator"));
    }
    for(Object oInitMacroInternal_InitStringInternal : this.eInitMacroInternal_InitStringInternal) {
      sb.append(oInitMacroInternal_InitStringInternal.toString());
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
    if(this.eInitMacroParam_InitMacroInternal_InitStringInternal.size() > 0) {
      sb.append(System.getProperty("line.separator"));
    }
    for(Object oInitMacroParam_InitMacroInternal_InitStringInternal : this.eInitMacroParam_InitMacroInternal_InitStringInternal) {
      sb.append(oInitMacroParam_InitMacroInternal_InitStringInternal.toString());
>>>>>>> Init internals before building the macro instead at the add or addAll methods
    }
    if(this.eInitInternalValue.size() > 0) {
      sb.append(System.getProperty("line.separator"));
    }
    for(Object oInitInternalValue : this.eInitInternalValue) {
      sb.append(oInitInternalValue.toString());
    }
    sb.append("    }");
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }

}
