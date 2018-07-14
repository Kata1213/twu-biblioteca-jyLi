package com.twu.biblioteca;

public class Item {
    public enum Type{
        BOOK,
        MOVIE
    }

    protected String title;
    protected boolean isCheckedOut;
    protected Type type;

    public Item(String title, Type type) {
        this.isCheckedOut = false;
        this.title = title;
        this.type = type;
    }

    public boolean getIsCheckedOut() {
        return isCheckedOut;
    }

    public void setIsCheckedOut(boolean isCheckedOut) {
        this.isCheckedOut = isCheckedOut;
    }

    public String getTitle() {
        return title;
    }

    public boolean checkOutItem(){
        if (this.isCheckedOut)
            return false;
        else{
            setIsCheckedOut(true);
            return true;
        }
    }

    public boolean returnItem(){
        if (this.isCheckedOut){
            setIsCheckedOut(false);
            return true;
        }
        else
            return false;
    }
}
