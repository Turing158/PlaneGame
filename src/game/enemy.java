package game;

import javax.swing.*;
import java.awt.*;

public class enemy {
    public int ex;
    public int ey;
    public int ew;
    public int eh;
    public Panel nowp;
    public Image imge;
    public enemy(Panel p,int x,int y){
        this.ex = x;
        this.ey = y;
        imge = new ImageIcon("img/enemy.png").getImage();
        this.nowp = p;
        ew = imge.getWidth(nowp);
        eh = imge.getHeight(nowp);
    }
    public void de(Graphics g){//画
        g.drawImage(imge,ex,ey,nowp);
    }
    public void mt(int x,int y){//移动方法
        this.ex = x;
        this.ey = y;
    }
}
