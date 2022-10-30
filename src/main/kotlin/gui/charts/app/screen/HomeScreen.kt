package gui.charts.app.screen

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import gui.charts.app.Screen
import gui.charts.app.ScreenRouter
import gui.charts.app.theme.Margins
import gui.charts.app.theme.Purple500

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created at 2022/3/10 21:05
 * @Version 1.0
 * @Description TO-DO
 */

@Composable
fun HomeScreen() {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Compose Charts") }, backgroundColor = Purple500)
    }) {
        HomeScreenContent()
    }
}

@Composable
private fun HomeScreenContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ChartScreenSelector(text = "Pie Chart", nextScreen = Screen.Pie)
        ChartScreenSelector(text = "Line Chart", nextScreen = Screen.Line)
        ChartScreenSelector(text = "Bar Chart", nextScreen = Screen.Bar)
    }
}

@Composable
private fun ChartScreenSelector(text: String, nextScreen: Screen) {
    Row(modifier = Modifier.padding(horizontal = Margins.horizontal, vertical = Margins.vertical)) {
        TextButton(onClick = { ScreenRouter.navigate(nextScreen) }) {
            Text(text = text)
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() = HomeScreen()