/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.c.macro;

import java.util.*;

public class MFieldMacroDeclaration extends Macro{
    
    private String field_FieldName;
    
    
    
    
    public MFieldMacroDeclaration(String pFieldName){
    
            this.setPFieldName(pFieldName);
    
    }
    
    
    private void setPFieldName( String pFieldName ){
        if(pFieldName == null){
            throw ObjectMacroException.parameterNull("FieldName");
        }
    
        this.field_FieldName = pFieldName;
    }
    
    
    private String buildFieldName(){
    
        return this.field_FieldName;
    }
    
    
    private String getFieldName(){
    
        return this.field_FieldName;
    }
    
    
    
    
    
    @Override
     void apply(
             InternalsInitializer internalsInitializer){
    
         internalsInitializer.setFieldMacroDeclaration(this);
     }
    
    
    @Override
    public String build(){
    
        BuildState buildState = this.build_state;
    
        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("FieldMacroDeclaration");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_state = buildState;
        List<String> indentations = new LinkedList<>();
        StringBuilder sbIndentation = new StringBuilder();
    
        
        
    
        StringBuilder sb0 = new StringBuilder();
    
        sb0.append("struct LinkedList *list_");
        sb0.append(buildFieldName());
        sb0.append(";");
    
        buildState.setExpansion(sb0.toString());
        return sb0.toString();
    }
    
    
    @Override
    String build(Context context) {
     return build();
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