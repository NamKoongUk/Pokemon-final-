package model.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import model.vo.Skill;
import model.vo.User;

public class UserDao{
   private List<User> userList = new ArrayList<User>();

   
   //0217-01 
      public UserDao() {
      User user = new User("str",new Date(),500,new ArrayList(),new ArrayList(),new ArrayList(), new ArrayList());
      for(int i=0; i<9; i++) {
    	  user.getUi_list().add(null);
      }
      for(int i=0; i<4; i++) {
    	  user.getUp_list().add(null);
      }
      for(int i=0; i<4; i++) {
    	  user.getEp_list().add(null);
      }
      userList.add(user);
      
      
   }
      //0217-02
   public UserDao(String name) {
	   User user = new User(name);
	   //임시로 포켓몬 1마리 넣기
	  /* PokemonDao pd = new PokemonDao(); 
	      //포켓몬 속성 정의
	      int randomIndex = new Random().nextInt(10);
	      int randomLevel = new Random().nextInt(20)+10;
	      int randomAb = new Random().nextInt(50)+500;
	      user.getUp_list().add(pd.getpList().get(randomIndex));
	      user.getUp_list().get(0).setpLevel(randomLevel);
	      user.getUp_list().get(0).setExp(randomAb);
	      user.getUp_list().get(0).setpSpeed(randomAb);
	      user.getUp_list().get(0).setpMaxHp(randomAb);
	      user.getUp_list().get(0).setpType(0);
	      user.getUp_list().get(0).setpHp(user.getUp_list().get(0).getpMaxHp()/2);
	      SkillDao sd = new SkillDao();
	      //임의로 스킬 지정
	      ArrayList<Skill> skillList = new ArrayList<>(); 
	      for(int i=0; i<4; i++) {
	    	  Skill skill = new Skill();
	          int random = new Random().nextInt(18);
	          int ctn = new Random().nextInt(2);
	          skill = sd.getsList().get(random);
	          skillList.add(skill);
	      }
	      user.getUp_list().get(0).setpSkill(skillList);*/
	      
	   userList.add(user);
	   
	   /*user.getUp_list().add(pd.getpList().get(5));
	   user.getUp_list().get(1).setpHp(30);
	   user.getUp_list().get(1).setpMaxHp(30);
	   user.getUp_list().get(1).setGrade(2);
	   user.getUp_list().add(pd.getpList().get(6));
	   user.getUp_list().add(pd.getpList().get(7));
	   
	   user.getUp_list().get(1).getpSkill().add(sd.getsList().get(0));
	   user.getUp_list().get(1).getpSkill().add(sd.getsList().get(1));
	   user.getUp_list().get(1).getpSkill().add(sd.getsList().get(2));
	   user.getUp_list().get(1).getpSkill().add(sd.getsList().get(3));*/
   }
   public void saveUser() {
      try(ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("user.dat",true))){
         objOut.writeObject(userList);

      } catch(Exception e) {
         e.printStackTrace();
      }
   }
   public void loadUser() {
      try {
         ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"));
         userList = (List<User>) ois.readObject();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   public List<User> getUserList() {
	  System.out.println(userList);
      return userList;
   }
   public void setUserList(ArrayList<User> userList) {
      this.userList = userList;
   }
   

}