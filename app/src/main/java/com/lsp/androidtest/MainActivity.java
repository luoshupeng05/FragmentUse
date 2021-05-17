package com.lsp.androidtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    private Button btnShowFG1;

    private Button btnShowFG2;

    private Button btnRemoveFG1;

    private Button btnRemoveFG2;

    private Button btnReplaceFG;

    private Button btnJump;


    Fragment1 fragment1;
    Fragment2 fragment2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowFG1 = findViewById(R.id.btn_show_fragment1);
        btnShowFG2 = findViewById(R.id.btn_show_fragment2);
        btnRemoveFG1 = findViewById(R.id.btn_remove_fragment1);
        btnRemoveFG2 = findViewById(R.id.btn_remove_fragment2);
        btnReplaceFG = findViewById(R.id.btn_replace_fragment);
        btnJump = findViewById(R.id.btn_jump);

        btnShowFG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                fragment1 = new Fragment1();
                Log.d(TAG, "onClick: =========增加FG111111========");
                ft.add(R.id.fragment_container, fragment1);
                ft.commit();

            }
        });

        btnShowFG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                fragment2 = new Fragment2();
                Log.d(TAG, "onClick: =========增加FG222222========");
                ft.add(R.id.fragment_container, fragment2);
                ft.commit();

            }
        });

        btnRemoveFG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Log.d(TAG, "onClick: =========移除FG11111111111111========");
                ft.remove(fragment1);
                ft.commit();
            }
        });

        btnRemoveFG2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Log.d(TAG, "onClick: =========移除FG22222222========");
                ft.remove(fragment2);
                ft.commit();
            }
        });

        btnReplaceFG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Log.d(TAG, "onClick: =========替换FG========");
                ft.replace(R.id.fragment_container, fragment1);
                ft.commit();
            }
        });

        btnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this
                        , SecondActivity.class);
                startActivity(intent);

            }
        });


    }


}