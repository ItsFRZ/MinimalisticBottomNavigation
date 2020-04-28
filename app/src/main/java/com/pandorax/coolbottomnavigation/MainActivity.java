package com.pandorax.coolbottomnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    ChipNavigationBar chipNavigationBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame,new Home())
                .commit();

        frameLayout = (FrameLayout) findViewById(R.id.frame);
        chipNavigationBar = (ChipNavigationBar) findViewById(R.id.bottommenu);
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {

                Fragment SelectFragment = null;

                switch (id)
                {
                    case R.id.home:
                        SelectFragment = new Home();
                        break;

                    case R.id.movie:
                        SelectFragment = new Movie();
                        break;

                    case R.id.pictures:
                        SelectFragment = new Picture();
                        break;

                    case R.id.videos:
                        SelectFragment = new Video();
                        break;

                }

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame,SelectFragment)
                        .commit();

            }
        });


    }
}
