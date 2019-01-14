package drawing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JToggleButton.ToggleButtonModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;
import stack.DlgDodaj;

import java.awt.FlowLayout;
import java.awt.event.WindowStateListener;
import java.awt.image.BufferedImage;
import java.awt.event.WindowEvent;
import java.awt.Canvas;
import java.awt.Component;

public class FrmAppDrawing extends JFrame {

	private JPanel contentPane;
	private JToggleButton tglbtnTacka;
	private JToggleButton tglbtnLinija;
	private JToggleButton tglbtnPravougaonik;
	private JToggleButton tglbtnKrug;
	private JToggleButton tglbtnKrugSaRupom;

	private JToggleButton tglbtnSelektuj;

	private JButton btnSelektuj;
	private JButton btnModifikuj;
	private JButton btnObrisi;

	private final ButtonGroup buttonGroup = new ButtonGroup();

	private String oblik;

	private int x1, y1;
	private int x, y;

	private boolean cekiranTacka, cekiranLinija, cekiranPravougaonik, cekiranKrug, cekiranKrugSaRupom, cekiranSelektuj;
	private boolean isKrug; // NE RADI TI ZA KRUG RESI TO!

	public ArrayList lista = new ArrayList<>();

	public ArrayList<Point> listaTac = new ArrayList<Point>();

	private JLabel lblNewLabel_1;
	public JLabel lblNewLabel;
	//

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	//
	public String getOblik() {
		return oblik;
	}

	public void setOblik(String oblik) {
		this.oblik = oblik;
	}

	public boolean getIsKrug() {
		return isKrug;
	}

	public void setIsKrug(boolean isKrug) {
		this.isKrug = isKrug;
	}

	public JToggleButton getTglbtnTacka() {
		return tglbtnTacka;
	}

