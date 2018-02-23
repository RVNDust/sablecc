/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

public class MStringPart extends Macro{

    private String field_String;

    private String field_IndexBuilder;

    public MStringPart(String pString, String pIndexBuilder){

        this.setPString(pString);
        this.setPIndexBuilder(pIndexBuilder);
    }

    private void setPString(String pString){
        if(pString == null){
            throw ObjectMacroException.parameterNull("String");
        }

        this.field_String = pString;
    }

    private void setPIndexBuilder(String pIndexBuilder){
        if(pIndexBuilder == null){
            throw ObjectMacroException.parameterNull("IndexBuilder");
        }

        this.field_IndexBuilder = pIndexBuilder;
    }

    private String buildString(){

        return this.field_String;
    }

    private String buildIndexBuilder(){

        return this.field_IndexBuilder;
    }

    private String getString(){

        return this.field_String;
    }

    private String getIndexBuilder(){

        return this.field_IndexBuilder;
    }

    @Override
    void apply(
            InternalsInitializer internalsInitializer){

        internalsInitializer.setStringPart(this);
    }

    @Override
    public String build(){

        String local_expansion = this.expansion;

        if(local_expansion != null){
            return local_expansion;
        }

        StringBuilder sb0 = new StringBuilder();

        sb0.append("        sb");
        sb0.append(buildIndexBuilder());
        sb0.append(".append(\"");
        sb0.append(buildString());
        sb0.append("\");");

        local_expansion = sb0.toString();
        this.expansion = local_expansion;
        return local_expansion;
    }

    @Override
    String build(Context context) {
        return build();
    }
}
