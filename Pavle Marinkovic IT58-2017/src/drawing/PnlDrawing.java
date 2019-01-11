package drawing;

import java.awt.Graphics;

import javax.swing.JPanel;

import drawing.Point;

public class PnlDrawing extends JPanel {
	private int x,y,x1,y1;
	private String oblik;
	
	PnlDrawing(int x, int y, String oblik){
		this.x=x;
		this.y=y;
		this.oblik=oblik;
	}
	
	PnlDrawing(int x, int y, int x1, String oblik){
		this.x=x;
		this.y=y;
		this.x1=x1;
		this.oblik=oblik;
	}
	
	PnlDrawing(int x, int y, int x1, int y1, String oblik){
		this.x=x;
		this.y=y;
		this.x1=x1;
		this.y1=y1;
		this.oblik=oblik;
	}
	
	/*public void paint(Graphics g, String oblik, int x, int y,int x1,int y1) {
		FrmAppDrawing d = new FrmAppDrawing();
		if(oblik.equals("tacka")) {
			Point p = new Point(x,y,false);
			p.draw(g);
		} else if(oblik.equals("linija")) {
			Point p = new Point(x,y);
			Point p1 = new Point(x1,y1);
			Line l = new Line(p,p1);
			l.draw(g);
		} else if(oblik.equals("pravougaonik")) {
			Point p = new Point(x,y);
			Rectangle r = new Rectangle(p,y1,x1);
			r.draw(g);
		} else if(oblik.equals("krug")) {
			Point p = new Point(x,y);
			Circle c = new Circle(p, x1);
			c.draw(g);
		} else if(oblik.equals("krugsarupom")) {
			Point p = new Point(x,y);
			Donut krugsarupom = new Donut(p, x1,y1);
			krugsarupom.draw(g);
		}
	}*/
	@Override
	public void paint(Graphics g) {
		FrmAppDrawing f = new FrmAppDrawing();
		if(oblik.equals("tacka")) {
			Point p = new Point(x,y,false);
			f.lista.add(p);
			p.draw(g);
		} else if(oblik.equals("linija")) {
			Point p = new Point(x,y);
			Point p1 = new Point(x1,y1);
			Line l = new Line(p,p1,false);
			l.draw(g);
		} else if(oblik.equals("pravougaonik")) {
			Point p = new Point(x,y);
			Rectangle r = new Rectangle(p,y1,x1,false);
			r.draw(g);
		} else if(oblik.equals("krug")) {
			Point p = new Point(x,y);
			Circle c = new Circle(p, x1);
			c.draw(g);
		} else if(oblik.equals("krugsarupom")) {
			Point p = new Point(x,y);
			Donut krugsarupom = new Donut(p, x1, y1, false);
			krugsarupom.draw(g);
		}

	}
}
