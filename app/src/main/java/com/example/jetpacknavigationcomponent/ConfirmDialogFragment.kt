package com.example.jetpacknavigationcomponent

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ConfirmDialogFragment : BottomSheetDialogFragment(R.layout.fragment_confirm_dialog) {

    private val args: ConfirmDialogFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dialog_message = view.findViewById<TextView>(R.id.dialog_message)
        val btn_negative = view.findViewById<Button>(R.id.btn_negative)
        val btn_positive = view.findViewById<Button>(R.id.btn_positive)

        //
        dialog_message.text = "Do you want to send ${args.amount}Tk to ${args.receiverName}?"

        btn_negative.setOnClickListener {
            dismiss()
            Toast.makeText(requireContext(), "Cancel", Toast.LENGTH_SHORT).show()
        }
        btn_positive.setOnClickListener {
            Toast.makeText(context, "${args.amount}Tk has been sent to ${args.receiverName}", Toast.LENGTH_LONG).show()
            dismiss()
        }

    }
}