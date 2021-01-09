package com.pmacademy.razvii_pt10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class DialogFragmentMain : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_fragment_main, container, false)
    }

    override fun onStart() {
        super.onStart()
        setupListeners()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }

    private fun setupListeners() {
        view?.findViewById<Button>(R.id.btnSayHello)?.setOnClickListener {
            closeDialogSayHello()
        }
    }

    private fun closeDialogSayHello() {
        Toast.makeText(context, "Hi! Glad to see you!", Toast.LENGTH_SHORT).show()
        dismiss()
    }

}