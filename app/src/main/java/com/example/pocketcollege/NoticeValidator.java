package com.example.pocketcollege;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NoticeValidator extends AppCompatActivity {

    private EditText notification_heading;
    private EditText notification_body;
    private Button sendButton;
    private Button submitButton;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_notice_validator);
        initVariable();
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkValidation()){
                    try {
                        fillNoticeModel();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else{
                Toast.makeText(NoticeValidator.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void fillNoticeModel() throws InterruptedException {
// Create a thread
        Thread thread = new Thread(() -> {
            NoticeDatabase database = NoticeDatabase.getDatabase(getApplicationContext());
            NoticeDao noticeDao = database.noticeDao();
            Notice notice = new Notice(generateRandomNumber(), notification_heading.getText().toString(),
                    notification_body.getText().toString(),"Notification From Management",getCurrentDateTimeString(),"");
            noticeDao.insertAll(notice);
        });
        // Start the thread
        thread.start();
        thread.join();
        clearFieldwithToast();
    }

    private int generateRandomNumber() {
            return (int) (Math.random() * 1000000000);
    }

    private void clearFieldwithToast() {
        notification_heading.setText("");
        notification_body.setText("");
        Toast.makeText(NoticeValidator.this, "Notice Sent to all Students", Toast.LENGTH_SHORT).show();
    }

    public  String getCurrentDateTimeString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Log.d("Current Date Time", sdf.format(new Date()));
        return sdf.format(new Date());
    }


    private boolean checkValidation() {
        if(notification_heading.getText().toString().isEmpty() && notification_body.getText().toString().isEmpty()){
            return false;
        }
        return true;
        }
    private void initVariable() {

        // Initialize views for this xml element
        notification_heading =(EditText)findViewById(R.id.notice_head);
        notification_body =(EditText)findViewById(R.id.notice_content);
        sendButton=  (Button)findViewById(R.id.send_notification);

    }

    }


