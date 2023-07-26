package game;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class background {
    public int bx;
    public int by;
    public Panel nowp;
    public Image imgbg;
    public background(Panel p){
        bx=0;
        by=0;
        this.nowp = p;
        imgbg = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("./img/background.png"))).getImage();
    }
    public void dbg(Graphics g){//画
        g.drawImage(imgbg,bx,by,nowp);
        g.drawImage(imgbg,bx,by-700,nowp);
    }
    public void mbg(){//移动方法
        by+=1;
        if(by == 700){
            by=0;
        }
    }
}
