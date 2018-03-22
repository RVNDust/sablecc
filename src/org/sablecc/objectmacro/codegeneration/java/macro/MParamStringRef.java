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

public class MParamStringRef {

  private final String pName;
  private final MParamStringRef mParamStringRef = this;
  private final List<Object> eContextParam = new LinkedList<Object>();
  private final List<Object> eGetInternalTail = new LinkedList<Object>();

  public MParamStringRef(String pName) {
    if(pName == null) throw new NullPointerException();
    this.pName = pName;
  }

  public MContextParam newContextParam() {
    MContextParam lContextParam = new MContextParam();
    this.eContextParam.add(lContextParam);
    return lContextParam;
  }

  public MGetInternalTail newGetInternalTail() {
    MGetInternalTail lGetInternalTail = new MGetInternalTail();
    this.eGetInternalTail.add(lGetInternalTail);
    return lGetInternalTail;
  }

  String pName() {
    return this.pName;
  }

  private String rName() {
    return this.mParamStringRef.pName();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    sb.append("    private String get");
    sb.append(rName());
    sb.append("(");
=======
    sb.append("    private String build");
    sb.append(rName());
    sb.append("(");
    sb.append(System.getProperty("line.separator"));
    sb.append("            ");
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
    sb.append("    private String get");
    sb.append(rName());
    sb.append("(");
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
=======
    sb.append("    private String get");
    sb.append(rName());
    sb.append("(");
>>>>>>> Revert "Changement Objectmacro-back"
=======
    sb.append("    private String get");
    sb.append(rName());
    sb.append("(");
>>>>>>> Revert "MaJ Fichier de Macro + Generation"
    for(Object oContextParam : this.eContextParam) {
      sb.append(oContextParam.toString());
    }
    sb.append("){");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        return this.field_");
    sb.append(rName());
    for(Object oGetInternalTail : this.eGetInternalTail) {
      sb.append(oGetInternalTail.toString());
=======
import java.util.*;

public class MParamStringRef extends Macro{

    private String field_Name;
    private final List<Macro> list_ContextParam;
    private DSeparator ContextParamSeparator;

    private DBeforeFirst ContextParamBeforeFirst;

    private DAfterLast ContextParamAfterLast;

    private DNone ContextParamNone;
    private final InternalValue ContextParamValue;
    private final List<Macro> list_GetInternalTail;
    private DSeparator GetInternalTailSeparator;

    private DBeforeFirst GetInternalTailBeforeFirst;

    private DAfterLast GetInternalTailAfterLast;

    private DNone GetInternalTailNone;
    private final InternalValue GetInternalTailValue;

    private final Context ContextParamContext = new Context();    private final Context GetInternalTailContext = new Context();

    public MParamStringRef(String pName){

        this.setPName(pName);

    this.list_ContextParam = new ArrayList<>();    this.list_GetInternalTail = new ArrayList<>();

    this.ContextParamValue = new InternalValue(this.list_ContextParam, this.ContextParamContext);    this.GetInternalTailValue = new InternalValue(this.list_GetInternalTail, this.GetInternalTailContext);
    }

    private void setPName( String pName ){
        if(pName == null){
            throw ObjectMacroException.parameterNull("Name");
        }

        this.field_Name = pName;
    }
    public void addContextParam(MContextParam macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("ContextParam");
        }
                if(this.build_state != null){
            throw ObjectMacroException.cannotModify("ContextParam");
        }

        this.list_ContextParam.add(macro);
    }
    public void addGetInternalTail(MGetInternalTail macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("GetInternalTail");
        }
                if(this.build_state != null){
            throw ObjectMacroException.cannotModify("GetInternalTail");
        }

        this.list_GetInternalTail.add(macro);
    }

    private String buildName(){

        return this.field_Name;
    }
    private String buildContextParam(){
        StringBuilder sb = new StringBuilder();
        Context local_context = ContextParamContext;
        List<Macro> macros = this.list_ContextParam;

        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;

        if(this.ContextParamNone != null){
            sb.append(this.ContextParamNone.apply(i, "", nb_macros));
        }

        for(Macro macro : macros){
            expansion = macro.build(local_context);

            if(this.ContextParamBeforeFirst != null){
                expansion = this.ContextParamBeforeFirst.apply(i, expansion, nb_macros);
            }

            if(this.ContextParamAfterLast != null){
                expansion = this.ContextParamAfterLast.apply(i, expansion, nb_macros);
            }

            if(this.ContextParamSeparator != null){
                expansion = this.ContextParamSeparator.apply(i, expansion, nb_macros);
            }

            sb.append(expansion);
            i++;
        }

        return sb.toString();
    }
    private String buildGetInternalTail(){
        StringBuilder sb = new StringBuilder();
        Context local_context = GetInternalTailContext;
        List<Macro> macros = this.list_GetInternalTail;

        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;

        if(this.GetInternalTailNone != null){
            sb.append(this.GetInternalTailNone.apply(i, "", nb_macros));
        }

        for(Macro macro : macros){
            expansion = macro.build(local_context);

            if(this.GetInternalTailBeforeFirst != null){
                expansion = this.GetInternalTailBeforeFirst.apply(i, expansion, nb_macros);
            }

            if(this.GetInternalTailAfterLast != null){
                expansion = this.GetInternalTailAfterLast.apply(i, expansion, nb_macros);
            }

            if(this.GetInternalTailSeparator != null){
                expansion = this.GetInternalTailSeparator.apply(i, expansion, nb_macros);
            }

            sb.append(expansion);
            i++;
        }

        return sb.toString();
    }

    private String getName(){

        return this.field_Name;
    }
    private InternalValue getContextParam(){
        return this.ContextParamValue;
    }
    private InternalValue getGetInternalTail(){
        return this.GetInternalTailValue;
    }
    private void initContextParamInternals(Context context){
        for(Macro macro : this.list_ContextParam){
            macro.apply(new InternalsInitializer("ContextParam"){
@Override
void setContextParam(MContextParam mContextParam){

    
    
}
});
        }
    }
    private void initGetInternalTailInternals(Context context){
        for(Macro macro : this.list_GetInternalTail){
            macro.apply(new InternalsInitializer("GetInternalTail"){
@Override
void setGetInternalTail(MGetInternalTail mGetInternalTail){

    
    
}
});
        }
    }

    private void initContextParamDirectives(){
        
    }
    private void initGetInternalTailDirectives(){
        
    }
    @Override
    void apply(
            InternalsInitializer internalsInitializer){

        internalsInitializer.setParamStringRef(this);
    }

   @Override
    public String build(){

        BuildState buildState = this.build_state;

        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("ParamStringRef");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_state = buildState;

        initContextParamDirectives();
initGetInternalTailDirectives();

        initContextParamInternals(null);
initGetInternalTailInternals(null);

        StringBuilder sb0 = new StringBuilder();

        sb0.append("    private String get");
        sb0.append(buildName());
        sb0.append("(");
        sb0.append(buildContextParam());
        sb0.append(")");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("        return this.field_");
        sb0.append(buildName());
        sb0.append(buildGetInternalTail());
        sb0.append(";");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    }");

        buildState.setExpansion(sb0.toString());
        return sb0.toString();
>>>>>>> Mise à jour Visiteur - Build OK
    }
    sb.append(";");
    sb.append(System.getProperty("line.separator"));
    sb.append("    }");
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }
<<<<<<< HEAD
<<<<<<< HEAD
=======
public class MParamStringRef extends Macro{
>>>>>>> Changement Objectmacro-back
=======
>>>>>>> Revert "Changement Objectmacro-back"
=======
public class MParamStringRef extends Macro{
>>>>>>> MaJ Fichier de Macro + Generation
=======
>>>>>>> Revert "MaJ Fichier de Macro + Generation"

<<<<<<< HEAD
}
=======
    @Override
    String build(Context context) {
        return build();
    }
}
>>>>>>> Correctifs objectmacro2-java(back)
