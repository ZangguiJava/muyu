package com.example.demo;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *绘制一个窗口{位置，大小，背景色，标题}
 *
 * 绘制蛇的主体
 */
public class Snake02 extends Frame {

    //蛇的主体，给它三个节点
    private Node[] body = {
        new Node(140,100),
        new Node(120,100),
        new Node(100,100)
    };

    //给它一个构造器
    public Snake02(){
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
        g.setColor(Color.cyan);
        //绘制蛇的主体
      for (int i=0;i<body.length;i++){
          body[i].drawNode(g,i);
      }
    }

    public static void main(String[] args) {
         new Snake02();
    }
}
