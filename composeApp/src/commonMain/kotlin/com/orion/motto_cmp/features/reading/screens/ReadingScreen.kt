package com.orion.motto_cmp.features.reading.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.orion.motto_cmp.common.components.app.TextHeadLine
import com.orion.motto_cmp.common.components.app.TextTitle
import com.orion.motto_cmp.common.util.WindowSize
import com.orion.motto_cmp.common.util.rememberWindowSize
import com.orion.motto_cmp.features.reading.components.FabMenu
import com.orion.motto_cmp.features.reading.model.ReadingPageModuleList
import com.orion.motto_cmp.navigation.Screen
import org.jetbrains.compose.resources.painterResource

@Composable
fun ReadingScreen(
    navController: NavController,
    isDarkTheme : Boolean = false
) {

    var screenSize by remember { mutableStateOf(IntSize.Zero) }
    var windowSize = rememberWindowSize(with(LocalDensity.current) { screenSize.width.toDp() })


    Box (
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()/*.background(Color.Red)*/,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        navController.navigate(Screen.Home)
                    }, colors = IconButtonDefaults.iconButtonColors(
                        MaterialTheme.colorScheme.primary.copy(
                            alpha = .05f
                        )
                    )
                ) {
                    Icon(
                        Icons.Default.ChevronLeft, contentDescription = "back icon", tint = MaterialTheme.colorScheme.primary
                    )
                }
                Spacer(modifier = Modifier.width(15.dp))
                TextHeadLine("Reading Modules")
            }

            LazyVerticalGrid(
                columns = if (windowSize == WindowSize.Expanded) GridCells.Fixed(3) else GridCells.Adaptive(minSize = 350.dp),
                contentPadding = PaddingValues(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ){
                itemsIndexed(
                    items = ReadingPageModuleList,
                    key = { _, module -> module.title}
                ){ index, module ->
                    OutlinedCard (
                        onClick = {}
                    ){
                        Column(
                            modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp),
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Image(
                                    painter = if (!isDarkTheme)painterResource(module.imgBlack!!) else painterResource( module.img),
                                    contentDescription = null,
                                    modifier = Modifier.size(26.dp)
                                )
                                IconButton(onClick = { }) {
                                    Icon(
                                        imageVector = Icons.Default.ChevronRight,
                                        contentDescription = "KeyboardArrowRight"
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(12.dp))
                            TextTitle(title = module.title)
                            Text(
                                text = module.desc,
                                fontSize = 13.sp
                            )
                        }
                    }
                }
            }
        }
        // Place the FAB manually or pass it to MainLayout
        FabMenu(
            windowSize = windowSize,
            modifier = Modifier
                .align(Alignment.BottomEnd)
//                .padding(/*bottom = 80.dp,*/ end = 16.dp)
        )
    }
}