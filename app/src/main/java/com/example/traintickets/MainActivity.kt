package com.example.traintickets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val departureTimes = Array(24) { i -> "%2d:00".format(i) }
    private var selectedId: Int? = null

    data class Ticket(val layout: ConstraintLayout, val origin: TextView,
                      val destination: TextView, val departure: TextView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<SelectionFragment>(R.id.fragmentContainerView)
            }
        }

//        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, departureTimes)
//        val spinner = findViewById<Spinner>(R.id.spinner_departure)
//        with (spinner) {
//            adapter = arrayAdapter
//
//            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//                override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
//                    selectedId = pos
//                }
//
//                override fun onNothingSelected(parent: AdapterView<*>?) {
//                    selectedId = null
//                }
//            }
//        }
//
//        val originEditText = findViewById<TextInputEditText>(R.id.origin_edit_text)
//        val destinationEditText = findViewById<TextInputEditText>(R.id.destination_edit_text)
//
//        val ticket = Ticket(
//            findViewById(R.id.ticket_layout),
//            findViewById(R.id.text_view_ticket_origin),
//            findViewById(R.id.text_view_ticket_destination),
//            findViewById(R.id.text_view_ticket_time)
//        )
//
//        val buttonOk = findViewById<Button>(R.id.button_ok)
//        buttonOk.setOnClickListener {
//            if (originEditText.text.isNullOrEmpty()) {
//                toastError(getString(R.string.origin_not_selected))
//            } else if (destinationEditText.text.isNullOrEmpty()) {
//                toastError(getString(R.string.destination_not_selected))
//            } else if (selectedId == null) {
//                toastError(getString(R.string.departure_not_selected))
//            } else {
//                printTicket(ticket, originEditText.text, destinationEditText.text, departureTimes[selectedId!!])
//            }
//        }
    }

    private fun toastError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun printTicket(ticket: Ticket, from: Editable?, to: Editable?, time: String) {
        with (ticket) {
            layout.visibility = View.VISIBLE
            origin.text = from
            destination.text = to
            departure.text = time
        }
    }
}