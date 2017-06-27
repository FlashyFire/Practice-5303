package pract;

import java.awt.*;

public class GraphPanel extends javax.swing.JPanel {

    /**
     * Creates new form GraphPanel
     */
    public GraphPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D gfx = (Graphics2D)g;
        gfx.setStroke(new BasicStroke(1)); 
        int N = Alg.N;
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
                if (Alg.L[i][j] > 0) {
                    //
                    // Подсвечивается только ребро из вершины iFrom в вершину iTo!!!!!
                    //
                    g.setColor(i == Alg.iFrom && j == Alg.iTo ? Color.red : Color.black);
                    g.drawLine((int) F[i][0], (int) F[i][1], (int) F[j][0], (int) F[j][1]);
                    gfx.setStroke(new BasicStroke(3));
                    obr(F[i][0],F[i][1],F[j][0],F[j][1],Alg.L[i][j],gfx);
                    gfx.setStroke(new BasicStroke(1));
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
    
    private void obr(double x1, double y1, double x2, double y2,int w, Graphics2D g)
    {
        double x0, y0, x, y, xn, yn, x3, y3;
        double PI = 3.14159;
        double a = 45;
        a = a * PI / 180;
        x0 = (x1 + x2) / 2;
        y0 = (y1 + y2) / 2;
        double k;
        double b;
        if (x1 != x2) {
            k = (y2 - y1) / (x2 - x1);
            b = y1 - k * x1;
            x = 10 * Math.cos(Math.atan(k));
            x = Math.abs(x);
            x3 = 20 * Math.cos(Math.atan(k));
            x3 = Math.abs(x3);
            if (x1 > x2) {
                x = x + x0;
                x3 = x3 + x0;
            } else {
                x = x0 - x;
                x3 = -x3 + x0;
            }
            y = k * x + b;
            y3 = k * x3 + b;
        } else {
            x = x0;
            x3 = x0;
            if (y1 > y2) {
                y = y0 + 10;
                y3 = y0 + 20;
            } else {
                y = y0 - 10;
                y3 = y0 - 20;
            }
        }
        xn = x0 - Math.sin(a) * (y - y0) + Math.cos(a) * (x - x0);
        yn = y0 + Math.cos(a) * (y - y0) + Math.sin(a) * (x - x0);
        g.drawLine((int) x0, (int) y0, (int) xn, (int) yn);
        a = -45;
        a = a * PI / 180;
        xn = x0 - Math.sin(a) * (y - y0) + Math.cos(a) * (x - x0);
        yn = y0 + Math.cos(a) * (y - y0) + Math.sin(a) * (x - x0);
        g.drawLine((int) x0, (int) y0, (int) xn, (int) yn);
        g.setStroke(new BasicStroke(1));
        g.setColor(Color.white);
        g.fillOval((int) (x3 - 8), (int) (y3 - 8), 16, 16);
        g.setColor(Color.red);
        String S = w + "";
        g.drawString(S, (int) (x3 - 5), (int) (y3 + 5));
        g.drawOval((int) (x3 - 8), (int) (y3 - 8), 16, 16);
        g.setStroke(new BasicStroke(3));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}