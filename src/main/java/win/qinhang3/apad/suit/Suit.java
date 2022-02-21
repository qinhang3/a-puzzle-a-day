package win.qinhang3.apad.suit;

import com.google.common.collect.Sets;
import win.qinhang3.apad.map.Map;
import win.qinhang3.apad.piece.Piece;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

/**
 * @description:
 * @author: hang
 * @create: 2022/2/11
 **/
public interface Suit {
    Map getMap();
    List<Piece> getPieces();

    default void run(Consumer<Map> callback){
        dfs(0, callback);
    }

    default void dfs(int p, Consumer<Map> callback){
        if (this.getPieces().size() <= p){
            callback.accept(getMap());
        }
        Piece piece = this.getPieces().get(p);

        Set<Piece> usedPiece = Sets.newHashSet();
        for (int f = 0; f < 2; f++) {
            for (int r = 0; r < 4; r++) {
                if (usedPiece.contains(piece)){
                    continue;
                }
                usedPiece.add(piece);
                for (int i = 0; i < this.getMap().getN(); i++) {
                    for (int j = 0; j < this.getMap().getM(); j++) {
                        boolean b = this.getMap().tryPiece(piece, i, j, p);
                        if (b){
                            dfs(p + 1, callback);
                            this.getMap().removePiece(piece, i, j ,p);
                        }
                    }
                }

                piece = piece.rotate();
            }
            piece = piece.flip();
        }

    }
}
