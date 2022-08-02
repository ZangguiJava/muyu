package com.example.demo;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
 *
 * 5.手动控制方向
 *
 * 添加键盘控制监听事件
 *
 * 6.食物
 *     主体
 *     位置
 */
public class Snake05 extends Frame {

    //程序要继续嘛
    private boolean isRunning = true;

        //上 2 下0 左1 右3
    private int direction = 3;

    private Node food = new Node(randomNum(0,600/20-1)*20,randomNum(2,500/20-1)*20);

    //蛇的主体，给它三个节点
    private Node[] body = {
        new Node(140,100),
        new Node(120,100),
        new Node(100,100)
    };

    //给它一个构造器
    public Snake05(){
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
        //注册键盘监听
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
               // System.out.println(e.getKeyCode());
                //上 2 下0 左1 右3
                int dir = -1;
                switch (e.getKeyCode()){
                    case KeyEvent.VK_UP://向上走
                        dir =2;
                        break;
                    case KeyEvent.VK_DOWN://向下走
                        dir =0;
                        break;
                    case KeyEvent.VK_LEFT://向左走
                        dir = 1;
                        break;
                    case KeyEvent.VK_RIGHT://向右走
                        dir = 3;
                        break;
                }
                //根据合法性  修改方向（不允许在同一条线上修改）
                if (direction%2 != dir%2){
                    direction = dir;
                }

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

      g.setColor(Color.green);
      food.drawNode(g,-1);
      //修改坐标
      move();
    }

    /**
     * 随机产生食物
     */
    public void productFood(){
        food = new Node(randomNum(0,600/20-1)*20,randomNum(2,500/20-1)*20);
    }

    /**
     *通过修改的坐标达到移动的效果
     */
    public void move(){
       //向右移动
        //每一次只需要给一个新的头节点，去掉尾节点即可
        Node[] temp = new Node[body.length];
        temp[0] = getNewHead();
        //去掉尾部
        System.arraycopy(body,0,temp,1,body.length-1);

        this.body= temp;


    }

    /**
     *根据方向来确定一个新的头节点
     * @return
     */
    public Node getNewHead(){

        Node newNode = body[0];
        switch (this.direction){

            //上 2 下0 左1 右3
            case 3:// 右
                newNode = new Node(newNode.getX()+20,newNode.getY());
                break;
            case 1://
                newNode = new Node(newNode.getX()-20,newNode.getY());
                break;
            case 2://
                newNode = new Node(newNode.getX(),newNode.getY()-20);
                break;
            case 0://
                newNode = new Node(newNode.getX(),newNode.getY()+20);
                break;
        }
        return newNode;
    }

    /**
     * 手动一直重绘窗体
     */
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

    /**
     * 生成指定区间的随机整数
     * @param min
     * @param max
     * @return
     */
    public static int randomNum(int min ,int max){

        return (int)(Math.random()*(max -min+1)+min);

    }
    public static void main(String[] args) {
         new Snake05();
    }
}
