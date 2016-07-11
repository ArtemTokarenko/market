package com.cusbee.salers.sites;

public class PageContainer {
    private int begin = 0;
    private int end = 0;
    private int current = 0;
    private int lastPage = 0;

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getLastPage(){return  lastPage;}

    public void setLastPage(int lastPage) {this.lastPage = lastPage;}
}
