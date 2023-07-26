package game;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Dboss {
    public int Dbx;
    public int Dby;
    public int Dbc;//动画计数器
    public boolean death;
    public Panel nowp;
    public Image[] imgDb = {//利用数组做动画
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/boss1.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/boss1.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/boss1.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/boss1.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/boss1.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/boss2.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/boss2.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/boss2.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/boss2.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/boss2.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/boss3.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/boss3.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/boss3.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/boss3.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/boss3.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/boss4.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/boss4.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/boss4.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/boss4.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/boss4.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/boss5.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/boss5.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/boss5.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/boss5.png"))).getImage(),
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../img/boss5.png"))).getImage()
    };
    public Dboss(Panel p,int x,int y){
        this.Dbx = x;
        this.Dby = y;
        this.nowp = p;
        Dbc = 0;
        death =false;
    }
    public void dDb(Graphics g){
        g.drawImage(imgDb[Dbc],Dbx,Dby,nowp);
        Dbc++;
        if(Dbc > imgDb.length-1){
            this.death = true;
        }
    }
    public void mt(int x,int y){
        this.Dbx = x;
        this.Dby = y;
    }
}
