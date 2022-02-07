package com.company.office;

import javax.swing.*;
import java.awt.*;

/**
 * @author: sansan.si
 * @vesion 1.0
 * @date: 2022-01-24 09:16
 * @description: 办公室窗体
 **/
public class DrawOffice extends JPanel {

    /**
     * 小方格宽度
     */
    private static final int sx = 50;
    /**
     * 小方格高度
     */
    private static final int sy = 50;
    /**
     * 高度，纵坐标
     */
    private static final int rw = 400;

    @Override
    public void paint(Graphics g) {
        try {
            super.paint(g);
            // 设置线条颜色为红色
            g.setColor(Color.RED);
            // 绘制外层矩形框
            g.drawRect(sx, sy, rw, rw);

            // 绘制过道
            g.drawLine(sx + 150, sy + sx, sx + 150, rw + sx);
            g.drawLine(sx + 250, sy + sx, sx + 250, rw + sx);
            // 走廊尽头生产部
            g.drawLine(sx, sy + sx, sx + 150, sy + sx);
            g.drawLine(sx + 250, sy + sx, sx + rw, sy + sx);
            Font font = new Font("黑体", Font.BOLD, 18);
            g.setFont(font);
            g.drawString("生产部", 220, 80);
            // 走廊left
            g.drawLine(sx, sy + 100, sx + 150, sy + 100);
            g.drawLine(sx, sy + 150, sx + 150, sy + 150);
            g.drawLine(sx, sy + 200, sx + 150, sy + 200);
            g.drawLine(sx, sy + 250, sx + 150, sy + 250);
            g.drawLine(sx, sy + 300, sx + 150, sy + 300);
            g.drawString("厕所", 100, 135);
            g.drawString("10楼门口", 100, 185);
            g.drawString("茶水间", 100, 235);
            g.drawString("第四会议室", 100, 285);
            g.drawString("知产部", 100, 335);
            g.drawString("领导办公室", 100, 385);
            // 走廊right
            g.drawLine(sx + 250, sy + 116, sx + rw, sy + 116);
            g.drawLine(sx + 250, sy + 232, sx + rw, sy + 232);
            g.drawLine(sx + 250, sy + 348, sx + rw, sy + 348);
            g.drawString("采购部", 350, 135);
            g.drawString("产品部", 350, 235);
            g.drawString("软件研发部", 325, 335);
            g.drawString("雷达AI算法部", 325, 435);

            g.drawString("过", 280, 255);
            g.drawString("道", 280, 275);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
