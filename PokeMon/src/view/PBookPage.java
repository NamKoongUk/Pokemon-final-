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

import model.dao.PokemonDao;

public class PBookPage extends JPanel{
   
   private JPanel pb;
   private MainFrame mf;
   private UserMenuPage ump;
   
   private ImageIcon backButtonImage = new ImageIcon("images/maketViewImages/marketViewBack.png");
   private ImageIcon leftButtonImage = new ImageIcon(("images/leftBtn.png"));
   private ImageIcon rightButtonImage = new ImageIcon(("images/rightBtn.png"));
   private ImageIcon getPokeImage = new ImageIcon(("images/userMenuImages/getPoke.PNG"));
   //이미지를 가질 리스트
   ArrayList<ImageIcon> imageList = new ArrayList<>();
   //화면에 보여질 포켓몬 라벨
   private JLabel[] pInfo = new JLabel[6];
   private JButton leftButton = new JButton(leftButtonImage);
   private JButton rightButton = new JButton(rightButtonImage);
   private JLabel getPokeLabel = new JLabel(getPokeImage);
   private JButton backButton = new JButton(backButtonImage);
   private ImageIcon image;
   //기본 시작 페이지
   private int page = 1;
   //마지막 포켓몬 번호
   private int pokemonMax =0;
   private PokemonDao pd = new PokemonDao();
   
   private Image pBookBackgroundLabel = new ImageIcon("images/pBookBackground.png").getImage();
   private int lastPage=1;
   
