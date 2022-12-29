package com.example.dz_3

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dz_3.data.Event
import com.example.dz_3.data.User
import com.example.dz_3.data.repository.EventRepository
import com.example.dz_3.data.repository.UserRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeViewModel(
    private val eventRepository: EventRepository = Graph.eventRepository
) : ViewModel(){
    private val _myEventState = MutableStateFlow(FavouriteViewState())
    private val _state = MutableStateFlow(HomeViewState())
    val state: StateFlow<HomeViewState>
        get() = _state
    val myEventState: StateFlow<FavouriteViewState>
        get() = _myEventState

    init {
        viewModelScope.launch {
            delay(1000L)
            eventRepository.events("Pavel")
                .onEach { event_list ->
                    _myEventState.update {
                        FavouriteViewState(
                            events = event_list
                        )
                    }
                }
                .collect()
        }
        viewModelScope.launch {
            delay(1000L)
            eventRepository.allEvents()
                .onEach { event_list ->
                    Log.d(ContentValues.TAG, event_list.toString())
                    _state.update{
                        HomeViewState(
                            events = event_list
                        )
                    }
                }
                .collect()
        }
        loadEvent()
    }
    private fun loadEvent(){
        val event = Event(
            1,
            "https://pitbiker.ru/wa-data/public/photos/64/00/64/64.970.jpg",
            "Чемпионат Санкт Петербурга",
            "Pavel",
            "Москва, ул. Бауманская дом 6",
            "23.02.2023",
            "мотокросс",
            20,
            10,
            30,
        )
        val event1 = Event(
            2,
            "https://pitbiker.ru/wa-data/public/photos/64/00/64/64.970.jpg",
            "Чемпионат Москвы",
            "Pavel",
            "Москва, ул. Бауманская дом 6",
            "23.02.2023",
            "питбайки",
            20,
            10,
            30,
        )
        val event2 = Event(
            4,
            "https://img.redbull.com/images/c_crop,x_0,y_0,h_2361,w_4202/c_fill,w_830,h_547/q_auto:low,f_auto/redbullcom/2015/08/19/1331742280888_2/red-bull-motogp-rookies-cup-%D0%B7%D0%B2%D0%B5%D0%B7%D0%B4%D1%8B-%D0%B1%D1%83%D0%B4%D1%83%D1%89%D0%B5%D0%B3%D0%BE.jpg",
            "Чемпионат Мира",
            "Nick",
            "Москва, ул. Бауманская дом 6",
            "23.03.2023",
            "мотоспорт",
            20,
            10,
            30,
        )
        viewModelScope.launch {
            listOf(event,event1,event2).forEach{ event -> eventRepository.addEvent(event) }

        }
    }
}
data class HomeViewState(
    val events: List<Event> = emptyList()
)
data class FavouriteViewState(
    val events: List<Event> = emptyList()
)