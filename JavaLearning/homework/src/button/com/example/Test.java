package button.com.example;

public class Test {

    public static void main(String[] args) {
        Button b1=new Button("按钮1");
        b1.setViewOnclicklistener(
                new View.ViewOnclicklistener() {
                    @Override
                    public void Onclick() {
                        System.out.println("SUBMIT");
                    }
                });
        Button b2=new Button("按钮2");
        b2.setViewOnclicklistener(new View.ViewOnclicklistener() {
            @Override
            public void Onclick() {
                System.out.println("CANCEL");
            }
        });


    }
}
