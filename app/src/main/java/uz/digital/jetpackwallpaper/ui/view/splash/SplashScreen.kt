package uz.digital.jetpackwallpaper.ui.view.splash

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.digital.jetpackwallpaper.R
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import uz.digital.jetpackwallpaper.ui.theme.Purple40
import uz.digital.jetpackwallpaper.util.Graph

@Composable
fun SplashScreen(navHostController: NavHostController) {
    var startAnimation by remember {
        mutableStateOf(false)
    }
    val color by animateColorAsState(targetValue = Color.Green)
    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(1200L)
//        navHostController.popBackStack()
        navHostController.navigate(Graph.MAIN) {
            launchSingleTop = true
            popUpTo(Graph.SPLASH)
        }
    }
    Splash(color)
}

@Composable
fun Splash(color: Color) {
    Box(
        modifier = Modifier
            .background(color)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(200.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = stringResource(id = R.string.jetpack),
                fontSize = 25.sp,
                color = Purple40,
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Italic
            )
        }
    }
}