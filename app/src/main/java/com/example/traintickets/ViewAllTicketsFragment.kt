package com.example.traintickets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.traintickets.databinding.FragmentViewAllTicketsBinding

class ViewAllTicketsFragment : Fragment() {

    private var _binding: FragmentViewAllTicketsBinding? = null
    private val binding get() = _binding!!

    private val ticketViewModel: TicketViewModel by activityViewModels {
        TicketViewModelFactory(TicketApplication.repository!!)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentViewAllTicketsBinding.inflate(inflater, container, false)

        ticketViewModel.allTickets.observe(viewLifecycleOwner) {
            binding.recyclerViewTickets.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = TicketAdapter(it)
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnReturn.setOnClickListener {
            val action = ViewAllTicketsFragmentDirections.actionViewAllTicketsFragmentToMainFragment()
            findNavController().navigate(action)
        }
    }
}