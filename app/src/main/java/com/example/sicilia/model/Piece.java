package com.example.sicilia.model;

import java.util.ArrayList;

public class Piece {
    private int value, position;
    private boolean whiteBlack;

    public Piece(int value, int position, boolean whiteBlack) {
        this.value = value;
        this.position = position;
        this.whiteBlack = whiteBlack;
    }

    public ArrayList<Integer> options(Board board, int count){
        ArrayList<Integer> optionList = new ArrayList<>();
        return optionList;
    }

    public Board move(Board board, int desiredPosition, int count){
        return null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isWhiteBlack() {
        return whiteBlack;
    }

    public void setWhiteBlack(boolean whiteBlack) {
        this.whiteBlack = whiteBlack;
    }
}
