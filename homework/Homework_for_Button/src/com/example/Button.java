package com.example;

public class Button  extends View {
    private  String ViewText;

    public Button (String ViewText) {
        this.ViewText=ViewText;

    }
    public interface ViewOnclicklistener {
        void Onclick();

    }
    public String getText() {
        return ViewText;
    }

    public void setText(String ViewText) {
        this.ViewText = ViewText;
    }
}