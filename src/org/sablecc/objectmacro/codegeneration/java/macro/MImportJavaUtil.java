/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

<<<<<<< HEAD
<<<<<<< HEAD
public class MImportJavaUtil {

  public MImportJavaUtil() {
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("import java.util.*;");
    sb.append(System.getProperty("line.separator"));
    return sb.toString();
  }

=======
import java.util.*;

public class MImportJavaUtil extends Macro{



    public MImportJavaUtil(){


=======
import java.util.*;

public class MImportJavaUtil extends Macro{



    public MImportJavaUtil(){


>>>>>>> object-macro2.1

    }





    @Override
    void apply(
            InternalsInitializer internalsInitializer){
<<<<<<< HEAD

        internalsInitializer.setImportJavaUtil(this);
    }

   @Override
    public String build(){

        BuildState buildState = this.build_state;

        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("ImportJavaUtil");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_state = buildState;

        

        

        StringBuilder sb0 = new StringBuilder();

        sb0.append("import java.util.*;");

        buildState.setExpansion(sb0.toString());
        return sb0.toString();
    }

=======

        internalsInitializer.setImportJavaUtil(this);
    }

   @Override
    public String build(){

        BuildState buildState = this.build_state;

        if(buildState == null){
            buildState = new BuildState();
        }
        else if(buildState.getExpansion() == null){
            throw ObjectMacroException.cyclicReference("ImportJavaUtil");
        }
        else{
            return buildState.getExpansion();
        }
        this.build_state = buildState;

        

        

        StringBuilder sb0 = new StringBuilder();

        sb0.append("import java.util.*;");

        buildState.setExpansion(sb0.toString());
        return sb0.toString();
    }

>>>>>>> object-macro2.1
    @Override
    String build(Context context) {
        return build();
    }
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> Mise à jour Visiteur - Build OK
}
=======
}
>>>>>>> Correctifs objectmacro2-java(back)
=======
}
>>>>>>> object-macro2.1
