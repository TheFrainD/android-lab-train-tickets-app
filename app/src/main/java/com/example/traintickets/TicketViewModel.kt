package com.example.traintickets

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class TicketViewModel(private val repository: TicketRepository) : ViewModel() {

    val allTickets: LiveData<List<TicketEntity>> = repository.allTickets.asLiveData()

    fun insert(ticket: TicketEntity) = viewModelScope.launch {
        repository.insert(ticket)
    }
}

class TicketViewModelFactory(private val repository: TicketRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TicketViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TicketViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}