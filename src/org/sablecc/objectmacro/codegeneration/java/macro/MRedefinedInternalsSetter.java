/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Revert "Changement Objectmacro-back"
=======
>>>>>>> Revert "MaJ Fichier de Macro + Generation"
import java.util.*;

public class MRedefinedInternalsSetter {

  private final String pName;
  private final MRedefinedInternalsSetter mRedefinedInternalsSetter = this;
  private final List<Object> eInitStringBuilder_StringPart_ParamInsertPart_EolPart_InsertMacroPart = new LinkedList<Object>();
  private final List<Object> eSetInternal = new LinkedList<Object>();

  public MRedefinedInternalsSetter(String pName) {
    if(pName == null) throw new NullPointerException();
    this.pName = pName;
  }

  public MInitStringBuilder newInitStringBuilder(String pIndexBuilder) {
    MInitStringBuilder lInitStringBuilder = new MInitStringBuilder(pIndexBuilder);
    this.eInitStringBuilder_StringPart_ParamInsertPart_EolPart_InsertMacroPart.add(lInitStringBuilder);
    return lInitStringBuilder;
  }

  public MStringPart newStringPart(String pString, String pIndexBuilder) {
    MStringPart lStringPart = new MStringPart(pString, pIndexBuilder);
    this.eInitStringBuilder_StringPart_ParamInsertPart_EolPart_InsertMacroPart.add(lStringPart);
    return lStringPart;
  }

  public MParamInsertPart newParamInsertPart(String pParamName, String pIndexBuilder) {
    MParamInsertPart lParamInsertPart = new MParamInsertPart(pParamName, pIndexBuilder);
    this.eInitStringBuilder_StringPart_ParamInsertPart_EolPart_InsertMacroPart.add(lParamInsertPart);
    return lParamInsertPart;
  }

  public MEolPart newEolPart(String pIndexBuilder) {
    MEolPart lEolPart = new MEolPart(pIndexBuilder);
    this.eInitStringBuilder_StringPart_ParamInsertPart_EolPart_InsertMacroPart.add(lEolPart);
    return lEolPart;
  }

  public MInsertMacroPart newInsertMacroPart(String pName, String pIndexBuilder, String pIndexInsert) {
    MInsertMacroPart lInsertMacroPart = new MInsertMacroPart(pName, pIndexBuilder, pIndexInsert);
    this.eInitStringBuilder_StringPart_ParamInsertPart_EolPart_InsertMacroPart.add(lInsertMacroPart);
    return lInsertMacroPart;
  }

  public MSetInternal newSetInternal(String pMacroName, String pParamName, String pContext) {
    MSetInternal lSetInternal = new MSetInternal(pMacroName, pParamName, pContext);
    this.eSetInternal.add(lSetInternal);
    return lSetInternal;
  }

  String pName() {
    return this.pName;
  }

