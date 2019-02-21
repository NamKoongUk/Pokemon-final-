package view;


import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.BattleManager;
import model.vo.User;


public class UserMenuPage extends JPanel {
   public final static int ESC = 27;
   //0217-01
   private UserMenuPage ump;
   private MainFrame mf;
   private Map m;
   private PInfoPage pip;
   private UserInfoPage uip;
   private SavePage sp;
   private UserInvenPage uivp;
   private PBookPage pb;

  

   private BattleManager bm;
   	

   private JLabel userMenuImage = new JLabel(new ImageIcon("images/userMenuImages/userMenuImage.png"));
   private JButton saveButton = new JButton(new ImageIcon("images/userMenuImages/savePageButton.PNG"));
   private JButton pBookButton = new JButton(new ImageIcon("images/userMenuImages/pBookButton.PNG"));
   private JButton pokemonInfoButton = new JButton(new ImageIcon("images/userMenuImages/pInfoButton.PNG"));
   private JButton userInfoButton = new JButton(new ImageIcon("images/userMenuImages/userInfoButton.PNG"));
   private JButton userInvenButton = new JButton(new ImageIcon("images/userMenuImages/userInvenButton.PNG"));
   private JButton backButton = new JButton(new ImageIcon("images/maketViewImages/marketViewBack.png"));

   


   //0217-01public UserMenuPage(MainFrame mf, JPanel panel, User user) {
      public UserMenuPage(MainFrame mf, Map m, User user) {
      this.ump = this;
      this.mf = mf;
      this.m = m;
      //this.uip = new UserInfoPage(mf, this,user);
      //0217-01this.pip = new PInfoPage(mf, this,user);
      //0217-01this.sp = new SavePage(mf, this);
      //0217-01this.uivp = new UserInvenPage(mf,this);
      //0217-01this.pb = new PBookPage(mf,this);
      userMenuImage.setBounds(0, 0, 1024, 768);
      
      
      
      settingButton(saveButton);
      this.setLayout(null);
      saveButton.setBounds(250, 220, 530, 80);
      pBookButton.setBounds(250,310,530, 80);
      pokemonInfoButton.setBounds(250,400,530, 80);
      userInfoButton.setBounds(250,490,530, 80);
      userInvenButton.setBounds(250,580,530, 80);
      backButton.setBounds(905, 657, 90, 60);
      
      saveButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            saveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
         }
         @Override
         public void mouseExited(MouseEvent e) {
            saveButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         }
         @Override
         public void mousePressed(MouseEvent e) {
            ump.setVisible(false);
            //0217-01 sp.setVisible(true);
            //0217-01 mf.add(sp);
            mf.add(new SavePage(mf, ump,user));
         }
      });

      this.add(saveButton);

      settingButton(pBookButton);
      pBookButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            pBookButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
         }
         @Override
         public void mouseExited(MouseEvent e) {
            pBookButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         }
         @Override
         public void mousePressed(MouseEvent e) {
            ump.setVisible(false);
            //0217-01 pb.setVisible(true);
            //0217-01 mf.add(pb);
            mf.add(new PBookPage(mf,ump));
         }
      });
      this.add(pBookButton);

      settingButton(pokemonInfoButton);
      pokemonInfoButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            pokemonInfoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
         }
         @Override
         public void mouseExited(MouseEvent e) {
            pokemonInfoButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         }
         @Override
         public void mousePressed(MouseEvent e) {
            ump.setVisible(false);
            //0217-01 pip.setVisible(true);
            //0217-01 mf.add(pip);
            mf.add(new PInfoPage(mf, ump,user));
         }
      });
      this.add(pokemonInfoButton);

      settingButton(userInfoButton);
      userInfoButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            userInfoButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
         }
         @Override
         public void mouseExited(MouseEvent e) {
            userInfoButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         }
         @Override
         public void mousePressed(MouseEvent e) {
            ump.setVisible(false);
            mf.add(new UserInfoPage(mf,ump,user));
         }
      });
      this.add(userInfoButton);

      settingButton(userInvenButton);

      userInvenButton.addMouseListener(new MouseAdapter() {

         @Override
         public void mouseEntered(MouseEvent e) {
            userInvenButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
         }
         @Override
         public void mouseExited(MouseEvent e) {
            userInvenButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         }
         @Override
         public void mousePressed(MouseEvent e) {
            ump.setVisible(false);
            //0217-01 uivp.setVisible(true);
            //0217-01 mf.add(uivp);
            mf.add(new UserInvenPage(mf, ump, user,m,bm)); //0217-01;
         }
      });
      this.add(userInvenButton);
      
      
      settingButton(backButton);
      backButton.setName("backButton");
      backButton.addMouseListener(new MouseAdapter() {
         
         @Override
         public void mouseEntered(MouseEvent e) {
            backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
         }
         @Override
         public void mouseExited(MouseEvent e) {
            backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
         }
         @Override
         public void mousePressed(MouseEvent e) {
            mf.remove(ump);
            m.setVisible(true);
            mf.requestFocus();
         }
      });
      this.add(backButton);
      this.add(userMenuImage);
      mf.addKeyListener(new KeyAdapter() {
         public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == 192) {
               mf.remove(ump);
               m.setVisible(true);
               mf.requestFocus();
            }
         }
      });
   }
   public void settingButton(JButton jb) {
      //jb.setBorderPainted(false);
      jb.setFocusPainted(false);
      jb.setContentAreaFilled(false);
   }





}