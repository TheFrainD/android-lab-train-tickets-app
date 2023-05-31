package com.example.traintickets

import android.app.Application

class TicketApplication : Application() {

    private val database by lazy { TicketRoomDatabase.getDatabase(this) }
    val repository by lazy { TicketRepository(database.ticketDao()) }
}