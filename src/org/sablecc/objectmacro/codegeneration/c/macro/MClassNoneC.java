/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.c.macro;

import java.util.*;

public class MClassNoneC extends Macro{
    
    
    
    
    
    public MClassNoneC(){
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    @Override
     void apply(
             InternalsInitializer internalsInitializer){
    
         internalsInitializer.setClassNoneC(this);
     }
    
    
    @Override
    public String build(){
    
        BuildState buildState = this.build_state;
    
        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("ClassNoneC");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_state = buildState;
        List<String> indentations = new LinkedList<>();
        StringBuilder sbIndentation = new StringBuilder();
    
        
        
    
        StringBuilder sb0 = new StringBuilder();
    
        MHeader minsert_2 = new MHeader();
        
        
        sb0.append(minsert_2.build(null));
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("#");
        sb0.append("include<stdlib.h>");
        sb0.append(LINE_SEPARATOR);
        sb0.append("#");
        sb0.append("include<stdio.h>");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("#");
        sb0.append("include \"DNone.h\"");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("struct DNone_VT VT_DNone = ");
        sb0.append("{");
        sb0.append("1, &HT_DNone, &DNone_apply};");
        sb0.append(LINE_SEPARATOR);
        sb0.append("void* HT_DNone[] = ");
        sb0.append("{");
        sb0.append("&VT_DNone};");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("DNone* new_DNone(char* value)");
        sb0.append(LINE_SEPARATOR);
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    DNone* none = malloc(sizeof(DNone));");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    none->vt = &VT_DNone;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    none->value = value;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    return none;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("}");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("void free_DNone(DNone* this)");
        sb0.append(LINE_SEPARATOR);
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    free(this);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("}");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("char* DNone_apply(DNone *this, int index, char* macro, int list_size)");
        sb0.append(LINE_SEPARATOR);
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    if(list_size == 0)");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        return this->value;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    }");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    return macro;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("}");
    
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