package game;

import javax.swing.*;
import java.awt.*;

public class plane {
    public int px;
    public int py;
    public int pw;
    public int ph;
    public Panel nowp;
    public Image imgp;
    public plane(Panel p){
        px = 200;
        py = 700;
        this.nowp = p;
        imgp = new ImageIcon("img/me.png").getImage();
        pw = imgp.getWidth(nowp);
        ph = imgp.getHeight(nowp);
    }
    public void dp(Graphics g){//画
        g.drawImage(imgp,px,py,nowp);
    }
    public void mt(int x,int y){//移动方法
        this.px = x - this.pw/2;
        this.py = y - this.ph/2;
    }
}
