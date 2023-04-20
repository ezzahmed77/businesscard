package com.example.businesscard


import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscard.ui.theme.BusinessCardTheme


@Composable
fun BusinessCard() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(bottom = 24.dp),
    ) {
        BasicCardInfo(
            modifier = Modifier.align(Alignment.Center),
            imgSrc = R.drawable.personal_photo,
            name = stringResource(id = R.string.name),
            title = stringResource(id = R.string.title)
        )
        ContactInfo(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun BasicCardInfo(
    modifier: Modifier = Modifier,
    @DrawableRes imgSrc: Int,
    name: String,
    title: String
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = painterResource(id = imgSrc),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(shape = CircleShape)
                .width(120.dp)
                .height(120.dp)

        )
        Text(
            text = name,
            style = MaterialTheme.typography.h5,
            color = Color.White
        )
        Text(
            text = title,
            style = MaterialTheme.typography.body1,
            color = Color.Green
        )
    }
}

@Composable
fun ContactInfo(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        ContactInfoItem(imgSrc = Icons.Default.Phone, content = stringResource(id = R.string.number))
        ContactInfoItem(imgSrc = Icons.Default.Email, content = stringResource(id = R.string.email))
        ContactInfoItem(imgSrc = Icons.Default.AccountBox, content = stringResource(id = R.string.linkedin))
    }
}

@Composable
fun ContactInfoItem(
    modifier: Modifier = Modifier,
    imgSrc: Any,
    content: String
) {
    Column {
        Divider(modifier = Modifier
            .height(1.5.dp)
            .background(color = Color.Gray))
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 8.dp, start = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = imgSrc as ImageVector,
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 24.dp),
                tint = Color.Cyan
            )

            Text(
                text = content,
                color = Color.White
            )
        }
    }
}

@Composable
@Preview
fun BusinessCardPreview(){
    BusinessCardTheme() {
        BusinessCard()
    }
}