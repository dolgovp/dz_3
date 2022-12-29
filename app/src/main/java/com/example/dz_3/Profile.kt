package com.example.dz_3

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.dz_3.data.User

@Composable
fun Profile(viewModel: ProfileViewModel){
    val userState = viewModel.state.collectAsState()
    var user = userState.value.user

    Log.d(TAG,"state"+ userState.toString())
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.fragment_background))
            .padding(
                bottom = 40.dp
            )
    ) {
        item {
            AsyncImage(
                modifier = Modifier
                    .height(400.dp)
                    .fillMaxWidth(),
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(user?.imgSrc)
                    .build(),
                error = painterResource(R.drawable.ic_baseline_sports_motorsports_24),
                placeholder = painterResource(R.drawable.ic_baseline_sports_motorsports_24),
                contentDescription = "f",
                contentScale = ContentScale.Crop,
            )
        }

            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .background(colorResource(id = R.color.fragment_background))
                ) {
                    Text(
                        "О себе",
                        modifier = Modifier
                            .padding(
                                top = 16.dp,
                                bottom = 12.dp
                            ),
                        fontSize = 18.sp,
                        color = colorResource(R.color.text_main)
                    )
                    if (user == null) {
                        CircularProgressIndicator(modifier = Modifier
                            .padding(10.dp),
                            color = colorResource(id = R.color.text_main)
                        )
                    }else {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(2.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(2.dp)
                            ) {
                                Text(
                                    "Телефон",
                                    modifier = Modifier
                                        .padding(2.dp),
                                    fontSize = 12.sp,
                                    color = colorResource(id = R.color.text_main)
                                )
                                Text(
                                    user.phone,
                                    modifier = Modifier
                                        .padding(2.dp)
                                )
                            }
                        }
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(2.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(2.dp)
                            ) {
                                Text(
                                    "Почта",
                                    modifier = Modifier
                                        .padding(2.dp),
                                    fontSize = 12.sp,
                                    color = colorResource(id = R.color.text_main)
                                )
                                Text(
                                    user.email,
                                    modifier = Modifier
                                        .padding(2.dp)
                                )
                            }
                        }
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(2.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(2.dp)
                            ) {
                                Text(
                                    "Дата рождения",
                                    modifier = Modifier
                                        .padding(2.dp),
                                    fontSize = 12.sp,
                                    color = colorResource(id = R.color.text_main)
                                )
                                Text(
                                    user.birthday,
                                    modifier = Modifier
                                        .padding(2.dp)
                                )
                            }
                        }
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(2.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(2.dp)
                            ) {
                                Text(
                                    "Пол",
                                    modifier = Modifier
                                        .padding(2.dp),
                                    fontSize = 12.sp,
                                    color = colorResource(id = R.color.text_main)
                                )
                                Text(
                                    user.male,
                                    modifier = Modifier
                                        .padding(2.dp)
                                )
                            }
                        }
                    }
                    Text(
                        "Мои соцсети",
                        modifier = Modifier
                            .padding(
                                top = 16.dp,
                                bottom = 12.dp
                            ),
                        fontSize = 18.sp,
                        color = colorResource(R.color.text_main)
                    )
                    if (user==null){
                        CircularProgressIndicator(modifier = Modifier
                            .padding(10.dp),
                            color = colorResource(id = R.color.text_main)
                        )
                    }else {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(2.dp)
                            ) {
                                Text(
                                    "Telegram",
                                    modifier = Modifier
                                        .padding(2.dp),
                                    fontSize = 12.sp,
                                    color = colorResource(id = R.color.text_main)
                                )
                                Text(
                                    user.telegram,
                                    modifier = Modifier
                                        .padding(2.dp)
                                )
                            }
                        }
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(2.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(2.dp)
                            ) {
                                Text(
                                    "Vk",
                                    modifier = Modifier
                                        .padding(2.dp),
                                    fontSize = 12.sp,
                                    color = colorResource(id = R.color.text_main)
                                )
                                Text(
                                    user.vk,
                                    modifier = Modifier
                                        .padding(2.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
}

