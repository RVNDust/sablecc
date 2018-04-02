<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Removed in constructor initialization and add lazy initialization
=======
>>>>>>> Revert "Changement Objectmacro-back"
=======
>>>>>>> object-macro2.1
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
=======
>>>>>>> Removed in constructor initialization and add lazy initialization
=======
>>>>>>> Changement Objectmacro-back
=======
>>>>>>> Revert "Changement Objectmacro-back"
=======
>>>>>>> object-macro2.1
package org.sablecc.objectmacro.codegeneration.java.structure;

import org.sablecc.objectmacro.codegeneration.java.macro.MMacro;

<<<<<<< HEAD
<<<<<<< HEAD
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
=======
import java.util.*;

>>>>>>> Revert "Changement Objectmacro-back"
=======
import java.util.*;

>>>>>>> object-macro2.1
public class Macro {

    private final MMacro macro;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    private final String name;

    private final List<String> parametersName;
<<<<<<< HEAD

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
=======
>>>>>>> Revert "Changement Objectmacro-back"
=======
    private final String name;

    private final List<String> parametersName;
>>>>>>> object-macro2.1

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

<<<<<<< HEAD
<<<<<<< HEAD
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
=======
    public String getName(){
        return this.name;
>>>>>>> Revert "Changement Objectmacro-back"
=======
    public String getName(){
        return this.name;
>>>>>>> object-macro2.1
    }
}
