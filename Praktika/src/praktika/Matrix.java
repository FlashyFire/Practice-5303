/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktika;

import java.util.Arrays;

/**
 *
 * @author ntabu_000
 */

public class Matrix {
    private int width;
    private int height;
    private final int[] data;
    
    public Matrix(int width, int height) {
        if (width <= 0)
            throw new IllegalArgumentException("Invalid width.");
        if (height <= 0)
            throw new IllegalArgumentException("Invalid height.");
        this.width = width;
        this.height = height;
        this.data = new int[width * height];
        Arrays.fill(this.data, 0);
    }
    
    public int get(int col, int row) {
        checkIndexes(col, row);
        return this.data[col + row * this.width];
    }
    
    public void set(int col, int row, int value) {
        checkIndexes(col, row);
        this.data[col + row * this.width] = value;
    }
    
    public int width() {
        return this.width;
    }
    
    public int height() {
        return this.height;
    }
    
    public Matrix makeCopy() {
        Matrix copy = new Matrix(this.width, this.height);
        System.arraycopy(this.data, 0, copy.data, 0, this.data.length);
        return copy;
    }
    
    private void checkIndexes(int col, int row) {
        if (col < 0 || col >= this.width)
            throw new IndexOutOfBoundsException("Column index is out of bounds!");
        if (row < 0 || row >= this.height)
            throw new IndexOutOfBoundsException("Row index is out of bounds!");
    }
}