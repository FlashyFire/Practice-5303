/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pract;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.Timer;

/**
 *
 * @author Asus-PC
 */
public class GraphPainter {
    private int N = 0;
    private int[][] L;
    private int[][] next;//матрица нахождения путей
    private int[][] d;//матрица кратчайших путей
    private double[][] F;//координаты вершин
    private Timer t;
    private int i=0;
    private int u=0;
    private int v=0;
   
    //private TimerTask task;
    public GraphPainter()
    {
        N = Alg.N;
        L = Alg.L;
        next = new int[N][N];
        d = new int[N][N];
        for (int k = 0; k < N; k++) {
            for (int j = 0; j < N; j++) {
                if (L[k][j]!=0)
                {
                    next[k][j]=j;
                    d[k][j]=L[k][j];

                }
            }
        }
        for (int k = 0; k < N; k++) {
            for (int j = 0; j < N; j++) {
                if (L[k][j]==0) {
                    d[k][j]=1000;
                }
            }
        }
    }
    public void paintComponent(Graphics2D g)    //отрисовка графа
    {
        g.setStroke(new BasicStroke(1)); 
            F = new double[N][2];
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
            for (int k = 0; k < N; ++k) {
                F[k][0] = x;
                F[k][1] = y;
                oldx = x;
                oldy = y;
                x = (oldx - x0) * Math.cos(angle) + (oldy - y0) * Math.sin(angle) + x0;
                y = -(oldx - x0) * Math.sin(angle) + (oldy - y0) * Math.cos(angle) + y0;
            }
            for (int k = 0; k < N; k++) {
                for (int j = 0; j < N; j++) {
                    if (L[k][j] > 0) {
                        g.drawLine((int) F[k][0], (int) F[k][1], (int) F[j][0], (int) F[j][1]);
                        g.setStroke(new BasicStroke(3));
                        obr(F[k][0],F[k][1],F[j][0],F[j][1],L[k][j],g);
                        g.setStroke(new BasicStroke(1));
                    }
                }
            }
            for (int k = 0; k < N; k++) {
                g.setColor(Color.green);
                g.fillOval((int) (F[k][0] - 10), (int) F[k][1] - 10, 20, 20);
                g.setColor(Color.black);
                g.drawOval((int) (F[k][0] - 10), (int) F[k][1] - 10, 20, 20);
                String s = k + "";
                g.drawString(s, (int) (F[k][0]) - 5, (int) F[k][1] + 5);
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
    public void paintAlg(Graphics2D g)
    {
         //g.drawLine(i*10, 200, u*10, v*10);
        if (d[u][i] + d[i][v] < d[u][v])
            {
                //g.drawLine(i*10, 0, u*10, v*10);
                d[u][v] = d[u][i] + d[i][v];
                Alg.d[u][v]=d[u][v];
                next[u][v] = next[u][i];
            }
        
        if (v!=N-1)
        {
            ++v;
        }
        else
        {
            v=0;
            if(u!=N-1)
            {
                ++u;
            }
            else
            {
                u=0;
                ++i;
            }
        }
            
        //g.drawLine(0, 0+ Iter*10, 90 , 90+ Iter*10);
        
        if (i == N-1 && u==N-1 && v==N-1)
        {
            GraphView.I=3;
        }
        
    }
}
