package game;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class GPanel extends Panel implements Runnable, KeyListener, MouseMotionListener,MouseListener{
    public GFrame gf;
    public plane pl;
    public stop st;
    public Boss boss;
    public static int score;//分数计数器
    public int ec;//敌机生成计数器
    public int emi;//敌机默认移动值
    public int fc;//子弹生产计数器
    public int bc;
    public int bci = 200;
    public background bg;
    public Vector<enemy> alle;//敌机集合
    public Vector<fire> allf;//子弹集合
    public Vector<Denemy> allDe;//敌机死亡特效集合
    public Vector<Dplane> allDp;//自己死亡特效
    public Vector<Boss> allBoss;
    public Vector<Dboss> allDb;
    public Image offimg =null;//双重缓冲画板
    public static boolean state;
    public int end ;
    public boolean start;
    public GPanel(){
        state = false;
        pl = new plane(this);
        bg = new background(this);
        alle = new Vector<enemy>();
        allf = new Vector<fire>();
        allBoss = new Vector<Boss>();
        allDe = new Vector<Denemy>();
        allDp = new Vector<Dplane>();
        allDb = new Vector<Dboss>();
        Thread t = new Thread(this);//创建多线程对象
        t.start();//开始进程
        this.addKeyListener(this);//添加键盘侦听
        this.addMouseMotionListener(this);//鼠标侦听
        this.addMouseListener(this);


    }
    public void paint(Graphics g){
        if (offimg == null){//双重缓冲解决画面闪屏问题
            offimg = createImage(480,700);
        }
        Graphics gimg = offimg.getGraphics();
        gimg.fillRect(0,0,480,700);
        bg.dbg(gimg);//画背景
        if (state){
            pl.dp(gimg);//画飞机
            for (int i=0;i<alle.size();i++){//画敌机
                enemy nowe = alle.elementAt(i);
                nowe.de(gimg);
            }
            for (int i=0;i<allf.size();i++){//画子弹
                fire nowf = allf.elementAt(i);
                nowf.df(gimg);
            }
            for (int i=0;i<allDe.size();i++){//画敌机死亡动画
                Denemy nowDe = allDe.elementAt(i);
                nowDe.dDe(gimg);
            }
            for (int i=0;i<allDp.size();i++){//画飞机死亡动画
                Dplane nowDp = allDp.elementAt(i);
                nowDp.dDp(gimg);
            }
            for (int i=0;i<allBoss.size();i++){
                Boss nowb = allBoss.elementAt(i);
                nowb.db(gimg);
            }
            for (int i=0;i<allDb.size();i++){
                Dboss nowDb = allDb.elementAt(i);
                nowDb.dDb(gimg);
            }
            gimg.setFont(new Font("宋体",Font.BOLD,20));
            gimg.drawString("Score :"+score,5,15);
            gimg.drawString("ESC(Pause)",360,15);
            if(end == 1){
                gimg.setFont(new Font("宋体",Font.BOLD,50));
                gimg.drawString("GameOver",130,350);
                gimg.setFont(new Font("宋体",Font.BOLD,20));
                gimg.drawString("Please click 'ESC' to Leave",85,380);
            }
        }
        if(!state){
            gimg.setFont(new Font("",Font.BOLD,75));
            gimg.drawString("Plane Battle",20,350);
            gimg.setFont(new Font("宋体",Font.BOLD,20));
            gimg.drawString("Please click mouse to start!",85,380);
        }
        g.drawImage(offimg,0,0,null);//画双重缓冲画面

    }
    public void update(Graphics g){//重写更新方法
        paint(g);
    }


    @Override
    public void run() {//多线程
        while (true){
            if(state == true){
                bg.mbg();
                if (end == 0){//如果end=1，游戏结束，不运行这些指令
                    ec++;//敌机生成
                    if (ec == 40){
                        alle.addElement(new enemy(this,(int)(Math.random()*423),-100));
                        ec = 0;
                    }
                    fc++;//子弹生成
                    if(fc == 30){
                        allf.addElement(new fire(this,pl.px+(pl.pw/2), pl.py));
                        fc = 0;
                    }
                    bc++;//boss生成
                    if( score >= 2000 &&bc >= bci){
                        allBoss.addElement(new Boss(this,(int)(Math.random()*400),-200));
                        bc = 0;
                    }
                    for (int i=0;i<alle.size();i++){//敌机的移动和移除
                        enemy nowe = alle.elementAt(i);
                        nowe.mt(nowe.ex, nowe.ey+emi+1);
                        if (nowe.ey == 700){
                            alle.remove(nowe);
                        }
                    }
                    for (int i=0;i<allf.size();i++){//子弹的移动和移除
                        fire nowf = allf.elementAt(i);
                        nowf.mt(nowf.fx, nowf.fy-5);
                        if (nowf.fy == -10){
                            allf.remove(nowf);
                        }
                    }
                    for(int i=0;i<allBoss.size();i++){//Boss的移动和移除
                        Boss nowb = allBoss.elementAt(i);
                        nowb.mt(nowb.bx, nowb.by+1);
                        if(nowb.by == 700){
                            allBoss.remove(nowb);
                        }
                    }
                }
                for (int i=0;i<allDe.size();i++){//敌机死亡特效移除
                    Denemy nowDe = allDe.elementAt(i);
                    nowDe.mt(nowDe.Dex, nowDe.Dey+emi+1);
                    if(nowDe.death){
                        allDe.removeElementAt(i);
                    }
                }
                for (int i=0;i<allDb.size();i++){//Boss死亡特效移除
                    Dboss nowDb = allDb.elementAt(i);
                    nowDb.mt(nowDb.Dbx, nowDb.Dby+1);
                    if (nowDb.death){
                        allDb.removeElementAt(i);
                    }
                }
                for(int i=0;i<allDp.size();i++){//飞机死亡特效移除
                    Dplane nowDp = allDp.elementAt(i);
                    if (nowDp.death){
                        allDp.removeElementAt(i);
                    }
                }
                for (int i=0;i<allf.size();i++){//子弹与敌机的碰撞检测
                    fire nowf = allf.elementAt(i);
                    for (int j=0;j<alle.size();j++){
                        enemy nowe = alle.elementAt(j);
                        if (this.CH(nowf.fx,nowf.fy,nowf.fw,nowf.fh, nowe.ex, nowe.ey, nowe.ew,nowe.eh)){
                            alle.removeElementAt(j);
                            allf.removeElementAt(i);
                            allDe.addElement(new Denemy(this,nowe.ex,nowe.ey));//增加死亡特效
                            score+=100;
                            i--;
                            break;
                        }
                    }
                }
                for (int i=0;i<allf.size();i++){
                    fire nowf= allf.elementAt(i);
                    for (int j=0;j<allBoss.size();j++){
                        Boss nowb = allBoss.elementAt(j);
                        if(this.CH(nowf.fx, nowf.fy, nowf.fw, nowf.fh, nowb.bx, nowb.by, nowb.bw, nowb.bh)){
                            nowb.delete();
                            allf.removeElementAt(i);
                            if(Boss.xue == 0){
                                allBoss.removeElementAt(j);
                                allDb.addElement(new Dboss(this, nowb.bx,nowb.by));
                                score +=500;
                            }
                            i--;
                            break;
                        }
                    }
                }
                for (int i=0;i<alle.size();i++){//敌机与飞机的碰撞检测
                    enemy nowe = alle.elementAt(i);
                    if (this.CH(nowe.ex, nowe.ey, nowe.ew, nowe.eh, pl.px, pl.py, pl.pw, pl.ph)){
                        alle.removeElementAt(i);
                        allDe.addElement(new Denemy(this, nowe.ex, nowe.ey));
                        allDp.addElement(new Dplane(this, pl.px, pl.py));
                        end = 1;
                    }
                }
                for (int i=0;i<allBoss.size();i++){//敌机与飞机的碰撞检测
                    Boss nowb = allBoss.elementAt(i);
                    if (this.CH(nowb.bx, nowb.by, nowb.bw, nowb.bh, pl.px, pl.py, pl.pw, pl.ph)){
                        allBoss.removeElementAt(i);
                        allDb.addElement(new Dboss(this, nowb.bx, nowb.by));
                        allDp.addElement(new Dplane(this, pl.px, pl.py));
                        end = 1;
                    }
                }
                switch (score){
                    case 5000:
                        emi = 1;
                        break;
                    case 10000:
                        emi = 2;
                        bci = 180;
                        break;
                    case 15000:
                        emi = 3;
                        bci = 160;
                        break;

                }
                this.repaint();//重画画面
            }
            try {
                Thread.sleep(10);//多线程休息
            }
            catch (Exception e){}
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int kc = e.getKeyCode();
        if(kc == KeyEvent.VK_ESCAPE){//ESC暂停
            GFrame gf =new GFrame();
            gf.GFx = getX();
            gf.GFy = getY();
            stop st = new stop();
            st.setBounds(gf.GFx+200,gf.GFy+350,280,200);
            st.setVisible(true);
            state = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(state){
            if (end == 0){
                pl.mt(e.getX(),e.getY());
            }
        }
    }
    public boolean CH(int x1,int y1,int w1,int h1,int x2,int y2,int w2,int h2){//碰撞检测方法
        if(x1+w1<x2||y1>y2+h2||x2+w2<x1||y1+h1<y2) {
            return false;
        }
        else {
            return true;
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (!start){
            state = true;
            start = true;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
