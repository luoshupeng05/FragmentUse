package com.lsp.androidtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.lsp.androidtest.databinding.ActivityViewBindingDemoBinding;


/**
 * 视图绑定的使用（ViewBinding）
 * 1、调用生成的绑定类中包含的静态 inflate() 方法。此操作会创建该绑定类的实例以供 Activity 使用。
 * 2、通过调用 getRoot() 方法或使用 Kotlin 属性语法获取对根视图的引用。
 * 3、将根视图传递到 setContentView()，使其成为屏幕上的活动视图。
 */


public class ViewBindingDemo extends AppCompatActivity {

    /*使用ViewBinding会生成一个以布局文件驼峰命名的绑定类*/
    private ActivityViewBindingDemoBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityViewBindingDemoBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);

        mBinding.btnUseVb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBinding.tvVbShow.getText().toString()
                        .equals("ViewBindingDemo 演示")){
                mBinding.tvVbShow.setText("按钮被点击我就变成这个文字了");
                }else {
                    mBinding.tvVbShow.setText("ViewBindingDemo 演示");
                }
            }
        });

    }
}