plugins {
//    id("java-library")
    id("com.android.library")
//    id("org.jetbrains.kotlin.jvm")
//    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = "com.code.common"
    compileSdk = 34
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    // from dependencies.gradle

    //region http
    api("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.google.code.gson:gson:2.10")
    api("com.blankj:utilcodex:1.30.6")


//    implementation("androidx.work:work-runtime:2.9.0")
//    implementation("androidx.work:work-runtime-ktx:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
    implementation("androidx.collection:collection-jvm:1.4.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    //endregion

    //Androidx Jetpack最新的startUp组件
//    api("androidx.startup:startup-runtime:1.1.1")



    //glide
//    api("com.github.bumptech.glide:glide:4.11.0")
//    kapt("com.github.bumptech.glide:compiler:4.11.0")

    //coil
//    implementation("io.coil-kt:coil:0.13.0")

    //腾讯的key-value
//    implementation("com.tencent:mmkv-static:1.2.1")

//    implementation("com.just.agentweb:agentweb-androidx:4.1.4") // (必选)
//    implementation 'com.just.agentweb:filechooser-androidx:4.1.4'// (可选)
//    implementation 'com.download.library:downloader-androidx:4.1.4'// (可选)

}