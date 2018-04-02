/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

import java.util.*;

<<<<<<< HEAD
<<<<<<< HEAD
public class MSetParam {

  private final String pName;
  private final MSetParam mSetParam = this;
  private final List<Object> eParamArg = new LinkedList<Object>();

  public MSetParam(String pName) {
    if(pName == null) throw new NullPointerException();
    this.pName = pName;
  }

  public MParamArg newParamArg(String pName) {
    MParamArg lParamArg = new MParamArg(pName);
    this.eParamArg.add(lParamArg);
    return lParamArg;
  }

  String pName() {
    return this.pName;
  }

  private String rName() {
    return this.mSetParam.pName();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("        this.setP");
    sb.append(rName());
    sb.append("(");
    for(Object oParamArg : this.eParamArg) {
      sb.append(oParamArg.toString());
    }
    sb.append(");");
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }

=======
=======
>>>>>>> object-macro2.1
public class MSetParam extends Macro{

    private String field_Name;
    private final List<Macro> list_ListParamArg;
    private DSeparator ListParamArgSeparator;

    private DBeforeFirst ListParamArgBeforeFirst;

    private DAfterLast ListParamArgAfterLast;

    private DNone ListParamArgNone;
    private final InternalValue ListParamArgValue;

    private final Context ListParamArgContext = new Context();

    public MSetParam(String pName){

        this.setPName(pName);

    this.list_ListParamArg = new ArrayList<>();

    this.ListParamArgValue = new InternalValue(this.list_ListParamArg, this.ListParamArgContext);
    }

    private void setPName( String pName ){
        if(pName == null){
            throw ObjectMacroException.parameterNull("Name");
        }

        this.field_Name = pName;
    }
    public void addListParamArg(MParamArg macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("ListParamArg");
        }
                if(this.build_state != null){
            throw ObjectMacroException.cannotModify("ParamArg");
        }

        this.list_ListParamArg.add(macro);
    }

    private String buildName(){

        return this.field_Name;
    }
    private String buildListParamArg(){
        StringBuilder sb = new StringBuilder();
        Context local_context = ListParamArgContext;
        List<Macro> macros = this.list_ListParamArg;

        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;

        if(this.ListParamArgNone != null){
            sb.append(this.ListParamArgNone.apply(i, "", nb_macros));
        }

        for(Macro macro : macros){
            expansion = macro.build(local_context);

            if(this.ListParamArgBeforeFirst != null){
                expansion = this.ListParamArgBeforeFirst.apply(i, expansion, nb_macros);
            }

            if(this.ListParamArgAfterLast != null){
                expansion = this.ListParamArgAfterLast.apply(i, expansion, nb_macros);
            }

            if(this.ListParamArgSeparator != null){
                expansion = this.ListParamArgSeparator.apply(i, expansion, nb_macros);
            }

            sb.append(expansion);
            i++;
        }

        return sb.toString();
    }

    private String getName(){

        return this.field_Name;
    }
    private InternalValue getListParamArg(){
        return this.ListParamArgValue;
    }
    private void initListParamArgInternals(Context context){
        for(Macro macro : this.list_ListParamArg){
            macro.apply(new InternalsInitializer("ListParamArg"){
@Override
void setParamArg(MParamArg mParamArg){

    
    
}
});
        }
    }

    private void initListParamArgDirectives(){
        
    }
    @Override
    void apply(
            InternalsInitializer internalsInitializer){

        internalsInitializer.setSetParam(this);
    }

   @Override
    public String build(){

        BuildState buildState = this.build_state;

        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("SetParam");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_state = buildState;

        initListParamArgDirectives();

        initListParamArgInternals(null);

        StringBuilder sb0 = new StringBuilder();

        sb0.append("        this.setP");
        sb0.append(buildName());
        sb0.append("(");
        sb0.append(buildListParamArg());
        sb0.append(");");

        buildState.setExpansion(sb0.toString());
        return sb0.toString();
    }

    @Override
    String build(Context context) {
        return build();
    }
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> Mise à jour Visiteur - Build OK
}
=======
}
>>>>>>> Correctifs objectmacro2-java(back)
=======
}
>>>>>>> object-macro2.1
