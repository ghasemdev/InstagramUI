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
    object Grid : TabItem(DRAWABLE.ic_grid, "Grid", { GridScreen() })
    object IGTV : TabItem(DRAWABLE.ic_igtv, "IGTV", { IGTVScreen() })
    object Mention : TabItem(DRAWABLE.ic_mention, "Mention", { MentionScreen() })
}