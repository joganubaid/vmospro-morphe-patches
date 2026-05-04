package com.vmos.pro.patches

import app.morphe.patcher.patch.ApkFileType
import app.morphe.patcher.patch.AppTarget
import app.morphe.patcher.patch.Compatibility

object Constants {
    const val APP_PACKAGE = "com.vmos.pro"
    const val APP_VERSION = "3.8.2"

    val COMPATIBILITY = Compatibility(
        name = "VMOS Pro",
        packageName = APP_PACKAGE,
        apkFileType = ApkFileType.APK_REQUIRED,
        appIconColor = "#4CAF50",
        signatures = setOf("placeholder"),
        targets = listOf(
            AppTarget(
                version = "3.8.2",
                minSdk = 21
            )
        )
    )
}