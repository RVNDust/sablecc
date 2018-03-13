/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

public class MClassInternalValue extends Macro{

    private Macro list_PackageDeclaration[];

    private final Context PackageDeclarationContext = new Context();

    public MClassInternalValue(Macro pPackageDeclaration[]){

        this.setPPackageDeclaration(pPackageDeclaration);
    }

    private void setPPackageDeclaration(Macro pPackageDeclaration[]){
        if(pPackageDeclaration == null){
            throw ObjectMacroException.parameterNull("PackageDeclaration");
        }

        Macro macros[] = pPackageDeclaration;
        this.list_PackageDeclaration = new Macro[macros.length];
        int i = 0;

        for(Macro macro : macros){
            if(macro == null){
                throw ObjectMacroException.macroNull(i, "PackageDeclaration");
            }

            macro.apply(new InternalsInitializer("PackageDeclaration"){
@Override
void setPackageDeclaration(MPackageDeclaration mPackageDeclaration){

        }
});

            this.list_PackageDeclaration[i++] = macro;

        }
    }

    private String buildPackageDeclaration(){

        StringBuilder sb0 = new StringBuilder();
        Context local_context = PackageDeclarationContext;
        Macro macros[] = this.list_PackageDeclaration;
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

    private Macro[] getPackageDeclaration(){

        return this.list_PackageDeclaration;
    }

    @Override
    void apply(
            InternalsInitializer internalsInitializer){

        internalsInitializer.setClassInternalValue(this);
    }

    @Override
    public String build(){

        String local_expansion = this.expansion;

        if(local_expansion != null){
            return local_expansion;
        }

        StringBuilder sb0 = new StringBuilder();

        MHeader minsert_1 = new MHeader();
                        sb0.append(minsert_1.build(null));
        sb0.append(LINE_SEPARATOR);
        sb0.append(buildPackageDeclaration());
        sb0.append(LINE_SEPARATOR);
        MImportJavaUtil minsert_2 = new MImportJavaUtil();
                        sb0.append(minsert_2.build(null));
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("class InternalValue ");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    private final List<Macro> macros;");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    private DAfterLast dAfterLast;");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    private DBeforeFirst dBeforeFirst;");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    private DSeparator dSeparator;");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    private DNone dNone;");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    private final Context context;");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    private String cache;");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    InternalValue(");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            List<Macro> macros,");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            Context context)");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("        this.macros = macros;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        this.context = context;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    }");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    String build()");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("        if(this.cache != null)");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            return this.cache;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        }");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("        StringBuilder sb = new StringBuilder();");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        int i = 0;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        int nb_macros = this.macros.size();");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("        if(this.dNone != null)");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            sb.append(this.dNone.apply(i, \"\", nb_macros));");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        }");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("        for(Macro macro : this.macros)");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            String expansion = macro.build(this.context);");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("            if(this.dBeforeFirst != null)");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("                expansion = dBeforeFirst.apply(i, expansion, nb_macros);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            }");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("            if(dAfterLast != null)");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("                expansion = dAfterLast.apply(i, expansion, nb_macros);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            }");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("            if(this.dSeparator != null)");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("                expansion = dSeparator.apply(i, expansion, nb_macros);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            }");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("            sb.append(expansion);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            i++;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        }");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("        this.cache = sb.toString();");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        return this.cache;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    }");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    void setNone(");
        sb0.append(LINE_SEPARATOR);
        sb0.append("                DNone none)");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("        this.dNone = none;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    }");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    void setBeforeFirst(");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            DBeforeFirst dBeforeFirst)");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("        this.dBeforeFirst = dBeforeFirst;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    }");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    void setAfterLast(");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            DAfterLast dAfterLast)");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("        this.dAfterLast = dAfterLast;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    }");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    void setSeparator(");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            DSeparator dSeparator)");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("        this.dSeparator = dSeparator;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    }");
        sb0.append(LINE_SEPARATOR);
        sb0.append("}");

        local_expansion = sb0.toString();
        this.expansion = local_expansion;
        return local_expansion;
    }
<<<<<<< HEAD
    sb.append(System.getProperty("line.separator"));
    sb.append("class InternalValue {");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("    private final List<Macro> macros;");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
    sb.append("    private final List<Directive> directives;");
=======
    sb.append("    private DAfterLast dAfterLast;");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("    private DBeforeFirst dBeforeFirst;");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("    private DSeparator dSeparator;");
>>>>>>> Remove abstraction on directives when building a macro or a parameter
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("    private DNone dNone;");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
<<<<<<< HEAD
    sb.append("    private final Context context;");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("    private String cache;");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
<<<<<<< HEAD
=======
=======
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
    sb.append("    private final Context context;");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
>>>>>>> Add structure which contains list of macros and the context associated
=======
>>>>>>> Add cache to InternalsValue
    sb.append("    InternalValue(");
    sb.append(System.getProperty("line.separator"));
    sb.append("            List<Macro> macros,");
    sb.append(System.getProperty("line.separator"));
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    sb.append("            Context context,");
    sb.append(System.getProperty("line.separator"));
    sb.append("            List<Directive> directives){");
=======
    sb.append("            Context context){");
>>>>>>> Add structure which contains list of macros and the context associated
=======
    sb.append("            Context context,");
    sb.append(System.getProperty("line.separator"));
    sb.append("            List<Directive> directives){");
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
=======
    sb.append("            Context context){");
>>>>>>> Remove abstraction on directives when building a macro or a parameter
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        this.macros = macros;");
    sb.append(System.getProperty("line.separator"));
    sb.append("        this.context = context;");
    sb.append(System.getProperty("line.separator"));
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    sb.append("        this.directives = directives;");
    sb.append(System.getProperty("line.separator"));
