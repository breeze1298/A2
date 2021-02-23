package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Notification extends AppCompatActivity {

    EditText e1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        setTitle("Notification");

       e1=findViewById(R.id.text);
       b1=findViewById(R.id.click);

       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               msg();
           }
       });


    }

    public void msg()
    {
        String txt=e1.getText().toString();
        if (txt.isEmpty())
        {
            Toast.makeText(this, "No Input for Notification !!", Toast.LENGTH_SHORT).show();
        }
        else {


            NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
            {
                NotificationChannel channel = new NotificationChannel("1", "Channel", NotificationManager.IMPORTANCE_DEFAULT);
                channel.setDescription("Description");
                mNotificationManager.createNotificationChannel(channel);
            }
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext(), "1")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Notification")
                    .setContentText(txt)
                    .setAutoCancel(true);

            Intent intent = new Intent(getApplicationContext(), Notification.class);
            PendingIntent pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            mBuilder.setContentIntent(pi);
            mNotificationManager.notify(0, mBuilder.build());
        }

    }
}