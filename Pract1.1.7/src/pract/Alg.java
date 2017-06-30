/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pract;

import java.util.ArrayList;

/**
 *
 * @author Asus-PC
 */
public class Alg extends Graph{
    public static int[][] next; //матрица нахождения путей
    public static int[][] d; //матрица кратчайших путей
    public static int iVertex = -1; // индекс вершины
    public static int iFrom = -1; // из какой вершины
    public static int iTo = -1; // в какую вершину
    public static final int INF = 10000; // большое число
    
    public static void Init(String s)
    {
        s = fix(s);
        getN(s);
        Arr_in(s);
        next = new int[N][N];
        d = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (L[i][j] != 0) {
                    next[i][j] = j;
                    d[i][j] = L[i][j];
                }
            }
        }
    }
    
    public static void AlgF() //собственно алгоритм Флойда Уоршалла
    {
        start();
        for (int i = 0; i < N; i++) {
            for (int u = 0; u < N; u++) {
                for (int v = 0; v < N; v++) {
                    if (d[u][i] + d[i][v] < d[u][v]) {
                        d[u][v] = d[u][i] + d[i][v];
                        next[u][v] = next[u][i];
                    }
                }
            }
        }
        finish();
    }
    
    public static boolean check() //ищем циклы отрицательного веса
    {
        boolean c=true;
        start();
        Alg.AlgF();
        for (int i=0; i<N; ++i)
            for (int j=0; j<N; ++j)
                for (int t=0; t<N; ++t)
                    if (d[i][t] < INF/2 && d[t][t] < 0 && d[t][j] < INF/2)
                        c = false;
        finish();
        return c;
    }
    
    // Начало работы алгоритма
    public static void start() {
        next = new int[N][N];
        d = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (L[i][j] == 0) {
                    d[i][j] = INF;
                } else {
                    d[i][j] = L[i][j];
                    next[i][j] = j;
                }
            }
        }
        iVertex = 0;
        iFrom = 0;
        iTo = 0;
    }
    
    // Один шаг работы алгоритма
    public static void oneStep() {
        if (d[iFrom][iVertex] + d[iVertex][iTo] < d[iFrom][iTo]) {
            d[iFrom][iTo] = d[iFrom][iVertex] + d[iVertex][iTo];
            next[iFrom][iTo] = next[iFrom][iVertex];
        }
        int imax = N - 1;
        if (iTo < imax) {
            iTo++;
        } else if (iFrom < imax) {
            iTo = 0;
            iFrom++;
        } else if (iVertex < imax) {
            iFrom = 0;
            iTo = 0;
            iVertex++;
        }
    }
    
    // Действия после окончания работы алгоритма
    public static void finish() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (d[i][j] >= INF)
                    d[i][j]=0;
            }
        }
        iVertex = -1;
        iFrom = -1;
        iTo = -1;
    }
    
    // Алгоритм закончил работу?
    public static boolean done() {
        int imax = N - 1;
        return iFrom == imax && iTo == imax && iVertex == imax;
    }
    
    public static ArrayList way(int n1, int n2)    //возвращает кратчайший путь
    {
        ArrayList<Integer> u = new ArrayList<>();
        int S=0;
        if (d[n1][n2]!=0)
        {
        if (n1==n2)
        {
            for (int i=0;i<N;++i)
            {
                u = new ArrayList<>();
                S=0;
                if (L[n1][i]!=0)
                {
                    if (d[i][n2] != 0) {
                        int c = i;
                        u.add(n1);
                        u.add(c);
                        S=d[c][n2]+d[n1][c];
                        while (c != n2) {
                            
                            c = next[c][n2];
                            u.add(c);
                            
                    }
                        if (S==d[n1][n2])
                            return u;
                }
                }
            }
        }
        else
        if (d[n1][n2] != 0) {
            int c = n1;
            while (c != n2) {
                c = next[c][n2];
                u.add(c);
            }
        }}
        return u;
    }
}
