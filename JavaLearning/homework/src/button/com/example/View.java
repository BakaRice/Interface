package button.com.example;

public  abstract class View  {
    private  String ViewText;
    private ViewOnclicklistener viewOnclicklistener;

    public interface ViewOnclicklistener {
        void Onclick();
    }

    public ViewOnclicklistener getViewOnclicklistener() {
        return viewOnclicklistener;
    }

    public void setViewOnclicklistener(ViewOnclicklistener viewOnclicklistener) {
        this.viewOnclicklistener = viewOnclicklistener;
    }
}