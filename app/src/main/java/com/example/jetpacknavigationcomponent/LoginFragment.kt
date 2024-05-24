package com.example.jetpacknavigationcomponent

import android.os.Bundle
import android.view.Menu
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton

class LoginFragment : Fragment(R.layout.fragment_login) {

    companion object {
        const val LOGIN_SUCCESSFUL = "LOGIN_SUCCESSFUL"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val et_username: EditText = view.findViewById(R.id.et_username)
        val et_password = view.findViewById<EditText>(R.id.et_password)
        val button_login = view.findViewById<MaterialButton>(R.id.button_login)

        val savedStateHandle = findNavController().previousBackStackEntry!!.savedStateHandle
        savedStateHandle.set(LOGIN_SUCCESSFUL, false)

        UserLoginInfo.user = null

        button_login.setOnClickListener {
            val username = et_username.text.toString()
            val password = et_password.text.toString()
            if (username.isNotEmpty() and password.isNotEmpty()) {
                UserLoginInfo.user = User(username, password)
                savedStateHandle.set(LOGIN_SUCCESSFUL, true)
                findNavController().popBackStack()

            } else Toast.makeText(requireContext(), "Details flup properly! then try", Toast.LENGTH_SHORT).show()
        }

    }
}