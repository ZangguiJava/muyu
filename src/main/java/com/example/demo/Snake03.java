package com.example.demo;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *绘制一个窗口{位置，大小，背景色，标题}
 *
 * 绘制蛇的主体
 *
 * 让蛇动起来
 * )1.窗口一直重绘
 * 2.修改坐标
 */
public class Snake03 extends Frame {

    //程序要继续嘛
    private boolean isRunning = true;

    //蛇的主体，给它三个节点
    private Node[] body = {
        new Node(140,100),
        new Node(120,100),
        new Node(100,100)
    };

    //给它一个构造器
    public Snake03(){
        this.setLocation(200,100);
        this.setSize(600,500);

        //设置窗体可见
        this.setVisible(true);

        this.setBackground(Color.pink);
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
        start();
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
      //修改坐标
      move();
    }

    /**
     *通过修改的坐标达到移动的效果
     */
    public void move(){
       //向右移动
        //每一次只需要给一个新的头节点，去掉尾节点即可
        Node[] temp = new Node[body.length];
        //去掉尾部
        System.arraycopy(body,0,temp,1,body.length-1);
        temp[0] = new Node(body[0].getX()+20,body[0].getY());
        this.body= temp;
        //

    }

    public void start(){
        while (this.isRunning){
            super.repaint();//手动让窗体重绘
            try {
                Thread.sleep(500);//暂停事件
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
         new Snake03();
    }
}
