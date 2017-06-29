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
                            } else {
                                ++j;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void getN(String s) {
        N = 0;
        s = fix(s);
        s += " ";
        for (int i = 1; i < s.length(); i++) {

            String s1, s2;
            s1 = s.substring(i, i + 1);
            s2 = s.substring(i - 1, i);
            if (s1.equals(" ") && ((s2.equals("1")) || ((s2.equals("0")) || (s2.equals("2")) || (s2.equals("3"))
                    || (s2.equals("4")) || (s2.equals("5")) || (s2.equals("6")) || (s2.equals("7"))
                    || (s2.equals("8")) || (s2.equals("9"))))) {
                ++N;
            }
        }
        double n = Math.sqrt(N);
        N = (int) n;
    }

    public static String fix(String s) {
        s = " " + s + " ";
        String S = " ";
        int l = s.length();
        for (int i = 0; i < l; i++) {
            if (s.substring(i, i + 1).equals("1") || s.substring(i, i + 1).equals("0") || s.substring(i, i + 1).equals("2") || s.substring(i, i + 1).equals("3")
                    || s.substring(i, i + 1).equals("4") || s.substring(i, i + 1).equals("5") || s.substring(i, i + 1).equals("6") || s.substring(i, i + 1).equals("7")
                    || s.substring(i, i + 1).equals("8") || s.substring(i, i + 1).equals("9") || s.substring(i, i + 1).equals(" ")) {
                S += s.substring(i, i + 1);
            } else {
                S += " ";
            }
        }
        S += " ";
        return S;
    }

    public static int[][] gen(int n, int w) {
        int[][] D = new int[n][n];
        int[] b = new int[n];
        int e = 0;
        for (int i = 0; i < n; i++) {
            int u = rnd(100);
            int k = 0;
            if (n > 3) {
                k = 2;
            } else if (n == 2) {
                k = 1;
            }
            for (int j = 0; j < k; j++) {
                int y = 0;
                while (y == 0) {
                    int r = rnd(n - 1);
                    if (i == r) {
                        int z = 0;
                        for (int l = 0; l < n; l++) {
                            if ((b[l] <= e) && l != i) {
                                z = 1;
                            }
                        }
                        if (z == 0) {
                            ++e;
                        }
                    }
                    if (r != i && b[r] <= e) {
                        D[i][r] = rnd(w);
                        ++b[r];
                        y = 1;
                    }
                }
            }

        }
        int n1;
        int n2;
        for (int i = 0; i < n; i++) {
            n1 = 0;
            n2 = 0;
            for (int j = 0; j < n; j++) {
                if (D[i][j] == 0) {
                    ++n1;
                }
                if (D[j][i] == 0) {
                    ++n2;
                }
            }
            if (n1 == n - 1) {
                int c = rnd(n - 1);
                while (c == i) {
                    c = rnd(n - 1);
                }
                D[i][c] = rnd(w);
            }
            if (n2 == n - 1) {
                int c = rnd(n - 1);
                while (c == i) {
                    c = rnd(n - 1);
                }
                D[c][i] = rnd(w);
            }
        }
        return D;

    }

    protected static int rnd(int max) {
        if (max != 0)
            return (int)(Math.random() * ++max);
        return 0;
    }
}
