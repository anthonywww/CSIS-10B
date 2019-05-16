import java.awt.Color;
import java.awt.Graphics;
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
		
		for (int i=0; i<entities.length; i++) {
			entities[i] = new Entity();
		}
		
		compute();
	}

	public void compute() {
		buffer = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(buffer, 0, 0, this);
		g.setColor(Color.LIGHT_GRAY);
		
		int radarWidth = 300;
		int radarHeight = 300;
		int radarRadius = (300/2)+20;
		
		g.drawOval((SCREEN_WIDTH/2) - (radarWidth/2), (SCREEN_HEIGHT/2) - (radarHeight/2), radarWidth, radarHeight);
		
		g.setColor(Color.GRAY);
		for (int i=-180; i<180; i+=30) {
			int x = (int) (radarRadius * -Math.cos(Math.toRadians(i+90))) + radarWidth;
			int y = (int) (radarRadius * -Math.sin(Math.toRadians(i+90))) + radarHeight;
			System.out.printf("i: %d X: %d Y: %d\n", i, x, y);
			g.drawLine(SCREEN_WIDTH/2, SCREEN_HEIGHT/2, x, y);
			String text = i + "*";
			int textWidth = g.getFontMetrics().stringWidth(text);
			int textHeight = g.getFontMetrics().getHeight();
			int textX = x;// + textWidth;
			int textY = y;// + textHeight;
			g.drawString(text, textX, textY);
		}
		
		
		g.setColor(Color.GREEN);
		final double myX = 0;
		final double myZ = 0;
		
		for (Entity e : entities) {
			double distance = Math.sqrt(Math.pow(myX-e.getX(), 2) + Math.pow(myZ-e.getZ(), 2));
			double angle = Math.atan2(e.getZ(), -e.getX());
			
			int x = (int) (distance * -Math.cos() + radarWidth;
			int y = (int) (distance * Math.sin() + radarHeight;
			
			int entityWidth = 3;
			int entityHeight = 3;
			
			g.drawOval(x, y, entityWidth, entityHeight);
			
			// Get distance to local player
			
			String text = e.name + "[]";
			int textWidth = g.getFontMetrics().stringWidth(text);
			int textHeight = g.getFontMetrics().getHeight();
			int textX = x;// + textWidth;
			int textY = y;// + textHeight;
			g.drawString(text, textX, textY);
		}
		
		
		System.out.printf("----\n");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			compute();
			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}
	
	
	class Entity {
		
		private String name;
		private int entityId;
		private double x;
		private double y;
		private double z;
		
		public Entity() {
			Random rand = new Random();
			byte[] bytes = new byte[7];
			rand.nextBytes(bytes);
			this.name = new String(bytes, Charset.forName("UTF-8"));
			this.entityId = rand.nextInt(10000);
			this.x = 10000 * rand.nextDouble() * (rand.nextBoolean() ? 1 : -1);
			this.y = 60 * rand.nextDouble() * (rand.nextBoolean() ? 1 : -1);
			this.z = 10000 * rand.nextDouble() * (rand.nextBoolean() ? 1 : -1);
		}
		
		public Entity(String name, int id, double x, double y, double z) {
			this.entityId = id;
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public String getName() {
			return name;
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
	}
}
