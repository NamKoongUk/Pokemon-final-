package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import controller.MCManager;
import model.vo.Pokemon;
import model.vo.User;

public class PChangeView extends JPanel{
   private MainFrame mf;
   private PChangeView pChangeView;
   private Map m;
   private Image backButtonImage = new ImageIcon("images/maketViewImages/marketViewBack.png").getImage();
   private JButton backButton = new JButton(new ImageIcon(backButtonImage));
   private MCManager mc;
   private Image pChangeBackground = new ImageIcon("images/maketViewImages/centerView.gif").getImage();
   private User user;
   private CenterView centerView;
   private Pokemon totalPoke;
   private Pokemon myPoke;
   public PChangeView(MainFrame mf, JPanel oldPage, User user) {
     mc = new MCManager(user);
     this.mf=mf;
      this.pChangeView=this;
      this.centerView = (CenterView)oldPage;
      
      this.setLayout(null);
      this.setBounds(0,0,1024,768);
      
      this.setBackground(Color.BLUE);

      JLabel recover = new JLabel("포켓몬 교체 센터입니다.");

      recover.setFont(new Font(getName(),4,30));
      recover.setBounds(250, 130, 500, 200);
      this.add(recover);

      JButton btnYes = new JButton("포켓몬 교체");

      btnYes.setBounds(350, 600, 150, 50);
      btnYes.setFont(new Font(getName(),3,15));
      this.add(btnYes);

      JButton btnNo = new JButton("센터로 가기");

      btnNo.setBounds(500, 600, 150, 50);
      btnNo.setFont(new Font(getName(),3,15));
      this.add(btnNo);

      JLabel totalName = new JLabel("잡은 포켓몬 목록");

      totalName.setBounds(250, 238, 100, 30);
      this.add(totalName);
            
      Pokemon totalSearchPoke = null;
      String[] totalPokeNameList = new String[user.getTp_list().size()];
      int totalPokeImgNo = 0;
      ImageIcon[] ptImgList = new ImageIcon[user.getTp_list().size()];
      JLabel[] totalPokeImg = new JLabel[ptImgList.length];
      for(int i=0 ; i<user.getTp_list().size() ; i++) {

    	  if(user.getTp_list().size()==0) {
    		  System.out.println("교체할 포켓몬이 없음");
    	  }
    	  else {           
    		  totalSearchPoke = user.getTp_list().get(i);
    		  totalPokeNameList[i] = user.getTp_list().get(i).getpName();
    		  totalPokeImgNo = totalSearchPoke.getpNo();
    		  ptImgList[i] = new ImageIcon("images/poke/"+totalPokeImgNo+"F.gif");
    		  totalPokeImg[i] = new JLabel(ptImgList[i]);
    	  }
      }
      JLabel totalPImg = new JLabel();
      totalPImg.setBounds(500, 250, 200, 160);
      
      JList totalPokeList = new JList(totalPokeNameList);
      totalPokeList.setFont(new Font(getName(),Font.BOLD,17));
      totalPokeList.setBounds(250, 270, 100, 320);
      totalPokeList.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
      this.add(totalPokeList);
      
      JTextField totalSelectedPoke = new JTextField(40);
      totalSelectedPoke.setLocation(356, 524);
      totalSelectedPoke.setSize(100, 50);
      
      JLabel myPokeName = new JLabel("현재 포켓몬 목록");
      myPokeName.setBounds(360, 238, 100, 30);
      this.add(myPokeName);
            
      Pokemon mySearchPoke = null;
      String[] myPokeNameList = new String[user.getUp_list().size()];
      int myPokeImgNo = 0;
      ImageIcon[] pmImgList = new ImageIcon[user.getUp_list().size()];
      JLabel[] myPokeImg = new JLabel[pmImgList.length];
      for(int i=0 ; i<user.getUp_list().size() ; i++) {

    	  if(user.getUp_list().size()==0) {
    		  System.out.println("내 포켓몬이 없음");
    	  }
    	  else {           
    		  mySearchPoke = user.getUp_list().get(i);
    		  myPokeImgNo = mySearchPoke.getpNo();
    		  myPokeNameList[i] = user.getUp_list().get(i).getpName();
    		  pmImgList[i] = new ImageIcon("images/poke/"+myPokeImgNo+"F.gif");
    		  myPokeImg[i] = new JLabel(pmImgList[i]);
    	  }
      }
      JLabel myPImg = new JLabel();
      myPImg.setBounds(500, 400, 200, 180);
      
      JList myPokeList = new JList(myPokeNameList);
      myPokeList.setFont(new Font(getName(),Font.BOLD,17));
      myPokeList.setBounds(360, 270, 100, 320);
      myPokeList.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
      this.add(myPokeList);
      
      JTextField mySelectedPoke = new JTextField(40);
      mySelectedPoke.setLocation(356, 524);
      mySelectedPoke.setSize(100, 50);
      
      totalPokeList.addListSelectionListener(new ListSelectionListener() {
          @Override
          public void valueChanged(ListSelectionEvent e) {
        	  totalSelectedPoke.setText(totalPokeList.getSelectedValue()+"");
        	  totalSelectedPoke.setHorizontalAlignment(JTextField.CENTER);
        	  System.out.println("바꿀 포켓몬 : "+totalPokeList.getSelectedValue());
        	  for(int i=0 ; i<user.getTp_list().size() ; i++) {
        		  if(totalPokeList.getSelectedValue().equals(user.getTp_list().get(i).getpName())) {
        			  totalPoke=user.getTp_list().get(i);
        		  }
        	  }
          }
       });
      totalPokeList.addListSelectionListener(new ListSelectionListener() {
          @Override
          public void valueChanged(ListSelectionEvent e) {
             totalPImg.setIcon(ptImgList[totalPokeList.getSelectedIndex()]);
          }
       });
      this.add(totalPImg);

      myPokeList.addListSelectionListener(new ListSelectionListener() {
          @Override
          public void valueChanged(ListSelectionEvent e) {
        	  mySelectedPoke.setText(myPokeList.getSelectedValue()+"");
        	  mySelectedPoke.setHorizontalAlignment(JTextField.CENTER);
        	  System.out.println("내 포켓몬 : "+myPokeList.getSelectedValue());
        	  for(int i=0 ; i<user.getUp_list().size() ; i++) {
        		  if(myPokeList.getSelectedValue().equals(user.getUp_list().get(i).getpName())) {
        			  myPoke=user.getUp_list().get(i);
        		  }
        	  }
          }
       });
      myPokeList.addListSelectionListener(new ListSelectionListener() {
          @Override
          public void valueChanged(ListSelectionEvent e) {
             myPImg.setIcon(pmImgList[myPokeList.getSelectedIndex()]);
          }
       });
      this.add(myPImg);
      
      btnYes.addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
            if(myPoke!=null&&totalPoke!=null) {
            	mc.usepChange(myPoke, totalPoke);
            	JOptionPane.showMessageDialog(null, "교체가 성공적으로 진행되었습니다.", "교체 성공", JOptionPane.WARNING_MESSAGE);
            	mf.remove(pChangeView);
    			centerView.setVisible(true);
    			mf.requestFocus();
            }
            else {
            	try {
            		JOptionPane.showMessageDialog(null, "교체할 포켓몬이 없습니다.", "교체 실패", JOptionPane.WARNING_MESSAGE);
                	mf.remove(pChangeView);
        			centerView.setVisible(true);
        			mf.requestFocus();
            	}catch(NullPointerException x) {
            		System.out.println("즐");
            	}
            }
         }
      });
      btnNo.addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
        	 JOptionPane.showMessageDialog(null, "교체를 취소하셨습니다.", "교체 취소", JOptionPane.WARNING_MESSAGE);
         	 mf.remove(pChangeView);

             centerView.setVisible(true);
             centerView.requestFocus();
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
            mf.remove(pChangeView);
            centerView.setVisible(true);
            centerView.requestFocus();
         }
      });
      this.add(backButton);
   }
   public void paintComponent(Graphics g) {
      
         g.drawImage(pChangeBackground, 0, 0, 1024, 729, this);
   }
   public void settingButton(JButton jb) {
         jb.setBorderPainted(false);
         jb.setFocusPainted(false);
         jb.setContentAreaFilled(false);
   }
}