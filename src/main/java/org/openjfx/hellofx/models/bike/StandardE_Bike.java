package org.openjfx.hellofx.models.bike;

public class StandardE_Bike implements TypeOfBike{
    public int depositAmount(){
        return 700000;
    };
    public int first30minAmount(){
        return 15000;
    };
    public int after30minAmount(){
        return 4500;
    };
    public int calculateTotal(int time){
        if(time>30){
            return this.first30minAmount() + (int) Math.ceil((time-30)/15)*this.after30minAmount();
        }
        else if(time<10){
            return 0;
        }
        else{
            return this.first30minAmount();
        }
    };
}
