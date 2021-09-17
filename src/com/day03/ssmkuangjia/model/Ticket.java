package com.day03.ssmkuangjia.model;

public class Ticket
{
    private Integer id;
    private String start_station;
    private String stop_station;
    private Integer ticket_price;
    private String start_time;

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
                '}';
    }
    public Ticket(){}
    public Ticket(Integer id, String start_station, String stop_station, Integer ticket_price, String start_time) {
        this.id = id;
        this.start_station = start_station;
        this.stop_station = stop_station;
        this.ticket_price = ticket_price;
        this.start_time = start_time;
    }
}
