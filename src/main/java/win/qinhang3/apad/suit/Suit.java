package win.qinhang3.apad.suit;

import com.google.common.collect.Sets;
import win.qinhang3.apad.map.Map;
import win.qinhang3.apad.piece.Piece;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * @description:
 * @author: hang
 * @create: 2022/2/11
 **/
public interface Suit {
    Map getMap();
    List<Piece> getPieces();

    default void run(BiConsumer<Map, AtomicBoolean> callback){
        dfs(0, callback, new AtomicBoolean(false));
    }

    default void dfs(int p, BiConsumer<Map, AtomicBoolean> callback, AtomicBoolean finish){
        if (this.getPieces().size() <= p){
            callback.accept(getMap(), finish);
            return;
        }
        Piece piece = this.getPieces().get(p);

        Set<Piece> usedPiece = Sets.newHashSet();
        for (int f = 0; f < 2 && !finish.get(); f++) {
            for (int r = 0; r < 4 && !finish.get(); r++) {
                if (usedPiece.contains(piece)){
                    continue;
                }
                usedPiece.add(piece);
                for (int i = 0; i < this.getMap().getN() && !finish.get(); i++) {
                    for (int j = 0; j < this.getMap().getM() && !finish.get(); j++) {
                        boolean b = this.getMap().tryPiece(piece, i, j, p);
                        if (b){
                            dfs(p + 1, callback, finish);
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
