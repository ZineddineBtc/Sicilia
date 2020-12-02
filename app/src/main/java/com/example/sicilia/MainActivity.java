package com.example.sicilia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        GridLayout mainGL = findViewById(R.id.mainGL);
        ViewGroup.LayoutParams params = mainGL.getLayoutParams();
        params.height = displayMetrics.widthPixels;
        mainGL.setLayoutParams(params);
        LinearLayout[] dots = new LinearLayout[64];
        boolean a = false;
        for(int i = 0; i < 64; i++){
            dots[i] = new LinearLayout(this);
            dots[i].setBackgroundColor(getColor(a?R.color.colorAccent:R.color.colorPrimary));
            LinearLayout.LayoutParams param =
                    new LinearLayout.LayoutParams(displayMetrics.widthPixels/9,
                            displayMetrics.widthPixels/9);
            param.setMargins(2, 2, 2, 2);
            mainGL.addView(dots[i], i, param);

            if((i+1)%8!=0){
                a = !a;
            }
        }

    }
}
