package com.example.jetpacknavigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialog

class SendCashFragment : Fragment(R.layout.fragment_send_cash) {

    //DATA RECEIVED USING JNC SAFE ARGS PLUGIN
    private val args: SendCashFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text_receiver = view.findViewById<TextView>(R.id.text_receiver)
        val et_amount = view.findViewById<EditText>(R.id.et_amount)
        val btn_cancel = view.findViewById<Button>(R.id.btn_cancel)
        val btn_next = view.findViewById<Button>(R.id.btn_next)
        val btn_done = view.findViewById<Button>(R.id.btn_done)


        //LiveData default amount set
        et_amount.setText(SampleData.defaultAmount.value.toString())
        SampleData.defaultAmount.observe(viewLifecycleOwner) {
            et_amount.setText(it.toString())
        }


        //DATA OR BUNDLE RECEIVED WITHOUT JNC SAFE ARGS PLUGIN
        /*val receiverName = arguments?.getString("name")
        text_receiver.text = "Send cash to $receiverName"*/

        //DATA RECEIVED USING JNC SAFE ARGS PLUGIN
        text_receiver.text = "Send cash to ${args.receiverName}"
        et_amount.setText(args.amount.toString())



        //NAVIGATE USING DIALOG
        btn_next.setOnClickListener {
            if (et_amount.text.isNotEmpty()) {
                val action = SendCashFragmentDirections.actionSendCashFragmentToConfirmDialogFragment(args.receiverName, et_amount.text.toString().toLong())
                findNavController().navigate(action)
            }
        }


        //BACK STACK MANAGE WITH POPUP_TO AND POPUP_TO_INCLUSIVE
        btn_done.setOnClickListener {
            val action = SendCashFragmentDirections.actionSendCashFragmentToHomeFragment()
            findNavController().navigate(action)
        }
        //
        btn_cancel.setOnClickListener {
            findNavController().popBackStack(R.id.homeFragment,false)
        }


    }

}