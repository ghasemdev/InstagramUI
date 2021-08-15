package com.example.instagramui.ui.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.example.instagramui.ui.features.profile.GridScreen
import com.example.instagramui.ui.features.profile.IGTVScreen
import com.example.instagramui.ui.features.profile.MentionScreen
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
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.p1),
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.p2),
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.p3),
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.p4),
            )
        )
    })

    @ExperimentalComposeUiApi
    object Mention : TabItem(DRAWABLE.ic_mention, "Mention", {
        MentionScreen(
            listOf(
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.p1),
                Post(userImage = DRAWABLE.avatar, userId = "ghasem_79_", post = DRAWABLE.p2),
            )
        )
    })
}