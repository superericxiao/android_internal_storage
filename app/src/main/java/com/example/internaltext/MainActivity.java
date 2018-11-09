package com.example.internaltext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

	private Button bt1,bt2;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/**/
		bt1 = (Button)findViewById(R.id.button1);
		bt2 = (Button)findViewById(R.id.button2);
		bt1.setOnClickListener(click);
		bt2.setOnClickListener(click);
	}
	
	
	public OnClickListener click = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			switch (arg0.getId()) {
			case R.id.button1:
				startActivity(new Intent(MainActivity.this,Write.class));
				break;
			case R.id.button2:
				startActivity(new Intent(MainActivity.this,Read.class));
				break;
			}
		}
	};
	
}
