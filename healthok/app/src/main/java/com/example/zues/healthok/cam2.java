package com.example.zues.healthok;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import java.io.File;


/**
 * Created by Raghuveer on 05/03/2016.
 */
public class cam2 extends Activity {


    ImageView iv1;
    ImageView iv;
    static final int CAM_REQUEST=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine1);

        iv1=(ImageView) findViewById(R.id.imageView6);
        iv=(ImageView) findViewById(R.id.imageView31);
        iv1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent camera_intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file=getFile();
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(camera_intent,CAM_REQUEST);

            }
        });

    }

    private File getFile(){
        File folder=new File("sdcard/cam_app");
        if(!folder.exists())
        {
            folder.mkdir();
        }

        File imagefile=new File(folder,"cam.jpg");
        return imagefile;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String path="sdcard/cam_app/cam.jpg";
        iv.setImageDrawable(Drawable.createFromPath(path));
    }
}





