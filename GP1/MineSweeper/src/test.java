import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class test {

    @Test
    public void testNoMines() {
        char[][] field = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };
        assertEquals(0, Minesweeper.countMines(field, 1, 1, 3, 3));
    }

    @Test
    public void testMinesOnEdge() {
        char[][] field = {
                {'*', '-', '-', '*'},
                {'-', '-', '-', '-'},
                {'*', '-', '-', '*'}
        };
        assertEquals(1, Minesweeper.countMines(field, 0, 1, 3, 4));
    }

    @Test
    public void testMinesInCorner() {
        char[][] field = {
                {'*', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '*'}
        };
        assertEquals(1, Minesweeper.countMines(field, 0, 0, 3, 3));
    }
}
