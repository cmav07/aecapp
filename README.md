### async 
```
package com.example.fortrial;

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
```



```
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

```






### calculator
```
package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    Button b1, b2, bplus, beql;
    EditText ET_Result;
    Float v1, v2;
    Boolean add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        b1 = (Button)findViewById(R.id.btn_one);
        b2 = (Button)findViewById(R.id.btn_two);

        bplus = (Button)findViewById(R.id.btn_plus);
        beql = (Button)findViewById((R.id.btn_eql));
        TextView ET_Result = (TextView) findViewById(R.id.ET_Result);


        b1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                ET_Result.setText(ET_Result.getText() + "1");
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                ET_Result.setText(ET_Result.getText() + "2");
            }
        });

        bplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = ET_Result.getText().toString().trim();
                if (!input.isEmpty()) {
                    try {
                        v1 = Float.parseFloat(input);
                        add = true;
                        ET_Result.setText(null);
                    } catch (NumberFormatException e) {
                        ET_Result.setError("Invalid input");
                    }
                } else {
                    ET_Result.setError("Please enter a number");
                }
            }
        });


        beql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = ET_Result.getText().toString().trim();
                if (!input.isEmpty()) {
                    try {
                        v2 = Float.parseFloat(input);
                        if (add) {
                            ET_Result.setText(String.valueOf(v1 + v2));
                            add = false;
                        }
                    } catch (NumberFormatException e) {
                        ET_Result.setError("Invalid input");
                    }
                } else {
                    ET_Result.setError("Please enter a number");
                }
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
```


```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Calculator"
        android:textSize="48sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.498"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.078" />

    <Button
        android:id="@+id/btn_plus"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="40dp"
        android:layout_marginTop="190dp"
        android:layout_marginEnd="104dp"
        android:layout_marginBottom="51dp"
        android:text="+"
        android:textSize="24sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toTopOf="@+id/btn_one"
        app:layout_constraintEnd_toStartOf="@+id/btn_eql"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView2" />

    <Button
        android:id="@+id/btn_eql"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="5dp"
        android:layout_marginTop="190dp"
        android:layout_marginEnd="40dp"
        android:layout_marginBottom="53dp"
        android:text="="
        android:textSize="24sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toTopOf="@+id/btn_two"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/btn_plus"
        app:layout_constraintTop_toBottomOf="@+id/textView2" />

    <Button
        android:id="@+id/btn_one"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="40dp"
        android:layout_marginTop="51dp"
        android:layout_marginEnd="40dp"
        android:layout_marginBottom="269dp"
        android:text="1"
        android:textSize="24sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toStartOf="@+id/btn_two"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/btn_plus" />

    <Button
        android:id="@+id/btn_two"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="80dp"
        android:layout_marginTop="52dp"
        android:layout_marginEnd="40dp"
        android:layout_marginBottom="268dp"
        android:text="2"
        android:textSize="24sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/btn_one"
        app:layout_constraintTop_toBottomOf="@+id/btn_eql" />

    <EditText
        android:id="@+id/ET_Result"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="165dp"
        android:layout_marginEnd="160dp"
        android:layout_marginBottom="521dp"
        android:hint="Enter Number"
        android:inputType="numberDecimal"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent" />


</androidx.constraintlayout.widget.ConstraintLayout>
```




### counter

```
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
```

```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/textView"
        android:layout_width="0dp"
        android:layout_height="68dp"
        android:layout_marginStart="32dp"
        android:layout_marginTop="50dp"
        android:rotationX="9"
        android:text=" Counter Application"
        android:textColor="#7C1414"
        android:textSize="34sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="139dp"
        android:layout_marginTop="134dp"
        android:text="Start"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/counter" />

    <Button
        android:id="@+id/button2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="139dp"
        android:layout_marginTop="94dp"
        android:text="Stop"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/button" />

    <TextView
        android:id="@+id/counter"
        android:layout_width="97dp"
        android:layout_height="70dp"
        android:layout_marginStart="130dp"
        android:layout_marginTop="120dp"
        android:textSize="34sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView" />

</androidx.constraintlayout.widget.ConstraintLayout>
```




