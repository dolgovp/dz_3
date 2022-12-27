package com.example.dz_3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
@Preview
@Composable
fun Profile(){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.fragment_background))
            .padding(
                bottom=40.dp
            )
    ) {
        item {
            AsyncImage(
                modifier = Modifier
                    .height(400.dp)
                    .fillMaxWidth(),
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data("https://pitbiker.ru/wa-data/public/photos/64/00/64/64.970.jpg")
                    .build(),
                error = painterResource(R.drawable.ic_baseline_sports_motorsports_24),
                placeholder = painterResource(R.drawable.ic_baseline_sports_motorsports_24),
                contentDescription = "f",
                contentScale = ContentScale.Crop,
            )
        }

        item{
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .background(colorResource(id = R.color.fragment_background))
            ) {
                Text("О себе",
                    modifier = Modifier
                        .padding(
                            top = 16.dp,
                            bottom = 12.dp
                        ),
                    fontSize = 18.sp,
                    color = colorResource(R.color.text_main)
                )
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(2.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(2.dp)
                    ) {
                        Text("Телефон",
                                modifier = Modifier
                                .padding(2.dp),
                            fontSize = 12.sp,
                            color = colorResource(id = R.color.text_main)
                        )
                        Text("89038031274")
                    }
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(2.dp)
                ) {
                    Column(modifier = Modifier
                        .padding(2.dp)
                    ) {
                        Text("Телефон",
                            modifier = Modifier
                                .padding(2.dp),
                            fontSize = 12.sp,
                            color = colorResource(id = R.color.text_main)
                        )
                        Text("89038031274")
                    }
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(2.dp)
                ) {
                    Column(modifier = Modifier
                        .padding(2.dp)
                    ) {
                        Text("Телефон",
                            modifier = Modifier
                                .padding(2.dp),
                            fontSize = 12.sp,
                            color = colorResource(id = R.color.text_main)
                        )
                        Text("89038031274")
                    }
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(2.dp)
                ) {
                    Column(modifier = Modifier
                        .padding(2.dp)
                    ) {
                        Text("Телефон",
                            modifier = Modifier
                                .padding(2.dp),
                            fontSize = 12.sp,
                            color = colorResource(id = R.color.text_main)
                        )
                        Text("89038031274")
                    }
                }
                Text("Мои соцсети",
                    modifier = Modifier
                        .padding(
                            top = 16.dp,
                            bottom = 12.dp
                        ),
                    fontSize = 18.sp,
                    color = colorResource(R.color.text_main)
                )
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                ) {
                    Column(modifier = Modifier
                        .padding(2.dp)
                    ) {
                        Text("Телефон",
                            modifier = Modifier
                                .padding(2.dp),
                            fontSize = 12.sp,
                            color = colorResource(id = R.color.text_main)
                        )
                        Text("89038031274")
                    }
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(2.dp)
                ) {
                    Column(modifier = Modifier
                        .padding(2.dp)
                    ) {
                        Text("Телефон",
                            modifier = Modifier
                                .padding(2.dp),
                            fontSize = 12.sp,
                            color = colorResource(id = R.color.text_main)
                        )
                        Text("89038031274")
                    }
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(2.dp)
                ) {
                    Column(modifier = Modifier
                        .padding(2.dp)
                    ) {
                        Text("Телефон",
                            modifier = Modifier
                                .padding(2.dp),
                            fontSize = 12.sp,
                            color = colorResource(id = R.color.text_main)
                        )
                        Text("89038031274")
                    }
                }
            }
        }
        
    }
}
