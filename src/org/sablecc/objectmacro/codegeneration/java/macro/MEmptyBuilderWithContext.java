/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

public class MEmptyBuilderWithContext extends Macro{

    public MEmptyBuilderWithContext(){
    }

    @Override
    void apply(
            InternalsInitializer internalsInitializer){

        internalsInitializer.setEmptyBuilderWithContext(this);
    }

    @Override
    public String build(){

        String local_expansion = this.expansion;

        if(local_expansion != null){
            return local_expansion;
        }

        StringBuilder sb0 = new StringBuilder();

        sb0.append("    @Override");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    String build(Context context) ");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        return build();");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    }");

        local_expansion = sb0.toString();
        this.expansion = local_expansion;
        return local_expansion;
    }

    @Override
    String build(Context context) {
        return build();
    }
}
