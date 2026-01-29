plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    kotlin("plugin.serialization") version "2.0.0"
    id("kotlin-parcelize")
}

android {
    namespace = "com.journey.heroDad"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.journey.herodad"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures{
        buildConfig = true
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            isShrinkResources = false
            isDebuggable = true

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    flavorDimensions += "environment"

    productFlavors {
        create("qa") {
            dimension = "environment"
            applicationIdSuffix = ".staging"
            applicationId = "com.journey.herodad.qa"
            resValue("string", "app_name", "Hero Dad (QA)")
            buildConfigField("String", "API_BASE_URL", "\"https://dummyjson.com/\"")
        }

        create("uat") {
            dimension = "environment"
            applicationIdSuffix = ".preprod"
            applicationId = "com.journey.herodad.uat"
            resValue("string", "app_name", "Hero Dad (UAT)")
            buildConfigField("String", "API_BASE_URL", "\"https://dummyjson.com/\"")
        }

        create("prod") {
            dimension = "environment"
            applicationId = "com.journey.herodad"
            resValue("string", "app_name", "Hero Dad")
            buildConfigField("String", "API_BASE_URL", "\"https://dummyjson.com/\"")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.gson)
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    //Image loading dependencies
    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)

    // Kotlin Serialization (Essential for Nav3 Routes)
    implementation(libs.kotlinx.serialization.json)

    // Navigation 3 (The New Stack Management)
    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.navigation3.ui)

    //Koin- dependency injection
    implementation(project.dependencies.platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(libs.koin.android)

    //Koin- Jetpack Compose
    implementation(libs.koin.androidx.compose)
    implementation(libs.koin.compose.navigation3)
    implementation(libs.koin.androidx.compose)

    implementation(libs.com.squareup.retrofit2.retrofit)
    implementation(libs.com.squareup.retrofit2.converter.gson)

    //DataStore
    implementation(libs.androidx.datastore.preferences)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}