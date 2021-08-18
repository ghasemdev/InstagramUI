package com.example.instagramui.ui.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.example.instagramui.ui.features.profile.GridScreen
import com.example.instagramui.ui.features.profile.IGTVScreen
import com.example.instagramui.utils.DRAWABLE

sealed class TabItem(
    @DrawableRes var icon: Int,
    var title: String,
    var screen: @Composable () -> Unit
) {
    @ExperimentalComposeUiApi
    object Grid : TabItem(DRAWABLE.ic_grid, "Grid", {
        GridScreen(
            listOf(
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.p1),
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.p2),
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.p3),
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.p4),
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.p5),
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.p6),
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.p7),
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.p8),
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.p9),
            )
        )
    })

    object IGTV : TabItem(DRAWABLE.ic_igtv, "IGTV", {
        IGTVScreen(
            listOf(
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.edsheeran),
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.ed2),
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.marsh),
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.khalid),
            )
        )
    })

    @ExperimentalComposeUiApi
    object Mention : TabItem(DRAWABLE.ic_mention, "Mention", {
        GridScreen(
            listOf(
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.adele),
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.billie),
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.bp),
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.camelia),
                Post(
                    userImage = DRAWABLE.avatar,
                    userId = "ghasem_79_",
                    post = DRAWABLE.dancemonkey
                ),
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.dualipa),
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.eminem),
                Post(
                    userImage = DRAWABLE.avatar,
                    userId = "ghasem_79_",
                    post = DRAWABLE.imagindragon
                ),
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.james),
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.katy),
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.lana),
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.marsh),
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.sam),
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.shawn),
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.weekend),
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.wolves),
            )
        )
    })
}