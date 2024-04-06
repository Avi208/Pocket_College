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


public class Welcome_Screen extends Activity implements OnClickListener

{	
	
	Button timetable, marks, attendance,procter, notice, library,feedback, personaldetails, my_institution, videolectures, events, myfees, teacherdetails,
	syllabus,assignments,placements,queries, materal;
	private Toolbar mToolbar;
	ImageView logout;
	private View rootView;

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
		timetable = (Button) findViewById(R.id.view_departmant);
		marks = (Button) findViewById(R.id.view_marks);
		attendance = (Button) findViewById(R.id.view_attendance_report);
		notice = (Button) findViewById(R.id.view_notice_board);
		library = (Button) findViewById(R.id.view_library);
		my_institution = (Button) findViewById(R.id.viewmyinstitution);
		personaldetails = (Button) findViewById(R.id.personal_details);
		//       videolectures	 = (Button) findViewById(R.id.video_lectures);
		feedback=(Button) findViewById(R.id.feedback);
		events	 = (Button) findViewById(R.id.events);
		myfees	 = (Button) findViewById(R.id.feedetails);
		teacherdetails	 = (Button) findViewById(R.id.teacherdetails);
		syllabus	 = (Button) findViewById(R.id.syllabus);
		assignments	 = (Button) findViewById(R.id.assignments);
		placements	 = (Button) findViewById(R.id.placement);
		queries	 = (Button) findViewById(R.id.queries);
//        ebooks = (Button) findViewById(R.id.ebooks);
		procter	 = (Button) findViewById(R.id.proctor);
		materal= (Button) findViewById( R.id.materal);

		timetable.setOnClickListener(this);
		marks.setOnClickListener(this);
		attendance.setOnClickListener(this);
		notice.setOnClickListener(this);
		library.setOnClickListener(this);
		my_institution.setOnClickListener(this);
		personaldetails.setOnClickListener(this);
//		videolectures.setOnClickListener(this);

