/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.c.macro;

abstract class Directive {

    final String value;

    Directive(
            String value) {

        this.value = value;
    }

    abstract String apply(Integer index, String macro, Integer list_size);
}