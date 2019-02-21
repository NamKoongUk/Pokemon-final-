package model.vo;

import java.io.Serializable;

//직렬화 처리
public class Skill implements Serializable {

   private String sName;   //스킬이름
   private int sNum;      //스킬 넘버
   private int sType;      //스킬타입
   private int sAtt;      //스킬 공격력
   
   public Skill() {}
   
   public Skill(String sName, int sNum, int sType, int sAtt) {
      this.sType = sType;
      this.sNum = sNum;
      this.sName = sName;
      this.sAtt = sAtt;
   }

   public String getsName() {
      return sName;
   }
   
   public int getsNum() {
      return sNum;
   }
   
   public int getsType() {
      return sType;
   }

   public int getsAtt() {
      return sAtt;
   }
   
   
   public void setsName(String sName) {
      this.sName = sName;
   }
   public void setsNum(int sNum) {
      this.sNum = sNum;
   }
   
   public void setsType(int sType) {
      this.sType = sType;
   }
   public void setsAtt(int sAtt) {
      this.sAtt = sAtt;
   }
   
}