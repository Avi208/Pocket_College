package com.example.pocketcollege;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		GlobalVariables newObj = (GlobalVariables) getApplication();
		boolean Student_Status=	newObj.studentSessionStatus;
		boolean Teacher_Status=	newObj.teacherSessionStatus;
		if(!Student_Status  ){
			Intent in = new Intent(MainActivity.this, Welcome_Screen.class);
			in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(in);
			overridePendingTransition(R.anim.right, R.anim.left);
		}
		/*else if (!Student_Status){


			*//*Intent in = new Intent(MainActivity.this, WelcomePage_fragment.class);
			in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(in);
			finish();
			overridePendingTransition(R.anim.right, R.anim.left);*//*
		}
*/


}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
		return super.onOptionsItemSelected(item);
	}
}
