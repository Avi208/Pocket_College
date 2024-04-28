package com.example.pocketcollege;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MailToParents extends Activity {

    private Spinner studentSpinner;
    private EditText emailEditText;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_to_parents);

        // Initialize views
        studentSpinner = findViewById(R.id.studentSpinner);
        emailEditText = findViewById(R.id.emailEditText);
        sendButton = findViewById(R.id.sendButton);

        // Populate spinner with student names
        List<String> studentNames = new ArrayList<>();
        studentNames.add("Harsha");
        studentNames.add("Darshan ");
        studentNames.add("Harshitha ");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, studentNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        studentSpinner.setAdapter(adapter);

        // Set listener for spinner item selection
        studentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // You can add your logic here when a student is selected
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Set click listener for send button
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }

    private void sendEmail() {
        String selectedStudent = studentSpinner.getSelectedItem().toString();
        String email = emailEditText.getText().toString().trim();

        // Perform basic email validation
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create an intent with the ACTION_SENDTO action
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntent.putExtra(Intent.EXTRA_CC, "avinashr167@mail.com");

        // You can set additional email fields like subject and body
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Message for " + selectedStudent);
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear " + selectedStudent + getString(R.string.MAIL_BODY) + ",\n\n");
        emailIntent.setType("message/rfc822");
      //  emailIntent.setType("text/plain");
        // Verify if there's an email client installed on the device to handle the intent
        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(emailIntent);
        } else {
            // If no email client is available, show a toast message
            startActivity(Intent.createChooser(emailIntent, "Choose an Email client :"));

            Toast.makeText(this, "No email client installed", Toast.LENGTH_SHORT).show();
        }
    }
}