  private String rName() {
    return this.mRedefinedInternalsSetter.pName();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    sb.append("@Override");
    sb.append(System.getProperty("line.separator"));
    sb.append("void set");
=======
    sb.append("    @Override");
    sb.append(System.getProperty("line.separator"));
    sb.append("    void set");
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
    sb.append("@Override");
    sb.append(System.getProperty("line.separator"));
    sb.append("void set");
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
=======
    sb.append("@Override");
    sb.append(System.getProperty("line.separator"));
    sb.append("void set");
>>>>>>> Revert "Changement Objectmacro-back"
=======
    sb.append("@Override");
    sb.append(System.getProperty("line.separator"));
    sb.append("void set");
>>>>>>> Revert "MaJ Fichier de Macro + Generation"
    sb.append(rName());
    sb.append("(M");
    sb.append(rName());
    sb.append(" m");
    sb.append(rName());
    sb.append("){");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    sb.append("    ");
=======
    sb.append("        ");
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
    sb.append("    ");
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
=======
    sb.append("    ");
>>>>>>> Revert "Changement Objectmacro-back"
=======
    sb.append("    ");
>>>>>>> Revert "MaJ Fichier de Macro + Generation"
    {
      boolean first = true;
      for(Object oInitStringBuilder_StringPart_ParamInsertPart_EolPart_InsertMacroPart : this.eInitStringBuilder_StringPart_ParamInsertPart_EolPart_InsertMacroPart) {
        if(first) {
          first = false;
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> MaJ Fichier de Macro + Generation
=======
import java.util.*;

>>>>>>> Mise à jour Visiteur - Build OK
public class MRedefinedInternalsSetter extends Macro{

    private String field_Name;
    private final List<Macro> list_ListPart;
    private DSeparator ListPartSeparator;

    private DBeforeFirst ListPartBeforeFirst;

    private DAfterLast ListPartAfterLast;

    private DNone ListPartNone;
    private final InternalValue ListPartValue;
    private final List<Macro> list_ListSetInternal;
    private DSeparator ListSetInternalSeparator;

    private DBeforeFirst ListSetInternalBeforeFirst;

    private DAfterLast ListSetInternalAfterLast;

    private DNone ListSetInternalNone;
    private final InternalValue ListSetInternalValue;

    private final Context ListPartContext = new Context();    private final Context ListSetInternalContext = new Context();

    public MRedefinedInternalsSetter(String pName){

        this.setPName(pName);

    this.list_ListPart = new ArrayList<>();    this.list_ListSetInternal = new ArrayList<>();

    this.ListPartValue = new InternalValue(this.list_ListPart, this.ListPartContext);    this.ListSetInternalValue = new InternalValue(this.list_ListSetInternal, this.ListSetInternalContext);
    }

    private void setPName( String pName ){
        if(pName == null){
            throw ObjectMacroException.parameterNull("Name");
        }

        this.field_Name = pName;
    }
    public void addListPart(MInitStringBuilder macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("ListPart");
        }
                if(this.build_state != null){
            throw ObjectMacroException.cannotModify("InitStringBuilder");
        }

        this.list_ListPart.add(macro);
    }
    public void addListPart(MStringPart macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("ListPart");
        }
                if(this.build_state != null){
            throw ObjectMacroException.cannotModify("StringPart");
        }

        this.list_ListPart.add(macro);
    }
    public void addListPart(MParamInsertPart macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("ListPart");
        }
<<<<<<< HEAD
@Override
void setStringPart(MStringPart mStringPart){

<<<<<<< HEAD
>>>>>>> Changement Objectmacro-back
=======
>>>>>>> Revert "Changement Objectmacro-back"
=======
>>>>>>> MaJ Fichier de Macro + Generation
=======
>>>>>>> Revert "MaJ Fichier de Macro + Generation"
        }
        else {
          sb.append(System.getProperty("line.separator"));
        }
        sb.append(oInitStringBuilder_StringPart_ParamInsertPart_EolPart_InsertMacroPart.toString());
      }
    }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    sb.append("    ");
    for(Object oSetInternal : this.eSetInternal) {
      sb.append(oSetInternal.toString());
    }
    sb.append("}");
=======
    sb.append("        ");
    for(Object oSetInternal : this.eSetInternal) {
      sb.append(oSetInternal.toString());
    }
    sb.append("    }");
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
    sb.append("    ");
    for(Object oSetInternal : this.eSetInternal) {
      sb.append(oSetInternal.toString());
=======
                if(this.build_state != null){
            throw ObjectMacroException.cannotModify("ParamInsertPart");
        }

        this.list_ListPart.add(macro);
    }
    public void addListPart(MEolPart macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("ListPart");
        }
                if(this.build_state != null){
            throw ObjectMacroException.cannotModify("EolPart");
        }

        this.list_ListPart.add(macro);
    }
    public void addListPart(MInsertMacroPart macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("ListPart");
        }
                if(this.build_state != null){
            throw ObjectMacroException.cannotModify("InsertMacroPart");
        }

        this.list_ListPart.add(macro);
    }
    public void addListSetInternal(MSetInternal macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("ListSetInternal");
        }
                if(this.build_state != null){
            throw ObjectMacroException.cannotModify("SetInternal");
        }

        this.list_ListSetInternal.add(macro);
