package com.example.sicilia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DisplayMetrics displayMetrics;
    GridLayout mainGL;
    LinearLayout[] cells = new LinearLayout[64];
    TextView[] pieces = new TextView[64];
    LinearLayout.LayoutParams cellsParams, piecesParams;
    String rookW="Rw", knightW="Nw", bishopW="Bw", queenW="Qw", kingW="Kw", pawnW="pw",
           rookB="Rb", knightB="Nb", bishopB="Bb", queenB="Qb", kingB="Kb", pawnB="pb",
           empty="";
    String[] piecesInitialPositionW =
            {rookW, knightW, bishopW, queenW, kingW, bishopW,knightW, rookW};
    String[] piecesInitialPositionB =
            {rookB, knightB, bishopB, queenB, kingB, bishopB, knightB, rookB};
    String[][] board = new String[8][8];
    int count=0, lastClickedPiece;
    boolean a=false, optionShown=false, isPawnOption, isRookOption, isKnightOption,
    isBishopOption, isKingOption, isQueenOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeMainGL();
        fillGrid();
        setBoard();
    }
    private void initializeMainGL(){
        displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        mainGL = findViewById(R.id.mainGL);
        ViewGroup.LayoutParams gridParams = mainGL.getLayoutParams();
        gridParams.height = displayMetrics.widthPixels;
        mainGL.setLayoutParams(gridParams);
    }
    private void setCellsParams(final int i){
        cells[i] = new LinearLayout(this);
        cells[i].setBackgroundColor(getColor(a?R.color.black_cell:R.color.white_cell));
        cellsParams = new LinearLayout.LayoutParams(displayMetrics.widthPixels/9,
                        displayMetrics.widthPixels/9);
        cellsParams.setMargins(2, 2, 2, 2);
        cells[i].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myOnClick(i);
            }
        });
    }
    private void setPiecesParams(){
        piecesParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        piecesParams.setMargins(2, 2, 2, 2);
    }
    private void initializePiece(int i){
        pieces[i] = new TextView(this);
        pieces[i].setGravity(Gravity.CENTER);
        pieces[i].setTextSize(20);
    }
    private void setBlackPiece(int i){
        pieces[i].setTextColor(getColor(R.color.black));
        if(i<8) {
            pieces[i].setText(piecesInitialPositionB[i]);
        }else{
            pieces[i].setText(pawnB);
        }
    }
    private void setWhitePiece(int i){
        pieces[i].setTextColor(getColor(R.color.white));
        if(i<56){
            pieces[i].setText(pawnW);
        }else{
            pieces[i].setText(piecesInitialPositionW[i-56]);
        }
    }
    private void fillGrid(){
        for(int i = 0; i < 64; i++){
            setCellsParams(i);
            initializePiece(i);
            if(i<16 || i>=48) {
                setPiecesParams();
                if (i < 16) {
                    setBlackPiece(i);
                } else {
                    setWhitePiece(i);
                }
            }else{
                pieces[i].setText("");
            }
            cells[i].addView(pieces[i], piecesParams);
            mainGL.addView(cells[i], i, cellsParams);
            if((i+1)%8!=0) a = !a;
        }
    }
    private void setBoard(){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(i==0){
                    board[i][j] = piecesInitialPositionB[j];
                }else if(i==1){
                    board[i][j] = pawnB;
                }else if(i==6){
                    board[i][j] = pawnW;
                }else if(i==7){
                    board[i][j] = piecesInitialPositionW[j];
                }else{
                    board[i][j] = empty;
                }
            }
        }
    }
    private void myOnClick(int i){
        int row = i/8;
        int column = i%8;
        String piece = board[row][column];
        //Toast.makeText(getApplicationContext(), piece, Toast.LENGTH_LONG).show();
        if(optionShown) {
            resetBackground();
        }
        if(piece.equals(pawnB) || piece.equals(pawnW)){
            pawnOptions(row, column, i);
        }

    }
    private void pawnOptions(int row, int column, int i){
        optionShown = true;
        isPawnOption = true;
        lastClickedPiece = i;
        if(count==0){
            if(row==1) {
                cells[i + 8].setBackgroundColor(getColor(R.color.grey));
                cells[i + 16].setBackgroundColor(getColor(R.color.grey));
            }else{
                cells[i - 8].setBackgroundColor(getColor(R.color.grey));
                cells[i - 16].setBackgroundColor(getColor(R.color.grey));
            }
        }
    }
    private void resetBackground(){
        String secondClickedCell = board[lastClickedPiece /8][lastClickedPiece %8];

        //if(.equals("empty")) return;
        boolean toggle = false;
        for(int i=0; i<64; i++){
            cells[i].setBackgroundColor(getColor(toggle?R.color.black_cell:R.color.white_cell));
            if((i+1)%8!=0) toggle = !toggle;
        }
        optionShown = false;
    }
}









