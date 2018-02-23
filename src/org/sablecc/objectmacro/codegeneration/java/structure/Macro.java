<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Removed in constructor initialization and add lazy initialization
/* This file is part of SableCC ( http://sablecc.org ).
 *
 * See the NOTICE file distributed with this work for copyright information.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

<<<<<<< HEAD
=======
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
=======
>>>>>>> Removed in constructor initialization and add lazy initialization
=======
>>>>>>> Changement Objectmacro-back
package org.sablecc.objectmacro.codegeneration.java.structure;

import org.sablecc.objectmacro.codegeneration.java.macro.MMacro;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import java.util.*;

=======
import java.util.List;
=======
import java.util.*;
>>>>>>> Moved utils files for generation to another walker

<<<<<<< HEAD
/**
 * Created by lam on 17/11/17.
 */
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
=======
>>>>>>> Removed in constructor initialization and add lazy initialization
=======
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lam on 17/11/17.
 */
>>>>>>> Changement Objectmacro-back
public class Macro {

    private MMacro macro;

    private final List<String> parameters;

    private final List<String> internals;

<<<<<<< HEAD
<<<<<<< HEAD
    private final String name;

    private final List<String> parametersName;

    private final List<String> internalsName;

    public Macro(
            MMacro macro,
            List<String> parametersName,
            List<String> internalsName,
            String name){

        this.macro = macro;
        this.parametersName = parametersName;
        this.internalsName = internalsName;
        this.name = name;
    }

    public List<String> getInternalsName() {
        return this.internalsName;
    }

    public List<String> getParametersName() {
        return this.parametersName;
    }

    public MMacro getMacro() {
        return this.macro;
    }

    public String getName(){
        return this.name;
=======
=======
    private final String name;

<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> Init internals before building the macro instead at the add or addAll methods
    private final List<String> parameters;
=======
    private final List<String> parametersName;
>>>>>>> Moved utils files for generation to another walker
=======
    private ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> list_ListPackage = new ArrayList<>();
    public ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> getPackages() {return this.list_ListPackage; }
    public void setPackage(ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> listPackage) {this.list_ListPackage = listPackage;}

    private ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> list_ListField = new ArrayList<>();
    public ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> getField() {return this.list_ListField; }
    public void setField(ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> listField) {this.list_ListField = listField;}

    private ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> list_ListContextField = new ArrayList<>();
    public ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> getContextField() {return this.list_ListContextField; }
    public void setContextField(ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> listContextField) {this.list_ListContextField = listContextField;}

    private ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> list_ListConstructor = new ArrayList<>();
    public ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> getConstructor() {return this.list_ListConstructor; }
    public void setConstructor(ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> listConstructor) {this.list_ListConstructor = listConstructor;}

    private ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> list_ListSetter = new ArrayList<>();
    public ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> getSetter() {return this.list_ListSetter; }
    public void setSetter(ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> listSetter) {this.list_ListSetter = listSetter;}
>>>>>>> Changement Objectmacro-back

    private ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> list_ListBuilder = new ArrayList<>();
    public ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> getBuilder() {return this.list_ListBuilder; }
    public void setBuilder(ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> listBuilder) {this.list_ListBuilder = listBuilder;}

    private ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> list_ListRef = new ArrayList<>();
    public ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> getRef() {return this.list_ListRef; }
    public void setRef(ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> listRef) {this.list_ListRef = listRef;}

    private ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> list_ListRedefinedApplyInitializer = new ArrayList<>();
    public ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> getRedefinedApplyInitializer() {return this.list_ListRedefinedApplyInitializer; }
    public void setRedefinedApplyInitializer(ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> listRedefinedApplyInitializer) {this.list_ListRedefinedApplyInitializer = listRedefinedApplyInitializer;}

    private ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> list_ListMacroBuilder = new ArrayList<>();
    public ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> getMacroBuilder() {return this.list_ListMacroBuilder; }
    public void setMacroBuilder(ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> listMacroBuilder) {this.list_ListMacroBuilder = listMacroBuilder;}

    private ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> list_ListEmptyBuilderWithContext = new ArrayList<>();
    public ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> getEmptyBuilderWithContext() {return this.list_ListEmptyBuilderWithContext; }
    public void setEmptyBuilderWithContext(ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> listEmptyBuilderWithContext) {this.list_ListEmptyBuilderWithContext = listEmptyBuilderWithContext;}

    public Macro(
            String name,
            List<String> parameters,
            List<String> internals){
        this.name = name;
        this.parameters = parameters;
        this.internals = internals;
    }

    public List<String> getInternals() {

        return internals;
    }

    public List<String> getParameters() {

        return parameters;
    }

    private void buildMacro() {
        this.macro = new MMacro(name,
                list_ListPackage.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[list_ListPackage.size()]),
                list_ListField.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[list_ListField.size()]),
                list_ListContextField.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[list_ListContextField.size()]),
                list_ListConstructor.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[list_ListConstructor.size()]),
                list_ListSetter.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[list_ListSetter.size()]),
                list_ListBuilder.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[list_ListBuilder.size()]),
                list_ListRef.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[list_ListRef.size()]),
                list_ListRedefinedApplyInitializer.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[list_ListRedefinedApplyInitializer.size()]),
                list_ListMacroBuilder.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[list_ListMacroBuilder.size()]),
                list_ListEmptyBuilderWithContext.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[list_ListEmptyBuilderWithContext.size()]) );
    }

<<<<<<< HEAD
<<<<<<< HEAD
        return macro;
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
=======
    public String getName(){
        return this.name;
>>>>>>> Init internals before building the macro instead at the add or addAll methods
=======
    public MMacro getMacro() {
        buildMacro();
        return macro;
>>>>>>> Changement Objectmacro-back
    }
}
