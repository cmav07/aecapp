package com.example.wallpaper;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.BitmapCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button wallcg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        wallcg = (Button) findViewById(R.id.btn_wp);
        wallcg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changewp();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void changewp(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.img);
        WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
        try{
            manager.setBitmap(bitmap);
            Toast.makeText(this,"Wallpaper set Succefully",Toast.LENGTH_SHORT).show();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}