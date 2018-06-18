/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.c.macro;

import java.util.*;

public class MStrSplitFunctionC extends Macro{
    
    private Map<Context, String> field_MacroName = new LinkedHashMap<>();
    
    
    
    
    public MStrSplitFunctionC(){
    
    
    }
    
    
        void setMacroName(
                Context context,
                String value) {
    
            if(value == null){
                throw new RuntimeException("value cannot be null here");
            }
    
            this.field_MacroName.put(context, value);
        }
    
    
    private String buildMacroName(Context context){
    
        return this.field_MacroName.get(context);
    }
    
    
    private String getMacroName(Context context){
    
        return this.field_MacroName.get(context);
    }
    
    
    
    
    
    @Override
     void apply(
             InternalsInitializer internalsInitializer){
    
         internalsInitializer.setStrSplitFunctionC(this);
     }
    
    
    @Override
    public String build(Context context){
    
        BuildState buildState = this.build_states.get(context);
    
        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("StrSplitFunctionC");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_states.put(context, buildState);
        List<String> indentations = new LinkedList<>();
        StringBuilder sbIndentation = new StringBuilder();
    
        
        
    
        StringBuilder sb0 = new StringBuilder();
    
        sb0.append("char** M");
        sb0.append(buildMacroName(context));
        sb0.append("_strSplit(char* a_str, const char a_delim)");
        sb0.append(LINE_SEPARATOR);
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    char** result    = 0;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    size_t count     = 0;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    char* tmp        = a_str;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    char* last_comma = 0;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    char delim[2];");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    delim[0] = a_delim;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    delim[1] = 0;");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    /* Count how many elements will be extracted. */");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    while (*tmp)");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    ");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        if (a_delim == *tmp)");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        ");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            count++;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            last_comma = tmp;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        }");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        tmp++;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    }");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    /* Add space for trailing token. */");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    count += last_comma < (a_str + strlen(a_str) - 1);");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    /* Add space for terminating NULL string so caller");
        sb0.append(LINE_SEPARATOR);
        sb0.append("       knows where the list of returned strings ends. */");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    count++;");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    result = malloc(sizeof(char*) * count);");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    if (result)");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    ");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        size_t idx  = 0;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        char* token = strtok(a_str, delim);");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("        while (token)");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        ");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            assert(idx < count);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            *(result + idx++) = strdup(token);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            token = strtok(0, delim);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        }");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        assert(idx == count - 1);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        *(result + idx) = 0;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    }");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    return result;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("}");
    
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