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
public class Graph {
    static public int N = 0;//кол-во вершин
    static public int[][] L;//матрица смежности
    
    public static void Arr_in(String s) {
        L = new int[N][N];
        String x = "";
        s += " ";
        int j = 0, k = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((!s.substring(i, i + 1).equals("\n")) && (!s.substring(i, i + 1).equals(" "))) {
                if (i == 0) {
                    x = s.substring(i, i + 1);
                } else {
                    if ((s.substring(i - 1, i).equals(" ")) || (s.substring(i - 1, i).equals("\n"))) {
                        x = s.substring(i, i + 1);
                    } else {
                        x += s.substring(i, i + 1);
                    }
                    if ((s.substring(i + 1, i + 2).equals(" ")) || (s.substring(i + 1, i + 2).equals("\n"))) {
                        if (x.matches("\\d+")) {
                            int u = Integer.parseInt(x);
                            L[k][j] = u;
                            if (j == N - 1) {
                                j = 0;
                                ++k;
                            } else
                                ++j;
                        }
                    }
                }
            }
        }
    }
    public static void getN (String s)
    {
        for (int i = 1; i < s.length(); i++) {
            String s1,s2;
            s1 = s.substring(i,i+1);
            s2 = s.substring(i-1,i);
            if (((s1.equals("\n"))||(s1.equals(" "))&&(!(s2.equals(" "))))||(!((s1.equals("\n"))||(s1.equals(" ")))&&(i==s.length()-1)))
            {
                ++N;
            }
        }
        double n = Math.sqrt(N);
        N = (int) n;
    }
    public static String fix(String s)
    {
        s=" "+s + " ";
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i,i+1).equals("\n"))
            {
                String s1 = s.substring(0,i-1);
                String s2 = s.substring(i+1,s.length());
                s = s1+"  " +s2;

            }
        }
        return s;
    }
    
}