### medicine alarm
```
# main activity java
package com.example.medicinealarm;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Switch modeSwitch;
    private Button insertButton, fetchButton;
    private LinearLayout medicineNameLayout;
    private EditText medicineNameInput, dateInput;
    private Spinner timeOfDaySpinner;
    private DataBaseConn db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modeSwitch = findViewById(R.id.switch1);
        insertButton = findViewById(R.id.insert);
        fetchButton = findViewById(R.id.fetch);
        medicineNameLayout = findViewById(R.id.medicine_name_layout);
        medicineNameInput = findViewById(R.id.editTextText);
        dateInput = findViewById(R.id.editTextDate);
        timeOfDaySpinner = findViewById(R.id.spinner);

        db = new DataBaseConn(this);

        setupSwitchListener();
        setupInsertButton();
        setupFetchButton();
        setupDatePicker(); // Add DatePicker functionality here
    }

    private void setupSwitchListener() {
        modeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                fetchButton.setVisibility(View.VISIBLE);
                insertButton.setVisibility(View.GONE);
                medicineNameLayout.setVisibility(View.GONE);
                medicineNameInput.setVisibility(View.GONE);
            } else {
                fetchButton.setVisibility(View.GONE);
                insertButton.setVisibility(View.VISIBLE);
                medicineNameLayout.setVisibility(View.VISIBLE);
                medicineNameInput.setVisibility(View.VISIBLE);
            }
        });
    }

    private void setupInsertButton() {
        insertButton.setOnClickListener(v -> {
            String name = medicineNameInput.getText().toString();
            String date = dateInput.getText().toString();
            String timeOfDay = timeOfDaySpinner.getSelectedItem().toString();

            if (name.isEmpty() || date.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                boolean result = db.insertData(name, date, timeOfDay);
                if (result) {
                    Toast.makeText(this, "Inserted Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Insert Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setupFetchButton() {
        fetchButton.setOnClickListener(v -> {
            String date = dateInput.getText().toString();
            String timeOfDay = timeOfDaySpinner.getSelectedItem().toString();

            if (date.isEmpty()) {
                Toast.makeText(this, "Please enter a date", Toast.LENGTH_SHORT).show();
            } else {
                Cursor cursor = db.fetchData(date, timeOfDay);
                if (cursor.getCount() == 0) {
                    Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
                } else {
                    StringBuilder result = new StringBuilder();
                    while (cursor.moveToNext()) {
                        result.append("Name: ").append(cursor.getString(1)).append("\n");
                    }
                    Toast.makeText(this, result.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void setupDatePicker() {
        dateInput.setOnClickListener(v -> showDatePickerDialog());
    }

    private void showDatePickerDialog() {
        // Get the current date
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Create a DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    // Set the selected date on the EditText
                    String date = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                    dateInput.setText(date);
                },
                year, month, day
        );

        datePickerDialog.show();
    }
}
```

### meet
```
# databaseconn.java
package com.example.medicinealarm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseConn extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Medicine.db";
    private static final String TABLE_NAME = "medicine_table";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "NAME";
    private static final String COL_3 = "DATE";
    private static final String COL_4 = "TIME_OF_DAY";

    public DataBaseConn(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
                COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_2 + " TEXT, " +
                COL_3 + " TEXT, " +
                COL_4 + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String date, String timeOfDay) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, date);
        contentValues.put(COL_4, timeOfDay);

        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public Cursor fetchData(String date, String timeOfDay) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " +
                COL_3 + "=? AND " + COL_4 + "=?", new String[]{date, timeOfDay});
    }
}
```


