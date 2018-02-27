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
<<<<<<< HEAD
<<<<<<< HEAD
import java.util.*;
=======
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
import java.util.*;
>>>>>>> Moved utils files for generation to another walker

import org.sablecc.exception.*;
import org.sablecc.objectmacro.codegeneration.*;
import org.sablecc.objectmacro.codegeneration.c.macro.MParam;
import org.sablecc.objectmacro.codegeneration.java.macro.*;
import org.sablecc.objectmacro.codegeneration.java.structure.Macro;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
import org.sablecc.objectmacro.exception.*;
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
=======
>>>>>>> Moved utils files for generation to another walker
=======
import org.sablecc.objectmacro.codegeneration.java.structure.ParamMacroRefStruct;
import org.sablecc.objectmacro.codegeneration.java.structure.ParamStringStruct;
import org.sablecc.objectmacro.exception.*;
>>>>>>> Changement Objectmacro-back
import org.sablecc.objectmacro.intermediate.syntax3.analysis.*;
import org.sablecc.objectmacro.intermediate.syntax3.node.*;
import org.sablecc.objectmacro.syntax3.node.PStringPart;
import org.sablecc.objectmacro.util.Utils;

public class CodeGenerationWalker
        extends DepthFirstAdapter {
<<<<<<< HEAD
<<<<<<< HEAD
=======

<<<<<<< HEAD
    private static final String CONTEXT_STRING = "Context";

    private static final String INSERT_VAR_NAME = "insert_";

    private static final String SEPARATOR_DIRECTIVE = "separator";

<<<<<<< HEAD
=======
    private static final String CONTEXT_STRING = "Context";

    private static final String INSERT_VAR_NAME = "insert_";

    private static final String SEPARATOR_DIRECTIVE = "separator";

>>>>>>> Changement Objectmacro-back
    private static final String AFTER_LAST_DIRECTIVE = "afterlast";

    private static final String NONE_DIRECTIVE = "none";

    private static final String BEFORE_FIRST_DIRECTIVE = "beforefirst";
<<<<<<< HEAD
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1

=======
>>>>>>> Moved utils files for generation to another walker
=======

>>>>>>> Changement Objectmacro-back
    private final IntermediateRepresentation ir;

    private final File packageDirectory;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Add comments and updated notice
    /**
     * List of macros in the file
     */
    private final Map<String, Macro> macros;

    /**
     * Object Macro with name and list of internals and parameters
     */
    private Macro currentMacro;

    /**
     * Current parameter name
     */
    private String currentParamName;

    /**
     * Macro representing the super class Macro
     */
    private MSuperMacro superMacro;

    /**
     * Macro representing an internal initializer super class
     */
    private MInternalsInitializer mInternalsInitializer;

    /**
     * Macro representing the class macro
     */
    private MMacro currentMacroToBuild;

    /**
     * Macro representing the constructor of a macro
     */
    private MConstructor currentConstructor;

    /**
     * Macro representing the method builder
     */
    private MMacroBuilder currentMacroBuilder;

    /**
     * Macro representing the apply internal initializer inside the method init internals
     */
    private MApplyInternalsInitializer currentApplyInitializer;

    /**
     * Macro representing the apply internal initializer inside the method addAll
     */
    private MApplyInternalsInitializer currentAddAllApplyInitializer;

    /**
     * Macro representing the redefined internals setter inside in apply initializer
     */
    private MRedefinedInternalsSetter currentRedefinedInternalsSetter;

    /**
     * Index of the current builder to avoid creating 2 StringBuilder of the same name
     */
    private Integer indexBuilder = 0;

    /**
     * Index of the current builder to avoid creating 2 macro objects for inserts of the same name
     */
    private Integer indexInsert = 0;

    /**
     * Created StringBuilders in the children of a AParameter node or AInternal node
     * This list is reset in the internal or parameter node's out
     */
    private List<String> createdBuilders = new ArrayList<>();

    /**
     * Created macro objects for inserts in the children of a AParameter node or AInternal node
     * This list is reset in the internal or parameter node's out
     */
    private List<Integer> createdInserts = new ArrayList<>();

    /**
     * Name of the current macro which is referenced
     */
    private String currentMacroRefName;
<<<<<<< HEAD

    /**
     * Name of the current context
     */
    private String currentContextName;

    /**
     * Names of all contexts created for the current Macro
     */
    private List<String> contextNames = new ArrayList<>();

    /**
     * Macro representing an insert in a macro body
     */
    private MInsertMacroPart currentInsertMacroPart;

    /**
     * Macro representing a parameter's builder
     */
    private MParamMacroRefBuilder currentParamMacroRefBuilder;

    /**
     * Macro representing the method to initialize directives
     */
    private MInitDirectives currentInitDirectives;

    /**
     * Macro representing the creation of an object Directive
     */
    private MNewDirective currentDirective;

    /**
     * Macro representing the creation of an object of the directive None
     */
    private MSetNoneDirective mSetNoneDirective;

    /**
     * Boolean to test whether the macro has or does not have internals
     */
    private boolean currentMacroHasInternals;
=======
    private MMacro currentMacro;
=======
    private MMacro currentMacroToBuild;

    private Macro currentMacro;
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name

    private MConstructor currentConstructor;

    private MSuperMacro superMacro;

    private MInternalsInitializer mInternalsInitializer;

    private MContext mContext;

    private MMacroBuilder currentMacroBuilder;

    private MApplyInternalsInitializer currentApplyInitializer;

    private MRedefinedInternalsSetter currentRedefinedInternalsSetter;

    private Integer indexBuilder = 0;

    private Integer indexInsert = 0;

    private String currentMacroName;

    private Map<String, Macro> macros = new LinkedHashMap<>();

    private Map<String, ParamStringStruct> currentMacroParamString = new LinkedHashMap<>();
    private Map<String, ParamMacroRefStruct> currentMacroParamMacroRef = new LinkedHashMap<>();

    private String currentContext;

    private MInsertMacroPart currentInsertMacroPart;
=======

    /**
     * Name of the current context
     */
    private String currentContextName;
>>>>>>> Add comments and updated notice

    /**
     * Names of all contexts created for the current Macro
     */
    private List<String> contextNames = new ArrayList<>();

    /**
     * Macro representing an insert in a macro body
     */
    private MInsertMacroPart currentInsertMacroPart;

    /**
     * Macro representing a parameter's builder
     */
    private MParamMacroRefBuilder currentParamMacroRefBuilder;

<<<<<<< HEAD
    private MPackageDeclaration packageDeclaration;

    private ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> currentParamList = new ArrayList<>();

    private ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> currentInternalList = new ArrayList<>();

    private MParentInternalsSetter currentInternalParentSetter;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    private MParamMacroRef currentParamMacroRef;
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
    private MParamMacroRefBuilder currentParamMacroRefBuilder;
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
=======
=======
    /**
     * Macro representing the method to initialize directives
     */
    private MInitDirectives currentInitDirectives;

    /**
     * Macro representing the creation of an object Directive
     */
    private MNewDirective currentDirective;

    /**
     * Macro representing the creation of an object of the directive None
     */
>>>>>>> Add comments and updated notice
    private MSetNoneDirective mSetNoneDirective;
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
=======
    private MRedefinedApplyInitializer currentRedefinedApplyInitializer;
>>>>>>> Changement Objectmacro-back

<<<<<<< HEAD
    private ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> currentParamSet;

    private ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> currentContextParam = new ArrayList<>();
    private ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> currentContextExpansion = new ArrayList<>();
    private ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> currentNewContextExpansion = new ArrayList<>();
    private ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> currentPublic = new ArrayList<>();
    private ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> currentEmptyBuilderWithContext = new ArrayList<>();
    private ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> currentListParts = new ArrayList<>();

    private ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> currentSeparators = new ArrayList<>();
    private ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> currentBeforeFirst = new ArrayList<>();
    private ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> currentAfterLast = new ArrayList<>();
    private ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> currentNone = new ArrayList<>();

    private boolean isInAMacroRef = false;


    private MStringParam currentStringParam;

    private ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> currentListRedefinedInternalSetter = new ArrayList<>();
=======
    /**
     * Boolean to test whether the macro has or does not have internals
     */
    private boolean currentMacroHasInternals;
>>>>>>> Add comments and updated notice

    public CodeGenerationWalker(
            IntermediateRepresentation ir,
<<<<<<< HEAD
            File packageDirectory,
<<<<<<< HEAD
<<<<<<< HEAD
            Map<String, Macro> macros) {
=======
            Map<String, MMacro> macros) {
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
            Map<String, Macro> macros) {
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
=======
            File packageDirectory) {
>>>>>>> Changement Objectmacro-back

        this.ir = ir;
        this.packageDirectory = packageDirectory;
    }

    private String string(
            TString tString) {

        String string = tString.getText();
        int length = string.length();
        return string.substring(1, length - 1);
    }

    private String escapedString(
            TString tString) {

        StringBuilder sb = new StringBuilder();
        String s = string(tString);
        boolean escaped = false;
        for (char c : s.toCharArray()) {
            if (escaped) {
                escaped = false;

                if (c == '\\') {
                    sb.append('\\');
                    sb.append('\\');
                }
                else if (c == '\'') {
                    sb.append('\'');
                }
                else {
                    throw new InternalException("unhandled case");
                }
            }
            else if (c == '\\') {
                escaped = true;
            }
            else if (c == '\"') {
                sb.append('\\');
                sb.append('\"');
            }
            else {
                sb.append(c);
            }
        }

        if (escaped) {
            throw new InternalException("incomplete escape");
        }

        return sb.toString();
    }

    private String buildNameCamelCase(
            LinkedList<TString> name_parts){

        StringBuilder macroName = new StringBuilder();
        for(TString partName : name_parts){
            macroName.append(Utils.toCamelCase(string(partName)));
        }

        return macroName.toString();
    }

    private String buildName(
            LinkedList<TString> name_parts){

        StringBuilder macroName = new StringBuilder();
        for(TString partName : name_parts){
            macroName.append(string(partName));
        }

        return macroName.toString();
    }

    private void writeFile(
            String fileName,
            String content){

        File destination = new File(this.packageDirectory, fileName);

        try {
            FileWriter fw = new FileWriter(destination);
            fw.write(content);
            fw.close();
        }
        catch (IOException e) {
            throw CompilerException.outputError(destination.toString(), e);
        }
    }

    private String getLetterFromInteger(
            Integer i){

        return i > 0 && i < 27 ? String.valueOf((char) (i + 64)) : null;
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
    private String string(
            TString tString) {

        String string = tString.getText();
        int length = string.length();
        return string.substring(1, length - 1);
    }

    private String escapedString(
            TString tString) {

        StringBuilder sb = new StringBuilder();
        String s = string(tString);
        boolean escaped = false;
        for (char c : s.toCharArray()) {
            if (escaped) {
                escaped = false;

                if (c == '\\') {
                    sb.append('\\');
                    sb.append('\\');
                }
                else if (c == '\'') {
                    sb.append('\'');
                }
                else {
                    throw new InternalException("unhandled case");
                }
            }
            else if (c == '\\') {
                escaped = true;
            }
            else if (c == '\"') {
                sb.append('\\');
                sb.append('\"');
            }
            else {
                sb.append(c);
            }
        }

        if (escaped) {
            throw new InternalException("incomplete escape");
        }

        return sb.toString();
    }

    private String buildNameCamelCase(
            LinkedList<TString> name_parts){

        StringBuilder macroName = new StringBuilder();
        for(TString partName : name_parts){
            macroName.append(Utils.toCamelCase(string(partName)));
        }
=======
>>>>>>> Moved utils files for generation to another walker


    private String getLetterFromInteger(
            Integer i){

        return i > 0 && i < 27 ? String.valueOf((char) (i + 64)) : null;
    }

>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
    @Override
    public void inAIntermediateRepresentation(
            AIntermediateRepresentation node) {

<<<<<<< HEAD
        this.superMacro = new MSuperMacro();
        this.mInternalsInitializer = new MInternalsInitializer();
<<<<<<< HEAD
<<<<<<< HEAD
=======
        this.mContext = new MContext();
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
>>>>>>> Moved utils files for generation to another walker

        if(!this.ir.getDestinationPackage().equals("")){
            String destinationPackage = this.ir.getDestinationPackage();
            this.superMacro.newPackageDeclaration(destinationPackage);
            this.mInternalsInitializer.newPackageDeclaration(destinationPackage);
<<<<<<< HEAD
<<<<<<< HEAD
=======
            this.mContext.newPackageDeclaration(destinationPackage);
<<<<<<< HEAD

>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
>>>>>>> Clean up code, add comments
=======
>>>>>>> Moved utils files for generation to another walker
=======
        if(!this.ir.getDestinationPackage().equals("")){
            String destinationPackage = this.ir.getDestinationPackage();
            packageDeclaration = new MPackageDeclaration(destinationPackage);
>>>>>>> Changement Objectmacro-back
        }

        this.superMacro = new MSuperMacro(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {this.packageDeclaration});
        //this.mInternalsInitializer = new MInternalsInitializer(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {this.packageDeclaration});
        this.mContext = new MContext(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {this.packageDeclaration});
    }

    @Override
    public void outAIntermediateRepresentation(
            AIntermediateRepresentation node) {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        GenerationUtils.writeFile(this.packageDirectory, "Macro.java", this.superMacro.toString());
        GenerationUtils
                .writeFile(this.packageDirectory,"InternalsInitializer.java", this.mInternalsInitializer.toString());
=======
        writeFile("Macro.java", this.superMacro.toString());
        writeFile("Context.java", this.mContext.toString());
        writeFile("InternalsInitializer.java", this.mInternalsInitializer.toString());

        MParameterNull mParameterNull = new MParameterNull();
        MIncorrectType mIncorrectType = new MIncorrectType();
        MObjectMacroErrorHead mObjectMacroErrorHead = new MObjectMacroErrorHead();
        MMacroNullInList mMacroNullInList = new MMacroNullInList();
        MCyclicReference mCyclicReference = new MCyclicReference();
        MCannotModify mCannotModify = new MCannotModify();
        MObjectMacroException mObjectMacroException = new MObjectMacroException();

        if(!this.ir.getDestinationPackage().equals("")){
            String destinationPackage = this.ir.getDestinationPackage();
            mIncorrectType.newPackageDeclaration(destinationPackage);
            mParameterNull.newPackageDeclaration(destinationPackage);
            mObjectMacroErrorHead.newPackageDeclaration(destinationPackage);
            mMacroNullInList.newPackageDeclaration(destinationPackage);
            mCyclicReference.newPackageDeclaration(destinationPackage);
            mCannotModify.newPackageDeclaration(destinationPackage);
            mObjectMacroException.newPackageDeclaration(destinationPackage);

        }

        writeFile("MIncorrectType.java", mIncorrectType.toString());
        writeFile("MParameterNull.java", mParameterNull.toString());
        writeFile("MObjectMacroErrorHead.java", mObjectMacroErrorHead.toString());
        writeFile("MMacroNullInList.java", mMacroNullInList.toString());
        writeFile("MCyclicReference.java", mCyclicReference.toString());
        writeFile("MCannotModify.java", mCannotModify.toString());
        writeFile("ObjectMacroException.java", mObjectMacroException.toString());
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
        GenerationUtils.writeFile(this.packageDirectory, "Macro.java", this.superMacro.toString());
        GenerationUtils
                .writeFile(this.packageDirectory,"InternalsInitializer.java", this.mInternalsInitializer.toString());
>>>>>>> Moved utils files for generation to another walker
=======
        this.mInternalsInitializer = new MInternalsInitializer(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {this.packageDeclaration}
        , new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {this.currentInternalParentSetter});

        writeFile("Macro.java", this.superMacro.build());
        writeFile("Context.java", this.mContext.build());
        writeFile("InternalsInitializer.java", this.mInternalsInitializer.build());

        MExParameterNull mParameterNull = new MExParameterNull(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {this.packageDeclaration});
        MExIncorrectType mIncorrectType = new MExIncorrectType(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {this.packageDeclaration});
        MExObjectMacroErrorHead mObjectMacroErrorHead = new MExObjectMacroErrorHead(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {this.packageDeclaration});
        MExMacroNullInList mMacroNullInList = new MExMacroNullInList(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {this.packageDeclaration});
        MExObjectMacroException mObjectMacroException = new MExObjectMacroException(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {this.packageDeclaration});

        if(!this.ir.getDestinationPackage().equals("")){
            String destinationPackage = this.ir.getDestinationPackage();
        }

        writeFile("MIncorrectType.java", mIncorrectType.build());
        writeFile("MParameterNull.java", mParameterNull.build());
        writeFile("MObjectMacroErrorHead.java", mObjectMacroErrorHead.build());
        writeFile("MMacroNullInList.java", mMacroNullInList.build());
        writeFile("ObjectMacroException.java", mObjectMacroException.build());
>>>>>>> Changement Objectmacro-back
    }

    @Override
    public void inAMacro(
            AMacro node) {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        String macroName = GenerationUtils.buildNameCamelCase(node.getNames());
        if(!this.macros.containsKey(macroName)){
            throw new InternalException(macroName + " does not exist");
        }
=======
        String macroName = buildNameCamelCase(node.getNames());
>>>>>>> Changement Objectmacro-back

        this.currentMacroName = macroName;

        if(!macros.containsKey(macroName))
            macros.put(macroName, new Macro(macroName, new LinkedList<>(), new LinkedList<>()));
        this.currentMacro = macros.get(macroName);

        this.contextNames = new ArrayList<>();

        if (!this.ir.getDestinationPackage().equals("")) {
            this.currentMacro.getPackages().add(this.packageDeclaration);
        }

<<<<<<< HEAD
        this.currentConstructor = this.currentMacroToBuild.newConstructor(macroName);
        this.currentMacroBuilder = this.currentMacroToBuild.newMacroBuilder(macroName);
<<<<<<< HEAD

        this.mInternalsInitializer.newParentInternalsSetter(macroName);
        this.currentMacroToBuild.newRedefinedApplyInitializer(macroName);

        this.currentMacroToBuild.newImportJavaUtil();
        this.currentMacroHasInternals = node.getInternals().size() > 0;

        if(this.currentMacroHasInternals){
            //method build is package protected so a context parameter to build the current macro
            this.currentMacroBuilder.newContextParam();
            this.currentMacroBuilder.newContextBuildState();
            this.currentMacroBuilder.newNewBuildState();
        }
        else{
            this.currentMacroBuilder.newPublic();
            this.currentMacroToBuild.newEmptyBuilderWithContext();
=======
        String macroName = buildNameCamelCase(node.getNames());
=======
        String macroName = GenerationUtils.buildNameCamelCase(node.getNames());
>>>>>>> Moved utils files for generation to another walker
        if(!this.macros.containsKey(macroName)){
            throw new InternalException(macroName + " does not exist");
        }

        this.currentMacro = this.macros.get(macroName);
        this.currentMacroToBuild = this.currentMacro.getMacro();
        this.contextNames = new ArrayList<>();

        if(this.currentMacroToBuild == null){
            throw new InternalException("currentMacroToBuild cannot be null here");
        }

        if (!this.ir.getDestinationPackage().equals("")) {
            this.currentMacroToBuild.newPackageDeclaration(this.ir.getDestinationPackage());
        }

        this.currentConstructor = this.currentMacroToBuild.newConstructor(macroName);
        this.currentMacroBuilder = this.currentMacroToBuild.newMacroBuilder();
=======
>>>>>>> Add BuildState class in order to do a cheap cycle verification on build method
=======
        //Définit dans le Out une fois passé dans tous les param et les internals
        /*this.currentConstructor = new MConstructor();*/
>>>>>>> Changement Objectmacro-back

        this.currentInternalParentSetter = new MParentInternalsSetter(this.currentMacroName);
        this.currentRedefinedApplyInitializer = new MRedefinedApplyInitializer(this.currentMacroName);
        this.currentMacro.getRedefinedApplyInitializer().add(this.currentRedefinedApplyInitializer);

        this.currentParamSet = new ArrayList<>();
        for(TString string : node.getInitOrder()){
            String param_name = Utils.toCamelCase(string(string));
            this.currentParamSet.add(new MSetParam(param_name, new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] { new MParamArg(param_name)}));
        }

        if(node.getInternals().size() > 0){
            //method build is package protected so a context parameter to build the current macro
            this.currentContextParam.add(new MContextParam());
            this.currentContextExpansion.add(new MContextExpansion());
            this.currentNewContextExpansion.add(new MNewContextExpansion());
        }
        else{
<<<<<<< HEAD
            this.currentMacroBuilder.newPublic();
<<<<<<< HEAD
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
            this.currentMacroToBuild.newEmptyBuilderWithContext();
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> Now macro without internals has a builder with context that only return build
=======
            this.currentMacroBuilder.newBuildVerification(macroName);
>>>>>>> Init internals before building the macro instead at the add or addAll methods
=======
>>>>>>> Add BuildState class in order to do a cheap cycle verification on build method
=======
            this.currentPublic.add(new MPublic());
            this.currentEmptyBuilderWithContext.add(new MEmptyBuilderWithContext());
>>>>>>> Changement Objectmacro-back
        }

        //Définition dans le OutAMacro pour avoir la liste des parts de la macro (4ème param du constructeur)
        /*this.currentMacroBuilder = new MMacroBuilder(this.currentPublic.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[currentPublic.size()])
            ,this.currentContextParam.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[currentContextParam.size()])
            ,this.currentContextExpansion.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[currentContextExpansion.size()])
            ,
            ,this.currentNewContextExpansion.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[currentNewContextExpansion.size()]));*/
    }

    /*@Override
    public void caseAInternal(
            AInternal node) {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        String paramName = GenerationUtils.buildNameCamelCase(node.getNames());

        if(node.getType() instanceof AStringType){
            this.currentMacroToBuild.newInternalStringField(paramName);
            this.currentMacroToBuild.newInternalStringSetter(paramName);

            MParamStringRefBuilder mParamStringRefBuilder = this.currentMacroToBuild
                    .newParamStringRefBuilder(paramName);
            mParamStringRefBuilder.newContextParam();
            mParamStringRefBuilder.newGetInternalTail();

            MParamStringRef mParamStringRef = this.currentMacroToBuild.newParamStringRef(paramName);
            mParamStringRef.newContextParam();
            mParamStringRef.newGetInternalTail();
        }
        else if(node.getType() instanceof AMacroRefsType){
            this.currentMacroToBuild.newInternalMacroField(paramName);
<<<<<<< HEAD

            this.currentMacroToBuild.newInternalMacroRefBuilder(paramName);
            this.currentMacroToBuild.newInternalMacroRef(paramName);

            this.indexBuilder = 0;
            this.currentMacroToBuild.newInternalMacroSetter(paramName);
=======
        String paramName = buildNameCamelCase(node.getNames());
=======
        String paramName = GenerationUtils.buildNameCamelCase(node.getNames());
>>>>>>> Moved utils files for generation to another walker
=======
        String paramName = buildNameCamelCase(node.getNames());
>>>>>>> Changement Objectmacro-back

        if(node.getType() instanceof AStringType){
            this.currentMacroToBuild.newInternalStringField(paramName);
            this.currentMacroToBuild.newInternalStringSetter(paramName);

            MParamStringRefBuilder mParamStringRefBuilder = this.currentMacroToBuild
                    .newParamStringRefBuilder(paramName);
            mParamStringRefBuilder.newContextParam();
            mParamStringRefBuilder.newGetInternalTail();

            MParamStringRef mParamStringRef = this.currentMacroToBuild.newParamStringRef(paramName);
            mParamStringRef.newContextParam();
            mParamStringRef.newGetInternalTail();
        }
        else if(node.getType() instanceof AMacroRefsType){
            this.currentMacroToBuild.newInternalMacroField(paramName);
            this.currentMacroToBuild.newContextField(paramName);
<<<<<<< HEAD
=======
>>>>>>> Add structure which contains list of macros and the context associated
=======
>>>>>>> Changement Objectmacro-back

            this.currentParamMacroRefBuilder = this.currentMacroToBuild
                    .newParamMacroRefBuilder(paramName, String.valueOf(this.indexBuilder));
            this.currentParamMacroRefBuilder.newContextParam();
            this.currentParamMacroRefBuilder.newGetInternalTail();
            this.currentParamMacroRefBuilder.newContextName(paramName.concat(CONTEXT_STRING));

            MParamMacroRef mParamMacroRef = this.currentMacroToBuild.newParamMacroRef(paramName);
            mParamMacroRef.newGetInternalTail();
            mParamMacroRef.newContextParam();

            //Initialize directives before type because of conflicts with stringBuilder
            for (PDirective directive : node.getDirectives()) {
                directive.apply(this);
            }

            this.indexBuilder = 0;
<<<<<<< HEAD
<<<<<<< HEAD

            this.currentContextName = paramName.concat(GenerationUtils.CONTEXT_STRING);
            this.contextNames.add(currentContextName);
            this.currentApplyInitializer =
                    this.currentMacroToBuild.newInternalMacroSetter(paramName)
                            .newApplyInternalsInitializer(paramName);
<<<<<<< HEAD

>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
>>>>>>> Removed in constructor initialization and add lazy initialization
=======
            this.currentMacroToBuild.newInternalMacroSetter(paramName);
>>>>>>> Add structure which contains list of macros and the context associated
=======

            this.currentContext = paramName.concat(CONTEXT_STRING);
            this.contextNames.add(currentContext);
            this.currentApplyInitializer =
                    this.currentMacroToBuild.newInternalMacroSetter(paramName)
                            .newApplyInternalsInitializer(paramName);

>>>>>>> Changement Objectmacro-back
        }
        else{
            throw new InternalException("case unhandled");
        }
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
        node.getType().apply(this);
        outAInternal(node);
    }

    @Override
    public void outAInternal(
            AInternal node) {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        this.currentContextName = null;
=======
        this.currentContext = null;
>>>>>>> Changement Objectmacro-back
        this.currentApplyInitializer = null;
        this.indexBuilder = 0;
        this.indexInsert = 0;
        this.currentParamMacroRefBuilder = null;
        this.createdBuilders = new ArrayList<>();
        this.createdInserts = new ArrayList<>();
<<<<<<< HEAD
=======
        this.currentContext = null;
=======
        this.currentContextName = null;
>>>>>>> Moved utils files for generation to another walker
        this.currentApplyInitializer = null;
        this.indexBuilder = 0;
        this.indexInsert = 0;
        this.currentParamMacroRefBuilder = null;
<<<<<<< HEAD
        this.createdBuilders.clear();
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
        this.createdBuilders = new ArrayList<>();
<<<<<<< HEAD
>>>>>>> fix creating same string builder in macro body
=======
        this.createdInserts = new ArrayList<>();
>>>>>>> Fix index inserts when creating 2 inserts in 2 different stringValue of a same macro reference
    }
=======
    }*/
>>>>>>> Changement Objectmacro-back

    @Override
    public void caseAParam(
            AParam node) {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        String paramName = this.currentParamName = GenerationUtils.buildNameCamelCase(node.getNames());
=======
        String paramName = buildNameCamelCase(node.getNames());
        ParamStringStruct paramStringStruct = new ParamStringStruct();
        ParamMacroRefStruct paramMacroRefStruct = new ParamMacroRefStruct();
>>>>>>> Changement Objectmacro-back

        if(node.getType() instanceof AStringType){
            paramStringStruct.mParamStringField = new MParamStringField(paramName);
            paramStringStruct.mParamStringRef = new MParamStringRef(paramName
                    , new org.sablecc.objectmacro.codegeneration.java.macro.Macro[0]
                    , new org.sablecc.objectmacro.codegeneration.java.macro.Macro[0]);
            paramStringStruct.mParamStringRefBuilder = new MParamStringRefBuilder(paramName
                    , new org.sablecc.objectmacro.codegeneration.java.macro.Macro[0]
                    , new org.sablecc.objectmacro.codegeneration.java.macro.Macro[0]);
            this.currentStringParam = new MStringParam(paramName);
            paramStringStruct.mParamStringSetter = new MParamStringSetter(paramName
                    , new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {this.currentStringParam}
                    , new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {new MParamArg(paramName)});

            this.currentParamList.add(this.currentStringParam);
            this.currentMacro.getField().add(paramStringStruct.mParamStringField);
            this.currentMacro.getRef().add(paramStringStruct.mParamStringRef);
            this.currentMacro.getBuilder().add(paramStringStruct.mParamStringRefBuilder);
            this.currentMacro.getSetter().add(paramStringStruct.mParamStringSetter);
            /*this.currentMacroParamString.put(paramName, param);*/
        }
        else if(node.getType() instanceof AMacroRefsType){
<<<<<<< HEAD

            this.currentMacroToBuild.newParamMacroField(paramName);
            this.currentMacroToBuild.newContextField(paramName);
            this.currentMacroToBuild.newDirectivesField(paramName);
            this.currentMacroToBuild.newInternalMacrosValueField(paramName);

            this.currentParamMacroRefBuilder = this.currentMacroToBuild.newParamMacroRefBuilder(
                    paramName, String.valueOf(this.indexBuilder));
            this.currentParamMacroRefBuilder.newContextName(paramName.concat(
                    GenerationUtils.CONTEXT_STRING));
            this.currentMacroToBuild.newParamMacroRef(paramName);

            this.currentInitDirectives = this.currentMacroToBuild.newInitDirectives(paramName);
=======
        String paramName = buildNameCamelCase(node.getNames());
=======
        String paramName = this.currentParamName = GenerationUtils.buildNameCamelCase(node.getNames());
>>>>>>> Add structure which contains list of macros and the context associated

        if(node.getType() instanceof AStringType){
            this.currentMacroToBuild.newParamStringField(paramName);
            this.currentMacroToBuild.newParamStringRefBuilder(paramName);
            this.currentMacroToBuild.newParamStringRef(paramName);

            MParamStringSetter mParamStringSetter = this.currentMacroToBuild.newParamStringSetter(paramName);
            mParamStringSetter.newParamArg(paramName);
            mParamStringSetter.newStringParam(paramName);

            this.currentConstructor.newStringParam(paramName);
            this.currentConstructor.newSetParam(paramName).newParamArg(paramName);
        }
        else if(node.getType() instanceof AMacroRefsType){

            this.currentMacroToBuild.newParamMacroField(paramName);
            this.currentMacroToBuild.newContextField(paramName);
            this.currentMacroToBuild.newDirectivesField(paramName);
            this.currentMacroToBuild.newInternalMacrosValueField(paramName);

            this.currentParamMacroRefBuilder = this.currentMacroToBuild.newParamMacroRefBuilder(
                    paramName, String.valueOf(this.indexBuilder));
<<<<<<< HEAD
<<<<<<< HEAD
            this.currentParamMacroRef.newContextName(paramName.concat(CONTEXT_STRING));
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
            this.currentParamMacroRefBuilder.newContextName(paramName.concat(CONTEXT_STRING));
=======
            this.currentParamMacroRefBuilder.newContextName(paramName.concat(
                    GenerationUtils.CONTEXT_STRING));
>>>>>>> Add structure which contains list of macros and the context associated
            this.currentMacroToBuild.newParamMacroRef(paramName);
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name

            this.currentInitDirectives = this.currentMacroToBuild.newInitDirectives(paramName);
=======
            paramMacroRefStruct.mParamMacroField = new MParamMacroField(paramName);
            paramMacroRefStruct.mContextField = new MContextField(paramName);
>>>>>>> Changement Objectmacro-back

            for (PDirective directive : node.getDirectives()) {
                directive.apply(this);
            }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
            this.currentContextName = paramName.concat(GenerationUtils.CONTEXT_STRING);
=======
            this.currentContext = paramName.concat(CONTEXT_STRING);
>>>>>>> Changement Objectmacro-back
            this.indexBuilder = 0;

            //Inutile avec la version 2 d'ObjectMacro ???
            /*MParamMacroSetter mParamMacroSetter = this.currentMacroToBuild.newParamMacroSetter(paramName);
            mParamMacroSetter.newParamArg(paramName);
            mParamMacroSetter.newMacroParam(paramName);*/

            this.currentParamList.add(new MMacroParam(paramName));
            this.contextNames.add(currentContext);

<<<<<<< HEAD
            this.contextNames.add(this.currentContextName);
<<<<<<< HEAD
            this.currentConstructor.newInitMacroParam(paramName);
            this.currentConstructor.newInitInternalValue(paramName);
            this.currentMacroBuilder.newInitDirectivesCall(paramName);

            if(this.currentMacroHasInternals){
                mInitInternalsCall.newContextArg();
            }
            else{
                mAddAll.newIsBuilt(this.currentMacro.getName());
            }
=======
            this.currentContext = paramName.concat(CONTEXT_STRING);
=======
            this.currentContextName = this.currentParamName.concat(
                    GenerationUtils.CONTEXT_STRING);
>>>>>>> Moved utils files for generation to another walker
=======
            this.currentContextName = paramName.concat(GenerationUtils.CONTEXT_STRING);
>>>>>>> Add structure which contains list of macros and the context associated
            this.indexBuilder = 0;

            MAddAll mAddAll = this.currentMacroToBuild.newAddAll(paramName);

            this.currentAddAllApplyInitializer = mAddAll.newApplyInternalsInitializer(paramName);
            this.currentApplyInitializer = this.currentMacroToBuild.newInitInternalsMethod(paramName)
<<<<<<< HEAD
                            .newApplyInternalsInitializer(paramName);
            this.contextNames.add(currentContext);
<<<<<<< HEAD
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
            this.currentConstructor.newInitMacroParam(paramName);
>>>>>>> Init internals before building the macro instead at the add or addAll methods
=======
                                                .newApplyInternalsInitializer(paramName);

            this.contextNames.add(currentContextName);
            this.currentConstructor.newInitMacroParam(paramName);
            this.currentConstructor.newInitInternalValue(paramName);
<<<<<<< HEAD
>>>>>>> Add structure which contains list of macros and the context associated
=======
=======
            this.currentConstructor.newInitMacroParam(paramName);
            this.currentConstructor.newInitInternalValue(paramName);
            this.currentMacroBuilder.newInitDirectivesCall(paramName);
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives

            if(this.currentMacroHasInternals){
                mInitInternalsCall.newContextArg();
            }
            else{
                mAddAll.newIsBuilt(this.currentMacro.getName());
            }
>>>>>>> Add BuildState class in order to do a cheap cycle verification on build method
=======
            paramMacroRefStruct.mParamMacroRef = new MParamMacroRef(paramName
            , new org.sablecc.objectmacro.codegeneration.java.macro.Macro[0]
            , new org.sablecc.objectmacro.codegeneration.java.macro.Macro[0]);

            this.currentMacro.getField().add(paramMacroRefStruct.mParamMacroField);
            this.currentMacro.getRef().add(paramMacroRefStruct.mParamMacroRef);
            this.currentMacro.getBuilder().add(paramMacroRefStruct.mParamMacroRefBuilder);
            this.currentMacro.getSetter().add(paramMacroRefStruct.mParamMacroSetter);
>>>>>>> Changement Objectmacro-back
        }
        else{
            throw new InternalException("case unhandled");
        }

<<<<<<< HEAD
<<<<<<< HEAD
=======
        this.currentParameters.add(paramName);
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
        node.getType().apply(this);

        if(node.getType() instanceof AMacroRefsType)
        {
            currentContextParam.add(new MContextParam());
            paramMacroRefStruct.mParamMacroRefBuilder = new MParamMacroRefBuilder(paramName
                    , String.valueOf(this.indexBuilder)
                    , currentContextParam.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[currentContextParam.size()])
                    , new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {new MContextName(paramName)}
                    , new org.sablecc.objectmacro.codegeneration.java.macro.Macro[0]
                    , this.currentNone.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[this.currentNone.size()])
                    , this.currentBeforeFirst.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[this.currentBeforeFirst.size()])
                    , this.currentSeparators.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[this.currentSeparators.size()])
                    , this.currentAfterLast.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[this.currentAfterLast.size()]));

            this.currentApplyInitializer = new MApplyInternalsInitializer(paramName
            , this.currentListRedefinedInternalSetter.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[this.currentListRedefinedInternalSetter.size()]));
        }

        outAParam(node);
    }

    @Override
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public void outAParam(
            AParam node) {
=======
    public void outAParam(AParam node) {
>>>>>>> Changement Objectmacro-back

        this.currentContext = null;
        this.currentApplyInitializer = null;
        this.indexBuilder = 0;
        this.indexInsert = 0;
        this.createdBuilders = new ArrayList<>();
        this.createdInserts = new ArrayList<>();
        this.currentParamMacroRefBuilder = null;
<<<<<<< HEAD
        this.currentInitDirectives = null;
<<<<<<< HEAD
=======
    public void outAParam(AParam node) {
=======
    public void outAParam(
            AParam node) {
>>>>>>> Add structure which contains list of macros and the context associated

        this.currentParamName = null;
        this.currentContextName = null;
        this.currentApplyInitializer = null;
        this.currentRedefinedInternalsSetter = null;
        this.indexBuilder = 0;
        this.indexInsert = 0;
<<<<<<< HEAD
        this.createdBuilders.clear();
<<<<<<< HEAD
        this.currentParamMacroRef = null;
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
=======
        this.createdBuilders = new ArrayList<>();
<<<<<<< HEAD
>>>>>>> fix creating same string builder in macro body
=======
        this.createdInserts = new ArrayList<>();
>>>>>>> Fix index inserts when creating 2 inserts in 2 different stringValue of a same macro reference
        this.currentParamMacroRefBuilder = null;
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
=======
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
=======
>>>>>>> Changement Objectmacro-back
    }

    @Override
    public void inADirective(
            ADirective node) {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        String directive_name = GenerationUtils.buildNameCamelCase(node.getNames());

        if(directive_name.equals(GenerationUtils.NONE_DIRECTIVE)){
            this.currentMacroToBuild.newNoneDirectiveField(this.currentParamName);
            this.currentParamMacroRefBuilder.newApplyNoneDirective();
            this.mSetNoneDirective = this.currentInitDirectives
                    .newSetNoneDirective(this.currentParamName, this.indexBuilder.toString());
        }
        else{
            this.currentDirective = this.currentInitDirectives
                    .newNewDirective(this.currentParamName, directive_name, this.indexBuilder.toString());
=======
        String directive_name = buildName(node.getNames());
        switch (directive_name) {

<<<<<<< HEAD
        if(directive_name.equals(SEPARATOR_DIRECTIVE)){
            this.currentSeparator = this.currentParamMacroRef.newSeparator();
        }
        else if(directive_name.equals(AFTER_LAST_DIRECTIVE)){
            this.currentAfterLast = this.currentParamMacroRef.newAfterLast();
        }
        else if(directive_name.equals(BEFORE_FIRST_DIRECTIVE)){
            this.currentBeforeFirst = this.currentParamMacroRef.newBeforeFirst();
        }
        else if(directive_name.equals(NONE_DIRECTIVE)){
            this.currentNone = this.currentParamMacroRef.newNone();
        }
        else{
            throw new InternalException("case unhandled");
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
            case SEPARATOR_DIRECTIVE:
=======
        String directive_name = GenerationUtils.buildName(node.getNames());
        switch (directive_name) {

            case GenerationUtils.SEPARATOR_DIRECTIVE:
>>>>>>> Moved utils files for generation to another walker
                this.currentSeparator = this.currentParamMacroRefBuilder.newSeparator();
                break;

            case GenerationUtils.AFTER_LAST_DIRECTIVE:
                this.currentAfterLast = this.currentParamMacroRefBuilder.newAfterLast();
                break;

            case GenerationUtils.BEFORE_FIRST_DIRECTIVE:
=======
        /*String directive_name = buildName(node.getNames());
        switch (directive_name) {

            case SEPARATOR_DIRECTIVE:
            this.currentSeparators.add(new MSeparator())
            break;

            case AFTER_LAST_DIRECTIVE:
                this.currentAfterLast = this.currentParamMacroRefBuilder.newAfterLast();
                break;

            case BEFORE_FIRST_DIRECTIVE:
>>>>>>> Changement Objectmacro-back
                this.currentBeforeFirst = this.currentParamMacroRefBuilder
                        .newBeforeFirst();
                break;

<<<<<<< HEAD
            case GenerationUtils.NONE_DIRECTIVE:
=======
            case NONE_DIRECTIVE:
>>>>>>> Changement Objectmacro-back
                this.currentNone = this.currentParamMacroRefBuilder.newNone();
                break;

            default:
                throw new InternalException("case unhandled");
<<<<<<< HEAD
>>>>>>> Clean up code, add comments
=======
        String directive_name = GenerationUtils.buildNameCamelCase(node.getNames());

        if(directive_name.equals(GenerationUtils.NONE_DIRECTIVE)){
            this.currentMacroToBuild.newNoneDirectiveField(this.currentParamName);
            this.currentParamMacroRefBuilder.newApplyNoneDirective();
            this.mSetNoneDirective = this.currentInitDirectives
                    .newSetNoneDirective(this.currentParamName, this.indexBuilder.toString());
        }
        else{
            this.currentDirective = this.currentInitDirectives
                    .newNewDirective(this.currentParamName, directive_name, this.indexBuilder.toString());
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
        }
=======
        }*/
>>>>>>> Changement Objectmacro-back
    }

    @Override
    public void outADirective(
            ADirective node) {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        this.indexBuilder++;
        this.currentDirective = null;
        this.mSetNoneDirective = null;
=======
        this.currentSeparator = null;
        this.currentAfterLast = null;
        this.currentBeforeFirst = null;
        this.currentNone = null;
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
        this.indexBuilder++;
        this.currentDirective = null;
        this.mSetNoneDirective = null;
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
=======
        /*this.currentSeparators = null;
        this.currentAfterLast = null;
        this.currentBeforeFirst = null;
        this.currentNone = null;*/
>>>>>>> Changement Objectmacro-back
    }

    @Override
    public void inAMacroRef(
            AMacroRef node) {
<<<<<<< HEAD

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        String macro_ref_name = this.currentMacroRefName = GenerationUtils.buildNameCamelCase(node.getNames());

        if(this.currentContextName != null){
            this.currentRedefinedInternalsSetter =
                    this.currentApplyInitializer.newRedefinedInternalsSetter(macro_ref_name);

            MSingleAdd mSingleAdd = this.currentMacroToBuild.newSingleAdd(macro_ref_name, this.currentParamName);
            if(!this.currentMacroHasInternals){
                mSingleAdd.newIsBuilt(this.currentMacro.getName());
            }

            this.currentAddAllApplyInitializer.newRedefinedInternalsSetter(macro_ref_name);
        }
=======
        this.currentMacroName = buildNameCamelCase(node.getNames());

        if(this.currentContext != null){
            this.currentRedefinedInternalsSetter = this.currentApplyInitializer.newRedefinedInternalsSetter(
                    currentMacroName);
<<<<<<< HEAD

>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
=======
        this.currentMacroRefName = buildNameCamelCase(node.getNames());
=======
        this.currentMacroRefName = GenerationUtils.buildNameCamelCase(node.getNames());
>>>>>>> Moved utils files for generation to another walker
=======
        String macro_ref_name = this.currentMacroRefName = GenerationUtils.buildNameCamelCase(node.getNames());
>>>>>>> Add structure which contains list of macros and the context associated

        if(this.currentContextName != null){
            this.currentRedefinedInternalsSetter =
                    this.currentApplyInitializer.newRedefinedInternalsSetter(macro_ref_name);

<<<<<<< HEAD
<<<<<<< HEAD
        if(this.currentEmptyApplyInitializer != null){
            this.currentEmptyRedefinedInternalsSetter =
                    this.currentEmptyApplyInitializer.newRedefinedInternalsSetter(
                            currentMacroRefName);
>>>>>>> Init internals before building the macro instead at the add or addAll methods
=======
            this.currentMacroToBuild.newSingleAdd(macro_ref_name, this.currentParamName);
=======
            MSingleAdd mSingleAdd = this.currentMacroToBuild.newSingleAdd(macro_ref_name, this.currentParamName);
            if(!this.currentMacroHasInternals){
                mSingleAdd.newIsBuilt(this.currentMacro.getName());
            }

>>>>>>> Add BuildState class in order to do a cheap cycle verification on build method
            this.currentAddAllApplyInitializer.newRedefinedInternalsSetter(macro_ref_name);
>>>>>>> Add structure which contains list of macros and the context associated
        }
>>>>>>> Clean up code, add comments
=======
        this.isInAMacroRef = true;
>>>>>>> Changement Objectmacro-back
    }

    @Override
    public void outAMacroRef(
            AMacroRef node) {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        this.currentMacroRefName = null;
=======
        this.currentMacroName = buildNameCamelCase(node.getNames());
        if(this.currentContext != null){
            this.currentRedefinedInternalsSetter = new MRedefinedInternalsSetter(currentMacroName
            , this.currentListParts.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[this.currentListParts.size()])
            , this.currentInternalList.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[this.currentInternalList.size()]));
        }

        this.currentMacroName = null;
        this.isInAMacroRef = false;
>>>>>>> Changement Objectmacro-back
    }

    @Override
    public void caseAStringValue(
=======
        this.currentMacroName = null;
=======
        this.currentMacroRefName = null;
>>>>>>> Init internals before building the macro instead at the add or addAll methods
    }

    @Override
<<<<<<< HEAD
    public void inAStringValue(
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
    public void caseAStringValue(
>>>>>>> indexInsert could be modified in the children nodes of stringValue
            AStringValue node) {

        this.indexBuilder++;
        String index_builder = String.valueOf(this.indexBuilder);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        boolean anyContext = this.currentContextName != null;
=======
        boolean anyContext = this.currentContext != null;
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
        boolean anyContext = this.currentContextName != null;
>>>>>>> Moved utils files for generation to another walker
=======
        boolean anyContext = this.currentContext != null;
>>>>>>> Changement Objectmacro-back

        MInitStringBuilder mInitStringBuilder;
        MSetInternal mSetInternal;
        MStringBuilderBuild mStringBuilderBuild;

<<<<<<< HEAD
            this.currentRedefinedInternalsSetter.newSetInternal(
<<<<<<< HEAD
<<<<<<< HEAD
                    this.currentMacroRefName,
                    GenerationUtils.buildNameCamelCase(node.getParamName()),
                    this.currentContextName).newStringBuilderBuild(index_builder);
=======
        if(anyContext){
            mSetInternal = new MSetInternal(this.currentMacroName
                    ,buildNameCamelCase(node.getParamName())
                    ,this.currentContext
                    , new org.sablecc.objectmacro.codegeneration.java.macro.Macro[0]);
>>>>>>> Changement Objectmacro-back

            for(PTextPart part : node.getParts()){
                part.apply(this);
            }
        }
        else{
<<<<<<< HEAD
            index_builder = GenerationUtils.getLetterFromInteger(this.indexBuilder);
<<<<<<< HEAD
=======

            index_builder = getLetterFromInteger(this.indexBuilder);
>>>>>>> Changement Objectmacro-back

            //Avoid declaring stringbuilder of the same name
            while(this.createdBuilders.contains(index_builder)){
                this.indexBuilder++;
                index_builder = getLetterFromInteger(this.indexBuilder);
            }

            this.createdBuilders.add(index_builder);

            //To avoid modification on indexes
            Integer tempIndexBuilder = this.indexBuilder;
            Integer tempIndexInsert = this.indexInsert;

            for(PTextPart part : node.getParts()){
                part.apply(this);
            }

            this.indexBuilder = tempIndexBuilder;
            this.indexInsert = tempIndexInsert;

<<<<<<< HEAD
            this.currentInsertMacroPart.newSetInternal(
                    GenerationUtils.INSERT_VAR_NAME.concat(String.valueOf(this.indexInsert)),
                    GenerationUtils.buildNameCamelCase(node.getParamName()),
                    "null").newStringBuilderBuild(index_builder);
=======
                    this.currentMacroName,
=======
                    this.currentMacroRefName,
<<<<<<< HEAD
>>>>>>> Init internals before building the macro instead at the add or addAll methods
                    buildNameCamelCase(node.getParamName()),
                    this.currentContext).newStringBuilderBuild(index_builder);
=======
                    GenerationUtils.buildNameCamelCase(node.getParamName()),
                    this.currentContextName).newStringBuilderBuild(index_builder);
>>>>>>> Moved utils files for generation to another walker

            for(PTextPart part : node.getParts()){
                part.apply(this);
            }
        }
        else{
            index_builder = getLetterFromInteger(this.indexBuilder);
=======
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives

            //Avoid declaring stringbuilder of the same name
            while(this.createdBuilders.contains(index_builder)){
                this.indexBuilder++;
                index_builder = GenerationUtils.getLetterFromInteger(this.indexBuilder);
            }

            this.currentInsertMacroPart.newInitStringBuilder(index_builder);
            this.createdBuilders.add(index_builder);

            //To avoid modification on indexes
            Integer tempIndexBuilder = this.indexBuilder;
            Integer tempIndexInsert = this.indexInsert;

            for(PTextPart part : node.getParts()){
                part.apply(this);
            }

            this.indexBuilder = tempIndexBuilder;
            this.indexInsert = tempIndexInsert;

            this.currentInsertMacroPart.newSetInternal(
                    GenerationUtils.INSERT_VAR_NAME.concat(String.valueOf(this.indexInsert)),
                    GenerationUtils.buildNameCamelCase(node.getParamName()),
                    "null").newStringBuilderBuild(index_builder);
<<<<<<< HEAD

<<<<<<< HEAD
            this.createdBuilders.add(index_builder);
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
>>>>>>> indexInsert could be modified in the children nodes of stringValue
=======
>>>>>>> Fix index inserts when creating 2 inserts in 2 different stringValue of a same macro reference
=======
            mSetInternal = new MSetInternal(INSERT_VAR_NAME.concat(String.valueOf(this.indexInsert))
                    ,buildNameCamelCase(node.getParamName())
                    ,"null"
                    ,new org.sablecc.objectmacro.codegeneration.java.macro.Macro[0]);

>>>>>>> Changement Objectmacro-back
        }
        mInitStringBuilder = new MInitStringBuilder(index_builder);
        mStringBuilderBuild = new MStringBuilderBuild(index_builder);
    }

    @Override
    public void caseAStringTextPart(
            AStringTextPart node) {

        String index_builder = String.valueOf(this.indexBuilder);

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        if(this.currentContextName != null
                && this.currentRedefinedInternalsSetter != null){
=======
        MStringPart mStringPart = new MStringPart(escapedString(node.getString())
        ,String.valueOf(this.indexBuilder));
>>>>>>> Changement Objectmacro-back

        this.currentListParts.add(mStringPart);

        if(this.currentContext != null
                && this.isInAMacroRef){

            this.currentListParts.add(new MStringPart(escapedString(node.getString())
                    , String.valueOf(this.indexBuilder)));
        }
        else {

            String string = escapedString(node.getString());

            if(this.currentInsertMacroPart != null){
<<<<<<< HEAD
                index_builder = GenerationUtils.getLetterFromInteger(this.indexBuilder);
=======
        if(this.currentContext != null
=======
        if(this.currentContextName != null
>>>>>>> Moved utils files for generation to another walker
                && this.currentRedefinedInternalsSetter != null){

            this.currentRedefinedInternalsSetter.newStringPart(
                    GenerationUtils.escapedString(node.getString()),
                    String.valueOf(this.indexBuilder));
        }
        else {
            String string = GenerationUtils.escapedString(node.getString());

            if(this.currentInsertMacroPart != null){
<<<<<<< HEAD
                index_builder = getLetterFromInteger(this.indexBuilder);
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
                index_builder = GenerationUtils.getLetterFromInteger(this.indexBuilder);
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
                this.currentInsertMacroPart.newStringPart(
                        string,
                        index_builder);
            }
<<<<<<< HEAD
<<<<<<< HEAD
            else if(this.currentDirective != null){
                this.currentDirective.newStringPart(
                        string,
                        index_builder);
            }
            else if(this.mSetNoneDirective != null){
                this.mSetNoneDirective.newStringPart(
=======
            else if(this.currentNone != null){
                this.currentNone.newStringPart(
                        string,
                        index_builder);
            }
            else if(this.currentBeforeFirst != null){
                this.currentBeforeFirst.newStringPart(
                        string,
                        index_builder);
            }
            else if(this.currentAfterLast != null){
                this.currentAfterLast.newStringPart(
                        string,
                        index_builder);
            }
            else if(this.currentSeparator != null){
                this.currentSeparator.newStringPart(
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
            else if(this.currentDirective != null){
                this.currentDirective.newStringPart(
                        string,
                        index_builder);
            }
            else if(this.mSetNoneDirective != null){
                this.mSetNoneDirective.newStringPart(
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
                        string,
                        index_builder);
=======
                index_builder = getLetterFromInteger(this.indexBuilder);
                this.currentListParts.add(new MStringPart(string, index_builder));
            }
            else if(this.currentNone != null){
                this.currentNone.add(new MNone(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {new MStringPart(string, index_builder)}));
            }
            else if(this.currentBeforeFirst != null){
                this.currentBeforeFirst.add(new MBeforeFirst(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {new MStringPart(string, index_builder)}));
            }
            else if(this.currentAfterLast != null){
                this.currentAfterLast.add(new MAfterLast(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {new MStringPart(string, index_builder)}));
            }
            else if(this.currentSeparators != null){
                this.currentSeparators.add(new MSeparator(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {new MStringPart(string, index_builder)}));
>>>>>>> Changement Objectmacro-back
            }
        }
    }

    @Override
    public void caseAVarTextPart(
            AVarTextPart node) {

        String index_builder = String.valueOf(this.indexBuilder);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        String param_name = GenerationUtils.buildNameCamelCase(node.getNames());
        if(this.currentContextName != null
                && this.currentRedefinedInternalsSetter != null){
=======
        String param_name = buildNameCamelCase(node.getNames());
>>>>>>> Changement Objectmacro-back

        if(this.currentContext != null)
        {
            this.currentContextParam.add(new MContextParam());
        }

        MParamInsertPart mParamInsertPart = new MParamInsertPart(param_name
        ,index_builder
        ,new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {new MContextArg()});

        this.currentListParts.add(mParamInsertPart);

        if(this.currentContext != null
                && this.isInAMacroRef){

            this.currentListParts.add(mParamInsertPart);
        }
        else {

            /*String string = escapedString(node.getString());*/

            if(this.currentInsertMacroPart != null){
<<<<<<< HEAD
                index_builder = GenerationUtils.getLetterFromInteger(this.indexBuilder);
<<<<<<< HEAD
=======

=======
        String param_name = buildNameCamelCase(node.getNames());
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
        if(this.currentContext != null
=======
        String param_name = GenerationUtils.buildNameCamelCase(node.getNames());
        if(this.currentContextName != null
>>>>>>> Moved utils files for generation to another walker
                && this.currentRedefinedInternalsSetter != null){

            this.currentRedefinedInternalsSetter.newParamInsertPart(
                    param_name,
                    index_builder);
        }
        else {
            if(this.currentInsertMacroPart != null){
                index_builder = getLetterFromInteger(this.indexBuilder);
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
                this.currentInsertMacroPart.newParamInsertPart(
                        param_name,
                        index_builder);
            }
<<<<<<< HEAD
<<<<<<< HEAD
            else if(this.currentDirective != null){
                this.currentDirective.newParamInsertPart(
                        param_name,
                        index_builder);
            }
            else if(this.mSetNoneDirective != null){
                this.mSetNoneDirective.newParamInsertPart(
=======
            else if(this.currentNone != null){
                this.currentNone.newParamInsertPart(
                        param_name,
                        index_builder);
            }
            else if(this.currentBeforeFirst != null){
                this.currentBeforeFirst.newParamInsertPart(
                        param_name,
                        index_builder);
            }
            else if(this.currentAfterLast != null){
                this.currentAfterLast.newParamInsertPart(
                        param_name,
                        index_builder);
            }
            else if(this.currentSeparator != null){
                this.currentSeparator.newParamInsertPart(
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
            else if(this.currentDirective != null){
                this.currentDirective.newParamInsertPart(
                        param_name,
                        index_builder);
            }
            else if(this.mSetNoneDirective != null){
                this.mSetNoneDirective.newParamInsertPart(
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
                        param_name,
                        index_builder);
=======
                /*index_builder = getLetterFromInteger(this.indexBuilder);*/
                this.currentListParts.add(mParamInsertPart);
            }
            else if(this.currentNone != null){
                this.currentNone.add(new MNone(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {mParamInsertPart}));
            }
            else if(this.currentBeforeFirst != null){
                this.currentBeforeFirst.add(new MBeforeFirst(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {mParamInsertPart}));
            }
            else if(this.currentAfterLast != null){
                this.currentAfterLast.add(new MAfterLast(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {mParamInsertPart}));
            }
            else if(this.currentSeparators != null){
                this.currentSeparators.add(new MSeparator(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {mParamInsertPart}));
>>>>>>> Changement Objectmacro-back
            }
        }
    }

    @Override
    public void caseAEolTextPart(
            AEolTextPart node) {

        String index_builder = String.valueOf(indexBuilder);

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        if(this.currentContextName != null
                && this.currentRedefinedInternalsSetter != null){

            this.currentRedefinedInternalsSetter.newEolPart(index_builder);
=======
        if(this.currentContext != null
                && this.currentRedefinedInternalsSetter != null){

            this.currentRedefinedInternalsSetter.newEolPart(index_builder);

>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
        if(this.currentContextName != null
                && this.currentRedefinedInternalsSetter != null){

            this.currentRedefinedInternalsSetter.newEolPart(index_builder);
>>>>>>> Moved utils files for generation to another walker
=======
        MEolPart mEolPart = new MEolPart(index_builder);

        this.currentListParts.add(mEolPart);

        if(this.currentContext != null
                && this.isInAMacroRef){

            this.currentListParts.add(mEolPart);
>>>>>>> Changement Objectmacro-back
        }
        else {

            /*String string = escapedString(node.getString());*/

            if(this.currentInsertMacroPart != null){
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                index_builder = GenerationUtils.getLetterFromInteger(this.indexBuilder);
                this.currentInsertMacroPart.newEolPart(
                        index_builder);
=======
                /*index_builder = getLetterFromInteger(this.indexBuilder);*/
                this.currentListParts.add(mEolPart);
            }
            else if(this.currentNone != null){
                this.currentNone.add(new MNone(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {mEolPart}));
>>>>>>> Changement Objectmacro-back
            }
            else if(this.currentBeforeFirst != null){
                this.currentBeforeFirst.add(new MBeforeFirst(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {mEolPart}));
            }
<<<<<<< HEAD
            else if(this.mSetNoneDirective != null){
                this.mSetNoneDirective.newEolPart(index_builder);
=======
                index_builder = getLetterFromInteger(this.indexBuilder);
=======
                index_builder = GenerationUtils.getLetterFromInteger(this.indexBuilder);
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
                this.currentInsertMacroPart.newEolPart(
                        index_builder);
            }
            else if(this.currentDirective != null){
                this.currentDirective.newEolPart(index_builder);
            }
<<<<<<< HEAD
            else if(this.currentAfterLast != null){
                this.currentAfterLast.newEolPart(index_builder);
            }
            else if(this.currentSeparator != null){
                this.currentSeparator.newEolPart(index_builder);
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
            else if(this.mSetNoneDirective != null){
                this.mSetNoneDirective.newEolPart(index_builder);
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
=======
            else if(this.currentAfterLast != null){
                this.currentAfterLast.add(new MAfterLast(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {mEolPart}));
            }
            else if(this.currentSeparators != null){
                this.currentSeparators.add(new MSeparator(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {mEolPart}));
>>>>>>> Changement Objectmacro-back
            }
        }
    }

    @Override
    public void caseAInsertTextPart(
            AInsertTextPart node) {

        AMacroRef macroRef = (AMacroRef) node.getMacroRef();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        String macro_name = GenerationUtils.buildNameCamelCase(macroRef.getNames());
=======
        String macro_name = buildNameCamelCase(macroRef.getNames());
>>>>>>> Changement Objectmacro-back
        String index_builder = String.valueOf(this.indexBuilder);

        //Avoid declaring insert of the same name
        while(this.createdInserts.contains(this.indexInsert)){
            this.indexInsert++;
        }

        String index_insert = String.valueOf(this.indexInsert);

        this.createdInserts.add(this.indexInsert);

        String tempContext = this.currentContext;
        String tempMacroName = this.currentMacroName;
        Integer tempIndex = this.indexBuilder;
        Integer tempIndexInsert = this.indexInsert;
        ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> tempListParts = this.currentListParts;
        ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> tempInternalList = this.currentInternalList;
        this.currentContext = null;

        node.getMacroRef().apply(this);

        this.currentInsertMacroPart = new MInsertMacroPart(macro_name
                ,index_builder
                ,index_insert
                ,this.currentListParts.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[this.currentListParts.size()])
                ,this.currentInternalList.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[this.currentInternalList.size()]));

        if(this.currentContext != null
                && this.isInAMacroRef){

<<<<<<< HEAD
=======
        String macro_name = buildNameCamelCase(macroRef.getNames());
=======
        String macro_name = GenerationUtils.buildNameCamelCase(macroRef.getNames());
>>>>>>> Moved utils files for generation to another walker
        String index_builder = String.valueOf(this.indexBuilder);

        //Avoid declaring insert of the same name
        while(this.createdInserts.contains(this.indexInsert)){
            this.indexInsert++;
        }

        String index_insert = String.valueOf(this.indexInsert);

        if(this.currentContextName != null
                && this.currentRedefinedInternalsSetter != null){
<<<<<<< HEAD
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======

>>>>>>> Moved utils files for generation to another walker
            this.currentInsertMacroPart =
                    this.currentRedefinedInternalsSetter.newInsertMacroPart(
                            macro_name,
                            index_builder,
                            index_insert);
<<<<<<< HEAD
<<<<<<< HEAD
        }
        else{
            if(tempInsertMacroPart != null){
                index_builder = GenerationUtils.getLetterFromInteger(this.indexBuilder);
<<<<<<< HEAD

=======

        }else{
=======
        }
        else{
>>>>>>> Moved utils files for generation to another walker
            if(tempInsertMacroPart != null){
<<<<<<< HEAD
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
                index_builder = getLetterFromInteger(this.indexBuilder);
=======
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives

>>>>>>> fix creating same string builder in macro body
                this.currentInsertMacroPart =
                        tempInsertMacroPart.newInsertMacroPart(
                                macro_name,
                                index_builder,
                                index_insert);
<<<<<<< HEAD
<<<<<<< HEAD
=======
            this.currentListParts.add(this.currentInsertMacroPart);
        }
        else {

            /*String string = escapedString(node.getString());*/
>>>>>>> Changement Objectmacro-back

            if(this.currentInsertMacroPart != null){
                /*index_builder = getLetterFromInteger(this.indexBuilder);*/
                this.currentListParts.add(this.currentInsertMacroPart);
            }
<<<<<<< HEAD
            else if(this.currentDirective != null){
<<<<<<< HEAD
                this.currentInsertMacroPart =
                    this.currentDirective.newInsertMacroPart(macro_name,
                            index_builder,
                            index_insert);

=======
            else if(this.currentNone != null){
                this.currentNone.add(new MNone(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {this.currentInsertMacroPart}));
            }
            else if(this.currentBeforeFirst != null){
                this.currentBeforeFirst.add(new MBeforeFirst(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {this.currentInsertMacroPart}));
            }
            else if(this.currentAfterLast != null){
                this.currentAfterLast.add(new MAfterLast(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {this.currentInsertMacroPart}));
>>>>>>> Changement Objectmacro-back
            }
            else if(this.currentSeparators != null){
                this.currentSeparators.add(new MSeparator(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {this.currentInsertMacroPart}));
            }
        }
<<<<<<< HEAD
        this.createdInserts.add(this.indexInsert);

        String tempContext = this.currentContextName;
        String tempMacroName = this.currentMacroRefName;
        Integer tempIndex = this.indexBuilder;
        Integer tempIndexInsert = this.indexInsert;
        this.currentContextName = null;
=======
=======

>>>>>>> fix creating same string builder in macro body
            }
            else if(this.currentNone != null){
=======
>>>>>>> Add directives into InternalValue and update directives in order to easily add new directives
                this.currentInsertMacroPart =
                    this.currentDirective.newInsertMacroPart(macro_name,
                            index_builder,
                            index_insert);

            }
            else if(this.mSetNoneDirective != null){
                this.currentInsertMacroPart =
                        this.mSetNoneDirective.newInsertMacroPart(macro_name,
                                index_builder,
                                index_insert);
            }
        }
        this.createdInserts.add(this.indexInsert);

        String tempContext = this.currentContextName;
        String tempMacroName = this.currentMacroRefName;
        Integer tempIndex = this.indexBuilder;
        Integer tempIndexInsert = this.indexInsert;
<<<<<<< HEAD
        this.currentContext = null;
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
        this.currentContextName = null;
>>>>>>> Moved utils files for generation to another walker

        node.getMacroRef().apply(this);
=======
>>>>>>> Changement Objectmacro-back

        this.indexBuilder = tempIndex;
<<<<<<< HEAD
<<<<<<< HEAD
        this.indexInsert = tempIndexInsert;
<<<<<<< HEAD
        this.currentContextName = tempContext;
        this.currentMacroRefName = tempMacroName;
=======
=======
        this.indexInsert = tempIndexInsert;
<<<<<<< HEAD
>>>>>>> indexInsert could be modified in the children nodes of stringValue
        this.currentContext = tempContext;
<<<<<<< HEAD
        this.currentMacroName = tempMacroName;
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
=======
        this.currentContextName = tempContext;
>>>>>>> Moved utils files for generation to another walker
        this.currentMacroRefName = tempMacroName;
>>>>>>> Init internals before building the macro instead at the add or addAll methods
        this.currentInsertMacroPart = tempInsertMacroPart;
=======
        this.currentContext = tempContext;
        this.currentMacroName = tempMacroName;
        this.currentListParts = tempListParts;
        this.currentInternalList = tempInternalList;
>>>>>>> Changement Objectmacro-back

    }

    @Override
    public void outAVarValue(
            AVarValue node) {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        String var_name = GenerationUtils.buildNameCamelCase(node.getNames());

        if(this.currentContextName != null){

            MParamRef paramRef = this.currentRedefinedInternalsSetter.newSetInternal(
                        this.currentMacroRefName,
                        GenerationUtils.buildNameCamelCase(node.getParamName()),
                        this.currentContextName)
<<<<<<< HEAD
                        .newParamRef(var_name);

            if(this.currentMacro.getInternalsName().contains(var_name)){
                paramRef.newContextName(GenerationUtils.CONTEXT_STRING.toLowerCase());
            }
        }
        else{
            MParamRef mParamRef =
                    this.currentInsertMacroPart.newSetInternal(
                            GenerationUtils.INSERT_VAR_NAME.concat(String.valueOf(this.indexInsert)),
                            GenerationUtils.buildNameCamelCase(node.getParamName()),
                            "null").newParamRef(var_name);

            if(this.currentMacro.getInternalsName().contains(var_name)){
                mParamRef.newContextArg();
            }
=======
=======
        String var_name = buildNameCamelCase(node.getNames());

>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
        if(this.currentContext != null){
=======
        String var_name = GenerationUtils.buildNameCamelCase(node.getNames());

        if(this.currentContextName != null){
>>>>>>> Moved utils files for generation to another walker

            MParamRef paramRef = this.currentRedefinedInternalsSetter.newSetInternal(
                    this.currentMacroRefName,
                    buildNameCamelCase(node.getParamName()),
                    this.currentContext)
=======
>>>>>>> Add structure which contains list of macros and the context associated
=======
        String var_name = buildNameCamelCase(node.getNames());

        if(this.currentContext != null){
            /*MParamRef paramRef = this.currentRedefinedInternalsSetter.newSetInternal(
                    this.currentMacroName,
                    buildNameCamelCase(node.getParamName()),
                    this.currentContext)
>>>>>>> Changement Objectmacro-back
                        .newParamRef(var_name);

            if(this.currentMacro.getInternals().contains(var_name)){
                paramRef.newContextName(this.currentContext);
            }*/
            this.currentInternalList.add(new MSetInternal(this.currentMacroName
            ,buildNameCamelCase(node.getParamName())
            ,this.currentContext
            ,new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {new MParamRef(var_name, new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {new MContextName(this.currentContext)})}));
        }
        else{
<<<<<<< HEAD
<<<<<<< HEAD
            this.currentInsertMacroPart.newSetInternal(
                    INSERT_VAR_NAME.concat(String.valueOf(this.indexInsert)),
                    buildNameCamelCase(node.getParamName()),
                    "null")
                    .newMacroArg(buildNameCamelCase(node.getNames()));

>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
            MParamRef mParamRef =
=======
            /*MParamRef mParamRef =
>>>>>>> Changement Objectmacro-back
                    this.currentInsertMacroPart.newSetInternal(
                        INSERT_VAR_NAME.concat(String.valueOf(this.indexInsert)),
                        buildNameCamelCase(node.getParamName()),
                        "null").newParamRef(var_name);

            if(this.currentMacro.getInternals().contains(var_name)){
                mParamRef.newContextArg();
<<<<<<< HEAD
            }
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
=======
            }*/

            this.currentInternalList.add(new MSetInternal(INSERT_VAR_NAME.concat(String.valueOf(this.indexInsert))
                    ,buildNameCamelCase(node.getParamName())
                    ,"null"
                    ,new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {
                        new MParamRef(var_name
                        , new org.sablecc.objectmacro.codegeneration.java.macro.Macro[] {new MContextArg()}
                        )
                    })
            );
>>>>>>> Changement Objectmacro-back
        }


    }

    @Override
    public void outAMacro(
            AMacro node) {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        String macroName = GenerationUtils.buildNameCamelCase(node.getNames());
        GenerationUtils.writeFile(this.packageDirectory, "M" + macroName + ".java", this.currentMacroToBuild.toString());

        this.contextNames = null;
        this.currentMacroToBuild = null;
        this.currentConstructor = null;
        this.currentMacro = null;
        this.currentMacroHasInternals = false;
    }

    @Override
    public void caseAStringMacroPart(
            AStringMacroPart node) {

        this.currentMacroBuilder.newStringPart(
                GenerationUtils.escapedString(node.getString()),
=======
        for(TString string : node.getInitOrder()){
            String param_name = Utils.toCamelCase(string(string));
            if(this.currentParameters.contains(param_name)){
                this.currentConstructor.newSetParam(param_name).newParamArg(param_name);
            }
        }

=======
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
        String macroName = buildNameCamelCase(node.getNames());
        writeFile("M" + macroName + ".java", this.currentMacroToBuild.toString());
=======
        String macroName = GenerationUtils.buildNameCamelCase(node.getNames());
        GenerationUtils.writeFile(this.packageDirectory, "M" + macroName + ".java", this.currentMacroToBuild.toString());
>>>>>>> Moved utils files for generation to another walker
=======
        String macroName = buildNameCamelCase(node.getNames());

        //Définition du constructeur d'après les paramètres recueillis dans l'arbre
        this.currentConstructor = new MConstructor(macroName
        , this.currentParamSet.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[this.currentParamSet.size()])
        , this.currentParamList.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[this.currentParamList.size()])
        , this.currentInternalList.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[this.currentInternalList.size()]));
        this.currentMacro.getConstructor().add(this.currentConstructor);

        //Définition du MacroBuilder
        this.currentMacroBuilder = new MMacroBuilder(this.currentPublic.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[this.currentPublic.size()])
        , this.currentContextParam.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[this.currentContextParam.size()])
        , this.currentContextExpansion.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[this.currentContextExpansion.size()])
        , this.currentListParts.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[this.currentListParts.size()])
        , this.currentNewContextExpansion.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[this.currentNewContextExpansion.size()]));
        this.currentMacro.getMacroBuilder().add(this.currentMacroBuilder);

        this.currentMacro.setEmptyBuilderWithContext(this.currentEmptyBuilderWithContext);

        writeFile("DebugListParts", this.currentListParts.toString());
        writeFile("M" + macroName + ".java", this.currentMacro.getMacro().build());
>>>>>>> Changement Objectmacro-back

        this.contextNames = null;
        this.currentMacroToBuild = null;
        this.currentConstructor = null;
    }

    @Override
    public void caseAStringMacroPart(AStringMacroPart node) {

<<<<<<< HEAD
        this.currentMacroBuilder.newStringPart(
<<<<<<< HEAD
                escapedString(node.getString()),
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
                GenerationUtils.escapedString(node.getString()),
>>>>>>> Moved utils files for generation to another walker
                String.valueOf(indexBuilder));
=======
        this.currentListParts.add(new MStringPart(escapedString(node.getString())
                , String.valueOf(indexBuilder)));
>>>>>>> Changement Objectmacro-back
    }

    @Override
    public void outAEolMacroPart(
            AEolMacroPart node) {

        this.currentListParts.add(new MEolPart(String.valueOf(indexBuilder)));
    }

    @Override
    public void caseAInsertMacroPart(
            AInsertMacroPart node) {

        AMacroRef macroRef = (AMacroRef) node.getMacroRef();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        String macro_name = GenerationUtils.buildNameCamelCase(macroRef.getNames());
=======
        String macro_name = buildNameCamelCase(macroRef.getNames());
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
        String macro_name = GenerationUtils.buildNameCamelCase(macroRef.getNames());
>>>>>>> Moved utils files for generation to another walker
        this.indexInsert++;

        this.currentInsertMacroPart =
                this.currentMacroBuilder.newInsertMacroPart(
                        macro_name, String.valueOf(indexBuilder), String.valueOf(indexInsert));

<<<<<<< HEAD
<<<<<<< HEAD
=======
        String macro_name = buildNameCamelCase(macroRef.getNames());
        this.indexInsert++;

>>>>>>> Changement Objectmacro-back
        this.createdInserts.add(this.indexInsert);
        Integer tempIndexBuilder = this.indexBuilder;
        Integer tempIndexInsert = this.indexInsert;
        ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> tempListParts = this.currentListParts;
        ArrayList<org.sablecc.objectmacro.codegeneration.java.macro.Macro> tempInternalList = this.currentInternalList;

        node.getMacroRef().apply(this);

        this.currentInsertMacroPart = new MInsertMacroPart(macro_name
        , String.valueOf(indexBuilder)
        , String.valueOf(indexInsert)
        , this.currentListParts.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[this.currentListParts.size()])
        , this.currentInternalList.toArray(new org.sablecc.objectmacro.codegeneration.java.macro.Macro[this.currentInternalList.size()]));

        this.currentListParts.add(this.currentInsertMacroPart);

        this.indexInsert = tempIndexInsert;
=======
=======
        this.createdInserts.add(this.indexInsert);
>>>>>>> Fix index inserts when creating 2 inserts in 2 different stringValue of a same macro reference
        Integer tempIndexBuilder = this.indexBuilder;
        Integer tempIndexInsert = this.indexInsert;

        node.getMacroRef().apply(this);

<<<<<<< HEAD
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
=======
        this.indexInsert = tempIndexInsert;
>>>>>>> indexInsert could be modified in the children nodes of stringValue
        this.indexBuilder = tempIndexBuilder;
        this.currentInsertMacroPart = null;
        this.currentListParts = tempListParts;
        this.currentInternalList = tempInternalList;
    }

    @Override
    public void outAVarMacroPart(
            AVarMacroPart node) {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        String param_name = GenerationUtils.buildNameCamelCase(node.getNames());
        MParamInsertPart mParamInsertPart =
                this.currentMacroBuilder.newParamInsertPart(
                        param_name,
                        String.valueOf(indexBuilder));

        if(this.currentMacro.getInternalsName().contains(param_name)){
            mParamInsertPart.newContextArg();
        }
    }
=======
//
//    private final IntermediateRepresentation ir;
//
//    private final File packageDirectory;
//
//    private MText currentText;
//
//    private MMacro currentMacro;
//
//    private MTextInsertPart currentTextInsertPart;
//
//    private MNone currentNone;
//
//    private MSeparator currentSeparator;
//
//    private MBeforeFirst currentBeforeFirst;
//
//    private MAfterLast currentAfterLast;
//
//    private MBeforeOne currentBeforeOne;
//
//    private MAfterOne currentAfterOne;
//
//    private MBeforeMany currentBeforeMany;
//
//    private MAfterMany currentAfterMany;
//
//    private MTextInsert currentTextInsert;
//
//    private MInlineText currentInlineText;
//
//    public CodeGenerationWalker(
//            IntermediateRepresentation ir,
//            File packageDirectory) {
//
//        this.ir = ir;
//        this.packageDirectory = packageDirectory;
//    }
//
//    private String string(
//            TString tString) {
//
//        String string = tString.getText();
//        int length = string.length();
//        return string.substring(1, length - 1);
//    }
//
//    private String escapedString(
//            TString tString) {
//
//        StringBuilder sb = new StringBuilder();
//        String s = string(tString);
//        boolean escaped = false;
//        for (char c : s.toCharArray()) {
//            if (escaped) {
//                escaped = false;
//
//                if (c == '\\') {
//                    sb.append('\\');
//                    sb.append('\\');
//                }
//                else if (c == '\'') {
//                    sb.append('\'');
//                }
//                else {
//                    throw new InternalException("unhandled case");
//                }
//            }
//            else if (c == '\\') {
//                escaped = true;
//            }
//            else if (c == '\"') {
//                sb.append('\\');
//                sb.append('\"');
//            }
//            else {
//                sb.append(c);
//            }
//        }
//
//        if (escaped) {
//            throw new InternalException("incomplete escape");
//        }
//
//        return sb.toString();
//    }
//
//    private boolean bool(
//            PBoolean pBoolean) {
//
//        if (pBoolean instanceof ATrueBoolean) {
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public void inAText(
//            AText node) {
//
//        this.currentText = new MText(string(node.getName()));
//
//        if (!this.ir.getDestinationPackage().equals("")) {
//            this.currentText.newPackageDeclaration(this.ir
//                    .getDestinationPackage());
//        }
//
//        for (TString param : node.getParams()) {
//            this.currentText.newParamField(string(param));
//            this.currentText.newParamParam(string(param));
//            this.currentText.newParamConstructorInit(string(param));
//            this.currentText.newParam(string(param));
//        }
//
//        if (bool(node.getSelfRef())) {
//            this.currentText.newSelfRefText();
//        }
//
//        for (TString ancersorRef : node.getAncestorRefs()) {
//            this.currentText.newAncestorField(string(ancersorRef));
//            this.currentText.newAncestorParam(string(ancersorRef));
//            this.currentText.newAncestorConstructorInit(string(ancersorRef));
//        }
//    }
//
//    @Override
//    public void outAText(
//            AText node) {
//
//        File destination = new File(this.packageDirectory, "M"
//                + string(node.getName()) + ".java");
//
//        try {
//            FileWriter fw = new FileWriter(destination);
//            fw.write(this.currentText.toString());
//            fw.close();
//        }
//        catch (IOException e) {
//            throw CompilerException.outputError(destination.toString(), e);
//        }
//
//        this.currentText = null;
//    }
//
//    @Override
//    public void inAMacro(
//            AMacro node) {
//
//        this.currentMacro = new MMacro(string(node.getName()));
//
//        if (!this.ir.getDestinationPackage().equals("")) {
//            this.currentMacro.newPackageDeclaration(this.ir
//                    .getDestinationPackage());
//        }
//
//        if (bool(node.getIsPublic())) {
//            this.currentMacro.newPublic();
//        }
//
//        if (node.getExpands().size() > 0) {
//            this.currentMacro.newImportJavaUtil();
//        }
//
//        for (TString param : node.getParams()) {
//            this.currentMacro.newParamField(string(param));
//            this.currentMacro.newParamParam(string(param));
//            this.currentMacro.newParamConstructorInit(string(param));
//            this.currentMacro.newParam(string(param));
//        }
//
//        if (bool(node.getSelfRef())) {
//            this.currentMacro.newSelfRefMacro();
//        }
//
//        for (TString ancersorRef : node.getAncestorRefs()) {
//            this.currentMacro.newAncestorField(string(ancersorRef));
//            this.currentMacro.newAncestorParam(string(ancersorRef));
//            this.currentMacro.newAncestorConstructorInit(string(ancersorRef));
//        }
//
//        for (TString expand : node.getExpands()) {
//            this.currentMacro.newExpandField(string(expand));
//        }
//    }
//
//    @Override
//    public void outAMacro(
//            AMacro node) {
//
//        File destination = new File(this.packageDirectory, "M"
//                + string(node.getName()) + ".java");
//
//        try {
//            FileWriter fw = new FileWriter(destination);
//            fw.write(this.currentMacro.toString());
//            fw.close();
//        }
//        catch (IOException e) {
//            throw CompilerException.outputError(destination.toString(), e);
//        }
//
//        this.currentMacro = null;
//    }
//
//    @Override
//    public void outAParamRef(
//            AParamRef node) {
//
//        if (this.currentText != null) {
//            this.currentText.newParamRef(string(node.getName()),
//                    string(node.getContext()));
//        }
//        else if (this.currentMacro != null) {
//            this.currentMacro.newParamRef(string(node.getName()),
//                    string(node.getContext()));
//        }
//        else {
//            throw new InternalException("unhandled case");
//        }
//    }
//
//    @Override
//    public void outAExpandedMacro(
//            AExpandedMacro node) {
//
//        MMacroCreator macroCreator = this.currentMacro
//                .newMacroCreator(string(node.getName()));
//
//        for (TString param : node.getParams()) {
//            macroCreator.newParamParam(string(param));
//            macroCreator.newParamArg(string(param));
//        }
//
//        for (TString ancestorRef : node.getAncestorRefs()) {
//            macroCreator.newAncestorArg(string(ancestorRef));
//        }
//
//        for (TString expand : node.getExpands()) {
//            macroCreator.newAddToExpand(string(expand));
//        }
//    }
//
//    @Override
//    public void outAStringTextPart(
//            AStringTextPart node) {
//
//        this.currentText.newStringPart(escapedString(node.getString()));
//    }
//
//    @Override
//    public void outAEolTextPart(
//            AEolTextPart node) {
//
//        this.currentText.newEolPart();
//    }
//
//    @Override
//    public void outAParamInsertTextPart(
//            AParamInsertTextPart node) {
//
//        this.currentText.newParamInsertPart(string(node.getParamInsert()));
//    }
//
//    @Override
//    public void inATextInsertTextPart(
//            ATextInsertTextPart node) {
//
//        this.currentTextInsertPart = this.currentText.newTextInsertPart();
//    }
//
//    @Override
//    public void outATextInsertTextPart(
//            ATextInsertTextPart node) {
//
//        this.currentTextInsertPart = null;
//    }
//
//    @Override
//    public void outAStringMacroPart(
//            AStringMacroPart node) {
//
//        this.currentMacro.newStringPart(escapedString(node.getString()));
//    }
//
//    @Override
//    public void outAEolMacroPart(
//            AEolMacroPart node) {
//
//        this.currentMacro.newEolPart();
//    }
//
//    @Override
//    public void outAParamInsertMacroPart(
//            AParamInsertMacroPart node) {
//
//        this.currentMacro.newParamInsertPart(string(node.getParamInsert()));
//    }
//
//    @Override
//    public void inATextInsertMacroPart(
//            ATextInsertMacroPart node) {
//
//        this.currentTextInsertPart = this.currentMacro.newTextInsertPart();
//    }
//
//    @Override
//    public void outATextInsertMacroPart(
//            ATextInsertMacroPart node) {
//
//        this.currentTextInsertPart = null;
//    }
//
//    @Override
//    public void caseAExpandInsert(
//            AExpandInsert node) {
//
//        MExpandInsertPart currentExpandInsertPart = this.currentMacro
//                .newExpandInsertPart(string(node.getName()));
//
//        if (node.getNone() != null) {
//            this.currentNone = currentExpandInsertPart.newNone();
//            node.getNone().apply(this);
//            this.currentNone = null;
//        }
//
//        if (node.getSeparator() != null) {
//            this.currentSeparator = currentExpandInsertPart.newSeparator();
//            node.getSeparator().apply(this);
//            this.currentSeparator = null;
//        }
//        else {
//            currentExpandInsertPart.newNoSeparator();
//        }
//
//        if (node.getBeforeFirst() != null) {
//            this.currentBeforeFirst = currentExpandInsertPart.newBeforeFirst();
//            node.getBeforeFirst().apply(this);
//            this.currentBeforeFirst = null;
//        }
//
//        if (node.getAfterLast() != null) {
//            this.currentAfterLast = currentExpandInsertPart.newAfterLast();
//            node.getAfterLast().apply(this);
//            this.currentAfterLast = null;
//        }
//
//        if (node.getBeforeOne() != null) {
//            this.currentBeforeOne = currentExpandInsertPart.newBeforeOne();
//            node.getBeforeOne().apply(this);
//            this.currentBeforeOne = null;
//        }
//
//        if (node.getAfterOne() != null) {
//            this.currentAfterOne = currentExpandInsertPart.newAfterOne();
//            node.getAfterOne().apply(this);
//            this.currentAfterOne = null;
//        }
//
//        if (node.getBeforeMany() != null) {
//            this.currentBeforeMany = currentExpandInsertPart.newBeforeMany();
//            node.getBeforeMany().apply(this);
//            this.currentBeforeMany = null;
//        }
//
//        if (node.getAfterMany() != null) {
//            this.currentAfterMany = currentExpandInsertPart.newAfterMany();
//            node.getAfterMany().apply(this);
//            this.currentAfterMany = null;
//        }
//    }
//
//    @Override
//    public void caseATextInsert(
//            ATextInsert node) {
//
//        MTextInsert oldTextInsert = this.currentTextInsert;
//
//        if (oldTextInsert != null) {
//            this.currentTextInsert = oldTextInsert.newTextInsert(string(node
//                    .getName()));
//        }
//        else if (this.currentNone != null) {
//            this.currentTextInsert = this.currentNone.newTextInsert(string(node
//                    .getName()));
//        }
//        else if (this.currentSeparator != null) {
//            this.currentTextInsert = this.currentSeparator
//                    .newTextInsert(string(node.getName()));
//        }
//        else if (this.currentBeforeFirst != null) {
//            this.currentTextInsert = this.currentBeforeFirst
//                    .newTextInsert(string(node.getName()));
//        }
//        else if (this.currentAfterLast != null) {
//            this.currentTextInsert = this.currentAfterLast
//                    .newTextInsert(string(node.getName()));
//        }
//        else if (this.currentBeforeOne != null) {
//            this.currentTextInsert = this.currentBeforeOne
//                    .newTextInsert(string(node.getName()));
//        }
//        else if (this.currentAfterOne != null) {
//            this.currentTextInsert = this.currentAfterOne
//                    .newTextInsert(string(node.getName()));
//        }
//        else if (this.currentBeforeMany != null) {
//            this.currentTextInsert = this.currentBeforeMany
//                    .newTextInsert(string(node.getName()));
//        }
//        else if (this.currentAfterMany != null) {
//            this.currentTextInsert = this.currentAfterMany
//                    .newTextInsert(string(node.getName()));
//        }
//        else if (this.currentTextInsertPart != null) {
//            this.currentTextInsert = this.currentTextInsertPart
//                    .newTextInsert(string(node.getName()));
//        }
//        else {
//            throw new InternalException("unhandled case");
//        }
//
//        for (PValue arg : node.getArgs()) {
//            arg.apply(this);
//        }
//
//        for (TString ancestorRef : node.getAncestorRefs()) {
//            this.currentTextInsert.newTextInsertAncestor(string(ancestorRef));
//        }
//
//        this.currentTextInsert = oldTextInsert;
//    }
//
//    @Override
//    public void inAInlineTextValue(
//            AInlineTextValue node) {
//
//        if (this.currentTextInsert != null) {
//            this.currentInlineText = this.currentTextInsert.newInlineText();
//        }
//        else if (this.currentNone != null) {
//            this.currentInlineText = this.currentNone.newInlineText();
//        }
//        else if (this.currentSeparator != null) {
//            this.currentInlineText = this.currentSeparator.newInlineText();
//        }
//        else if (this.currentBeforeFirst != null) {
//            this.currentInlineText = this.currentBeforeFirst.newInlineText();
//        }
//        else if (this.currentAfterLast != null) {
//            this.currentInlineText = this.currentAfterLast.newInlineText();
//        }
//        else if (this.currentBeforeOne != null) {
//            this.currentInlineText = this.currentBeforeOne.newInlineText();
//        }
//        else if (this.currentAfterOne != null) {
//            this.currentInlineText = this.currentAfterOne.newInlineText();
//        }
//        else if (this.currentBeforeMany != null) {
//            this.currentInlineText = this.currentBeforeMany.newInlineText();
//        }
//        else if (this.currentAfterMany != null) {
//            this.currentInlineText = this.currentAfterMany.newInlineText();
//        }
//        else {
//            throw new InternalException("unhandled case");
//        }
//    }
//
//    @Override
//    public void outAInlineTextValue(
//            AInlineTextValue node) {
//
//        if (this.currentTextInsert != null) {
//            this.currentInlineText = null;
//        }
//        else if (this.currentNone != null) {
//            this.currentInlineText = null;
//        }
//        else if (this.currentSeparator != null) {
//            this.currentInlineText = null;
//        }
//        else if (this.currentBeforeFirst != null) {
//            this.currentInlineText = null;
//        }
//        else if (this.currentAfterLast != null) {
//            this.currentInlineText = null;
//        }
//        else if (this.currentBeforeOne != null) {
//            this.currentInlineText = null;
//        }
//        else if (this.currentAfterOne != null) {
//            this.currentInlineText = null;
//        }
//        else if (this.currentBeforeMany != null) {
//            this.currentInlineText = null;
//        }
//        else if (this.currentAfterMany != null) {
//            this.currentInlineText = null;
//        }
//        else {
//            throw new InternalException("unhandled case");
//        }
//    }
//
//    @Override
//    public void outAStringInlineText(
//            AStringInlineText node) {
//
//        this.currentInlineText.newInlineString(escapedString(node.getString()));
//    }
//
//    @Override
//    public void outAEolInlineText(
//            AEolInlineText node) {
//
//        this.currentInlineText.newInlineEol();
//    }
//
//    @Override
//    public void outAParamInsertValue(
//            AParamInsertValue node) {
//
//        if (this.currentTextInsert != null) {
//            this.currentTextInsert
//                    .newParamInsert(string(node.getParamInsert()));
//        }
//        else if (this.currentNone != null) {
//            this.currentNone.newParamInsert(string(node.getParamInsert()));
//        }
//        else if (this.currentSeparator != null) {
//            this.currentSeparator.newParamInsert(string(node.getParamInsert()));
//        }
//        else if (this.currentBeforeFirst != null) {
//            this.currentBeforeFirst
//                    .newParamInsert(string(node.getParamInsert()));
//        }
//        else if (this.currentAfterLast != null) {
//            this.currentAfterLast.newParamInsert(string(node.getParamInsert()));
//        }
//        else if (this.currentBeforeOne != null) {
//            this.currentBeforeOne.newParamInsert(string(node.getParamInsert()));
//        }
//        else if (this.currentAfterOne != null) {
//            this.currentAfterOne.newParamInsert(string(node.getParamInsert()));
//        }
//        else if (this.currentBeforeMany != null) {
//            this.currentBeforeMany
//                    .newParamInsert(string(node.getParamInsert()));
//        }
//        else if (this.currentAfterMany != null) {
//            this.currentAfterMany.newParamInsert(string(node.getParamInsert()));
//        }
//        else {
//            throw new InternalException("unhandled case");
//        }
//    }
>>>>>>> Comment Code generation to compile ObjectMacro
=======
=======
        String param_name = buildNameCamelCase(node.getNames());
>>>>>>> Allow to set internals with string and macro by adding a structure containing the macro and parameters and internals name
=======
        String param_name = GenerationUtils.buildNameCamelCase(node.getNames());
>>>>>>> Moved utils files for generation to another walker
        MParamInsertPart mParamInsertPart =
                this.currentMacroBuilder.newParamInsertPart(
                        param_name,
                        String.valueOf(indexBuilder));
=======
        String param_name = buildNameCamelCase(node.getNames());

        org.sablecc.objectmacro.codegeneration.java.macro.Macro[] listContextArgs;
>>>>>>> Changement Objectmacro-back

        if(this.currentMacro.getInternals().contains(param_name)){
            listContextArgs = new org.sablecc.objectmacro.codegeneration.java.macro.Macro[1];
            listContextArgs[0] = new MContextArg();
        }
        else
        {
            listContextArgs = new org.sablecc.objectmacro.codegeneration.java.macro.Macro[0];
        }

        MParamInsertPart mParamInsertPart = new MParamInsertPart(param_name
                , String.valueOf(indexBuilder)
                , listContextArgs);

        this.currentListParts.add(mParamInsertPart);
    }
>>>>>>> Java code generation Objectmacro 2 using the lib ObjectMacro 1
}
