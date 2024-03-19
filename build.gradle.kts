// Top-level build file where you can add configuration options common to all sub-projects/modules.
// 在 build.gradle.kts 文件的顶部导入 dependencies.gradle.kts 文件
//apply(from = "dependencies.gradle.kts.kts")
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
//    id("androidx.navigation.safeargs.kotlin") version "1.9.22" apply false
//    kotlin("android")
//    kotlin("parcelize") version "1.8.22" apply false
    kotlin("kapt") version "1.9.22" apply false
    id("org.jetbrains.kotlin.jvm") version "1.9.22" apply false
}