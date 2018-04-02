<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Update tests to be adapted to the lazy initialization
=======
>>>>>>> Revert "Changement Objectmacro-back"
=======
>>>>>>> object-macro2.1
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
<<<<<<< HEAD
=======
>>>>>>> Changement Objectmacro-back
=======
>>>>>>> Revert "Changement Objectmacro-back"
=======
>>>>>>> object-macro2.1
package entity;

import entity.macro.*;

import java.io.File;
import java.io.FileWriter;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import java.util.ArrayList;
=======
=======
>>>>>>> Update tests to be adapted to the lazy initialization
package entity;

import entity.macro.*;

import java.io.File;
import java.io.FileWriter;
<<<<<<< HEAD
import java.io.IOException;
>>>>>>> Add refused, accepted tests
=======
import java.util.ArrayList;
>>>>>>> Update tests to be adapted to the lazy initialization
=======
import java.io.IOException;
>>>>>>> Changement Objectmacro-back
=======
import java.util.ArrayList;
>>>>>>> Revert "Changement Objectmacro-back"
=======
import java.util.ArrayList;
>>>>>>> object-macro2.1

public class Main {

    public static void main(
            String[] args){

        MEntity entity = createEntity("Person");
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> moved jpa_entity test
=======
>>>>>>> object-macro2.1
        File entities_directory = new File("tests/objectmacro/java/entities");
        if(!entities_directory.exists()){
            entities_directory.mkdir();
        }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Add script to run jpa entity test
=======
>>>>>>> object-macro2.1
        File directory = new File("tests/objectmacro/java/entities");
        if(!directory.exists()){
            directory.mkdir();
        }

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Add refused, accepted tests
=======
>>>>>>> moved jpa_entity test
=======
>>>>>>> Add script to run jpa entity test
=======
>>>>>>> object-macro2.1
        File destination = new File("tests/objectmacro/java/entities", "Person.java");
        writeFile(destination, entity.build());
        entity = createEntity("Book");
        destination = new File("tests/objectmacro/java/entities", "Book.java");
        writeFile(destination, entity.build());
    }

    private static void writeFile(
            File destination, String content){

        try {
            FileWriter fw = new FileWriter(destination);
            fw.write(content);
            fw.close();
        }
        catch (Exception e) {
            System.out.print(e.getMessage());
            System.exit(0);
        }
    }

    private static MEntity createEntity(
            String entity_name){

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> object-macro2.1
        MEntity mEntity = new MEntity(entity_name);
        mEntity.addPackage(new MPackageDeclaration("entities"));
        MSetter setter = new MSetter("id_" + entity_name.toLowerCase(), Integer.class.getSimpleName());
        MGetter getter = new MGetter("id_" + entity_name.toLowerCase(), Integer.class.getSimpleName());

        mEntity.addAttributes(createId("id_" + entity_name.toLowerCase(), "AUTO"));
        mEntity.addAccessors(setter);
        mEntity.addAccessors(getter);

        mEntity.addAttributes(createAttribute("A", Integer.class.getSimpleName(), false));
        setter = new MSetter("A", Integer.class.getSimpleName());
        getter = new MGetter("A", Integer.class.getSimpleName());
        mEntity.addAccessors(setter);
        mEntity.addAccessors(getter);

        mEntity.addAttributes(createAttribute("B", String.class.getSimpleName(), true));
        setter = new MSetter("B", String.class.getSimpleName());
        getter = new MGetter("B", String.class.getSimpleName());
        mEntity.addAccessors(setter);
        mEntity.addAccessors(getter);

        return mEntity;
<<<<<<< HEAD
=======
=======
>>>>>>> Changement Objectmacro-back
        MPackageDeclaration mPackageDeclaration = new MPackageDeclaration("entities");
        MAttribute[] attributes = new MAttribute[3];
        Macro[] accessors = new Macro[6];

        attributes[0] = createId("id_" + entity_name.toLowerCase(), "AUTO");
<<<<<<< HEAD
=======
        MEntity mEntity = new MEntity(entity_name);
<<<<<<< HEAD
        mEntity.addPPackage(new MPackageDeclaration("entities"));
>>>>>>> Update tests to be adapted to the lazy initialization
=======
        mEntity.addPackage(new MPackageDeclaration("entities"));
>>>>>>> Removed letter P from add and addAll methods name
=======
>>>>>>> Changement Objectmacro-back
=======
        MEntity mEntity = new MEntity(entity_name);
        mEntity.addPackage(new MPackageDeclaration("entities"));
>>>>>>> Revert "Changement Objectmacro-back"
        MSetter setter = new MSetter("id_" + entity_name.toLowerCase(), Integer.class.getSimpleName());
        MGetter getter = new MGetter("id_" + entity_name.toLowerCase(), Integer.class.getSimpleName());

        mEntity.addAttributes(createId("id_" + entity_name.toLowerCase(), "AUTO"));
        mEntity.addAccessors(setter);
        mEntity.addAccessors(getter);

        mEntity.addAttributes(createAttribute("A", Integer.class.getSimpleName(), false));
        setter = new MSetter("A", Integer.class.getSimpleName());
        getter = new MGetter("A", Integer.class.getSimpleName());
        mEntity.addAccessors(setter);
        mEntity.addAccessors(getter);

        mEntity.addAttributes(createAttribute("B", String.class.getSimpleName(), true));
        setter = new MSetter("B", String.class.getSimpleName());
        getter = new MGetter("B", String.class.getSimpleName());
        mEntity.addAccessors(setter);
        mEntity.addAccessors(getter);

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        mEntity.setPRelationships(new ArrayList<>());

<<<<<<< HEAD
        return new MEntity(entity_name, new MPackageDeclaration[]{mPackageDeclaration}, attributes, new MRelationship[0], accessors);
>>>>>>> Add refused, accepted tests
=======
=======
>>>>>>> Remove public to prevent user to access to supermacro attributes
        return mEntity;
>>>>>>> Update tests to be adapted to the lazy initialization
=======
        return new MEntity(entity_name, new MPackageDeclaration[]{mPackageDeclaration}, attributes, new MRelationship[0], accessors);
>>>>>>> Changement Objectmacro-back
=======
        return mEntity;
>>>>>>> Revert "Changement Objectmacro-back"
=======
>>>>>>> object-macro2.1
    }

