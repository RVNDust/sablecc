/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.c.macro;
import java.util.*;

class InternalValue {

    private final List<Macro> macros;

    private DAfterLast dAfterLast;

    private DBeforeFirst dBeforeFirst;

    private DSeparator dSeparator;

    private DNone dNone;

    private final Context context;

    private String cache;

    InternalValue(
            List<Macro> macros,
            Context context){

        this.macros = macros;
        this.context = context;
    }

    String build(){

        if(this.cache != null){
            return this.cache;
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int nb_macros = this.macros.size();

        if(this.dNone != null){
            sb.append(this.dNone.apply(i, "", nb_macros));
        }

        for(Macro macro : this.macros){
            String expansion = macro.build(this.context);

            if(this.dBeforeFirst != null){
                expansion = dBeforeFirst.apply(i, expansion, nb_macros);
            }

            if(dAfterLast != null){
                expansion = dAfterLast.apply(i, expansion, nb_macros);
            }

            if(this.dSeparator != null){
                expansion = dSeparator.apply(i, expansion, nb_macros);
            }

            sb.append(expansion);
            i++;
        }

        this.cache = sb.toString();
        return this.cache;
    }

    void setNone(
                DNone none){

        this.dNone = none;
    }

    void setBeforeFirst(
            DBeforeFirst dBeforeFirst){

        this.dBeforeFirst = dBeforeFirst;
    }

    void setAfterLast(
            DAfterLast dAfterLast){

        this.dAfterLast = dAfterLast;
    }

    void setSeparator(
            DSeparator dSeparator){

        this.dSeparator = dSeparator;
    }
}