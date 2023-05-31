package com.example.traintickets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.traintickets.databinding.FragmentViewTicketBinding


class ViewTicketFragment : Fragment() {

    private var _binding: FragmentViewTicketBinding? = null
    private val binding get() = _binding!!

    private val args: ViewTicketFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentViewTicketBinding.inflate(inflater, container, false)

        binding.textViewTicketOrigin.text = args.ticket.origin
        binding.textViewTicketDestination.text = args.ticket.destination
        binding.textViewTicketTime.text = args.ticket.departure

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnReturn.setOnClickListener {
            val action = ViewTicketFragmentDirections.actionViewTicketFragmentToMainFragment()
            findNavController().navigate(action)
        }
    }
}