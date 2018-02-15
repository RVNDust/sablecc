/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

import java.util.*;

public class MMacro {

  private final String pName;
  private final MMacro mMacro = this;
  private final List<Object> ePackageDeclaration = new LinkedList<Object>();
  private final List<Object> eImportJavaUtil = new LinkedList<Object>();
<<<<<<< HEAD
  private final List<Object> eParamMacroField_ParamStringField_InternalMacroField_InternalStringField_InternalMacrosValueField_DirectivesField_NoneDirectiveField = new LinkedList<Object>();
  private final List<Object> eContextField = new LinkedList<Object>();
  private final List<Object> eConstructor = new LinkedList<Object>();
  private final List<Object> eParamStringSetter_AddAll_SingleAdd_InternalStringSetter_InternalMacroSetter = new LinkedList<Object>();
  private final List<Object> eParamStringRefBuilder_ParamMacroRefBuilder_InternalMacroRefBuilder = new LinkedList<Object>();
  private final List<Object> eParamStringRef_ParamMacroRef_InternalMacroRef = new LinkedList<Object>();
  private final List<Object> eInitInternalsMethod = new LinkedList<Object>();
  private final List<Object> eInitDirectives = new LinkedList<Object>();
  private final List<Object> eRedefinedApplyInitializer = new LinkedList<Object>();
  private final List<Object> eMacroBuilder = new LinkedList<Object>();
  private final List<Object> eEmptyBuilderWithContext = new LinkedList<Object>();
=======
  private final List<Object> eParamMacroField_ParamStringField_InternalMacroField_InternalStringField = new LinkedList<Object>();
  private final List<Object> eContextField = new LinkedList<Object>();
  private final List<Object> eConstructor = new LinkedList<Object>();
  private final List<Object> eParamStringSetter_AddAll_SingleAdd_InternalStringSetter_InternalMacroSetter = new LinkedList<Object>();
  private final List<Object> eParamStringRefBuilder_ParamMacroRefBuilder = new LinkedList<Object>();
  private final List<Object> eParamStringRef_ParamMacroRef = new LinkedList<Object>();
  private final List<Object> eRedefinedApplyInitializer = new LinkedList<Object>();
  private final List<Object> eMacroBuilder = new LinkedList<Object>();
<<<<<<< HEAD
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
  private final List<Object> eEmptyBuilderWithContext = new LinkedList<Object>();
>>>>>>> Now macro without internals has a builder with context that only return build

  public MMacro(String pName) {
    if(pName == null) throw new NullPointerException();
    this.pName = pName;
  }

  public MPackageDeclaration newPackageDeclaration(String pPackageName) {
    MPackageDeclaration lPackageDeclaration = new MPackageDeclaration(pPackageName);
    this.ePackageDeclaration.add(lPackageDeclaration);
    return lPackageDeclaration;
  }

  public MImportJavaUtil newImportJavaUtil() {
    MImportJavaUtil lImportJavaUtil = new MImportJavaUtil();
    this.eImportJavaUtil.add(lImportJavaUtil);
    return lImportJavaUtil;
  }

  public MParamMacroField newParamMacroField(String pName) {
    MParamMacroField lParamMacroField = new MParamMacroField(pName);
<<<<<<< HEAD
    this.eParamMacroField_ParamStringField_InternalMacroField_InternalStringField_InternalMacrosValueField_DirectivesField_NoneDirectiveField.add(lParamMacroField);
=======
    this.eParamMacroField_ParamStringField_InternalMacroField_InternalStringField.add(lParamMacroField);
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
    return lParamMacroField;
  }

  public MParamStringField newParamStringField(String pName) {
    MParamStringField lParamStringField = new MParamStringField(pName);
<<<<<<< HEAD
    this.eParamMacroField_ParamStringField_InternalMacroField_InternalStringField_InternalMacrosValueField_DirectivesField_NoneDirectiveField.add(lParamStringField);
=======
    this.eParamMacroField_ParamStringField_InternalMacroField_InternalStringField.add(lParamStringField);
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
    return lParamStringField;
  }

