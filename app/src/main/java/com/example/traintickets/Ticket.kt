package com.example.traintickets

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ticket(
    val origin: String?,
    val destination: String?,
    val departure: String?,
) : Parcelable

@Entity(tableName = "ticket_table")
class TicketEntity(
    @ColumnInfo(name = "origin") val origin: String,
    @ColumnInfo(name = "destination") val destination: String,
    @ColumnInfo(name = "departure") val departure: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
)