package com.example.jetpacknavigationcomponent

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val et_default_amount = view.findViewById<EditText>(R.id.et_default_amount)
        val btn_save = view.findViewById<Button>(R.id.btn_save)
        val btn_about_app = view.findViewById<Button>(R.id.btn_about_app)


        et_default_amount.setText(SampleData.defaultAmount.value.toString())

        btn_save.setOnClickListener {
            if (et_default_amount.text.isNotEmpty()) {

                val defaultAmount = et_default_amount.text.toString().toLong()
                SampleData.defaultAmount.value = defaultAmount
            }
            return@setOnClickListener
        }

        //
        btn_about_app.setOnClickListener {
            val action = SettingGraphDirections.actionGlobalAboutAppFragment()
            findNavController().navigate(action)
        }

    }

}