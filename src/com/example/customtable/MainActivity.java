package com.example.customtable;

import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends Activity {
	static int counter=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.table_layout);
		init();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void init() {
		TableLayout tl = (TableLayout) findViewById(R.id.table_layout_id);
		//add new row buttone
		TableRow addrow = new TableRow(this);
		TableRow.LayoutParams lp1 = new TableRow.LayoutParams(
				TableRow.LayoutParams.WRAP_CONTENT);
		addrow.setLayoutParams(lp1);
		ImageButton addButt = new ImageButton(this);
		addButt.setBackgroundResource(getResources().getIdentifier("add" , "drawable", getPackageName()));
		addrow.addView(addButt);
		addrow.setPadding(0, 5, 0,0);
		addrow.setGravity(Gravity.CENTER);
		tl.addView(addrow);
		addButt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				addrow(counter);
				counter++;
			}
		});
		
	}
	
	private void addrow(int i){
		LayoutInflater inflater = getLayoutInflater();
		TableLayout tl = (TableLayout) findViewById(R.id.table_layout_id);
		TableRow row = (TableRow) inflater.inflate(
				R.layout.table_row_layout, tl, false);
		ImageButton left = (ImageButton) row
				.findViewById(R.id.left_butt_id);
		EditText txt = (EditText) row.findViewById(R.id.text_id);
		ImageButton right = (ImageButton) row
				.findViewById(R.id.right_butt_id);
		txt.setText("custom row # " + i);
		// set background for left buttone
		left.setBackgroundResource(getResources().getIdentifier("img",
				"drawable", getPackageName()));
		left.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//do something
			}
		});
		// set image for right button
		right.setBackgroundResource(getResources().getIdentifier("del",
				"drawable", getPackageName()));
		// add listener to perform deletion no row
		right.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TableLayout localTl = (TableLayout) findViewById(R.id.table_layout_id);
				localTl.removeView((View) v.getParent());
				counter--;
			}
		});
		//add row to table
		tl.addView(row,counter);
	}
}
