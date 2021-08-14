package com.example.instagramui.ui.features.profile

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagramui.ui.common.NoRippleTab
import com.example.instagramui.ui.model.StoryHighlight
import com.example.instagramui.ui.model.TabItem
import com.example.instagramui.ui.theme.InstagramUITheme
import com.example.instagramui.utils.DRAWABLE
import com.example.instagramui.utils.asPainter
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch
import kpy.util.extension.ifNotNull

@ExperimentalPagerApi
@Composable
fun ProfileScreen() {
    val tabs = listOf(
        TabItem.Grid,
        TabItem.IGTV,
        TabItem.Mention
    )
    val pagerState = rememberPagerState(pageCount = tabs.size)

    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(name = "ghasem_79_")
        Spacer(modifier = Modifier.height(8.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(25.dp))
        HighlightSection(
            highlights = listOf(
                StoryHighlight(image = DRAWABLE.h1.asPainter(), title = "Projects"),
                StoryHighlight(image = DRAWABLE.h2.asPainter(), title = "Art"),
                StoryHighlight(image = DRAWABLE.h3.asPainter(), title = "My wOrDs"),
                StoryHighlight(image = DRAWABLE.h4.asPainter(), title = "Coffee"),
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        TabView(tabs = tabs, pagerState = pagerState)
        TabsContent(tabs = tabs, pagerState = pagerState)
    }
}

@Composable
private fun TopBar(
    name: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        IconButton(
            onClick = { Log.d("Profile", "TopBar: back") },
            modifier = Modifier.weight(0.17F)
        ) {
            Icon(
                painter = DRAWABLE.ic_back_arrow.asPainter(),
                contentDescription = "Back",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
        }
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black,
            maxLines = 1,
            modifier = Modifier
                .padding(start = 4.dp, end = 16.dp)
                .weight(0.58F)
        )
        IconButton(
            onClick = { Log.d("Profile", "TopBar: bell") },
            modifier = Modifier.weight(0.08F)
        ) {
            Icon(
                painter = DRAWABLE.ic_bell.asPainter(),
                contentDescription = "Bell",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
        }
        IconButton(
            onClick = { Log.d("Profile", "TopBar: menu") },
            modifier = Modifier.weight(0.17F)
        ) {
            Icon(
                painter = DRAWABLE.ic_dotmenu.asPainter(),
                contentDescription = "Menu",
                tint = Color.Black,
                modifier = Modifier.size(18.dp)
            )
        }
    }
}

@Composable
private fun ProfileSection(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
        ) {
            RoundImage(
                image = DRAWABLE.avatar.asPainter(),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3F)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7F))
        }
        Spacer(modifier = Modifier.height(12.dp))
        ProfileDescription(
            displayName = "ghasem",
            description = "UB \uD83D\uDCBB\uD83D\uDCF1\n" +
                    "My favorites \uD83C\uDFA5\uD83D\uDCD6\uD83C\uDFA8\n" +
                    "If they treat you like one of their choices, make them one of your memories.",
            followedBy = listOf("hassan__rouhani"),
            otherCount = 26
        )
    }
}

@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1F, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
}

@Composable
private fun StatSection(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStat(value = "9", title = "Posts")
        ProfileStat(value = "349", title = "Followers")
        ProfileStat(value = "303", title = "Following")
    }
}

@Composable
private fun ProfileStat(
    value: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = value,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}

@Composable
private fun ProfileDescription(
    displayName: String,
    description: String,
    followedBy: List<String>,
    otherCount: Int
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Text(
            text = displayName,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            color = Color.Black,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight,
            textAlign = TextAlign.Justify
        )
        Text(
            text = "See Translation",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        if (followedBy.isNotEmpty()) {
            Text(
                color = Color.Black,
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                    )
                    append("Followed by ")
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1) {
                            append(", ")
                        }
                    }
                    if (otherCount > 2) {
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }
}

@Composable
private fun ButtonSection(modifier: Modifier = Modifier) {
    val height = 35.dp
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        ActionButton(
            text = "Following",
            textColor = Color(0xFF14B31B),
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .weight(1F)
                .height(height = height)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .padding(start = 8.dp)
                .weight(1F)
                .height(height = height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .padding(start = 8.dp)
                .height(height = height)
        )
    }
}

@Composable
private fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    textColor: Color = Color.Black,
    icon: ImageVector? = null
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {
        text.ifNotNull {
            Text(
                text = it,
                color = textColor,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        icon.ifNotNull {
            Icon(
                imageVector = it,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}

@Composable
private fun HighlightSection(
    modifier: Modifier = Modifier,
    highlights: List<StoryHighlight>
) {
    LazyRow(modifier = modifier) {
        items(highlights.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(
                    start = 15.dp,
                    end = if (it == highlights.size - 1) 15.dp else 0.dp
                )
            ) {
                RoundImage(
                    image = highlights[it].image,
                    modifier = Modifier.size(70.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = highlights[it].title,
                    color = Color.Black,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@ExperimentalPagerApi
@Composable
private fun TabView(tabs: List<TabItem>, pagerState: PagerState) {
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
private fun TabsContent(tabs: List<TabItem>, pagerState: PagerState) {
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