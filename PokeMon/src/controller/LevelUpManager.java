package controller;

import model.vo.User;

public class LevelUpManager {
   
   User user;
   int level;
   int exp;
   int maxexp;
   int maxHp;
   int pSpeed;
   
   
   public LevelUpManager() {}
   
   public void levelup(User user) {
      this.user = user;
      level = user.getUp_list().get(0).getpLevel();
      exp = user.getUp_list().get(0).getExp();
      maxexp = user.getUp_list().get(0).getpMaxExp();
      maxHp = user.getUp_list().get(0).getpMaxHp();
      pSpeed = user.getUp_list().get(0).getpSpeed();
      
      if(exp >= maxexp) {
         System.out.println("레벨업!!");
         System.out.println("레벨 업 전 수치 : " + level + ", "+ exp + ", "+ maxexp + ", "+ maxHp + ", "+ pSpeed);
         user.getUp_list().get(0).setpLevel(level+1);
         user.getUp_list().get(0).setExp(0);
         user.getUp_list().get(0).setpMaxHp((int)(maxHp*1.2));
         user.getUp_list().get(0).setpMaxExp((int)(maxexp*1.2));
         user.getUp_list().get(0).setpSpeed((int)(pSpeed*1.1));
         System.out.println("레벨 업 후 수치 : " + maxHp + ", "+ pSpeed);
         
         
      }
      
   }
   
}