# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.18.1)

# Declares and names the project.

project("lametest")

message("Begin...")

add_definitions("-DSTDC_HEADERS")

set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -Wall -O2 -U_FORTIFY_SOURCE -fstack-protector-all")
#set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11 -ffunction-sections -fdata-sections")

set(LAME_LIBMP3_DIR ${CMAKE_CURRENT_SOURCE_DIR}/lame_3.99.5)

message(${LAME_LIBMP3_DIR})

include_directories(${LAME_LIBMP3_DIR})

link_directories(${LAME_LIBMP3_DIR}/${CMAKE_ANDROID_ARCH_ABI}/lib)

set(LAME_SRC

        lame_3.99.5/bitstream.c
        lame_3.99.5/fft.c
        lame_3.99.5/id3tag.c
        lame_3.99.5/mpglib_interface.c
        lame_3.99.5/presets.c
        lame_3.99.5/quantize.c
        lame_3.99.5/reservoir.c
        lame_3.99.5/tables.c
        lame_3.99.5/util.c
        lame_3.99.5/VbrTag.c
        lame_3.99.5/encoder.c
        lame_3.99.5/gain_analysis.c
        lame_3.99.5/lame.c
        lame_3.99.5/newmdct.c
        lame_3.99.5/psymodel.c
        lame_3.99.5/quantize_pvt.c
        lame_3.99.5/set_get.c
        lame_3.99.5/takehiro.c
        lame_3.99.5/vbrquantize.c
        lame_3.99.5/version.c
        lame_util.c
        )

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

add_library( # Sets the name of the library.
        lametest

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        native-lib.cpp

        ${LAME_SRC}
        )

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
        lametest

        # Links the target library to the log library
        # included in the NDK.
        ${log-lib}
        EGL OpenSLES android mediandk
        )