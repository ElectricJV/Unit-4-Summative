import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.*;

/**
 * 
 */

/**
 * @author Joshua
 *
 */
public class Picture extends JComponent{

	/**
	 * Class data
	 */
	private Color c;
	private int x, y, width, height;
	private ImageIcon img;
	private boolean useImage, useText;
	private String text;
	private Font font;
	
	/**
	 * Default constructor. Creates a red picture at 0,0
	 */
	public Picture() {
		this.c = Color.red;
		this.x = 0;
		this.y = 0;
		this.width = 100;
		this.height = 50;
		this.useImage = false;
		this.useText = false;
		this.img = null;
		repaint();
	}
	
	/**
	 * Constructor to specify components
	 */
	public Picture(int x, int y, int width, int height, Color c) {
		this.c = c;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.useImage = false;
		this.useText = false;
		this.img = null;
		repaint();
	}

	/**
	 * Constructor to use an image
	 */
	public Picture(int x, int y, ImageIcon img) {
		this.c = null;
		this.x = x;
		this.y = y;
		this.width = img.getIconWidth();
		this.height = img.getIconHeight();
		this.useImage = true;
		this.useText = false;
		this.img = img;
		repaint();
	}
	
	/**
	 * Constructor to paint text
	 */
	public Picture(String text, Font font,  int x, int y) {
		this.c = Color.BLACK;
		this.x = x; 
		this.y = y;
		this.useImage = false;
		this.useText = true;
		this.text = text;
		this.font = font; 
		this.img = null;
		repaint();
	}
	
	/**
	 * The component's paint method
	 */
	public void paint(Graphics g) {
		if (useImage) {
			img.paintIcon(this, g, this.x, this.y);
		}
		else if (useText) {
			g.setFont(font);
			g.drawString(text, x, y);
		}
		else {
			g.setColor(this.c);
			g.drawRect(x,  y, width, height);
			g.fillRect(x, y, width, height);
		}
	}
	
	public void setDrawString(boolean useText) 
	{
		this.useText = useText;
	}

	public void setFont(Font font)
	{
		this.font= font; 
	}
	
	public void setPic(ImageIcon img)
	{
		this.img = img;
	}
	
	public void setC(Color c)
	{
		this.c = c;
		repaint();
	}

	public void setC(int r, int g, int b) 
	{
		this.c = new Color (r, g, b);
		repaint();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame();
		
		Picture p0 = new Picture();
		f.setSize(400, 300);
		f.add(p0);
		f.setVisible(true);

		JOptionPane.showMessageDialog(null, "Wait");
		
		f.remove(p0);
		Picture p1 = new Picture(50, 50, 50, 100, Color.BLUE);
		
		f.add(p1);
		f.setVisible(true);
		
		JOptionPane.showMessageDialog(null, "Wait");
		
		f.remove(p1);
		Picture p2 = new Picture(10, 10, new ImageIcon("42%DiamondBank.png"));
		
		f.add(p2);
		f.setVisible(true);
		
		JOptionPane.showMessageDialog(null, "Wait");
		
		f.remove(p2);
		String word = JOptionPane.showInputDialog(null, "Enter a word to paint", "The LaFerrari is a nice car");
		Picture p3 = new Picture(word, new Font("Simple", Font.ITALIC, 20), 50, 50);
		
		f.add(p3);
		f.setVisible(true);
		
		
	}

}
