/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.c.macro;

import java.util.*;

public class MClassInternalValueH extends Macro{
    
    
    
    
    
    public MClassInternalValueH(){
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    @Override
     void apply(
             InternalsInitializer internalsInitializer){
    
         internalsInitializer.setClassInternalValueH(this);
     }
    
    
    @Override
    public String build(){
    
        BuildState buildState = this.build_state;
    
        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("ClassInternalValueH");
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
        sb0.append("ifndef INTERNALVALUE_H");
        sb0.append(LINE_SEPARATOR);
        sb0.append("#");
        sb0.append("define INTERNALVALUE_H");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("extern struct InternalValue_VT VT_InternalValue;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("extern void *HT_InternalValue[];");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("typedef struct InternalValue");
        sb0.append(LINE_SEPARATOR);
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    struct InternalValue_VT (*vt);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    LinkedList *macros;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    struct DAfterLast *dAfterLast;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    struct DBeforeFirst *dBeforeFirst;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    struct DSeparator *dSeparator;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    struct DNone *dNone;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    Context context;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    char* cache;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("} InternalValue;");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("typedef struct InternalValue_VT");
        sb0.append(LINE_SEPARATOR);
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    int hl;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    void* (*ht)[];");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    char* (*build)(struct InternalValue*);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    void (*setNone)(struct InternalValue*, struct DNone*);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    void (*setBeforeFirst)(struct InternalValue*, struct DBeforeFirst*);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    void (*setAfterLast)(struct InternalValue*, struct DAfterLast*);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    void (*setSeparator)(struct InternalValue*, struct DSeparator*);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("} InternalValue_VT;");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("InternalValue* new_InternalValue(LinkedList *macros, Context context);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("void free_InternalValue(struct InternalValue*);");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("char* InternalValue_build(struct InternalValue*);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("void InternalValue_setNone(struct InternalValue*, struct DNone*);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("void InternalValue_setBeforeFirst(struct InternalValue*, struct DBeforeFirst*);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("void InternalValue_setAfterLast(struct InternalValue*, struct DAfterLast*);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("void InternalValue_setSeparator(struct InternalValue*, struct DSeparator*);");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("#");
        sb0.append("endif //INTERNALVALUE_H");
        sb0.append(LINE_SEPARATOR);
    
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