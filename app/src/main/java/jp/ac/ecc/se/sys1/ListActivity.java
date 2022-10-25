package jp.ac.ecc.se.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        String[] curryList = {"ドライカレー","カツカレー","チーズカレー","スープカレー"};

        //移行先の画面を変数に登録
        Intent intentPA = new Intent(this,PreferencesActivity.class);

        //画面上のパーツを登録
        ListView listView = findViewById(R.id.curryList);

        //配列セット用のアダプター宣言
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, curryList);

        //画面上のListViewにアダプターの配列データ表示
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView tv = (TextView)view;
                String st = (String) adapterView.getItemAtPosition(i);
                //何番目を選んだかを送る
                intentPA.putExtra("curry",i);
                //画面遷移
                startActivity(intentPA);

                //Toast.makeText(getApplicationContext(),tv.getText(),Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(),Integer.toString(i),Toast.LENGTH_SHORT).show();
                //i:何番目を選んだか
                Toast.makeText(getApplicationContext(),st,Toast.LENGTH_SHORT).show();
            }
        });
    }
}