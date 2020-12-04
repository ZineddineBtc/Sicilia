package com.example.sicilia.model;

import java.util.ArrayList;

public class Board {
    Piece[][] pieces;

    public Board(){
        pieces = new Piece[8][8];
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(i==0){
                    Piece[] blackRank = {
                            new Rook(0, false),
                            new Knight(1, false),
                            new Bishop(2, false),
                            new King(3, false),
                            new Queen(4, false),
                            new Bishop(5, false),
                            new Knight(6, false),
                            new Rook(7, false)
                    };
                    pieces[i][j] = blackRank[j];
                }else if(i==1){
                    pieces[i][j] = new Pawn((i*8)+j, false); // black pawns
                }else if(i==6){
                    pieces[i][j] = new Pawn((i*8)+j, true); // white pawns
                }else if(i==7){
                    Piece[] whiteRank = {
                            new Rook(56, true),
                            new Knight(57, true),
                            new Bishop(58, true),
                            new King(59, true),
                            new Queen(60, true),
                            new Bishop(61, true),
                            new Knight(62, true),
                            new Rook(63, true)
                    };
                    pieces[i][j] = whiteRank[j];
                }
            }
        }
    }

    public void movePiece(Piece piece, ArrayList<Integer> optionsList, int desiredPosition){
        if(optionsList.contains(desiredPosition)){
            pieces[desiredPosition/8][desiredPosition%8] = piece;
        }
    }
}
