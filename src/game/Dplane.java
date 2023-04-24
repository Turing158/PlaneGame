package game;

import javax.swing.*;
import java.awt.*;

public class Dplane {
    public int Dpx;
    public int Dpy;
    public boolean death;
    public int Dpc;//动画计数器
    public Panel nowp;
    public Image[] imgDp = {//添加图片数组，利用数组做动画
            new ImageIcon("img/me_1.png").getImage(),
            new ImageIcon("img/me_1.png").getImage(),
            new ImageIcon("img/me_1.png").getImage(),
            new ImageIcon("img/me_1.png").getImage(),
            new ImageIcon("img/me_1.png").getImage(),
            new ImageIcon("img/me_2.png").getImage(),
            new ImageIcon("img/me_2.png").getImage(),
            new ImageIcon("img/me_2.png").getImage(),
            new ImageIcon("img/me_2.png").getImage(),
            new ImageIcon("img/me_2.png").getImage(),
            new ImageIcon("img/me_3.png").getImage(),
            new ImageIcon("img/me_3.png").getImage(),
            new ImageIcon("img/me_3.png").getImage(),
            new ImageIcon("img/me_3.png").getImage(),
            new ImageIcon("img/me_3.png").getImage(),
            new ImageIcon("img/me_4.png").getImage(),
            new ImageIcon("img/me_4.png").getImage(),
            new ImageIcon("img/me_4.png").getImage(),
            new ImageIcon("img/me_4.png").getImage(),
            new ImageIcon("img/me_4.png").getImage()
    };
    public Dplane(Panel p,int x,int y){
        this.Dpx = x;
        this.Dpy = y;
        this.nowp = p;
        Dpc = 0;
        death = false;
    }
    public void dDp(Graphics g){//画
        g.drawImage(imgDp[Dpc],Dpx,Dpy,nowp);
        Dpc++;
        if(Dpc> imgDp.length-1){
            this.death = true;
        }
    }
}
