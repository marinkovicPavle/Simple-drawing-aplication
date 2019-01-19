package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalityType;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DlgUnos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUnos;
	private JTextField txtUnos1;
	private JLabel lblUnesite;
	private JLabel lblUnesite1;
	
	private boolean isOK;
	private JLabel lblIzaberiteBoju;
	private JButton btnBoja;
	
	private Color c;
	private Color colorUnutrasnjost;
	private Color colorIviceUnutrasnjiKrug;
	private Color colorUnutrasnjiKrugBoja;
	
	private JLabel lblIzaberiteBojuUnutrasnjosti;
	private JButton btnBojaUnutrasnj;
	private JLabel lblIzaberiteBojuIvice;
	private JLabel lblIzaberiteBojuUnutrasnjeg;
	private JButton btnBojaIviceUnutrasnji;
	private JButton btnBojaUnutrasnjiKrug;
	
	
	
	public Color getColorIviceUnutrasnjiKrug() {
		return colorIviceUnutrasnjiKrug;
	}

	public void setColorIviceUnutrasnjiKrug(Color colorIviceUnutrasnjiKrug) {
		this.colorIviceUnutrasnjiKrug = colorIviceUnutrasnjiKrug;
	}

	public Color getColorUnutrasnjiKrugBoja() {
		return colorUnutrasnjiKrugBoja;
	}

	public void setColorUnutrasnjiKrugBoja(Color colorUnutrasnjiKrugBoja) {
		this.colorUnutrasnjiKrugBoja = colorUnutrasnjiKrugBoja;
	}

	public Color getColorUnutrasnjost() {
		return colorUnutrasnjost;
	}

	public void setColorUnutrasnjost(Color colorUnutrasnjost) {
		this.colorUnutrasnjost = colorUnutrasnjost;
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}
	
	public boolean isOK() {
		return isOK;
	}

	public void setOK(boolean isOK) {
		this.isOK = isOK;
	}

	public JTextField getTxtUnos() {
		return txtUnos;
	}

	public void setTxtUnos(JTextField txtUnos) {
		this.txtUnos = txtUnos;
	}

	public JTextField getTxtUnos1() {
		return txtUnos1;
	}

	public void setTxtUnos1(JTextField txtUnos1) {
		this.txtUnos1 = txtUnos1;
	}

	public JLabel getLblUnesite() {
		return lblUnesite;
	}

	public void setLblUnesite(JLabel lblUnesite) {
		this.lblUnesite = lblUnesite;
	}

	public JLabel getLblUnesite1() {
		return lblUnesite1;
	}

	public void setLblUnesite1(JLabel lblUnesite1) {
		this.lblUnesite1 = lblUnesite1;
	}
	
	public JButton getBtnBojaUnutrasnjiKrug() {
		return btnBojaUnutrasnjiKrug;
	}

	public void setBtnBojaUnutrasnjiKrug(JButton btnBojaUnutrasnjiKrug) {
		this.btnBojaUnutrasnjiKrug = btnBojaUnutrasnjiKrug;
	}

	public JLabel getLblIzaberiteBojuUnutrasnjeg() {
		return lblIzaberiteBojuUnutrasnjeg;
	}

	public void setLblIzaberiteBojuUnutrasnjeg(JLabel lblIzaberiteBojuUnutrasnjeg) {
		this.lblIzaberiteBojuUnutrasnjeg = lblIzaberiteBojuUnutrasnjeg;
	}

	public JButton getBtnBojaIviceUnutrasnji() {
		return btnBojaIviceUnutrasnji;
	}

	public void setBtnBojaIviceUnutrasnji(JButton btnBojaIviceUnutrasnji) {
		this.btnBojaIviceUnutrasnji = btnBojaIviceUnutrasnji;
	}

	
	
	public JLabel getLblIzaberiteBoju() {
		return lblIzaberiteBoju;
	}

	public void setLblIzaberiteBoju(JLabel lblIzaberiteBoju) {
		this.lblIzaberiteBoju = lblIzaberiteBoju;
	}

	public JLabel getLblIzaberiteBojuUnutrasnjosti() {
		return lblIzaberiteBojuUnutrasnjosti;
	}

	public void setLblIzaberiteBojuUnutrasnjosti(JLabel lblIzaberiteBojuUnutrasnjosti) {
		this.lblIzaberiteBojuUnutrasnjosti = lblIzaberiteBojuUnutrasnjosti;
	}

	public JLabel getLblIzaberiteBojuIvice() {
		return lblIzaberiteBojuIvice;
	}

	public void setLblIzaberiteBojuIvice(JLabel lblIzaberiteBojuIvice) {
		this.lblIzaberiteBojuIvice = lblIzaberiteBojuIvice;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgUnos dialog = new DlgUnos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgUnos() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 371, 259);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow]", "[][20][25][][25][25]"));
		{
			lblUnesite = new JLabel("Unesite sirinu:");
			contentPanel.add(lblUnesite, "cell 0 0,alignx center");
		}
		{
			txtUnos = new JTextField();
			txtUnos.setTransferHandler(null); //da bismo zabranili pastovanje u textfield, da ne bi korisnik kopirao neki string
			txtUnos.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (!((c >= '0') && (c <= '9') ||
							(c == KeyEvent.VK_BACK_SPACE) ||
							(c == KeyEvent.VK_DELETE))) {
						e.consume();
						getToolkit().beep();
					}
				}
			});
			contentPanel.add(txtUnos, "cell 1 0,growx");
			txtUnos.setColumns(10);
		}
		{
			{
				lblUnesite1 = new JLabel("Unesite visinu:");
				contentPanel.add(lblUnesite1, "cell 0 1,alignx center");
			}
		}
		txtUnos1 = new JTextField();
		txtUnos1.setTransferHandler(null); //da bismo zabranili pastovanje u textfield, da ne bi korisnik kopirao neki string
		txtUnos1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') ||
						(c == KeyEvent.VK_BACK_SPACE) ||
						(c == KeyEvent.VK_DELETE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		contentPanel.add(txtUnos1, "cell 1 1,growx");
		txtUnos1.setColumns(10);
		{
			lblIzaberiteBoju = new JLabel("Izaberite boju ivice:");
			contentPanel.add(lblIzaberiteBoju, "cell 0 2,alignx center");
		}
		{
			btnBoja = new JButton("Boja");
			btnBoja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					c = JColorChooser.showDialog(null, "Izaberite boju", Color.RED);
				}
			});
			contentPanel.add(btnBoja, "cell 1 2,growx");
		}
		{
			lblIzaberiteBojuUnutrasnjosti = new JLabel("Izaberite boju unutrasnjosti:");
			contentPanel.add(lblIzaberiteBojuUnutrasnjosti, "cell 0 3,alignx center");
		}
		{
			btnBojaUnutrasnj = new JButton("Boja");
			btnBojaUnutrasnj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					colorUnutrasnjost = JColorChooser.showDialog(null, "Izaberite boju unutrasnjosti", Color.RED);
				}
			});
			contentPanel.add(btnBojaUnutrasnj, "cell 1 3,growx");
		}
		{
			lblIzaberiteBojuIvice = new JLabel("Izaberite boju ivice unutrasnjeg kruga:");
			lblIzaberiteBojuIvice.setVisible(false);
			contentPanel.add(lblIzaberiteBojuIvice, "cell 0 4");
		}
		{
			btnBojaIviceUnutrasnji = new JButton("Boja");
			btnBojaIviceUnutrasnji.setVisible(false);
			btnBojaIviceUnutrasnji.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					colorIviceUnutrasnjiKrug = JColorChooser.showDialog(null, "Izaberite ivice unutrasnjeg kruga", Color.RED);
				}
			});
			contentPanel.add(btnBojaIviceUnutrasnji, "cell 1 4,growx");
		}
		{
			lblIzaberiteBojuUnutrasnjeg = new JLabel("Izaberite boju unutrasnjeg kruga:");
			lblIzaberiteBojuUnutrasnjeg.setVisible(false);
			contentPanel.add(lblIzaberiteBojuUnutrasnjeg, "cell 0 5");
		}
		{
			btnBojaUnutrasnjiKrug = new JButton("Boja");
			btnBojaUnutrasnjiKrug.setVisible(false);
			btnBojaUnutrasnjiKrug.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					colorUnutrasnjiKrugBoja = JColorChooser.showDialog(null, "Izaberite boju unutrasnjeg kruga", Color.RED);
				}
			});
			contentPanel.add(btnBojaUnutrasnjiKrug, "cell 1 5,growx");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (txtUnos.getText().isEmpty() || txtUnos1.getText().isEmpty()) {
							isOK = false;
							setVisible(true);
							JOptionPane.showMessageDialog(null, "Morate popuniti sva polja!","Greska", JOptionPane.WARNING_MESSAGE);
						} else {
							isOK = true;
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
