package game;

import javax.swing.*;
import java.awt.*;

public class fire {
    public int fx;
    public int fy;
    public int fw;
    public int fh;
    public Panel nowp;
    public Image imgf;
    public fire(Panel p,int x,int y){
        this.fx = x;
        this.fy = y;
        this.nowp = p;
        imgf = new ImageIcon("img/fire.png").getImage();
        fw = imgf.getWidth(nowp);
        fh = imgf.getHeight(nowp);
    }
    public void df(Graphics g){//画
        g.drawImage(imgf,fx,fy,nowp);
    }
    public void mt(int x,int y){//移动方法
        this.fx = x;
        this.fy = y;
    }
}
