package com.vmos.pro.patches

import app.morphe.patcher.Patch
import app.morphe.patcher.patch.PatchResult
import app.morphe.patcher.patch.PatchWithFingerprint
import app.morphe.patcher.patch.Relevance

@PatchWithFingerprint(
    fingerprint = "Lcom/vmos/pro/account/AccountHelper;->isVipVM()Z",
    compatibility = Constants.COMPATIBILITY,
    description = "Always return true for isVipVM check - unlocks VIP VM features",
    relevance = Relevance.HIGHEST
)
class VipVMPatch {
    fun patch(): PatchResult {
        return modifyMethod {
            """
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
    description = "Always return true for isVipAct check - unlocks VIP activity features",
    relevance = Relevance.HIGHEST
)
class VipActPatch {
    fun patch(): PatchResult {
        return modifyMethod {
            """
            .method public isVipAct()Z
               .registers 2
               const/4 v0, 0x1
               return v0
            .end method
            """.trimIndent()
        }.patch()
    }
}

@PatchWithFingerprint(
    fingerprint = "Lcom/vmos/pro/bean/UserBean;->getVipGradeType()Ljava/lang/String;",
    compatibility = Constants.COMPATIBILITY,
    description = "Return VIP grade type to unlock VIP features",
    relevance = Relevance.HIGHEST
)
class VipGradePatch {
    fun patch(): PatchResult {
        return modifyMethod {
            """
            .method public getVipGradeType()Ljava/lang/String;
               .registers 2
               const-string v0, "svip"
               return-object v0
            .end method
            """.trimIndent()
        }.patch()
    }
}