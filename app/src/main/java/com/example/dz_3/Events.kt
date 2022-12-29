package com.example.dz_3

import android.content.ContentValues.TAG
import android.graphics.fonts.FontStyle
import android.media.Image
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.items
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.dz_3.data.Event

@Composable
fun EventsGrid(viewModel: HomeViewModel){
    val eventsState = viewModel.state.collectAsState()
    var events = eventsState.value.events
LazyColumn(
    modifier = Modifier
        .fillMaxWidth()
        .background(colorResource(id = R.color.fragment_background))
        .padding(
            top = 16.dp,
            bottom = 40.dp,
            start = 12.dp,
            end = 12.dp
        ),
    horizontalAlignment = Alignment.CenterHorizontally

){
    if(events.isEmpty()){
        Loading()
    }else{
        item{
            Text(text="Мероприятия",
                modifier = Modifier
                    .background(colorResource(id = R.color.fragment_background))
                    .padding(
                        top = 20.dp,
                        bottom = 12.dp
                    )
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = colorResource(id = R.color.text_main)
            )
        }
        items(
            items = events,
            key = {it.id}
        ){
            Spacer(modifier = Modifier.height(5.dp))
            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxSize()
            ){
                Column(
                    modifier = Modifier.padding(15.dp)
                ) {
                    Text(it.name,
                        modifier = Modifier
                            .padding(2.dp),
                        fontSize = 18.sp,
                        color = colorResource(R.color.text_main))
                    Text(it.date,
                        modifier = Modifier
                            .padding(2.dp),
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.text_second)
                    )
                    Row(modifier = Modifier.padding(2.dp)) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id =R.drawable.ic_baseline_location_on_24 ),
                            contentDescription = "smth",
                            tint = colorResource(R.color.text_main),
                        )
                        Text(it.city,
                            modifier = Modifier
                                .padding(2.dp),
                            fontSize = 12.sp,
                            color = colorResource(R.color.text_main)
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Card(
                            modifier = Modifier
                                .padding(5.dp),

                            shape = RoundedCornerShape(15.dp),
                        ) {
                            Text(it.cat, modifier = Modifier
                                .background(color = colorResource(R.color.category_background))
                                .padding(5.dp),
                                color = colorResource(R.color.text_main),
                                fontSize = 12.sp,
                            )

                        }

                    }
                    Card(
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier
                            .fillMaxSize()
                            .defaultMinSize(minWidth = 200.dp, minHeight = 200.dp),
                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(context = LocalContext.current)
                                .data(it.imgSrc)
                                .build(),
                            error = painterResource(R.drawable.ic_baseline_sports_motorsports_24),
                            placeholder = painterResource(R.drawable.ic_baseline_sports_motorsports_24),
                            contentDescription = "f",
                            contentScale = ContentScale.Crop,
                        )
                    }
                    LikeGroup(it)
                }
            }
        }
    }
}
}

private fun LazyListScope.Loading() {
    item {
        CircularProgressIndicator(modifier = Modifier
                .padding(10.dp), 
            color = colorResource(id = R.color.text_main)
        )
    }
}

@Composable
fun LikeGroup(event: Event){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        Row(
            modifier = Modifier.padding(4.dp)
        ){
            Icon(
                imageVector = ImageVector.vectorResource(id =R.drawable.ic_outline_favorite_border_24),
                contentDescription = "smth",
                tint = colorResource(R.color.text_second),
            )
            Text(event.like.toString(),color = colorResource(id = R.color.text_main))
        }

        Row(
            modifier = Modifier.padding(4.dp)
        ){
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_people_outline_24),
                contentDescription = "smth",
                tint = colorResource(R.color.text_second),
            )
            Text(event.look_cnt.toString(),color = colorResource(id = R.color.text_main))
        }


        Row(
            modifier = Modifier.padding(4.dp)
        ){
            Icon(
                imageVector = ImageVector.vectorResource(id =R.drawable.ic_outline_remove_red_eye_24 ),
                contentDescription = "smth",
                tint = colorResource(R.color.text_second),
            )
            Text(event.users_cnt.toString(),color = colorResource(id = R.color.text_main))
        }

    }
}