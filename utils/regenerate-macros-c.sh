#!/usr/bin/env bash

rm -f src/org/sablecc/objectmacro/codegeneration/c/macro/*.java

java -jar lib/objectmacro.jar -d intermediate/ macros/objectmacro2-c.objectmacro
java -jar lib/objectmacro-back.jar -d src -p org.sablecc.objectmacro.codegeneration.c.macro intermediate/objectmacro2-c.intermediate

ant -f ant-files/
