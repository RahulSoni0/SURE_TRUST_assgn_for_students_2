package com.example.newsapp.ui.activities;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.newsapp.R;
import com.example.newsapp.databinding.ActivityMainBinding;
import com.example.newsapp.ui.fragments.ApFragment;
import com.example.newsapp.ui.fragments.EntertainmentFragment;
import com.example.newsapp.ui.fragments.HeadlinesFragment;
import com.example.newsapp.ui.fragments.PoliticsFragment;
import com.example.newsapp.ui.fragments.ScienceFragment;
import com.example.newsapp.ui.fragments.SportsFragment;
import com.example.newsapp.ui.fragments.TechnologyFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private TabLayout tabLayout;
    private FrameLayout frameLayout;

    Fragment fragment = null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);
        frameLayout = findViewById(R.id.FragmentContainer);


        fragment = new HeadlinesFragment();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.FragmentContainer, fragment);
        fragmentTransaction.commit();


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new HeadlinesFragment();
                        break;
                    case 1:
                        fragment = new ApFragment();
                        break;
                    case 2:
                        fragment = new TechnologyFragment();
                        break;
                    case 3:
                        fragment = new ScienceFragment();
                        break;
                    case 4:
                        fragment = new SportsFragment();
                        break;
                    case 5:
                        fragment = new PoliticsFragment();
                        break;
                    case 6:
                        fragment = new EntertainmentFragment();
                        break;
                }
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.FragmentContainer, fragment);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}