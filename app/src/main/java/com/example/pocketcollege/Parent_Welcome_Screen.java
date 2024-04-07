package com.example.pocketcollege;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

public class Parent_Welcome_Screen extends FragmentActivity implements OnClickListener

{

	Button timetable, marks, attendance,personaldetails,events, myfees, teacherdetails,assignments;
	//final Context context = this;
	private ImageView logout;
	private View rootView;

	public  Parent_Welcome_Screen(){

	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.parentwelcome, container, false);


		TextView welcomeMessage = (TextView) findViewById(R.id.welcomee);
		GlobalVariables newObj = (GlobalVariables) getApplication();
		welcomeMessage.setText("Welcome " + newObj.getUserName());
		timetable = (Button) findViewById(R.id.view_departmant);
		marks = (Button) findViewById(R.id.view_marks);
		attendance = (Button) findViewById(R.id.view_attendance_report);

		personaldetails = (Button) findViewById(R.id.personal_details);
		events = (Button) findViewById(R.id.events);
		myfees = (Button) findViewById(R.id.feedetails);
		teacherdetails = (Button) findViewById(R.id.teacherdetails);

		timetable.setOnClickListener(this);
		marks.setOnClickListener(this);
		attendance.setOnClickListener(this);

		personaldetails.setOnClickListener(this);
		events.setOnClickListener(this);
		myfees.setOnClickListener(this);
		teacherdetails.setOnClickListener(this);

		return rootView;
	}


	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.parentwelcome);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			Window window = getWindow();
			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			window.setStatusBarColor(ContextCompat.getColor(this, R.color.cardviewcolor));
			window.setNavigationBarColor(ContextCompat.getColor(this, R.color.cardviewcolor));
		}
	}
	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
	}
	
	

	@Override
	public void onBackPressed() {
		AlertDialog.Builder builder = new AlertDialog.Builder(
				Parent_Welcome_Screen.this);
		builder.setMessage("Do you want to exit?")
				.setCancelable(false)
				.setPositiveButton("Quit",new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								Parent_Welcome_Screen.this.finish();
							}
						})
				.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
							}
						});
		AlertDialog alert = builder.create();
		alert.show();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		/*switch (v.getId()) {

		case R.id.view_departmant:
			System.out.println("Inside switch");
			Intent newIntent51 = new Intent("com.prakyath.pocketcollege.TIMETABLE");
			startActivity(newIntent51);
			overridePendingTransition(R.anim.flip_vertical_in, R.anim.flip_vertical_out);
			break;

		case R.id.view_marks:
			Intent newIntent2 = new Intent("com.prakyath.pocketcollege.INTERNALMARKS");
			startActivity(newIntent2);
			overridePendingTransition(R.anim.flip_vertical_in, R.anim.flip_vertical_out);
			break;

		case R.id.view_attendance_report:
			Intent newIntent3 = new Intent("com.prakyath.pocketcollege.VIEW_ATTENDANCE");
			startActivity(newIntent3);
			overridePendingTransition(R.anim.flip_vertical_in, R.anim.flip_vertical_out);
			break;

		case R.id.personal_details:
			Intent newIntent5 = new Intent("com.prakyath.pocketcollege.PARENTPERSONALDETAILS");
			startActivity(newIntent5);
			overridePendingTransition(R.anim.flip_vertical_in, R.anim.flip_vertical_out);
			break;

		case R.id.events:
			Intent newIntent6 = new Intent("com.prakyath.pocketcollege.EVENTS");
			startActivity(newIntent6);
			overridePendingTransition(R.anim.flip_vertical_in, R.anim.flip_vertical_out);
			break;

		case R.id.feedetails:
			*//*GlobalVariables newObj = (GlobalVariables) getApplication();
			newObj.alertDialogDisplay(context);*//*
			Intent newIntent7 = new Intent("com.prakyath.pocketcollege.MYFEES");
			startActivity(newIntent7);
			overridePendingTransition(R.anim.flip_vertical_in, R.anim.flip_vertical_out);
			break;

		case R.id.teacherdetails:
			Intent newIntent8 = new Intent("com.prakyath.pocketcollege.PARENTTEACHERDETAILS");
			startActivity(newIntent8);
			overridePendingTransition(R.anim.flip_vertical_in, R.anim.flip_vertical_out);
			break;
		
		default:
			break;

		}*/
	}
}
