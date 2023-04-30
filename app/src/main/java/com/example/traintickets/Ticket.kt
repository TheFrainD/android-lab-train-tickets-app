package com.example.traintickets

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ticket(
    val origin: String?,
    val destination: String?,
    val departure: String?,
) : Parcelable