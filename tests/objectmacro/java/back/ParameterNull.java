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
package back;

import back.macro.*;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

=======
>>>>>>> Add back end tests
=======
import java.util.ArrayList;
import java.util.List;

>>>>>>> Update tests to be adapted to the lazy initialization
=======
>>>>>>> Changement Objectmacro-back
=======
import java.util.ArrayList;
import java.util.List;

>>>>>>> Revert "Changement Objectmacro-back"
public class ParameterNull {

    public static void main(
            String[] args){

        System.out.println("---------- Parameter null ----------");
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Update tests to be adapted to the lazy initialization
        MA ma = new MA("First argument of MA");
<<<<<<< HEAD
=======
        MA ma = new MA("First argument of MA");
>>>>>>> Revert "Changement Objectmacro-back"
        List<Macro> macros = new ArrayList<>();
        macros.add(new MB("First argument in MB0"));
        macros.add(new MB("First argument in MB1"));
        macros.add(new MB("First argument in MB2"));
<<<<<<< HEAD
<<<<<<< HEAD

        try{
            ma.addZ(null);
            ma.addAllY(macros);
=======
=======
>>>>>>> Changement Objectmacro-back
        Macro[] macros = new Macro[3];
        macros[0] = new MB("First argument in MB0");
        macros[1] = new MB("First argument in MB1");
        macros[2] = new MB("First argument in MB2");
<<<<<<< HEAD

        try{
            MA ma = new MA("First argument of MA", macros, null);
>>>>>>> Add back end tests
=======

        try{
<<<<<<< HEAD
            ma.addPZ(null);
<<<<<<< HEAD
            ma.setPY(macros);
>>>>>>> Update tests to be adapted to the lazy initialization
=======
            ma.addAllPY(macros);
>>>>>>> Add test for dynamic cyclic reference verification
=======
            ma.addZ(null);
            ma.addAllY(macros);
>>>>>>> Removed letter P from add and addAll methods name
=======

        try{
            MA ma = new MA("First argument of MA", macros, null);
>>>>>>> Changement Objectmacro-back
=======

        try{
            ma.addZ(null);
            ma.addAllY(macros);
>>>>>>> Revert "Changement Objectmacro-back"
            ma.build();
=======

        try{
            ma.addZ(null);
>>>>>>> Removed add all function to keep only the static overload
            System.err.println("It should throw an exception here");
            System.exit(1);
        }
        catch(ObjectMacroException e){
            System.out.println(e.getMessage());
        }
    }
}
