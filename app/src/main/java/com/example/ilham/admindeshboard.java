package com.example.ilham;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

import com.example.ilham.camera_admin.admincamera;
import com.example.ilham.shirt_admin.adminshirt;
import com.example.ilham.shoe_admin.adminshoe;
import com.example.ilham.sports_admin.adminsports;
import com.example.ilham.watch_admin.adminwatch;

public class admindeshboard extends AppCompatActivity {
    GridLayout adminGridLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admindeshboard);
        adminGridLayout =(GridLayout) findViewById(R.id.adminGridLayout);
        setSingleEvent(adminGridLayout);
    }
    private void setSingleEvent(GridLayout adminGridLayout) {

        for(int i=0;i<adminGridLayout.getChildCount();i++)
        {
            CardView cardView = (CardView)adminGridLayout.getChildAt(i);

            final int finalI = i;

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(finalI==0)
                    {
                        //String database="students";
                        Intent intent= new Intent(admindeshboard.this,admindevice.class);
                        // intent.putExtra("database",database);
                        startActivity(intent);
                    }
                    else if(finalI==1)
                    {
                        Intent intent= new Intent(admindeshboard.this, adminshirt.class);
                        startActivity(intent);
                    }
                    else if(finalI==2)
                    {
                        Intent intent= new Intent(admindeshboard.this, adminshoe.class);
                        startActivity(intent);
                    }
                    else if(finalI==3)
                    {
                        Intent intent= new Intent(admindeshboard.this, admincamera.class);
                        startActivity(intent);
                    }
                    else if(finalI==4)
                    {
                        Intent intent= new Intent(admindeshboard.this, adminsports.class);
                        startActivity(intent);
                    }
                    else if(finalI==5)
                    {
                        Intent intent= new Intent(admindeshboard.this, adminwatch.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }
}