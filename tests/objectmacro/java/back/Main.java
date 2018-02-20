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
import java.util.ArrayList;
import java.util.List;

=======
>>>>>>> Add back end tests
=======
import java.util.ArrayList;
import java.util.List;

>>>>>>> Update tests to be adapted to the lazy initialization
public class Main {

    public static void main(
            String[] args){

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        System.out.print("======== Main Test ===========\n");
        MA ma = new MA("First argument of MA");
        List<Macro> macros = new ArrayList<>();
        MB mb = new MB("la");
        MB mb2 = new MB("First argument in MB0");
        macros.add(mb2);
        macros.add(new MB("First argument in MB1"));
        macros.add(new MB("First argument in MB2"));

        try{
            mb.addS(new MC());
            ma.addZ(new MC());
            ma.addAllY(macros);
            ma.addY(mb);
            ma.addZ(new MC());
            mb2.addS(new MC());
=======
        Macro[] macros = new Macro[3];
        macros[0] = new MB("First argument in MB0");
        macros[1] = new MB("First argument in MB1");
        macros[2] = new MB("First argument in MB2");

        Macro[] macros1 = new Macro[2];
        macros1[0] = new MC();
        macros1[1] = new MC();

        try{
            MA ma = new MA("First argument of MA", macros, macros1);
            macros[0] = new  MC();
>>>>>>> Add back end tests
=======
=======
        System.out.print("======== Main Test ===========\n");
>>>>>>> Add test for dynamic cyclic reference verification
        MA ma = new MA("First argument of MA");
        List<Macro> macros = new ArrayList<>();
        MB mb = new MB("la");
        MB mb2 = new MB("First argument in MB0");
        macros.add(mb2);
        macros.add(new MB("First argument in MB1"));
        macros.add(new MB("First argument in MB2"));

        try{
            mb.addPS(new MC());
            ma.addPZ(new MC());
            ma.addAllPY(macros);
            ma.addPY(mb);
            ma.addPZ(new MC());
<<<<<<< HEAD
<<<<<<< HEAD
            ma.setPY(macros);
>>>>>>> Update tests to be adapted to the lazy initialization
=======
>>>>>>> Add test for dynamic cyclic reference verification
=======
            mb2.addPS(new MC());
>>>>>>> Add BuildState class in order to do a cheap cycle verification on build method
            System.out.println(ma.build());
        }
        catch(ObjectMacroException e){
            System.err.println(e.getMessage());
            System.err.println("It should not throw an exception");
            System.exit(1);
        }
    }
}
