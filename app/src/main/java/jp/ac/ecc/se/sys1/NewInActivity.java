package jp.ac.ecc.se.sys1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewInActivity extends AppCompatActivity {
    //カメラ起動用のリクエストコードを宣言する
    final int CAMERA_RESULT = 100;
    Uri imageUri2;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_RESULT && resultCode == RESULT_OK) {
            ImageView cameraImage = findViewById(R.id.cameraImage);
            /*
            Bitmap bitmap = data.getParcelableExtra("data");
            cameraImage.setImageBitmap(bitmap);
            */
            cameraImage.setImageURI(imageUri2);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_in);

        EditText TitleText = findViewById(R.id.TitleText);
        EditText ContentText = findViewById(R.id.ContentText);
        ImageView imageView = findViewById(R.id.imageViewForList);
        Button cameraButton = findViewById(R.id.cameraButton2);
        Button saveButton = findViewById(R.id.SaveButton);

        Intent intent = getIntent();
        final Uri[] imageUri = {intent.getParcelableExtra("imageUri")};
        imageView.setImageURI(imageUri[0]);

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //ファイル名
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String fileName = "Traning_" + timestamp + "_.jpg";
                //パラメータの設定
                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.TITLE, fileName);
                values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
                //保存場所
                imageUri2 =
                        getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                //カメラのIntentにパラメータセット
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri2);

                startActivityForResult(intent, CAMERA_RESULT);
            }
        });
    }
}