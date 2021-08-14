package com.example.instagramui.ui.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import com.example.instagramui.ui.features.profile.GridScreen
import com.example.instagramui.ui.features.profile.IGTVScreen
import com.example.instagramui.ui.features.profile.MentionScreen
import com.example.instagramui.utils.DRAWABLE

sealed class TabItem(
    @DrawableRes var icon: Int,
    var title: String,
    var screen: @Composable () -> Unit
) {
    object Grid : TabItem(DRAWABLE.ic_grid, "Grid", {
        GridScreen(
            listOf(
                DRAWABLE.p1,
                DRAWABLE.p2,
                DRAWABLE.p3,
                DRAWABLE.p4,
                DRAWABLE.p5,
                DRAWABLE.p6,
                DRAWABLE.p7,
                DRAWABLE.p8,
                DRAWABLE.p9,
            )
        )
    })

    object IGTV : TabItem(DRAWABLE.ic_igtv, "IGTV", {
        IGTVScreen(
            listOf(
                DRAWABLE.p1,
                DRAWABLE.p2,
                DRAWABLE.p3,
                DRAWABLE.p4,
            )
        )
    })

    object Mention : TabItem(DRAWABLE.ic_mention, "Mention", {
        MentionScreen(
            listOf(
                DRAWABLE.p1,
                DRAWABLE.p2,
            )
        )
    })
}