package com.example.demo.entity;

public class Colu {

    private Integer id;
    private String name;
    private int parent_id;
    private int order_num;
    private int statu;

    public Colu(Integer id, String name, int parent_id, int order_num, int statu) {
        this.id = id;
        this.name = name;
        this.parent_id = parent_id;
        this.order_num = order_num;
        this.statu = statu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public int getOrder_num() {
        return order_num;
    }

    public void setOrder_num(int order_num) {
        this.order_num = order_num;
    }

    public int getStatu() {
        return statu;
    }

    public void setStatu(int statu) {
        this.statu = statu;
    }

    @Override
    public String toString() {
        return "Colu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parent_id=" + parent_id +
                ", order_num=" + order_num +
                ", statu=" + statu +
                '}';
    }
}
