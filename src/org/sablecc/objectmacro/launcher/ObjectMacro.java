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

package org.sablecc.objectmacro.launcher;

import java.io.*;
import java.util.*;

import org.sablecc.exception.*;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import org.sablecc.objectmacro.intermediate.macro.*;
=======
import org.sablecc.objectmacro.codegeneration.*;
import org.sablecc.objectmacro.codegeneration.c.*;
import org.sablecc.objectmacro.codegeneration.intermediate.*;
import org.sablecc.objectmacro.codegeneration.java.*;
import org.sablecc.objectmacro.codegeneration.scala.*;
=======
>>>>>>> FrontEnd is now independent about name conventions
import org.sablecc.objectmacro.codegeneration.intermediate.macro.*;
>>>>>>> New Intermediate Representation file generated 
import org.sablecc.objectmacro.errormessage.*;
import org.sablecc.objectmacro.exception.*;
<<<<<<< HEAD
=======
import org.sablecc.objectmacro.intermediate.syntax3.node.*;
<<<<<<< HEAD
import org.sablecc.objectmacro.intermediate.syntax3.node.AMacro;
import org.sablecc.objectmacro.intermediate.syntax3.node.AOption;
import org.sablecc.objectmacro.intermediate.syntax3.node.PMacro;
import org.sablecc.objectmacro.intermediate.syntax3.node.POption;
import org.sablecc.objectmacro.intermediate.syntax3.node.PParam;
import org.sablecc.objectmacro.intermediate.syntax3.node.PType;
>>>>>>> ObjectMacro2 syntaxic/lexical/semantic analysis
=======
>>>>>>> New Intermediate Representation file generated 
=======
import org.sablecc.objectmacro.intermediate.macro.*;
import org.sablecc.objectmacro.errormessage.*;
import org.sablecc.objectmacro.exception.*;
>>>>>>> Split DefinitionCollector into MacroReferenceCollector and ParamReferenceCollector
import org.sablecc.objectmacro.structure.*;
import org.sablecc.objectmacro.syntax3.lexer.*;
import org.sablecc.objectmacro.syntax3.node.*;
import org.sablecc.objectmacro.syntax3.node.AStringType;
import org.sablecc.objectmacro.syntax3.node.Start;
import org.sablecc.objectmacro.syntax3.parser.*;
import org.sablecc.objectmacro.util.Utils;
<<<<<<< HEAD
<<<<<<< HEAD
import org.sablecc.objectmacro.walker.*;

=======
import org.sablecc.objectmacro.walker.DeclarationCollector;
import org.sablecc.objectmacro.walker.DefinitionCollector;
import org.sablecc.objectmacro.walker.DirectiveCollector;
import org.sablecc.objectmacro.walker.VarVerifier;
>>>>>>> FrontEnd is now independent about name conventions
=======
import org.sablecc.objectmacro.walker.*;

>>>>>>> Split DefinitionCollector into MacroReferenceCollector and ParamReferenceCollector
import org.sablecc.util.*;

/**
 * The main class of ObjectMacro.
 */
public class ObjectMacro {

    private static GlobalIndex globalIndex = null;
    /** Prevents instantiation of this class. */
    private ObjectMacro() {

        throw new InternalException("this class may not have instances");
    }

    /** Launches ObjectMacro. */
    public static void main(
            String[] args) {

        try {
            compile(args);
        }
        catch (CompilerException e) {
            System.err.print(e.getMessage());
            System.err.flush();
            System.exit(1);
        }
        catch (ParserException e) {
            int start = e.getMessage().indexOf(' ');
            System.err.print(new MSyntaxError(e.getToken().getLine() + "", e
                    .getToken().getPos() + "", e.getToken().getClass()
                    .getSimpleName().substring(1).toLowerCase(), e.getToken()
                    .getText(), e.getMessage().substring(start)));
            System.err.flush();
            System.exit(1);
        }
        catch (LexerException e) {
            int start = e.getMessage().indexOf('[') + 1;
            int end = e.getMessage().indexOf(',');
            String line = e.getMessage().substring(start, end);

            start = e.getMessage().indexOf(',') + 1;
            end = e.getMessage().indexOf(']');
            String pos = e.getMessage().substring(start, end);

            start = e.getMessage().indexOf(' ') + 1;

            System.err.print(new MLexicalError(line, pos, e.getMessage()
                    .substring(start)));
            System.err.flush();
            System.exit(1);
        }
        catch (InternalException e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            pw.flush();
            System.err.print(new MInternalError(sw.toString(), e.getMessage()));
            System.err.flush();
            System.exit(1);
        }

        // finish gracefully
        System.exit(0);
    }

