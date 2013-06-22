package pcsalt.example.alertbuttonoverride;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class OverrideAlertButtonDemoActivity extends Activity {

	Button btnShow;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_override_alert_button_demo);
		btnShow = (Button) findViewById(R.id.btn_show);
		btnShow.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				show();
			}
		});
	}
	
	public void show() {
		AlertDialog.Builder builder = new AlertDialog.Builder(OverrideAlertButtonDemoActivity.this);
		builder.setTitle("Demo alert");
		builder.setMessage("This is demo alert to override the button of AlertDialog.");
		builder.setNegativeButton("Cancel", null);
		builder.setPositiveButton("OK", null);
		/*builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			// This allows to display toast but closes the dialog
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(getBaseContext(), "Clicked ok", Toast.LENGTH_SHORT).show();
			}
		});*/
		
		AlertDialog alert = builder.create();
		alert.show();
		
		Button btnPositive = alert.getButton(DialogInterface.BUTTON_POSITIVE);
		btnPositive.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getBaseContext(), "Clicked ok", Toast.LENGTH_SHORT).show();
			}
		});
		
	}
}