```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:layout_marginRight="10dp"
        android:orientation="horizontal">

        <TextView
            android:id="@+id/textView"
            android:layout_width="100dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="MEDICINE DATEBASE"
            android:textSize="30sp"/>
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:layout_marginRight="10dp"
        android:orientation="horizontal">

        <TextView
            android:id="@+id/textView2"
            android:layout_width="100dp"
            android:layout_height="48dp"
            android:layout_weight="1"
            android:text="Insert"
            android:textSize="20sp"
            android:textAllCaps="false"/>

        <Switch
            android:id="@+id/switch1"
            android:layout_width="wrap_content"
            android:layout_height="48dp"
            android:layout_weight="1"/>

        <TextView
            android:id="@+id/textView3"
            android:layout_width="wrap_content"
            android:layout_height="48dp"
            android:layout_weight="1"
            android:text="Fetch"
            android:textSize="20sp"/>
    </LinearLayout>

    <LinearLayout
        android:id="@+id/medicine_name_layout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:layout_marginRight="10dp"
        android:orientation="horizontal">

        <TextView
            android:id="@+id/textView4"
            android:layout_width="100dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Medicine Name"
            android:textSize="24dp"/>

        <EditText
            android:id="@+id/editTextText"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:ems="10"
            android:inputType="text"
            android:hint="Enter medicine name"
            android:textSize="20sp"/>
    </LinearLayout>


    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:layout_marginRight="10dp"
        android:orientation="horizontal">

        <TextView
            android:id="@+id/textView5"
            android:layout_width="100dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Date"
            android:textSize="24dp"/>

        <EditText
            android:id="@+id/editTextDate"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:ems="10"
            android:hint="Enter date"
            android:focusable="false"
            android:clickable="true"
            android:textSize="24sp"/>

    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:layout_marginRight="10dp"
        android:orientation="horizontal">

        <TextView
            android:id="@+id/textView6"
            android:layout_width="100dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Time of the Day"
            android:textSize="20sp"/>

        <Spinner
            android:id="@+id/spinner"
            android:layout_width="24dp"
            android:layout_height="48dp"
            android:layout_weight="1"
            android:entries="@array/timeoftheday"/>
    </LinearLayout>

    <Button
        android:id="@+id/insert"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:text="INSERT"/>
    <Button
        android:id="@+id/fetch"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:text="FETCH"/>

    <TextView
        android:id="@+id/textView7"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Suhas\n1NT21CS181"
        android:layout_marginTop="30dp"/>

</LinearLayout>
```



### t2s
```
package com.example.texttospeec;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText et;
    TextToSpeech ts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.btn);
        et = (EditText)findViewById(R.id.etex);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
        ts=new TextToSpeech(getBaseContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR){
                    ts.setLanguage(Locale.ENGLISH);
                    Toast.makeText(getBaseContext(),"SUCCESS",Toast.LENGTH_LONG).show();
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btn), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void speak()
    {
        String te = et.getText().toString();
        ts.speak(te,TextToSpeech.QUEUE_FLUSH,null);
    }
}
```


```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/btn"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#FEFFFFFF"
    android:textAlignment="textEnd"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/textView"
        android:layout_width="305dp"
        android:layout_height="77dp"
        android:layout_marginStart="53dp"
        android:layout_marginTop="26dp"
        android:text="Text To Speech Application "
        android:textAlignment="center"
        android:textColor="#F20909"
        android:textSize="30sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/etex"
        android:layout_width="326dp"
        android:layout_height="142dp"
        android:layout_marginStart="42dp"
        android:layout_marginTop="85dp"
        android:ems="10"
        android:inputType="text"
        android:text="Enter Text"
        android:textSize="24sp"
        android:visibility="visible"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView"
        tools:visibility="visible" />

    <Button
        android:id="@+id/button"
        android:layout_width="293dp"
        android:layout_height="75dp"
        android:layout_marginStart="52dp"
        android:layout_marginTop="124dp"
        android:text="Convert Text To Speech"
        android:textColor="#ECEFF2"
        android:textColorLink="#E7EBE3"
        android:textSize="24sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/etex" />
</androidx.constraintlayout.widget.ConstraintLayout>

```


### signup
```
#signin.java
package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class signin extends AppCompatActivity {

    private EditText usernameField, passwordField;
    private Button loginButton;
    private String correctUsername, correctPassword;
    private int attemptsLeft = 2; // Max 2 attempts

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        usernameField = findViewById(R.id.username);
        passwordField = findViewById(R.id.password);
        loginButton = findViewById(R.id.login);

        // Retrieve data from signup activity
        Intent intent = getIntent();
        correctUsername = intent.getStringExtra("username");
        correctPassword = intent.getStringExtra("password");

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameField.getText().toString().trim();
                String password = passwordField.getText().toString().trim();

                if (username.equals(correctUsername) && password.equals(correctPassword)) {
                    // Successful login
                    Toast.makeText(signin.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    Intent welcomeIntent = new Intent(signin.this, welcome.class);
                    startActivity(welcomeIntent);
                    finish();
                } else {
                    // Failed login
                    attemptsLeft--;
                    if (attemptsLeft > 0) {
                        Toast.makeText(signin.this, "Login Failed. Attempts left: " + attemptsLeft, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(signin.this, "Login Failed. No attempts left.", Toast.LENGTH_LONG).show();
                        loginButton.setEnabled(false); // Disable login button
                    }
                }
            }
        });
    }
}
```

