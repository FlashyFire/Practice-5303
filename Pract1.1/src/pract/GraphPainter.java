/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pract;
import java.awt.Graphics;
import java.awt.*;
import java.io.IOException;
import java.awt.Color;
/**
 *
 * @author Asus-PC
 */
public class GraphPainter {
    private int N = 0;
    private int[][] L;
    
    public GraphPainter()
    {
        N = Alg.N;
        L = Alg.L;
    }
    public void paintComponent(Graphics2D g)    //отрисовка графа
    {
        g.setStroke(new BasicStroke(1)); 
            double[][] F = new double[N][2];
            double PI = 3.14159;
            double angle=0;
            if (N!=0)
                angle = 360/N;
            angle = angle * PI / 180;
            double r = 80;
            double x = 250;
            double y = 250;
            double x0 = x, y0 = y;
            y = 35;
            double oldx, oldy;
            g.setColor(Color.red);
            for (int i = 0; i < N; ++i) {
                F[i][0] = x;
                F[i][1] = y;
                oldx = x;
                oldy = y;
                x = (oldx - x0) * Math.cos(angle) + (oldy - y0) * Math.sin(angle) + x0;
                y = -(oldx - x0) * Math.sin(angle) + (oldy - y0) * Math.cos(angle) + y0;
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (L[i][j] > 0) {
                        g.drawLine((int) F[i][0], (int) F[i][1], (int) F[j][0], (int) F[j][1]);
                        g.setStroke(new BasicStroke(3));
                        obr(F[i][0],F[i][1],F[j][0],F[j][1],L[i][j],g);
                        g.setStroke(new BasicStroke(1));
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                g.setColor(Color.green);
                g.fillOval((int) (F[i][0] - 10), (int) F[i][1] - 10, 20, 20);
                g.setColor(Color.black);
                g.drawOval((int) (F[i][0] - 10), (int) F[i][1] - 10, 20, 20);
                String s = i + "";
                g.drawString(s, (int) (F[i][0]) - 5, (int) F[i][1] + 5);
            }
    }

    private static void obr(double x1, double y1, double x2, double y2,int w, Graphics2D g)
    {
        double x0,y0,x,y,xn,yn,x3,y3;
        double PI = 3.14159;
        double a=45;
        a = a*PI/180;
        x0=(x1+x2)/2;
        y0=(y1+y2)/2;
        double k;
        double b;
        if (x1!=x2)
        {
            k=(y2-y1)/(x2-x1);
            b=y1-k*x1;
            x=10*Math.cos(Math.atan(k));
            x=Math.abs(x);
            x3=20*Math.cos(Math.atan(k));
            x3= Math.abs(x3);
            if (x1>x2)
            {
                x=x+x0;
                x3=x3+x0;
            }
            else
            {
                x=x0-x;
                x3=-x3+x0;
            }
            y=k*x+b;
            y3 = k*x3+b;
        }
        else
        {
            x=x0;
            x3 = x0;
            if (y1>y2)
            {
                y=y0+10;
                y3=y0+20;
            }
            else
            {
                y=y0-10;
                y3=y0-20;
            }
        }
        xn=x0-Math.sin(a)*(y-y0)+Math.cos(a)*(x-x0);
        yn=y0+Math.cos(a)*(y-y0)+Math.sin(a)*(x-x0);
        g.drawLine((int)x0,(int)y0,(int)xn,(int)yn);
        a=-45;
        a = a*PI/180;
        xn=x0-Math.sin(a)*(y-y0)+Math.cos(a)*(x-x0);
        yn=y0+Math.cos(a)*(y-y0)+Math.sin(a)*(x-x0);
        g.drawLine((int)x0,(int)y0,(int)xn,(int)yn);
        g.setStroke(new BasicStroke(1));
        g.setColor(Color.white);
        g.fillOval((int)(x3-8), (int)(y3-8), 16, 16);
        g.setColor(Color.red);
        String S = w +"";
        g.drawString(S, (int)(x3-5), (int)(y3+5));
        g.drawOval((int)(x3-8), (int)(y3-8), 16, 16);
        g.setStroke(new BasicStroke(3));
        
    }
}