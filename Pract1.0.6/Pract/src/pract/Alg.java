/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pract;

/**
 *
 * @author Asus-PC
 */
public class Alg extends Graph{
    static public int[][] next;//матрица нахождения путей
    static public int[][] d;//матрица кратчайших путей
    
    public static void Init(String s)
    {
        getN(s);
        s=fix(s);
        Arr_in(s);
        //AlgF();
    }
    
    public static void AlgF() //собственно алгоритм Флойда Уоршалла
    {
        next = new int[N][N];
        d = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (L[i][j]!=0)
                {
                    next[i][j]=j;
                    d[i][j]=L[i][j];

                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (L[i][j]==0) {
                    d[i][j]=1000;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int u = 0; u < N; u++) {
                for (int v = 0; v < N; v++) {
                    if (d[u][i] + d[i][v] < d[u][v])
                    {
                        d[u][v] = d[u][i] + d[i][v];
                        next[u][v] = next[u][i];
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (d[i][j]==1000)
                    d[i][j]=0;
            }
        }
    }
    
    public static String way(int n1, int n2)    //возвращает кратчайший путь
    {
        String path = "";
        int c;
        if (d[n1][n2] == 0)
            return path;
        else
        {
            c=n1;
            while (c!=n2)
            {
                if (c==n1)
                    path=c+"->";
                else
                    path+=c+"->";
                c = next[c][n2];
            }
            path+=n2+"=";
            path+=d[n1][n2]+"";
            return path;
        }
    }
}
