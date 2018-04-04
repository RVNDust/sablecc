/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

import java.util.*;

<<<<<<< HEAD
public class MInternalsInitializer {

  private final List<Object> ePackageDeclaration = new LinkedList<Object>();
  private final List<Object> eImportJavaUtil = new LinkedList<Object>();
  private final List<Object> eParentInternalsSetter = new LinkedList<Object>();

  public MInternalsInitializer() {
  }

  public MPackageDeclaration newPackageDeclaration(String pPackageName) {
    MPackageDeclaration lPackageDeclaration = new MPackageDeclaration(pPackageName);
    this.ePackageDeclaration.add(lPackageDeclaration);
    return lPackageDeclaration;
  }

  public MImportJavaUtil newImportJavaUtil() {
    MImportJavaUtil lImportJavaUtil = new MImportJavaUtil();
    this.eImportJavaUtil.add(lImportJavaUtil);
    return lImportJavaUtil;
  }

  public MParentInternalsSetter newParentInternalsSetter(String pName) {
    MParentInternalsSetter lParentInternalsSetter = new MParentInternalsSetter(pName);
    this.eParentInternalsSetter.add(lParentInternalsSetter);
    return lParentInternalsSetter;
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
    }
    for(Object oImportJavaUtil : this.eImportJavaUtil) {
      sb.append(oImportJavaUtil.toString());
    }
    sb.append(System.getProperty("line.separator"));
    sb.append("public class InternalsInitializer {");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("    private final String _paramName;");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    sb.append("    InternalsInitializer(String paramName){");
    sb.append(System.getProperty("line.separator"));
    sb.append("        this._paramName = paramName;");
    sb.append(System.getProperty("line.separator"));
    sb.append("    }");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    {
      boolean first = true;
      for(Object oParentInternalsSetter : this.eParentInternalsSetter) {
        if(first) {
          first = false;
        }
        else {
          sb.append(System.getProperty("line.separator"));
        }
        sb.append(oParentInternalsSetter.toString());
      }
=======
public class MInternalsInitializer extends Macro{

    private final List<Macro> list_PackageDeclaration;
    private DSeparator PackageDeclarationSeparator;

    private DBeforeFirst PackageDeclarationBeforeFirst;

    private DAfterLast PackageDeclarationAfterLast;

    private DNone PackageDeclarationNone;
    private final InternalValue PackageDeclarationValue;
    private final List<Macro> list_ListParentInternalSetters;
    private DSeparator ListParentInternalSettersSeparator;

    private DBeforeFirst ListParentInternalSettersBeforeFirst;

    private DAfterLast ListParentInternalSettersAfterLast;

    private DNone ListParentInternalSettersNone;
    private final InternalValue ListParentInternalSettersValue;

    private final Context PackageDeclarationContext = new Context();    private final Context ListParentInternalSettersContext = new Context();

    public MInternalsInitializer(){


    this.list_PackageDeclaration = new ArrayList<>();    this.list_ListParentInternalSetters = new ArrayList<>();

    this.PackageDeclarationValue = new InternalValue(this.list_PackageDeclaration, this.PackageDeclarationContext);    this.ListParentInternalSettersValue = new InternalValue(this.list_ListParentInternalSetters, this.ListParentInternalSettersContext);
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
    public void addListParentInternalSetters(MParentInternalsSetter macro){
        if(macro == null){
            throw ObjectMacroException.parameterNull("ListParentInternalSetters");
        }
                if(this.build_state != null){
            throw ObjectMacroException.cannotModify("ParentInternalsSetter");
        }

        this.list_ListParentInternalSetters.add(macro);
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
    }
    private String buildListParentInternalSetters(){
        StringBuilder sb = new StringBuilder();
        Context local_context = ListParentInternalSettersContext;
        List<Macro> macros = this.list_ListParentInternalSetters;

        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;

        if(this.ListParentInternalSettersNone != null){
            sb.append(this.ListParentInternalSettersNone.apply(i, "", nb_macros));
        }

        for(Macro macro : macros){
            expansion = macro.build(local_context);

            if(this.ListParentInternalSettersBeforeFirst != null){
                expansion = this.ListParentInternalSettersBeforeFirst.apply(i, expansion, nb_macros);
            }

            if(this.ListParentInternalSettersAfterLast != null){
                expansion = this.ListParentInternalSettersAfterLast.apply(i, expansion, nb_macros);
            }

            if(this.ListParentInternalSettersSeparator != null){
                expansion = this.ListParentInternalSettersSeparator.apply(i, expansion, nb_macros);
            }

            sb.append(expansion);
            i++;
        }

        return sb.toString();
    }

    private InternalValue getPackageDeclaration(){
        return this.PackageDeclarationValue;
    }
    private InternalValue getListParentInternalSetters(){
        return this.ListParentInternalSettersValue;
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
    private void initListParentInternalSettersInternals(Context context){
        for(Macro macro : this.list_ListParentInternalSetters){
            macro.apply(new InternalsInitializer("ListParentInternalSetters"){
@Override
void setParentInternalsSetter(MParentInternalsSetter mParentInternalsSetter){

    
    
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
    private void initListParentInternalSettersDirectives(){
        StringBuilder sb0 = new StringBuilder();
        sb0.append(LINE_SEPARATOR);
this.ListParentInternalSettersSeparator = new DSeparator(sb0.toString());
this.ListParentInternalSettersValue.setSeparator(this.ListParentInternalSettersSeparator);
    }
    @Override
    void apply(
            InternalsInitializer internalsInitializer){

        internalsInitializer.setInternalsInitializer(this);
    }

   @Override
    public String build(){

        BuildState buildState = this.build_state;

        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("InternalsInitializer");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_state = buildState;

        initPackageDeclarationDirectives();
initListParentInternalSettersDirectives();

        initPackageDeclarationInternals(null);
initListParentInternalSettersInternals(null);

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
        sb0.append("public class InternalsInitializer ");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    private final String _paramName;");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("    InternalsInitializer(String paramName)");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        sb0.append("        this._paramName = paramName;");
        sb0.append(LINE_SEPARATOR);
        sb0.append("    }");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append(buildListParentInternalSetters());
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("}");

        buildState.setExpansion(sb0.toString());
        return sb0.toString();
>>>>>>> Mise à jour Visiteur - Build OK
    }
    sb.append(System.getProperty("line.separator"));
    sb.append("}");
    sb.append(System.getProperty("line.separator"));
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }

<<<<<<< HEAD
}
=======
    @Override
    String build(Context context) {
        return build();
    }
}
>>>>>>> Correctifs objectmacro2-java(back)
