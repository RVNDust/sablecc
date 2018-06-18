/* This file was generated by SableCC's ObjectMacro. */


package org.sablecc.objectmacro.codegeneration.c.macro;

public class ObjectMacroException
        extends RuntimeException{

    private ObjectMacroException(
            String message){

        super(message);

        if(message == null){
            throw new RuntimeException("message may not be null");
        }
    }

    private ObjectMacroException(
            String message,
            Throwable cause) {

        super(message, cause);

        if (message == null) {
            throw new RuntimeException("message may not be null");
        }

        if (cause == null) {
            throw new RuntimeException("cause may not be null");
        }
    }

    static ObjectMacroException incorrectType(
            String type,
            String param_name){


        return new ObjectMacroException(
                new MIncorrectType(type, param_name).toString());
    }

    static ObjectMacroException macroNull(
            Integer index,
            String paramName){

        return new ObjectMacroException(
                new MMacroNullInList(String.valueOf(index), paramName).toString());
    }

    static ObjectMacroException parameterNull(
            String paramName){

        return new ObjectMacroException(new MParameterNull(paramName).toString());
    }

    static ObjectMacroException cyclicReference(
            String macroName){

        return new ObjectMacroException(new MCyclicReference(macroName).toString());
    }

    static ObjectMacroException cannotModify(
            String macroName){

        return new ObjectMacroException(new MCannotModify(macroName).toString());
    }

}