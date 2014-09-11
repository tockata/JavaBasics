import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class Ball {
	private static final int DIAMETER = 50;
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	private Image tennisBall;
	
	private Game game;
	
	public Ball(Game game) {
		this.game = game;
	}
	
	public void move() {
		if (x + xa < 0) {
			xa = 1;
		}
		if (x + xa > game.getWidth() - DIAMETER) {
			xa = -1;
		}
		if (y + ya < 0) {
			ya = 1;
		}
		if (y + ya > game.getHeight() - DIAMETER) {
			game.gameOver();
		}
		if (collision()) {
			ya = -1;
			y = game.racquet.getX() - DIAMETER;
		}
		x += xa;
		y += ya;
	}
	
	public void paint(Graphics2D g) {
		ImageIcon tennisBallFace = new ImageIcon("tennis_ball.png");
		ImageIcon tennisBallBack = new ImageIcon("tennis_ball_blank.png");
		if (x % 30 == 0) {
			tennisBall = tennisBallFace.getImage();
		} else {
			tennisBall = tennisBallBack.getImage();
		}
		//tennisBall = ii.getImage();
		g.drawImage(tennisBall, x, y, DIAMETER, DIAMETER, null);
	}
	
	public Rectangle getBallBorders() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
	
	private boolean collision() {
		return game.racquet.getRacquetBorders().intersects(getBallBorders());
	}
	
}
