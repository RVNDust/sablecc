/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

<<<<<<< HEAD
public class MParamMacroField {

  private final String pName;
  private final MParamMacroField mParamMacroField = this;

  public MParamMacroField(String pName) {
    if(pName == null) throw new NullPointerException();
    this.pName = pName;
  }

  String pName() {
    return this.pName;
  }

  private String rName() {
    return this.mParamMacroField.pName();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    sb.append("    private final List<Macro> list_");
    sb.append(rName());
    sb.append(";");
=======
    sb.append("    private Macro list_");
    sb.append(rName());
    sb.append("[];");
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
    sb.append("    private List<Macro> list_");
=======
    sb.append("    private final List<Macro> list_");
>>>>>>> Init internals before building the macro instead at the add or addAll methods
    sb.append(rName());
    sb.append(";");
>>>>>>> Removed in constructor initialization and add lazy initialization
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }
=======
public class MParamMacroField extends Macro{
>>>>>>> Changement Objectmacro-back

    private String field_Name;

    public MParamMacroField(String pName){

        this.setPName(pName);
    }

    private void setPName(String pName){
        if(pName == null){
            throw ObjectMacroException.parameterNull("Name");
        }

        this.field_Name = pName;
    }

    private String buildName(){

        return this.field_Name;
    }

    private String getName(){

        return this.field_Name;
    }

    @Override
    void apply(
            InternalsInitializer internalsInitializer){

        internalsInitializer.setParamMacroField(this);
    }

    @Override
    public String build(){

        String local_expansion = this.expansion;

        if(local_expansion != null){
            return local_expansion;
        }

        StringBuilder sb0 = new StringBuilder();

        sb0.append("    private Macro list_");
        sb0.append(buildName());
        sb0.append("[];");

        local_expansion = sb0.toString();
        this.expansion = local_expansion;
        return local_expansion;
    }

    @Override
    String build(Context context) {
        return build();
    }
}
