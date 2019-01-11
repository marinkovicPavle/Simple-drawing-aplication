package stack;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;
import javax.swing.*;

public class FrmApp extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<Rectangle> dlm = new DefaultListModel<Rectangle>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmApp frame = new FrmApp();
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
	public FrmApp() {
		setTitle("Stack - Marinkovic Pavle IT58/2017");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlSever = new JPanel();
		contentPane.add(pnlSever, BorderLayout.NORTH);
		
		JLabel lblRectangle = new JLabel("Rectangle Stack App");
		pnlSever.add(lblRectangle);
		
		JPanel pnlZapad = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlZapad.getLayout();
		contentPane.add(pnlZapad, BorderLayout.WEST);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgDodaj d = new DlgDodaj();
				d.setVisible(true);
				if(d.isOK()) {
					try {
						Point p = new Point(Integer.parseInt(d.getTxtX().getText()),Integer.parseInt(d.getTxtY().getText()));
						Rectangle r = new Rectangle(p,Integer.parseInt(d.getTxtVisina().getText()),Integer.parseInt(d.getTxtSirina().getText()));
						dlm.add(0,r);
					} catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Unesite iskljucivo brojeve!","Greska", JOptionPane.WARNING_MESSAGE);
					}
				}
				d.getTxtX().setText("");
				d.getTxtY().setText("");
				d.getTxtSirina().setText("");
				d.getTxtVisina().setText("");
			}
		});
		pnlZapad.add(btnDodaj);
		
		JButton btnIzbrisi = new JButton("Izbrisi");
		btnIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgDodaj d = new DlgDodaj();
				try {
				d.getBtnOk().setVisible(true);
				d.getBtnDodaj().setVisible(false);
				d.getBtnOdustani().setVisible(false);
				d.getTxtX().setText(Integer.toString(dlm.get(0).getUpperLeftPoint().getX()));
				d.getTxtY().setText(Integer.toString(dlm.get(0).getUpperLeftPoint().getY()));
				d.getTxtVisina().setText(Integer.toString(dlm.get(0).getHeight()));
				d.getTxtSirina().setText(Integer.toString(dlm.get(0).getWidth()));
				d.setVisible(true);
				dlm.remove(0);
				} catch(ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(null, "Stek je prazan!","Greska", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		pnlZapad.add(btnIzbrisi);
		
		JPanel pnlCentar = new JPanel();
		contentPane.add(pnlCentar, BorderLayout.CENTER);
		pnlCentar.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pnlCentar.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(dlm);
	}
}

