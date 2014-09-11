import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;


public class Racquet {
	private static final int WIDTH = 100;
	private static final int HEIGHT = 135;
	private static final int X = 0;
	
	private Image tennisRacket;
	int y = 282;
	int ya = 0;
	private Game game;
	
	public Racquet(Game game) {
		this.game = game;
	}
	
	public void move() {
		if (y + ya > 0 && y + ya < game.getHeight() - 135) {
			y = y + ya;
		}
	}
	
	public void paint(Graphics2D g) {
		ImageIcon racketUp = new ImageIcon("racket_up.png");
		ImageIcon racketDown = new ImageIcon("racket_down.png");
		if (y < 283) {
			tennisRacket = racketUp.getImage();
		} else {
			tennisRacket = racketDown.getImage();
		}
		g.drawImage(tennisRacket, X, y, WIDTH, HEIGHT, null);
	}
	
	public void keyReleased(KeyEvent e) {
		ya = 0;
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			ya = 3;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			ya = -3;
		}
	}
	
	public Rectangle getRacquetBorders() {
		return new Rectangle(X, y, WIDTH, HEIGHT);
	}
	
	public int getX() {
		return X;
	}
}
