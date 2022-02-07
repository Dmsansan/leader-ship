package com.company;

import com.company.move.*;
import com.company.office.DrawOffice;

import javax.swing.*;
import java.awt.*;

/**
 * 项目主函数
 *
 * @author sansan.si
 * @date 2022-01-25
 */
public class Main {

    public static void main(String[] args) {
        System.err.println("行为分析项目启动开始");
        JFrame jf = new JFrame("行为分析");
        jf.setSize(500, 500);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 层级面板
        JLayeredPane layeredPane = new JLayeredPane();
        DrawOffice drawOffice = new DrawOffice();
        drawOffice.setBounds(0, 0, 500, 500);
        layeredPane.add(drawOffice, 200);

        // office移动
        LeaderMove leaderMove = new LeaderMove();
        leaderMove.setBackground(Color.cyan);
        leaderMove.setBounds(100, 400, 100, 20);
        layeredPane.add(leaderMove, new Integer(300));
        // 线程更改图标位置
        Thread thread = new Thread(leaderMove);
        thread.start();

        // AI移动
        RadarAiMove radarAiMove = new RadarAiMove();
        radarAiMove.setBackground(Color.cyan);
        radarAiMove.setBounds(200, 420, 120, 20);
        layeredPane.add(radarAiMove, new Integer(300));
        Thread thread1 = new Thread(radarAiMove);
        thread1.start();

        // 过道移动
        GuodaoMove guodaoMove;
        String type = "cs1";
        if ("zc".equals(type)) {
            guodaoMove = new GuodaoMove(240, -20);
            guodaoMove.setBackground(Color.cyan);
            guodaoMove.setBounds(240, 320, 20, 80);
            layeredPane.add(guodaoMove, new Integer(300));
        } else if ("fm".equals(type)) {
            guodaoMove = new GuodaoMove(300, -20);
            guodaoMove.setBackground(Color.cyan);
            guodaoMove.setBounds(240, 260, 20, 140);
            layeredPane.add(guodaoMove, new Integer(300));
        } else if ("tw".equals(type)) {
            guodaoMove = new GuodaoMove(340, -20);
            guodaoMove.setBackground(Color.cyan);
            guodaoMove.setBounds(240, 220, 20, 180);
            layeredPane.add(guodaoMove, new Integer(300));
        } else if ("tf".equals(type)) {
            guodaoMove = new GuodaoMove(400, -20);
            guodaoMove.setBackground(Color.cyan);
            guodaoMove.setBounds(240, 160, 20, 240);
            layeredPane.add(guodaoMove, new Integer(300));
        } else if ("cs".equals(type)) {
            guodaoMove = new GuodaoMove(440, -20);
            guodaoMove.setBackground(Color.cyan);
            guodaoMove.setBounds(240, 120, 20, 280);
            layeredPane.add(guodaoMove, new Integer(300));
        } else {
            guodaoMove = new GuodaoMove(480, 0);
            guodaoMove.setBackground(Color.cyan);
            guodaoMove.setBounds(240, 80, 20, 320);
            layeredPane.add(guodaoMove, new Integer(300));
        }
        Thread thread3 = new Thread(guodaoMove);
        thread3.start();

        // 厕所移动
        CheSuoMove cheSuoMove = new CheSuoMove();
        cheSuoMove.setBackground(Color.GREEN);
        cheSuoMove.setBounds(180, 120, 60, 20);
        layeredPane.add(cheSuoMove, new Integer(300));
        Thread thread8 = new Thread(cheSuoMove);
        thread8.start();

        // 10楼门口移动
        TenFloorMove tenFloorMove = new TenFloorMove();
        tenFloorMove.setBackground(Color.GREEN);
        tenFloorMove.setBounds(180, 160, 60, 20);
        layeredPane.add(tenFloorMove, new Integer(300));
        Thread thread7 = new Thread(tenFloorMove);
        thread7.start();

        // 茶水间移动
        TeaWaterMove teaWaterMove = new TeaWaterMove();
        teaWaterMove.setBackground(Color.GREEN);
        teaWaterMove.setBounds(180, 220, 60, 20);
        layeredPane.add(teaWaterMove, new Integer(300));
        Thread thread6 = new Thread(teaWaterMove);
        thread6.start();

        // 第四会议室移动
        FourMeetMove fourMeetMove = new FourMeetMove();
        fourMeetMove.setBackground(Color.GREEN);
        fourMeetMove.setBounds(180, 260, 60, 20);
        layeredPane.add(fourMeetMove, new Integer(300));
        Thread thread5 = new Thread(fourMeetMove);
        thread5.start();

        // 知产部移动
        ZhiChanMove zhiChanMove = new ZhiChanMove();
        zhiChanMove.setBackground(Color.GREEN);
        zhiChanMove.setBounds(180, 320, 60, 20);
        layeredPane.add(zhiChanMove, new Integer(300));
        Thread thread4 = new Thread(zhiChanMove);
        thread4.start();

        // leader办公室到过道移动
        GuodaoOneMove guodaoOneMove = new GuodaoOneMove();
        guodaoOneMove.setBackground(Color.GREEN);
        guodaoOneMove.setBounds(200, 400, 60, 20);
        layeredPane.add(guodaoOneMove, new Integer(300));
        Thread thread2 = new Thread(guodaoOneMove);
        thread2.start();

        // 采购部移动
        CaiGouMove caiGouMove = new CaiGouMove();
        caiGouMove.setBackground(Color.GREEN);
        caiGouMove.setBounds(260, 120, 60, 20);
        layeredPane.add(caiGouMove, new Integer(300));
        Thread thread11 = new Thread(caiGouMove);
        thread11.start();

        // 产品部移动
        ProductMove productMove = new ProductMove();
        productMove.setBackground(Color.GREEN);
        productMove.setBounds(260, 220, 60, 20);
        layeredPane.add(productMove, new Integer(300));
        Thread thread10 = new Thread(productMove);
        thread10.start();

        // 软件研发部移动
        SoftMove softMove = new SoftMove();
        softMove.setBackground(Color.GREEN);
        softMove.setBounds(260, 320, 60, 20);
        layeredPane.add(softMove, new Integer(300));
        Thread thread9 = new Thread(softMove);
        thread9.start();

        jf.setContentPane(layeredPane);
        jf.setVisible(true);
    }
}
