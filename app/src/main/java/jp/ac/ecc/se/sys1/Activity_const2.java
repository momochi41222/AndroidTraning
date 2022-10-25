package jp.ac.ecc.se.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Activity_const2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_const2);

        TextView Profile = findViewById(R.id.Profile2);
        EditText nameText = findViewById(R.id.nameText4);
        EditText password = findViewById(R.id.editTextTextPassword);
        Button clearButtonA = findViewById(R.id.cleara);
        Button clearButtonB = findViewById(R.id.clearb);
        CheckBox check10 = findViewById(R.id.check10);
    }
}