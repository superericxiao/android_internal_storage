package com.example.internaltext;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Write extends AppCompatActivity {

	private EditText student,last,first;
	private RadioGroup gender;
	private Spinner division;
	private Button Submit;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_write);
		fid();
		
		
		Submit.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View arg0) {
				
				if(CheckText().endsWith("")){
					String RecordString = Unity.readDataFromFile(Write.this);
					
					String ID = student.getText().toString();
					String lastName = last.getText().toString();
					String firstName = first.getText().toString();
					String radioButton = ((RadioButton) findViewById(gender.getCheckedRadioButtonId())).getText().toString();
					String Division = division.getSelectedItem().toString();
					
					String total = ID+"%"+ lastName+"%"+ firstName+"%"+ radioButton+"%"+Division;
					
					if (!RecordString.equals("")) {
						RecordString += "#"+total;
					}else{
						RecordString += total;
					}
					
					Log.i("S", RecordString);
					Unity.writeDataToFile(Write.this, RecordString);
					
					
					
					finish();
					
				}else{
					Toast.makeText(Write.this, CheckText(), Toast.LENGTH_SHORT).show();
				}
			}
		});
	}


	private void fid() {
		student = (EditText)findViewById(R.id.student);
		last = (EditText)findViewById(R.id.last);
		first = (EditText)findViewById(R.id.first);
		gender = (RadioGroup)findViewById(R.id.gender);
		division = (Spinner)findViewById(R.id.division);
		Submit = (Button)findViewById(R.id.Submit);
		
		ArrayAdapter<String> adp = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item);
		adp.add("COSC");
		adp.add("DATA");
		adp.add("MATH");
		division.setAdapter(adp);
		
		
		
	}
	
	private String CheckText() {
		if(student.getText().length()==0
				||last.getText().length()==0
				||first.getText().length()==0){
			return "There are fields not filled";
		}
		return "";
	}
	
	

}
