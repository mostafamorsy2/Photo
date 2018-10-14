package com.example.darsh.newsession14;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.icu.util.Output;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class ShowImage extends AppCompatActivity {

    ImageView imageView;
    Button save;

    Drawable drawable;
    Bitmap bitmap;
    String ImagePath;
    Uri URI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);

        imageView=findViewById(R.id.img2);
        save=findViewById(R.id.save);

        final Bundle bundle = getIntent().getExtras();
        imageView.setImageResource(bundle.getInt("img"));

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawable = getResources().getDrawable(bundle.getInt("img"));

                bitmap = ((BitmapDrawable)drawable).getBitmap();

                ImagePath = MediaStore.Images.Media.insertImage(
                        getContentResolver(),
                        bitmap,
                        "demo_image",
                        "png"
                );

                URI = Uri.parse(ImagePath);

                Toast.makeText(ShowImage.this, "Image Saved Successfully", Toast.LENGTH_SHORT).show();

            }

        });
    }
}
