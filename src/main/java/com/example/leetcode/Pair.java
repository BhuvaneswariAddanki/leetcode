package com.example.leetcode;

public class Pair<FIRST,SECOND> {
    private final FIRST firstElement;
    private  final SECOND secondElement;

    public Pair(FIRST firstElement, SECOND secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    public FIRST getFirstElement() {
        return firstElement;
    }


    public SECOND getSecondElement() {
        return secondElement;
    }

}
