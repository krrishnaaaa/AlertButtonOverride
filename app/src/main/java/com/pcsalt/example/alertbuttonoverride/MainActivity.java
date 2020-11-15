package com.pcsalt.example.alertbuttonoverride;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    This method is referenced from Button in activity_main.xml
     */
    public void buttonClicked(View view) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Demo");
        dialogBuilder.setMessage("After clicking the \"Done\" button, dialog will not close.");
        dialogBuilder.setPositiveButton("Done", null);
        dialogBuilder.setNegativeButton("Close", null);

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

        Button positiveButton = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        // override the text color of positive button
        positiveButton.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
        // provides custom implementation to positive button click
        positiveButton.setOnClickListener(v -> onPositiveButtonClicked(alertDialog));

        Button negativeButton = alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
        // override the text color of negative button
        negativeButton.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
        // provides custom implementation to negative button click
        negativeButton.setOnClickListener(v -> onNegativeButtonClicked(alertDialog));

    }

    private void onPositiveButtonClicked(AlertDialog alertDialog) {
        Toast.makeText(MainActivity.this, "Dialog will NOT close", Toast.LENGTH_SHORT).show();
    }

    private void onNegativeButtonClicked(AlertDialog alertDialog) {
        Toast.makeText(MainActivity.this, "Dialog will close now", Toast.LENGTH_SHORT).show();
        alertDialog.dismiss();
    }
}
