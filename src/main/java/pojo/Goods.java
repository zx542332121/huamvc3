package pojo;

import java.sql.Date;

public class Goods {
    private int id;
    private String g_name;
    private double g_price;
    private Date g_date;

    public Goods(int id, String g_name, double g_price, Date g_date) {
        this.id = id;
        this.g_name = g_name;
        this.g_price = g_price;
        this.g_date = g_date;
    }

    public Goods() {

    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", g_name='" + g_name + '\'' +
                ", g_price=" + g_price +
                ", g_date=" + g_date +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public double getG_price() {
        return g_price;
    }

    public void setG_price(double g_price) {
        this.g_price = g_price;
    }

    public Date getG_date() {
        return g_date;
    }

    public void setG_date(Date g_date) {
        this.g_date = g_date;
    }
}
