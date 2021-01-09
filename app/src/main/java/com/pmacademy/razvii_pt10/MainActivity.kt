package com.pmacademy.razvii_pt10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

    private val bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout> by lazy {
        BottomSheetBehavior.from(findViewById(R.id.bottomSheet))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomSheet()
        setupButtonListeners()

    }

    private fun setupButtonListeners() {
        findViewById<Button>(R.id.btnAlertDialog).setOnClickListener {
            showAlertDialog()
        }
        findViewById<Button>(R.id.btnDialogFragment).setOnClickListener {
            showDialogFragment()
        }
        findViewById<Button>(R.id.btnBottomSheetXml).setOnClickListener {
            showBottomSheetXml()
        }
        findViewById<Button>(R.id.btnBottomSheetFragment).setOnClickListener {
            showBottomSheetFragment()
        }

    }

    private fun showAlertDialog() {
        AlertDialog.Builder(this)
            .setTitle("Hello")
            .setMessage("I'm the Alert Dialog :)")
            .setIcon(R.drawable.ic_launcher_foreground)
            .setPositiveButton("Hello :)") { dialog, which ->
                Toast.makeText(this, "You're funny", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Bye :(") { dialog, which ->
                Toast.makeText(this, "Bye bye", Toast.LENGTH_SHORT).show()
            }
            .setCancelable(false)
            .show()
    }

    private fun showDialogFragment() {
        supportFragmentManager.beginTransaction()
            .add(DialogFragmentMain(), "TAG")
            .commitAllowingStateLoss()
    }

    private fun showBottomSheetFragment() {
        supportFragmentManager.beginTransaction().add(BottomSheetDialogFragmentMain(), "TAG")
            .commitAllowingStateLoss()
    }

    private fun showBottomSheetXml() {
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    private fun setupBottomSheet() {
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                Log.d(TAG, "User slide Bottom Sheet — $slideOffset")
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                Log.d(TAG, "Bottom Sheet state changed. New state — $newState")
            }
        })
    }


}