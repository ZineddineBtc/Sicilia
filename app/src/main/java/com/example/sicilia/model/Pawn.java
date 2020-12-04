package com.example.sicilia.model;

import java.util.ArrayList;

public class Pawn extends Piece{

    public Pawn(int position, boolean whiteBlack) {
        super(1, position, whiteBlack);
    }

    @Override
    public ArrayList<Integer> options(Board board, int count) {
        ArrayList<Integer> optionsList = new ArrayList<>();
        int row = getPosition()/8;
        int col = getPosition()%8;
        if(count==0 || count==1){
            firstMoveOptions(optionsList);
        }else{
            if(isWhiteBlack()){ // white
                whiteMove(optionsList, board, row, col);
            }else{ // black
                blackMove(optionsList, board, row, col);
            }
        }
        return optionsList;
    }
    private void firstMoveOptions(ArrayList<Integer> optionsList){
        if(isWhiteBlack()) { // white
            optionsList.add(getPosition() - 8);
            optionsList.add(getPosition() - 16);
        }else{ // black
            optionsList.add(getPosition() + 8);
            optionsList.add(getPosition() + 16);
        }
    }
    private void whiteMove(ArrayList<Integer> optionsList, Board board, int row, int col){
        if(board.getPieces()[row-1][col]==null){ // front
            optionsList.add(getPosition()-8);
        }
        if(board.getPieces()[row-1][col-1]==null){ // left diagonal
            optionsList.add(getPosition()-9);
        }
        if(board.getPieces()[row-1][col+1]==null){ // right diagonal
            optionsList.add(getPosition()-7);
        }
    }
    private void blackMove(ArrayList<Integer> optionsList, Board board, int row, int col){
        if(board.getPieces()[row+1][col]==null){ // front
            optionsList.add(getPosition()+8);
        }
        if(board.getPieces()[row+1][col-1]==null){ // left diagonal
            optionsList.add(getPosition()+7);
        }
        if(board.getPieces()[row+1][col+1]==null){ // right diagonal
            optionsList.add(getPosition()+9);
        }
    }




}
