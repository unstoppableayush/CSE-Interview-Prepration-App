package com.example.ayushsproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.auth.FirebaseAuth;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageSlider imageSlider;
    RelativeLayout relativeLayout1,relativeLayout2,relativeLayout3,relativeLayout4,relativeLayout5,relativeLayout6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageSlider=findViewById(R.id.imageSlider);
        relativeLayout1=findViewById(R.id.relativelayout1);
        relativeLayout2=findViewById(R.id.relativelayout2);
        relativeLayout3=findViewById(R.id.relativelayout3);
        relativeLayout4=findViewById(R.id.relativelayout4);
        relativeLayout5=findViewById(R.id.relativelayout5);
        relativeLayout6=findViewById(R.id.relativelayout6);
       
        relativeLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),clanguage.class));
            }
        });
        relativeLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),cpplanguage.class));
            }
        });
        relativeLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),dbms.class));
            }
        });
        relativeLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),datastructure.class));
            }
        });
        relativeLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),java.class));
            }
        });
        relativeLayout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),operatingsystem.class));
            }
        });
        //new we will create a list for images

        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://www.gpgopalganj.ac.in/wp-content/uploads/sites/41/2022/01/file_61dc3be4e006c.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.gpgopalganj.ac.in/wp-content/uploads/sites/41/2021/04/6bb7d95d-69b3-4fb5-acc7-aff84dd3ea77.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.gpgopalganj.ac.in/wp-content/uploads/sites/41/2021/08/file_61192425829d6.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.gpgopalganj.ac.in/wp-content/uploads/sites/41/2021/10/file_615dcca78a237-scaled.jpeg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.gpgopalganj.ac.in/wp-content/uploads/sites/41/2021/08/file_6119248ad53d7.jpg", ScaleTypes.FIT));

        imageSlider.setImageList(slideModels,ScaleTypes.FIT);
        
        //toolbar

        
        


    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();;
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        DialogPlus dialogPlus=DialogPlus.newDialog(MainActivity.this)
                .setContentBackgroundResource(R.color.transparent)
                .setContentHolder(new ViewHolder(R.layout.custom_exit_dialouge))
                .setGravity(Gravity.CENTER)
                .setExpanded(true,1000)
                .setCancelable(true)
                .create();
        View view = dialogPlus.getHolderView();
        Button btnNo = view.findViewById(R.id.btnNo);
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialogPlus.dismiss();
            }
        });
        Button btnYes = view.findViewById(R.id.btnYes);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finishAffinity();
            }
        });
        dialogPlus.show();

    }
}