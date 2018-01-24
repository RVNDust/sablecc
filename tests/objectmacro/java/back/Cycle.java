<<<<<<< HEAD
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

=======
>>>>>>> Add test for dynamic cyclic reference verification
package back;

import back.macro.*;

<<<<<<< HEAD
=======
/**
 * Created by lam on 24/01/18.
 */
>>>>>>> Add test for dynamic cyclic reference verification
public class Cycle {

    public static void main(String args[]){

        System.out.print("---------- Cyclic Reference ----------\n");
        MF f = new MF();
        MG g = new MG();
        MH h = new MH();
<<<<<<< HEAD
        f.addY(h);
        f.addX(g);
        f.addX(g);
        h.addLala(f);
=======
        f.addPY(h);
        f.addPX(g);
        f.addPX(g);
        h.addPLala(f);
>>>>>>> Add test for dynamic cyclic reference verification

        try{
            System.out.print(f.build());
            System.err.println("It should throw an exception here");
            System.exit(1);
        }catch(ObjectMacroException e){
            System.out.println(e.getMessage());
        }
    }
}
