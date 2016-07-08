package com.example.hideandshowfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FirstFragment ff;
    private ThirdFragment tf;
    private SecondFragment sf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {

            tf = ThirdFragment.newInstance("third");

            ff = FirstFragment.newInstance("first");

            sf = SecondFragment.newInstance("second");

        }

        findViewById(R.id.btn_first).setOnClickListener(this);

        findViewById(R.id.btn_second).setOnClickListener(this);

        findViewById(R.id.btn_third).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_first:

                displayFirstFragment();

                break;

            case R.id.btn_second:

                displaySecondFragment();

                break;

            case R.id.btn_third:

                displayThirdFragment();

                break;

            default:
                break;
        }
    }


    protected void displayThirdFragment() {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if (tf.isAdded()) { // if the fragment is already in container

            ft.show(tf);

        } else { // fragment needs to be added to frame container

            ft.add(R.id.your_placeholder, tf, "third");

        }

        // Hide fragment B
        if (ff.isAdded()) {

            ft.hide(ff);

        }

        // Hide fragment C
        if (sf.isAdded()) {

            ft.hide(sf);

        }

        ft.addToBackStack("third");
        ft.commit();
    }

    protected void displayFirstFragment() {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if (ff.isAdded()) { // if the fragment is already in container

            ft.show(ff);

        } else { // fragment needs to be added to frame container

            ft.add(R.id.your_placeholder, ff, "first");

        }

        // Hide fragment B
        if (tf.isAdded()) {

            ft.hide(tf);

        }

        // Hide fragment C
        if (sf.isAdded()) {

            ft.hide(sf);

        }

        // Commit changes
        ft.addToBackStack("first");
        ft.commit();

    }


    public void displaySecondFragment() {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if (sf.isAdded()) {

            ft.show(sf);

        } else {

            ft.add(R.id.your_placeholder, sf,"second");

        }

        if (ff.isAdded()) {

            ft.hide(ff);

        }

        if (tf.isAdded()) {

            ft.hide(tf);

        }

        ft.addToBackStack("second");
        ft.commit();
    }
}
