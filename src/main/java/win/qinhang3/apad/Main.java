package win.qinhang3.apad;

import com.google.common.collect.Sets;
import win.qinhang3.apad.piece.Piece;
import win.qinhang3.apad.suit.DemoSuit;
import win.qinhang3.apad.suit.NormalSuit;
import win.qinhang3.apad.suit.Suit;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: hang
 * @create: 2022/2/11
 **/
public class Main {
    private static int count = 0;
    public static void main(String[] args) {
        Suit suit = new NormalSuit();

        //JUN 1
        suit.getMap().getData()[0][5] = 100;
        suit.getMap().getData()[2][1] = 100;

        //DEMO
//        suit.getMap().getData()[0][0] = 100;


        int p = 0;
        dfs(suit, p);
    }

    private static void dfs(Suit suit, int p){
        if (suit.getPieces().size() <= p){
            suit.getMap().printMap(++count);
            ImageUtil.draw(suit.getMap());
            return;
        }
        Piece piece = suit.getPieces().get(p);

        Set<Piece> usedPiece = Sets.newHashSet();
        for (int f = 0; f < 2; f++) {
            for (int r = 0; r < 4; r++) {
                if (usedPiece.contains(piece)){
                    continue;
                }
                usedPiece.add(piece);
                for (int i = 0; i < suit.getMap().getN(); i++) {
                    for (int j = 0; j < suit.getMap().getM(); j++) {
                        boolean b = suit.getMap().tryPiece(piece, i, j, p);
                        if (b){
                            dfs(suit, p + 1);
                            suit.getMap().removePiece(piece, i, j ,p);
                        }
                    }
                }

                piece = piece.rotate();
            }
            piece = piece.flip();
        }

    }
}
