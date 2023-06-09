package com.example.traintickets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.traintickets.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null

    private val binding get() = _binding!!

    private val departureTimes = Array(24) { i -> "%2d:00".format(i) }
    private var selectedId: Int? = null
    private var arrayAdapter: ArrayAdapter<String>? = null

    private val ticketViewModel: TicketViewModel by activityViewModels {
        TicketViewModelFactory(TicketApplication.repository!!)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arrayAdapter = this.context?.let {
            ArrayAdapter(
                it,
                android.R.layout.simple_spinner_item,
                departureTimes
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.spDepartureTime) {
            adapter = arrayAdapter

            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    pos: Int,
                    id: Long
                ) {
                    selectedId = pos
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    selectedId = null
                }
            }
        }

        binding.btnOk.setOnClickListener {
            if (binding.etOrigin.text.isNullOrEmpty()) {
                toastError(getString(R.string.origin_not_selected))
            } else if (binding.etDestination.text.isNullOrEmpty()) {
                toastError(getString(R.string.destination_not_selected))
            } else if (selectedId == null) {
                toastError(getString(R.string.departure_not_selected))
            } else {
                val ticket = Ticket(
                    binding.etOrigin.text?.toString(),
                    binding.etDestination.text?.toString(),
                    departureTimes[selectedId!!]
                )

                ticketViewModel.insert(TicketEntity(
                    ticket.origin!!, ticket.destination!!, ticket.departure!!
                ))

                Toast.makeText(this.context, "Ticket added to the database!", Toast.LENGTH_SHORT).show()

                val action = MainFragmentDirections.actionMainFragmentToViewTicketFragment(ticket)
                findNavController().navigate(action)
            }
        }

        binding.btnOpen.setOnClickListener {
            if (ticketViewModel.allTickets.value?.size == null) {
                toastError("Ticket data base is empty!")

            } else {
                val action = MainFragmentDirections.actionMainFragmentToViewAllTicketsFragment()
                findNavController().navigate(action)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun toastError(msg: String) {
        Toast.makeText(this.context, msg, Toast.LENGTH_SHORT).show()
    }
}