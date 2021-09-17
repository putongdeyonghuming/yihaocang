package com.day04.ssmspring.model;

public class Ticket
{
    private Integer id;
    private String start_station;
    private String stop_station;
    private Integer ticket_price;
    private String start_time;
    private siji siji;/*//关联司机对象*/

    public com.day04.ssmspring.model.siji getSiji() {
        return siji;
    }

    public void setSiji(com.day04.ssmspring.model.siji siji) {
        this.siji = siji;
    }

    public  Ticket()
    {
        System.out.println("------这是Ticket的构造方法-------");
    }

    public Ticket(String start_station, String stop_station) {
        this.start_station = start_station;
        this.stop_station = stop_station;
    }

    public void Init()
    {
        System.out.println("------这是spring里创建对象时候执行的方法-------");
    }
    public void Init1()
    {
        System.out.println("------这是spring里创建对象关闭时候的方法-------");
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

    public Integer getTicket_price() {
        return ticket_price;
    }

    public void setTicket_price(Integer ticket_price) {
        this.ticket_price = ticket_price;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", start_station='" + start_station + '\'' +
                ", stop_station='" + stop_station + '\'' +
                ", ticket_price=" + ticket_price +
                ", start_time='" + start_time + '\'' +
                ", siji=" + siji +
                '}';
    }

    public Ticket(Integer id, String start_station, String stop_station, Integer ticket_price, String start_time) {
        this.id = id;
        this.start_station = start_station;
        this.stop_station = stop_station;
        this.ticket_price = ticket_price;
        this.start_time = start_time;
    }
}
