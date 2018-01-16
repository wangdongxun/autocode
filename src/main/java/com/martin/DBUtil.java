package com.martin;

import java.sql.*;
import java.util.Map;

public class DBUtil
{
    private static Connection conn = null;
    private static Map<String, String> xmlMap;
    private static ResultSet resultSet = null;
    private static PreparedStatement pstmt = null;

    public DBUtil()
            throws Exception
    {
        conn = connectionDB();
    }

    public static Connection connectionDB()
    {
        try
        {
            XmlRead xmlRead = new XmlRead();
            xmlMap = xmlRead.getXml();
            Class.forName((String)xmlMap.get("driverClassName"));
            conn = DriverManager.getConnection((String)xmlMap.get("url"), (String)xmlMap.get("username"), (String)xmlMap.get("password"));
            System.out.println("DB connect success!");

            return conn;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return conn;
        }finally {}
    }

    public static boolean close()
    {
        boolean isClose = false;
        if (resultSet != null) {
            try
            {
                resultSet.close();
                resultSet = null;
                isClose = true;
            }
            catch (SQLException e)
            {
                isClose = false;
                e.printStackTrace();
                System.out.println("关闭结果通知");
            }
        }
        if (pstmt != null) {
            try
            {
                pstmt.close();
                pstmt = null;
                isClose = true;
            }
            catch (SQLException e)
            {
                isClose = false;
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try
            {
                conn.close();
                conn = null;
                isClose = true;
            }
            catch (Exception e)
            {
                isClose = false;
                e.printStackTrace();
            }
        }
        return isClose;
    }
}