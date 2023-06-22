package gui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun CroppingRectangle(
    dx: MutableState<Double>,
    dy: MutableState<Double>,
    dx2: MutableState<Double>,
    dy2: MutableState<Double>
) {
    val constant = with(LocalDensity.current) { 1.dp.toPx() }

    Box {
        Divider(
            color = Color.Blue,
            thickness = 2.dp,
            modifier = Modifier
                .width(5.dp)
                .height(5.dp)
                .offset {
                    IntOffset(
                        (constant * 20).roundToInt() + (dx.value / constant).roundToInt(),
                        (constant * 20).roundToInt() + (dy.value / constant).roundToInt()
                    )
                }
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        dx.value += constant * dragAmount.x
                        dy.value += constant * dragAmount.y
                    }
                }
        )

        Divider(
            color = Color.Blue,
            modifier = Modifier
                .height(5.dp)
                .width(5.dp)
                .offset {
                    IntOffset(
                        (constant * 20).roundToInt() + (dx2.value / constant).roundToInt(),
                        (constant * 20).roundToInt() + (dy2.value / constant).roundToInt()
                    )
                }
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        dx2.value += constant * dragAmount.x
                        dy2.value += constant * dragAmount.y
                    }
                }
        )

        Canvas(modifier = Modifier.fillMaxSize()) {
            drawRect(
                color = Color.Red,
                style = Stroke(5f),
                topLeft = Offset(
                    x = (constant * 20).roundToInt() + dx.value.toFloat() / constant,
                    y = (constant * 20).roundToInt() + dy.value.toFloat() / constant
                ),
                size = Size(
                    dx2.value.toFloat() / constant - dx.value.toFloat() / constant,
                    dy2.value.toFloat() / constant - dy.value.toFloat() / constant
                )
            )
        }
    }
}
