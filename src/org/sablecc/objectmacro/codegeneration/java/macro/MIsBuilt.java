/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

public class MIsBuilt {

  private final String pMacroName;
  private final MIsBuilt mIsBuilt = this;

  public MIsBuilt(String pMacroName) {
    if(pMacroName == null) throw new NullPointerException();
    this.pMacroName = pMacroName;
  }

  String pMacroName() {
    return this.pMacroName;
  }

  private String rMacroName() {
    return this.mIsBuilt.pMacroName();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("        if(this.build_state != null){");
    sb.append(System.getProperty("line.separator"));
    sb.append("            throw ObjectMacroException.cannotModify(\"");
    sb.append(rMacroName());
    sb.append("\");");
    sb.append(System.getProperty("line.separator"));
    sb.append("        }");
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }

<<<<<<< HEAD
=======
public class MIsBuilt extends Macro{

    private Map<Context, String> field_MacroName = new LinkedHashMap<>();


    public MIsBuilt(){



    }

    void setMacroName(
            Context context,
            String value) {

        if(value == null){
            throw new RuntimeException("value cannot be null here");
        }

        this.field_MacroName.put(context, value);
    }

    private String buildMacroName(Context context){

        return this.field_MacroName.get(context);
    }

    private String getMacroName(Context context){

        return this.field_MacroName.get(context);
    }


    @Override
    void apply(
            InternalsInitializer internalsInitializer){

        internalsInitializer.setIsBuilt(this);
    }

   @Override
    public String build(Context context){

        BuildState buildState = this.build_states.get(context);

        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("IsBuilt");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_states.put(context, buildState);

        

        

        StringBuilder sb0 = new StringBuilder();

        sb0.append("        if(this.build_state != null)");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            throw ObjectMacroException.cannotModify(\"");
        sb0.append(buildMacroName(context));
        sb0.append("\");");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        }");

        buildState.setExpansion(sb0.toString());
        return sb0.toString();
    }
<<<<<<< HEAD
>>>>>>> Mise à jour Visiteur - Build OK
}
=======

}
>>>>>>> Correctifs objectmacro2-java(back)