    /**
     * Parses the provided arguments and launches macro compilation.
     */
    public static void compile(
            String[] arguments)
            throws ParserException, LexerException {

        // default destination directory is current working directory
        File destinationDirectory = new File(System.getProperty("user.dir"));

        // default destination package is anonymous
        String destinationPackage = "";

        // default option values
        boolean generateCode = true;
        Verbosity verbosity = Verbosity.INFORMATIVE;
        Strictness strictness = Strictness.STRICT;

        // parse command line arguments
        ArgumentCollection argumentCollection = new ArgumentCollection(
                arguments);

        // handle option arguments
        for (OptionArgument optionArgument : argumentCollection
                .getOptionArguments()) {

            switch (optionArgument.getOption()) {

            case DESTINATION:
                destinationDirectory = new File(optionArgument.getOperand());
                break;

            case PACKAGE:
                destinationPackage = optionArgument.getOperand();
                break;

            case GENERATE:
                generateCode = true;
                break;

            case NO_CODE:
                generateCode = false;
                break;

            case LENIENT:
                strictness = Strictness.LENIENT;
                break;

            case STRICT:
                strictness = Strictness.STRICT;
                break;

            case QUIET:
                verbosity = Verbosity.QUIET;
                break;

            case INFORMATIVE:
                verbosity = Verbosity.INFORMATIVE;
                break;

            case VERBOSE:
                verbosity = Verbosity.VERBOSE;
                break;

            case VERSION:
                System.out.println("ObjectMacro, part of SableCC version "
                        + Version.VERSION);
                return;

            case HELP:
                System.out.println("Usage: objectmacro "
                        + Option.getShortHelpMessage() + " file.objectmacro");
                System.out.println("Options:");
                System.out.println(Option.getLongHelpMessage());
                return;
            default:
                throw new InternalException("unhandled option "
                        + optionArgument.getOption());
            }
        }

        switch (verbosity) {
        case INFORMATIVE:
        case VERBOSE:
            System.out.println();
            System.out.println("ObjectMacro, part of SableCC version "
                    + Version.VERSION);
            System.out
                    .println("by Etienne M. Gagnon <egagnon@j-meg.com> and other contributors.");
            System.out.println();
            break;
        }

        // handle text arguments
        if (argumentCollection.getTextArguments().size() == 0) {
            System.out.println("Usage: objectmacro "
                    + Option.getShortHelpMessage() + " file.objectmacro");
            return;
        }
        else if (argumentCollection.getTextArguments().size() > 1) {
            throw CompilerException.invalidArgumentCount();
        }

        // check argument
        TextArgument textArgument = argumentCollection.getTextArguments()
                .get(0);

        if (!textArgument.getText().endsWith(".objectmacro")) {
            throw CompilerException.invalidObjectmacroSuffix(textArgument.getText());
        }

        File macroFile = new File(textArgument.getText());

        if (!macroFile.exists()) {
            throw CompilerException.missingMacroFile(textArgument.getText());
        }

        if (!macroFile.isFile()) {
            throw CompilerException.macroNotFile(textArgument.getText());
        }

        compile(macroFile, destinationDirectory,
                destinationPackage, generateCode, strictness, verbosity);
    }

