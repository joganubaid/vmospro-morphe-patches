package com.vmos.pro.patches

import app.morphe.patcher.patch.PatchWithFingerprint
import app.morphe.patcher.patch.PatchResult
import app.morphe.patcher.patch.Relevance
import app.morphe.patcher.patch.replaceClass

@PatchWithFingerprint(
    fingerprint = "Lcom/vmos/pro/account/AccountHelper;->isVipVM()Z",
    compatibility = Constants.COMPATIBILITY,
    description = "Always return true for isVipVM check",
    relevance = Relevance.HIGHEST
)
class VipVMPatch {
    fun patch(): PatchResult {
        return replaceClass {
            """
            .class public Lcom/vmos/pro/account/AccountHelper;
            .super Ljava/lang/Object;
            .source ""
            
            .method public isVipVM()Z
               .registers 2
               const/4 v0, 0x1
               return v0
            .end method
            """.trimIndent()
        }.patch()
    }
}

@PatchWithFingerprint(
    fingerprint = "Lcom/vmos/mvplibrary/BaseAct;->isVipAct()Z",
    compatibility = Constants.COMPATIBILITY,
    description = "Always return true for isVipAct check",
    relevance = Relevance.HIGHEST
)
class VipActPatch {
    fun patch(): PatchResult {
        return replaceClass {
            """
            .class public Lcom/vmos/mvplibrary/BaseAct;
            .super Ljava/lang/Object;
            
            .method public isVipAct()Z
               .registers 2
               const/4 v0, 0x1
               return v0
            .end method
            """.trimIndent()
        }.patch()
    }
}