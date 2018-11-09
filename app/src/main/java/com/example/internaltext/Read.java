package com.example.internaltext;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Read extends AppCompatActivity {

	private TextView student,last,first,gender,division;
	private Button bt1,bt2,bt3;
	
	private ArrayList<ArrayList<String>> students;
	private int total,Currentnumber = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_read);
		fid();
		
		String RecordString = Unity.readDataFromFile(Read.this);
		Log.i("A", RecordString);
		try{
			if (RecordString !=null){
				students = Unity.PartitionExtraction(RecordString);
				total = students.size();
				//
				UpdateUI(Currentnumber);//The first student
				
			}else{
				error();
			}
		}catch (Exception e) {
			Log.i("error", e.getMessage());
			//error();
		}
		
	}

	
	private void UpdateUI(int nextnumber) {
		Log.i("nextnumberA", nextnumber+"_"+total);
		if (nextnumber>(total-1)) {
			nextnumber = Currentnumber = 0;
		}
		if(nextnumber<0){
			nextnumber = Currentnumber = (total-1);
		}
		student.setText(students.get(nextnumber).get(0)+"");
		last.setText(students.get(nextnumber).get(1)+"");
		first.setText(students.get(nextnumber).get(2)+"");
		gender.setText(students.get(nextnumber).get(3)+"");
		division.setText(students.get(nextnumber).get(4)+"");
		
	}
	
	public OnClickListener click = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			switch (arg0.getId()) {
			case R.id.button1:
				Currentnumber--;
				UpdateUI(Currentnumber);
				break;
			case R.id.button2:
				Currentnumber++;
				UpdateUI(Currentnumber);
				break;
			case R.id.button3:
				finish();
				break;
			}
		}
	};

	private void fid() {
		student = (TextView)findViewById(R.id.student);
		last = (TextView)findViewById(R.id.last);
		first = (TextView)findViewById(R.id.first);
		gender = (TextView)findViewById(R.id.gender);
		division = (TextView)findViewById(R.id.division);
		bt1 = (Button)findViewById(R.id.button1);
		bt2 = (Button)findViewById(R.id.button2);
		bt3 = (Button)findViewById(R.id.button3);
		bt1.setOnClickListener(click);
		bt2.setOnClickListener(click);
		bt3.setOnClickListener(click);
	}
	private void error() {
		Toast.makeText(Read.this, "you need to add some records", Toast.LENGTH_SHORT).show();
		bt1.setEnabled(false);
		bt2.setEnabled(false);
	}
}
