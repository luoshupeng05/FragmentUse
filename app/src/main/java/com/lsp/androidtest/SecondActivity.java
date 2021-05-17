package com.lsp.androidtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    private Button btnShowFG1;

    private Button btnShowFG2;

    private Button btnShowFG3;

    private Button btnShowFG4;

    private Button btnPopBackStack;

    private Button btnBackToStack2_0;

    private Button btnBackToStack2_INCLUSIVE;

    Fragment1 fragment1;

    Fragment2 fragment2;

    Fragment3 fragment3;

    Fragment4 fragment4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnShowFG1 = findViewById(R.id.btn_show_fragment1);
        btnShowFG2 = findViewById(R.id.btn_show_fragment2);
        btnShowFG3 = findViewById(R.id.btn_show_fragment3);
        btnShowFG4 = findViewById(R.id.btn_show_fragment4);
        btnPopBackStack = findViewById(R.id.btn_PopBackStack);
        btnBackToStack2_0 = findViewById(R.id.btn_BackToStack2_0);
        btnBackToStack2_INCLUSIVE = findViewById(R.id.btn_BackToStack2_INCLUSIVE);

        btnShowFG1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                fragment1 = new Fragment1();
                Log.d(TAG, "onClick: =========增加FG111111========");
                ft.add(R.id.fragment_container, fragment1);
                ft.addToBackStack("f1");
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
                ft.addToBackStack("fg2");
                ft.commit();

            }
        });

        btnShowFG3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                fragment3 = new Fragment3();
                Log.d(TAG, "onClick: =========增加FG3333333333========");
                ft.add(R.id.fragment_container, fragment3);
                ft.addToBackStack("f3");
                ft.commit();
            }
        });

        btnShowFG4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                fragment4 = new Fragment4();
                Log.d(TAG, "onClick: =========增加FG444444444========");
                ft.add(R.id.fragment_container, fragment4);
                ft.addToBackStack("f4");
                ft.commit();
            }
        });

        btnPopBackStack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                Log.d(TAG, "onClick: =========回退到上一次的提交========");
                fm.popBackStack();

            }
        });

        btnBackToStack2_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                Log.d(TAG, "onClick: =========回退到第二个碎片的提交========");
                fm.popBackStack("fg2",0);

            }
        });

        btnBackToStack2_INCLUSIVE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                Log.d(TAG, "onClick: =========回退到第二个碎片创建前的提交========");
                fm.popBackStack("fg2",FragmentManager.POP_BACK_STACK_INCLUSIVE);

            }
        });

    }
}