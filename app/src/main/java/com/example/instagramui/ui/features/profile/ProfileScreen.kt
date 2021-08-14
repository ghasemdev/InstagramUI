package com.example.instagramui.ui.features.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.instagramui.ui.common.NoRippleTab
import com.example.instagramui.ui.model.TabItem
import com.example.instagramui.ui.theme.InstagramUITheme
import com.example.instagramui.utils.asPainter
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun ProfileScreen() {
    val tabs = listOf(
        TabItem.Grid,
        TabItem.IGTV,
        TabItem.Mention
    )
    val pagerState = rememberPagerState(pageCount = tabs.size)
    Column {
        Tabs(tabs = tabs, pagerState = pagerState)
        TabsContent(tabs = tabs, pagerState = pagerState)
    }
}

@ExperimentalPagerApi
@Composable
fun Tabs(tabs: List<TabItem>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    val inactiveColor = Color(0xFF777777)
    val activeColor = MaterialTheme.colors.onBackground

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.Transparent,
        contentColor = activeColor,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.pagerTabIndicatorOffset(
                    pagerState = pagerState,
                    tabPositions = tabPositions
                )
            )
        }
    ) {
        tabs.forEachIndexed { index, tab ->
            NoRippleTab(
                selected = pagerState.currentPage == index,
                selectedContentColor = activeColor,
                unselectedContentColor = inactiveColor,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            ) {
                Icon(
                    painter = tab.icon.asPainter(),
                    contentDescription = tab.title,
                    tint = if (pagerState.currentPage == index) activeColor else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(22.dp)
                )
            }
        }
    }
}

@ExperimentalPagerApi
@Composable
fun TabsContent(tabs: List<TabItem>, pagerState: PagerState) {
    HorizontalPager(state = pagerState) { page ->
        tabs[page].screen()
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    InstagramUITheme {
        ProfileScreen()
    }
}