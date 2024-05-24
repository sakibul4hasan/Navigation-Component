package com.example.jetpacknavigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController

class NotificationFragment : Fragment(R.layout.fragment_notification) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lv_notifications = view.findViewById<ListView>(R.id.lv_notifications)

        lv_notifications.adapter = ArrayAdapter<String>(requireContext(),android.R.layout.simple_list_item_1,getNotifications())

    }

    private fun getNotifications(): List<String> {
        val notifications = mutableListOf<String>()

        for (i in 1..20) {
            notifications.add("Notification # $i")
        }
        return notifications
    }

}