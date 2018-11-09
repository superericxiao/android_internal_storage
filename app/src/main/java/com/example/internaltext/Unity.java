package com.example.internaltext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

public class Unity {
	
	//�g��
	public static void writeDataToFile(Context context, String data){
	  try {
	    FileOutputStream fout = context.openFileOutput("data", Context.MODE_PRIVATE);
	    fout.write(data.getBytes());
	    fout.close();
	  } catch (FileNotFoundException e) {
	    e.printStackTrace();
	  } catch (IOException e) {
	    e.printStackTrace();
	  }
	}
	
	//Ū��
	public static String readDataFromFile(Context context){
	  String result = "";
	  try {
	    StringBuilder sb = new StringBuilder();
	    FileInputStream fin = context.openFileInput("data");
	    byte[] data = new byte[fin.available()];
	    while (fin.read(data) != -1) {
	      sb.append(new String(data));
	    }
	    fin.close();
	    result = sb.toString();
	  } catch (FileNotFoundException e) {
	    e.printStackTrace();
	  } catch (IOException e) {
	    e.printStackTrace();
	  }
	  return result;
	}

	

	public static ArrayList<ArrayList<String>> PartitionExtraction(String str){
		ArrayList<ArrayList<String>> student = new ArrayList<>();
		//Log.i("G", str);
		String[] Peoples = str.split("#");
		
		for (int i = 0; i < Peoples.length; i++) {
			String[] infor = Peoples[i].split("%");
			
			ArrayList<String> arrayList = new ArrayList<>();
			for (int j = 0; j < infor.length; j++) {
				arrayList.add(infor[j]);
			}
			student.add(arrayList);
		}
		
		return student;
	}
	
	
	
}
