#include <jni.h>
#include <string>

#ifdef __cplusplus
extern "C"
{
#include "lame.h"
#endif
JNIEXPORT jstring JNICALL
Java_com_xyd_lametest_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

JNIEXPORT jstring JNICALL
Java_com_xyd_lametest_MainActivity_getLameVersion(
        JNIEnv* env,
jobject /* this */) {
    std::string hello = "Hello from Lame";
    return env->NewStringUTF(get_lame_version());
}
#ifdef __cplusplus
}
#endif