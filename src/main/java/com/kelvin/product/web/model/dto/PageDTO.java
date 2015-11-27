package com.kelvin.product.web.model.dto;

/**
 * Created by tangshulei on 2015/11/27.
 */
public class PageDTO {

    public static final String PAGE_ORDER0_TYPE_DESC = "DESC";
    public static final String PAGE_ORDER0_TYPE_ASC = "ASC";

    private int pageNum;
    private int pageSize;
    private String order;
    private String orderType;
    private int curPage;
    private int total;

    public PageDTO(){
        super();
    }

    public PageDTO(int pageNum, int total, int curPage, String order, String orderType){
        this.pageNum = pageNum;
        this.total = total;
        this.curPage = curPage;
        this.order = order;
        this.orderType = orderType;
        this.pageSize = (int)Math.ceil(total/pageNum);
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
