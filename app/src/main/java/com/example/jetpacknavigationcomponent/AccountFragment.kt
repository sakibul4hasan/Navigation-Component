package com.example.jetpacknavigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController

class AccountFragment : Fragment(R.layout.fragment_account) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val account_btn = view.findViewById<Button>(R.id.account_btn)

        account_btn.setOnClickListener {
            val action = AccountFragmentDirections.actionAccountFragmentToProfileFragment()
            findNavController().navigate(action)
        }

    }
}