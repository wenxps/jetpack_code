// 统一配置一些共用参数
plugins {
    kotlin("android")
    kotlin("parcelize")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(30)
    buildToolsVersion = "30.0.2"

    defaultConfig {
        minSdkVersion(23)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        // Java配置方式: room 的scheme文件生成位置配置，便于查看数据库创建表的详细信息; ARouter的配置
        javaCompileOptions {
            annotationProcessorOptions {
                // room 的scheme文件生成位置配置
                arguments.put("room.schemaLocation", "$projectDir/schemas".toString())

                // ARouter的配置
                arguments.put("AROUTER_MODULE_NAME", project.name)
            }
        }

        // Kotlin配置方式: room 的scheme文件生成位置配置  ;   ARouter 的配置
        kapt {
            arguments {
                arg("AROUTER_MODULE_NAME", project.name)
                arg("room.schemaLocation", "$projectDir/schemas".toString())
            }
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    // AS4 以上版本使用这个配置dataBinding
    buildFeatures {
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    // 使用jetpack的组件，会要求jdk 1.8最好，有的时候会遇到报错，需要配置如下，避免target jvm 1.8的那个报错
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs += listOf("-Xopt-in=kotlin.RequiresOptIn") // 添加@OptIn(ExperimentalContracts::class) 注解参数
    }
}

dependencies {
    implementation(fileTree(mapOf("include" to listOf("*.jar"), "dir" to "libs")))

    // 平台相关的基础库
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0-native-mt")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.3")
    implementation("androidx.appcompat:appcompat:1.3.0-alpha02")
    implementation("androidx.core:core-ktx:1.5.0")
    implementation("androidx.fragment:fragment-ktx:1.3.0")
    implementation("androidx.activity:activity-ktx:1.2.0")
    implementation("androidx.activity:activity-ktx:1.2.0")
    implementation("com.google.android.material:material:1.3.0-beta01")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.recyclerview:recyclerview:1.2.0-beta01")

    // Jetpack libs
    implementation("androidx.lifecycle:lifecycle-livedata:2.3.0-rc01")
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.3.0")
    implementation("androidx.lifecycle:lifecycle-runtime:2.3.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.0-rc01")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.0")
    kapt("androidx.lifecycle:lifecycle-common-java8:2.3.0-rc01")

    implementation("androidx.room:room-runtime:2.3.0-alpha04")
    implementation("androidx.room:room-common:2.3.0-alpha04")
    implementation("androidx.room:room-ktx:2.3.0-alpha04")
    kapt("androidx.room:room-compiler:2.3.0-alpha04")

    implementation("androidx.paging:paging-runtime:3.0.0-alpha11")
    implementation("androidx.paging:paging-runtime-ktx:3.0.0-alpha11")
    implementation("androidx.paging:paging-common:3.0.0-alpha11")
    implementation("androidx.paging:paging-common-ktx:3.0.0-alpha11")

    implementation("androidx.work:work-runtime:2.5.0")
    implementation("androidx.work:work-runtime-ktx:2.5.0")

    // Navigation
    implementation("androidx.navigation:navigation-ui:$navigation_version")
    implementation("androidx.navigation:navigation-ui-ktx:$navigation_version")
    implementation("androidx.navigation:navigation-fragment:$navigation_version")
    implementation("androidx.navigation:navigation-fragment-ktx:$navigation_version")
    implementation("androidx.navigation:navigation-runtime:$navigation_version")

    // ARouter
    implementation("com.alibaba:arouter-api:1.5.0")
    kapt("com.alibaba:arouter-compiler:1.5.2")

    // LiveData EventBus
    implementation("io.github.jeremyliao:live-event-bus-x:1.8.0")

    // Test libs
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit-ktx:1.1.2")
    androidTestImplementation("androidx.test:core:1.3.0")
    androidTestImplementation("androidx.test:core-ktx:1.3.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")

    // Koin for AndroidX
    implementation("org.koin:koin-core:$koin_version")
    implementation("org.koin:koin-core-ext:$koin_version")
    implementation("org.koin:koin-androidx-scope:$koin_version")
    implementation("org.koin:koin-androidx-viewmodel:$koin_version")
    implementation("org.koin:koin-androidx-fragment:$koin_version")
    implementation("org.koin:koin-androidx-ext:$koin_version")
    testImplementation("org.koin:koin-test:$koin_version")
}
