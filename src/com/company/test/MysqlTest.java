package com.company.test;

import java.sql.*;

/**
 * @author: sansan.si
 * @vesion 1.0
 * @date: 2022-02-08 17:03
 * @description: mysql数据库连接测试
 **/
public class MysqlTest {
    /**
     *  MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
     */
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/behavior?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    /**
     *  数据库的用户名与密码，需要根据自己的设置
     */
    static final String USER = "root";
    static final String PASS = "123456";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, real_name realName, sex, age, depart_id departId, `position` FROM leader";
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("realName");
                String url = rs.getString("sex");

                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", 真实姓名: " + name);
                System.out.print(", 性别: " + url);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
