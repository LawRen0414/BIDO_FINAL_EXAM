package com.example.affirmations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation
import com.example.affirmations.ui.theme.AffirmationsTheme


//MARK LAWRENCE BIDO
//BSIT 22A3


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    login()
                }
            }
            loginbutton(onClick = {})
        }
    }
}

@Composable
fun login(){
    Column {
        Text(
            text = "LOG IN",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 280.dp)
                .padding(horizontal = 20.dp)
        )
        Text(
            text = "EMAIL:",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 10.dp)
                .padding(horizontal = 20.dp)
        )
        inputemail(
            modifier = Modifier
                .padding(top = 10.dp)
                .padding(horizontal = 20.dp)
                .fillMaxWidth())

        Text(
            text = "PASSWORD:",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 10.dp)
                .padding(horizontal = 20.dp)
        )
        inputpassword(modifier = Modifier
            .padding(top = 5.dp)
            .padding(horizontal = 20.dp)
            .fillMaxWidth())

    }
}

@Composable
fun inputemail(modifier: Modifier = Modifier) {
    var textInput by remember { mutableStateOf("") }

    TextField(
        value = textInput,
        onValueChange = {textInput = it},
        singleLine = true,
        label = { Text(stringResource(R.string.label)) },
        modifier = modifier
    )
}

@Composable
fun inputpassword(modifier: Modifier = Modifier) {
    var textInputt by remember { mutableStateOf("") }

    TextField(
        value = textInputt,
        onValueChange = {textInputt = it},
        singleLine = true,
        label = { Text(stringResource(R.string.label2)) },
        modifier = modifier
    )
}

@Composable
fun loginbutton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(0) }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 430.dp)
            .padding(horizontal = 155.dp)
            .size(200.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Button(onClick = { result = 1 }) {
            Text("Login")
        }
    }

    Column{
        if (result == 1){
            logincomplete()
        }
    }

}

@Composable
fun logincomplete() {
    var resultt by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color(255, 255, 255),

                ),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),


            ) {

            if (resultt == 3){
                AffirmationsTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        AffirmationsApp()
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.star_check),
                    contentDescription = null,
                    modifier = Modifier
                        .width(500.dp)
                        .height(500.dp)
                )
                Text(
                    text ="You have log in successfully",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(top = 1.dp, bottom = 10.dp)
                )
                Text(
                    text = "Welcome back, user!",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(top = 1.dp, bottom = 40.dp)
                )

                Button(onClick = {resultt = 3}) {
                    Text("to Home page")

                }

            }

        }

    }


}

@Composable
fun AffirmationsApp() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.fp_bgg),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = "Welcome to FitPicks Store!",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 10.dp)
                .padding(horizontal = 30.dp)
        )
        Text(
            text = "Where Fashion Dreams Come True",
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 2.dp)
                .padding(horizontal = 100.dp)
        )

    }
    Column {
        AffirmationList(
            affirmationList = Datasource().loadAffirmations(),
            modifier = Modifier
                .padding(top = 180.dp)
                .padding(bottom = 10.dp)
                .fillMaxSize()
        )
    }
}


@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(affirmationList) { affirmation ->
            AffirmationCard(
                affirmation = affirmation,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize()
            )
        }
    }
}

@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(affirmation.imageResourceId),
                contentDescription = stringResource(affirmation.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(affirmation.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}



