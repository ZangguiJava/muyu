package com.example.demo;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *绘制一个窗口{位置，大小，背景色，标题}
 */
public class Snake extends Frame {

    //给它一个构造器
    public Snake(){
        this.setLocation(200,100);
        this.setSize(600,500);

        //设置窗体可见
        this.setVisible(true);

        this.setBackground(Color.GREEN);
        this.setTitle("贪吃蛇");
        //不能随便改变窗体的大小

        this.setResizable(false);

        //注册窗口的一个监听
        this.addWindowListener(new WindowAdapter() {
            @Override
            //直接推出虚拟机
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public static void main(String[] args) {
         new Snake();
    }
}
