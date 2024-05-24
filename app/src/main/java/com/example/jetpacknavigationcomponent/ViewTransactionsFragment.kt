package com.example.jetpacknavigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class ViewTransactionsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_view_transaction, container, false)
        val bt_test = view.findViewById<Button>(R.id.bt_test)

        bt_test.setOnClickListener {
            val action = ViewTransactionsFragmentDirections.actionViewTransactionsFragmentToSendCashFragment(amount = 500L)
            findNavController().navigate(action)
        }


        return view
    }
}