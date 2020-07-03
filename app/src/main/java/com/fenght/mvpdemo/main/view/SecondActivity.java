package com.fenght.mvpdemo.main.view;

import android.os.Bundle;

import com.fenght.mvpdemo.R;
import com.fenght.mvpdemo.main.fragment.SecondFragment;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment,new SecondFragment()).commit();

    }
}
