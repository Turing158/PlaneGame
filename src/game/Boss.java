package game;

import javax.swing.*;
import java.awt.*;

public class Boss {
    public int bx;
    public int by;
    public int bw;
    public int bh;
    public int xue = 5;
    public Panel nowp;
    public Image imgb;
    public Boss(Panel p,int x,int y){
        this.bx = x;
        this.by = y;
        this.nowp = p;
        imgb = new ImageIcon("img/boss.png").getImage();
        bw = imgb.getWidth(nowp);
        bh = imgb.getHeight(nowp);
    }
    public void db(Graphics g){
        g.drawImage(imgb,bx,by,nowp);
    }
    public void mt(int x,int y){
        this.bx = x;
        this.by = y;
    }
    public void delete(){
        this.xue--;
    }
}
