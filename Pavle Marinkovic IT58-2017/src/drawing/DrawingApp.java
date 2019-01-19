package drawing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DrawingApp extends JFrame {

	private JPanel contentPane;

	private PnlDrawing panelCrtanje = new PnlDrawing(this);

	private final ButtonGroup buttonGroup = new ButtonGroup();

	private JToggleButton tglbtnSelektuj;
	private JToggleButton tglbtnTacka, tglbtnLinija, tglbtnPravougaonik, tglbtnKrug, tglbtnKrugSaRupom;

	private JPanel pnlSelekcija, pnlCrtanje;
	private JButton btnObrisi;

	private boolean cekiranTacka, cekiranLinija, cekiranPravougaonik, cekiranKrug, cekiranKrugSaRupom, cekiranSelektuj;
	private JButton btnModifikuj;

	public JToggleButton getTglbtnSelektuj() {
		return tglbtnSelektuj;
	}

	public void setTglbtnSelektuj(JToggleButton tglbtnSelektuj) {
		this.tglbtnSelektuj = tglbtnSelektuj;
	}

	public JToggleButton getTglbtnTacka() {
		return tglbtnTacka;
	}

	public void setTglbtnTacka(JToggleButton tglbtnTacka) {
		this.tglbtnTacka = tglbtnTacka;
	}

	public JToggleButton getTglbtnLinija() {
		return tglbtnLinija;
	}

	public void setTglbtnLinija(JToggleButton tglbtnLinija) {
		this.tglbtnLinija = tglbtnLinija;
	}

	public JToggleButton getTglbtnPravougaonik() {
		return tglbtnPravougaonik;
	}

	public void setTglbtnPravougaonik(JToggleButton tglbtnPravougaonik) {
		this.tglbtnPravougaonik = tglbtnPravougaonik;
	}

	public JToggleButton getTglbtnKrug() {
		return tglbtnKrug;
	}

	public void setTglbtnKrug(JToggleButton tglbtnKrug) {
		this.tglbtnKrug = tglbtnKrug;
	}

	public JToggleButton getTglbtnKrugSaRupom() {
		return tglbtnKrugSaRupom;
	}

	public void setTglbtnKrugSaRupom(JToggleButton tglbtnKrugSaRupom) {
		this.tglbtnKrugSaRupom = tglbtnKrugSaRupom;
	}

	public static void main(String[] args) {
		// EventQueue.invokeLater(new Runnable() {
		// public void run() {
		// try {
		DrawingApp frame = new DrawingApp();
		frame.setVisible(true);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// });
	}

	/**
	 * Create the frame.
	 */
	public DrawingApp() {
		setTitle("Drawing - Marinkovic Pavle IT58/2017");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		contentPane.add(panelCrtanje);

		pnlSelekcija = new JPanel();
		contentPane.add(pnlSelekcija, BorderLayout.SOUTH);

		tglbtnSelektuj = new JToggleButton("Selektuj");
		tglbtnSelektuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		pnlSelekcija.add(tglbtnSelektuj);
		buttonGroup.add(tglbtnSelektuj);

		btnObrisi = new JButton("Obrisi");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				brisi();
			}
		});

		btnModifikuj = new JButton("Modifikuj");
		btnModifikuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modifikuj();
			}
		});
		pnlSelekcija.add(btnModifikuj);
		pnlSelekcija.add(btnObrisi);

		pnlCrtanje = new JPanel();
		contentPane.add(pnlCrtanje, BorderLayout.NORTH);

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
		buttonGroup.add(tglbtnTacka);
		pnlCrtanje.add(tglbtnTacka);

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
		pnlCrtanje.add(tglbtnLinija);

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
				} else {
					buttonGroup.clearSelection();
					cekiranPravougaonik = false;
				}
			}
		});
		buttonGroup.add(tglbtnPravougaonik);
		pnlCrtanje.add(tglbtnPravougaonik);

		tglbtnKrug = new JToggleButton("Krug");
		tglbtnKrug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cekiranKrug == false) {
					cekiranKrug = true;
					cekiranTacka = false;
					cekiranLinija = false;
					cekiranPravougaonik = false;
					cekiranKrugSaRupom = false;
					cekiranSelektuj = false;
				} else {
					buttonGroup.clearSelection();
					cekiranKrug = false;
				}
			}
		});
		buttonGroup.add(tglbtnKrug);
		pnlCrtanje.add(tglbtnKrug);

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
				} else {
					buttonGroup.clearSelection();
					cekiranKrugSaRupom = false;
				}
			}
		});
		buttonGroup.add(tglbtnKrugSaRupom);
		pnlCrtanje.add(tglbtnKrugSaRupom);

	}

	protected void brisi() {
		Shape selected = panelCrtanje.getSelected();
		if (selected != null) {
			int selectedOption = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Obavestenje",
					JOptionPane.YES_NO_OPTION);
			if (selectedOption == JOptionPane.YES_OPTION) {
				panelCrtanje.getShapes().remove(selected);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Niste izabrali ni jedan objekat!","Greska", JOptionPane.WARNING_MESSAGE);
		}
		panelCrtanje.setSelected(null);
		panelCrtanje.repaint();
	}

	protected void modifikuj() {
		int korX = 0, korY = 0, x1 = 0, y1 = 0;
		Shape selected = panelCrtanje.getSelected();
		if (selected != null) {
			if (selected instanceof Point) {
				Point p = (Point) selected;
				DlgIzmenaTacka izmena = new DlgIzmenaTacka();
				izmena.getTxtX().setText("" + p.getX());
				izmena.getTxtY().setText("" + p.getY());
				izmena.pack();
				izmena.setVisible(true);
				if (izmena.isOK()) {
					korX = Integer.parseInt(izmena.getTxtX().getText());
					korY = Integer.parseInt(izmena.getTxtY().getText());
					p = new Point(korX, korY);
					p.setColor(izmena.getC());
					panelCrtanje.getShapes().set(panelCrtanje.getShapes().indexOf(selected), p);
				}
			} else if (selected instanceof Line) {
				Line l = (Line) selected;
				DlgIzmena izmena = new DlgIzmena();
				izmena.setTitle("Linija");
				izmena.getLblX().setText("Unesite X koordinatu pocetne tacke:");
				izmena.getLblY().setText("Unesite Y koordinatu pocetne tacke:");
				izmena.getLblUnesite().setText("Unesite X koordinatu krajnje tacke:");
				izmena.getLblUnesite1().setText("Unesite Y koordinatu krajnje tacke:");
				izmena.getTxtX().setText("" + l.getStartPoint().getX());
				izmena.getTxtY().setText("" + l.getStartPoint().getY());
				izmena.getTxtUnos().setText("" + l.getEndPoint().getX());
				izmena.getTxtUnos1().setText("" + l.getEndPoint().getY());
				izmena.getLblIzaberiteBojuUnutrasnjosti().setVisible(false);
				izmena.getBtnBojaUnutrasnjosti().setVisible(false);
				izmena.pack();
				izmena.setVisible(true);
				if (izmena.isOK()) {
					korX = Integer.parseInt(izmena.getTxtX().getText());
					korY = Integer.parseInt(izmena.getTxtY().getText());
					x1 = Integer.parseInt(izmena.getTxtUnos().getText());
					y1 = Integer.parseInt(izmena.getTxtUnos1().getText());
					l = new Line(new Point(korX, korY), new Point(x1, y1));
					l.setColor(izmena.getC());
					panelCrtanje.getShapes().set(panelCrtanje.getShapes().indexOf(selected), l);
				}
			} else if (selected instanceof Rectangle) {
				Rectangle r = (Rectangle) selected;
				DlgIzmena izmena = new DlgIzmena();
				izmena.setTitle("Pravougaonik");
				izmena.getTxtX().setText("" + r.getUpperLeftPoint().getX());
				izmena.getTxtY().setText("" + r.getUpperLeftPoint().getY());
				izmena.getTxtUnos().setText("" + r.getHeight());
				izmena.getTxtUnos1().setText("" + r.getWidth());
				izmena.pack();
				izmena.setVisible(true);
				if (izmena.isOK()) {
					korX = Integer.parseInt(izmena.getTxtX().getText());
					korY = Integer.parseInt(izmena.getTxtY().getText());
					x1 = Integer.parseInt(izmena.getTxtUnos().getText());
					y1 = Integer.parseInt(izmena.getTxtUnos1().getText());
					r = new Rectangle(new Point(korX, korY), x1, y1);
					r.setColor(izmena.getC());
					r.setColorUnutrasnjost(izmena.getColorUnutrasnjost());
					panelCrtanje.getShapes().set(panelCrtanje.getShapes().indexOf(selected), r);
				}
			} else if (selected instanceof Donut) {
				Donut d = (Donut) selected;
				DlgIzmena izmena = new DlgIzmena();
				izmena.getLblUnesite().setText("Unesite poluprecnik spoljasnjeg kruga:");
				izmena.getLblUnesite1().setText("Unesite poluprecnik unutrasnjeg kruga:");
				izmena.setTitle("Krug sa rupom");
				izmena.getLblIzaberiteBoju().setText("Izaberite boju ivica spoljasnjeg kruga:");
				izmena.getLblIzaberiteBojuUnutrasnjosti().setText("Izaberite boju spoljasnjeg kruga:");
				izmena.getLblIzaberiteBojuIvice().setVisible(true);
				izmena.getLblIzaberiteBojuUnutrasnjeg().setVisible(true);
				izmena.getBtnBojaIviceUnutrasnjegKruga().setVisible(true);
				izmena.getBtnBojaUnutrasnjegKruga().setVisible(true);
				izmena.getTxtX().setText("" + d.getCenter().getX());
				izmena.getTxtY().setText("" + d.getCenter().getY());
				izmena.getTxtUnos().setText("" + d.getRadius());
				izmena.getTxtUnos1().setText("" + d.getInnerRadius());
				izmena.pack();
				izmena.setVisible(true);
				if (izmena.isOK()) {
					korX = Integer.parseInt(izmena.getTxtX().getText());
					korY = Integer.parseInt(izmena.getTxtY().getText());
					x1 = Integer.parseInt(izmena.getTxtUnos().getText());
					y1 = Integer.parseInt(izmena.getTxtUnos1().getText());
					d = new Donut(new Point(korX, korY), x1, y1);
					d.setColor(izmena.getC());
					d.setColorIviceMali(izmena.getColorIviceUnutrasnjiKrug());
					d.setColorUnutrasnostMali(izmena.getColorUnutrasnjiKrugBoja());
					d.setColorUnutrasnjostVeliki(izmena.getColorUnutrasnjost());
					panelCrtanje.getShapes().set(panelCrtanje.getShapes().indexOf(selected), d);
				}
			} else if (selected instanceof Circle) {
				Circle c = (Circle) selected;
				DlgIzmenaKrug izmena = new DlgIzmenaKrug();
				izmena.getTxtX().setText("" + c.getCenter().getX());
				izmena.getTxtY().setText("" + c.getCenter().getY());
				izmena.getTxtPoluprecnik().setText("" + c.getRadius());
				izmena.pack();
				izmena.setVisible(true);
				if (izmena.isOK()) {
					korX = Integer.parseInt(izmena.getTxtX().getText());
					korY = Integer.parseInt(izmena.getTxtY().getText());
					x1 = Integer.parseInt(izmena.getTxtPoluprecnik().getText());
					c = new Circle(new Point(korX, korY), x1);
					c.setColor(izmena.getC());
					c.setColorUnutrasnjost(izmena.getColorUnutrasnjost());
					panelCrtanje.getShapes().set(panelCrtanje.getShapes().indexOf(selected), c);
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Niste izabrali ni jedan objekat!","Greska", JOptionPane.WARNING_MESSAGE);
		}
		panelCrtanje.repaint();
		panelCrtanje.setSelected(null);
		buttonGroup.clearSelection();
	}
}
