#!/usr/bin/env bash

set -e

mkdir -p tests/objectmacro/common/intermediate

java -jar lib/objectmacro.jar -d tests/objectmacro/common/intermediate/ tests/objectmacro/common/back-tests/back.objectmacro

rm -f test/objectmacro/c/back/macro/*.c
rm -f test/objectmacro/c/back/macro/*.h

java -jar lib/objectmacro-back.jar -t=c -d tests/objectmacro/c -p back.macro tests/objectmacro/common/intermediate/back.intermediate

#TODO Ajouter compilation du fichier de test C  + Test