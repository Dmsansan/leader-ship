package com.company.move;

import javax.swing.*;
import java.awt.*;

/**
 * @author: sansan.si
 * @vesion 1.0
 * @date: 2022-01-25 13:46
 * @description: 移动轨迹
 **/
public class GuodaoMove extends JPanel implements Runnable {
    int x = 0;
    int y;
    int step = 20;
    int height;

    public GuodaoMove(int y, int height) {
        this.y = y;
        this.height = height;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.fillRect(x, y, 20, 20);
    }

    @Override
    public void run() {
        while (true) {
            if (y > height) {
                repaint();
            }
            y -= step;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
