package com.example.pocketcollege;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.example.pocketcollege.Response.FetchResponseToTables;
import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;


public class Student_View_attendance extends Activity {

    TextView test;
    final Context context = this;
    private Toolbar mToolbar;
    private NiftyDialogBuilder dialogBuilder;
    Effectstype effect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_attendance);
        Context context1 = getApplicationContext();

        Spinner dropdown = (Spinner) findViewById(R.id.month);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mToolbar = (Toolbar) findViewById(R.id.attendence);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        String[] items = new String[]{" ", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        dropdown.setAdapter(adapter);
        Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
        int currentMonth = localCalendar.get(Calendar.MONTH) + 1;
        dropdown.setSelection(currentMonth);

        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                GlobalVariables newObj = (GlobalVariables) getApplication();
                String userId = newObj.getUserId();
                String month = String.valueOf(arg2);

                String token = newObj.getUserToken();
                String[] LoginVal = {userId, month, token};
                if (true) {
                    new GetAttendance().execute(LoginVal);
                    try {
                        ModuleToFetchStudentAttadence();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } else {
                    newObj.alertDialog(context);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        };

        dropdown.setOnItemSelectedListener(listener);

    }

    private void ModuleToFetchStudentAttadence() throws JSONException {

        JSONObject json = null;
        String data = FetchResponseToTables.studentAttedence;
        System.out.println(data);
        JSONObject statusValue = new JSONObject(data);
        json = statusValue;
        try {
            String status = json.getString("status");
            if (status.equals("error")) {

                System.out.println("Login Failed");
            } else if (status.equals("No_Data")) {
						/*GlobalVariables newObj = (GlobalVariables) getApplication();
						newObj.alertNORECORDS(context);*/
                showDialogBox("No Record to Display", 0);
						/*new SweetAlertDialog(this, Student_View_attendance.ERROR_TYPE)
								.setTitleText("Oops...")
								.setContentText("Something went wrong!")
								.show();
*/
            } else {
                JSONArray attendance_arr = json.getJSONArray("attandence");
                //JSONArray attendance_arr1 = result.getJSONArray("error");
                init(attendance_arr);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void showDialogBox(String message, int seconds) {
        dialogBuilder = NiftyDialogBuilder.getInstance(Student_View_attendance.this);

        dialogBuilder
                //.withTitle("ss").requestWindowFeature(Window.FEATURE_NO_TITLE)
                .withTitle("Sorry..!")
                .withMessage(message)
                .withMessageColor("#FFFFFF")
                .withDialogColor(Color.parseColor("#0bb6d7"))
                .isCancelableOnTouchOutside(false)
                .withDuration(700)
                .withEffect(effect)
                //.withButton1Text("OK")
                .withButton2Text("OK")
                .setCustomView(R.layout.custom_viewnotification, Student_View_attendance.this)
                /*.setButton1Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogBuilder.dismiss();
                        *//*Intent in = new Intent(NotificationReceiveActivity.this, MainActivity.class);
							in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
							startActivity(in);*//*
						}
					})*/
                .setButton2Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialogBuilder.dismiss();

                    }
                })
                .show();

    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
    }

    public void init(JSONArray attendance_arr) {
        List<String> list = new ArrayList<String>();
        final int ten_dp = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 10, getResources()
                        .getDisplayMetrics());
        LinearLayout ll = (LinearLayout) findViewById(R.id.table);
        ll.removeAllViews();
        LayoutParams lp2 = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        lp2.setMargins(ten_dp, ten_dp, 0, ten_dp / 10);

        for (int i = 0; i < attendance_arr.length(); i++) {
            JSONObject period;
            try {
                period = attendance_arr.getJSONObject(i);

                String sub_name = period.getString("subject_name");
                String present_days = period.getString("present");
                //	String percentage = period.getString("percentage");
                System.out.println("Student_View_attendance.init" + sub_name);
                String total_days = period.getString("total_class");
                int persent = Integer.parseInt(present_days);
                int totalDay = Integer.parseInt(total_days);
                //int percentage =  ((persent/totalDay) * 100);
                int percentage = percentcalculate(persent, totalDay);

                if (sub_name.equals("null")) {

                    sub_name = "No Class";
                    System.out.println("Student_View_attendance.init" + sub_name);
                }
                if (present_days.contentEquals("null")) {
                    present_days = "0";
                }
                if (total_days.contentEquals("null")) {
                    total_days = "0";
                }
				/*if (percentage.contentEquals("null"))
				{
					percentage = "0";
				}*/


                //list.add(percentage);

//
//				float per=Float.parseFloat(percentage);
//				if(per<75.00){
//					System.out.println("low percentage"+per);
//
//				}

				/*System.out.println(sub_name + "--" + present_days + "--"
						+ total_days + percentage + "%");*/

                //	System.out.println((percentage == (sub_name / present_days) * 100));

                TableRow.LayoutParams lp = new TableRow.LayoutParams(
                        TableRow.LayoutParams.WRAP_CONTENT);
                lp.setMargins(0, ten_dp, 0, 2 * ten_dp);
                LinearLayout row = new LinearLayout(this);
                row.setOrientation(LinearLayout.HORIZONTAL);
                row.setLayoutParams(lp2);
                TextView tv = new TextView(this);
                tv.setText(sub_name);
                tv.setBackgroundColor(Color.parseColor("#ffffff"));
                tv.setGravity(Gravity.LEFT);
                tv.setHeight(5 * ten_dp);
                tv.setPadding(ten_dp, ten_dp, 3 * ten_dp / 10, ten_dp);
                tv.setPadding(ten_dp, ten_dp, 0, 0);
                tv.setLayoutParams(new LayoutParams(14 * ten_dp,
                        LayoutParams.WRAP_CONTENT, .7f));
                TextView ts = new TextView(this);
                ts.setText(" ");
                ts.setPadding(ten_dp / 2, 0, 0, 0);
                TextView td = new TextView(this);
                td.setGravity(Gravity.LEFT);
                td.setTextSize(10);
                td.setHeight(5 * ten_dp);
                td.setPadding(ten_dp, ten_dp, 0, 0);
                td.setLayoutParams(new LayoutParams(4 * ten_dp,
                        LayoutParams.WRAP_CONTENT, .3f));
                td.setPadding(ten_dp, ten_dp, 3 * ten_dp / 10, ten_dp);
                td.setBackgroundColor(Color.parseColor("#006064"));
                td.setText(present_days + "/" + total_days + " =  " + percentage + "%");
                tv.setTextColor(Color.BLACK);
                td.setTextColor(Color.WHITE);
                row.addView(tv);
                row.addView(ts);
                row.addView(td);

                ll.addView(row, i);


                //		System.out.println(percentage);


            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        String[] stringArray = list.toArray(new String[list.size()]);
        Boolean findpercentage = false;
        //System.out.println(Arrays.toString( stringArray ));
        for (int i = 0; i < list.size(); i++) {
            float test = Float.parseFloat(String.valueOf(list.get(i)));
            //System.out.println("Value of element--------> "+list.get(i));
            if (test < 75) {
                findpercentage = true;
                System.out.println("Value of element " + test);
            }

        }
        if (findpercentage) {
            AlertDialog.Builder builder = new AlertDialog.Builder(
                    Student_View_attendance.this);
            builder.setTitle("Warning!");
            builder.setMessage("Your Attendence is Less then 75%");
            builder.setIcon(R.drawable.ic_launcher);
            builder.setPositiveButton("Cancel",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,
                                            int which) {
                            Log.e("Blocked Clicked", "OK");
                        }
                    });

            builder.show();
        }

    }

    private int percentcalculate(int persent, int totalDay) {
        int per = 0;
        per = (persent * 100) / totalDay;

        return per;
    }


    public class GetAttendance extends AsyncTask<String, Integer, JSONObject> {


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

           ;


            try {
                json = getTimeTable();
            } catch (Exception e) {
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

                        System.out.println("Login Failed");
                    } else if (status.equals("No_Data")) {
						/*GlobalVariables newObj = (GlobalVariables) getApplication();
						newObj.alertNORECORDS(context);*/
                        showDialogBox("No Record to Display", 0);
						/*new SweetAlertDialog(this, Student_View_attendance.ERROR_TYPE)
								.setTitleText("Oops...")
								.setContentText("Something went wrong!")
								.show();
*/
                    } else {
                        JSONArray attendance_arr = result.getJSONArray("attandence");
                        //JSONArray attendance_arr1 = result.getJSONArray("error");
                        init(attendance_arr);
                    }
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }


        public JSONObject getTimeTable() throws JSONException {
			String data = "{\n" +
					"    \"status\": \"ok\",\n" +
					"    \"response\": \"Fetched Successfully!\",\n" +
					"    \"attandence\": [\n" +
					"        {\n" +
					"            \"subject_name\": \"Database Management Systems\",\n" +
					"            \"subject_code\": \"13A05402\",\n" +
					"            \"date\": \"04/05/2016\",\n" +
					"            \"present\": \"4\",\n" +
					"            \"total_class\": \"6\"\n" +
					"        },\n" +
					"        {\n" +
					"            \"subject_name\": \"java Lab\",\n" +
					"            \"subject_code\": \"13A05402\",\n" +
					"            \"date\": \"04/05/2016\",\n" +
					"            \"present\": \"2\",\n" +
					"            \"total_class\": \"6\"\n" +
					"        }\n" +
					"    ]\n" +
					"}";
			JSONObject statusValue = new JSONObject(data);
            return statusValue;
        }

    }

}