  public MInternalMacroField newInternalMacroField(String pName) {
    MInternalMacroField lInternalMacroField = new MInternalMacroField(pName);
<<<<<<< HEAD
    this.eParamMacroField_ParamStringField_InternalMacroField_InternalStringField_InternalMacrosValueField_DirectivesField_NoneDirectiveField.add(lInternalMacroField);
=======
    this.eParamMacroField_ParamStringField_InternalMacroField_InternalStringField.add(lInternalMacroField);
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
    return lInternalMacroField;
  }

  public MInternalStringField newInternalStringField(String pName) {
    MInternalStringField lInternalStringField = new MInternalStringField(pName);
<<<<<<< HEAD
    this.eParamMacroField_ParamStringField_InternalMacroField_InternalStringField_InternalMacrosValueField_DirectivesField_NoneDirectiveField.add(lInternalStringField);
    return lInternalStringField;
  }

  public MInternalMacrosValueField newInternalMacrosValueField(String pParamName) {
    MInternalMacrosValueField lInternalMacrosValueField = new MInternalMacrosValueField(pParamName);
    this.eParamMacroField_ParamStringField_InternalMacroField_InternalStringField_InternalMacrosValueField_DirectivesField_NoneDirectiveField.add(lInternalMacrosValueField);
    return lInternalMacrosValueField;
  }

  public MDirectivesField newDirectivesField(String pParamName) {
    MDirectivesField lDirectivesField = new MDirectivesField(pParamName);
    this.eParamMacroField_ParamStringField_InternalMacroField_InternalStringField_InternalMacrosValueField_DirectivesField_NoneDirectiveField.add(lDirectivesField);
    return lDirectivesField;
  }

  public MNoneDirectiveField newNoneDirectiveField(String pParamName) {
    MNoneDirectiveField lNoneDirectiveField = new MNoneDirectiveField(pParamName);
    this.eParamMacroField_ParamStringField_InternalMacroField_InternalStringField_InternalMacrosValueField_DirectivesField_NoneDirectiveField.add(lNoneDirectiveField);
    return lNoneDirectiveField;
  }

=======
    this.eParamMacroField_ParamStringField_InternalMacroField_InternalStringField.add(lInternalStringField);
    return lInternalStringField;
  }

