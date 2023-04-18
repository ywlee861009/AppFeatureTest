plugins {
    id(PlugIn.LIBRARY)
    id(PlugIn.ANDROID)
    id(PlugIn.KAPT)
}

android {
    namespace = AppConfig.NAMESPACE + ".data"
    compileSdk = AppConfig.COMPILE_SDK

    defaultConfig {
        minSdk = AppConfig.MIN_SDK
        targetSdk = AppConfig.TARGET_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    testImplementation(Library.J_UNIT)
    androidTestImplementation(Library.J_UNIT_EXT)
    androidTestImplementation(Library.ESPRESSO_CORE)

    implementation(Library.RETROFIT)
    implementation(Library.CONVERTOR_GSON)
    implementation(Library.LOGGING_INTERCEPTOR)

    implementation(Library.HILT_ANDROID)
    kapt(Library.HILT_COMPILER)
    kapt(Library.HILT_COMPILER_ANDROID_X)
}