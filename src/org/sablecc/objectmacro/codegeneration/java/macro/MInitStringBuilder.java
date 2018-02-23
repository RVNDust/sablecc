/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

public class MInitStringBuilder extends Macro{

    private String field_IndexBuilder;

    public MInitStringBuilder(String pIndexBuilder){

        this.setPIndexBuilder(pIndexBuilder);
    }

    private void setPIndexBuilder(String pIndexBuilder){
        if(pIndexBuilder == null){
            throw ObjectMacroException.parameterNull("IndexBuilder");
        }

        this.field_IndexBuilder = pIndexBuilder;
    }

    private String buildIndexBuilder(){

        return this.field_IndexBuilder;
    }

    private String getIndexBuilder(){

        return this.field_IndexBuilder;
    }

    @Override
    void apply(
            InternalsInitializer internalsInitializer){

        internalsInitializer.setInitStringBuilder(this);
    }

    @Override
    public String build(){

        String local_expansion = this.expansion;

        if(local_expansion != null){
            return local_expansion;
        }

        StringBuilder sb0 = new StringBuilder();

        sb0.append("        StringBuilder sb");
        sb0.append(buildIndexBuilder());
        sb0.append(" = new StringBuilder();");

        local_expansion = sb0.toString();
        this.expansion = local_expansion;
        return local_expansion;
    }

    @Override
    String build(Context context) {
        return build();
    }
}