>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
  public MContextField newContextField(String pName) {
    MContextField lContextField = new MContextField(pName);
    this.eContextField.add(lContextField);
    return lContextField;
  }

  public MConstructor newConstructor(String pName) {
    MConstructor lConstructor = new MConstructor(pName);
    this.eConstructor.add(lConstructor);
    return lConstructor;
  }

  public MParamStringSetter newParamStringSetter(String pName) {
    MParamStringSetter lParamStringSetter = new MParamStringSetter(pName);
<<<<<<< HEAD
<<<<<<< HEAD
    this.eParamStringSetter_AddAll_SingleAdd_InternalStringSetter_InternalMacroSetter.add(lParamStringSetter);
    return lParamStringSetter;
  }

  public MAddAll newAddAll(String pParamName) {
    MAddAll lAddAll = new MAddAll(pParamName);
    this.eParamStringSetter_AddAll_SingleAdd_InternalStringSetter_InternalMacroSetter.add(lAddAll);
    return lAddAll;
  }

  public MSingleAdd newSingleAdd(String pMacroName, String pParamName) {
    MSingleAdd lSingleAdd = new MSingleAdd(pMacroName, pParamName);
    this.eParamStringSetter_AddAll_SingleAdd_InternalStringSetter_InternalMacroSetter.add(lSingleAdd);
    return lSingleAdd;
=======
    this.eParamStringSetter_ParamMacroSetter_InternalStringSetter_InternalMacroSetter.add(lParamStringSetter);
    return lParamStringSetter;
  }

  public MParamMacroSetter newParamMacroSetter(String pParamName, String pMacroName) {
    MParamMacroSetter lParamMacroSetter = new MParamMacroSetter(pParamName, pMacroName);
    this.eParamStringSetter_ParamMacroSetter_InternalStringSetter_InternalMacroSetter.add(lParamMacroSetter);
    return lParamMacroSetter;
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
    this.eParamStringSetter_AddAll_SingleAdd_InternalStringSetter_InternalMacroSetter.add(lParamStringSetter);
    return lParamStringSetter;
  }

  public MAddAll newAddAll(String pParamName) {
    MAddAll lAddAll = new MAddAll(pParamName);
    this.eParamStringSetter_AddAll_SingleAdd_InternalStringSetter_InternalMacroSetter.add(lAddAll);
    return lAddAll;
  }

  public MSingleAdd newSingleAdd(String pMacroName, String pParamName) {
    MSingleAdd lSingleAdd = new MSingleAdd(pMacroName, pParamName);
    this.eParamStringSetter_AddAll_SingleAdd_InternalStringSetter_InternalMacroSetter.add(lSingleAdd);
    return lSingleAdd;
>>>>>>> AddAll and single adds with static overloads
  }

  public MInternalStringSetter newInternalStringSetter(String pName) {
    MInternalStringSetter lInternalStringSetter = new MInternalStringSetter(pName);
<<<<<<< HEAD
<<<<<<< HEAD
    this.eParamStringSetter_AddAll_SingleAdd_InternalStringSetter_InternalMacroSetter.add(lInternalStringSetter);
    return lInternalStringSetter;
  }

  public MInternalMacroSetter newInternalMacroSetter(String pParamName) {
    MInternalMacroSetter lInternalMacroSetter = new MInternalMacroSetter(pParamName);
    this.eParamStringSetter_AddAll_SingleAdd_InternalStringSetter_InternalMacroSetter.add(lInternalMacroSetter);
    return lInternalMacroSetter;
  }

  public MParamStringRefBuilder newParamStringRefBuilder(String pName) {
    MParamStringRefBuilder lParamStringRefBuilder = new MParamStringRefBuilder(pName);
    this.eParamStringRefBuilder_ParamMacroRefBuilder_InternalMacroRefBuilder.add(lParamStringRefBuilder);
    return lParamStringRefBuilder;
  }

  public MParamMacroRefBuilder newParamMacroRefBuilder(String pName, String pIndexBuilder) {
    MParamMacroRefBuilder lParamMacroRefBuilder = new MParamMacroRefBuilder(pName, pIndexBuilder);
    this.eParamStringRefBuilder_ParamMacroRefBuilder_InternalMacroRefBuilder.add(lParamMacroRefBuilder);
    return lParamMacroRefBuilder;
  }

  public MInternalMacroRefBuilder newInternalMacroRefBuilder(String pInternalName) {
    MInternalMacroRefBuilder lInternalMacroRefBuilder = new MInternalMacroRefBuilder(pInternalName);
    this.eParamStringRefBuilder_ParamMacroRefBuilder_InternalMacroRefBuilder.add(lInternalMacroRefBuilder);
    return lInternalMacroRefBuilder;
  }

  public MParamStringRef newParamStringRef(String pName) {
    MParamStringRef lParamStringRef = new MParamStringRef(pName);
    this.eParamStringRef_ParamMacroRef_InternalMacroRef.add(lParamStringRef);
    return lParamStringRef;
  }

  public MParamMacroRef newParamMacroRef(String pName) {
    MParamMacroRef lParamMacroRef = new MParamMacroRef(pName);
    this.eParamStringRef_ParamMacroRef_InternalMacroRef.add(lParamMacroRef);
    return lParamMacroRef;
  }

  public MInternalMacroRef newInternalMacroRef(String pParamName) {
    MInternalMacroRef lInternalMacroRef = new MInternalMacroRef(pParamName);
    this.eParamStringRef_ParamMacroRef_InternalMacroRef.add(lInternalMacroRef);
    return lInternalMacroRef;
  }

  public MInitInternalsMethod newInitInternalsMethod(String pName) {
    MInitInternalsMethod lInitInternalsMethod = new MInitInternalsMethod(pName);
    this.eInitInternalsMethod.add(lInitInternalsMethod);
    return lInitInternalsMethod;
  }

  public MInitDirectives newInitDirectives(String pParamName) {
    MInitDirectives lInitDirectives = new MInitDirectives(pParamName);
    this.eInitDirectives.add(lInitDirectives);
    return lInitDirectives;
  }

