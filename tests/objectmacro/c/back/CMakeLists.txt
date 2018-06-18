cmake_minimum_required(VERSION 3.6)   # CMake version check
project(test_composers)               # Create project "simple_example"
set(CMAKE_CXX_STANDARD 11)            # Enable c++11 standard

set(SOURCE_FILES macro/MAuthor.c macro/MDetail.c macro/MFinalOutput.c macro/Stringbuilder.c macro/LinkedList.c macro/LinkedListNode.c macro/Context.c composers.c)            # Add main.cpp file of project root directory as source file
add_executable(test_composers ${SOURCE_FILES})       # Add executable target with source files listed in SOURCE_FILES variable

set(SOURCE_FILES2 macro/MA.c macro/MB.c macro/MC.c macro/MSemicolonSeparator.c macro/MEmptyMacro.c macro/MCommaSeparator.c macro/Stringbuilder.c macro/LinkedList.c macro/LinkedListNode.c macro/Map.c macro/Context.c macro/InternalsInitializer.c internals.c)            # Add main.cpp file of project root directory as source file
add_executable(test_internals ${SOURCE_FILES2})       # Add executable target with source files listed in SOURCE_FILES variable