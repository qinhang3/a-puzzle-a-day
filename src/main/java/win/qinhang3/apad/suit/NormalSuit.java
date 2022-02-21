package win.qinhang3.apad.suit;


import com.google.common.collect.Lists;
import lombok.Getter;
import win.qinhang3.apad.map.Map;
import win.qinhang3.apad.map.NormalMap;
import win.qinhang3.apad.piece.*;

import java.util.List;
import java.util.function.Consumer;

/**
 * @description:
 * @author: hang
 * @create: 2022/2/11
 **/
@Getter
public class NormalSuit implements Suit{
    private final Map map = new NormalMap();
    private final List<Piece> pieces = Lists.newArrayList(new Piece5_1(), new Piece5_2(), new Piece5_3(), new Piece5_4(), new Piece5_5(), new Piece5_6(), new Piece5_7(), new Piece6_1());

}
