package drawing;

import java.awt.Graphics;

import javax.swing.JPanel;

import drawing.Point;

public class PnlDrawing extends JPanel {
	
	public void paint(Graphics g, int x, int y) {
		FrmAppDrawing d = new FrmAppDrawing();
		Point p = new Point(x,y,false);
		p.draw(g);
	}
	
}
