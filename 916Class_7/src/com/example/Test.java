package com.example;

 class Dialog {
     public interface onClickListener{
         void confim();
         void cancel();
     };
     private String title;//定义必选
     private String content;//定义可选
     private onClickListener oncl;//定义必选

    private Dialog(Builder b){
        this.title = b.title;//必选
        this.content = b.content;//可选
        this.oncl = b.oncl;
    }
     public String getTitle(){ return this.title; }
     public String getContent(){ return this.content; }
     public onClickListener getOncl(){return this.oncl;}
    public static  class Builder{//内部类的建造
        private String title;//必选
        private String content;//可选
        private onClickListener oncl;//必选
        public Builder(String title,onClickListener oncl){//必选属性被在构造方法写
            this.title = title;
            this.oncl = oncl;
        }
        public  Builder(){ };

        public Builder setContent(String content) {this.content = content;return this;}
        //可选属性在内部被方法的形式写出//返回builder类型

        public Dialog build(){
            return  new Dialog(this);
        }
    }
}

public class Test {
    public static void main(String[] args) {

        Dialog d1 = new Dialog.Builder("shiyan8",
                new Dialog.onClickListener() {
                    @Override
                    public void confim() {
                        System.out.println("确认");
                    }

                    @Override
                    public void cancel() {
                        System.out.println("退出");
                    }
                }
        ).setContent("真神奇 设计模式").build();
        System.out.println(d1.getTitle()+d1.getContent());
    }
}
