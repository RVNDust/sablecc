/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import java.util.*;

=======
>>>>>>> Init internals before building the macro instead at the add or addAll methods
=======
import java.util.*;

>>>>>>> Lazy initialization in build method instead of eager initialization in add methods
=======
import java.util.*;

>>>>>>> Revert "MaJ Fichier de Macro + Generation"
public class MInitInternalsCall {

  private final String pParamName;
  private final MInitInternalsCall mInitInternalsCall = this;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
  private final List<Object> eContextArg = new LinkedList<Object>();

  MInitInternalsCall(String pParamName) {
<<<<<<< HEAD
=======

  public MInitInternalsCall(String pParamName) {
>>>>>>> Init internals before building the macro instead at the add or addAll methods
=======
  private final List<Object> eContextArg = new LinkedList<Object>();

  public MInitInternalsCall(String pParamName) {
>>>>>>> Lazy initialization in build method instead of eager initialization in add methods
=======
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
=======
  private final List<Object> eContextArg = new LinkedList<Object>();

  MInitInternalsCall(String pParamName) {
>>>>>>> Revert "MaJ Fichier de Macro + Generation"
    if(pParamName == null) throw new NullPointerException();
    this.pParamName = pParamName;
  }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Lazy initialization in build method instead of eager initialization in add methods
=======
>>>>>>> Revert "MaJ Fichier de Macro + Generation"
  public MContextArg newContextArg() {
    MContextArg lContextArg = new MContextArg();
    this.eContextArg.add(lContextArg);
    return lContextArg;
  }

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Init internals before building the macro instead at the add or addAll methods
=======
>>>>>>> Lazy initialization in build method instead of eager initialization in add methods
=======
>>>>>>> Revert "MaJ Fichier de Macro + Generation"
  String pParamName() {
    return this.pParamName;
  }

  private String rParamName() {
    return this.mInitInternalsCall.pParamName();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    sb.append("        init");
=======
    sb.append("init");
>>>>>>> Lazy initialization in build method instead of eager initialization in add methods
=======
    sb.append("        init");
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
=======
    sb.append("        init");
>>>>>>> Revert "MaJ Fichier de Macro + Generation"
    sb.append(rParamName());
    sb.append("Internals(");
    if(this.eContextArg.size() == 0) {
      sb.append("null");
    }
    for(Object oContextArg : this.eContextArg) {
      sb.append(oContextArg.toString());
=======
=======
>>>>>>> object-macro2.1
import java.util.*;

public class MInitInternalsCall extends Macro{

    private String field_ParamName;
    private final List<Macro> list_ContextArg;
    private DSeparator ContextArgSeparator;

    private DBeforeFirst ContextArgBeforeFirst;

    private DAfterLast ContextArgAfterLast;

    private DNone ContextArgNone;
    private final InternalValue ContextArgValue;

    private final Context ContextArgContext = new Context();

    public MInitInternalsCall(String pParamName){

        this.setPParamName(pParamName);

    this.list_ContextArg = new ArrayList<>();

    this.ContextArgValue = new InternalValue(this.list_ContextArg, this.ContextArgContext);
    }

    private void setPParamName( String pParamName ){
        if(pParamName == null){
            throw ObjectMacroException.parameterNull("ParamName");
        }

        this.field_ParamName = pParamName;
    }
    public void addContextArg(MContextArg macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("ContextArg");
        }
                if(this.build_state != null){
            throw ObjectMacroException.cannotModify("ContextArg");
        }

        this.list_ContextArg.add(macro);
    }

    private String buildParamName(){

        return this.field_ParamName;
    }
    private String buildContextArg(){
        StringBuilder sb = new StringBuilder();
        Context local_context = ContextArgContext;
        List<Macro> macros = this.list_ContextArg;

        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;

        if(this.ContextArgNone != null){
            sb.append(this.ContextArgNone.apply(i, "", nb_macros));
        }

        for(Macro macro : macros){
            expansion = macro.build(local_context);

            if(this.ContextArgBeforeFirst != null){
                expansion = this.ContextArgBeforeFirst.apply(i, expansion, nb_macros);
            }

            if(this.ContextArgAfterLast != null){
                expansion = this.ContextArgAfterLast.apply(i, expansion, nb_macros);
            }

            if(this.ContextArgSeparator != null){
                expansion = this.ContextArgSeparator.apply(i, expansion, nb_macros);
            }

            sb.append(expansion);
            i++;
        }

        return sb.toString();
    }

    private String getParamName(){

        return this.field_ParamName;
    }
    private InternalValue getContextArg(){
        return this.ContextArgValue;
    }
    private void initContextArgInternals(Context context){
        for(Macro macro : this.list_ContextArg){
            macro.apply(new InternalsInitializer("ContextArg"){
@Override
void setContextArg(MContextArg mContextArg){

    
    
}
});
        }
    }

    private void initContextArgDirectives(){
        StringBuilder sb0 = new StringBuilder();
        sb0.append("null");
this.ContextArgNone = new DNone(sb0.toString());
this.ContextArgValue.setNone(this.ContextArgNone);
    }
    @Override
    void apply(
            InternalsInitializer internalsInitializer){

        internalsInitializer.setInitInternalsCall(this);
    }

   @Override
    public String build(){

        BuildState buildState = this.build_state;

        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("InitInternalsCall");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_state = buildState;

        initContextArgDirectives();

        initContextArgInternals(null);

        StringBuilder sb0 = new StringBuilder();

        sb0.append("init");
        sb0.append(buildParamName());
        sb0.append("Internals(");
        sb0.append(buildContextArg());
        sb0.append(");");

        buildState.setExpansion(sb0.toString());
        return sb0.toString();
<<<<<<< HEAD
>>>>>>> Mise à jour Visiteur - Build OK
    }
    sb.append(");");
    sb.append(System.getProperty("line.separator"));
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    sb.append("        ");
=======
    sb.append("init");
    sb.append(rParamName());
    sb.append("Internals();");
    sb.append(System.getProperty("line.separator"));
>>>>>>> Init internals before building the macro instead at the add or addAll methods
=======
>>>>>>> Lazy initialization in build method instead of eager initialization in add methods
=======
    sb.append("        ");
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
    return sb.toString();
  }
=======
public class MInitInternalsCall extends Macro{
>>>>>>> MaJ Fichier de Macro + Generation
=======
    sb.append("        ");
    return sb.toString();
  }
>>>>>>> Revert "MaJ Fichier de Macro + Generation"

<<<<<<< HEAD
}
=======
=======
    }

>>>>>>> object-macro2.1
    @Override
    String build(Context context) {
        return build();
    }
<<<<<<< HEAD
}
>>>>>>> Correctifs objectmacro2-java(back)
=======
}
>>>>>>> object-macro2.1
