package com.ecas.model;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lenovo on 2017/12/9.
 */
public class PageContext {
    private int pagePerRow = 10;
    private boolean pageState = false;

    public static PageContext getContext(HttpServletRequest request,int pagePerRow){
        return null;
    }

    public int getPagePerRow() {
        return pagePerRow;
    }

    public void setPagePerRow(int pagePerRow) {
        this.pagePerRow = pagePerRow;
    }

    public boolean isPageState() {
        return pageState;
    }

    public void setPageState(boolean pageState) {
        this.pageState = pageState;
    }
}
