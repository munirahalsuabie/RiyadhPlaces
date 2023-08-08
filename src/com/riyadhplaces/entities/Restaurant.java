
package com.riyadhplaces.entities;

public class Restaurant implements Identifiable{
    
    private Long id;
    private Long Phone_Number;
    private String Address;
    private String Res_Type;
    private String Res_Name;

    public Restaurant() {
    }
//Long id, String Dri_Type , String Dri_Name, String Address, int Phone_Number)
    public Restaurant(Long id,String Res_Type, String Res_Name, String Address, Long Phone_Number) {
        this.id = id;
        this.Phone_Number = Phone_Number;
        this.Address = Address;
        this.Res_Type = Res_Type;
        this.Res_Name = Res_Name;
    }

    public Restaurant (String Res_Type, String Res_Name, String Address, Long Phone_Number) {
        this(null , Res_Type , Res_Name , Address , Phone_Number);
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

    public String getRes_Type() {
        return Res_Type;
    }

    public void setRes_Type(String Res_Type) {
        this.Res_Type = Res_Type;
    }

    public String getRes_Name() {
        return Res_Name;
    }

    public void setRes_Name(String Res_Name) {
        this.Res_Name = Res_Name;
    }    

    @Override
    public String toString() {
        return "Restaurant{" + "id=" + id + ", Phone_Number=" + Phone_Number + ", Address=" + Address + ", Res_Type=" + Res_Type + ", Res_Name=" + Res_Name + '}';
    }
    
       
}