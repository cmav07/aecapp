[package com.example.fortrial;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fortrial.R;

public class MainActivity extends AppCompatActivity {

    private TextView asyncText;
    private Button startButton, stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        asyncText = findViewById(R.id.asynctext);
        startButton = findViewById(R.id.buttonst);
        stopButton = findViewById(R.id.buttonstop);

        // Configure TextView for marquee
        asyncText.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        asyncText.setHorizontallyScrolling(true);
        asyncText.setMarqueeRepeatLimit(-1); // Repeat indefinitely

        // Start Button
        startButton.setOnClickListener(view -> {
            asyncText.setVisibility(View.VISIBLE); // Make it visible
            asyncText.setSelected(true); // Enable marquee
        });

        // Stop Button
        stopButton.setOnClickListener(view -> {
            asyncText.setSelected(false); // Stop marquee
        });
    }
}




<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <!-- Title TextView -->
    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Asynchronous Task"
        android:textSize="35sp"
        android:textColor="#FF5733"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginTop="32dp" />

    <!-- Start Task Button -->
    <Button
        android:id="@+id/buttonst"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Start Task"
        app:layout_constraintTop_toBottomOf="@id/textView"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginTop="24dp" />

    <!-- Stop Task Button -->
    <Button
        android:id="@+id/buttonstop"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Stop Task"
        app:layout_constraintTop_toBottomOf="@id/buttonst"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginTop="16dp" />

    <!-- Output TextView -->
    <TextView
        android:id="@+id/asynctext"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="This is an example of Asynchronous"
        android:textSize="20sp"
        android:visibility="invisible"
        android:ellipsize="marquee"
        android:singleLine="true"
        android:marqueeRepeatLimit="marquee_forever"
        android:scrollHorizontally="true"
        android:focusable="true"
        android:focusableInTouchMode="true"
        app:layout_constraintTop_toBottomOf="@id/buttonstop"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_marginTop="32dp" />
</androidx.constraintlayout.widget.ConstraintLayout>

]
