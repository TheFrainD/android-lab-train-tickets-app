package com.example.traintickets

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class TicketRepository(private val ticketDao: TicketDao) {

    val allTickets: Flow<List<TicketEntity>> = ticketDao.getAll()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(ticket: TicketEntity) {
        ticketDao.insert(ticket)
    }
}