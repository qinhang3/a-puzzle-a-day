package win.qinhang3.apad.map;

import win.qinhang3.apad.piece.Piece;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @description:
 * @author: hang
 * @create: 2022/2/11
 **/
public interface Map {
    int[][] getData();
    int getN();
    int getM();

    default Map copy(){
        int[][] nd = new int[getN()][getM()];
        for (int i = 0; i < getN(); i++) {
            for (int j = 0; j < getM(); j++) {
                nd[i][j] = getData()[i][j];
            }
        }
        return new TempMap(nd);
    }

    default void printMap(int count){
        System.out.printf("第%d种方案\n", count);
        for (int i = 0; i < getN(); i++) {
            for (int j = 0; j < getM(); j++) {
                System.out.printf("%04d ", getData()[i][j]);
            }
            System.out.println();
        }
        System.out.println("===============");
    }

    default boolean tryPiece(Piece piece, int x, int y, int p){
//        System.out.printf("tryPiece %d %d %d\n", x, y, p);
        for (int i = 0; i < piece.getX(); i++) {
            for (int j = 0; j < piece.getY(); j++) {
                if (piece.getData()[i][j] == 0){
                    continue;
                }
                int tx = i + x;
                int ty = j + y;
                if (tx >= getN() || ty >= getM()){
                    return false;
                }
                if (getData()[tx][ty] != 0){
                    return false;
                }
            }
        }
        //可以放下
        for (int i = 0; i < piece.getX(); i++) {
            for (int j = 0; j < piece.getY(); j++) {
                if (piece.getData()[i][j] == 0){
                    continue;
                }
                int tx = i + x;
                int ty = j + y;
                getData()[tx][ty] = p + 10;
            }
        }
        return true;
    }

    default void removePiece(Piece piece, int x, int y, int p){
        for (int i = 0; i < piece.getX(); i++) {
            for (int j = 0; j < piece.getY(); j++) {
                if (piece.getData()[i][j] == 0){
                    continue;
                }
                int tx = i + x;
                int ty = j + y;
                getData()[tx][ty] = 0;
            }
        }
    }
}
