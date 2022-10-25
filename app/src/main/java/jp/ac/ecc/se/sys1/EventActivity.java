package jp.ac.ecc.se.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class EventActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        // 呼び元画面から送られてきたintent情報を入手
        Intent intent = getIntent();
        int age = intent.getIntExtra("age",25);
        // 確認
        Toast.makeText(this,"年齢："+ age ,Toast.LENGTH_SHORT).show();

        // EventActivity画面上のパーツの宣言部
        TextView Profile = findViewById(R.id.Profile2);
        EditText nameText = findViewById(R.id.nameText4);
        EditText passText = findViewById(R.id.editTextTextPassword);
        Button ClearA = findViewById(R.id.cleara);
        Button ClearB = findViewById(R.id.clearb);
        Button confirmButton = findViewById(R.id.button2);
        CheckBox check10 = findViewById(R.id.check10);
        CheckBox check20 = findViewById(R.id.check20);
        CheckBox check30 = findViewById(R.id.check30);
        RadioButton man = findViewById(R.id.radioButton);
        RadioButton woman = findViewById(R.id.radioButton2);

        ClearA.setOnClickListener(this);
        ClearB.setOnClickListener(this);
        confirmButton.setOnClickListener(this);

        ClearB.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                setTitle(passText.getText());
                return false;
            }
        });

        confirmButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (man.isChecked() == true){
                    Toast.makeText(getApplicationContext(),R.string.man,Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),R.string.woman,Toast.LENGTH_SHORT).show();
                }

                finish();// 画面消える

                return false;
            }
        });
    }


    @Override
    public void onClick(View view) {
        EditText nameText = findViewById(R.id.nameText4);
        EditText passText = findViewById(R.id.editTextTextPassword);
        switch (view.getId()){
            case R.id.cleara:
                nameText.setText("");
                break;
            case R.id.clearb:
                passText.setText("");
                setTitle(R.string.app_name);
                break;
            case R.id.button2:
                Toast.makeText(this,"名前：" + nameText.getText(),Toast.LENGTH_SHORT).show();
                break;
                }
    }
}