plugins {
    id(PlugIn.APPLICATION)
    id(PlugIn.ANDROID)
    id(PlugIn.KAPT)
    id(PlugIn.HILT)
}

android {
    namespace= AppConfig.NAMESPACE
    compileSdk = AppConfig.COMPILE_SDK

    defaultConfig {
        applicationId = "com.example.appfeature"
        minSdk = AppConfig.MIN_SDK
        targetSdk = AppConfig.TARGET_SDK
        versionCode = AppConfig.VERSION_CODE
        versionName = AppConfig.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    kapt {
        correctErrorTypes = true
    }
    dataBinding {
        enable = true
    }
}

dependencies {
    implementation(project(mapOf("path" to ":data")))

    implementation(Library.KTX)
    implementation(Library.ACTIVITY_KTX)
    implementation(Library.FRAGMENT_KTX)
    implementation(Library.APP_COMPAT)
    implementation(Library.MATERIAL)
    implementation(Library.CONSTRAINT_LAYOUT)
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