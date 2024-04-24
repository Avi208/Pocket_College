package com.example.pocketcollege;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;




import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;


public class View_notice extends Activity {

	//String mainMenu[] = {"Time Table", "IA Marks", "Attendance"};
	private Toolbar mToolbar;
	final Context context = this;
	@Override
	protected void onCreate(Bundle savedInstanceState)

	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_notice);
		mToolbar= (Toolbar) findViewById(R.id.notiaction);
		mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onBackPressed();
			}
		});
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		GlobalVariables newObj = (GlobalVariables) getApplication();
		String userId = newObj.getUserId();
		String token = newObj.getUserToken();
		String[] LoginVal = { userId, token };

		new GetNotice().execute(LoginVal);


	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	public void init(JSONArray notice_arr) {
		System.out.println("Inside init");
		// TableLayout ll = (TableLayout) findViewById(R.id.table);
		LinearLayout ll = (LinearLayout) findViewById(R.id.table);
		// ll.setOrientation(2);

		String brief[] = new String[200];

		final String title[] = new String[200];
		final String content[] = new String[200];
		final String issued_on[] = new String[200];
		final String pathDOC[] = new String[200];
		final String owner[] = new String[200];
		final int ten_dp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources()
				.getDisplayMetrics());
		int i;
		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		lp.setMargins(ten_dp, ten_dp, 6 * ten_dp / 10, 0);
		LayoutParams lp2 = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		System.out.println("length" + notice_arr.length());
		for (i = 0; i < notice_arr.length(); i++) {
			JSONObject period;
			try {
				System.out.println("Inside loop " + i);
				period = notice_arr.getJSONObject(i);
				title[i] = period.getString("title");
				content[i] = period.getString("content");
				pathDOC[i]=period.getString("path");
				content[i].replaceAll("\\<[^>]*>","");
				//brief[i] = period.getString("brief");
				issued_on[i] = period.getString("issued_on");
				owner[i] = period.getString("owner");
				LinearLayout LL = new LinearLayout(this);
				LL.setBackgroundColor(Color.parseColor("#40404000"));
				LL.setOrientation(LinearLayout.VERTICAL);
				LL.setClickable(true);
				LL.setId(i);
				LL.setLayoutParams(lp);
				LL.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						final int j = v.getId();
						// TODO Auto-generated method stub
						final Dialog dialog = new Dialog(context);
						dialog.setContentView(R.layout.customevent);
						dialog.setTitle(title[j]);
						TextView text1 = (TextView) dialog
								.findViewById(R.id.issued_on);
						text1.setText(issued_on[j]);
						TextView text2 = (TextView) dialog
								.findViewById(R.id.published_by);
						text2.setText(owner[j]);
						// set the custom dialog components - text, image and
						// button
						// TextView date_issued = (TextView)
						// dialog.findViewById(R.id.issued_on);
						TextView text = (TextView) dialog
								.findViewById(R.id.content);
						text.setText(content[j]);


						// ImageView image = (ImageView)
						// dialog.findViewById(R.id.image);
						// image.setImageResource(R.drawable.ic_launcher);

						final Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
						Button dialogButton2 = (Button) dialog.findViewById(R.id.dialogButtonView);
						// if button is clicked, close the custom dialog
						dialogButton
								.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View v) {
										dialog.dismiss();
									}
								});
						dialogButton2
								.setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View v) {
									//	Toast.makeText(getApplicationContext(),"inside",Toast.LENGTH_LONG ).show();
										WebView webview = (WebView) dialog.findViewById(R.id.viewdoc);
										String myPdfUrl = pathDOC[j];
										String url = "http://docs.google.com/gview?embedded=true&url=" + myPdfUrl;
										//Log.i(TAG, "Opening PDF: " + url);
										webview.getSettings().setJavaScriptEnabled(true);
										webview.loadUrl(url);
									}
								});


						dialog.show();
					}
				});
				TextView tv = new TextView(this);
				int j = i + 1;
				tv.setText(title[i]);
				// tv.setBackgroundResource(R.drawable.period_1_bg);
				tv.setGravity(Gravity.LEFT);
				tv.setHeight(8 * ten_dp);
				tv.setPadding(ten_dp, ten_dp, 0, 0);
				tv.setWidth(20 * ten_dp);

				TextView td = new TextView(this);
				td.setGravity(Gravity.LEFT);
				td.setHeight(5 * ten_dp);
				td.setPadding(ten_dp, 3 * ten_dp / 10, 0, 0);
				td.setWidth(20 * ten_dp);
				// td.setBackgroundResource(R.drawable.subject_bg);
				td.setText(brief[i]);

				LinearLayout l2 = new LinearLayout(this);
				l2.setLayoutParams(lp);
				TextView ts = new TextView(this);
				ts.setHeight(3 * ten_dp);
				ts.setWidth(10 * ten_dp);
				ts.setGravity(Gravity.LEFT);
				ts.setText(issued_on[i]);
				TextView tr = new TextView(this);
				tr.setHeight(3 * ten_dp);
				tr.setWidth(12 * ten_dp);
				tr.setGravity(Gravity.RIGHT);
				tr.setText("Read more..");
				tr.setPadding(3 * ten_dp, 0, 3 * ten_dp / 10, ten_dp);
				tv.setTextColor(Color.WHITE);
				td.setTextColor(Color.parseColor("#E5E5E5"));
				ts.setTextColor(Color.WHITE);
				tr.setTextColor(Color.WHITE);
				l2.addView(ts);
				l2.addView(tr);

				LL.addView(tv);
				LL.addView(td);
				LL.addView(l2);

				ll.addView(LL, i);

			}
			catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public class GetNotice extends AsyncTask<String, Integer, JSONObject>

	{
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
			//		System.out.println("Inside do_backgrnd");


            try {
                json = getNotice();
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            return json;
		}

		@Override
		protected void onPostExecute(JSONObject result)
		{
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			progressDialog.dismiss();
			if (result == null)
			{
				GlobalVariables newObj = (GlobalVariables) getApplication();
				newObj.alertDialog(context);
			}
			else
			{

				try {
					String status = result.getString("status");

					if (status.equals("error"))
					{

						System.out.println("Login Failed");
					}else if(status.equals("No_Data")){
						GlobalVariables newObj = (GlobalVariables) getApplication();
						newObj.alertNORECORDS(context);
					}
					else
					{
						JSONArray notice_arr = result.getJSONArray("notice");

						init(notice_arr);
					}
				} catch (JSONException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		public JSONObject getNotice() throws JSONException {

				String data = "{\n" +
						"    \"status\": \"ok\",\n" +
						"    \"response\": \"Fetched Notice\",\n" +
						"    \"notice\": [\n" +
						"        {\n" +
						"            \"title\": \"Prepare Late Comers List.\",\n" +
						"            \"content\": \"Madhu,rrrSend the Late Comers List of Boys and Girls Who stays in Hostel Block Wise. The Management is taking the Disciplinary action who ever coming the Hostel late in the night . All the Students should be present in side the Hostel Before 9:15 Pm all the Days. \",\n" +
						"            \"owner\": \"Dr P.Mallikarjuna Reddy\",\n" +
						"            \"issued_on\": \"07/29/2016\",\n" +
						"            \"path\": \"http://www.pocketcollege.in/pvkk/\"\n" +
						"        },\n" +
						"        {\n" +
						"            \"title\": \"List of Students Details.\",\n" +
						"            \"content\": \"Rajgopal,rrrSend the Boys and Girls Details of each Hostel in the Campus.rrrrYours,rrPrincipal.\",\n" +
						"            \"owner\": \"Dr P.Mallikarjuna Reddy\",\n" +
						"            \"issued_on\": \"07/29/2016\",\n" +
						"            \"path\": \"http://www.pocketcollege.in/pvkk/\"\n" +
						"        },\n" +
						"        {\n" +
						"            \"title\": \"Appointment schedule\",\n" +
						"            \"content\": \"HI,rrToday i will allow visitors only between 10:30am to 12:30pm. \",\n" +
						"            \"owner\": \"Dr P.Mallikarjuna Reddy\",\n" +
						"            \"issued_on\": \"07/25/2016\",\n" +
						"            \"path\": \"http://www.pocketcollege.in/pvkk/\"\n" +
						"        },\n" +
						"        {\n" +
						"            \"title\": \"Greetings\",\n" +
						"            \"content\": \"CONGRATULATIONSManagement, Principal and Staff of PVKKIT congratulates the 23 Students who got selected in the Off campus drive by TECH MAHINDRA on 09-05-2016CONGRATULATIONS14 Students got selected in the Off Campus RECRUITMENT drive conducted by INSPIREDGE IT SOLUTIONS on\",\n" +
						"            \"owner\": \"Dr P.Mallikarjuna Reddy\",\n" +
						"            \"issued_on\": \"05/31/2016\",\n" +
						"            \"path\": \"http://www.pocketcollege.in/pvkk/notice/notice13315460_1003230216398072_1577787957195727420_n.jpg\"\n" +
						"        }\n" +
						"    ]\n" +
						"}";

					JSONObject statusValue = new JSONObject(data);

					System.out.println("******from data base*****"+statusValue);
					return statusValue;



			}

	}

}


