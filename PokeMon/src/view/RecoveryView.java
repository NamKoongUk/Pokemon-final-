package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import controller.MCManager;
import model.vo.Pokemon;
import model.vo.User;
import music.Music;

public class RecoveryView extends JPanel{
   private MainFrame mf;
   private RecoveryView recoveryView;
   private Map m;
   private Image backButtonImage = new ImageIcon("images/maketViewImages/marketViewBack.png").getImage();
   private JButton backButton = new JButton(new ImageIcon(backButtonImage));
   private MCManager mc;
   private int ans=0;
   private Image recoveryBackground = new ImageIcon("images/maketViewImages/recoveryView.gif").getImage();
   private User user;
   private PInfoPage pinfo;
   private JButton resultYes = new JButton("모두 회복되었습니다.");
   private Dialog yes = new Dialog(mf); 
   private CenterView centerView;
   private Music m_vill = new Music("heal.mp3", false);
   
   
   
   public RecoveryView(MainFrame mf, JPanel oldPage, User user) {
     mc = new MCManager(user);
     this.mf=mf;
      this.recoveryView=this;
      this.centerView = (CenterView)oldPage;
      
      this.setLayout(null);
      this.setBounds(0,0,1024,768);
      this.setBackground(Color.BLUE);

      JLabel recover = new JLabel("포켓몬 회복 센터입니다.");

      recover.setFont(new Font(getName(),4,30));
      recover.setBounds(250, 130, 500, 200);
      this.add(recover);

      JButton btnYes = new JButton("포켓몬 회복");

      btnYes.setBounds(350, 600, 150, 50);
      btnYes.setFont(new Font(getName(),3,15));
      this.add(btnYes);

      JButton btnNo = new JButton("센터로 가기");

      btnNo.setBounds(500, 600, 150, 50);
      btnNo.setFont(new Font(getName(),3,15));
      this.add(btnNo);
      
      Pokemon searchPoke = null;
      int pokeImgNo = 0;
      ImageIcon[] pImgList = new ImageIcon[4];
      JLabel[] userPoke = new JLabel[pImgList.length];
      int x=140;
      int y=270;
      for(int i=0 ; i<user.getUp_list().size() ; i++) {
         if(user.getUp_list().size()==0) {
            System.out.println("포켓몬이 없음");
         }
         else {
            searchPoke = user.getUp_list().get(i);
            pokeImgNo = user.getUp_list().get(i).getpNo();
            pImgList[i] = new ImageIcon("images/poke/"+pokeImgNo+"F.gif");
            userPoke[i] = new JLabel(pImgList[i]);
            if(pokeImgNo==6) {
            	x+=20;
            	y=250;
            }else if(pokeImgNo==3||pokeImgNo==9||pokeImgNo==22) {
            	x+=10;
            	y=270;
            }
            else {
            	x-=10;
            	y=270;
            }
             userPoke[i].setBounds(x, y, 190, 300);
             x+=190;
             this.add(userPoke[i]);
         }
      }
      yes.setBounds(700, 450, 200, 100);
      btnYes.addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
            ans=1;
            mc.useRecovery(ans);
            m_vill.start();
            JOptionPane.showMessageDialog(null, "회복이 성공적으로 진행 되었습니다.", "회복 성공", JOptionPane.WARNING_MESSAGE);
          
           mf.remove(recoveryView);
           centerView.setVisible(true);
         mf.requestFocus();
            ans=0;
         }
      });
      btnNo.addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
            ans=2;
            mc.useRecovery(ans);

            JOptionPane.showMessageDialog(null, "회복을 취소하셨습니다.", "회복 취소", JOptionPane.WARNING_MESSAGE);

           mf.remove(recoveryView);

            centerView.setVisible(true);
            centerView.requestFocus();
            ans=0;
         }
      });
      backButton.setBounds(905, 657, 90, 60);
      settingButton(backButton);
      backButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) { }
         @Override
         public void mouseExited(MouseEvent e) {}
         @Override
         public void mousePressed(MouseEvent e) {
            mf.remove(recoveryView);
            
            centerView.setVisible(true);
            centerView.requestFocus();
            m.setEscCtn(0);
         }
      });
      this.add(backButton);
   }
   public void paintComponent(Graphics g) {
      
         g.drawImage(recoveryBackground, 0, 0, 1024, 729, this);
   }
   public void settingButton(JButton jb) {
         jb.setBorderPainted(false);
         jb.setFocusPainted(false);
         jb.setContentAreaFilled(false);
   }
   
}