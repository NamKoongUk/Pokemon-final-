package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.BattleManager;
import controller.ItemManager;
import model.vo.Pokemon;
import model.vo.User;

public class PInfoPage extends JPanel{
   //0217-01
   private MainFrame mf;
   private Map m;
   private JPanel pip;
   private UserMenuPage ump;
   private JPanel oldPage;
   private BattlePage bp;
   private User user;
   private BattleManager bm = new BattleManager();
   private Thread th;
   //private NpcBattlePage nbp;

   private JLabel[] pInfo = new JLabel[4];
   private JTextArea[] pInfoText = new JTextArea[4];
   private JButton backButton = new JButton(new ImageIcon("images/maketViewImages/marketViewBack.png"));
   private Image pInfoBackground = new ImageIcon("images/pInfoPage.png").getImage();


   public PInfoPage(MainFrame mf, JPanel oldPage, User user) {

      this.mf = mf;
      this.pip = this;
      //this.ump = ump;
      this.oldPage = oldPage; //JPanel 로 받아 유저메뉴/배틀페이지  페이지 받기
      this.user = user;

      pip.setOpaque(false);
      pip.setBounds(0, 0, 1024, 768);
      JLabel j = new JLabel();
      for(int i=0; i < pInfo.length; i++) {
         pInfo[i] = new JLabel();
         pInfo[i] = new JLabel(new ImageIcon("images/userMenuImages/pInfo4.png"));
      }
      for(int i=0; i < pInfo.length; i++) {
         pInfoText[i] = new JTextArea();

         pInfoText[i].setBackground(new Color(0,0,0,0));
      }

      bm.showP((PInfoPage) pip, user);

      mf.addKeyListener(new KeyAdapter() {
         public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == UserMenuPage.ESC) {
               mf.remove(pip);
               pip.setVisible(false);
            }
         }
      });


      JLabel label = new JLabel();
      label.setText("  ");

      pip.setBackground(Color.WHITE);
      pip.setLayout(null);
      backButton.setBounds(905, 657, 90, 60);


      backButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {

         }
         @Override
         public void mouseExited(MouseEvent e) {

         }
         @Override
         public void mousePressed(java.awt.event.MouseEvent e) {
            mf.remove(pip);
            oldPage.setVisible(true);
            mf.requestFocus();

         }
      });
      
         pInfo[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               pip.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
               pip.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
               //선택된 포켓몬 이름
            	if(user.getUp_list().size()>=1) {
            		bm.changeP(mf,oldPage, user, user.getUp_list().get(0));
            	}
            }
         });
         pInfo[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               pip.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
               pip.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
            	if(user.getUp_list().size()>=2) {
            		bm.changeP(mf,oldPage, user, user.getUp_list().get(1));
            	}
            }
         });
         pInfo[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               pip.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
               pip.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
            	if(user.getUp_list().size()>=3) {
            		bm.changeP(mf,oldPage, user, user.getUp_list().get(2));
            	}
            }
         });
         pInfo[3].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               pip.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
               pip.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
            	if(user.getUp_list().size()>=4) {
            		bm.changeP(mf,oldPage, user, user.getUp_list().get(3));
            	}
            }
         });
      //}




      label.setBounds(450, 20, 200, 40);
      pInfo[0].setBounds(120, 120, 300, 200);
      pInfo[1].setBounds(530, 120, 300, 200);
      pInfo[2].setBounds(120, 410, 300, 200);
      pInfo[3].setBounds(530, 410, 300, 200);

      pInfoText[0].setBounds(245,160,280,130);
      pInfoText[1].setBounds(655,160,280,130);
      pInfoText[2].setBounds(245,455,280,130);
      pInfoText[3].setBounds(655,455,280,130);


      pip.add(label);

      pip.add(backButton);
      pip.add(pInfo[0]);
      pip.add(pInfo[1]);
      pip.add(pInfo[2]);
      pip.add(pInfo[3]);
      pip.add(pInfoText[0]);
      pip.add(pInfoText[1]);
      pip.add(pInfoText[2]);
      pip.add(pInfoText[3]);




   }



   //아이템 사용(유저인벤에서)연결
   public PInfoPage(MainFrame mf, JPanel oldPage, User user,String userItemName) {


      this.mf = mf;
      this.pip = this;
      //this.ump = ump;
      this.oldPage = oldPage; //JPanel 로 받아 유저메뉴/배틀페이지  페이지 받기
      this.user = user;

      pip.setOpaque(false);
      pip.setBounds(0, 0, 1024, 768);
      JLabel j = new JLabel();
      for(int i=0; i < pInfo.length; i++) {
         pInfo[i] = new JLabel();
         pInfo[i] = new JLabel(new ImageIcon("images/userMenuImages/pInfo4.png"));
      }
      for(int i=0; i < pInfo.length; i++) {
         pInfoText[i] = new JTextArea();

         pInfoText[i].setBackground(new Color(0,0,0,0));
      }

      bm.showP((PInfoPage) pip, user);


      mf.addKeyListener(new KeyAdapter() {
         public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == UserMenuPage.ESC) {
               mf.remove(pip);
               pip.setVisible(false);
            }
         }
      });

      JLabel label = new JLabel();
      label.setText("  ");

      pip.setBackground(Color.WHITE);
      pip.setLayout(null);
      backButton.setBounds(905, 657, 90, 60);


      backButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {

         }
         @Override
         public void mouseExited(MouseEvent e) {

         }
         @Override
         public void mousePressed(java.awt.event.MouseEvent e) {
            mf.remove(pip);
            oldPage.setVisible(true);
            mf.requestFocus();

         }
      });



      label.setBounds(450, 20, 200, 40);
      pInfo[0].setBounds(120, 120, 300, 200);
      pInfo[1].setBounds(530, 120, 300, 200);
      pInfo[2].setBounds(120, 410, 300, 200);
      pInfo[3].setBounds(530, 410, 300, 200);

      pInfoText[0].setBounds(245,160,280,130);
      pInfoText[1].setBounds(655,160,280,130);
      pInfoText[2].setBounds(245,455,280,130);
      pInfoText[3].setBounds(655,455,280,130);


      pip.add(label);

      pip.add(backButton);
      pip.add(pInfo[0]);
      pip.add(pInfo[1]);
      pip.add(pInfo[2]);
      pip.add(pInfo[3]);
      pip.add(pInfoText[0]);
      pip.add(pInfoText[1]);
      pip.add(pInfoText[2]);
      pip.add(pInfoText[3]);


      if((oldPage instanceof UserInvenPage)) {
         pInfo[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               pip.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
               pip.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
               //선택된 포켓몬 이름
               String pName = pInfo[0].getName();
               itemUsedDialog(userItemName,pName);
            }
         });
         pInfo[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               pip.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
               pip.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
               String pName = pInfo[1].getName();
               itemUsedDialog(userItemName,pName);
            }
         });
         pInfo[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               pip.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
               pip.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
               String pName = pInfo[2].getName();
               itemUsedDialog(userItemName,pName);
            }
         });
         pInfo[3].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
               pip.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
               pip.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
               String pName = pInfo[3].getName();
               itemUsedDialog(userItemName,pName);
            }
         });
      }

   }

   public void itemUsedDialog(String userItemName,String pName) {
      int result = JOptionPane.showConfirmDialog(null, "아이템 사용하시겠습니까??", "아이템 사용",JOptionPane.YES_NO_OPTION);

      Pokemon poke = null;
      ArrayList<Pokemon> up_list = (ArrayList<Pokemon>) user.getUp_list();

      for(int i=0; i<up_list.size(); i++) {
         if(up_list.get(i).getpName().equals(pName)) {
            poke = up_list.get(i);
         }
      }

      if(result == 0) {
         new ItemManager(user).useItem(userItemName,poke);
         pip.setVisible(false);
         mf.remove(pip);
         mf.remove(oldPage);
         mf.add(((UserInvenPage) oldPage).getOldPage());
         ((UserInvenPage) oldPage).getOldPage().setVisible(true);
         mf.requestFocus();
      } else {
         pip.setVisible(false);
         mf.remove(pip);
         mf.add(oldPage);
         oldPage.setVisible(true);
      }
   }




   public JLabel[] getpInfo() {
      return pInfo;
   }

   public void setpInfo(JLabel[] pInfo) {
      this.pInfo = pInfo;
   }

   public JTextArea[] getpInfoText() {
      return pInfoText;
   }

   public void setpInfoText(JTextArea[] pInfoText) {
      this.pInfoText = pInfoText;
   }

   public void paintComponent(Graphics g) {
      g.drawImage(pInfoBackground, 0, 0, 1024, 729, this);
   }      


}


















