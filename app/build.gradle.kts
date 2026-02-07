plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.spotless)
}

android {
    namespace = "com.example.travelblog"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.travelblog"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.glide)
    implementation(libs.gson)
    implementation(libs.okhttp)
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}

// Add the Spotless configuration
spotless {
    // Configure formatting for Kotlin files
    kotlin {
        // Apply the ktlint formatting rule.
        // The version should be a recent one from ktlint.
        ktlint("0.50.0")
        target("**/*.kt")
        targetExclude("**/build/**/*.kt")
    }
    // Configure formatting for Gradle build scripts
    kotlinGradle {
        target("*.gradle.kts")
        // Use a standard Kotlin code style for Gradle files
        ktlint("0.50.0")
    }
    java {
        target("**/*.java")
        targetExclude("**/build/**/*.java")
        // Use Google's Java formatter
        googleJavaFormat()
    }
}