    /**
     * Compiles the provided macro file.
     */
    private static void compile(
            File macroFile,
            File destinationDirectory,
            String destinationPackage,
            boolean generateCode,
            Strictness strictness,
            Verbosity verbosity)
            throws ParserException, LexerException {

        switch (verbosity) {
        case INFORMATIVE:
        case VERBOSE:
            System.out.println("Compiling \"" + macroFile + "\"");
            break;
        }

        Start ast;

        try {
            FileReader fr = new FileReader(macroFile);
            BufferedReader br = new BufferedReader(fr);
            PushbackReader pbr = new PushbackReader(br, 1024);

            switch (verbosity) {
            case VERBOSE:
                System.out.println(" Parsing");
                break;
            }

            ast = new Parser(new CustomLexer(pbr)).parse();

            pbr.close();
            br.close();
            fr.close();
        }
        catch (IOException e) {
            throw CompilerException.inputError(macroFile.toString(), e);
        }

<<<<<<< HEAD
<<<<<<< HEAD
        globalIndex = verifySemantics(ast, strictness, verbosity);
=======
        GlobalIndex globalIndex = verifySemantics(ast, strictness, verbosity);

        generateIntermediateFile(
<<<<<<< HEAD
                globalIndex, verbosity, destinationDirectory);

<<<<<<< HEAD
        PIntermediateRepresentation intermediateAST = generateIntermediateAST(
                globalIndex, verbosity);
>>>>>>> New Intermediate Representation file generated 

        if(generateCode){
            generateIntermediateFile(
                    verbosity, destinationDirectory, macroFile);
        }

=======
//        PIntermediateRepresentation intermediateAST = generateIntermediateAST(
//                globalIndex, verbosity);
//
//        IntermediateRepresentation ir = new IntermediateRepresentation(
//                intermediateAST, macroFile, destinationDirectory,
//                destinationPackage);
//
//        CodeGenerator codeGenerator;
//
//        if (targetLanguage.equals("java")) {
//            codeGenerator = new JavaCodeGenerator(ir);
//        }
//        else if (targetLanguage.equals("intermediate")) {
//            codeGenerator = new IntermediateCodeGenerator(ir);
//        }
//        else if (targetLanguage.equals("c")) {
//            codeGenerator = new CCodeGenerator(ir);
//        }
//        else if (targetLanguage.equals("scala")) {
//            codeGenerator = new ScalaCodeGenerator(ir);
//        }
//        else {
//            throw new InternalException("unhandled case");
//        }
//
//        switch (verbosity) {
//        case VERBOSE:
//            System.out.println(" Verifying target-specific semantics");
//            break;
//        }
//
//        codeGenerator.verifyTargetSpecificSemantics(strictness);
//
//        if (generateCode) {
//            switch (verbosity) {
//            case VERBOSE:
//                System.out.println(" Generating code");
//                break;
//            }
//
//            codeGenerator.generateCode();
//        }
>>>>>>> Comment Code generation to compile ObjectMacro
=======
                globalIndex, verbosity, destinationDirectory, macroFile);
=======
        globalIndex = verifySemantics(ast, strictness, verbosity);

<<<<<<< HEAD
        generateIntermediateFile(
                verbosity, destinationDirectory, macroFile);
>>>>>>> Add internals name in intermediate representation in args
=======
        if(generateCode){
            generateIntermediateFile(
                    verbosity, destinationDirectory, macroFile);
        }
>>>>>>> Clean up code, add comments

>>>>>>> FrontEnd is now independent about name conventions
    }

    private static GlobalIndex verifySemantics(
            Start ast,
            Strictness strictness,
            Verbosity verbosity) {

        switch (verbosity) {
        case VERBOSE:
            System.out.println(" Verifying semantics");
            break;
        }

        GlobalIndex globalIndex = new GlobalIndex();

        ast.apply(new DeclarationCollector(globalIndex));
<<<<<<< HEAD
<<<<<<< HEAD
        ast.apply(new MacroReferenceCollector(globalIndex));
        ast.apply(new ParamReferenceCollector(globalIndex));
        ast.apply(new DirectiveCollector(globalIndex));
        ast.apply(new VarVerifier(globalIndex));

        for(Macro macro : globalIndex.getAllMacros()){
<<<<<<< HEAD
            macro.detectParamsCyclicReference();
        }

        if(strictness == Strictness.STRICT){
            for (Macro macro : globalIndex.getAllMacros()) {
                Set<Param> allParamsInternals = new LinkedHashSet<>();
                allParamsInternals.addAll(macro.getAllInternals());
                allParamsInternals.addAll(macro.getAllParams());

                for (Param param : allParamsInternals) {
=======
        ast.apply(new DefinitionCollector(globalIndex));
=======
        ast.apply(new MacroReferenceCollector(globalIndex));
        ast.apply(new ParamReferenceCollector(globalIndex));
>>>>>>> Split DefinitionCollector into MacroReferenceCollector and ParamReferenceCollector
        ast.apply(new DirectiveCollector(globalIndex));
        ast.apply(new VarVerifier(globalIndex));

        if (strictness == Strictness.STRICT) {
=======
            Set<Param> allParamsInternals = new LinkedHashSet<>();
            allParamsInternals.addAll(macro.getAllInternals());
            allParamsInternals.addAll(macro.getAllParams());

            macro.detectParamsCyclicReference();
        }
>>>>>>> Removed walker cyclic detector and computing indirect param references

        if(strictness == Strictness.STRICT){
            for (Macro macro : globalIndex.getAllMacros()) {
<<<<<<< HEAD
                for (Param param : macro.getAllParams()) {
>>>>>>> ObjectMacro2 syntaxic/lexical/semantic analysis
=======
                Set<Param> allParamsInternals = new LinkedHashSet<>();
                allParamsInternals.addAll(macro.getAllInternals());
                allParamsInternals.addAll(macro.getAllParams());

                for (Param param : allParamsInternals) {
>>>>>>> Verify params and internals if they are all used
                    if (!param.isUsed()) {
                        throw CompilerException.unusedParam(param);
                    }
                }
            }
        }


        return globalIndex;
    }

<<<<<<< HEAD
    private static void generateIntermediateFile(
            Verbosity verbosity,
            File destinationDirectory,
            File macroFile) {

        switch (verbosity) {
        case VERBOSE:
            System.out.println(" Creating intermediate structure");
            break;
        }
<<<<<<< HEAD

        StringBuilder macros_string = new StringBuilder();

        for (Macro macro : globalIndex.getAllMacros()) {
<<<<<<< HEAD
            MMacro macro_macro = createMacro(macro);
            macros_string.append(macro_macro.toString());
            macros_string.append(System.getProperty("line.separator"));
        }

        String macroFileName = macroFile.getName();
        int length = macroFileName.length();

        String name = macroFile.getName()
                .substring(0, length - ".objectmacro".length());

        File destination = new File(destinationDirectory, name.concat(".intermediate"));

        try {
            FileWriter fw = new FileWriter(destination);
            fw.write(macros_string.toString());
            fw.close();
        }
        catch (IOException e) {
            throw CompilerException.outputError(destination.toString(), e);
        }
=======
>>>>>>> ObjectMacro2 syntaxic/lexical/semantic analysis
    }

<<<<<<< HEAD
    private static MMacro createMacro(
            Macro macro) {
=======
=======
>>>>>>> Add initialization order to params depending on the relations between params
    private static void generateIntermediateFile(
            GlobalIndex globalIndex,
<<<<<<< HEAD
            Verbosity verbosity) {
>>>>>>> New Intermediate Representation file generated 
=======
            Verbosity verbosity,
<<<<<<< HEAD
            File destinationDirectory) {
>>>>>>> Fix Destination Directory for generated intermediate file 
=======
            File destinationDirectory,
            File macroFile) {
>>>>>>> FrontEnd is now independent about name conventions

        MMacro mMacro = new MMacro();
        String splittedMacroName[] = Utils.splitName(macro.getNameDeclaration());
        for(String part : splittedMacroName){
            mMacro.newSimpleName(part);
        }

<<<<<<< HEAD
        Set<Internal> macro_internals = macro.getAllInternals();
        Set<External> macro_params = macro.getAllParams();

        List<PMacroBodyPart> macroBodyParts = macro.getDeclaration().getMacroBodyParts();
        createMacroBody(mMacro, macroBodyParts);

        for(External param : macro_params){
            createParam(mMacro.newParam(), param);
        }

<<<<<<< HEAD
        for(Internal internal : macro_internals){
            createInternal(mMacro.newInternal(), internal);
        }
=======
        List<PMacro> macros = new LinkedList<PMacro>();
>>>>>>> ObjectMacro2 syntaxic/lexical/semantic analysis
=======
        StringBuilder macros_string = new StringBuilder();
>>>>>>> New Intermediate Representation file generated 

        MInitializationOrder mInitializationOrder = mMacro.newInitializationOrder();

<<<<<<< HEAD
        for(Param param : macro.getComponentFinder().getLinearization()){
            if(!param.isString()){
                mInitializationOrder.newSimpleName(param.getName());
            }
        }

<<<<<<< HEAD
        return mMacro;
    }

    private static void createMacroBody(
            MMacro mMacro,
            List<PMacroBodyPart> macroBodyParts){

        for(PMacroBodyPart bodyPart : macroBodyParts){
            if(bodyPart instanceof AEscapeMacroBodyPart){
                AEscapeMacroBodyPart escapeMacroBodyPart = (AEscapeMacroBodyPart) bodyPart;

                if(escapeMacroBodyPart.getTextEscape().getText().equals("{{")){
                    mMacro.newStringPart("{");
                }
                else{
                    throw new InternalException("case unhandled");
                }
            }
            else if(bodyPart instanceof ATextMacroBodyPart){
                ATextMacroBodyPart textBodyPart = ((ATextMacroBodyPart) bodyPart);

                String macroTextPart = textBodyPart.getTextPart().getText().replaceAll("'","\\\\'");
                mMacro.newStringPart(macroTextPart);
            }
            else if(bodyPart instanceof AInsertMacroBodyPart){
                AInsertMacroBodyPart insertPart = (AInsertMacroBodyPart) bodyPart;

                AMacroReference macroReference = (AMacroReference) insertPart.getMacroReference();
                MMacroInsert macroInsert = mMacro.newMacroInsert();
                MMacroRef mMacroRef = macroInsert.newMacroRef();

                String macroRefName[] = Utils.splitName(macroReference.getName());
                for(String part : macroRefName){
                    mMacroRef.newSimpleName(part);

                }

                if(macroReference.getValues().size() > 0){
                    createArgs(mMacroRef.newArgs(), macroReference);
                }

            }
            else if(bodyPart instanceof AVarMacroBodyPart){
                AVarMacroBodyPart aVarMacroBodyPart = (AVarMacroBodyPart) bodyPart;

                String varNames[] = Utils.getVarName(aVarMacroBodyPart.getVariable()).split(Utils.NAME_SEPARATOR);
                MParamInsert mParamInsert = mMacro.newParamInsert();

                for(String part : varNames){
                    mParamInsert.newSimpleName(part);

                }
            }
            else if(bodyPart instanceof AEolMacroBodyPart){
                mMacro.newEolPart();
            }
            else {
                throw new InternalException("case unhandled");
            }
        }
    }

    private static void createTextParts(
            MTextArgument mTextArgument,
            List<PStringPart> stringParts){

        for(PStringPart stringPart : stringParts){
            if(stringPart instanceof ATextStringPart){
                ATextStringPart textPart = ((ATextStringPart) stringPart);

                String text = textPart.getText().getText().replaceAll("'", "\\\\'");
                mTextArgument.newStringPart(text);
            }
            else if(stringPart instanceof AInsertStringPart){
                AMacroReference macro_node = (AMacroReference) ((AInsertStringPart) stringPart).getMacro();

                MMacroRef macro_ref = mTextArgument.newMacroInsert().newMacroRef();

                String macroRefName[] = Utils.splitName(macro_node.getName());
                for(String part : macroRefName){
                    macro_ref.newSimpleName(part);

                }

                if(macro_node.getValues().size() > 0){
                    createArgs(macro_ref.newArgs(), macro_node);
                }
            }
            else if(stringPart instanceof AVarStringPart){
                TVariable var_token = ((AVarStringPart) stringPart).getVariable();
                MParamInsert mParamInsert = mTextArgument.newParamInsert();

                String splittedVarName[] = Utils.getVarName(var_token).split(Utils.NAME_SEPARATOR);
                for(String part : splittedVarName){
                    mParamInsert.newSimpleName(part);
                }
            }
            else if(stringPart instanceof AEscapeStringPart){
                AEscapeStringPart escapeStringPart = (AEscapeStringPart) stringPart;

                String text = escapeStringPart.getStringEscape().getText();
                if(text.equals("\\\\")){
                    mTextArgument.newStringPart("\\");
                }
                else if(text.equals("\\n")){
                    mTextArgument.newEolPart();
                }
                else if(text.startsWith("\\")){
                    mTextArgument.newStringPart(text.substring(text.length() - 1));
                }
                else{
                    throw new InternalException("case unhandled");
                }
            }
            else{
                throw new InternalException("case unhandled");
            }
        }
    }

    private static void createDirectiveParts(
            MDirective mDirective,
            List<PStringPart> stringParts){

        for(PStringPart stringPart : stringParts){
            if(stringPart instanceof ATextStringPart){
                String stringPartText = ((ATextStringPart) stringPart).getText().getText();

                stringPartText = stringPartText.replaceAll("'", "\\\\'");
                mDirective.newStringPart(stringPartText);
            }
            else if(stringPart instanceof AInsertStringPart){
                AMacroReference macro_node = (AMacroReference) ((AInsertStringPart) stringPart).getMacro();

                MMacroRef macro_ref = mDirective.newMacroInsert().newMacroRef();

                String macroRefName[] = Utils.splitName(macro_node.getName());
                for(String part : macroRefName){
                    macro_ref.newSimpleName(part);
                }

                if(macro_node.getValues().size() > 0){
                    createArgs(macro_ref.newArgs(), macro_node);
                }
            }
            else if(stringPart instanceof AVarStringPart){
                TVariable tVariable = ((AVarStringPart) stringPart).getVariable();

                MParamInsert mParamInsert = mDirective.newParamInsert();
                String splittedVarName[] = Utils.getVarName(tVariable).split(Utils.NAME_SEPARATOR);

                for(String part : splittedVarName){
                    mParamInsert.newSimpleName(part);
                }
            }
            else if(stringPart instanceof AEscapeStringPart){
                AEscapeStringPart escapeStringPart = (AEscapeStringPart) stringPart;
                String text = escapeStringPart.getStringEscape().getText();

                if(text.equals("\\\\")){
                    mDirective.newStringPart("\\");
                }
                else if(text.equals("\\n")){
                    mDirective.newEolPart();
                }
                else{
                    throw new InternalException("case unhandled");
                }
            }
            else{
                throw new InternalException("case unhandled");
            }
        }
    }

    private static void createParam(
            MParam macro_param,
            External param){

        String paramNames[] = Utils.splitName(param.getNameDeclaration());
        for(String part : paramNames){
            macro_param.newSimpleName(part);
        }

        if(param.getDeclaration().getType() instanceof AStringType){
            macro_param.newStringType();
        }
        else if(param.getDeclaration().getType() instanceof AMacrosType){
            MMacroType macro_param_type = macro_param.newMacroType();

            Set<AMacroReference> macroReferences = param.getMacroReferences();

            for(AMacroReference l_macroRef : macroReferences){
                MMacroRef macroRef = macro_param_type.newMacroRef();

                String splittedMacroName[] = Utils.splitName(l_macroRef.getName());
                for(String part : splittedMacroName){
                    macroRef.newSimpleName(part);
                }

                if(l_macroRef.getValues().size() > 0){
                    createArgs(macroRef.newArgs(), l_macroRef);
                }
            }
        }

        Set<Directive> directives = param.getAllDirectives();
        for(Directive l_directive : directives){
            MDirective mDirective = macro_param.newDirective();

            String splittedDirectiveName[] = Utils.splitName(l_directive.getDeclaration().getName());
            for(String part : splittedDirectiveName){
                mDirective.newSimpleName(part);
            }

            createDirectiveParts(mDirective, l_directive.getDeclaration().getParts());
        }
    }

    private static void createInternal(
            MInternal macro_internal,
            Internal param){

        String paramNames[] = Utils.splitName(param.getNameDeclaration());
        for(String part : paramNames){
            macro_internal.newSimpleName(part);
        }

        if(param.getDeclaration().getType() instanceof AStringInternalType){
            macro_internal.newStringType();
        }
        else if(param.getDeclaration().getType() instanceof AIdentifiersInternalType){
            MMacroType macro_param_type = macro_internal.newMacroType();

            Set<AMacroReference> macroReferences = param.getMacroReferences();

            for(AMacroReference l_macroRef : macroReferences){
                MMacroRef macroRef = macro_param_type.newMacroRef();

                String splittedMacroName[] = Utils.splitName(l_macroRef.getName());
                for(String part : splittedMacroName){
                    macroRef.newSimpleName(part);
                }
            }
        }
    }

    private static void createArgs(
            MArgs macro_args,
            AMacroReference aMacroReference){

        Macro macroReferenced = globalIndex.getMacro(aMacroReference.getName());
        List<String> paramNames = macroReferenced.getInternalsName();
        List<PStaticValue> arguments = aMacroReference.getValues();
        int i = 0;

        for(PStaticValue argument : arguments){
            if(argument instanceof AStringStaticValue){
                AStringStaticValue stringValue = (AStringStaticValue) argument;

                MTextArgument textArgument = macro_args.newTextArgument();
                textArgument.newParamName(paramNames.get(i));

                createTextParts(textArgument, stringValue.getParts());
            }
            else if(argument instanceof AVarStaticValue){
                AVarStaticValue varValue = (AVarStaticValue) argument;

                MVarArgument varArgument = macro_args.newVarArgument();
                varArgument.newParamName(paramNames.get(i));

                String macroRefName[] = Utils.splitName(varValue.getIdentifier());
                for(String part : macroRefName){
                    varArgument.newSimpleName(part);
                }
=======
        return new AIntermediateRepresentation(macros);
=======
=======
>>>>>>> Clean up code, add comments
            MMacro macro_macro = createMacro(macro);
            macros_string.append(macro_macro.toString());
            macros_string.append(System.getProperty("line.separator"));
        }

        String macroFileName = macroFile.getName();
        int length = macroFileName.length();

        String name = macroFile.getName()
                .substring(0, length - ".objectmacro".length());

        File destination = new File(destinationDirectory, name.concat(".intermediate"));

        try {
            FileWriter fw = new FileWriter(destination);
            fw.write(macros_string.toString());
            fw.close();
        }
        catch (IOException e) {
            throw CompilerException.outputError(destination.toString(), e);
        }
>>>>>>> New Intermediate Representation file generated 
    }

    private static MMacro createMacro(
            Macro macro) {

        MMacro mMacro = new MMacro();
        String macroNames[] = Utils.splitName(macro.getNameDeclaration());
        for(String part : macroNames){
            mMacro.newSimpleName(part);
        }

        Set<Param> macro_internals = macro.getAllInternals();
        Set<Param> macro_params = macro.getAllParams();

        List<PMacroBodyPart> macroBodyParts = macro.getDeclaration().getMacroBodyParts();
        createMacroBody(mMacro, macroBodyParts);

        for(Param param : macro_params){
            createParam(
                    mMacro.newParam(), param);
        }

        for(Param internal : macro_internals){
            createInternal(
                    mMacro.newInternal(), internal);
        }

        MInitializationOrder mInitializationOrder = mMacro.newInitializationOrder();

        for(Param param : macro.getComponentFinder().getLinearization()){
            mInitializationOrder.newSimpleName(param.getName());
        }

        return mMacro;
    }

    private static void createMacroBody(
            MMacro mMacro,
            List<PMacroBodyPart> macroBodyParts){

        for(PMacroBodyPart bodyPart : macroBodyParts){

            if(bodyPart instanceof AEscapeMacroBodyPart){
                AEscapeMacroBodyPart escapeMacroBodyPart = (AEscapeMacroBodyPart) bodyPart;

                if(escapeMacroBodyPart.getTextEscape().getText().equals("{{")){
                    mMacro.newStringPart("{");
                }else{
                    throw new InternalException("case unhandled");
                }
            }else if(bodyPart instanceof ATextMacroBodyPart){

                ATextMacroBodyPart aTextMacroBodyPart = ((ATextMacroBodyPart) bodyPart);
                String macroTextPart = aTextMacroBodyPart.getTextPart().getText();
                macroTextPart = macroTextPart.replaceAll("'", "\\\\'");

                mMacro.newStringPart(macroTextPart);

            }else if(bodyPart instanceof AInsertMacroBodyPart){

                AInsertMacroBodyPart aInsertMacroBodyPart = (AInsertMacroBodyPart) bodyPart;
                AMacroReference macroRef = (AMacroReference) aInsertMacroBodyPart.getMacroReference();
                MMacroInsert macroInsert = mMacro.newMacroInsert();
                MMacroRef mMacroRef = macroInsert.newMacroRef();

                String macroRefName[] = Utils.splitName(macroRef.getName());
                for(String part : macroRefName){
                    mMacroRef.newSimpleName(part);

                }

                if(macroRef.getValues().size() > 0){
                    createArgs(mMacroRef.newArgs(), macroRef);
                }

            }else if(bodyPart instanceof AVarMacroBodyPart){

                AVarMacroBodyPart aVarMacroBodyPart = (AVarMacroBodyPart) bodyPart;
                String varNames[] = Utils.getVarName(aVarMacroBodyPart.getVariable()).split(Utils.NAME_SEPARATOR);
                MParamInsert mParamInsert = mMacro.newParamInsert();

                for(String part : varNames){
                    mParamInsert.newSimpleName(part);

                }
            }else if(bodyPart instanceof AEolMacroBodyPart){

                mMacro.newEolPart();
            }
            else {
                throw new InternalException("case unhandled");
            }
        }
    }

    private static void createTextParts(
            MTextArgument mTextArgument,
            List<PStringPart> stringParts){

        for(PStringPart stringPart : stringParts){
            if(stringPart instanceof ATextStringPart){
                String stringPartText = ((ATextStringPart) stringPart).getText().getText();

                stringPartText = stringPartText.replaceAll("'", "\\\\'");

                mTextArgument.newStringPart(stringPartText);
            }
            else if(stringPart instanceof AInsertStringPart){

                AMacroReference macro_node = (AMacroReference) ((AInsertStringPart) stringPart).getMacro();
                MMacroInsert mMacroInsert = mTextArgument.newMacroInsert();
                MMacroRef mMacroRef = mMacroInsert.newMacroRef();

                String macroRefName[] = Utils.splitName(macro_node.getName());
                for(String part : macroRefName){
                    mMacroRef.newSimpleName(part);

                }

                if(macro_node.getValues().size() > 0){
                    createArgs(mMacroRef.newArgs(), macro_node);
                }
            }
            else if(stringPart instanceof AVarStringPart){
                TVariable tVariable = ((AVarStringPart) stringPart).getVariable();
                MParamInsert mParamInsert = mTextArgument.newParamInsert();

                String varNames[] = Utils.getVarName(tVariable).split(Utils.NAME_SEPARATOR);
                for(String part : varNames){
                    mParamInsert.newSimpleName(part);

                }
            }
            else if(stringPart instanceof AEscapeStringPart){

                AEscapeStringPart escapeStringPart = (AEscapeStringPart) stringPart;
                if(escapeStringPart.getStringEscape().getText().equals("\\\\")){
                    mTextArgument.newStringPart("\\");
                }else if(escapeStringPart.getStringEscape().getText().equals("\\n")){
                    mTextArgument.newEolPart();
                }
                else{
                    throw new InternalException("case unhandled");
                }
            }
            else{
                throw new InternalException("case unhandled");
            }
        }
    }

    private static void createDirectiveParts(
            MDirective mDirective,
            List<PStringPart> stringParts){

        for(PStringPart stringPart : stringParts){
            if(stringPart instanceof ATextStringPart){
                String stringPartText = ((ATextStringPart) stringPart).getText().getText();

                stringPartText = stringPartText.replaceAll("'", "\\\\'");

                mDirective.newStringPart(stringPartText);
            }
            else if(stringPart instanceof AInsertStringPart){

                AMacroReference macro_node = (AMacroReference) ((AInsertStringPart) stringPart).getMacro();
                MMacroInsert mMacroInsert = mDirective.newMacroInsert();
                MMacroRef mMacroRef = mMacroInsert.newMacroRef();

                String macroRefName[] = Utils.splitName(macro_node.getName());
                for(String part : macroRefName){
                    mMacroRef.newSimpleName(part);

                }

                if(macro_node.getValues().size() > 0){
                    createArgs(mMacroRef.newArgs(), macro_node);
                }
            }
            else if(stringPart instanceof AVarStringPart){
                TVariable tVariable = ((AVarStringPart) stringPart).getVariable();
                MParamInsert mParamInsert = mDirective.newParamInsert();

                String varNames[] = Utils.getVarName(tVariable).split(Utils.NAME_SEPARATOR);
                for(String part : varNames){
                    mParamInsert.newSimpleName(part);

                }
            }
            else if(stringPart instanceof AEscapeStringPart){

                AEscapeStringPart escapeStringPart = (AEscapeStringPart) stringPart;
                if(escapeStringPart.getStringEscape().getText().equals("\\\\")){
                    mDirective.newStringPart("\\");
                }else if(escapeStringPart.getStringEscape().getText().equals("\\n")){
                    mDirective.newEolPart();
                }
                else{
                    throw new InternalException("case unhandled");
                }
            }
            else{
                throw new InternalException("case unhandled");
            }
        }
    }

    private static void createParam(
            MParam macro_param,
            Param param){

        String paramNames[] = Utils.splitName(param.getNameDeclaration());
        for(String part : paramNames){
            macro_param.newSimpleName(part);

        }

        if(param.getDeclaration().getType() instanceof AStringType){
            macro_param.newStringType();

        }else if(param.getDeclaration().getType() instanceof AMacrosType){

            MMacroType macro_param_type = macro_param.newMacroType();
            Set<AMacroReference> macroReferences = param.getMacroReferences();

            for(AMacroReference l_macroRef : macroReferences){

                MMacroRef macroRef = macro_param_type.newMacroRef();
                String macroRefName[] = Utils.splitName(l_macroRef.getName());
                for(String part : macroRefName){
                    macroRef.newSimpleName(part);

                }

                if(l_macroRef.getValues().size() > 0){
                    createArgs(macroRef.newArgs(), l_macroRef);
                }
            }
        }

        Set<Directive> directives = param.getAllDirectives();
        for(Directive l_directive : directives){
            MDirective mDirective = macro_param.newDirective();

            String directiveNames[] = Utils.splitName(l_directive.getDeclaration().getName());
            for(String part : directiveNames){
                mDirective.newSimpleName(part);

            }
            createDirectiveParts(mDirective, l_directive.getDeclaration().getParts());
        }
    }

    private static void createInternal(
            MInternal macro_internal,
            Param param){

        String paramNames[] = Utils.splitName(param.getNameDeclaration());
        for(String part : paramNames){
            macro_internal.newSimpleName(part);

        }

        if(param.getDeclaration().getType() instanceof AStringType){
            macro_internal.newStringType();

        }else if(param.getDeclaration().getType() instanceof AMacrosType){

            MMacroType macro_param_type = macro_internal.newMacroType();
            Set<AMacroReference> macroReferences = param.getMacroReferences();

            for(AMacroReference l_macroRef : macroReferences){

                MMacroRef macroRef = macro_param_type.newMacroRef();
                if(l_macroRef.getValues().size() > 0){
                    createArgs(macroRef.newArgs(), l_macroRef);
                }

                String macroRefNames[] = Utils.splitName(l_macroRef.getName());
                for(String part : macroRefNames){
                    macroRef.newSimpleName(part);
                }
            }
        }

        Set<Directive> directives = param.getAllDirectives();

        for(Directive l_directive : directives){

            MDirective mDirective = macro_internal.newDirective();
            String directiveNames[] = Utils.splitName(l_directive.getDeclaration().getName());
            for(String part : directiveNames){
                mDirective.newSimpleName(part);

            }
            createDirectiveParts(mDirective, l_directive.getDeclaration().getParts());
        }
    }

    private static void createArgs(
            MArgs macro_args,
            AMacroReference aMacroReference){

        Macro macroReferenced = globalIndex.getMacro(aMacroReference.getName());
        List<String> paramNames = macroReferenced.getInternalsName();
        List<PStaticValue> arguments = aMacroReference.getValues();
        int i = 0;

        for(PStaticValue argument : arguments){
            if(argument instanceof AStringStaticValue){

                AStringStaticValue aStringStaticValue = (AStringStaticValue) argument;
                MTextArgument mTextArgument = macro_args.newTextArgument();
                mTextArgument.newParamName(paramNames.get(i));
                createTextParts(mTextArgument, aStringStaticValue.getParts());

            }else if(argument instanceof AVarStaticValue){

                AVarStaticValue aVarStaticValue = (AVarStaticValue) argument;
<<<<<<< HEAD
<<<<<<< HEAD
                AVarValue value = new AVarValue(
                        new TString(aVarStaticValue.getIdentifier().getText()));
                values.add(value);
>>>>>>> ObjectMacro2 syntaxic/lexical/semantic analysis
=======
                macro_args.newVarArgument(aVarStaticValue.getIdentifier().getText());
>>>>>>> New Intermediate Representation file generated 
=======
                MVarArgument mVarArgument = macro_args.newVarArgument();
                mVarArgument.newParamName(paramNames.get(i));

                String macroRefName[] = Utils.splitName(aVarStaticValue.getIdentifier());
                for(String part : macroRefName){
                    mVarArgument.newSimpleName(part);
                }
>>>>>>> FrontEnd is now independent about name conventions
            }
            i++;
        }
<<<<<<< HEAD
<<<<<<< HEAD
=======

        return values;
    }

    private static AMacroRef createMacroRef(
            AMacroReference macroReference){

        List<PValue> values = createValues(macroReference);
        TString macroRefName = new TString(macroReference.getName().getText());

        return new AMacroRef(macroRefName, values);
>>>>>>> ObjectMacro2 syntaxic/lexical/semantic analysis
=======
>>>>>>> New Intermediate Representation file generated 
    }
}
