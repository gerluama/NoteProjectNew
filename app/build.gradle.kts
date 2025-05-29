

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.noteprojectnew"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.noteprojectnew"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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



    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.room.common.jvm)
    implementation(libs.androidx.room.runtime.android)
    implementation(libs.androidx.runtime.livedata)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.3")

    //implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    //implementation ("androidx.room:room-ktx:2.5.2")
    //implementation ("androidx.navigation:navigation-compose:2.7.0")

    // Material Design 3
    //implementation ("androidx.compose.material3:material3:1.1.1")
    //implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    //implementation(platform("androidx.compose:compose-bom:2023.08.00")) // Проверьте последнюю версию на https://developer.android.com/jetpack/compose/bom

    //ds
    //implementation("androidx.compose.material3:material3")
    //implementation ("androidx.core:core-ktx:1.12.0")
    //implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    //implementation ("androidx.activity:activity-compose:1.8.0")

    // Compose
    //implementation (platform("androidx.compose:compose-bom:2023.10.01"))
    //implementation ("androidx.compose.ui:ui")
   // implementation ("androidx.compose.ui:ui-graphics")
    //implementation ("androidx.compose.ui:ui-tooling-preview")
    //implementation ("androidx.compose.material3:material3")

    // ViewModel
    //implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")

    // Для иконок
    //implementation ("androidx.compose.material:material-icons-extended:1.5.4")

    implementation ("androidx.core:core-ktx:1.12.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation ("androidx.activity:activity-compose:1.8.0")

    // Compose
    implementation (platform("androidx.compose:compose-bom:2023.10.01"))
    implementation ("androidx.compose.ui:ui")
    implementation ("androidx.compose.ui:ui-graphics")
    implementation ("androidx.compose.ui:ui-tooling-preview")
    implementation ("androidx.compose.material3:material3")



    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
}
