package com.example.traintickets

import android.app.Application

class TicketApplication : Application() {

    companion object {
        var database: TicketRoomDatabase? = null
        var repository: TicketRepository? = null
    }

    override fun onCreate() {
        super.onCreate()
        database = TicketRoomDatabase.getDatabase(this)
        repository = TicketRepository(database!!.ticketDao())
    }
}