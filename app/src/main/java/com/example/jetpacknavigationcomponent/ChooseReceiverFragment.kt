package com.example.jetpacknavigationcomponent

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.fragment.findNavController

class ChooseReceiverFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_choose_receiver, container, false)
        val btn_next: Button = view.findViewById(R.id.btn_next)
        val btn_cancel = view.findViewById<Button>(R.id.btn_cancel)
        val et_receiver_name: EditText = view.findViewById(R.id.et_receiver_name)


        //DATA OR BUNDLE PASSING WITHOUT JNC SAFE ARGS PLUGIN
        /*btn_next.setOnClickListener {

            //ANIMATION ADD PROGRAMMATICALLY
            val navOption = NavOptions.Builder()
                .setEnterAnim(R.anim.slide_in_right)
                .setExitAnim(R.anim.slide_out_left)
                .setPopEnterAnim(R.anim.slide_in_left)
                .setPopExitAnim(R.anim.slide_out_right)
                .build()

            if (et_receiver_name.text.isNotEmpty()) {
                val receiverName = et_receiver_name.text.toString()
                val args = Bundle()
                args.putString("name", receiverName)

                findNavController().navigate(R.id.sendCashFragment, args, navOption)
            }
        }*/


        //DATA PASSING USING JNC SAFE ARGS PLUGIN
        btn_next.setOnClickListener {

            if (et_receiver_name.text.isNotEmpty()) {
                val receiverName = et_receiver_name.text.toString()
                ExplicitDeepLink(receiverName)
                val action = ChooseReceiverFragmentDirections.actionChooseReceiverFragmentToSendCashFragment(receiverName)
                findNavController().navigate(action)

            } else {
                et_receiver_name.error = "input blank!"
                et_receiver_name.requestFocus()
                return@setOnClickListener
            }
        }

        //BACK STACK MANAGE WITH POPUP_TO AND POPUP_TO_INCLUSIVE
        btn_cancel.setOnClickListener {
            findNavController().popBackStack()
            /*findNavController().navigateUp()*/
        }



        return view
    }

    @SuppressLint("MissingPermission")
    private fun ExplicitDeepLink(receiverName: String) {
        val pendingIntent = NavDeepLinkBuilder(requireContext())
            .setGraph(R.navigation.home_graph)
            .setDestination(R.id.sendCashFragment)
            .setArguments(SendCashFragmentArgs(receiverName).toBundle())
            .createPendingIntent()

        val notification = NotificationCompat.Builder(requireContext(), CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notifications)
            .setContentTitle("Complete Transaction")
            .setContentText("Send money to $receiverName")
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        NotificationManagerCompat.from(requireContext()).notify(1002, notification)
    }
}