=======
    this.eParamStringSetter_ParamMacroSetter_InternalStringSetter_InternalMacroSetter.add(lInternalStringSetter);
=======
    this.eParamStringSetter_AddAll_SingleAdd_InternalStringSetter_InternalMacroSetter.add(lInternalStringSetter);
>>>>>>> AddAll and single adds with static overloads
    return lInternalStringSetter;
  }

  public MInternalMacroSetter newInternalMacroSetter(String pParamName) {
    MInternalMacroSetter lInternalMacroSetter = new MInternalMacroSetter(pParamName);
    this.eParamStringSetter_AddAll_SingleAdd_InternalStringSetter_InternalMacroSetter.add(lInternalMacroSetter);
    return lInternalMacroSetter;
  }

  public MParamStringRefBuilder newParamStringRefBuilder(String pName) {
    MParamStringRefBuilder lParamStringRefBuilder = new MParamStringRefBuilder(pName);
    this.eParamStringRefBuilder_ParamMacroRefBuilder.add(lParamStringRefBuilder);
    return lParamStringRefBuilder;
  }

  public MParamMacroRefBuilder newParamMacroRefBuilder(String pName, String pIndexBuilder) {
    MParamMacroRefBuilder lParamMacroRefBuilder = new MParamMacroRefBuilder(pName, pIndexBuilder);
    this.eParamStringRefBuilder_ParamMacroRefBuilder.add(lParamMacroRefBuilder);
    return lParamMacroRefBuilder;
  }

  public MParamStringRef newParamStringRef(String pName) {
    MParamStringRef lParamStringRef = new MParamStringRef(pName);
    this.eParamStringRef_ParamMacroRef.add(lParamStringRef);
    return lParamStringRef;
  }

  public MParamMacroRef newParamMacroRef(String pName) {
    MParamMacroRef lParamMacroRef = new MParamMacroRef(pName);
    this.eParamStringRef_ParamMacroRef.add(lParamMacroRef);
    return lParamMacroRef;
  }

<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
  public MInitInternalsMethod newInitInternalsMethod(String pName) {
    MInitInternalsMethod lInitInternalsMethod = new MInitInternalsMethod(pName);
    this.eInitInternalsMethod.add(lInitInternalsMethod);
    return lInitInternalsMethod;
  }

>>>>>>> Init internals before building the macro instead at the add or addAll methods
=======
>>>>>>> AddAll and single adds with static overloads
  public MRedefinedApplyInitializer newRedefinedApplyInitializer(String pName) {
    MRedefinedApplyInitializer lRedefinedApplyInitializer = new MRedefinedApplyInitializer(pName);
    this.eRedefinedApplyInitializer.add(lRedefinedApplyInitializer);
    return lRedefinedApplyInitializer;
  }

