package com.example.sicilia.model;

import java.util.ArrayList;

public class Rook extends Piece{

    public Rook(int position, boolean whiteBlack) {
        super(5, position, whiteBlack);
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
