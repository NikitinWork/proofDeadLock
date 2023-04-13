#include <jni.h>
#include "libshared_api.h"




extern "C" JNIEXPORT void JNICALL
Java_com_example_proofdeadlock_android_NdkWrapper_deadlock(
        JNIEnv *env,
        jobject) {

    libshared_ExportedSymbols *symbols = libshared_symbols();

    symbols->kotlin.root.com.android.kotlin.android.deadlock();
}

extern "C" JNIEXPORT void JNICALL
Java_com_example_proofdeadlock_android_NdkWrapper_normalWork(
        JNIEnv *env,
        jobject) {

    libshared_ExportedSymbols *symbols = libshared_symbols();

    symbols->kotlin.root.com.android.kotlin.android.normalWork();
}


jint JNI_OnLoad(JavaVM *vm, void *reserved) {
    JNIEnv *env;
    if (vm->GetEnv(reinterpret_cast<void **>(&env), JNI_VERSION_1_6) != JNI_OK) {
        return JNI_ERR;
    }

    //libshared_ExportedSymbols *symbols = libshared_symbols();

    //symbols->kotlin.root.com.android.kotlin.android.deadlock();

    return JNI_VERSION_1_6;
}