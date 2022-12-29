package uz.digital.jetpackwallpaper.ui.view.bottom

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import uz.digital.jetpackwallpaper.R
import uz.digital.jetpackwallpaper.util.Graph

@Composable
fun HomeScreen(navHostController: NavHostController) {
    val list = mutableListOf<Int>()
    repeat(100) {
        list.add(it)
    }
    LazyColumn(
        modifier = Modifier.padding(bottom = 55.dp)
    ) {
        itemsIndexed(list) { index, item ->
            Item(int = index) {
                navHostController.navigate("${Graph.DETAILS}/$item")
            }
        }
    }
}

@Composable
fun Item(int: Int, onClick: (Int) -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(5.dp),
        elevation = 10.dp,
        backgroundColor = Color.Gray,
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clickable {
                    onClick(int)
                }
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Null",
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "$int",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}