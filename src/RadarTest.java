import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.nio.charset.Charset;
import java.util.Random;

import javax.swing.JFrame;

public class RadarTest extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private final int SCREEN_WIDTH = 600;
	private final int SCREEN_HEIGHT = 600;
	private double x;
	private double y;
	private double z;
	private double yaw;
	private double pitch;
	private BufferedImage buffer;
	private Entity[] entities;

	public static void main(String[] args) {
		new RadarTest();
	}

	public RadarTest() {
		super("Radar Test");
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		addKeyListener(this);
		setResizable(false);
		setVisible(true);

		entities = new Entity[32];

		for (int i = 0; i < entities.length; i++) {
			entities[i] = new Entity();
			System.err.println("Entity: " + entities[i]);
		}

		x = 0;
		y = 0;
		z = 0;
		yaw = 0;
		pitch = 0;

		compute();
	}

	public void compute() {
		buffer = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
		super.repaint();
	}

	@Override
	public void paint(Graphics g) {
		
		BufferedImage bufferedImage = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = bufferedImage.createGraphics();
		// paint using g2d ...
		g2d.drawImage(buffer, 0, 0, this);
		Graphics2D g2dComponent = (Graphics2D) g;
		g2dComponent.drawImage(bufferedImage, null, 0, 0);
		
		
		g.drawImage(buffer, 0, 0, this);

		int radarWidth = 300;
		int radarHeight = 300;
		int radarRadius = (300 / 2) + 20;

		// Draw coordinates
		g.setColor(Color.WHITE);
		g.setFont(g.getFont().deriveFont(16.0F));
		String coords = String.format("X=%.2f / Z=%.2f / Yaw=%.2f", x, z, yaw);
		int coordsTextHeight = g.getFontMetrics().getHeight();
		int coordsTextX = 4;
		int coordsTextY = 18 + coordsTextHeight;
		g.drawString(coords, coordsTextX, coordsTextY);
		g.setFont(g.getFont().deriveFont(12.0F));
		String help = "Use Arrow Keys to move, W = -yaw, T = +yaw, X = reset position";
		int helpTextHeight = g.getFontMetrics().getHeight();
		int helpTextY = 36 + helpTextHeight;
		g.drawString(help, coordsTextX, helpTextY);
		
		// Draw Radar Circle
		g.setColor(Color.DARK_GRAY);
		g.drawOval((SCREEN_WIDTH / 2) - (radarWidth / 2), (SCREEN_HEIGHT / 2) - (radarHeight / 2), radarWidth, radarHeight);

		// Draw Distance Circles
		//g.setColor(Color.DARK_GRAY);
		// inner
		// g.drawOval((SCREEN_WIDTH/2) - (radarWidth/6), (SCREEN_HEIGHT/2) - (radarHeight/6), radarWidth/3, radarHeight/3);
		// half
		// g.drawOval((SCREEN_WIDTH / 2) - (radarWidth / 4), (SCREEN_HEIGHT / 2) - (radarHeight / 4), radarWidth / 2,radarHeight / 2);
		// outer
		// g.drawOval((SCREEN_WIDTH/2) - (radarWidth/3), (SCREEN_HEIGHT/2) - (radarHeight/3), (int) (radarWidth*0.5), (int) (radarHeight*0.5));

		// Draw Grid
		g.setColor(Color.DARK_GRAY);
		for (int i = -180; i < 180; i += 30) {
			int x = (int) (radarRadius * -Math.cos(Math.toRadians(i + 90))) + radarWidth;
			int y = (int) (radarRadius * -Math.sin(Math.toRadians(i + 90))) + radarHeight;

			// g.drawLine(SCREEN_WIDTH/2, SCREEN_HEIGHT/2, x, y);
			drawDashedLine(g, SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2, x, y);

			String text = i + "";
			int textWidth = g.getFontMetrics().stringWidth(text);
			int textHeight = g.getFontMetrics().getHeight();
			int textX = x - textWidth / 2;
			int textY = y + textHeight / 2;
			g.setFont(g.getFont().deriveFont(10.0F));
			g.drawString(text, textX, textY);
		}

		// Draw facing line
		g.setColor(Color.CYAN);
		int facingDX = (int) ((radarRadius-20) * -Math.cos(Math.toRadians(yaw + 90))) + radarWidth;
		int facingDY = (int) ((radarRadius-20) * -Math.sin(Math.toRadians(yaw + 90))) + radarHeight;
		//g.drawLine(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2, facingDX, facingDY);
		drawDashedLine(g, SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2, facingDX, facingDY);

		// Draw entities
		g.setColor(Color.GREEN);
		for (Entity e : entities) {
			//double distance = Math.sqrt(Math.pow(x - e.getX(), 2) + Math.pow(z - e.getZ(), 2));
			double distance = Math.sqrt(Math.pow(Math.max(x, e.getX()) - Math.min(x, e.getX()), 2) +
					Math.pow(Math.max(z, e.getZ()) - Math.min(z, e.getZ()), 2));

			if (distance > radarRadius-20) {
				continue;
			}

			double angle = Math.atan2(e.getX(), -e.getZ());
			int x = (int) (distance * -Math.cos(angle) + radarWidth);
			int y = (int) (distance * Math.sin(angle) + radarHeight);
//			int x = (int) (distance * -Math.cos(angle+Math.PI/2) + radarWidth);
//			int y = (int) (distance * Math.sin(angle+Math.PI/2) + radarHeight);

			int entityWidth = 3;
			int entityHeight = 3;
			
			g.drawOval(x, y, entityWidth, entityHeight);

			// Get distance to local player
			String text = e.toString();
			int textWidth = g.getFontMetrics().stringWidth(text);
			int textHeight = g.getFontMetrics().getHeight();
			int textX = x - textWidth/2;
			int textY = y - textHeight;
			g.drawString(text, textX, textY);
		}

	}

	private static void drawDashedLine(Graphics g, int x1, int y1, int x2, int y2) {
		// creates a copy of the Graphics instance
		Graphics2D g2d = (Graphics2D) g.create();

		// set the stroke of the copy, not the original
		Stroke dashed = new BasicStroke(0.1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 4 }, 0);
		g2d.setStroke(dashed);
		g2d.drawLine(x1, y1, x2, y2);

		// gets rid of the copy
		g2d.dispose();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		double dyaw = yaw;
		double dpitch = pitch;
		double dx = -Math.cos(pitch) * Math.sin(yaw);
		double dy = -Math.sin(pitch);
		double dz = Math.cos(pitch) * Math.cos(yaw);
		double magnitude = 0;

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			dyaw += 90;
			magnitude = -1;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			dyaw += 90;
			magnitude = 1;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			magnitude = 1;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			magnitude = -1;
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			yaw -= 30;
			if (yaw <= -180) {
				yaw = 180;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_T) {
			yaw += 30;
			if (yaw >= 180) {
				yaw = -180;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_X) {
			x = 0;
			y = 0;
			z = 0;
		}

		// Set delta vectors
		dx = -Math.cos(Math.toRadians(dpitch)) * Math.sin(Math.toRadians(dyaw));
		dy = -Math.sin(Math.toRadians(dpitch));
		dz = Math.cos(Math.toRadians(dpitch)) * Math.cos(Math.toRadians(dyaw));

		// Set position vectors
		x += magnitude * dx;
		y += magnitude * dy;
		z += magnitude * dz;
		
		compute();
	}

	class Entity {
		private int entityId;
		private double x;
		private double y;
		private double z;

		public Entity() {
			Random rand = new Random();
			this.entityId = rand.nextInt(10000);
			this.x = 400 * rand.nextDouble() * (rand.nextBoolean() ? 1 : -1);
			this.y = 60 * rand.nextDouble() * (rand.nextBoolean() ? 1 : -1);
			this.z = 400 * rand.nextDouble() * (rand.nextBoolean() ? 1 : -1);
		}

		public Entity(int id, double x, double y, double z) {
			this.entityId = id;
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public int getEntityId() {
			return entityId;
		}

		public double getX() {
			return x;
		}

		public void setX(double x) {
			this.x = x;
		}

		public double getY() {
			return y;
		}

		public void setY(double y) {
			this.y = y;
		}

		public double getZ() {
			return z;
		}

		public void setZ(double z) {
			this.z = z;
		}
		
		@Override
		public String toString() {
			return String.format("%d [X=%.0f Z=%.0f]", entityId, x, z);
		}
	}
}
