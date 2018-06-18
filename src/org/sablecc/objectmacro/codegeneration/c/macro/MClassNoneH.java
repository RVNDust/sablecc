/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.c.macro;

import java.util.*;

public class MClassNoneH extends Macro{
    
    
    
    
    
    public MClassNoneH(){
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    @Override
     void apply(
             InternalsInitializer internalsInitializer){
    
         internalsInitializer.setClassNoneH(this);
     }
    
    
    @Override
    public String build(){
    
        BuildState buildState = this.build_state;
    
        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("ClassNoneH");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_state = buildState;
        List<String> indentations = new LinkedList<>();
        StringBuilder sbIndentation = new StringBuilder();
    
        
        
    
        StringBuilder sb0 = new StringBuilder();
    
        MHeader minsert_1 = new MHeader();
        
        
        sb0.append(minsert_1.build(null));
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("#");
        sb0.append("ifndef DNONE_H");
        sb0.append(LINE_SEPARATOR);
        sb0.append("#");
        sb0.append("define DNONE_H");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("extern struct DNone_VT VT_DNone;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("extern void *HT_DNone;");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("typedef struct DNone");
        sb0.append(LINE_SEPARATOR);
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    struct DNone_VT (*vt);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    char* value;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("} DNone;");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("typedef struct DNone_VT");
        sb0.append(LINE_SEPARATOR);
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    int hl;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    void* (*ht)[];");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    char* (*apply)(int index, char* macro, int list_size);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("} DNone_VT;");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("DNone* new_DNone(char* value);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("void free_DNone(struct DNone*);");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("char* DNone_apply(int index, char* macro, int list_size);");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("#");
        sb0.append("endif //DNONE_H");
    
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