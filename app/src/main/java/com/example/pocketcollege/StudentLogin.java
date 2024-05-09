package com.example.pocketcollege;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;


public class StudentLogin extends FragmentActivity {

	Button submit_login;
	private static TextView validateUser;
	final Context context = this;
	Toolbar mToolbar;
	private Button forgotPassword;
	private SharedPreferences sharedPreferences;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.studentlogin);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			Window window = getWindow();
			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			window.setStatusBarColor(ContextCompat.getColor(this, R.color.cardviewcolor));
			window.setNavigationBarColor(ContextCompat.getColor(this, R.color.cardviewcolor));
		}
		sharedPreferences=getSharedPreferences("MyPrefsFile", Context.MODE_PRIVATE);
		submit_login = (Button) findViewById(R.id.b_login);

		validateUser = (TextView) findViewById(R.id.loginStatus);
		forgotPassword=(Button)findViewById(R.id.forgottenPassword);
		validateUser.setText("Enter UserName and Password");

		submit_login.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub.
				EditText usr_number = (EditText) findViewById(R.id.user_name);
				EditText password_main = (EditText) findViewById(R.id.user_pass);
				String username = usr_number.getText().toString();
				String password = password_main.getText().toString();
				String getUserNamefromSharedPreferences = sharedPreferences.getString("s_username", "");
				String getPasswordfromSharedPreferences = sharedPreferences.getString("s_password", "");
				if (getUserNamefromSharedPreferences.equals(username) && getPasswordfromSharedPreferences.equals(password)) {
					startActivity(new Intent(StudentLogin.this, Welcome_Screen.class));
				}
				else {
					Toast.makeText(StudentLogin.this, "UserID and Password requested", Toast.LENGTH_SHORT).show();
				}
			}
		});
		forgotPassword.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				UpdateCredentialsBottomSheetDialog dialog = new UpdateCredentialsBottomSheetDialog(context, sharedPreferences,
						"STUDENT_PARENT_LOGIN");
				dialog.show(getSupportFragmentManager(), "update_credentials_dialog");
			}
		});
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	public void setText(String result) 
	{

		if (result.equals("Login Failed")) { 
			// or whatever it is supposed to
			// equal if
			// it's ok
			// set your text to whatever, you are ok
			System.out.println("Login Failed");

			validateUser.setText("Login Failed");
			
		}
		else
		{
			
		}
	}

	/*public class CheckUsername extends AsyncTask<String, Integer, String> {

		HttpClient Client;
		JSONObject json;
	//	final static String URL = "http://pocketcollege.in/api/";
	//	final static String URL = "http://192.168.1.105/api/";
	//	final static String URL = "http://192.168.1.108/pcapi/api/";
		final static String URL = "http://pocketcollege.in/madhu/index.php/pocketcollege/faculty_login";
		ProgressDialog progressDialog = new ProgressDialog(context);

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();

			progressDialog.setMessage("Processing... Please Wait...");
			progressDialog.show();
		}

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			String username = params[0].toString();
			String password = params[1].toString();
			String status = null;
			GlobalVariables newObj = (GlobalVariables) getApplication();

			if (newObj.checkNetwork()) 
			
			{
				System.out.println("Checked and am inside");
				Client = new DefaultHttpClient();
			
				try
				{
     				json = ValidateUsername(username, password);
					if (json == null)
					{
						status = "NoNet";
					}
					else
					{
						status = json.getString("status");
						System.out.println(status);
						System.out.println(json.getString("teacher"));
					
						if (status.equals("ok")) 
						
						{
							JSONObject user_values = new JSONObject(
							json.getString("teacher"));
					       newObj.setTeacherID(user_values.getString("id"));
					       newObj.setTeacherName(user_values.getString("name"));
					       newObj.setTeacher_branchID(user_values.getString("branch_id"));
					       newObj.setTeacher_CollegeID(user_values.getString("college_id"));
							newObj.setTeacherPhoto(user_values.getString("photo"));
							newObj.setTeacherEmail(user_values.getString("email"));


						}
					}
					System.out.println(status);
				} catch (ClientProtocolException e)
				{
					// TODO Auto-generated catch block
					System.out
							.println("Checked and am inside ClientProtocolException");
					e.printStackTrace();
				} catch (IOException e) 
				{
					// TODO Auto-generated catch block
					System.out.println("Am i here");
					System.out.println("Checked and am inside IOException");
					e.printStackTrace();
				} catch (JSONException e)
				{
					// TODO Auto-generated catch block
					System.out.println("Checked and am inside JSONException");
					e.printStackTrace();
				}
			}
			else
			{
				status = "NoNet";
			}

			return status;

		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);

			if (result.equals("error"))
			{
				progressDialog.dismiss();
				setText("Login Failed");
				Snackbar.with(getApplicationContext()) // context
						.text("Login Failed") // text to display
						.textColor(Color.parseColor("#ffffff"))
						.color(Color.parseColor("#056b8f"))
						.show(TeacherLogin.this);
			}
			else if (result.equals("ok")) {
				Thread loggedIn = new Thread() {

					public void run() {
						try {
							sleep(1);
						} catch (InterruptedException e) {
							// TODO: handle exception
							e.printStackTrace();
						} finally {
							progressDialog.dismiss();
					//		Toast.makeText(getBaseContext(), "Login Success\nWelcome", Toast.LENGTH_LONG).show();
							GlobalVariables newObj = (GlobalVariables) getApplication();

						//	System.out.println("Session Status in Login Page" + newObj.studentSessionStatus);

							newObj.teacherSessionStatus=true;
							Intent openMainActivity = new Intent(
									"com.prakyath.pocketcollege.TEACHERWELCOMESCREEN");
							
							startActivity(openMainActivity);
						}
					}
					
					
				};
				loggedIn.start();

			} else if (result.equals("NoNet")) {

				System.out.println("Nonet");
				GlobalVariables newObj = (GlobalVariables) getApplication();
				newObj.alertDialog(context);

			}

		}

		public JSONObject ValidateUsername(String username, String password)
				throws ClientProtocolException, IOException, JSONException {
			StringBuilder url = new StringBuilder(URL);
			HttpPost post = new HttpPost(url.toString());
			try {
				// Add your data
				System.out.println("username"+username);
				System.out.println("password"+password);
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(
						2);
				nameValuePairs.add(new BasicNameValuePair("token", "ABCD"));
				nameValuePairs.add(new BasicNameValuePair("func_name","validate_faculty"));
				nameValuePairs
						.add(new BasicNameValuePair("username", username));
				nameValuePairs
						.add(new BasicNameValuePair("password", password));
				post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

				// Execute HTTP Post Request
				HttpResponse response = Client.execute(post);
				int status = response.getStatusLine().getStatusCode();
				if (status == 200) {
					HttpEntity e = response.getEntity();
					String data = EntityUtils.toString(e);
					
					System.out.println("Data-->"+data);

					JSONObject statusValue = new JSONObject(data);
					return statusValue;
				}
				else
				{
					System.out.println("Ofter Json"+status);
					return null;
				}

			} 
			catch (ClientProtocolException e)
			{
				// TODO Auto-generated catch block
				System.out
						.println("Checked and am inside ClientProtocolException");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Checked and am inside IOException");
				e.printStackTrace();
			}
			return null;
		}

	}*/
}