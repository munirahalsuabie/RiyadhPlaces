package com.riyadhplaces.entities;

public class Drink implements Identifiable {

    private Long id;
    private Long Phone_Number;
    private String Address;
    private String Dri_Type;
    private String Dri_Name;

    public Drink() {
    }

    public Drink(Long id, String Dri_Type , String Dri_Name, String Address, Long Phone_Number) {
        this.id = id;
        this.Phone_Number = Phone_Number;
        this.Address = Address;
        this.Dri_Type = Dri_Type;
        this.Dri_Name = Dri_Name;
    }

    public Drink ( String Dri_Type , String Dri_Name, String Address, Long Phone_Number) {
        this(null, Dri_Type, Dri_Name, Address, Phone_Number);

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(Long Phone_Number) {
        this.Phone_Number = Phone_Number;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getDri_Type() {
        return Dri_Type;
    }

    public void setDri_Type(String Dri_Type) {
        this.Dri_Type = Dri_Type;
        
    }

    public String getDri_Name() {
        return Dri_Name;
    }

    public void setDri_Name(String Dri_Name) {
        this.Dri_Name = Dri_Name;
    }

    @Override
    public String toString() {
        return "Drink{" + "id=" + id + ", Phone_Number=" + Phone_Number + ", Address=" + Address + ", Dri_Type=" + Dri_Type + ", Dri_Name=" + Dri_Name + '}';
    }

}
