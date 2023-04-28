package com.example.mindfulness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //Stress
        TextView stress = (TextView) findViewById(R.id.stress);

        stress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create new intent
                Intent stress = new Intent(HomeActivity.this, Stress.class);
                startActivity(stress);
            }
        });

        //Depression
        TextView depression = (TextView) findViewById(R.id.depression);

        depression.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create new intent
                Intent depression = new Intent(HomeActivity.this, Depression.class);
                startActivity(depression);
            }
        });

        //Anxiety
        TextView anxiety = (TextView) findViewById(R.id.anxiety);

        anxiety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create new intent
                Intent anx = new Intent(HomeActivity.this, Anxiety.class);
                startActivity(anx);
            }
        });

        //ADHD
        TextView adhd = (TextView) findViewById(R.id.adhd);

        adhd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create new intent
                Intent adhd = new Intent(HomeActivity.this, Adhd.class);
                startActivity(adhd);
            }
        });

        //PTSD
        TextView ptsd = (TextView) findViewById(R.id.ptsd);

        ptsd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create new intent
                Intent ptsd = new Intent(HomeActivity.this, Ptsd.class);
                startActivity(ptsd);
            }
        });

        //Mania
        TextView mania = (TextView) findViewById(R.id.mania);

        mania.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create new intent
                Intent mania = new Intent(HomeActivity.this, Mania.class);
                startActivity(mania);
            }
        });

        //Panic Disorder
        TextView pd = (TextView) findViewById(R.id.pd);

        pd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create new intent
                Intent pd = new Intent(HomeActivity.this, Pd.class);
                startActivity(pd);
            }
        });

        //Sleeping Disorder
        TextView sd = (TextView) findViewById(R.id.sd);

        sd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create new intent
                Intent sd = new Intent(HomeActivity.this, Sd.class);
                startActivity(sd);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (getClass() == HomeActivity.class) {
            // Exit the app when the back button is pressed on HomeActivity
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        } else {
            // Launch the activity you want to show
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
    }

}