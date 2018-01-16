package com.martin;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TableUtil
{
    public static Map<String, Object> transferTable(String tableName)
            throws Exception
    {
        DatabaseMetaData metaData = DBUtil.connectionDB().getMetaData();
        ResultSet tableRet = metaData.getTables(null, "%", tableName, new String[] { "TABLE" });
        if (tableRet.next()) {
            System.out.println("Table is: " + tableRet.getString("TABLE_NAME").toUpperCase());
        } else {
            throw new Exception("Table not found!");
        }
        String columnName = null;
        String displayName = null;
        String displayNameSpace = null;
        String jdbcType = null;
        String columnType = null;
        TableAttr tableAttr = null;
        TableAttr keyAttr = null;
        String columnLength = null;
        String isKey = "N";
        String comment = null;

        ResultSet keyReset = metaData.getPrimaryKeys(null, null, tableName);
        Set keySet = new HashSet();
        while (keyReset.next()) {
            keySet.add(keyReset.getString("COLUMN_NAME"));
        }
        ResultSet colReset = metaData.getColumns(null, "%", tableName, "%");
        List<Object> columnList = new ArrayList();
        List<Object> keyList = new ArrayList();
        while (colReset.next())
        {
            columnName = colReset.getString("COLUMN_NAME");
            displayName = getDisplayName(columnName);
            displayNameSpace = getDisplayNameSpace(columnName);
            jdbcType = colReset.getString("TYPE_NAME");
            if ((jdbcType.equalsIgnoreCase("varchar")) || (jdbcType.equalsIgnoreCase("char")))
            {
                columnType = "String";
            }
            else if ((jdbcType.equalsIgnoreCase("unsigned")) || (jdbcType.equalsIgnoreCase("int unsigned")) || (jdbcType.equalsIgnoreCase("int")))
            {
                jdbcType = "INTEGER";
                columnType = "Integer";
            }
            else if (jdbcType.equalsIgnoreCase("text"))
            {
                jdbcType = "LONGVARCHAR";
                columnType = "String";
            }
            else if ((jdbcType.equalsIgnoreCase("bigint")) || (jdbcType.equalsIgnoreCase("bigint unsigned")))
            {
                jdbcType = "BIGINT";
                columnType = "Long";
            }
            else if (jdbcType.equalsIgnoreCase("smallint"))
            {
                columnType = "Short";
            }
            else if (jdbcType.equalsIgnoreCase("datetime"))
            {
                jdbcType = "TIMESTAMP";
                columnType = "Date";
            }
            else if (jdbcType.equalsIgnoreCase("date"))
            {
                columnType = "Date";
            }
            else if ((jdbcType.equalsIgnoreCase("tinyint")) || (jdbcType.equalsIgnoreCase("tinyint unsigned")))
            {
                columnType = "Byte";
            }
            columnLength = colReset.getString("COLUMN_SIZE");
            if (columnLength == null) {
                columnLength = "20";
            }
            comment = colReset.getString("REMARKS");
            if (keySet.contains(columnName))
            {
                isKey = "Y";
                keyAttr = new TableAttr(columnName, displayName, displayNameSpace, jdbcType, columnType, null, null, comment);
                keyList.add(keyAttr);
            }
            else
            {
                isKey = "N";
            }
            tableAttr = new TableAttr(columnName, displayName, displayNameSpace, jdbcType, columnType, columnLength, isKey, comment);
            columnList.add(tableAttr);
        }
        DBUtil.close();

        Map<String, Object> map = new HashMap();
        map.put("keyList", keyList);
        map.put("columnList", columnList);
        return map;
    }

    public static String getDisplayName(String columnName)
            throws Exception
    {
        String displayName = "";

        String[] array = columnName.split("_");
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                displayName = displayName + array[i].substring(0, 1).toLowerCase() + array[i].substring(1).toLowerCase();
            } else {
                displayName = displayName + array[i].substring(0, 1).toUpperCase() + array[i].substring(1).toLowerCase();
            }
        }
        return displayName;
    }

    public static String getDisplayNameSpace(String columnName)
            throws Exception
    {
        String displayNameSpace = "";

        String[] array = columnName.split("_");
        for (int i = 0; i < array.length; i++) {
            displayNameSpace = displayNameSpace + array[i].substring(0, 1).toUpperCase() + array[i].substring(1).toLowerCase() + " ";
        }
        return displayNameSpace.substring(0, displayNameSpace.length() - 1);
    }
}
