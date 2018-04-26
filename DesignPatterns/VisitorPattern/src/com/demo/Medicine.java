package com.demo;

/**
 * 药品--抽象元素
 */
public abstract class Medicine {
    private String name;    //药名
    private Double price;    //药价

    public Medicine(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    //接受访问者
    public abstract void accept(IVisitor visitor);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
