
package com.spartans.dto;


public class OfficialInfo {
    private String name;
    private String address;
    private String city;
    private boolean varified;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isVarified() {
        return varified;
    }

    public void setVarified(boolean varified) {
        this.varified = varified;
    }
    
}
