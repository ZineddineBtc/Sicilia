package com.example.sicilia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DisplayMetrics displayMetrics;
    GridLayout mainGL;
    LinearLayout[] cells = new LinearLayout[64];
    TextView[] pieces = new TextView[32];
    LinearLayout.LayoutParams cellsParams, piecesParams;
    String[] piecesNotation = {"R", "N", "B", "K", "Q", "B", "N", "R"};
    boolean a = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeMainGL();
        fillGrid();

    }
    private void initializeMainGL(){
        displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        mainGL = findViewById(R.id.mainGL);
        ViewGroup.LayoutParams gridParams = mainGL.getLayoutParams();
        gridParams.height = displayMetrics.widthPixels;
        mainGL.setLayoutParams(gridParams);
    }
    private void setCellsParams(int i){
        cells[i] = new LinearLayout(this);
        cells[i].setBackgroundColor(getColor(a?R.color.colorAccent:R.color.colorPrimary));
        cellsParams = new LinearLayout.LayoutParams(displayMetrics.widthPixels/9,
                        displayMetrics.widthPixels/9);
        cellsParams.setMargins(2, 2, 2, 2);
    }
    private void setPiecesParams(){
        piecesParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        piecesParams.setMargins(2, 2, 2, 2);
    }
    private void appendBlackPieces(int i){
        pieces[i] = new TextView(this);
        pieces[i].setTextColor(getColor(R.color.black));
        pieces[i].setGravity(Gravity.CENTER);
        pieces[i].setTextSize(20);
        if(i<8) {
            pieces[i].setText(piecesNotation[i]);
        }else{
            pieces[i].setText("p");
        }
        cells[i].addView(pieces[i], piecesParams);
    }
    private void appendWhitePieces(int i){
        pieces[i-32] = new TextView(this);
        pieces[i-32].setTextColor(getColor(R.color.white));
        pieces[i-32].setGravity(Gravity.CENTER);
        pieces[i-32].setTextSize(20);
        if(i<56){
            pieces[i-32].setText("p");
        }else{
            pieces[i-32].setText(piecesNotation[i-56]);
        }
        cells[i].addView(pieces[i-32], piecesParams);
    }
    private void fillGrid(){
        for(int i = 0; i < 64; i++){
            setCellsParams(i);
            if(i<16 || i>=48) {
                setPiecesParams();
                if (i < 16) {
                    appendBlackPieces(i);
                } else {
                    appendWhitePieces(i);
                }
            }
            mainGL.addView(cells[i], i, cellsParams);
            if((i+1)%8!=0) a = !a;
        }
    }

}









