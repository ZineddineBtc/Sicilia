package com.example.sicilia.model;

import java.util.ArrayList;

public class Queen extends Piece{

    public Queen(int position, boolean whiteBlack) {
        super(9, position, whiteBlack);
    }

    @Override
    public ArrayList<Integer> options(Board board, int count) {
        return super.options(board, count);
    }

    @Override
    public Board move(Board board, int desiredPosition, int count) {
        return super.move(board, desiredPosition, count);
    }
}
