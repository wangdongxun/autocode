package com.martin;

public class TableAttr
{
    public String columnName;
    public String displayName;
    public String displayNameSpace;
    public String jdbcType;
    public String columnType;
    public String columnLength;
    public String comment;
    public String isKey;

    public TableAttr(String columnName, String displayName, String displayNameSpace, String jdbcType, String columnType, String columnLength, String isKey, String comment)
    {
        this.columnName = columnName;
        this.displayName = displayName;
        this.displayNameSpace = displayNameSpace;
        this.jdbcType = jdbcType;
        this.columnType = columnType;
        this.columnLength = columnLength;
        this.comment = comment;
        this.isKey = isKey;
    }

    public String getColumnName()
    {
        return this.columnName;
    }

    public void setColumnName(String columnName)
    {
        this.columnName = columnName;
    }

    public String getDisplayName()
    {
        return this.displayName;
    }

    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }

    public String getDisplayNameSpace()
    {
        return this.displayNameSpace;
    }

    public void setDisplayNameSpace(String displayNameSpace)
    {
        this.displayNameSpace = displayNameSpace;
    }

    public String getJdbcType()
    {
        return this.jdbcType;
    }

    public void setJdbcType(String jdbcType)
    {
        this.jdbcType = jdbcType;
    }

    public String getColumnType()
    {
        return this.columnType;
    }

    public void setColumnType(String columnType)
    {
        this.columnType = columnType;
    }

    public String getColumnLength()
    {
        return this.columnLength;
    }

    public void setColumnLength(String columnLength)
    {
        this.columnLength = columnLength;
    }

    public String getComment()
    {
        return this.comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public String getIsKey()
    {
        return this.isKey;
    }

    public void setIsKey(String isKey)
    {
        this.isKey = isKey;
    }
}
