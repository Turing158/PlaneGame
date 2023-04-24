package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GFrame extends Frame implements WindowListener{
    public GPanel gp;
    public  stop st;
    public Image icon;
    public int GFx;
    public int GFy;
    public GFrame(){
        this.setTitle("Plane Game!");//设置窗口标题
        this.setBounds(100,100,480,700);//设置窗口大小
        icon = new ImageIcon("img/plane.png").getImage();//创建图标对象
        this.setIconImage(icon);//添加图标
        GPanel gp = new GPanel();//创建面板对象
        this.add(gp);//添加面板
        this.addWindowListener(this);//添加windows窗口侦听
        this.setResizable(false);//设置不允许用户调整窗口大小
    }


    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.GFx = getX();
        this.GFy = getY();
        stop st = new stop();
        st.setBounds(GFx+200,GFy+350,280,200);//设置窗口样式
        st.setVisible(true);//显示stop窗口
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