<<<<<<< HEAD
  public MMacroBuilder newMacroBuilder(String pMacroName) {
    MMacroBuilder lMacroBuilder = new MMacroBuilder(pMacroName);
=======
  public MMacroBuilder newMacroBuilder() {
    MMacroBuilder lMacroBuilder = new MMacroBuilder();
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
    this.eMacroBuilder.add(lMacroBuilder);
    return lMacroBuilder;
  }

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Now macro without internals has a builder with context that only return build
  public MEmptyBuilderWithContext newEmptyBuilderWithContext() {
    MEmptyBuilderWithContext lEmptyBuilderWithContext = new MEmptyBuilderWithContext();
    this.eEmptyBuilderWithContext.add(lEmptyBuilderWithContext);
    return lEmptyBuilderWithContext;
  }

<<<<<<< HEAD
=======
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
>>>>>>> Now macro without internals has a builder with context that only return build
  String pName() {
    return this.pName;
  }

  private String rName() {
    return this.mMacro.pName();
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
    if(this.eImportJavaUtil.size() > 0) {
      sb.append(System.getProperty("line.separator"));
    }
    for(Object oImportJavaUtil : this.eImportJavaUtil) {
      sb.append(oImportJavaUtil.toString());
    }
    sb.append(System.getProperty("line.separator"));
    sb.append("public class M");
    sb.append(rName());
    sb.append(" extends Macro{");
    sb.append(System.getProperty("line.separator"));
<<<<<<< HEAD
    if(this.eParamMacroField_ParamStringField_InternalMacroField_InternalStringField_InternalMacrosValueField_DirectivesField_NoneDirectiveField.size() > 0) {
=======
    if(this.eParamMacroField_ParamStringField_InternalMacroField_InternalStringField.size() > 0) {
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
      sb.append(System.getProperty("line.separator"));
    }
    {
      boolean first = true;
<<<<<<< HEAD
      for(Object oParamMacroField_ParamStringField_InternalMacroField_InternalStringField_InternalMacrosValueField_DirectivesField_NoneDirectiveField : this.eParamMacroField_ParamStringField_InternalMacroField_InternalStringField_InternalMacrosValueField_DirectivesField_NoneDirectiveField) {
=======
      for(Object oParamMacroField_ParamStringField_InternalMacroField_InternalStringField : this.eParamMacroField_ParamStringField_InternalMacroField_InternalStringField) {
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
        if(first) {
          first = false;
        }
        else {
          sb.append(System.getProperty("line.separator"));
        }
<<<<<<< HEAD
        sb.append(oParamMacroField_ParamStringField_InternalMacroField_InternalStringField_InternalMacrosValueField_DirectivesField_NoneDirectiveField.toString());
=======
        sb.append(oParamMacroField_ParamStringField_InternalMacroField_InternalStringField.toString());
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
      }
    }
    if(this.eContextField.size() > 0) {
      sb.append(System.getProperty("line.separator"));
    }
    for(Object oContextField : this.eContextField) {
      sb.append(oContextField.toString());
    }
    if(this.eConstructor.size() > 0) {
      sb.append(System.getProperty("line.separator"));
    }
    for(Object oConstructor : this.eConstructor) {
      sb.append(oConstructor.toString());
    }
<<<<<<< HEAD
<<<<<<< HEAD
    if(this.eParamStringSetter_AddAll_SingleAdd_InternalStringSetter_InternalMacroSetter.size() > 0) {
=======
    if(this.eParamStringSetter_ParamMacroSetter_InternalStringSetter_InternalMacroSetter.size() > 0) {
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
    if(this.eParamStringSetter_AddAll_SingleAdd_InternalStringSetter_InternalMacroSetter.size() > 0) {
>>>>>>> AddAll and single adds with static overloads
      sb.append(System.getProperty("line.separator"));
    }
    {
      boolean first = true;
<<<<<<< HEAD
<<<<<<< HEAD
      for(Object oParamStringSetter_AddAll_SingleAdd_InternalStringSetter_InternalMacroSetter : this.eParamStringSetter_AddAll_SingleAdd_InternalStringSetter_InternalMacroSetter) {
=======
      for(Object oParamStringSetter_ParamMacroSetter_InternalStringSetter_InternalMacroSetter : this.eParamStringSetter_ParamMacroSetter_InternalStringSetter_InternalMacroSetter) {
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
        if(first) {
          first = false;
        }
        else {
          sb.append(System.getProperty("line.separator"));
        }
<<<<<<< HEAD
        sb.append(oParamStringSetter_AddAll_SingleAdd_InternalStringSetter_InternalMacroSetter.toString());
      }
    }
    if(this.eParamStringRefBuilder_ParamMacroRefBuilder_InternalMacroRefBuilder.size() > 0) {
      sb.append(System.getProperty("line.separator"));
    }
    {
      boolean first = true;
      for(Object oParamStringRefBuilder_ParamMacroRefBuilder_InternalMacroRefBuilder : this.eParamStringRefBuilder_ParamMacroRefBuilder_InternalMacroRefBuilder) {
        if(first) {
          first = false;
        }
        else {
          sb.append(System.getProperty("line.separator"));
        }
        sb.append(oParamStringRefBuilder_ParamMacroRefBuilder_InternalMacroRefBuilder.toString());
      }
    }
    if(this.eParamStringRef_ParamMacroRef_InternalMacroRef.size() > 0) {
      sb.append(System.getProperty("line.separator"));
    }
    {
      boolean first = true;
      for(Object oParamStringRef_ParamMacroRef_InternalMacroRef : this.eParamStringRef_ParamMacroRef_InternalMacroRef) {
        if(first) {
          first = false;
        }
        else {
          sb.append(System.getProperty("line.separator"));
        }
        sb.append(oParamStringRef_ParamMacroRef_InternalMacroRef.toString());
      }
    }
    {
      boolean first = true;
      for(Object oInitInternalsMethod : this.eInitInternalsMethod) {
=======
      for(Object oParamStringSetter_AddAll_SingleAdd_InternalStringSetter_InternalMacroSetter : this.eParamStringSetter_AddAll_SingleAdd_InternalStringSetter_InternalMacroSetter) {
>>>>>>> AddAll and single adds with static overloads
        if(first) {
          first = false;
        }
        else {
          sb.append(System.getProperty("line.separator"));
        }
<<<<<<< HEAD
        sb.append(oInitInternalsMethod.toString());
      }
    }
    if(this.eInitDirectives.size() > 0) {
      sb.append(System.getProperty("line.separator"));
    }
    {
      boolean first = true;
      for(Object oInitDirectives : this.eInitDirectives) {
        if(first) {
          first = false;
        }
        else {
          sb.append(System.getProperty("line.separator"));
        }
        sb.append(oInitDirectives.toString());
      }
    }
    for(Object oRedefinedApplyInitializer : this.eRedefinedApplyInitializer) {
      sb.append(oRedefinedApplyInitializer.toString());
    }
    if(this.eMacroBuilder.size() > 0) {
      sb.append(System.getProperty("line.separator"));
    }
    for(Object oMacroBuilder : this.eMacroBuilder) {
      sb.append(oMacroBuilder.toString());
    }
    if(this.eEmptyBuilderWithContext.size() > 0) {
      sb.append(System.getProperty("line.separator"));
    }
    for(Object oEmptyBuilderWithContext : this.eEmptyBuilderWithContext) {
      sb.append(oEmptyBuilderWithContext.toString());
    }
=======
        sb.append(oParamStringSetter_ParamMacroSetter_InternalStringSetter_InternalMacroSetter.toString());
=======
        sb.append(oParamStringSetter_AddAll_SingleAdd_InternalStringSetter_InternalMacroSetter.toString());
>>>>>>> AddAll and single adds with static overloads
      }
    }
    if(this.eParamStringRefBuilder_ParamMacroRefBuilder.size() > 0) {
      sb.append(System.getProperty("line.separator"));
    }
    {
      boolean first = true;
      for(Object oParamStringRefBuilder_ParamMacroRefBuilder : this.eParamStringRefBuilder_ParamMacroRefBuilder) {
        if(first) {
          first = false;
        }
        else {
          sb.append(System.getProperty("line.separator"));
        }
        sb.append(oParamStringRefBuilder_ParamMacroRefBuilder.toString());
      }
    }
    if(this.eParamStringRef_ParamMacroRef.size() > 0) {
      sb.append(System.getProperty("line.separator"));
    }
    {
      boolean first = true;
      for(Object oParamStringRef_ParamMacroRef : this.eParamStringRef_ParamMacroRef) {
        if(first) {
          first = false;
        }
        else {
          sb.append(System.getProperty("line.separator"));
        }
        sb.append(oParamStringRef_ParamMacroRef.toString());
      }
    }
    sb.append(System.getProperty("line.separator"));
    for(Object oRedefinedApplyInitializer : this.eRedefinedApplyInitializer) {
      sb.append(oRedefinedApplyInitializer.toString());
    }
    if(this.eMacroBuilder.size() > 0) {
      sb.append(System.getProperty("line.separator"));
    }
    for(Object oMacroBuilder : this.eMacroBuilder) {
      sb.append(oMacroBuilder.toString());
    }
<<<<<<< HEAD
    sb.append(System.getProperty("line.separator"));
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
    if(this.eEmptyBuilderWithContext.size() > 0) {
      sb.append(System.getProperty("line.separator"));
    }
    for(Object oEmptyBuilderWithContext : this.eEmptyBuilderWithContext) {
      sb.append(oEmptyBuilderWithContext.toString());
    }
>>>>>>> Now macro without internals has a builder with context that only return build
    sb.append("}");
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }

}
