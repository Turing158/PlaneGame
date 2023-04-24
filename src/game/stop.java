package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class stop extends Frame  implements ActionListener{
    public GFrame gf;
    public GPanel gp;
    public Label iscore;
    public Button con;
    public Button exit;
    public Image icon;
    public boolean stop;
    public stop(){
        this.setTitle("Stop!!!");//设置窗口标题
        this.setLayout(null);//设置窗口样式为空
        icon = new ImageIcon("img/pause_pressed.png").getImage();//窗创建图标对象
        this.setIconImage(icon);//设置图标
        iscore = new Label("Score : "+ GPanel.score);//创建得分标签对象
        iscore.setFont(new Font("宋体",Font.BOLD,20));//设置文字样式
        iscore.setBounds(80,50,200,40);//设置标签大小
        this.add(iscore);//添加标签
        con = new Button("Continue");//创建按钮对象
        exit = new Button("Exit");//创建按钮对象
        con.setBounds(40,120,80,40);//设置按钮大小
        exit.setBounds(150,120,80,40);//设置按钮大小
        this.add(con);//添加按钮
        this.add(exit);//添加按钮
        con.addActionListener(this);
        exit.addActionListener(e -> System.exit(0));//添加点击事件
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
        GPanel.state = true;
    }
}