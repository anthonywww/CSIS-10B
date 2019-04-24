import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class FractalTest extends JFrame implements KeyListener {
	
	private static final long serialVersionUID = 1L;
	private final int SCREEN_WIDTH = 800;
	private final int SCREEN_HEIGHT = 600;

	// Fractal image
	private BufferedImage fractal;

	// Number of max iterations
	private int maxIter = 500;
	// Zoom factor
	private double zoom = 150;
	// Coordinates
	private double xPos = SCREEN_WIDTH / 2;
	private double yPos = SCREEN_HEIGHT / 2;

	// Algorithm variables
	private double zx, zy, cX, cY, tmp;

	public static void main(String[] args) {
		// Create the frame and make it visible
		new FractalTest().setVisible(true);
	}

	public FractalTest() {
		super("Mandelbrot Set");
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		addKeyListener(this);
		setResizable(false);

		// Compute the fractal to start
		ComputeFractal();
	}

	public void ComputeFractal() {
		fractal = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);

		for (int y = 0; y < fractal.getHeight(); y++) {
			for (int x = 0; x < fractal.getWidth(); x++) {
				zx = zy = 0;
				cX = (x - xPos) / zoom;
				cY = (y - yPos) / zoom;

				int iter;

				for (iter = 0; iter < maxIter && zx * zx + zy * zy < 4; iter++) {
					tmp = zx * zx - zy * zy + cX;
					zy = 2.0 * zx * zy + cY;
					zx = tmp;
				}

				// If the point is in the set
				if (iter == maxIter) {
					Color color = new Color(0, 0, 0);
					fractal.setRGB(x, y, color.getRGB());
				}
				// If the point is not in the set
				else {
					double r = iter | (iter << 2);
					while (r > 255) {
						r -= 255;
					}
					double g = iter | (iter << 4);
					while (g > 255) {
						g -= 255;
					}
					double b = iter | (iter << 8);
					while (b > 255) {
						b -= 255;
					}

					Color color = new Color((int) r, (int) g, (int) b);
					fractal.setRGB(x, y, color.getRGB());
				}
			}
		}

		repaint();
	}

	public void paint(Graphics g) {
		// Draw the fractal
		g.drawImage(fractal, 0, 0, this);
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			zoom += 100;
			ComputeFractal();
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			xPos += 50;
			ComputeFractal();
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			xPos -= 50;
			ComputeFractal();
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			yPos += 50;
			ComputeFractal();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			yPos -= 50;
			ComputeFractal();
		}
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {

	}
}