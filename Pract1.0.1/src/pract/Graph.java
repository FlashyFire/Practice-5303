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
        N=0;
        s=fix(s);
        s+=" ";
        for (int i = 1; i < s.length(); i++) {
            
            String s1,s2;
            s1 = s.substring(i,i+1);
            s2 = s.substring(i-1,i);
            if (s1.equals(" ")&&((s2.equals("1"))||((s2.equals("0"))||(s2.equals("2"))||(s2.equals("3"))
                    ||(s2.equals("4"))||(s2.equals("5"))||(s2.equals("6"))||(s2.equals("7"))
                    ||(s2.equals("8"))||(s2.equals("9")))))
                ++N;
        }
        double n = Math.sqrt(N);
        N = (int) n;
    }
    public static String fix(String s)
    {
        s=" "+s + " ";
        String S = " ";
        int l=s.length();
        for (int i = 0; i < l; i++) {
            if (s.substring(i, i+1).equals("1")||s.substring(i, i+1).equals("0")||s.substring(i, i+1).equals("2")||s.substring(i, i+1).equals("3")
                    ||s.substring(i, i+1).equals("4")||s.substring(i, i+1).equals("5")||s.substring(i, i+1).equals("6")||s.substring(i, i+1).equals("7")
                    ||s.substring(i, i+1).equals("8")||s.substring(i, i+1).equals("9")||s.substring(i, i+1).equals(" "))
            {
                 S+=s.substring(i, i+1);
                             }
            else
                S+=" ";
        }
        S+=" ";
        return S;
    }
    
}
