package com.company;

import com.company.entity.DestPlaceEnum;
import com.company.entity.LeaderTrace;
import com.company.move.*;
import com.company.office.DrawOffice;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目主函数
 *
 * @author sansan.si
 * @date 2022-01-25
 */
public class Main {

    /**
     * MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
     */
    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/behavior?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    /**
     * 数据库的用户名与密码，需要根据自己的设置
     */
    public static final String USER = "root";
    public static final String PASS = "123456";

    /**
     * AI雷达研究部
     */
    public static final String AI_DEPART = "ai";
    /**
     * 知产部
     */
    public static final String ZHICHAN_DEPART = "zhichan";
    /**
     * 第四会议室
     */
    public static final String FOURMEET_DEPART = "fourmeet";
    /**
     * 茶水间
     */
    public static final String TEAWATER_DEPART = "teawater";
    /**
     * 10楼门口
     */
    public static final String TENFLOOR_DEPART = "tenfloor";
    /**
     * 厕所
     */
    public static final String CESUO_DEPART = "cesuo";
    /**
     * 采购部
     */
    public static final String CAIGOU_DEPART = "caigou";
    /**
     * 产品部
     */
    public static final String CHANPIN_DEPART = "chanpin";
    /**
     * 软件部
     */
    public static final String RUANJIAN_DEPART = "ruanjian";

    public static void main(String[] args) {
        List<LeaderTrace> leaderTraces = getLeaderTraces();
        LeaderTrace leaderTrace = leaderTraces.get(0);
        String destPlace = leaderTrace.getDestPlace();
        System.out.println("历史轨迹目的地：" + DestPlaceEnum.getName(destPlace));
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

        Thread thread1 = new Thread(radarAiMove);
        if (AI_DEPART.equals(destPlace)) {
            layeredPane.add(radarAiMove, new Integer(300));
            thread1.start();
        }

        // 过道移动
        GuodaoMove guodaoMove;
        if (ZHICHAN_DEPART.equals(destPlace)) {
            guodaoMove = new GuodaoMove(240, -20);
            guodaoMove.setBackground(Color.cyan);
            guodaoMove.setBounds(240, 320, 20, 80);
            layeredPane.add(guodaoMove, new Integer(300));
        } else if (FOURMEET_DEPART.equals(destPlace)) {
            guodaoMove = new GuodaoMove(300, -20);
            guodaoMove.setBackground(Color.cyan);
            guodaoMove.setBounds(240, 260, 20, 140);
            layeredPane.add(guodaoMove, new Integer(300));
        } else if (TEAWATER_DEPART.equals(destPlace)) {
            guodaoMove = new GuodaoMove(340, -20);
            guodaoMove.setBackground(Color.cyan);
            guodaoMove.setBounds(240, 220, 20, 180);
            layeredPane.add(guodaoMove, new Integer(300));
        } else if (TENFLOOR_DEPART.equals(destPlace)) {
            guodaoMove = new GuodaoMove(400, -20);
            guodaoMove.setBackground(Color.cyan);
            guodaoMove.setBounds(240, 160, 20, 240);
            layeredPane.add(guodaoMove, new Integer(300));
        } else if (CESUO_DEPART.equals(destPlace)) {
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

        Thread thread8 = new Thread(cheSuoMove);
        if (CESUO_DEPART.equals(destPlace)) {
            layeredPane.add(cheSuoMove, new Integer(300));
            thread8.start();
        }

        // 10楼门口移动
        TenFloorMove tenFloorMove = new TenFloorMove();
        tenFloorMove.setBackground(Color.GREEN);
        tenFloorMove.setBounds(180, 160, 60, 20);

        Thread thread7 = new Thread(tenFloorMove);
        if (TENFLOOR_DEPART.equals(destPlace)) {
            layeredPane.add(tenFloorMove, new Integer(300));
            thread7.start();
        }

        // 茶水间移动
        TeaWaterMove teaWaterMove = new TeaWaterMove();
        teaWaterMove.setBackground(Color.GREEN);
        teaWaterMove.setBounds(180, 220, 60, 20);

        Thread thread6 = new Thread(teaWaterMove);
        if (TEAWATER_DEPART.equals(destPlace)) {
            layeredPane.add(teaWaterMove, new Integer(300));
            thread6.start();
        }

        // 第四会议室移动
        FourMeetMove fourMeetMove = new FourMeetMove();
        fourMeetMove.setBackground(Color.GREEN);
        fourMeetMove.setBounds(180, 260, 60, 20);

        Thread thread5 = new Thread(fourMeetMove);
        if (FOURMEET_DEPART.equals(destPlace)) {
            layeredPane.add(fourMeetMove, new Integer(300));
            thread5.start();
        }

        // 知产部移动
        ZhiChanMove zhiChanMove = new ZhiChanMove();
        zhiChanMove.setBackground(Color.GREEN);
        zhiChanMove.setBounds(180, 320, 60, 20);

        Thread thread4 = new Thread(zhiChanMove);
        if (ZHICHAN_DEPART.equals(destPlace)) {
            layeredPane.add(zhiChanMove, new Integer(300));
            thread4.start();
        }

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

        Thread thread11 = new Thread(caiGouMove);
        if (CAIGOU_DEPART.equals(destPlace)) {
            layeredPane.add(caiGouMove, new Integer(300));
            thread11.start();
        }

        // 产品部移动
        ProductMove productMove = new ProductMove();
        productMove.setBackground(Color.GREEN);
        productMove.setBounds(260, 220, 60, 20);

        Thread thread10 = new Thread(productMove);
        if (CHANPIN_DEPART.equals(destPlace)) {
            layeredPane.add(productMove, new Integer(300));
            thread10.start();
        }

        // 软件研发部移动
        SoftMove softMove = new SoftMove();
        softMove.setBackground(Color.GREEN);
        softMove.setBounds(260, 320, 60, 20);

        Thread thread9 = new Thread(softMove);
        if (RUANJIAN_DEPART.equals(destPlace)) {
            layeredPane.add(softMove, new Integer(300));
            thread9.start();
        }

        jf.setContentPane(layeredPane);
        jf.setVisible(true);
        System.err.println("行为分析项目启动成功");
    }

    /**
     * 获取历史轨迹集合
     *
     * @return
     */
    public static List<LeaderTrace> getLeaderTraces() {
        List<LeaderTrace> result = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, leader_id leaderId, dest_place destPlace, arrive_time arriveTime FROM leader_trace order by arriveTime asc";
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                int id = rs.getInt("id");
                int leaderId = rs.getInt("leaderId");
                String destPlace = rs.getString("destPlace");
                Date arriveTime = rs.getDate("arriveTime");

                LeaderTrace leaderTrace = new LeaderTrace();
                leaderTrace.setId(id);
                leaderTrace.setLeaderId(leaderId);
                leaderTrace.setDestPlace(destPlace);
                leaderTrace.setArriveTime(arriveTime);
                result.add(leaderTrace);
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
            return result;
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }// 什么都不做
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
        return result;
    }
}
