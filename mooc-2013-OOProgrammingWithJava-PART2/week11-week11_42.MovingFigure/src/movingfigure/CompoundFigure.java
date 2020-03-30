/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author davido
 */
public class CompoundFigure extends Figure {

    List<Figure> figures;

    public CompoundFigure() {
        super(0, 0);
        this.figures = new ArrayList<Figure>();
    }

    public void add(Figure f) {
        figures.add(f);
    }

    @Override
    public void draw(Graphics g) {
        for (Figure f : figures) {
            f.draw(g);
        }
    }

    @Override
    public void move(int dx, int dy) {
        for (Figure f : figures) {
            f.move(dx, dy);
        }
    }

}
