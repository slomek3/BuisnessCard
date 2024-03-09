package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun LogoSection(name: String, title: String, modifier: Modifier = Modifier){
val image = painterResource(id = R.drawable.foto_slomski_michal)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()

        ) {
        Image(
            painter = image,
            contentDescription = "Michal_Slomski_photo",
            alignment = Alignment.TopCenter,
            modifier = modifier.height(290.dp)
        )
        Text(
            text = name,
            fontSize = 30.sp,

        )
        Text(
            text = title,
            fontSize = 20.sp,
            )


    }
}
@Composable
fun ContactSection(
        phone: String,
        social: String,
        email: String,
        modifier: Modifier = Modifier
) {
    val phoneIcon = painterResource(R.drawable.phone_icon)
    val socialIcon = painterResource(R.drawable.linkedin_icon)
    val emailIcon = painterResource(id = R.drawable.email_icon)
    Column(
        modifier = modifier
            .padding(start = 16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        )
    {
        Row(

            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Image(
                painter = phoneIcon,
                contentDescription = "phone_icon",
                modifier = modifier.height(50.dp)


                )
            Text(
                text = phone,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(horizontal = 8.dp),
            )
        }
        Row() {
            Image(
                painter = socialIcon,
                contentDescription = "social_Icon",
                modifier = modifier.height(50.dp)
                )
            Text(
                text = social,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(horizontal = 8.dp),
                )
        }
        Row() {
            Image(
                painter = emailIcon,
                contentDescription = "email_Icon",
                modifier = modifier.height(50.dp)
                )
            Text(
                text = email,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(horizontal = 8.dp),
                )
        }

    }
}

@Composable
fun BusinessCardApp(){
    Column(
        Modifier.padding(16.dp)
    ) {
        Spacer(Modifier.weight(0.1f))
        Row(

            modifier = Modifier.weight(0.3f)
        ) {
            LogoSection(name = "Michal Slomski", title = "Fachinformatiker")

        }
        Spacer(Modifier.weight(0.05f))
        Row(


            modifier = Modifier.weight(0.2f)

        ){
            ContactSection(
                phone = stringResource(R.string.phone_number),
                social = stringResource(R.string.linkedIn_address),
                email = stringResource(R.string.email_address)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardApp()
}