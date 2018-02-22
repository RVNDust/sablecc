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
<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> Add back end tests
=======

>>>>>>> Update tests to be adapted to the lazy initialization
package back;

import back.macro.MCommaSeparator;
import back.macro.MEmptyMacro;
import back.macro.Macro;

public class Separator {

    public static void main(
                String[] args){

        MEmptyMacro mEmptyMacro = new MEmptyMacro();
<<<<<<< HEAD
<<<<<<< HEAD
        MCommaSeparator mCommaSeparator = new MCommaSeparator();
        mCommaSeparator.addX(mEmptyMacro);
        mCommaSeparator.addX(mEmptyMacro);
        mCommaSeparator.addX(mEmptyMacro);
=======
        MCommaSeparator mCommaSeparator = new MCommaSeparator(new Macro[]{mEmptyMacro, mEmptyMacro, mEmptyMacro});

>>>>>>> Add back end tests
=======
        MCommaSeparator mCommaSeparator = new MCommaSeparator();
<<<<<<< HEAD
        mCommaSeparator.addPX(mEmptyMacro);
        mCommaSeparator.addPX(mEmptyMacro);
        mCommaSeparator.addPX(mEmptyMacro);
>>>>>>> Update tests to be adapted to the lazy initialization
=======
        mCommaSeparator.addX(mEmptyMacro);
        mCommaSeparator.addX(mEmptyMacro);
        mCommaSeparator.addX(mEmptyMacro);
>>>>>>> Removed letter P from add and addAll methods name
        System.out.println(mCommaSeparator.build());
    }

}
