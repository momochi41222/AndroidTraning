package jp.ac.ecc.se.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class List2Activity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);

        //移行する画面の宣言
        Intent intentSub = new Intent(this,SubActivity.class);
        Intent intentEvent = new Intent(this,EventActivity.class);

        // 画面のパーツを変数にセット
        ListView viewList = findViewById(R.id.arrayList);
        EditText dataInText = findViewById(R.id.dataIn);
        Button dataInButton = findViewById(R.id.dataInButton);

        //1.可変長のString配列
        ArrayList<String> dataList = new ArrayList<>();
        //2.配列セット用のアダプター宣言
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        //3.画面上のListViewにアダプターの配列データ表示
        viewList.setAdapter(adapter);

        //4.データ追加ボタン
        dataInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dT = dataInText.getText().toString();
                if (!dT.equals("")) {
                    //1.追加する文字列を可変長配列に追加
                    dataList.add(dT);
                    //2.リスト再表示
                    viewList.setAdapter(adapter);
                    //3.テキストをクリア
                    dataInText.setText("");
                }
            }
        });

        viewList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i%2){
                    case 1:
                        startActivity(intentSub);
                        break;
                    case 0:
                        startActivity(intentEvent);
                        break;
                }
            }
        });

    }
}