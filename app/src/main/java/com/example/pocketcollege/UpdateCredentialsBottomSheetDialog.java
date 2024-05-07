package com.example.pocketcollege;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class UpdateCredentialsBottomSheetDialog extends BottomSheetDialogFragment {

    private Context context;
    private SharedPreferences sharedPreferences;

    private EditText usernameEditText;
    private EditText passwordEditText;
    private String LOGIN_FLAG;

    public UpdateCredentialsBottomSheetDialog(Context context, SharedPreferences sharedPreferences,
                                              String FLAG) {
        this.context = context;
        this.sharedPreferences = sharedPreferences;
        this.LOGIN_FLAG = FLAG;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_update_credentials, container, false);

        usernameEditText = view.findViewById(R.id.username_edit_text);
        passwordEditText = view.findViewById(R.id.password_edit_text);

        // Set the current username and password in the EditText fields
        usernameEditText.setText(sharedPreferences.getString("username", ""));
        passwordEditText.setText(sharedPreferences.getString("password", ""));

        Button updateButton = view.findViewById(R.id.update_button);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // add basic validation
                if (usernameEditText.getText().toString().isEmpty() ) {
                    usernameEditText.setError("Username is required");
                    return;
                }else if (passwordEditText.getText().toString().isEmpty()) {
                    passwordEditText.setError("Password is required");
                    return;
                }
               if(LOGIN_FLAG.equals("TEACHER_LOGIN")) {
                   // Update the username and password in shared preferences
                   sharedPreferences.edit()
                           .putString("t_username", usernameEditText.getText().toString())
                           .putString("t_password", passwordEditText.getText().toString())
                           .apply();

                   // Dismiss the bottom sheet dialog
                   dismiss();
               }else if(LOGIN_FLAG.equals("STUDENT_PARENT_LOGIN")){
                   // Update the username and password in shared preferences
                   sharedPreferences.edit()
                           .putString("s_username", usernameEditText.getText().toString())
                           .putString("s_password", passwordEditText.getText().toString())
                           .apply();

                   // Dismiss the bottom sheet dialog
                   dismiss();
                }
            }
        });

        return view;
    }
}