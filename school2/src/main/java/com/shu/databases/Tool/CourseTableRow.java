package com.shu.databases.Tool;

import java.util.ArrayList;

/**
 * Created by Yisa on 2017/4/9.
 */
public class CourseTableRow {
    private int  RowIndex;
    private char[] tablerow;

    public CourseTableRow(char[] tablerow, int rowIndex) {
        this.tablerow = tablerow;
        RowIndex = rowIndex;
    }

    public char[] getTablerow() {
        return tablerow;
    }

    public void setTablerow(char[] tablerow) {
        this.tablerow = tablerow;
    }

    public int getRowIndex() {
        return RowIndex;
    }

    public void setRowIndex(int rowIndex) {
        RowIndex = rowIndex;
    }
}
