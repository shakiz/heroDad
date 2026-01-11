package com.journey.heroDad.utils.components.widget

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ChartPoint(
    val label: String,
    val value: Float
)

@Composable
fun AppLineChartWidget(
    modifier: Modifier = Modifier,
    points: List<ChartPoint>,
    title: String = "Movement Trends",
    mainValue: String = "~12 kicks",
    changeText: String = "+2% vs last week",
) {
    if (points.size < 2) return

    val maxValue = points.maxOf { it.value }.takeIf { it > 0f } ?: 1f

    val animationProgress = remember { Animatable(0f) }

    LaunchedEffect(points) {
        animationProgress.snapTo(0f)
        animationProgress.animateTo(
            1f,
            tween(1200, easing = FastOutSlowInEasing)
        )
    }

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(20.dp),
        color = Color(0xFF162330),
        border = BorderStroke(1.dp, Color(0xFF223347)),
        tonalElevation = 0.dp
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 16.dp)) {
            // Title
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.onPrimary)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Stats row
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = mainValue,
                    style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.onPrimary)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = changeText,
                    color = Color(0xFF4CAF50),
                    fontSize = 16.sp
                )
            }

            Canvas(
                modifier = modifier
                    .fillMaxWidth()
                    .height(160.dp)
            ) {
                val spacing = size.width / (points.size - 1)
                val chartHeight = size.height * 0.85f

                fun y(value: Float): Float =
                    size.height - (value / maxValue) * chartHeight

                val linePath = Path()
                val fillPath = Path()

                points.forEachIndexed { index, point ->
                    val x = spacing * index
                    val y = y(point.value)

                    if (index == 0) {
                        linePath.moveTo(x, y)
                        fillPath.moveTo(x, size.height)
                        fillPath.lineTo(x, y)
                    } else {
                        val prevX = spacing * (index - 1)
                        val prevY = y(points[index - 1].value)
                        val controlX = (prevX + x) / 2f

                        linePath.cubicTo(
                            controlX, prevY,
                            controlX, y,
                            x, y
                        )

                        fillPath.cubicTo(
                            controlX, prevY,
                            controlX, y,
                            x, y
                        )
                    }
                }

                fillPath.lineTo(size.width, size.height)
                fillPath.close()

                val clipWidth = size.width * animationProgress.value

                clipRect(right = clipWidth) {

                    drawPath(
                        fillPath,
                        brush = Brush.verticalGradient(
                            listOf(
                                Color(0xFF3B82F6).copy(alpha = 0.35f),
                                Color.Transparent
                            )
                        )
                    )

                    drawPath(
                        linePath,
                        color = Color(0xFF3B82F6),
                        alpha = 0.25f,
                        style = Stroke(8f, cap = StrokeCap.Round, join = StrokeJoin.Round)
                    )

                    drawPath(
                        linePath,
                        brush = Brush.horizontalGradient(
                            listOf(Color(0xFF60A5FA), Color(0xFF3B82F6))
                        ),
                        style = Stroke(4f, cap = StrokeCap.Round, join = StrokeJoin.Round)
                    )
                }

                points.forEachIndexed { index, point ->
                    val x = spacing * index
                    drawCircle(
                        color = Color(0xFF93C5FD),
                        radius = 6f,
                        center = Offset(x, y(point.value)),
                        alpha = animationProgress.value
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                points.forEach {
                    Text(
                        text = it.label,
                        color = Color(0xFF7C8CA1),
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}
