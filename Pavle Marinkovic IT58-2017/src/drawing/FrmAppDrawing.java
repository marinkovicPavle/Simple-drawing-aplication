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

public class FrmAppDrawing extends JFrame {

	private JPanel contentPane;
	private JToggleButton tglbtnTacka;
	private JToggleButton tglbtnLinija;
	private JToggleButton tglbtnPravougaonik;
	private JToggleButton tglbtnKrug;
	private JToggleButton tglbtnKrugSaRupom;
	
	private JButton btnSelektuj;
	private JButton btnModifikuj;
	private JButton btnObrisi;
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private String oblik;
	
	private int x1,y1;
	private int x,y;
	
	private boolean cekiranTacka,cekiranLinija,cekiranPravougaonik,cekiranKrug,cekiranKrugSaRupom;
	private boolean isKrug; // NE RADI TI ZA KRUG RESI TO!
	
	public ArrayList lista = new ArrayList<>();
	
	private JLabel lblNewLabel_1;
	public JLabel lblNewLabel;
	//
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
	int brojac=0;
	public FrmAppDrawing() {
		setTitle("Crtanje Aplikacija");
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Graphics g =  getGraphics();
				if(tglbtnTacka.isSelected()) {
					x = e.getX();
					y = e.getY();
					oblik="tacka";
					PnlDrawing crtaj = new PnlDrawing(x, y, oblik);
					//crtaj.paint(g,oblik,x,y,0,0);
					crtaj.paint(g);
				} else if(tglbtnLinija.isSelected()) {
					oblik="linija";
					if(brojac==0) {
						x = e.getX();
					 	y = e.getY();
					 	brojac++;
					 } else if(brojac==1) {
						 x1=e.getX();
						 y1=e.getY();
						 PnlDrawing crtaj = new PnlDrawing(x, y, x1, y1, oblik);
						 crtaj.paint(g);
						 //crtaj.paint(g,oblik,x,y,x1,y1);
						 //crtaj.paint(g);
						 brojac=0;
					 }
				} else if(tglbtnPravougaonik.isSelected()) {
					x = e.getX();
					y = e.getY();
					PnlDrawing crtaj = new PnlDrawing(x, y, x1, y1, oblik);
					//crtaj.paint(g,oblik,x,y,x1,y1);
					crtaj.paint(g);
				} else if(tglbtnKrug.isSelected()) {
					x = e.getX();
					y = e.getY();
					PnlDrawing crtaj = new PnlDrawing(x, y, x1, oblik);
					//crtaj.paint(g,oblik,x,y,x1,0);
					crtaj.paint(g);
				} else if(tglbtnKrugSaRupom.isSelected()) {
					x = e.getX();
					y = e.getY();
					PnlDrawing crtaj = new PnlDrawing(x, y, x1, y1, oblik);
					//crtaj.paint(g,oblik,x,y,x1,y1);
					crtaj.paint(g);
				}
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
				if(cekiranTacka == false) {
					cekiranTacka = true;
					cekiranLinija = false;
					cekiranPravougaonik = false;
					cekiranKrug = false;
					cekiranKrugSaRupom = false;
				} else {
					buttonGroup.clearSelection();
					cekiranTacka = false;
				}
			}
		});
		/*tglbtnTacka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				//Graphics g = getGraphics();
				//PnlDrawing crtaj = new PnlDrawing();
				//crtaj.paint(g);
				//Point p = new Point(mouse)
			}
		});*/
		buttonGroup.add(tglbtnTacka);
		pnlDugmici.add(tglbtnTacka);
		
		tglbtnLinija = new JToggleButton("Linija");
		tglbtnLinija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cekiranLinija == false) {
					cekiranLinija = true;
					cekiranTacka = false;
					cekiranPravougaonik = false;
					cekiranKrug = false;
					cekiranKrugSaRupom = false;
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
				if(cekiranPravougaonik == false) {
					cekiranPravougaonik = true;
					cekiranTacka = false;
					cekiranLinija = false;
					cekiranKrug = false;
					cekiranKrugSaRupom = false;
					DlgUnos unos = new DlgUnos();
					unos.pack();
					unos.setTitle("Pravougaonik");
					unos.setVisible(true);
					if(unos.isOK()) {
							oblik="pravougaonik";
							x1=Integer.parseInt(unos.getTxtUnos().getText());
							y1=Integer.parseInt(unos.getTxtUnos1().getText());
						}
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
				if(cekiranKrug==false) {
					cekiranKrug=true;
					cekiranTacka = false;
					cekiranLinija = false;
					cekiranPravougaonik=false;
					cekiranKrugSaRupom=false;
					DlgUnos unos = new DlgUnos();
					unos.getLblUnesite().setText("Unesite poluprecnik:");
					unos.getLblUnesite1().setVisible(false);
					unos.getTxtUnos1().setVisible(false);
					unos.pack(); //da dijalog prilagodimo komponentama
					unos.setTitle("Krug");
					unos.setVisible(true);
					if(unos.isOK()) {
						oblik="krug";
						x1=Integer.parseInt(unos.getTxtUnos().getText());
					}
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
				if(cekiranKrugSaRupom==false) {
					cekiranKrugSaRupom = true;
					cekiranTacka = false;
					cekiranLinija = false;
					cekiranPravougaonik=false;
					cekiranKrug=false;
					DlgUnos unos = new DlgUnos();
					unos.getLblUnesite().setText("Unesite poluprecnik spoljasnjeg kruga:");
					unos.getLblUnesite1().setText("Unesite poluprecnik unutrasnjeg kruga:");
					unos.pack();
					unos.setTitle("Krug sa rupom");
					unos.setVisible(true);
					if(unos.isOK()) {
						oblik="krugsarupom";
						x1=Integer.parseInt(unos.getTxtUnos().getText());
						y1=Integer.parseInt(unos.getTxtUnos1().getText());
					}
				} else {
					buttonGroup.clearSelection();
					cekiranKrugSaRupom = false;
				}
			}
		});
		buttonGroup.add(tglbtnKrugSaRupom);
		pnlDugmici.add(tglbtnKrugSaRupom);
		
		JPanel pnlCrtanje = new JPanel();
		/*pnlCrtanje.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int x = e.getX();
				 int y = e.getY();
				
				 Graphics g =  getGraphics();
				 PnlDrawing crtaj = new PnlDrawing();
				if(tglbtnTacka.isSelected()) {
					//oblik="tacka";
					//crtaj.paint(g,oblik,x,y);
					g.fillOval(e.getX(), e.getY(), 30, 30);
					lblNewLabel.setText("x= "+x+" y= "+y);
				} else if(tglbtnLinija.isSelected()) {
					oblik="linija";
					crtaj.paint(g, oblik, x, y);
				}
			}
		});*/
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
		
		btnSelektuj = new JButton("Selektuj");
		pnlModifikacija.add(btnSelektuj);
		
		btnModifikuj = new JButton("Modifikuj");
		pnlModifikacija.add(btnModifikuj);
		
		btnObrisi = new JButton("Obrisi");
		pnlModifikacija.add(btnObrisi);
	}

}