	public void setTglbtnTacka(JToggleButton tglbtnTacka) {
		this.tglbtnTacka = tglbtnTacka;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAppDrawing frame = new FrmAppDrawing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	int brojac = 0;

	public FrmAppDrawing() {
		setTitle("Crtanje Aplikacija");
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Graphics g = getGraphics();
				if (tglbtnTacka.isSelected()) {
					x = e.getX();
					y = e.getY();
					Point p = new Point(x, y);
					lista.add(p);
					listaTac.add(p);
					oblik = "tacka";
					PnlDrawing crtaj = new PnlDrawing(p, oblik);
					// PnlDrawing crtaj = new PnlDrawing(x, y, oblik);
					// crtaj.paint(g,oblik,x,y,0,0);
					crtaj.paint(g);
				} else if (tglbtnLinija.isSelected()) {
					oblik = "linija";
					if (brojac == 0) {
						x = e.getX();
						y = e.getY();
						brojac++;
					} else if (brojac == 1) {
						x1 = e.getX();
						y1 = e.getY();
						Point p1 = new Point(x, y);
						Point p2 = new Point(x1, y1);
						Line l = new Line(p1, p2);
						lista.add(l);
						PnlDrawing crtaj = new PnlDrawing(l, oblik);
						// PnlDrawing crtaj = new PnlDrawing(x, y, x1, y1, oblik);
						crtaj.paint(g);
						// crtaj.paint(g,oblik,x,y,x1,y1);
						// crtaj.paint(g);
						brojac = 0;
					}
				} else if (tglbtnPravougaonik.isSelected()) {
					x = e.getX();
					y = e.getY();
					DlgUnos unos = new DlgUnos();
					unos.pack();
					unos.setTitle("Pravougaonik");
					unos.setVisible(true);
					if (unos.isOK()) {
						oblik = "pravougaonik";
						x1 = Integer.parseInt(unos.getTxtUnos().getText());
						y1 = Integer.parseInt(unos.getTxtUnos1().getText());
					}
					Point p = new Point(x, y);
					Rectangle r = new Rectangle(p, y1, x1);
					lista.add(r);
					PnlDrawing crtaj = new PnlDrawing(r, oblik);
					// PnlDrawing crtaj = new PnlDrawing(x, y, x1, y1, oblik);
					// crtaj.paint(g,oblik,x,y,x1,y1);
					crtaj.paint(g);
				} else if (tglbtnKrug.isSelected()) {
					x = e.getX();
					y = e.getY();
					DlgUnosKrug unos = new DlgUnosKrug();
					unos.pack(); // da dijalog prilagodimo komponentama
					unos.setVisible(true);
					if (unos.isOK()) {
						oblik = "krug";
						x1 = Integer.parseInt(unos.getTxtPoluprecnik().getText());
					}
					Point p = new Point(x, y);
					Circle c = new Circle(p, x1);
					lista.add(c);
					PnlDrawing crtaj = new PnlDrawing(c, oblik);
					// PnlDrawing crtaj = new PnlDrawing(x, y, x1, oblik);
					// crtaj.paint(g,oblik,x,y,x1,0);
					crtaj.paint(g);
				} else if (tglbtnKrugSaRupom.isSelected()) {
					x = e.getX();
					y = e.getY();
					DlgUnos unos = new DlgUnos();
					unos.getLblUnesite().setText("Unesite poluprecnik spoljasnjeg kruga:");
					unos.getLblUnesite1().setText("Unesite poluprecnik unutrasnjeg kruga:");
					unos.pack();
					unos.setTitle("Krug sa rupom");
					unos.setVisible(true);
					if (unos.isOK()) {
						oblik = "krugsarupom";
						x1 = Integer.parseInt(unos.getTxtUnos().getText());
						y1 = Integer.parseInt(unos.getTxtUnos1().getText());
					}
					Point p = new Point(x, y);
					Donut kurgSaRupom = new Donut(p, x1, y1);
					lista.add(kurgSaRupom);
					PnlDrawing crtaj = new PnlDrawing(kurgSaRupom, oblik);
					// PnlDrawing crtaj = new PnlDrawing(x, y, x1, y1, oblik);
					// crtaj.paint(g,oblik,x,y,x1,y1);
					crtaj.paint(g);
				} else if (tglbtnSelektuj.isSelected()) {
					for (Object o : lista) {
						if (o instanceof Point) {
							Point p = (Point) o;
							if (p.contains(e.getX(), e.getY())) {
								lblNewLabel.setText("DA");
								p.setSelected(true);
							}
						} else if (o instanceof Line) {
							Line l = (Line) o;
							if (l.contains(e.getX(), e.getY())) {
								lblNewLabel.setText("DA");
								l.setSelected(true);
							}
						} else if (o instanceof Rectangle) {
							Rectangle r = (Rectangle) o;
							if (r.contains(e.getX(), e.getY())) {
								lblNewLabel.setText("DA");
								r.setSelected(true);
							}
						} else if (o instanceof Circle) {
							Circle c = (Circle) o;
							if (c.contains(e.getX(), e.getY())) {
								lblNewLabel.setText("DA");
								c.setSelected(true);
							}
						} else if (o instanceof Donut) {
							Donut krugSaRupom = (Donut) o;
							if (krugSaRupom.contains(e.getX(), e.getY())) {
								lblNewLabel.setText("DA");
								krugSaRupom.setSelected(true);
							}
						}
					}
				}
				/*
				 * for (int i = 0; i < listaTac.size(); i++) { if
				 * (listaTac.get(i).contains(e.getX(), e.getY())){
				 * listaTac.get(i).setSelected(true); lblNewLabel.setText("DA"); }
				 */

				/*
				 * Point p = (Point)lista.get(0); if(p.contains(e.getX(), e.getY())) {
				 * lblNewLabel.setText("DA"); p.setSelected(true); } else {
				 * lblNewLabel.setText("NE"); }
				 */
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pnlDugmici = new JPanel();
		pnlDugmici.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		contentPane.add(pnlDugmici, BorderLayout.NORTH);

		tglbtnTacka = new JToggleButton("Tacka");
		tglbtnTacka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cekiranTacka == false) {
					cekiranTacka = true;
					cekiranLinija = false;
					cekiranPravougaonik = false;
					cekiranKrug = false;
					cekiranKrugSaRupom = false;
					cekiranSelektuj = false;
				} else {
					buttonGroup.clearSelection();
					cekiranTacka = false;
				}
			}
		});
		/*
		 * tglbtnTacka.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) {
		 * 
		 * //Graphics g = getGraphics(); //PnlDrawing crtaj = new PnlDrawing();
		 * //crtaj.paint(g); //Point p = new Point(mouse) } });
		 */
		buttonGroup.add(tglbtnTacka);
		pnlDugmici.add(tglbtnTacka);

		tglbtnLinija = new JToggleButton("Linija");
		tglbtnLinija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cekiranLinija == false) {
					cekiranLinija = true;
					cekiranTacka = false;
					cekiranPravougaonik = false;
					cekiranKrug = false;
					cekiranKrugSaRupom = false;
					cekiranSelektuj = false;
				} else {
					buttonGroup.clearSelection();
					cekiranLinija = false;
				}
			}
		});
		buttonGroup.add(tglbtnLinija);
		pnlDugmici.add(tglbtnLinija);

		tglbtnPravougaonik = new JToggleButton("Pravougaonik");
		tglbtnPravougaonik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cekiranPravougaonik == false) {
					cekiranPravougaonik = true;
					cekiranTacka = false;
					cekiranLinija = false;
					cekiranKrug = false;
					cekiranKrugSaRupom = false;
					cekiranSelektuj = false;
					/*DlgUnos unos = new DlgUnos();
					unos.pack();
					unos.setTitle("Pravougaonik");
					unos.setVisible(true);
					if (unos.isOK()) {
						oblik = "pravougaonik";
						x1 = Integer.parseInt(unos.getTxtUnos().getText());
						y1 = Integer.parseInt(unos.getTxtUnos1().getText());
					}*/
				} else {
					buttonGroup.clearSelection();
					cekiranPravougaonik = false;
				}
			}
		});
		buttonGroup.add(tglbtnPravougaonik);
		pnlDugmici.add(tglbtnPravougaonik);

		tglbtnKrug = new JToggleButton("Krug");
		tglbtnKrug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cekiranKrug == false) {
					cekiranKrug = true;
					cekiranTacka = false;
					cekiranLinija = false;
					cekiranPravougaonik = false;
					cekiranKrugSaRupom = false;
					cekiranSelektuj = false;
					/*DlgUnosKrug unos = new DlgUnosKrug();
					unos.pack(); // da dijalog prilagodimo komponentama
					unos.setVisible(true);
					if (unos.isOK()) {
						oblik = "krug";
						x1 = Integer.parseInt(unos.getTxtPoluprecnik().getText());
					}*/
				} else {
					buttonGroup.clearSelection();
					cekiranKrug = false;
				}
			}
		});
		buttonGroup.add(tglbtnKrug);
		pnlDugmici.add(tglbtnKrug);

		tglbtnKrugSaRupom = new JToggleButton("Krug sa rupom");
		tglbtnKrugSaRupom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cekiranKrugSaRupom == false) {
					cekiranKrugSaRupom = true;
					cekiranTacka = false;
					cekiranLinija = false;
					cekiranPravougaonik = false;
					cekiranKrug = false;
					cekiranSelektuj = false;
					/*DlgUnos unos = new DlgUnos();
					unos.getLblUnesite().setText("Unesite poluprecnik spoljasnjeg kruga:");
					unos.getLblUnesite1().setText("Unesite poluprecnik unutrasnjeg kruga:");
					unos.pack();
					unos.setTitle("Krug sa rupom");
					unos.setVisible(true);
					if (unos.isOK()) {
						oblik = "krugsarupom";
						x1 = Integer.parseInt(unos.getTxtUnos().getText());
						y1 = Integer.parseInt(unos.getTxtUnos1().getText());
					}*/
				} else {
					buttonGroup.clearSelection();
					cekiranKrugSaRupom = false;
				}
			}
		});
		buttonGroup.add(tglbtnKrugSaRupom);
		pnlDugmici.add(tglbtnKrugSaRupom);

		JPanel pnlCrtanje = new JPanel();
		/*
		 * pnlCrtanje.addMouseListener(new MouseAdapter() {
		 * 
		 * @Override public void mouseClicked(MouseEvent e) { int x = e.getX(); int y =
		 * e.getY();
		 * 
		 * Graphics g = getGraphics(); PnlDrawing crtaj = new PnlDrawing();
		 * if(tglbtnTacka.isSelected()) { //oblik="tacka"; //crtaj.paint(g,oblik,x,y);
		 * g.fillOval(e.getX(), e.getY(), 30, 30);
		 * lblNewLabel.setText("x= "+x+" y= "+y); } else if(tglbtnLinija.isSelected()) {
		 * oblik="linija"; crtaj.paint(g, oblik, x, y); } } });
		 */
		contentPane.add(pnlCrtanje, BorderLayout.CENTER);
		pnlCrtanje.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblNewLabel = new JLabel("New label");
		pnlCrtanje.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("New label");
		pnlCrtanje.add(lblNewLabel_1);

		JPanel pnlModifikacija = new JPanel();
		pnlModifikacija.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		contentPane.add(pnlModifikacija, BorderLayout.SOUTH);

		tglbtnSelektuj = new JToggleButton("Selektuj");
		tglbtnSelektuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cekiranSelektuj == false) {
					cekiranSelektuj = true;
					cekiranTacka = false;
					cekiranPravougaonik = false;
					cekiranKrug = false;
					cekiranKrugSaRupom = false;
					cekiranLinija = false;
				} else {
					buttonGroup.clearSelection();
					cekiranSelektuj = false;
				}
			}
		});
		pnlModifikacija.add(tglbtnSelektuj);
		buttonGroup.add(tglbtnSelektuj);

		btnSelektuj = new JButton("Selektuj");
		pnlModifikacija.add(btnSelektuj);

		btnModifikuj = new JButton("Modifikuj");
		pnlModifikacija.add(btnModifikuj);

		btnObrisi = new JButton("Obrisi");
		pnlModifikacija.add(btnObrisi);
	}

}
