package com.example.jetpacknavigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val btn_send_money : Button = view.findViewById(R.id.btn_send_money)
        val btn_view_balance : Button = view.findViewById(R.id.btn_view_balance)
        val btn_transaction : Button = view.findViewById(R.id.btn_transaction)
        val navController = findNavController()

        //There are three ways to navigate

        //NAVIGATE USING GRAPH FRAG ID
        /*btn_send_money.setOnClickListener {
            navController.navigate(R.id.chooseReceiverFragment)
        }
        btn_view_balance.setOnClickListener {
            navController.navigate(R.id.viewBalanceFragment)
        }
        btn_transaction.setOnClickListener {
            navController.navigate(R.id.viewTransactionsFragment)
        }*/

        //NAVIGATE USING ACTION XML ATTRIBUTES
        /*btn_send_money.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_chooseReceiverFragment)
        }
        btn_view_balance.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_viewBalanceFragment)
        }
        btn_transaction.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_viewTransactionsFragment)
        }*/


        //NAVIGATE USING SAFE ARGS PLUGIN AND ACTION FOR RECOMMENDED BY GOOGLE
        btn_send_money.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToChooseReceiverFragment()
            navController.navigate(action)
        }
        btn_view_balance.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToViewBalanceFragment()
            navController.navigate(action)
        }
        btn_transaction.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToViewTransactionsFragment()
            navController.navigate(action)
        }


        return view
    }
}