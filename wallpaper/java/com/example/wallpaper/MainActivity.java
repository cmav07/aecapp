package com.example.myapplication;

import android.annotation.SuppressLint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button changewallpaper;
    WallpaperManager wpm;
    int id = 1;
    Handler handler = new Handler(); // Handler to post to UI thread

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wpm = WallpaperManager.getInstance(this);
        changewallpaper = findViewById(R.id.btn_click);
        changewallpaper.setOnClickListener(view -> setWallpaper());
    }

    private void setWallpaper() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Set wallpaper based on id
                Drawable drawable = null;
                if (id == 1) {
                    drawable = ContextCompat.getDrawable(MainActivity.this, R.drawable.one);
                    id = 2;
                } else if (id == 2) {
                    drawable = ContextCompat.getDrawable(MainActivity.this, R.drawable.two);
                    id = 3;
                } else if (id == 3) {
                    drawable = ContextCompat.getDrawable(MainActivity.this, R.drawable.three);
                    id = 4;
                } else if (id == 4) {
                    drawable = ContextCompat.getDrawable(MainActivity.this, R.drawable.four);
                    id = 1;
                }

                if (drawable != null) {
                    Bitmap wallpaper = ((BitmapDrawable) drawable).getBitmap();
                    try {
                        wpm.setBitmap(wallpaper);
                        Toast.makeText(MainActivity.this, "Wallpaper Changed", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Error setting wallpaper", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, 0);  // Immediately run the task
    }
}

