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
    private val _state = MutableStateFlow(HomeViewState())
    val state: StateFlow<HomeViewState>
        get() = _state

    init {
        viewModelScope.launch {
            delay(2000L)
            eventRepository.events("Pavel")
                .onEach { event_list ->
                    Log.d(ContentValues.TAG, event_list.toString())
                    _state.update {
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
        val event_1 = Event(
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
        viewModelScope.launch {
            listOf(event,event_1).forEach{ event -> eventRepository.addEvent(event) }

        }
    }
}
data class HomeViewState(
    val events: List<Event> = emptyList()
)