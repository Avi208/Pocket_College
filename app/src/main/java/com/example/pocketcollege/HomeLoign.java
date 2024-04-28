package com.example.pocketcollege;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeLoign extends FragmentActivity  {
	
	Button studentlogin, parentlogin,LecturerLogin;
	private Toolbar mToolbar;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.homelogin);
		GlobalVariables ob = new GlobalVariables();
		studentlogin = (Button) findViewById(R.id.studentslogin);
		parentlogin = (Button) findViewById(R.id.parentslogin);
		LecturerLogin = (Button) findViewById(R.id.LecturerLogin);
		LecturerLogin.setOnClickListener(new View.OnClickListener() {
			@Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(HomeLoign.this, TeacherLogin.class);
                startActivity(intent);
            }
		});
		studentlogin.setOnClickListener(new View.OnClickListener() {
			@Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(HomeLoign.this, TeacherLogin.class);
                startActivity(intent);

            }

		});
		parentlogin.setOnClickListener(new View.OnClickListener() {
			@Override
            public void onClick(View v) {
				Intent intent = new Intent(HomeLoign.this, TeacherLogin.class);
				startActivity(intent);            }
		});


	}


}
