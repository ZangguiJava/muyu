package com.example.demo;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *绘制一个窗口{位置，大小，背景色，标题}
 *
 * 画出蛇的躯干
 */
public class Snake01 extends Frame {

    //给它一个构造器
    public Snake01(){
        this.setLocation(200,100);
        this.setSize(600,500);

        //设置窗体可见
        this.setVisible(true);

        this.setBackground(Color.yellow);
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

    /**
     * 画笔
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        //画正方形
        g.drawRect(100,150,50,50);
        //画圆
        g.drawOval(100,150,50,50);

        //修改颜色
        g.setColor(Color.MAGENTA);
        //填充图形
        g.fillRect(300,150,50,50);
        g.fillOval(300,150,50,50);

        //
        g.fillRect(100,100,20-1,20-1);
        g.fillRect(120,100,20-1,20-1);
        g.fillOval(140,100,20-1,20-1);

    }

    public static void main(String[] args) {
         new Snake01();
    }
}
