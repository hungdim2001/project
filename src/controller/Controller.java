/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author
 */
public class Controller {
    
    private int row;
    private int col;
    private int[][] matrix;
    MainForm1 frame;
    private ArrayList<Integer> listIcon = new ArrayList<>();
    
    public Controller(MainForm1 frame, int row, int col) {//MainFrame frame,
        this.frame = frame;
        this.row = row;
        this.col = col;
        System.out.println(row + "," + col);
        createMatrix();
        showMatrix();
    }

    // show matrix
    public void showMatrix() {
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                System.out.printf("%3d", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("size List Icon: " + listIcon.size());
        for (int i = 0; i < listIcon.size(); i++) {
            System.out.print(listIcon.get(i) + " ");
        }
    }
    
    private boolean checkLineX(int y1, int y2, int x) {
        System.out.println("check line x");
        // find point have column max and min
        int min = Math.min(y1, y2);
        int max = Math.max(y1, y2);
        // run column
        for (int y = min + 1; y < max; y++) {
            if (matrix[x][y] != 0) { // if see barrier then die
                System.out.println("die: " + x + "" + y);
                return false;
            }
            System.out.println("ok: " + x + "" + y);
        }

        // not die -> success
        return true;
    }
    
    private boolean checkLineY(int x1, int x2, int y) {
        System.out.println("check line y");
        int min = Math.min(x1, x2);
        int max = Math.max(x1, x2);
        for (int x = min + 1; x < max; x++) {
            if (matrix[x][y] != 0) {
                System.out.println("die: " + x + "" + y);
                return false;
            }
            System.out.println("ok: " + x + "" + y);
        }
        return true;
    }

    // check in rectangle
    private boolean checkRectX(Point p1, Point p2) {
        System.out.println("check rect x");
        // find point have y min and max
        Point pMinY = p1, pMaxY = p2;
        if (p1.y > p2.y) {
            pMinY = p2;
            pMaxY = p1;
        }
        for (int y = pMinY.y; y <= pMaxY.y; y++) {
            if (y > pMinY.y && matrix[pMinY.x][y] != 0) {
                return false;
            }
            // check two line
            if ((matrix[pMaxY.x][y] == 0 || y == pMaxY.y)
                    && checkLineY(pMinY.x, pMaxY.x, y)
                    && checkLineX(y, pMaxY.y, pMaxY.x)) {
                
                System.out.println("Rect x");
                System.out.println("(" + pMinY.x + "," + pMinY.y + ") -> ("
                        + pMinY.x + "," + y + ") -> (" + pMaxY.x + "," + y
                        + ") -> (" + pMaxY.x + "," + pMaxY.y + ")");
                // if three line is true return column y
                return true;
            }
        }
        // have a line in three line not true then return -1
        return false;
    }
    
    private boolean checkRectY(Point p1, Point p2) {
        System.out.println("check rect y");
        // find point have y min
        Point pMinX = p1, pMaxX = p2;
        if (p1.x > p2.x) {
            pMinX = p2;
            pMaxX = p1;
        }
        // find line and y begin
        for (int x = pMinX.x; x <= pMaxX.x; x++) {
            if (x > pMinX.x && matrix[x][pMinX.y] != 0) {
                return false;
            }
            if ((matrix[x][pMaxX.y] == 0 || x == pMaxX.x)
                    && checkLineX(pMinX.y, pMaxX.y, x)
                    && checkLineY(x, pMaxX.x, pMaxX.y)) {
                
                System.out.println("Rect y");
                System.out.println("(" + pMinX.x + "," + pMinX.y + ") -> (" + x
                        + "," + pMinX.y + ") -> (" + x + "," + pMaxX.y
                        + ") -> (" + pMaxX.x + "," + pMaxX.y + ")");
                return true;
            }
        }
        return false;
    }

    /**
     * p1 and p2 are Points want check
     *
     * @param type : true is check with increase, false is decrease return
     * column can connect p1 and p2
     */
    private boolean checkMoreLineX(Point p1, Point p2, int type) {
        System.out.println("check chec more x");
        // find point have y min
        Point pMinY = p1, pMaxY = p2;
        if (p1.y > p2.y) {
            pMinY = p2;
            pMaxY = p1;
        }
        // find line and y begin
        int y = pMaxY.y + type;
        int row = pMinY.x;
        int colFinish = pMaxY.y;
        if (type == -1) {
            colFinish = pMinY.y;
            y = pMinY.y + type;
            row = pMaxY.x;
            System.out.println("colFinish = " + colFinish);
        }

        // find column finish of line
        // check more
        if ((matrix[row][colFinish] == 0 || pMinY.y == pMaxY.y)
                && checkLineX(pMinY.y, pMaxY.y, row)) {
            while (matrix[pMinY.x][y] == 0
                    && matrix[pMaxY.x][y] == 0) {
                if (checkLineY(pMinY.x, pMaxY.x, y)) {
                    
                    System.out.println("TH X " + type);
                    System.out.println("(" + pMinY.x + "," + pMinY.y + ") -> ("
                            + pMinY.x + "," + y + ") -> (" + pMaxY.x + "," + y
                            + ") -> (" + pMaxY.x + "," + pMaxY.y + ")");
                    return true;
                }
                y += type;
            }
        }
        return false;
    }
    
    private boolean checkMoreLineY(Point p1, Point p2, int type) {
        System.out.println("check more y");
        Point pMinX = p1, pMaxX = p2;
        if (p1.x > p2.x) {
            pMinX = p2;
            pMaxX = p1;
        }
        int x = pMaxX.x + type;
        int col = pMinX.y;
        int rowFinish = pMaxX.x;
        if (type == -1) {
            rowFinish = pMinX.x;
            x = pMinX.x + type;
            col = pMaxX.y;
        }
        if ((matrix[rowFinish][col] == 0 || pMinX.x == pMaxX.x)
                && checkLineY(pMinX.x, pMaxX.x, col)) {
            while (matrix[x][pMinX.y] == 0
                    && matrix[x][pMaxX.y] == 0) {
                if (checkLineX(pMinX.y, pMaxX.y, x)) {
                    System.out.println("TH Y " + type);
                    System.out.println("(" + pMinX.x + "," + pMinX.y + ") -> ("
                            + x + "," + pMinX.y + ") -> (" + x + "," + pMaxX.y
                            + ") -> (" + pMaxX.x + "," + pMaxX.y + ")");
                    return true;
                }
                x += type;
            }
        }
        return false;
    }
    
    public PointLine checkTwoPoint(Point p1, Point p2) {
        
        if (!p1.equals(p2) && matrix[p1.x][p1.y] == matrix[p2.x][p2.y]) {
            // check line with x
            if (p1.x == p2.x) {
                System.out.println("line x");
                if (checkLineX(p1.y, p2.y, p1.x)) {
                    return new PointLine(p1, p2);
                }
            }
            // check line with y
            if (p1.y == p2.y) {
                System.out.println("line y");
                if (checkLineY(p1.x, p2.x, p1.y)) {
                    System.out.println("ok line y");
                    return new PointLine(p1, p2);
                }
            }

            // check in rectangle with x
            if (checkRectX(p1, p2)) {
                System.out.println("rect x");
                return new PointLine(p1, p2);
            }

            // check in rectangle with y
            if (checkRectY(p1, p2)) {
                System.out.println("rect y");
                return new PointLine(p1, p2);
            }
            // check more right
            if (checkMoreLineX(p1, p2, 1)) {
                System.out.println("more right");
                return new PointLine(p1, p2);
            }
            // check more left
            if (checkMoreLineX(p1, p2, -1)) {
                System.out.println("more left");
                return new PointLine(p1, p2);
            }
            // check more down
            if (checkMoreLineY(p1, p2, 1)) {
                System.out.println("more down");
                return new PointLine(p1, p2);
            }
            // check more up
            if (checkMoreLineY(p1, p2, -1)) {
                System.out.println("more up");
                return new PointLine(p1, p2);
            }
        }
        return null;
    }
    
    private void createMatrix() {
        matrix = new int[row][col];
        for (int i = 0; i < col; i++) {
            matrix[0][i] = matrix[row - 1][i] = 0;
        }
        for (int i = 0; i < row; i++) {
            matrix[i][0] = matrix[i][col - 1] = 0;
        }
        
        Random rand = new Random();
        int imgCount = 20;
        int max = 6;//imgCount / 2
        int[] arr = new int[imgCount + 1];
        ArrayList<Point> listPoint = new ArrayList<Point>();
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                listPoint.add(new Point(i, j));
            }
        }
        int i = 0;
        do {
            int index = rand.nextInt(imgCount) + 1;
            if (arr[index] < max) {
                
                arr[index] += 2;
                for (int j = 0; j < 2; j++) {
                    try {
                        int size = listPoint.size();
                        int pointIndex = rand.nextInt(size);
                        matrix[listPoint.get(pointIndex).x][listPoint
                                .get(pointIndex).y] = index;
                        listPoint.remove(pointIndex);
                        listIcon.add(index);
                    } catch (Exception e) {
                    }
                }
                i++;
            }
        } while (i < row * col / 2);
    }
    
    public void changePosition() {
        Random rand = new Random();
        ArrayList<Integer> tempListIcon = new ArrayList<>();
        
        for(int i =0; i<listIcon.size(); i++){
        tempListIcon.add(listIcon.get(i));
        }
        System.out.println("row" + row + " col" + col);
        for (int i = 1; i < row -1; i++) {

            for (int j = 1; j < col -1; j++) {

                if (matrix[i][j] != 0) {
                    int randIndex = rand.nextInt(tempListIcon.size());
                    matrix[i][j] = tempListIcon.get(randIndex);
                    tempListIcon.remove(randIndex);
                    System.out.println("after rand:" + listIcon.size());
                }

            }

        }
      
        showMatrix();
    }
    
    public int getRow() {
        return row;
    }
    
    public void setRow(int row) {
        this.row = row;
    }
    
    public int getCol() {
        return col;
    }
    
    public void setCol(int col) {
        this.col = col;
    }
    
    public int[][] getMatrix() {
        return matrix;
    }
    
    public ArrayList<Integer> getListIcon() {
        return listIcon;
    }
    
    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
}
