/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.c.macro;

import java.util.*;

public class MInternalStringGetterH extends Macro{
    
    private String field_FieldName;
    
    private Map<Context, String> field_MacroName = new LinkedHashMap<>();
    
    
    
    
    public MInternalStringGetterH(String pFieldName){
    
            this.setPFieldName(pFieldName);
    
    }
    
    
    private void setPFieldName( String pFieldName ){
        if(pFieldName == null){
            throw ObjectMacroException.parameterNull("FieldName");
        }
    
        this.field_FieldName = pFieldName;
    }
    
        void setMacroName(
                Context context,
                String value) {
    
            if(value == null){
                throw new RuntimeException("value cannot be null here");
            }
    
            this.field_MacroName.put(context, value);
        }
    
    
    private String buildFieldName(){
    
        return this.field_FieldName;
    }
    
    private String buildMacroName(Context context){
    
        return this.field_MacroName.get(context);
    }
    
    
    private String getFieldName(){
    
        return this.field_FieldName;
    }
    
    private String getMacroName(Context context){
    
        return this.field_MacroName.get(context);
    }
    
    
    
    
    
    @Override
     void apply(
             InternalsInitializer internalsInitializer){
    
         internalsInitializer.setInternalStringGetterH(this);
     }
    
    
    @Override
    public String build(Context context){
    
        BuildState buildState = this.build_states.get(context);
    
        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("InternalStringGetterH");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_states.put(context, buildState);
        List<String> indentations = new LinkedList<>();
        StringBuilder sbIndentation = new StringBuilder();
    
        
        
    
        StringBuilder sb0 = new StringBuilder();
    
        sb0.append("void* M");
        sb0.append(buildMacroName(context));
        sb0.append("_get");
        sb0.append(buildFieldName());
        sb0.append("(M");
        sb0.append(buildMacroName(context));
        sb0.append(" *this, Context *key);");
    
        buildState.setExpansion(sb0.toString());
        return sb0.toString();
    }
    
    
    private String applyIndent(
                            String macro,
                            String indent){

            StringBuilder sb = new StringBuilder();
            String[] lines = macro.split( "\n");

            if(lines.length > 1){
                for(int i = 0; i < lines.length; i++){
                    String line = lines[i];
                    sb.append(indent).append(line);

                    if(i < lines.length - 1){
                        sb.append(LINE_SEPARATOR);
                    }
                }
            }
            else{
                sb.append(indent).append(macro);
            }

            return sb.toString();
    }
}