>>>>>>> Mise à jour Visiteur - Build OK
    }
    sb.append("}");
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }
=======
=======
>>>>>>> MaJ Fichier de Macro + Generation

    private String buildName(){

        return this.field_Name;
    }
    private String buildListPart(){
        StringBuilder sb = new StringBuilder();
        Context local_context = ListPartContext;
        List<Macro> macros = this.list_ListPart;

        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;

        if(this.ListPartNone != null){
            sb.append(this.ListPartNone.apply(i, "", nb_macros));
        }

        for(Macro macro : macros){
            expansion = macro.build(local_context);

            if(this.ListPartBeforeFirst != null){
                expansion = this.ListPartBeforeFirst.apply(i, expansion, nb_macros);
            }

            if(this.ListPartAfterLast != null){
                expansion = this.ListPartAfterLast.apply(i, expansion, nb_macros);
            }

            if(this.ListPartSeparator != null){
                expansion = this.ListPartSeparator.apply(i, expansion, nb_macros);
            }

            sb.append(expansion);
            i++;
        }

        return sb.toString();
    }
    private String buildListSetInternal(){
        StringBuilder sb = new StringBuilder();
        Context local_context = ListSetInternalContext;
        List<Macro> macros = this.list_ListSetInternal;

        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;

        if(this.ListSetInternalNone != null){
            sb.append(this.ListSetInternalNone.apply(i, "", nb_macros));
        }

        for(Macro macro : macros){
            expansion = macro.build(local_context);

            if(this.ListSetInternalBeforeFirst != null){
                expansion = this.ListSetInternalBeforeFirst.apply(i, expansion, nb_macros);
            }

            if(this.ListSetInternalAfterLast != null){
                expansion = this.ListSetInternalAfterLast.apply(i, expansion, nb_macros);
            }

            if(this.ListSetInternalSeparator != null){
                expansion = this.ListSetInternalSeparator.apply(i, expansion, nb_macros);
            }

            sb.append(expansion);
            i++;
        }

        return sb.toString();
    }

    private String getName(){

        return this.field_Name;
    }
    private InternalValue getListPart(){
        return this.ListPartValue;
    }
    private InternalValue getListSetInternal(){
        return this.ListSetInternalValue;
    }
    private void initListPartInternals(Context context){
        for(Macro macro : this.list_ListPart){
            macro.apply(new InternalsInitializer("ListPart"){
@Override
void setInitStringBuilder(MInitStringBuilder mInitStringBuilder){

    
    
}@Override
void setStringPart(MStringPart mStringPart){

    
    
}@Override
void setParamInsertPart(MParamInsertPart mParamInsertPart){

    
    
}@Override
void setEolPart(MEolPart mEolPart){

    
    
}@Override
void setInsertMacroPart(MInsertMacroPart mInsertMacroPart){

    
    
}
});
        }
    }
    private void initListSetInternalInternals(Context context){
        for(Macro macro : this.list_ListSetInternal){
            macro.apply(new InternalsInitializer("ListSetInternal"){
@Override
void setSetInternal(MSetInternal mSetInternal){

    
    
}
});
        }
    }

    private void initListPartDirectives(){
        StringBuilder sb0 = new StringBuilder();
        sb0.append(LINE_SEPARATOR);
this.ListPartSeparator = new DSeparator(sb0.toString());
this.ListPartValue.setSeparator(this.ListPartSeparator);
    }
    private void initListSetInternalDirectives(){
        
    }
    @Override
    void apply(
            InternalsInitializer internalsInitializer){

        internalsInitializer.setRedefinedInternalsSetter(this);
<<<<<<< HEAD
    }
<<<<<<< HEAD
>>>>>>> Changement Objectmacro-back
=======
    sb.append("    ");
    for(Object oSetInternal : this.eSetInternal) {
      sb.append(oSetInternal.toString());
=======

   @Override
    public String build(){

        BuildState buildState = this.build_state;

        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("RedefinedInternalsSetter");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_state = buildState;

        initListPartDirectives();
initListSetInternalDirectives();

        initListPartInternals(null);
initListSetInternalInternals(null);

        StringBuilder sb0 = new StringBuilder();

        sb0.append("@Override");
        sb0.append(LINE_SEPARATOR);
        sb0.append("void set");
        sb0.append(buildName());
        sb0.append("(M");
        sb0.append(buildName());
        sb0.append(" m");
        sb0.append(buildName());
        sb0.append(")");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    ");
        sb0.append(buildListPart());
        sb0.append(LINE_SEPARATOR);
        sb0.append("    ");
        sb0.append(buildListSetInternal());
        sb0.append(LINE_SEPARATOR);
        sb0.append("}");

        buildState.setExpansion(sb0.toString());
        return sb0.toString();
>>>>>>> Mise à jour Visiteur - Build OK
    }
    sb.append("}");
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }
>>>>>>> Revert "Changement Objectmacro-back"
=======
    }
>>>>>>> MaJ Fichier de Macro + Generation
=======
    sb.append("    ");
    for(Object oSetInternal : this.eSetInternal) {
      sb.append(oSetInternal.toString());
    }
<<<<<<< HEAD
    sb.append("}");
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }
>>>>>>> Revert "MaJ Fichier de Macro + Generation"

}
=======
}
>>>>>>> Correctifs objectmacro2-java(back)
