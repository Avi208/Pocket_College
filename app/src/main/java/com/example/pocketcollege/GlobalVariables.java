package com.example.pocketcollege;

import javax.security.auth.PrivateCredentialPermission;

import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class GlobalVariables extends Application {

	private String userToken;
	private String userId;
	private String userName;
	private String parentPhoto;
	private String studentPhoto;
	private String studentemail;

	private String[] userSubjects;
	private String[] teacherSubject;
	private String[] SubjectTime;

	private String[] userSubjects_id;
	private String[] SectionID;
	private String TeacherID;
	private String TeacherPhoto;
	private String TeacherEmail;

	private String TeacherName;
	private String[] res_teacher;
	private String[] res_teacherid;
	private String[] que_teacher;
	private String college_id;
	private String PrincipalID ;
	private String parentID ;
	private String principalName;
	private String teacher_branchID;
	private String teacher_CollegeID;
	public boolean studentSessionStatus=false;

	public boolean parentSessionStatus=false;
	public boolean teacherSessionStatus=false;
	public boolean principalSessionStatus=false;



	public Boolean status=false;

	public String getTeacher_branchID() {
		return teacher_branchID;
	}

	public void setTeacher_branchID(String teacher_branchID) {
		this.teacher_branchID = teacher_branchID;
	}



	public String getTeacher_CollegeID() {
		return teacher_CollegeID;
	}

	public void setTeacher_CollegeID(String teacher_CollegeID) {
		this.teacher_CollegeID = teacher_CollegeID;
	}

	/**
	 * @return the college_id
	 */
	public String getCollege_id() {
		return college_id;
	}

	/**
	 * @param college_id the college_id to set
	 */
	public void setCollege_id(String college_id) {
		this.college_id = college_id;
	}

	public String[] getRes_teacher() {
		return res_teacher;
	}

	public void setRes_teacher(String[]  res_teacher) {
		this.res_teacher = res_teacher;
	}

	public String getUserName()
	{
		return userName;
	}

	public String getUserId() 
	{
		//Toast.makeText(GlobalVariables.this,userId,Toast.LENGTH_LONG).show();
		return userId;
	}

	public String getUserToken()
	{
		return "ABCD";
		// return userToken;
	}

	public String getPrincipalID() {
		return PrincipalID;
	}

	public void setPrincipalID(String principalID) {
		PrincipalID = principalID;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPrincipalName() {
		return principalName;
	}

	public void setPrincipalName(String principalName) {
		System.out.println("GlobalVariables.setPrincipalName"+principalName);
		this.principalName = principalName;
	}

	public String getParentPhoto() {
		return parentPhoto;
	}

	public void setParentPhoto(String parentPhoto) {
		this.parentPhoto = parentPhoto;
	}

	public void setUserId(String userId)
	{
	//	Toast.makeText(GlobalVariables.this,userId,Toast.LENGTH_LONG).show();
		this.userId = userId;

	}

	public void setUserToken(String userToken) 
	{
		this.userToken = userToken;
	}
	
	public void setUserSubjects(String[] stringArray) 
	{
		// TODO Auto-generated method stub
		userSubjects = stringArray;


	}

	public String getTeacherEmail() {
		return TeacherEmail;
	}

	public void setTeacherEmail(String teacherEmail) {
		TeacherEmail = teacherEmail;
	}

	public String getStudentPhoto() {
		return studentPhoto;
	}

	public void setStudentPhoto(String studentPhoto) {
		this.studentPhoto = studentPhoto;
	}

	public String getStudentemail() {
		return studentemail;
	}

	public void setStudentemail(String studentemail) {
		this.studentemail = studentemail;
	}

	public String getTeacherPhoto() {
		return TeacherPhoto;
	}

	public void setTeacherPhoto(String teacherPhoto) {
		TeacherPhoto = teacherPhoto;
	}

	public String[] getTeacherSubject() {
		return teacherSubject;
	}

	public void setTeacherSubject(String[] teacherSubject) {
		this.teacherSubject = teacherSubject;
	}

	public String[] getSectionID() {
		return SectionID;
	}

	public void setSectionID(String[] sectionID) {
		SectionID = sectionID;
	}

	public String[] getUserSubjects()
	{
		return userSubjects;
	}

	// Check if Internet Network is active
	
	public boolean checkNetwork()
	{
		boolean wifiDataAvailable = false;
		boolean mobileDataAvailable = false;
		
		ConnectivityManager conManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		
		NetworkInfo[] networkInfo = conManager.getAllNetworkInfo();
		
		for (NetworkInfo netInfo : networkInfo)
		{
			if (netInfo.getTypeName().equalsIgnoreCase("WIFI"))
				
				if (netInfo.isConnected())
					wifiDataAvailable = true;
			
			if (netInfo.getTypeName().equalsIgnoreCase("MOBILE"))
				if (netInfo.isConnected())
					mobileDataAvailable = true;
		}
		return wifiDataAvailable || mobileDataAvailable;
	}

	public void alertDialog(Context context) {
		// TODO Auto-generated method stub
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

		alertDialogBuilder
				.setTitle("No internet connection")
				.setMessage("Please turn on mobile data")
				.setPositiveButton("OK",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
												int which) {
								// code for exit
								Intent intent = new Intent(
										Intent.ACTION_MAIN);
								intent.addCategory(Intent.CATEGORY_HOME);
								intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
								startActivity(intent);
							}

						}).show();


	}
	public void alertDialogfailed(Context context) {
		// TODO Auto-generated method stub
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

		alertDialogBuilder
				.setTitle("Login Failed ")
				.setMessage("Invalid Register ID . please enter valid Id ")
				.setPositiveButton("OK",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
												int which) {
								// code for exit
								/*Intent intent = new Intent(
										Intent.ACTION_MAIN);
								intent.addCategory(Intent.CATEGORY_HOME);
								intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
								startActivity(intent);*/
							}

						}).show();


	}


	public void alertDialogExit(Context context)
	{
		// TODO Auto-generated method stub
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				context);

		alertDialogBuilder
				.setTitle("Are you sure ?")
				.setCancelable(false)
				.setPositiveButton("OK",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
												int which) {
								// code for exit
								Intent intent = new Intent(
										Intent.ACTION_MAIN);
								intent.addCategory(Intent.CATEGORY_HOME);
								intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
								startActivity(intent);
							}

						})
						.setNegativeButton("No", null)
						.show();
		
	}
	public void alertDialogDisplay(Context context)
	{
		// TODO Auto-generated method stub
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				context);

		alertDialogBuilder
				.setTitle("Sorry !")
				.setMessage("This module will be Activated after one Month of the basic version usage")
				.setCancelable(false)
				.setPositiveButton("OK",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
												int which) {
								// code for exit
								/*Intent intent = new Intent(
										Intent.ACTION_MAIN);
								intent.addCategory(Intent.CATEGORY_HOME);
								intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
								startActivity(intent);*/
							}

						})
				//.setNegativeButton("No", null)
				.show();

	}

	public void alertsucessfully(Context context)
	{
		// TODO Auto-generated method stub
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				context);

		alertDialogBuilder
				.setTitle("successfull")
				.setMessage("feed back send sucessfully ")
				.setCancelable(false)
				.setPositiveButton("OK",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
												int which) {
								/*Intent newIntent16 = new Intent(
										"com.prakyath.pocketcollege.FEEDBACK");
								startActivity(newIntent16);*/

							}

						})
				.setNegativeButton("No", null)
				.show();

	}
	public void alertNORECORDS(Context context)
	{
		// TODO Auto-generated method stub
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				context);

		alertDialogBuilder
				.setTitle("NO RECORD !!!")
				.setMessage("NO RECORD TO DISPLAY......!")
				.setCancelable(false)
				.setPositiveButton("OK",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
												int which) {
								/*Intent newIntent16 = new Intent(
										"com.prakyath.pocketcollege.FEEDBACK");
								startActivity(newIntent16);*/

							}

						})
				.setNegativeButton("No", null)
				.show();

	}
	public void setTeacherID(String teacherid) {
		
		this.TeacherID=teacherid;
		
		
	}

	public String getTeacherID() {
		return TeacherID;
	}

	public void setTeacherName(String teacherName) {
		this.TeacherName=teacherName;
		
	}

	public String getTeacherName() {
		return TeacherName;
	}

	
	/**
	 * @return the que_teacher
	 */
	public String[] getQue_teacher() {
		return que_teacher;
	}

	/**
	 * @param que_teacher the que_teacher to set
	 */
	public void setQue_teacher(String[] que_teacher) {
		this.que_teacher = que_teacher;
	}

	/**
	 * @return the res_teacherid
	 */
	public String[] getRes_teacherid() {
		return res_teacherid;
	}

	/**
	 * @param res_teacherid the res_teacherid to set
	 */
	public void setRes_teacherid(String[] res_teacherid) {
		this.res_teacherid = res_teacherid;
	}


	public String[] getUserSubjects_id() {
		return userSubjects_id;
	}

	public void setUserSubjects_id(String[] userSubjects_id) {
		this.userSubjects_id = userSubjects_id;
	}

	public String getParentID() {
		return parentID;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}


}

