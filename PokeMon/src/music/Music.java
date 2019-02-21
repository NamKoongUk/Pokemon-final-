package music;

import java.io.*;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Music extends Thread {
   private Player player;
   private boolean isLoop;
   private File file;
   private FileInputStream fis;
   private BufferedInputStream bis;
   
   public Music(String name,boolean isLoop) {
      this.isLoop = isLoop;
      
      try {
         file = new File("music/"+name);
         fis = new FileInputStream(file);
         bis = new BufferedInputStream(fis);
         player = new Player(bis);
      } catch (FileNotFoundException | JavaLayerException e) {
         e.printStackTrace();
      }
      
   }
   
   public int getTime() {
      if(player==null) {
         return 0;
      }
      
      return player.getPosition();
   }
   
   public void close() {
      isLoop = false;
      player.close();
      this.interrupt();
   }
   
   @Override
   public void run() {
      try {
         do {
            player.play();
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);
         } while (isLoop);
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
   }
}