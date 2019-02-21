package model.vo;

import java.awt.Image;

public class Ball extends Item {
   
   private int cProb;   //포켓몬 잡는 확률
   private int cType;   //볼 종류 -> 0 : 마스터볼 / 1 : 슈퍼볼 / 2 : 몬스터볼
   
   
   public Ball() {}
   

   public Ball(String iName, int iNo, int iPrice, int iType, int iAmount, String iInfo, int cProb, int cType) {
	super(iName, iNo, iPrice, iType, iAmount, iInfo);
	this.cProb = cProb;
	this.cType = cType;
}


public int getcProb() {
      return cProb;
   }

   public int getcType() {
      return cType;
   }

   public void setcProb(int cProb) {
      this.cProb = cProb;
   }

   public void setcType(int cType) {
      this.cType = cType;
   }
   
   

}