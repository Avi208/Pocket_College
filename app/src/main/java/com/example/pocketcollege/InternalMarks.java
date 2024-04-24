package com.example.pocketcollege;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.logging.Handler;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;

import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class InternalMarks extends Activity {


	final Context context = this;
	private TextView AverageCount;
	int incre = 1;
	Handler handler;
	Runnable run;
	int counter = 0;
	int total = 0;
	private String firstmid;
	private int total123;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.internalmarks);
		AverageCount= (TextView) findViewById(R.id.numnercount);

		Spinner dropdown = (Spinner) findViewById(R.id.subject);
		GlobalVariables newObj = (GlobalVariables) getApplication();
		setInternalMarks(newObj);
		String[] items = newObj.getUserSubjects();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, items);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		dropdown.setAdapter(adapter);

		AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() 
		{

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub

				String subject_pos = String.valueOf(arg2);


				String[] Loginvalues = { "",""};


					int counter = 0;
					int total = 0;
					new GetIA().execute(Loginvalues);


			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		};

		dropdown.setOnItemSelectedListener(listener);		
		//revmob = RevMob.start(this);
		//RevMobBanner banner = revmob.createBanner(this);
		//ViewGroup view = (ViewGroup) findViewById(R.id.banner);
		//view.addView(banner);
		//revmob.showFullscreen(this);
	}

	private void setInternalMarks(GlobalVariables newObj) {
		String[] stringArray = {
				"Database Management Systems",
				"Java Programming",
				"Formal Languages & Automata Theory",
				"Computer Organization & Architecture",
				"Principles of Programming Languages",
				"Database Management Systems Lab",
				"Java Programming Lab",
				"Human Values & Professional Ethics (Audit Course)",
				"Design and Analysis of Algorithms"
		};
		newObj.setUserSubjects(stringArray);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	public void init(String[] iaMarks, String average) {

		final int ten_dp = (int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 10, getResources()
						.getDisplayMetrics());
		LinearLayout ll = (LinearLayout) findViewById(R.id.table);
		ll.removeAllViews();
		LayoutParams lp2 = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT);
		lp2.setMargins(0, ten_dp, 0, ten_dp / 10);

		ll.removeAllViews();
		if(average.equals("")){
			total=0;
			AverageCount.setText("");
		}

		for (int i = 0; i < iaMarks.length; i++) {
			JSONObject period;
			TableRow.LayoutParams lp = new TableRow.LayoutParams(
					TableRow.LayoutParams.WRAP_CONTENT);

			if (i == 0) {
				LinearLayout row = new LinearLayout(this);
				row.setOrientation(LinearLayout.HORIZONTAL);
				row.setLayoutParams(lp2);
				TextView tv = new TextView(this);
				tv.setText("Test");

				tv.setWidth(13 * ten_dp);
				tv.setGravity(Gravity.CENTER);
				TextView td = new TextView(this);
				td.setGravity(Gravity.RIGHT);
				td.setText("Marks");
				td.setWidth(20 * ten_dp);
				td.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
				tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
				tv.setTextColor(Color.parseColor("#e6e6e6"));
				td.setTextColor(Color.parseColor("#e6e6e6"));

				row.addView(tv);

				row.addView(td);

				ll.addView(row, i);
			}
			LinearLayout row = new LinearLayout(this);
			row.setOrientation(LinearLayout.HORIZONTAL);
			row.setLayoutParams(lp2);
			TextView tv = new TextView(this);
			int j = i + 1;
			tv.setText("MID" + j);
			tv.setTextColor(Color.BLACK);
			tv.setGravity(Gravity.CENTER);
			tv.setHeight(5 * ten_dp);
			tv.setPadding(ten_dp, ten_dp, 0, 0);
			tv.setLayoutParams(new LayoutParams(4 * ten_dp,
					LayoutParams.WRAP_CONTENT, .3f));
			tv.setPadding(ten_dp, ten_dp, 3 * ten_dp / 10, ten_dp);
			tv.setBackgroundColor(Color.parseColor("#006064"));


			TextView td = new TextView(this);
			td.setGravity(Gravity.CENTER);

			td.setText(iaMarks[i]);
			td.setBackgroundColor(Color.parseColor("#ffffff"));
			td.setPadding(ten_dp, ten_dp, 0, 0);
			td.setLayoutParams(new LayoutParams(4 * ten_dp,
					LayoutParams.WRAP_CONTENT, .3f));
			td.setPadding(ten_dp, ten_dp, 3 * ten_dp / 10, ten_dp);
			tv.setTextColor(Color.WHITE);
			td.setTextColor(Color.BLACK);
			td.setWidth(13 * ten_dp);
			td.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
			tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
			row.addView(tv);

			row.addView(td);

			ll.addView(row, i + 1);

		}
		LinearLayout row = new LinearLayout(this);
		row.setOrientation(LinearLayout.HORIZONTAL);
		row.setLayoutParams(lp2);
		TextView ta = new TextView(this);

		ta.setText("Average Marks: "/* + average*/);
		if(average.equals("null") ){
			total=0;
			System.out.println("error000");
			AverageCount.setText("" + total);
		}else {
			try {
				total=NumberFormat.getInstance().parse(average).intValue();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		try {


				total123= NumberFormat.getInstance().parse(average).intValue();
			if(total123==0 ){
				total=0;
				AverageCount.setText("" + total);
			}else {
				total=total123;
			}
			//total= 22;
			counter=0;

		} catch (ParseException e) {
			e.printStackTrace();
		}
		ta.setWidth(18 * ten_dp);
		ta.setTextColor(Color.parseColor("#ffffff"));
		ta.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17);
		ta.setGravity(Gravity.CENTER_HORIZONTAL);
		row.addView(ta);
		ll.addView(row, iaMarks.length + 1);

		//total=Integer.parseInt(average);
	//	int a = (int) Math.round(Float.parseFloat(average));
	//	System.out.println("777777777777777777777" + a);
		try {

			new Thread(new Runnable() {

				public void run() {
					while (counter < total) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						AverageCount.post(new Runnable() {

							public void run() {
								AverageCount.setText("" + counter);

							}

						});
						counter++;
					}

				}

			}).start();

		}catch (Exception e){

		}


	}


	public class GetIA extends AsyncTask<String, Integer, JSONObject> {


		JSONObject json = null;

		ProgressDialog progressDialog = new ProgressDialog(context);

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();

			progressDialog.setMessage("Processing... Please Wait...");
			progressDialog.show();

		}

		@Override
		protected JSONObject doInBackground(String... params) {
			// TODO Auto-generated method stub


			try {

				json = getIA();
			}  catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return json;
		}

		@Override
		protected void onPostExecute(JSONObject result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			progressDialog.dismiss();
			if (result == null) {
				GlobalVariables newObj = (GlobalVariables) getApplication();
				newObj.alertDialog(context);
			} else {
				try {
					String status = result.getString("status");
					if (status.equals("error")) {

						System.out.println("Avaiunsh"+status);
					} else {
						System.out.println(status);
						JSONArray iaMarks = result.getJSONArray("ia_marks");
						JSONObject period;
						period = iaMarks.getJSONObject(0);

					//	String average = result.getString("average");
					//	String averageRound = round(average);

						String firstmid = period.getString("firstmid");
						String firstmidRound = round(firstmid);
						String secondmid = period.getString("secondmid");
						System.out.println("9999999999999999"+secondmid);
						String average = period.getString("average");
						String averageround = round(average);
						String secondmidRound = round(secondmid);
						String[] iaMarkss={firstmidRound,secondmidRound};
						int[] iaMarks123 = new int[30];
					//	float f1 = Float.parseFloat(iaMarkss[0]);
					//	float f2 = Float.parseFloat(iaMarkss[1]);
					//	int firstmindround = Math.round(f1);
					//	int secoundmindround = Math.round(f2);
						//int[] iaMarksfuck = {firstmindround, secoundmindround};
					//	String[] iaMarks={firstmid,"23"};
						init(iaMarkss,averageround);
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		private String round(String numberOFString) {
			String returnval;
			if(numberOFString.equals("null")){
				returnval=" ";
			}else if(numberOFString.equals("0")){
				returnval="";
			}
			else{
				if(numberOFString.equals("")){
					returnval="";
				}else{
					System.out.println("555555555555555555555555555555"+numberOFString);
					Float no=Float.parseFloat(numberOFString);
					int rounded=Math.round(no);
					System.out.println("rounded this"+rounded);
					String intToString= String.valueOf(rounded);
					returnval=intToString;
				}


			}


			return returnval;
		}

		public JSONObject getIA() throws JSONException {


				// Add your data
					String data = "{\n" +
							"  \"status\": \"ok\",\n" +
							"  \"response\": \"IA Marks Fetched Successfully!\",\n" +
							"  \"ia_marks\": [\n" +
							"    {\n" +
							"      \"firstmid\": 26,\n" +
							"      \"secondmid\": 27,\n" +
							"      \"average\": 27\n" +
							"    }\n" +
							"  ]\n" +
							"}";
							JSONObject statusValue = new JSONObject(data);
					System.out.println(statusValue);
					return statusValue;



		}

	}

}
