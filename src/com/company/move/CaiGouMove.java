package com.company.move;

import javax.swing.*;
import java.awt.*;

/**
 * @author: sansan.si
 * @vesion 1.0
 * @date: 2022-01-25 13:46
 * @description: 移动轨迹
 **/
public class CaiGouMove extends JPanel implements Runnable {
    int x = -460;
    int y = 0;
    int step = 20;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.fillRect(x, y, 20, 20);
    }

    @Override
    public void run() {
        while (true) {
            if (x < 40) {
                repaint();
            }
            x += step;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
