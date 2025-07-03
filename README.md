# FursatiCMP

[![Android CI](https://github.com/MohannedSohail/FursatiCMP_CI-CD/actions/workflows/android-ci.yml/badge.svg)](https://github.com/MohannedSohail/FursatiCMP_CI-CD/actions/workflows/android-ci.yml)
[![Firebase Distribution](https://img.shields.io/badge/Release-Firebase-orange?logo=firebase)](https://console.firebase.google.com/)
[![Kotlin Multiplatform](https://img.shields.io/badge/Kotlin-Multiplatform-blueviolet?logo=kotlin)](https://kotlinlang.org/lp/multiplatform/)
[![Compose Multiplatform](https://img.shields.io/badge/JetBrains-Compose%20Multiplatform-brightgreen?logo=jetbrains)](https://www.jetbrains.com/lp/compose-multiplatform/)
![Platform](https://img.shields.io/badge/platform-Android%20%7C%20iOS%20%7C%20Desktop-blue?logo=android)


This is a Kotlin Multiplatform project targeting Android, iOS, Desktop.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…
