package testerr;

import java.awt.*;
import java.util.Date;
import javax.swing.*;

public class GraphicsTester extends JFrame{
    public GraphicsTester()
    {super("演示字体、颜色、窗口");
        setVisible(true);
        //显示窗口
        setSize(480,250);
        //大小
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setFont(new Font("SansSerif",Font.BOLD,12));
        g.setColor(Color.blue);
        //yanse
        g.drawString("字体ScanSerif,粗体,12号,蓝色",20,50);

        g.setColor(Color.black);
        int xValues[]={250,280,290,300,330,310,320,290,260,270};
        int yValues[]={210,210,190,210,210,220,230,220,230,220};
        g.drawPolygon(xValues,yValues,10);

        int xValues2[] ={360,390,400,410,440,420,430,400,370,380};
        g.fillPolygon(xValues2,yValues,10);

    }
    public static void main(String args[]){
        GraphicsTester application = new GraphicsTester();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Date now = new Date();
        int x = 1;
        int y = x;
        x = 2;
        System.out.println(y);

        System.out.println(now);
    }
}