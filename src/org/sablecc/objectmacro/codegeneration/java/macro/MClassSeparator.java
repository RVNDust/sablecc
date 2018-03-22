/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

import java.util.*;
<<<<<<< HEAD

public class MClassSeparator {

  private final List<Object> ePackageDeclaration = new LinkedList<Object>();

  public MClassSeparator() {
  }

  public MPackageDeclaration newPackageDeclaration(String pPackageName) {
    MPackageDeclaration lPackageDeclaration = new MPackageDeclaration(pPackageName);
    this.ePackageDeclaration.add(lPackageDeclaration);
    return lPackageDeclaration;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(new MHeader().toString());
    if(this.ePackageDeclaration.size() > 0) {
      sb.append(System.getProperty("line.separator"));
    }
    for(Object oPackageDeclaration : this.ePackageDeclaration) {
      sb.append(oPackageDeclaration.toString());
=======

public class MClassSeparator extends Macro{

    private final List<Macro> list_PackageDeclaration;
    private DSeparator PackageDeclarationSeparator;

    private DBeforeFirst PackageDeclarationBeforeFirst;

    private DAfterLast PackageDeclarationAfterLast;

    private DNone PackageDeclarationNone;
    private final InternalValue PackageDeclarationValue;

    private final Context PackageDeclarationContext = new Context();

    public MClassSeparator(){


    this.list_PackageDeclaration = new ArrayList<>();

    this.PackageDeclarationValue = new InternalValue(this.list_PackageDeclaration, this.PackageDeclarationContext);
    }

    public void addPackageDeclaration(MPackageDeclaration macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("PackageDeclaration");
        }
                if(this.build_state != null){
            throw ObjectMacroException.cannotModify("PackageDeclaration");
        }

        this.list_PackageDeclaration.add(macro);
    }

    private String buildPackageDeclaration(){
        StringBuilder sb = new StringBuilder();
        Context local_context = PackageDeclarationContext;
        List<Macro> macros = this.list_PackageDeclaration;

        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;

        if(this.PackageDeclarationNone != null){
            sb.append(this.PackageDeclarationNone.apply(i, "", nb_macros));
        }

        for(Macro macro : macros){
            expansion = macro.build(local_context);

            if(this.PackageDeclarationBeforeFirst != null){
                expansion = this.PackageDeclarationBeforeFirst.apply(i, expansion, nb_macros);
            }

            if(this.PackageDeclarationAfterLast != null){
                expansion = this.PackageDeclarationAfterLast.apply(i, expansion, nb_macros);
            }

            if(this.PackageDeclarationSeparator != null){
                expansion = this.PackageDeclarationSeparator.apply(i, expansion, nb_macros);
            }

            sb.append(expansion);
            i++;
        }

        return sb.toString();
>>>>>>> Mise à jour Visiteur - Build OK
    }
    sb.append(System.getProperty("line.separator"));
    sb.append("class DSeparator");
    sb.append(System.getProperty("line.separator"));
    sb.append("        extends Directive {");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("    DSeparator(String value) {");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        super(value);");
    sb.append(System.getProperty("line.separator"));
    sb.append("    }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("    @Override");
    sb.append(System.getProperty("line.separator"));
    sb.append("    String apply(");
    sb.append(System.getProperty("line.separator"));
    sb.append("            Integer index,");
    sb.append(System.getProperty("line.separator"));
    sb.append("            String macro,");
    sb.append(System.getProperty("line.separator"));
    sb.append("            Integer list_size) {");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        if(index == list_size - 1){");
    sb.append(System.getProperty("line.separator"));
    sb.append("            return macro;");
    sb.append(System.getProperty("line.separator"));
    sb.append("        }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("        return macro.concat(this.value);");
    sb.append(System.getProperty("line.separator"));
    sb.append("    }");
    sb.append(System.getProperty("line.separator"));
    sb.append("}");
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }

<<<<<<< HEAD
=======
    private InternalValue getPackageDeclaration(){
        return this.PackageDeclarationValue;
    }
    private void initPackageDeclarationInternals(Context context){
        for(Macro macro : this.list_PackageDeclaration){
            macro.apply(new InternalsInitializer("PackageDeclaration"){
@Override
void setPackageDeclaration(MPackageDeclaration mPackageDeclaration){

    
    
}
});
        }
    }

    private void initPackageDeclarationDirectives(){
        StringBuilder sb0 = new StringBuilder();
        sb0.append(LINE_SEPARATOR);
this.PackageDeclarationBeforeFirst = new DBeforeFirst(sb0.toString());
this.PackageDeclarationValue.setBeforeFirst(this.PackageDeclarationBeforeFirst);
    }
    @Override
    void apply(
            InternalsInitializer internalsInitializer){

        internalsInitializer.setClassSeparator(this);
    }

   @Override
    public String build(){

        BuildState buildState = this.build_state;

        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("ClassSeparator");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_state = buildState;

        initPackageDeclarationDirectives();

        initPackageDeclarationInternals(null);

        StringBuilder sb0 = new StringBuilder();

        MHeader minsert_1 = new MHeader();
        
        
        sb0.append(minsert_1.build(null));
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append(buildPackageDeclaration());
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("class DSeparator");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        extends Directive ");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    DSeparator(String value) ");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("        super(value);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    }");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    @Override");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    String apply(");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            Integer index,");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            String macro,");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            Integer list_size) ");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("        if(index == list_size - 1)");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("            return macro;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        }");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("        return macro.concat(this.value);");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    }");
        sb0.append(LINE_SEPARATOR);
        sb0.append("}");

        buildState.setExpansion(sb0.toString());
        return sb0.toString();
    }

    @Override
    String build(Context context) {
        return build();
    }
<<<<<<< HEAD
>>>>>>> Mise à jour Visiteur - Build OK
}
=======
}
>>>>>>> Correctifs objectmacro2-java(back)
