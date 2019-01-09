package drawing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmAppDrawing extends JFrame {

	private JPanel contentPane;

	private final ButtonGroup buttonGroup = new ButtonGroup();
	
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
	public FrmAppDrawing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlDugmici = new JPanel();
		contentPane.add(pnlDugmici, BorderLayout.NORTH);
		
		JToggleButton tglbtnTacka = new JToggleButton("Tacka");
		tglbtnTacka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				//Graphics g = getGraphics();
				//PnlDrawing crtaj = new PnlDrawing();
				//crtaj.paint(g);
				//Point p = new Point(mouse)
			}
		});
		buttonGroup.add(tglbtnTacka);
		pnlDugmici.add(tglbtnTacka);
		
		JToggleButton tglbtnLinija = new JToggleButton("Linija");
		buttonGroup.add(tglbtnLinija);
		pnlDugmici.add(tglbtnLinija);
		
		JToggleButton tglbtnPravougaonik = new JToggleButton("Pravougaonik");
		buttonGroup.add(tglbtnPravougaonik);
		pnlDugmici.add(tglbtnPravougaonik);
		
		JToggleButton tglbtnKrug = new JToggleButton("Krug");
		buttonGroup.add(tglbtnKrug);
		pnlDugmici.add(tglbtnKrug);
		
		JToggleButton tglbtnKrugSaRupom = new JToggleButton("Krug sa rupom");
		buttonGroup.add(tglbtnKrugSaRupom);
		pnlDugmici.add(tglbtnKrugSaRupom);
		
		JPanel pnlCrtanje = new JPanel();
		pnlCrtanje.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int x = e.getX();
				 int y = e.getY();
				
				if(tglbtnTacka.isSelected()) {
					Graphics g = getGraphics();
					PnlDrawing crtaj = new PnlDrawing();
					crtaj.paint(g,x,y);
				}
			}
		});
		contentPane.add(pnlCrtanje, BorderLayout.CENTER);
		
		JPanel pnlModifikacija = new JPanel();
		contentPane.add(pnlModifikacija, BorderLayout.SOUTH);
		
		JButton btnSelektuj = new JButton("Selektuj");
		pnlModifikacija.add(btnSelektuj);
		
		JButton btnModifikuj = new JButton("Modifikuj");
		pnlModifikacija.add(btnModifikuj);
		
		JButton btnObrisi = new JButton("Obrisi");
		pnlModifikacija.add(btnObrisi);
	}

}
