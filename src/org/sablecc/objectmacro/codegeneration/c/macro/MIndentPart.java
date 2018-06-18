/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.c.macro;

import java.util.*;

public class MIndentPart extends Macro{
    
    private String field_IndexBuilder;
    
    private String field_IndexIndent;
    
    private Map<Context, String> field_MacroName = new LinkedHashMap<>();
    
    
    
    
    public MIndentPart(String pIndexBuilder, String pIndexIndent){
    
            this.setPIndexBuilder(pIndexBuilder);
            this.setPIndexIndent(pIndexIndent);
    
    }
    
    
    private void setPIndexBuilder( String pIndexBuilder ){
        if(pIndexBuilder == null){
            throw ObjectMacroException.parameterNull("IndexBuilder");
        }
    
        this.field_IndexBuilder = pIndexBuilder;
    }
    
    private void setPIndexIndent( String pIndexIndent ){
        if(pIndexIndent == null){
            throw ObjectMacroException.parameterNull("IndexIndent");
        }
    
        this.field_IndexIndent = pIndexIndent;
    }
    
        void setMacroName(
                Context context,
                String value) {
    
            if(value == null){
                throw new RuntimeException("value cannot be null here");
            }
    
            this.field_MacroName.put(context, value);
        }
    
    
    private String buildIndexBuilder(){
    
        return this.field_IndexBuilder;
    }
    
    private String buildIndexIndent(){
    
        return this.field_IndexIndent;
    }
    
    private String buildMacroName(Context context){
    
        return this.field_MacroName.get(context);
    }
    
    
    private String getIndexBuilder(){
    
        return this.field_IndexBuilder;
    }
    
    private String getIndexIndent(){
    
        return this.field_IndexIndent;
    }
    
    private String getMacroName(Context context){
    
        return this.field_MacroName.get(context);
    }
    
    
    
    
    
    @Override
     void apply(
             InternalsInitializer internalsInitializer){
    
         internalsInitializer.setIndentPart(this);
     }
    
    
    @Override
    public String build(Context context){
    
        BuildState buildState = this.build_states.get(context);
    
        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("IndentPart");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_states.put(context, buildState);
        List<String> indentations = new LinkedList<>();
        StringBuilder sbIndentation = new StringBuilder();
    
        
        
    
        StringBuilder sb0 = new StringBuilder();
    
        sb0.append("sb");
        sb0.append(buildIndexBuilder());
        sb0.append("->vt->append(sb");
        sb0.append(buildIndexBuilder());
        sb0.append(", M");
        sb0.append(buildMacroName(context));
        sb0.append("_applyIndent(sb");
        sb0.append(buildIndexIndent());
        sb0.append("->vt->toString(sb");
        sb0.append(buildIndexIndent());
        sb0.append("), indentations->vt->getAtIndex(indentations, indentations->size-1)));");
        sb0.append(LINE_SEPARATOR);
        sb0.append("indentations->vt->removeLast(indentations);");
    
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