package com.vmos.pro.patches

import app.morphe.patcher.Patch
import app.morphe.patcher.patch.PatchResult
import app.morphe.patcher.patch.PatchWithFingerprint
import app.morphe.patcher.patch.Relevance

@PatchWithFingerprint(
    fingerprint = "Lcom/vmos/pro/model/VipModel;->isVip()Z",
    compatibility = Constants.COMPATIBILITY,
    description = "Always return true for isVip check",
    relevance = Relevance.HIGHEST
)
class VipUnlockPatch {
    fun patch(): PatchResult {
        // Override isVip() to always return true
        return modifyMethod {
            """
            .method public isVip()Z
               .registers 2
               const/4 v0, 0x1
               return v0
            .end method
            """.trimIndent()
        }.patch()
    }
}

@PatchWithFingerprint(
    fingerprint = "Lcom/vmos/pro/model/VipModel;->isForeverVip()Z",
    compatibility = Constants.COMPATIBILITY,
    description = "Always return true for isForeverVip check",
    relevance = Relevance.HIGHEST
)
class ForeverVipPatch {
    fun patch(): PatchResult {
        // Override isForeverVip() to always return true
        return modifyMethod {
            """
            .method public isForeverVip()Z
               .registers 2
               const/4 v0, 0x1
               return v0
            .end method
            """.trimIndent()
        }.patch()
    }
}

@PatchWithFingerprint(
    fingerprint = "Lcom/vmos/pro/utils/VipCheck;->checkVip()Z",
    compatibility = Constants.COMPATIBILITY,
    description = "Bypass VIP check in VipCheck",
    relevance = Relevance.HIGHEST
)
class VipCheckBypassPatch {
    fun patch(): PatchResult {
        // Override checkVip() to always return true
        return modifyMethod {
            """
            .method public checkVip()Z
               .registers 2
               const/4 v0, 0x1
               return v0
            .end method
            """.trimIndent()
        }.patch()
    }
}