package win.qinhang3.apad.suit;

import win.qinhang3.apad.map.Map;
import win.qinhang3.apad.piece.Piece;

import java.util.List;

/**
 * @description:
 * @author: hang
 * @create: 2022/2/11
 **/
public interface Suit {
    Map getMap();
    List<Piece> getPieces();
}