   public PBookPage(MainFrame mf,UserMenuPage ump) {
      
      pokemonMax = pd.getpList().size();
      
      if(lastPage%6==0) {
         lastPage=pokemonMax/6;
         System.out.println("6으로 나눠짐"+lastPage);
      }else if(lastPage%6!=0) {
         lastPage=pokemonMax/6+1;
         System.out.println("6으로 안나눠짐"+lastPage);
      }
      
      pBookImage();
      this.mf = mf;
      this.pb = this;
      this.ump = ump;
      this.setLayout(null);
      
      this.setBounds(0, 0, 1024, 768);
      
      mf.addKeyListener(new KeyAdapter() {
         public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == UserMenuPage.ESC) {
               mf.remove(pb);
               pb.setVisible(false);
            }
         }
      });
      
      JLabel labelMain = new JLabel();
      labelMain.setText("main");
      JLabel label = new JLabel();
      label.setText("pokemon book Page");
      label.setBounds(450, 20, 200, 40);
      this.setBackground(Color.WHITE);

      for(int i=0; i<=5; i++) {
         pInfo[i] = new JLabel(imageList.get(i));
      }
      
      leftButton.setBounds(20, 320, 95, 95);
      leftButton.setBorderPainted(false);
      leftButton.setFocusPainted(false);
      leftButton.setContentAreaFilled(false);
      //왼쪽으로 가기 버튼
      leftButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
         }
         @Override
         public void mouseExited(MouseEvent e) {
         }
         @Override
         public void mousePressed(MouseEvent e) {
            //왼쪽 버튼
            if(page>1) {
               page --;
               clickPBookleftButton(page);
            } else {
               JOptionPane.showMessageDialog(null, "첫 번째 페이지 입니다.", "포켓몬 도감", JOptionPane.WARNING_MESSAGE);
               System.out.println("first Page");
            }
         }
      });
      
      rightButton.setBounds(910, 320, 95, 95);
      rightButton.setBorderPainted(false);
      rightButton.setFocusPainted(false);
      rightButton.setContentAreaFilled(false);
      //오른쪽으로 가기 버튼
      rightButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
         }
         @Override
         public void mouseExited(MouseEvent e) {
         }
         @Override
         public void mousePressed(MouseEvent e) {
            if(page<lastPage) {
               clickPBookRightButton(page);
               page ++;
            } else {
               JOptionPane.showMessageDialog(null, "마지막 페이지 입니다.", "포켓몬 도감", JOptionPane.WARNING_MESSAGE);
               System.out.println("Last Page");
            }
         }
      });
      backButton.setBounds(905, 657, 90, 60);
      //뒤로 가기 버튼
      backButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
         }
         @Override
         public void mouseExited(MouseEvent e) {
         }
         @Override
         public void mousePressed(MouseEvent e) {
            mf.remove(pb);
            ump.setVisible(true);
            mf.requestFocus();
         }
      });
      
      setBoundPInfo();

      for(int i=0; i<=pInfo.length-1; i++) {
         this.add(pInfo[i]);
      }
      this.add(getPokeLabel);
      this.add(label);
      this.add(leftButton);
      this.add(backButton);
      this.add(rightButton);
   }
   //이미지 list저장 메소드
   public void pBookImage() {
	   lastPage=3;
	   image = new ImageIcon(("images/userMenuImages/pBook/"+1+".PNG"));
       imageList.add(image);
       image = new ImageIcon(("images/userMenuImages/pBook/"+2+".PNG"));
       imageList.add(image);
       image = new ImageIcon(("images/userMenuImages/pBook/"+3+".PNG"));
       imageList.add(image);
       image = new ImageIcon(("images/userMenuImages/pBook/"+4+".PNG"));
       imageList.add(image);
       image = new ImageIcon(("images/userMenuImages/pBook/"+5+".PNG"));
       imageList.add(image);
       image = new ImageIcon(("images/userMenuImages/pBook/"+6+".PNG"));
       imageList.add(image);
       image = new ImageIcon(("images/userMenuImages/pBook/"+7+".PNG"));
       imageList.add(image);
       image = new ImageIcon(("images/userMenuImages/pBook/"+8+".PNG"));
       imageList.add(image);
       image = new ImageIcon(("images/userMenuImages/pBook/"+9+".PNG"));
       imageList.add(image);
       image = new ImageIcon(("images/userMenuImages/pBook/"+17+".PNG"));
       imageList.add(image);
       image = new ImageIcon(("images/userMenuImages/pBook/"+18+".PNG"));
       imageList.add(image);
       image = new ImageIcon(("images/userMenuImages/pBook/"+19+".PNG"));
       imageList.add(image);
       image = new ImageIcon(("images/userMenuImages/pBook/"+20+".PNG"));
       imageList.add(image);
       image = new ImageIcon(("images/userMenuImages/pBook/"+21+".PNG"));
       imageList.add(image);
       image = new ImageIcon(("images/userMenuImages/pBook/"+22+".PNG"));
       imageList.add(image);
       image = new ImageIcon(("images/userMenuImages/pBook/"+23+".PNG"));
       imageList.add(image);
       image = new ImageIcon(("images/userMenuImages/pBook/nonImage.png"));
       imageList.add(image);           
       image = new ImageIcon(("images/userMenuImages/pBook/nonImage.png"));
       imageList.add(image);           
   }
   public void clickPBookRightButton(int Page) {
      int max = Page*6;
      int min = max-6;
      for(int i=0; i<=5; i++) {
         this.remove(pInfo[i]);
      }
      int index =0;
      for(int i=min; i<max; i++) {
         pInfo[index] = new JLabel(imageList.get(i+6));
         System.out.println("index : "+index);
         System.out.println("min : "+min);
         System.out.println("max : "+max);
         System.out.println("i : "+i);
         this.add(pInfo[index]);
         index++;
      }
      setBoundPInfo();
   }
   public void clickPBookleftButton(int page) {
      int max = page*6;
      int min = max-6;
      for(int i=0; i<=5; i++) {
         this.remove(pInfo[i]);
      }
      int index = 5;
      for(int i=max; i>min; i--) {
         pInfo[index] = new JLabel(imageList.get(i-1));
         this.add(pInfo[index]);
         index--;
      }
      setBoundPInfo();
   }
   public void setBoundPInfo() {
      pInfo[0].setBounds(125, 145, 250, 250);
      pInfo[1].setBounds(385, 145, 250, 250);
      pInfo[2].setBounds(645, 145, 250, 250);
      pInfo[3].setBounds(125, 385, 250, 250);
      pInfo[4].setBounds(385, 385, 250, 250);
      pInfo[5].setBounds(645, 385, 250, 250);
      
   }
   public void paintComponent(Graphics g) {
         g.drawImage(pBookBackgroundLabel, 0, 0, 1024, 729, pb);
   }
   public void settingButton(JButton jb) {
   jb.setBorderPainted(false);
   jb.setFocusPainted(false);
   jb.setContentAreaFilled(false);
   }
}