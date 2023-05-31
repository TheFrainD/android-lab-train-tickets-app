package com.example.traintickets

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.traintickets.databinding.TicketItemBinding

class TicketAdapter(private val allTickets: List<TicketEntity>) : RecyclerView.Adapter<TicketViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = TicketItemBinding.inflate(from, parent, false)
        return TicketViewHolder(parent.context, binding)
    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        holder.bindTicket(allTickets[position])
    }

    override fun getItemCount(): Int = allTickets.size
}