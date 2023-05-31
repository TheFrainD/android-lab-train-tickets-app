package com.example.traintickets

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TicketEntity::class], version = 1, exportSchema = false)
public abstract class TicketRoomDatabase : RoomDatabase() {

    abstract fun ticketDao(): TicketDao

    companion object {
        @Volatile
        private var INSTANCE: TicketRoomDatabase? = null

        fun getDatabase(context: Context): TicketRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TicketRoomDatabase::class.java,
                    "ticket_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}