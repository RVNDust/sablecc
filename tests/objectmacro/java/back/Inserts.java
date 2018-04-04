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

public class Inserts {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Add inserts test in back-tests
=======
>>>>>>> Revert "Changement Objectmacro-back"
    public static void main(
            String[] args){

        System.out.print("======== Inserts Test ===========\n");
<<<<<<< HEAD
<<<<<<< HEAD
        Macro d = new MD();
        System.out.println(d.build());
=======
    public static void main(String[] args){
        Macro d = new MD();
        d.build();
>>>>>>> Add back end tests
=======
        Macro d = new MD();
        System.out.println(d.build());
>>>>>>> Add inserts test in back-tests
=======
    public static void main(String[] args){
        Macro d = new MD();
        d.build();
>>>>>>> Changement Objectmacro-back
=======
        Macro d = new MD();
        System.out.println(d.build());
>>>>>>> Revert "Changement Objectmacro-back"
    }

}
