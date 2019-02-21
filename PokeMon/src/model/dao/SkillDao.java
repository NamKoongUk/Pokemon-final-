package model.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.vo.Skill;

public class SkillDao implements Serializable{
   private List<Skill> sList = new ArrayList<Skill>();
   private int num = 0;   



   public List<Skill> getsList() {
	return sList;
}

public void setsList(List<Skill> sList) {
	this.sList = sList;
}

public SkillDao() {
      //Ã³À½ µ¥ÀÌÅÍ ÀÔ·Â¿ë
      
      sList.add(new Skill("¸ð¾ß¸ð¾ß",100,0,0));
      sList.add(new Skill("¸öÅë¹ÚÄ¡±â",1,0,15));
      sList.add(new Skill("Àü±¤¼®È­",2,0,18));
      sList.add(new Skill("¿¬¼Ó»´Ä¡±â",3,0,13));
      sList.add(new Skill("ÀëÀëÆÝÄ¡",4,0,10));
      sList.add(new Skill("ÆÄ±«±¤¼±",5,0,20));
      sList.add(new Skill("ºÒ²É¼¼·Ê",6,1,12));
      sList.add(new Skill("È­¿°¹æ»ç",7,1,16));
      sList.add(new Skill("´ÏÆ®·ÎÂ÷Áö",8,1,14));
      sList.add(new Skill("ºÒ´ë¹®ÀÚ",9,1,18));
      sList.add(new Skill("¹°´ëÆ÷",10,2,12));
      sList.add(new Skill("ÇÏÀÌµå·ÎÆßÇÁ",11,2,16));
      sList.add(new Skill("¾ÆÄí¾ÆÅ×ÀÏ",12,2,14));
      sList.add(new Skill("ÆÄµµÅ¸±â",13,2,18));
      sList.add(new Skill("¾¾»Ñ¸®±â",14,3,12));
      sList.add(new Skill("µ¢ÄðÃ¤Âï",15,3,14));
      sList.add(new Skill("ÀÙ³¯°¡¸£±â",16,3,16));
      sList.add(new Skill("¼Ö¶óºö",17,3,18));
	//outputSkill();
   }
   
   public void inputSkill() {
      try {
         ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Skill.dat",true));
         
         oos.writeObject(sList);
      }catch(IOException e) {
         e.printStackTrace();
      }
   }
   
   public void outputSkill() {
      try {
         ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Skill.dat"));
         
         sList = (List<Skill>) ois.readObject();
         
      }catch(IOException e) {
         e.printStackTrace();
      }catch(ClassNotFoundException e) {
         e.printStackTrace();
      }
   }
   
}