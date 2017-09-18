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
import java.util.*;

import org.sablecc.exception.*;
import org.sablecc.objectmacro.codegeneration.*;
import org.sablecc.objectmacro.codegeneration.java.macro.*;
import org.sablecc.objectmacro.codegeneration.java.structure.Macro;
import org.sablecc.objectmacro.intermediate.syntax3.analysis.*;
import org.sablecc.objectmacro.intermediate.syntax3.node.*;

public class CodeGenerationWalker
        extends DepthFirstAdapter {
<<<<<<< HEAD

    private final IntermediateRepresentation ir;

    private final File packageDirectory;

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

    public CodeGenerationWalker(
            IntermediateRepresentation ir,
            File packageDirectory,
            Map<String, Macro> macros) {

        this.ir = ir;
        this.packageDirectory = packageDirectory;
        this.macros = macros;
    }

    @Override
    public void inAIntermediateRepresentation(
            AIntermediateRepresentation node) {

        this.superMacro = new MSuperMacro();
        this.mInternalsInitializer = new MInternalsInitializer();

        if(!this.ir.getDestinationPackage().equals("")){
            String destinationPackage = this.ir.getDestinationPackage();
            this.superMacro.newPackageDeclaration(destinationPackage);
            this.mInternalsInitializer.newPackageDeclaration(destinationPackage);
        }

        this.superMacro.newImportJavaUtil();
        this.mInternalsInitializer.newImportJavaUtil();

    }

    @Override
    public void outAIntermediateRepresentation(
            AIntermediateRepresentation node) {

        GenerationUtils.writeFile(this.packageDirectory, "Macro.java", this.superMacro.toString());
        GenerationUtils
                .writeFile(this.packageDirectory,"InternalsInitializer.java", this.mInternalsInitializer.toString());
    }

    @Override
    public void inAMacro(
            AMacro node) {

        String macroName = GenerationUtils.buildNameCamelCase(node.getNames());
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
        this.currentMacroBuilder = this.currentMacroToBuild.newMacroBuilder(macroName);

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
        }
    }

    @Override
    public void caseAInternal(
            AInternal node) {

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

            this.currentMacroToBuild.newInternalMacroRefBuilder(paramName);
            this.currentMacroToBuild.newInternalMacroRef(paramName);

            this.indexBuilder = 0;
            this.currentMacroToBuild.newInternalMacroSetter(paramName);
        }
        else{
            throw new InternalException("case unhandled");
        }
        node.getType().apply(this);
        outAInternal(node);
    }

    @Override
    public void outAInternal(
            AInternal node) {

        this.currentContextName = null;
        this.currentApplyInitializer = null;
        this.indexBuilder = 0;
        this.indexInsert = 0;
        this.currentParamMacroRefBuilder = null;
        this.createdBuilders = new ArrayList<>();
        this.createdInserts = new ArrayList<>();
    }

    @Override
    public void caseAParam(
            AParam node) {

        String paramName = this.currentParamName = GenerationUtils.buildNameCamelCase(node.getNames());

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
            this.currentParamMacroRefBuilder.newContextName(paramName.concat(
                    GenerationUtils.CONTEXT_STRING));
            this.currentMacroToBuild.newParamMacroRef(paramName);

            this.currentInitDirectives = this.currentMacroToBuild.newInitDirectives(paramName);

            for (PDirective directive : node.getDirectives()) {
                directive.apply(this);
            }

            this.currentContextName = paramName.concat(GenerationUtils.CONTEXT_STRING);
            this.indexBuilder = 0;

            MInitInternalsCall mInitInternalsCall = this.currentMacroBuilder.newInitInternalsCall(paramName);
            MAddAll mAddAll = this.currentMacroToBuild.newAddAll(paramName);

            this.currentAddAllApplyInitializer = mAddAll.newApplyInternalsInitializer(paramName);
            this.currentApplyInitializer = this.currentMacroToBuild.newInitInternalsMethod(paramName)
                                                .newApplyInternalsInitializer(paramName);

            this.contextNames.add(this.currentContextName);
            this.currentConstructor.newInitMacroParam(paramName);
            this.currentConstructor.newInitInternalValue(paramName);
            this.currentMacroBuilder.newInitDirectivesCall(paramName);

            if(this.currentMacroHasInternals){
                mInitInternalsCall.newContextArg();
            }
            else{
                mAddAll.newIsBuilt(this.currentMacro.getName());
            }
        }
        else{
            throw new InternalException("case unhandled");
        }

        node.getType().apply(this);
        outAParam(node);
    }

    @Override
    public void outAParam(
            AParam node) {

        this.currentParamName = null;
        this.currentContextName = null;
        this.currentApplyInitializer = null;
        this.currentRedefinedInternalsSetter = null;
        this.indexBuilder = 0;
        this.indexInsert = 0;
        this.createdBuilders = new ArrayList<>();
        this.createdInserts = new ArrayList<>();
        this.currentParamMacroRefBuilder = null;
        this.currentInitDirectives = null;
    }

    @Override
    public void inADirective(
            ADirective node) {

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
        }
    }

    @Override
    public void outADirective(
            ADirective node) {

        this.indexBuilder++;
        this.currentDirective = null;
        this.mSetNoneDirective = null;
    }

    @Override
    public void inAMacroRef(
            AMacroRef node) {

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
    }

    @Override
    public void outAMacroRef(
            AMacroRef node) {

        this.currentMacroRefName = null;
    }

    @Override
    public void caseAStringValue(
            AStringValue node) {

        this.indexBuilder++;
        String index_builder = String.valueOf(this.indexBuilder);
        boolean anyContext = this.currentContextName != null;

        if(anyContext){
            this.currentRedefinedInternalsSetter.newInitStringBuilder(index_builder);

            this.currentRedefinedInternalsSetter.newSetInternal(
                    this.currentMacroRefName,
                    GenerationUtils.buildNameCamelCase(node.getParamName()),
                    this.currentContextName).newStringBuilderBuild(index_builder);

            for(PTextPart part : node.getParts()){
                part.apply(this);
            }
        }
        else{
            index_builder = GenerationUtils.getLetterFromInteger(this.indexBuilder);

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
        }
    }

    @Override
    public void caseAStringTextPart(
            AStringTextPart node) {

        String index_builder = String.valueOf(this.indexBuilder);

        if(this.currentContextName != null
                && this.currentRedefinedInternalsSetter != null){

            this.currentRedefinedInternalsSetter.newStringPart(
                    GenerationUtils.escapedString(node.getString()),
                    String.valueOf(this.indexBuilder));
        }
        else {
            String string = GenerationUtils.escapedString(node.getString());

            if(this.currentInsertMacroPart != null){
                index_builder = GenerationUtils.getLetterFromInteger(this.indexBuilder);
                this.currentInsertMacroPart.newStringPart(
                        string,
                        index_builder);
            }
            else if(this.currentDirective != null){
                this.currentDirective.newStringPart(
                        string,
                        index_builder);
            }
            else if(this.mSetNoneDirective != null){
                this.mSetNoneDirective.newStringPart(
                        string,
                        index_builder);
            }
        }
    }

    @Override
    public void caseAVarTextPart(
            AVarTextPart node) {

        String index_builder = String.valueOf(this.indexBuilder);
        String param_name = GenerationUtils.buildNameCamelCase(node.getNames());
        if(this.currentContextName != null
                && this.currentRedefinedInternalsSetter != null){

            this.currentRedefinedInternalsSetter.newParamInsertPart(
                    param_name,
                    index_builder);
        }
        else {
            if(this.currentInsertMacroPart != null){
                index_builder = GenerationUtils.getLetterFromInteger(this.indexBuilder);
                this.currentInsertMacroPart.newParamInsertPart(
                        param_name,
                        index_builder);
            }
            else if(this.currentDirective != null){
                this.currentDirective.newParamInsertPart(
                        param_name,
                        index_builder);
            }
            else if(this.mSetNoneDirective != null){
                this.mSetNoneDirective.newParamInsertPart(
                        param_name,
                        index_builder);
            }
        }
    }

    @Override
    public void caseAEolTextPart(
            AEolTextPart node) {

        String index_builder = String.valueOf(indexBuilder);

        if(this.currentContextName != null
                && this.currentRedefinedInternalsSetter != null){

            this.currentRedefinedInternalsSetter.newEolPart(index_builder);
        }
        else {

            if(this.currentInsertMacroPart != null){
                index_builder = GenerationUtils.getLetterFromInteger(this.indexBuilder);
                this.currentInsertMacroPart.newEolPart(
                        index_builder);
            }
            else if(this.currentDirective != null){
                this.currentDirective.newEolPart(index_builder);
            }
            else if(this.mSetNoneDirective != null){
                this.mSetNoneDirective.newEolPart(index_builder);
            }
        }
    }

    @Override
    public void caseAInsertTextPart(
            AInsertTextPart node) {

        MInsertMacroPart tempInsertMacroPart = this.currentInsertMacroPart;
        AMacroRef macroRef = (AMacroRef) node.getMacroRef();
        String macro_name = GenerationUtils.buildNameCamelCase(macroRef.getNames());
        String index_builder = String.valueOf(this.indexBuilder);

        //Avoid declaring insert of the same name
        while(this.createdInserts.contains(this.indexInsert)){
            this.indexInsert++;
        }

        String index_insert = String.valueOf(this.indexInsert);

        if(this.currentContextName != null
                && this.currentRedefinedInternalsSetter != null){

            this.currentInsertMacroPart =
                    this.currentRedefinedInternalsSetter.newInsertMacroPart(
                            macro_name,
                            index_builder,
                            index_insert);
        }
        else{
            if(tempInsertMacroPart != null){
                index_builder = GenerationUtils.getLetterFromInteger(this.indexBuilder);

                this.currentInsertMacroPart =
                        tempInsertMacroPart.newInsertMacroPart(
                                macro_name,
                                index_builder,
                                index_insert);

            }
            else if(this.currentDirective != null){
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
        this.currentContextName = null;

        node.getMacroRef().apply(this);

        this.indexBuilder = tempIndex;
        this.indexInsert = tempIndexInsert;
        this.currentContextName = tempContext;
        this.currentMacroRefName = tempMacroName;
        this.currentInsertMacroPart = tempInsertMacroPart;

    }

    @Override
    public void outAVarValue(
            AVarValue node) {

        String var_name = GenerationUtils.buildNameCamelCase(node.getNames());

        if(this.currentContextName != null){

            MParamRef paramRef = this.currentRedefinedInternalsSetter.newSetInternal(
                        this.currentMacroRefName,
                        GenerationUtils.buildNameCamelCase(node.getParamName()),
                        this.currentContextName)
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
        }
    }

    @Override
    public void outAMacro(
            AMacro node) {

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
                String.valueOf(indexBuilder));
    }

    @Override
    public void outAEolMacroPart(
            AEolMacroPart node) {

        this.currentMacroBuilder.newEolPart(String.valueOf(indexBuilder));
    }

    @Override
    public void caseAInsertMacroPart(
            AInsertMacroPart node) {

        AMacroRef macroRef = (AMacroRef) node.getMacroRef();
        String macro_name = GenerationUtils.buildNameCamelCase(macroRef.getNames());
        this.indexInsert++;

        this.currentInsertMacroPart =
                this.currentMacroBuilder.newInsertMacroPart(
                        macro_name, String.valueOf(indexBuilder), String.valueOf(indexInsert));

        this.createdInserts.add(this.indexInsert);
        Integer tempIndexBuilder = this.indexBuilder;
        Integer tempIndexInsert = this.indexInsert;

        node.getMacroRef().apply(this);

        this.indexInsert = tempIndexInsert;
        this.indexBuilder = tempIndexBuilder;
        this.currentInsertMacroPart = null;
    }

    @Override
    public void outAVarMacroPart(
            AVarMacroPart node) {

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
}
