package com.example.counter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button start,stop;
    TextView ctr;
    int c=0;
    Boolean running = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        start=(Button)findViewById(R.id.button);
        stop=(Button)findViewById(R.id.button2);
        ctr=(TextView) findViewById(R.id.counter);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        if(v.equals(start)){
            c=0;
            running=true;
            new Mycounter().start();
        }
        else if(v.equals(stop)){
            running=false;
        }
    }
    Handler handler = new Handler()
    {
        public void handleMessage(Message m)
        {
            ctr.setText(String.valueOf(m.what));
        }
    };
    class Mycounter extends Thread
    {
        public void run()
        {
            while(running)
            {
                c++;
                handler.sendEmptyMessage(c);
                try{
                    Thread.sleep(1000);
                }catch(Exception e){}
            }
        }
    }
}