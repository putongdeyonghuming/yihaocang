package com.day02.chepiao.model;

public class query
{
    private Integer id;
    private String start_station;
    private String stop_station;
    private String  start_time;
    private Integer ticket_pricea;
    private Integer ticket_priceb;
    //下边是分页的参数
    //当前页
    private Integer currentPage=1;
    //每页显示条数
    private Integer pageSize=3;
    //查询出来页面的开始下标
    private Integer kaishixiabiao=0;

    public Integer getKaishixiabiao() {
        if (currentPage!=0 && pageSize!=0)
        {
            kaishixiabiao=(currentPage-1)*pageSize;
        }
        return kaishixiabiao;
    }

    public void setKaishixiabiao(Integer kaishixiabiao) {
        this.kaishixiabiao = kaishixiabiao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStart_station() {
        return start_station;
    }

    public void setStart_station(String start_station) {
        this.start_station = start_station;
    }

    public String getStop_station() {
        return stop_station;
    }

    public void setStop_station(String stop_station) {
        this.stop_station = stop_station;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public Integer getTicket_pricea() {
        return ticket_pricea;
    }

    public void setTicket_pricea(Integer ticket_pricea) {
        this.ticket_pricea = ticket_pricea;
    }

    public Integer getTicket_priceb() {
        return ticket_priceb;
    }

    public void setTicket_priceb(Integer ticket_priceb) {
        this.ticket_priceb = ticket_priceb;
    }

    @Override
    public String toString() {
        return "query{" +
                "id=" + id +
                ", start_station='" + start_station + '\'' +
                ", stop_station='" + stop_station + '\'' +
                ", start_time='" + start_time + '\'' +
                ", ticket_pricea=" + ticket_pricea +
                ", ticket_priceb=" + ticket_priceb +
                '}';
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
}
