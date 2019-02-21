package model.vo;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;

public class Pokemon implements Serializable{

   private String pName;   //포켓몬 이름
   private int pNo;      //포켓몬 번호
   private int pLevel;      //포켓몬 레벨
   private int pType;      //포켓몬 타입 -> 0 : 노말 / 1 : 불 / 2 : 물 / 3 : 풀
   private int pHp;      //포켓몬 HP
   private int pMaxHp;	 //포켓몬 maxHp
   private int pSpeed;      //포켓몬 스피드
   private Item pItem;      //포켓몬 아이템
   private boolean pEvoType;   //포켓몬 진화 방법 -> true : 진화의 돌 / false : 레벨업
   private int grade;      //포켓몬 등급 -> 0 : 상 / 1 : 중 / 2 : 하

   private int exp;      //현재 경험치
   private int pMaxExp;   //최대 경험치, 맥스에 도달하면 레벨업
   private int setExp;      //잡으면 얻게 되는 경험치
   public int getpMaxHp() {
	return pMaxHp;
}



public void setpMaxHp(int pMaxHp) {
	this.pMaxHp = pMaxHp;
}




   private ArrayList<Skill> pSkill;      //포켓몬 스킬


   public Pokemon() {}
   
   public Pokemon(Pokemon p) {
	   this.pName = p.pName;
	      this.pNo = p.pNo;
	      this.pLevel = p.pLevel;
	      this.pType = p.pType;
	      this.pHp = p.pHp;
	      this.pSpeed = p.pSpeed;
	      this.pItem = p.pItem;
	      this.pEvoType = p.pEvoType;
	      this.grade = p.grade;
	      this.exp = p.exp;
	      this.pMaxExp = p.pMaxExp;
	      this.setExp = p.setExp;
	      this.pSkill = p.pSkill;
	      this.pMaxHp = p.pMaxHp;
   }



   public Pokemon(String pName, int pNo, int pLevel, int pType, int pHp,int pMaxHp, int pSpeed, Item pItem, boolean pEvoType,
         int grade, int exp, int pMaxExp, int setExp, ArrayList<Skill> pSkill) {
      this.pName = pName;
      this.pNo = pNo;
      this.pLevel = pLevel;
      this.pType = pType;
      this.pHp = pHp;
      this.pSpeed = pSpeed;
      this.pItem = pItem;
      this.pEvoType = pEvoType;
      this.grade = grade;
      this.exp = exp;
      this.pMaxExp = pMaxExp;
      this.setExp = setExp;
      this.pSkill = pSkill;
      this.pMaxHp = pMaxHp;
   }

   public String getpName() {
      return pName;
   }


   public int getpNo() {
      return pNo;
   }


   public int getpLevel() {
      return pLevel;
   }


   public int getpType() {
      return pType;
   }


   public int getpHp() {
      return pHp;
   }


   public int getpSpeed() {
      return pSpeed;
   }


   public Item getpItem() {
      return pItem;
   }


   public boolean ispEvoType() {
      return pEvoType;
   }





   public int getGrade() {
      return grade;
   }


   public int getExp() {
      return exp;
   }


   public int getpMaxExp() {
      return pMaxExp;
   }


   public int getSetExp() {
      return setExp;
   }


   public ArrayList<Skill> getpSkill() {
      return pSkill;
   }


   public void setpName(String pName) {
      this.pName = pName;
   }


   public void setpNo(int pNo) {
      this.pNo = pNo;
   }


   public void setpLevel(int pLevel) {
      this.pLevel = pLevel;
   }


   public void setpType(int pType) {
      this.pType = pType;
   }


   public void setpHp(int pHp) {
      this.pHp = pHp;
   }


   public void setpSpeed(int pSpeed) {
      this.pSpeed = pSpeed;
   }


   public void setpItem(Item pItem) {
      this.pItem = pItem;
   }


   public void setpEvoType(boolean pEvoType) {
      this.pEvoType = pEvoType;
   }





   public void setGrade(int grade) {
      this.grade = grade;
   }


   public void setExp(int exp) {
      this.exp = exp;
   }


   public void setpMaxExp(int pMaxExp) {
      this.pMaxExp = pMaxExp;
   }


   public void setSetExp(int setExp) {
      this.setExp = setExp;
   }


   public void setpSkill(ArrayList<Skill> pSkill) {
      this.pSkill = pSkill;
   }
}