package com.day02.chepiao.model;

import com.day02.chepiao.model.Ticket;

import java.util.List;

public class fenyetiaojian {
//这个是和分页有关的，这里边是有数据的
    private List<Ticket> data;
    //当前页，每页显示条数，共多少页等参数，
    private Integer currentPage=1;
    //每页显示条数
    private Integer pageSize=2;
    //共多少条
    private Integer totalNum=3;
    //共多少页
    private Integer totalPage=4;

    public List<Ticket> getData() {
        return data;
    }

    public void setData(List<Ticket> data) {
        this.data = data;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "chaxuntiaojian{" +
                "data=" + data +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalNum=" + totalNum +
                ", totalPage=" + totalPage +
                '}';
    }
}
