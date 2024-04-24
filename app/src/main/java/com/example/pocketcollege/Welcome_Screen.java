package com.example.pocketcollege;

import static android.app.PendingIntent.getActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;


public class Welcome_Screen extends Activity {	
	

	private ImageView personDetails;
	private ImageView iaMarks;
	private ImageView noticeBoard;

	public Welcome_Screen(){

	}


	public void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.welcome);
		 TextView welcomeMessage = (TextView) findViewById(R.id.welcomee);


		GlobalVariables newObj = (GlobalVariables) this.getApplication();
		//welcomeMessage.setText("Welcome " +" To "+ newObj.getUserName());
		welcomeMessage.setText("Welcome " +" To Aviansh Raj ");
		personDetails = (ImageView) findViewById(R.id.personaldetails);
		iaMarks = (ImageView) findViewById(R.id.internals_marks);
		noticeBoard = (ImageView) findViewById(R.id.noticboard);
		personDetails.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
                Intent intent = new Intent(Welcome_Screen.this, MyStudentProfile.class);
                startActivity(intent);
			}
		});
		iaMarks.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
                Intent intent = new Intent(Welcome_Screen.this, InternalMarks.class);
                startActivity(intent);
			}
		});
		noticeBoard.setOnClickListener(new OnClickListener() {
			@Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(Welcome_Screen.this, View_notice.class);
                startActivity(intent);
            }
		});
	}
	@Override
	public void onResume() {
		super.onResume();
	                       }

	@Override
	public void onPause() {
		super.onPause();
	                      }
	

}
