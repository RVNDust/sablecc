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

package org.sablecc.objectmacro.codegeneration.java;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

import org.sablecc.objectmacro.codegeneration.*;
<<<<<<< HEAD
<<<<<<< HEAD
import org.sablecc.objectmacro.codegeneration.java.structure.Macro;
=======
import org.sablecc.objectmacro.codegeneration.java.macro.MMacro;
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
import org.sablecc.objectmacro.codegeneration.java.structure.Macro;
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
import org.sablecc.objectmacro.exception.*;
import org.sablecc.util.*;

public class JavaCodeGenerator
        extends CodeGenerator {

    private File packageDirectory;

    public JavaCodeGenerator(
            IntermediateRepresentation ir) {

        super(ir);
    }

    private File getPakcageDirectory() {

        if (this.packageDirectory == null) {
            String packageName = getIr().getDestinationPackage();
            if (!packageName.equals("")) {
                String packageDirectoryName = packageName.replace('.', '/');
                this.packageDirectory = new File(getIr()
                        .getDestinationDirectory(), packageDirectoryName);
            }
            else {
                this.packageDirectory = getIr().getDestinationDirectory();
            }
        }

        return this.packageDirectory;
    }

    @Override
    public void verifyTargetSpecificSemantics(
            Strictness strictness) {

        // nothing to verify
    }

    @Override
    public void generateCode() {

        File packageDirectory = getPakcageDirectory();

        if (!packageDirectory.exists()) {
            if (!packageDirectory.mkdirs()) {
                CompilerException.cannotCreateDirectory(packageDirectory
                        .toString());
            }
        }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        Map<String, Macro> macros = new LinkedHashMap<>();
=======
        Map<String, MMacro> macros = new LinkedHashMap<>();
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
        Map<String, Macro> macros = new LinkedHashMap<>();
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name

        MacroCollector macroCollector = new MacroCollector(macros);
        getIr().getAST().apply(macroCollector);

        CodeGenerationWalker walker = new CodeGenerationWalker(getIr(),
<<<<<<< HEAD
<<<<<<< HEAD
                packageDirectory, macros);
<<<<<<< HEAD
<<<<<<< HEAD
        UtilsGenerationWalker utilsGenerationWalker = new UtilsGenerationWalker(getIr(), packageDirectory);

        getIr().getAST().apply(walker);
        getIr().getAST().apply(utilsGenerationWalker);
=======
//        CodeGenerationWalker walker = new CodeGenerationWalker(getIr(),
//                packageDirectory);
//        getIr().getAST().apply(walker);
>>>>>>> Comment Code generation to compile ObjectMacro
=======
        getIr().getAST().apply(walker);
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
        UtilsGenerationWalker utilsGenerationWalker = new UtilsGenerationWalker(getIr(), packageDirectory);

        getIr().getAST().apply(walker);
        getIr().getAST().apply(utilsGenerationWalker);
>>>>>>> Moved utils files for generation to another walker
=======
                packageDirectory);
        /*MyWalker walker = new MyWalker(getIr());*/
        getIr().getAST().apply(walker);
>>>>>>> Changement Objectmacro-back
=======
                packageDirectory, macros);
        UtilsGenerationWalker utilsGenerationWalker = new UtilsGenerationWalker(getIr(), packageDirectory);

        getIr().getAST().apply(walker);
        getIr().getAST().apply(utilsGenerationWalker);
>>>>>>> Revert "Changement Objectmacro-back"
    }
}
