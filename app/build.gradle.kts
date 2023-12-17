plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("kotlin-parcelize")
}

apply{
    from("../shared_dependencies.gradle")
}
android {
    namespace = "com.example.androidexpert"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.androidexpert"
        minSdk = 24
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
        viewBinding{
            enable = true
        }
    dynamicFeatures += setOf(":favorite")
}

dependencies {

    implementation (project(":core"))
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.9.0")

//    implementation("androidx.core:core-ktx:1.9.0")
//    implementation("androidx.appcompat:appcompat:1.6.1")
//    implementation("com.google.android.material:material:1.10.0")
//    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
//    testImplementation("junit:junit:4.13.2")
//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
//
//
//    implementation("com.github.bumptech.glide:glide:4.15.1")
//    implementation("com.squareup.retrofit2:retrofit:2.9.0")
//    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
//    implementation ("com.squareup.okhttp3:okhttp:5.0.0-alpha.11")
//    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.11")
//
//    implementation ("androidx.room:room-ktx:2.6.1")
//    ksp("androidx.room:room-compiler:2.6.1")
//    implementation ("io.insert-koin:koin-android:3.3.3")
//
//    implementation ("androidx.activity:activity-ktx:1.7.0")
//    implementation ("androidx.fragment:fragment-ktx:1.5.6")
//    implementation ("androidx.navigation:navigation-fragment-ktx:2.5.3")
//    implementation ("androidx.navigation:navigation-ui-ktx:2.5.3")
//
//    //coroutine support
//    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
//    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
//    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.6.4")
//
//    //coroutines
//    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
//    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
//    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.6.4")
}