```
# signup.java
package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class signup extends AppCompatActivity {

    private EditText usernameField, passwordField;
    private Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameField = findViewById(R.id.username);
        passwordField = findViewById(R.id.password);
        signUpButton = findViewById(R.id.sighup);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameField.getText().toString().trim();
                String password = passwordField.getText().toString().trim();

                // Validate input
                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(signup.this, "Username is required", Toast.LENGTH_SHORT).show();
                } else if (!isValidEmail(username)) {
                    Toast.makeText(signup.this, "Enter a valid email as username", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(signup.this, "Password is required", Toast.LENGTH_SHORT).show();
                } else if (!isValidPassword(password)) {
                    Toast.makeText(signup.this, "Password must be at least 8 characters and include uppercase, lowercase, numbers, and special characters", Toast.LENGTH_LONG).show();
                } else {
                    // Navigate to signin activity and pass data
                    Intent intent = new Intent(signup.this, signin.class);
                    intent.putExtra("username", username);
                    intent.putExtra("password", password);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    // Validate password
    private boolean isValidPassword(String password) {
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        return Pattern.matches(passwordPattern, password);
    }

    // Validate username as email
    private boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
```
```
#welcome.java
package com.example.signup;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome);

    }
}
```

```
#activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".signup">

    <TextView
        android:id="@+id/textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:lineSpacingExtra="8sp"
        android:text="SIGNUP"
        android:textColor="#8727B0"
        android:textSize="48sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.497"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.155" />

    <Button
        android:id="@+id/sighup"
        android:layout_width="172dp"
        android:layout_height="64dp"
        android:layout_marginStart="116dp"
        android:layout_marginTop="528dp"
        android:text="SIGN UP"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/username"
        android:layout_width="280dp"
        android:layout_height="87dp"
        android:ems="10"
        android:hint="username :"
        android:inputType="text"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.496"
        app:layout_constraintStart_toStartOf="parent"
        tools:layout_editor_absoluteY="244dp" />

    <EditText
        android:id="@+id/password"
        android:layout_width="298dp"
        android:layout_height="88dp"
        android:ems="10"
        android:hint="password:"
        android:inputType="text"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.575"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.559" />

</androidx.constraintlayout.widget.ConstraintLayout>

```
```
#activity_signin.xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".signin">

    <TextView
        android:id="@+id/textView3"
        android:layout_width="152dp"
        android:layout_height="97dp"
        android:layout_marginStart="128dp"
        android:layout_marginTop="28dp"
        android:text="Login Activity"
        android:textAlignment="center"
        android:textSize="34sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/username"
        android:layout_width="230dp"
        android:layout_height="63dp"
        android:layout_marginStart="88dp"
        android:layout_marginTop="188dp"
        android:ems="10"
        android:hint="username:"
        android:inputType="text"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/password"
        android:layout_width="232dp"
        android:layout_height="74dp"
        android:layout_marginStart="88dp"
        android:layout_marginTop="292dp"
        android:ems="10"
        android:hint="password:"
        android:inputType="text"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/login"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="176dp"
        android:layout_marginTop="452dp"
        android:text="Login"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```
```
#activity_welcome.xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".welcome">

    <TextView
        android:id="@+id/textView4"
        android:layout_width="311dp"
        android:layout_height="123dp"
        android:text="WELCOME TO HOME PAGE"
        android:textAlignment="center"
        android:textColor="#E91E63"
        android:textSize="34sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```




### wallpaper
```
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
```

```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:layout_marginTop="48dp"
        android:text="Changing  wallpaper app"
        android:textColor="#0963AB"
        android:textColorHighlight="#1969A9"
        android:textSize="34sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/btn_wp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="84dp"
        android:layout_marginTop="318dp"
        android:text="Click here to change wallpaper"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView" />

</androidx.constraintlayout.widget.ConstraintLayout>

```
