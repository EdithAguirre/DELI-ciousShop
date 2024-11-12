package com.pluralsight;

public class Topping {

    private boolean premium, meat, extra;
    private String name;

    public Topping(boolean premium, String name) {
        this.premium = premium;
        this.name = name;
    }
    public Topping(boolean premium, String name, boolean extra, boolean meat) {
        this.premium = premium;
        this.name = name;
        this.extra = extra;
        this.meat = meat;
    }

    public boolean isPremium() {
        return this.premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public boolean isExtra() {
        return this.extra;
    }

    public void setExtra(boolean extra) {
        this.extra = extra;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMeat() {
        return this.meat;
    }

    public void setMeat(boolean meat) {
        this.meat = meat;
    }
}
