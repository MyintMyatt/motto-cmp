import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.orion.motto_cmp.common.components.app.TextHeadLine
import com.orion.motto_cmp.navigation.Screen


@Composable
fun HiraganaScreen(
    navController: NavController
){
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
        ) {

            // header bar
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
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
                        Icons.Default.ChevronLeft,
                        contentDescription = "back icon",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                Spacer(modifier = Modifier.width(15.dp))
                TextHeadLine("Hiragana & Katakana")
            }

            // body content
            KanjiAppDemo()
        }
    }
}


// 1. Data Model: Represents a single stroke of the Kanji
data class KanjiStroke(
    val pathData: String
)

@Composable
fun AnimatedKanji(
    strokes: List<KanjiStroke>,
    modifier: Modifier = Modifier
) {
    // 2. State to control the animation progress (0f to 1f)
    // We want to animate through ALL strokes sequentially.
    // If we have 3 strokes, 0.0-0.33 is stroke 1, 0.33-0.66 is stroke 2, etc.
    val totalStrokes = strokes.size
    val transition = rememberInfiniteTransition()

    // Animate from 0 to totalStrokes (e.g., 0.0f -> 5.0f for 5 strokes)
    // This allows us to know exactly which stroke is currently "writing"
    val progress by transition.animateFloat(
        initialValue = 0f,
        targetValue = totalStrokes.toFloat() + 1f, // +1 for a pause at the end
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = totalStrokes * 600, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    // Cache the parsed paths so we don't re-parse every frame
    val parsedPaths = remember(strokes) {
        strokes.map {
            PathParser().parsePathString(it.pathData).toPath()
        }
    }

    // 3. The Canvas
    Canvas(modifier = modifier) {
        // KanjiVG data is usually 109x109. We scale it to fit our Canvas.
        val scaleX = size.width / 109f
        val scaleY = size.height / 109f

        scale(scaleX, scaleY, pivot = androidx.compose.ui.geometry.Offset.Zero) {

            // Draw a guide (faint gray full character)
            parsedPaths.forEach { path ->
                drawPath(
                    path = path,
                    color = Color.LightGray.copy(alpha = 0.3f),
                    style = Stroke(width = 3f, cap = StrokeCap.Round, join = StrokeJoin.Round)
                )
            }

            // Draw the animated strokes
            parsedPaths.forEachIndexed { index, path ->
                if (progress >= index + 1) {
                    // This stroke is fully finished
                    drawPath(
                        path = path,
                        color = Color.Black,
                        style = Stroke(width = 3f, cap = StrokeCap.Round, join = StrokeJoin.Round)
                    )
                } else if (progress > index) {
                    // This stroke is currently being written
                    val strokeProgress = progress - index // 0.0 to 1.0 for this specific stroke

                    // Use PathMeasure to get a segment of the path
                    val measure = PathMeasure()
                    measure.setPath(path, false)

                    val length = measure.length
                    val partialPath = Path()
                    measure.getSegment(0f, length * strokeProgress, partialPath, true)

                    drawPath(
                        path = partialPath,
                        color = Color.Black,
                        style = Stroke(width = 3f, cap = StrokeCap.Round, join = StrokeJoin.Round)
                    )
                }
            }
        }
    }
}

// Usage Example
@Composable
fun KanjiAppDemo() {
    // Example Data: Kanji for "Tree" (木) - U+6728
    // Data from KanjiVG
    val treeKanji = listOf(
        KanjiStroke("M29.5,23 c2.12,0.62,5.1,0.67,7.38,0.44 c10.32-1.04,26.68-3.05,38.99-4.06 c2.08-0.17,3.62,0.1,5.62,0.56"), // Horizontal
        KanjiStroke("M53,10.75 c1.5,0.75,2.75,2.75,2.75,4.75 c0,12.5,0,67.75-0.25,80.75"), // Vertical
        KanjiStroke("M54.5,44 c-6.6,12.01-22.33,29.98-35.75,37.25"), // Left diagonal
        KanjiStroke("M57,44.75 c6.42,7.7,21.94,22.28,29.83,27.17 c2.44,1.52,4.18,2.44,6.42,2.83")  // Right diagonal
    )

    AnimatedKanji(
        strokes = treeKanji,
        modifier = Modifier.size(300.dp)
    )
}