		events.setOnClickListener(this);
		myfees.setOnClickListener(this);
		teacherdetails.setOnClickListener(this);
		syllabus.setOnClickListener(this);
		assignments.setOnClickListener(this);
		placements.setOnClickListener(this);
		queries.setOnClickListener(this);
//		ebooks.setOnClickListener(this);
		feedback.setOnClickListener(this);
		procter.setOnClickListener(this);
		materal.setOnClickListener(this);
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
	public void onClick(View v) {
		// TODO Auto-generated method stub
		/*switch (v.getId()) {
		
		case R.id.view_departmant:
			System.out.println("Inside switch");
			Intent newIntent1 = new Intent("com.prakyath.pocketcollege.TIMETABLE");
			startActivity(newIntent1);
			getActivity().overridePendingTransition(R.anim.flip_vertical_in, R.anim.flip_vertical_out);
			break;
		
		case R.id.view_marks:
			Intent newIntent2 = new Intent(
					"com.prakyath.pocketcollege.INTERNALMARKS");
			startActivity(newIntent2);
			getActivity().overridePendingTransition(R.anim.flip_vertical_in, R.anim.flip_vertical_out);
			break;
			
		case R.id.view_attendance_report:
			Intent newIntent3 = new Intent("com.prakyath.pocketcollege.VIEW_ATTENDANCE");
			startActivity(newIntent3);
			getActivity().overridePendingTransition(R.anim.flip_vertical_in, R.anim.flip_vertical_out);
			break;
				
		case R.id.view_notice_board:
			Intent newIntent4 = new Intent(
					"com.prakyath.pocketcollege.VIEW_NOTICE");
			startActivity(newIntent4);

			getActivity().overridePendingTransition(R.anim.flip_vertical_in, R.anim.flip_vertical_out);
			break;
				
		case R.id.viewmyinstitution:
			Intent newIntent5 = new Intent(
					"com.prakyath.pocketcollege.MYINSTITUTION");
			startActivity(newIntent5);

			getActivity().overridePendingTransition(R.anim.flip_vertical_in, R.anim.flip_vertical_out);
			break;

		case R.id.view_library:
			*//*Intent newIntent6 = new Intent(
					"com.prakyath.pocketcollege.LIBRARY");
			startActivity(newIntent6);*//*
			GlobalVariables newObj = (GlobalVariables) getActivity().getApplication();
			newObj.alertDialogDisplay(getActivity());

			getActivity().overridePendingTransition(R.anim.flip_vertical_in, R.anim.flip_vertical_out);
			break;				
			
		case R.id.personal_details:
			Intent newIntent7 = new Intent(
					"com.prakyath.pocketcollege.PERSONALDETAILS");
			startActivity(newIntent7);

			getActivity().overridePendingTransition(R.anim.flip_vertical_in, R.anim.flip_vertical_out);
			break;


		case R.id.events:
			Intent newIntent9 = new Intent(
					"com.prakyath.pocketcollege.EVENTS");
			startActivity(newIntent9);

			getActivity().overridePendingTransition(R.anim.flip_vertical_in, R.anim.flip_vertical_out);
			break;
			
		case R.id.feedetails:
			Intent newIntent10 = new Intent(
					"com.prakyath.pocketcollege.MYFEES");
			startActivity(newIntent10);

			getActivity().overridePendingTransition(R.anim.flip_vertical_in, R.anim.flip_vertical_out);

			*//*GlobalVariables newObj3 = (GlobalVariables) getApplication();
			newObj3.alertDialogDisplay(context);*//*

			getActivity().overridePendingTransition(R.anim.flip_vertical_in, R.anim.flip_vertical_out);
			break;
			
		case R.id.teacherdetails:
			Intent newIntent11 = new Intent(
					"com.prakyath.pocketcollege.TEACHERDETAILS");
			startActivity(newIntent11);

			getActivity().overridePendingTransition(R.anim.flip_vertical_in, R.anim.flip_vertical_out);
			break;
			
		case R.id.syllabus:
			Intent newIntent12 = new Intent(
					"com.prakyath.pocketcollege.STUDENTSYLLABUS");
			startActivity(newIntent12);

			getActivity().overridePendingTransition(R.anim.flip_vertical_in, R.anim.flip_vertical_out);
			break;
			
		case R.id.placement:
			*//*Intent newIntent13 = new Intent(
					"com.prakyath.pocketcollege.PLACEMENTS");
			startActivity(newIntent13);*//*
			GlobalVariables newObj1 = (GlobalVariables) getActivity().getApplication();
			newObj1.alertDialogDisplay(getActivity());

			getActivity().overridePendingTransition(R.anim.flip_vertical_in, R.anim.flip_vertical_out);

			break;

			case R.id.feedback:
				Intent newIntent16 = new Intent(
						"com.prakyath.pocketcollege.FEEDBACK");
				startActivity(newIntent16);

				getActivity().overridePendingTransition(R.anim.flip_vertical_in, R.anim.flip_vertical_out);
				break;
			
		case R.id.assignments:
			Intent newIntent14 = new Intent(
					"com.prakyath.pocketcollege.ASSIGNMENTS");
			startActivity(newIntent14);

			getActivity().overridePendingTransition(R.anim.flip_vertical_in, R.anim.flip_vertical_out);
			break;
			case R.id.proctor:
				Intent newIntent17 = new Intent(
						"com.prakyath.pocketcollege.PROCTOR");
				startActivity(newIntent17);

				getActivity().overridePendingTransition(R.anim.flip_vertical_in, R.anim.flip_vertical_out);
				break;
			
		case R.id.queries:
			Intent newIntent15 = new Intent(
					//"com.prakyath.pocketcollege.QUERIES");
					"com.prakyath.pocketcollege.LISTVIEW");
			startActivity(newIntent15);

			getActivity().overridePendingTransition(R.anim.flip_vertical_in, R.anim.flip_vertical_out);
			break;

			case R.id.materal:
				Intent newStudent = new Intent(
						//"com.prakyath.pocketcollege.QUERIES");
						"com.prakyath.pocketcollege.STUDENTMATERAL");
				startActivity(newStudent);

				getActivity().overridePendingTransition(R.anim.flip_vertical_in, R.anim.flip_vertical_out);
				break;
			
//		case R.id.ebooks:
//			
//			break;
					
		default:
			break;*/
			
		}

}
