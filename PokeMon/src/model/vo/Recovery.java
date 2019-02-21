package model.vo;

import java.awt.Image;

public class Recovery extends Item {
   
   private int rType;   //회복약 종류 -> 0 : 상 / 1 : 중 / 2 : 하
   private int rAmount;   //회복량
   
   public Recovery() {}
   
   public Recovery(String iName, int iNo, int iPrice, int iType, int iAmount, String iInfo, int rType, int rAmount) {
	super(iName, iNo, iPrice, iType, iAmount, iInfo);
	this.rType = rType;
	this.rAmount = rAmount;
}

public int getrType() {
      return rType;
   }

   public int getAmount() {
      return rAmount;
   }

   public void setrType(int rType) {
      this.rType = rType;
   }

   public void setAmount(int amount) {
      this.rAmount = amount;
   }

}