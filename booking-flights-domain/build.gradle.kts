plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    id("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {

//    implementation(libs.dagger)
//    kapt(libs.dagger.compiler)
    implementation("com.google.dagger:dagger:2.53")
    kapt("com.google.dagger:dagger-compiler:2.53")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")

}