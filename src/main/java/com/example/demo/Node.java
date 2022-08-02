package com.example.demo;

import java.awt.*;
import java.util.Objects;

/**
 * 封装一个节点类,保存坐标x,y
 */
public class Node {

    private int x;
    private int y;

    public Node() {
    }

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * 绘制节点
     * @param g
     */
    public void drawNode(Graphics g,int i){
        //区分头和身体
        if (0==i){
            g.fillOval(this.x,this.y,20-1,20-1);
        }else {
            g.fillRect(this.x,this.y,20-1,20-1);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x &&
                y == node.y;
    }


}
