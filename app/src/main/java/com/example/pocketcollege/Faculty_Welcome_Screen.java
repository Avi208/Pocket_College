package com.example.pocketcollege;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;


public class Faculty_Welcome_Screen extends Activity {


	private ImageView personDetails;
	private ImageView iaMarks;
	private ImageView noticeBoard;
	private ImageView attendence;
	private ImageView sendEmail;
	private ImageView addNoticeBard;

	public Faculty_Welcome_Screen(){

	}


	public void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.faculty_welcome);
		 TextView welcomeMessage = (TextView) findViewById(R.id.welcomee);
		 sendEmail = (ImageView) findViewById(R.id.sendemail);
		 personDetails = (ImageView) findViewById(R.id.personaldetails);
		 noticeBoard = (ImageView) findViewById(R.id.noticboard);
		 addNoticeBard = (ImageView) findViewById(R.id.add_noticboard);


		GlobalVariables newObj = (GlobalVariables) this.getApplication();
		//welcomeMessage.setText("Welcome " +" To "+ newObj.getUserName());
		welcomeMessage.setText("Welcome " +" To Faculty Name ");

		sendEmail.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
                Intent intent = new Intent(Faculty_Welcome_Screen.this, MailToParents.class);
                startActivity(intent);
			}
		});
		personDetails.setOnClickListener(new OnClickListener() {
			@Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(Faculty_Welcome_Screen.this, AllStudentListActivity.class);
                startActivity(intent);
            }
		});
		noticeBoard.setOnClickListener(new View.OnClickListener() {
			@Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(Faculty_Welcome_Screen.this, View_notice.class);
                startActivity(intent);
            }
		});
		addNoticeBard.setOnClickListener(new OnClickListener() {
				@Override
                public void onClick(View view) {
                    // TODO Auto-generated method stub
                    Intent intent = new Intent(Faculty_Welcome_Screen.this, NoticeValidator.class);
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
