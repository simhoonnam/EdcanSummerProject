package com.example.money;

/**
 * Created by 훈 on 2016-11-10.
 */
public class model {

    private String pluseminus;
    private String muchmoney;

    public model(){

    }

    public model(String pluseminus,String muchmoney){
        this.pluseminus=pluseminus;
        this.muchmoney=muchmoney;
    }

    public String getPluseminus(){
        return pluseminus;
    }

    public void setPluseminus(String pluseminus){
        this.pluseminus=pluseminus;
    }

    public String getMuchmoney() {
        return this.muchmoney;
    }

    public void setMuchmoney(String muchmoney) {
        this.muchmoney=muchmoney;
    }
}
