package com.example.traintickets

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.traintickets.databinding.TicketItemBinding

class TicketViewHolder(
    private val context: Context,
    private val binding: TicketItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bindTicket(ticket: TicketEntity) {
        binding.textViewTicketOrigin.text = ticket.origin
        binding.textViewTicketDestination.text = ticket.destination
        binding.textViewTicketDeparture.text = ticket.departure
    }
}