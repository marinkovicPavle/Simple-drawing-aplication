package drawing;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

import drawing.Point;

public class PnlDrawing extends JPanel {
	private int x,y,x1,y1;
	private String oblik;
	
	private ArrayList<Object> lista = new ArrayList<>();
	
	private Point p;
	private Line l;
	private Rectangle r;
	private Circle c;
	private Donut krugSaRupom;
	
	public ArrayList<Object> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Object> lista) {
		this.lista = lista;
	}

	/*PnlDrawing(int x, int y, String oblik){
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
	}*/
	
	PnlDrawing(Point p, String oblik){
		this.p=p;
		this.oblik=oblik;
	}
	
	PnlDrawing(Line l, String oblik){
		this.l=l;
		this.oblik=oblik;
	}
	
	PnlDrawing(Rectangle r, String oblik){
		this.r=r;
		this.oblik=oblik;
	}
	
	PnlDrawing(Circle c, String oblik){
		this.c=c;
		this.oblik=oblik;
	}
	
	PnlDrawing(Donut krugSaRupom, String oblik){
		this.krugSaRupom=krugSaRupom;
		this.oblik=oblik;
	}
	
	PnlDrawing(){
	}
	//
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
			//Point p = new Point(x,y,false);
			lista.add(p);
			p.draw(g);
		} else if(oblik.equals("linija")) {
			/*Point p = new Point(x,y);
			Point p1 = new Point(x1,y1);
			Line l = new Line(p,p1,false);*/
			lista.add(l);
			l.draw(g);
		} else if(oblik.equals("pravougaonik")) {
			/*Point p = new Point(x,y);
			Rectangle r = new Rectangle(p,y1,x1,false);*/
			r.draw(g);
		} else if(oblik.equals("krug")) {
			/*Point p = new Point(x,y);
			Circle c = new Circle(p, x1);*/
			lista.add(c);
			c.draw(g);
		} else if(oblik.equals("krugsarupom")) {
			/*Point p = new Point(x,y);
			Donut krugsarupom = new Donut(p, x1, y1, false);*/
			lista.add(krugSaRupom);
			krugSaRupom.draw(g);
		}

	}
}
