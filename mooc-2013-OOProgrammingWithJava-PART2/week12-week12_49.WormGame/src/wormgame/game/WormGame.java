package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    
    private Worm worm;
    private Apple apple;
    private Random random;

    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;

        addActionListener(this);
        setInitialDelay(2000);
        
        this.random = new Random();
        
        this.worm = new Worm(width / 2, height / 2, Direction.DOWN);
        this.apple = createApple();
    }


    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
    
    public Worm getWorm() {
        return this.worm;
    }
    
    public void setWorm(Worm worm) {
        this.worm = worm;
    }
    
    public Apple getApple() {
        return this.apple;
    }
    
    private Apple createApple() {
        Apple apple;
        do {
            apple = new Apple(this.random.nextInt(this.width), this.random.nextInt(this.height));
        } while (this.worm.runsInto(apple));
        return apple;
    }
    
    public void setApple(Apple apple) {
        this.apple = apple;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            return;
        }
        
        // move worm
        this.worm.move();
        
        // does worm hit apple
        if (this.worm.runsInto(apple)) {
            this.worm.grow();
            this.setApple(createApple());
        }
        
        // does worm hit itself
        if (this.worm.runsIntoItself()) {
            this.continues = false;
        }
        
        // does the head exceed boundary
        List<Piece> pieces = worm.getPieces();
        Piece head = pieces.get(pieces.size() - 1);
        if (head.getX() <= 0 || head.getY() <= 0 || head.getX() >= this.width || head.getY() >= this.height) {
            this.continues = false;
        }
        
        // call updatable
        this.updatable.update();
        
        // tick timer
        setDelay(1000 / this.worm.getLength());

    }

}