    private static MAttribute createId(
            String name,
            String generation_strategy){

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        MAttribute mAttribute = new MAttribute(name, "Integer");
=======
>>>>>>> Add refused, accepted tests
=======
        MAttribute mAttribute = new MAttribute(name, "Integer");
>>>>>>> Update tests to be adapted to the lazy initialization
=======
>>>>>>> Changement Objectmacro-back
=======
        MAttribute mAttribute = new MAttribute(name, "Integer");
>>>>>>> Revert "Changement Objectmacro-back"
=======
        MAttribute mAttribute = new MAttribute(name, "Integer");
>>>>>>> object-macro2.1
        MPrimaryKey mPrimaryKey = new MPrimaryKey();
        MIdIncrementationStrategy mIdIncrementationStrategy = null;
        if(!generation_strategy.equals("")){
            mIdIncrementationStrategy = new MIdIncrementationStrategy(generation_strategy);
        }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> object-macro2.1
        mAttribute.addNotNull(new MNotNull());

        if (mIdIncrementationStrategy == null) {
            mAttribute.addId(mPrimaryKey);
        }
        else{
            mAttribute.addId(mPrimaryKey);
            mAttribute.addId(mIdIncrementationStrategy);
        }

        return mAttribute;
<<<<<<< HEAD
=======
        Macro[] id_related;
=======
        mAttribute.addPNotNull(new MNotNull());
=======
        mAttribute.addNotNull(new MNotNull());
>>>>>>> Removed letter P from add and addAll methods name

>>>>>>> Update tests to be adapted to the lazy initialization
=======
        Macro[] id_related;
>>>>>>> Changement Objectmacro-back
=======
        mAttribute.addNotNull(new MNotNull());

>>>>>>> Revert "Changement Objectmacro-back"
        if (mIdIncrementationStrategy == null) {
            mAttribute.addId(mPrimaryKey);
        }
        else{
            mAttribute.addId(mPrimaryKey);
            mAttribute.addId(mIdIncrementationStrategy);
        }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        return new MAttribute(name, "Integer", id_related, new Macro[0]);
>>>>>>> Add refused, accepted tests
=======
        return mAttribute;
>>>>>>> Update tests to be adapted to the lazy initialization
=======
        return new MAttribute(name, "Integer", id_related, new Macro[0]);
>>>>>>> Changement Objectmacro-back
=======
        return mAttribute;
>>>>>>> Revert "Changement Objectmacro-back"
=======
>>>>>>> object-macro2.1
    }

    private static MAttribute createAttribute(
            String name,
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> object-macro2.1
            String type,
            boolean notNull){

        MAttribute mAttribute = new MAttribute(name, type);
        if(notNull) {
            mAttribute.addNotNull(new MNotNull());
        }

        return mAttribute;
<<<<<<< HEAD
=======
            String type){
=======
            String type,
            boolean notNull){
>>>>>>> Update tests to be adapted to the lazy initialization
=======
            String type){
>>>>>>> Changement Objectmacro-back
=======
            String type,
            boolean notNull){
>>>>>>> Revert "Changement Objectmacro-back"

        MAttribute mAttribute = new MAttribute(name, type);
        if(notNull) {
            mAttribute.addNotNull(new MNotNull());
        }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        return new MAttribute(name, type, new Macro[0], new Macro[]{new MNotNull()});
>>>>>>> Add refused, accepted tests
=======
        mAttribute.setPId(new ArrayList<>());
=======
>>>>>>> Remove public to prevent user to access to supermacro attributes
        return mAttribute;
>>>>>>> Update tests to be adapted to the lazy initialization
=======
        return new MAttribute(name, type, new Macro[0], new Macro[]{new MNotNull()});
>>>>>>> Changement Objectmacro-back
=======
        return mAttribute;
>>>>>>> Revert "Changement Objectmacro-back"
=======
>>>>>>> object-macro2.1
    }

}
