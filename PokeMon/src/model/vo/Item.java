package model.vo;

import java.io.Serializable;

public class Item implements Serializable {
   
   private String iName;   //아이템 이름
   private int iNo;      //아이템 번호
   private int iPrice;      //아이템 가격
   private int iType;      //아이템 타입 -> 0 : ball(몬스터볼) / 1 : recovery(회복약) / 2 : stone(진화의 돌)
   private int iAmount = 0;   //아이템 현재수량
   private String iInfo;
   
   public Item() {}
   
   public Item(String iName, int iNo, int iPrice, int iType, int iAmount, String iInfo) {
	super();
	this.iName = iName;
	this.iNo = iNo;
	this.iPrice = iPrice;
	this.iType = iType;
	this.iAmount = iAmount;
	this.iInfo = iInfo;
}

   
   public String getiInfo() {
	return iInfo;
}

public void setiInfo(String iInfo) {
	this.iInfo = iInfo;
}

public int getiAmount() {
      return iAmount;
   }

   public void setiAmount(int iAmount) {
      this.iAmount = iAmount;
   }

   public String getiName() {
      return iName;
   }


   public int getiNo() {
      return iNo;
   }


   public int getiPrice() {
      return iPrice;
   }


   public int getiType() {
      return iType;
   }


   public void setiName(String iName) {
      this.iName = iName;
   }


   public void setiNo(int iNo) {
      this.iNo = iNo;
   }


   public void setiPrice(int iPrice) {
      this.iPrice = iPrice;
   }


   public void setiType(int iType) {
      this.iType = iType;
   }
}