// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false

    // ToDo: Add the following line to enable the Google DevTools KSP plugin
    alias(libs.plugins.googleDevtoolsKsp) apply false
}