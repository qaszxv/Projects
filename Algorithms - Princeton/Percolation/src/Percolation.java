/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 *
 * @author hungle
 */
public class Percolation {

    private boolean[][] grid;
    private int N;
    private int virtualTop;
    private int virtualBottom;
    private int numbOpen = 0;

    private WeightedQuickUnionUF quickUnion;
    private WeightedQuickUnionUF quickUnionIsFull;

    public Percolation(int n) // create n-by-n grid, with all sites blocked
    {
        if (n <= 0) {
            throw new IllegalArgumentException(Integer.toString(n));
        }
        grid = new boolean[n][n];
        this.N = n;
        quickUnion = new WeightedQuickUnionUF(n * n + 2);
        quickUnionIsFull = new WeightedQuickUnionUF(n * n + 1);
        virtualTop = n * n;
        virtualBottom = n * n + 1;
    }

    public void open(int row, int col) // open site (row, col) if it is not open already
    {
        if (row <= 0 || row >= N + 1 || col <= 0 || col >= N + 1) {
            throw new IllegalArgumentException(Integer.toString(row));
        }

        if (isOpen(row, col)) {
            return;
        } else {
            grid[row - 1][col - 1] = true;
            numbOpen++;

            if (N == 1) {
                quickUnion.union(convertToInt(row, col), virtualTop);
                quickUnionIsFull.union(convertToInt(row, col), virtualTop);
                quickUnion.union(convertToInt(row, col), virtualBottom);
            } else if (row == 1) {
                quickUnion.union(convertToInt(row, col), virtualTop);
                quickUnionIsFull.union(convertToInt(row, col), virtualTop);
                if (isOpen(row + 1, col)) {
                    quickUnion.union(convertToInt(row, col), convertToInt(row + 1, col));
                    quickUnionIsFull.union(convertToInt(row, col), convertToInt(row + 1, col));
                }
            } else if (row == N) {
                quickUnion.union(convertToInt(row, col), virtualBottom);
                if (isOpen(row - 1, col)) {
                    quickUnion.union(convertToInt(row, col), convertToInt(row - 1, col));
                    quickUnionIsFull.union(convertToInt(row, col), convertToInt(row - 1, col));
                }
            } else {
                if (row > 1 && row < N) {
                    if (isOpen(row - 1, col)) {
                        quickUnion.union(convertToInt(row, col), convertToInt(row - 1, col));
                        quickUnionIsFull.union(convertToInt(row, col), convertToInt(row - 1, col));
                    }
                    if (isOpen(row + 1, col)) {
                        quickUnion.union(convertToInt(row, col), convertToInt(row + 1, col));
                        quickUnionIsFull.union(convertToInt(row, col), convertToInt(row + 1, col));
                    }

                } 
            }
            if ((col + 1 <= N) && isOpen(row, col + 1)) {
                quickUnion.union(convertToInt(row, col), convertToInt(row, col + 1));
                quickUnionIsFull.union(convertToInt(row, col), convertToInt(row, col + 1));
            }
            if ((col - 1 > 0) && isOpen(row, col - 1)) {
                quickUnion.union(convertToInt(row, col), convertToInt(row, col - 1));
                quickUnionIsFull.union(convertToInt(row, col), convertToInt(row, col - 1));
            }
        }
    }

    public boolean isOpen(int row, int col) // is site (row, col) open?
    {
        if (row <= 0 || row >= N + 1 || col <= 0 || col >= N + 1) {
            throw new IllegalArgumentException(Integer.toString(row));
        }
        return grid[row - 1][col - 1];
    }

    public boolean isFull(int row, int col) // is site (row, col) full?
    {
        if (row <= 0 || row >= N + 1 || col <= 0 || col >= N + 1) {
            throw new IllegalArgumentException(Integer.toString(row));
        }
        if (isOpen(row, col)) {
            if (quickUnionIsFull.connected(virtualTop, convertToInt(row, col))) {
                return true;
            }
        }
        return false;
    }

    public int numberOfOpenSites() // number of open sites
    {
        return numbOpen;
    }

    public boolean percolates() // does the system percolate?
    {
        if (quickUnion.connected(virtualTop, virtualBottom)) {
            return true;
        }
        return false;
    }

    private int convertToInt(int row, int col) {
        int number = (row - 1) * N + col - 1;
        return number;
    }

    public static void main(String[] args) {
        /*Percolation perco = new Percolation(3);
        perco.open(1, 3); 
        perco.open(2, 3); 
        perco.open(3, 3); 
        System.out.println(perco.percolates());
        perco.open(3, 1);
        
        System.out.println(perco.isFull(3, 1));*/
    }
}
