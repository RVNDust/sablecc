<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Add copyrights
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
<<<<<<< HEAD
<<<<<<< HEAD
 */
<<<<<<< HEAD
=======
 *//*

>>>>>>> Changement Objectmacro-back
=======
 */
>>>>>>> Revert "Changement Objectmacro-back"
package org.sablecc.objectmacro.codegeneration.java;

import org.sablecc.objectmacro.codegeneration.java.macro.MMacro;
import org.sablecc.objectmacro.codegeneration.java.structure.Macro;
import org.sablecc.objectmacro.intermediate.syntax3.analysis.DepthFirstAdapter;
import org.sablecc.objectmacro.intermediate.syntax3.node.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MacroCollector
        extends DepthFirstAdapter{

    private final Map<String, Macro> macros;

    private List<String> currentParameters = new LinkedList<>();

    private List<String> currentInternals = new LinkedList<>();

    public MacroCollector(
            Map<String, Macro> macros){
=======
=======
>>>>>>> Add copyrights
package org.sablecc.objectmacro.codegeneration.java;

import org.sablecc.objectmacro.codegeneration.java.macro.MMacro;
import org.sablecc.objectmacro.codegeneration.java.structure.Macro;
import org.sablecc.objectmacro.intermediate.syntax3.analysis.DepthFirstAdapter;
import org.sablecc.objectmacro.intermediate.syntax3.node.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MacroCollector
        extends DepthFirstAdapter{

    private final Map<String, Macro> macros;

    private List<String> currentParameters = new LinkedList<>();

    private List<String> currentInternals = new LinkedList<>();

    public MacroCollector(
<<<<<<< HEAD
            Map<String, MMacro> macros){
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
            Map<String, Macro> macros){
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name

        this.macros = macros;
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    @Override
    public void inAMacro(
            AMacro node) {

        this.currentParameters = new LinkedList<>();
        this.currentInternals = new LinkedList<>();
    }

    @Override
    public void outAMacro(
            AMacro node) {

        String macro_name = GenerationUtils.buildNameCamelCase(node.getNames());
        this.macros.put(macro_name,
                new Macro(new MMacro(macro_name), this.currentParameters, this.currentInternals, macro_name));

    }

    @Override
    public void caseAParam(
            AParam node) {

        String param_name = GenerationUtils.buildNameCamelCase(node.getNames());
        this.currentParameters.add(param_name);
    }

    @Override
    public void caseAInternal(
            AInternal node) {

        String param_name = GenerationUtils.buildNameCamelCase(node.getNames());
        this.currentInternals.add(param_name);
    }

=======
=======
>>>>>>> Changement Objectmacro-back
    private String string(
            TString tString) {

        String string = tString.getText();
        int length = string.length();
        return string.substring(1, length - 1);
    }

    private String buildNameCamelCase(
            LinkedList<TString> names){

        StringBuilder paramName = new StringBuilder();
        for(TString partName : names){
            paramName.append(Utils.toCamelCase(string(partName)));
        }

        return paramName.toString();
    }

<<<<<<< HEAD
=======
>>>>>>> Moved utils files for generation to another walker
=======
>>>>>>> Changement Objectmacro-back
=======
>>>>>>> Revert "Changement Objectmacro-back"
    @Override
    public void inAMacro(
            AMacro node) {

        this.currentParameters = new LinkedList<>();
        this.currentInternals = new LinkedList<>();
    }
<<<<<<< HEAD
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======

    @Override
    public void outAMacro(
            AMacro node) {

        String macro_name = GenerationUtils.buildNameCamelCase(node.getNames());
        this.macros.put(macro_name,
                new Macro(new MMacro(macro_name), this.currentParameters, this.currentInternals, macro_name));

    }

    @Override
    public void caseAParam(
            AParam node) {

        String param_name = GenerationUtils.buildNameCamelCase(node.getNames());
        this.currentParameters.add(param_name);
    }

    @Override
    public void caseAInternal(
            AInternal node) {

        String param_name = GenerationUtils.buildNameCamelCase(node.getNames());
        this.currentInternals.add(param_name);
    }

>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
}
