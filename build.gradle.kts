plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}
android {
    namespace = "com.assistantmunna.ai"
    compileSdk = 35
    defaultConfig {
        applicationId = "com.assistantmunna.ai"
        minSdk = 23
        targetSdk = 35
        versionCode = 17
        versionName = "17.0"
    }
}
