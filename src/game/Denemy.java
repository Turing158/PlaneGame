package game;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Denemy {
    public int Dex;
    public int Dey;
    public int Dec;//动画计数器
    public boolean death;
    public Panel nowp;
    public Image imgDe[] = {//添加图片数组，利用数组做动画
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/enemy1.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/enemy1.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/enemy1.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/enemy1.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/enemy1.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/enemy2.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/enemy2.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/enemy2.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/enemy2.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/enemy2.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/enemy3.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/enemy3.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/enemy3.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/enemy3.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/enemy3.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/enemy4.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/enemy4.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/enemy4.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/enemy4.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/enemy4.png"))).getImage()

    };
    public Denemy(Panel p,int x,int y){
        this.Dex = x;
        this.Dey = y;
        this.nowp = p;
        Dec = 0;
        death = false;
    }
    public void dDe(Graphics g){//画
        g.drawImage(imgDe[Dec],Dex,Dey,nowp);
        Dec++;
        if (Dec > imgDe.length-1){
            this.death = true;
        }
    }
    public void mt(int x,int y){
        this.Dex = x;
        this.Dey = y;
    }
}
