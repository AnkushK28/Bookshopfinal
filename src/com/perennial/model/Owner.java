package com.perennial.model;

public class Owner
{
    String ownerName;
    int mobileno;

    public Owner(String ownerName, int mobileno)
    {
        this.ownerName = ownerName;
         this.mobileno = mobileno;
    }

    @Override
    public String toString() {
        return
                "ownerName='" + ownerName + '\'' +
                ", mobileno=" + mobileno +

                ' ';
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getMobileno() {
        return mobileno;
    }
}
