package com.pcsalt.example.alertbuttonoverride

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pcsalt.example.alertbuttonoverride.R
import android.content.DialogInterface
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /*
    This method is referenced from Button in activity_main.xml
     */
    fun buttonClicked(view: View?) {
        val dialogBuilder = AlertDialog.Builder(this).apply {
            setTitle("Demo")
            setMessage("After clicking the \"Done\" button, dialog will not close.")
            setPositiveButton("Done", null)
            setNegativeButton("Close", null)
        }
        val alertDialog = dialogBuilder.create()
        alertDialog.show()

        val positiveButton = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE)
        // override the text color of positive button
        positiveButton.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                android.R.color.holo_green_dark
            )
        )
        // provides custom implementation to positive button click
        positiveButton.setOnClickListener { onPositiveButtonClicked(alertDialog) }
        val negativeButton = alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE)
        // override the text color of negative button
        negativeButton.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                android.R.color.holo_red_dark
            )
        )
        // provides custom implementation to negative button click
        negativeButton.setOnClickListener { onNegativeButtonClicked(alertDialog) }
    }

    private fun onPositiveButtonClicked(alertDialog: AlertDialog) {
        Toast.makeText(this@MainActivity, "Dialog will NOT close", Toast.LENGTH_SHORT).show()
    }

    private fun onNegativeButtonClicked(alertDialog: AlertDialog) {
        Toast.makeText(this@MainActivity, "Dialog will close now", Toast.LENGTH_SHORT).show()
        alertDialog.dismiss()
    }
}