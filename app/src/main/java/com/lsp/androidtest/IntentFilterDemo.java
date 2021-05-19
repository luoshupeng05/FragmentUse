package com.lsp.androidtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentFilterDemo extends AppCompatActivity implements View.OnClickListener {


    private Button btnCall;

    private Button btnGoMap;

    private Button btnGoViewBinding;

    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_filter_demo);

        init();
        btnCall.setOnClickListener(this);
        btnGoMap.setOnClickListener(this);
        btnGoViewBinding.setOnClickListener(this);

    }


    private void init() {

        btnCall = findViewById(R.id.btn_call_phone);
        btnGoMap = findViewById(R.id.btn_go_map);
        btnGoViewBinding = findViewById(R.id.btn_go_viewBinding);

    }


    @Override
    public void onClick(View v) {
        mIntent = new Intent();
        switch (v.getId()) {
            case R.id.btn_call_phone:
                mIntent.setAction(Intent.ACTION_DIAL);
                startActivity(mIntent);
            case R.id.btn_go_map:
                Uri uri = Uri.parse("geo:0,0?q="+Uri.encode("西安火车站"));
                mIntent.setAction(Intent.ACTION_VIEW);
                mIntent.setData(uri);
                startActivity(mIntent);
            case R.id.btn_go_viewBinding:
                mIntent.setClassName("com.lsp.androidtest"
                        ,"com.lsp.androidtest.ViewBindingDemo");
                startActivity(mIntent);
        }

    }
}