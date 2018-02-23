/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

public class MConstructor extends Macro{

    private String field_Name;

    private Macro list_ListSetParam[];

    private Macro list_ListParam[];

    private Macro list_ListInternal[];

    private final Context ListSetParamContext = new Context();
    private final Context ListParamContext = new Context();
    private final Context ListInternalContext = new Context();

    public MConstructor(String pName, Macro pListSetParam[], Macro pListParam[], Macro pListInternal[]){

        this.setPName(pName);
        this.setPListSetParam(pListSetParam);
        this.setPListParam(pListParam);
        this.setPListInternal(pListInternal);
    }

    private void setPName(String pName){
        if(pName == null){
            throw ObjectMacroException.parameterNull("Name");
        }

        this.field_Name = pName;
    }

    private void setPListSetParam(Macro pListSetParam[]){
        if(pListSetParam == null){
            throw ObjectMacroException.parameterNull("ListSetParam");
        }

        Macro macros[] = pListSetParam;
        this.list_ListSetParam = new Macro[macros.length];
        int i = 0;

        for(Macro macro : macros){
            if(macro == null){
                throw ObjectMacroException.macroNull(i, "ListSetParam");
            }

            macro.apply(new InternalsInitializer("ListSetParam"){
@Override
void setSetParam(MSetParam mSetParam){

        }
});

            this.list_ListSetParam[i++] = macro;

        }
    }

    private void setPListParam(Macro pListParam[]){
        if(pListParam == null){
            throw ObjectMacroException.parameterNull("ListParam");
        }

        Macro macros[] = pListParam;
        this.list_ListParam = new Macro[macros.length];
        int i = 0;

        for(Macro macro : macros){
            if(macro == null){
                throw ObjectMacroException.macroNull(i, "ListParam");
            }

            macro.apply(new InternalsInitializer("ListParam"){
@Override
void setStringParam(MStringParam mStringParam){

        }
@Override
void setMacroParam(MMacroParam mMacroParam){

        }
});

            this.list_ListParam[i++] = macro;

        }
    }

    private void setPListInternal(Macro pListInternal[]){
        if(pListInternal == null){
            throw ObjectMacroException.parameterNull("ListInternal");
        }

        Macro macros[] = pListInternal;
        this.list_ListInternal = new Macro[macros.length];
        int i = 0;

        for(Macro macro : macros){
            if(macro == null){
                throw ObjectMacroException.macroNull(i, "ListInternal");
            }

            macro.apply(new InternalsInitializer("ListInternal"){
@Override
void setInitMacroInternal(MInitMacroInternal mInitMacroInternal){

        }
@Override
void setInitStringInternal(MInitStringInternal mInitStringInternal){

        }
});

            this.list_ListInternal[i++] = macro;

        }
    }

    private String buildName(){

        return this.field_Name;
    }

    private String buildListSetParam(){

        StringBuilder sb0 = new StringBuilder();
        Context local_context = ListSetParamContext;
        Macro macros[] = this.list_ListSetParam;
                boolean first = true;
        int i = 0;

        for(Macro macro : macros){
            if(first){
            sb0.append(LINE_SEPARATOR);
    first = false;
}
            
            sb0.append(macro.build(local_context));
            i++;

                    }

        return sb0.toString();
    }

    private String buildListParam(){

        StringBuilder sb0 = new StringBuilder();
        Context local_context = ListParamContext;
        Macro macros[] = this.list_ListParam;
                boolean first = true;
        int i = 0;

        for(Macro macro : macros){
                        if(first) {
  first = false;
}
else {
           sb0.append(", ");
}

            sb0.append(macro.build(local_context));
            i++;

                    }

        return sb0.toString();
    }

    private String buildListInternal(){

        StringBuilder sb0 = new StringBuilder();
        Context local_context = ListInternalContext;
        Macro macros[] = this.list_ListInternal;
                boolean first = true;
        int i = 0;

        for(Macro macro : macros){
            if(first){
            sb0.append(LINE_SEPARATOR);
    first = false;
}
            
            sb0.append(macro.build(local_context));
            i++;

                    }

        return sb0.toString();
    }

    private String getName(){

        return this.field_Name;
    }

    private Macro[] getListSetParam(){

        return this.list_ListSetParam;
    }

    private Macro[] getListParam(){

        return this.list_ListParam;
    }

    private Macro[] getListInternal(){

        return this.list_ListInternal;
    }

    @Override
    void apply(
            InternalsInitializer internalsInitializer){

        internalsInitializer.setConstructor(this);
    }

    @Override
    public String build(){

        String local_expansion = this.expansion;

        if(local_expansion != null){
            return local_expansion;
        }

        StringBuilder sb0 = new StringBuilder();

        sb0.append("    public M");
        sb0.append(buildName());
        sb0.append("(");
        sb0.append(buildListParam());
        sb0.append(")");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append(buildListSetParam());
        sb0.append(LINE_SEPARATOR);
        sb0.append(buildListInternal());
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