=======
>>>>>>> Add structure which contains list of macros and the context associated
=======
    sb.append("        this.directives = directives;");
    sb.append(System.getProperty("line.separator"));
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
=======
>>>>>>> Remove abstraction on directives when building a macro or a parameter
    sb.append("    }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("    String build(){");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Add cache to InternalsValue
    sb.append("        if(this.cache != null){");
    sb.append(System.getProperty("line.separator"));
    sb.append("            return this.cache;");
    sb.append(System.getProperty("line.separator"));
    sb.append("        }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
<<<<<<< HEAD
    sb.append("        StringBuilder sb = new StringBuilder();");
    sb.append(System.getProperty("line.separator"));
    sb.append("        int i = 0;");
    sb.append(System.getProperty("line.separator"));
    sb.append("        int nb_macros = this.macros.size();");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        if(this.dNone != null){");
    sb.append(System.getProperty("line.separator"));
    sb.append("            sb.append(this.dNone.apply(i, \"\", nb_macros));");
    sb.append(System.getProperty("line.separator"));
    sb.append("        }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        for(Macro macro : this.macros){");
    sb.append(System.getProperty("line.separator"));
    sb.append("            String expansion = macro.build(this.context);");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("            if(this.dBeforeFirst != null){");
    sb.append(System.getProperty("line.separator"));
    sb.append("                expansion = dBeforeFirst.apply(i, expansion, nb_macros);");
    sb.append(System.getProperty("line.separator"));
    sb.append("            }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("            if(dAfterLast != null){");
    sb.append(System.getProperty("line.separator"));
    sb.append("                expansion = dAfterLast.apply(i, expansion, nb_macros);");
    sb.append(System.getProperty("line.separator"));
    sb.append("            }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("            if(this.dSeparator != null){");
    sb.append(System.getProperty("line.separator"));
    sb.append("                expansion = dSeparator.apply(i, expansion, nb_macros);");
    sb.append(System.getProperty("line.separator"));
    sb.append("            }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("            sb.append(expansion);");
    sb.append(System.getProperty("line.separator"));
    sb.append("            i++;");
=======
=======
>>>>>>> Add cache to InternalsValue
    sb.append("        StringBuilder sb = new StringBuilder();");
    sb.append(System.getProperty("line.separator"));
    sb.append("        int i = 0;");
    sb.append(System.getProperty("line.separator"));
    sb.append("        int nb_macros = this.macros.size();");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        if(this.dNone != null){");
    sb.append(System.getProperty("line.separator"));
    sb.append("            sb.append(this.dNone.apply(i, \"\", nb_macros));");
    sb.append(System.getProperty("line.separator"));
    sb.append("        }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        for(Macro macro : this.macros){");
    sb.append(System.getProperty("line.separator"));
<<<<<<< HEAD
    sb.append("            sb.append(macro.build(this.context));");
>>>>>>> Add structure which contains list of macros and the context associated
=======
    sb.append("            String expansion = macro.build(this.context);");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("            for(Directive directive : this.directives){");
    sb.append(System.getProperty("line.separator"));
    sb.append("                expansion = directive.apply(i, expansion, nb_macros);");
    sb.append(System.getProperty("line.separator"));
    sb.append("            }");
    sb.append(System.getProperty("line.separator"));
    sb.append("            sb.append(expansion);");
    sb.append(System.getProperty("line.separator"));
    sb.append("            i++;");
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
    sb.append(System.getProperty("line.separator"));
    sb.append("        }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
<<<<<<< HEAD
<<<<<<< HEAD
    sb.append("        this.cache = sb.toString();");
    sb.append(System.getProperty("line.separator"));
    sb.append("        return this.cache;");
=======
    sb.append("        return sb.toString();");
>>>>>>> Add structure which contains list of macros and the context associated
=======
    sb.append("        this.cache = sb.toString();");
    sb.append(System.getProperty("line.separator"));
    sb.append("        return this.cache;");
>>>>>>> Add cache to InternalsValue
    sb.append(System.getProperty("line.separator"));
    sb.append("    }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("    void setNone(");
    sb.append(System.getProperty("line.separator"));
    sb.append("                DNone none){");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        this.dNone = none;");
    sb.append(System.getProperty("line.separator"));
    sb.append("    }");
    sb.append(System.getProperty("line.separator"));
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
    sb.append(System.getProperty("line.separator"));
    sb.append("    void setBeforeFirst(");
    sb.append(System.getProperty("line.separator"));
    sb.append("            DBeforeFirst dBeforeFirst){");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        this.dBeforeFirst = dBeforeFirst;");
    sb.append(System.getProperty("line.separator"));
    sb.append("    }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("    void setAfterLast(");
    sb.append(System.getProperty("line.separator"));
    sb.append("            DAfterLast dAfterLast){");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        this.dAfterLast = dAfterLast;");
    sb.append(System.getProperty("line.separator"));
    sb.append("    }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("    void setSeparator(");
    sb.append(System.getProperty("line.separator"));
    sb.append("            DSeparator dSeparator){");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        this.dSeparator = dSeparator;");
    sb.append(System.getProperty("line.separator"));
    sb.append("    }");
    sb.append(System.getProperty("line.separator"));
<<<<<<< HEAD
=======
>>>>>>> Add structure which contains list of macros and the context associated
=======
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
    sb.append("}");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }
=======
>>>>>>> MaJ Fichier de Macro + Generation

    @Override
    String build(Context context) {
        return build();
    }
}
