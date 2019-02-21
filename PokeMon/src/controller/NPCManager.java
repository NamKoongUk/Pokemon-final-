package controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.dao.SkillDao;
import model.vo.Item;
import model.vo.Pokemon;
import model.vo.Skill;
import model.vo.User;
import view.BattlePage;
import view.MainFrame;
import view.Map;

public class NPCManager {
   private User user;
   private Map m; 
   private JPanel panel;
   private BattlePage bp;
   private MainFrame mf;
   private BattleManager bm;
   private SkillDao sd = new SkillDao();


   public void NPCBattle(User user, Map m) {
      this.user = user;
      this.m = m;

      user.getEp_list().clear();
      System.out.println("NPC배틀 시작화면");

      //첫번째 NPC
      //if(m.getCtn() == 0) {
      if(m.getCtn() ==1) {
         user.getEp_list().add(new Pokemon("이상해꽃",3,1,3,50,700,0, new Item(), false,0, 0, 0, 0,new ArrayList<Skill>()));
      }else if(m.getCtn() == 2) {
         user.getEp_list().add(new Pokemon("리자몽",6,1,1,50,850,0, new Item(), false,0, 0, 0, 0,new ArrayList<Skill>()));
      }else if(m.getCtn() ==3) {
         user.getEp_list().add(new Pokemon("거북왕",9,1,2,50,1000,0, new Item(), false,0, 0, 0, 0,new ArrayList<Skill>()));
      }
      //user.getEp_list().add(new Pokemon("이상해씨",1,1,3,50,500,0,new Item(),false,0,0,0,50, new ArrayList<Skill>()));
      //user.getEp_list().add(new Pokemon("꼬부기",7,1,2,10,500,0,new Item(),false,0,0,0,50, new ArrayList<Skill>()));
      //user.getEp_list().add(new Pokemon("파이리",4,1,1,25,500,0,new Item(),false,0,0,0,50, new ArrayList<Skill>()));


      //포켓몬 스킬 정의
      while(user.getEp_list().get(0).getpSkill().size() < 5) {
         int random = new Random().nextInt(18);
         int ctn = new Random().nextInt(2);
         if(  user.getEp_list().get(0).getpType() == 0 && sd.getsList().get(random).getsType()==0) {
            user.getEp_list().get(0).getpSkill().add(sd.getsList().get(random));
         }
         if( user.getEp_list().get(0).getpType() == 1 && (sd.getsList().get(random).getsType()==0 || sd.getsList().get(random).getsType()==1)) {
            if(ctn == 0) {
               user.getEp_list().get(0).getpSkill().add(sd.getsList().get(random));
            }else {
               user.getEp_list().get(0).getpSkill().add(sd.getsList().get(random));
            }
         }
         if( user.getEp_list().get(0).getpType() == 2 && (sd.getsList().get(random).getsType()==0 || sd.getsList().get(random).getsType()==2)) {
            if(ctn == 0) {
               user.getEp_list().get(0).getpSkill().add(sd.getsList().get(random));
            }else {
               user.getEp_list().get(0).getpSkill().add(sd.getsList().get(random));
            }
         }
         if( user.getEp_list().get(0).getpType() == 3 && (sd.getsList().get(random).getsType()==0 || sd.getsList().get(random).getsType()==3)) {
            if(ctn == 0) {
               user.getEp_list().get(0).getpSkill().add(sd.getsList().get(random));
            }else {
               user.getEp_list().get(0).getpSkill().add(sd.getsList().get(random));
            }
         }
      }

      /*if(user.getEp_list().get(0).getpHp() == 0) {
         bp.setVisible(true);
         bm.enPChange(mf, m, user);
      }*/
   }
   /*
   public JPanel enPChange(MainFrame mf, JPanel bp,User user) {
      this.panel = bp;

      JOptionPane.showMessageDialog(null,  "상대 포켓몬이 쓰러졌다", "적 포켓몬 교체", 0);
      Pokemon zero = user.getEp_list().get(0);
      for(int i=1; i<user.getEp_list().size(); i++) {
         if(user.getEp_list().get(i).getpHp() > 0) {
            //            user.getEp_list().set(0, user.getEp_list().get(i));
            //            user.getEp_list().set(i, user.getEp_list().get(i+1));
            Pokemon temp = user.getEp_list().get(i);
            user.getEp_list().set(i, zero);
            user.getEp_list().set(0, temp);

            break;
         }
      }
      return panel;
   }*/
}