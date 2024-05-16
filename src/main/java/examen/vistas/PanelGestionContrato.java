package examen.vistas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.awt.Font;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JSlider;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JToolBar;

import examen.controllers.ControladorContrato;
import examen.controllers.ControladorTipoContrato;
import examen.controllers.ControladorUsuario;
import examen.models.Contrato;
import examen.utils.UtilsBBDD;

import javax.swing.ImageIcon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class PanelGestionContrato extends JPanel {

	private static final long serialVersionUID = 1L;
	private Contrato contrato = null;
	private JFormattedTextField jtfFechaFirma;
	private JSpinner jsLimite;
	private JSlider jsliderSaldo;
	private JTextField jtfDescripcion;
	private JLabel lblNewLabel_1;
	private JTextField jtfTipoContrato;
	private JButton jbtnTipoContrato;
	private JTextField jtfUsuario;
	
	private static PanelGestionContrato instance = null;
	
	public static PanelGestionContrato getInstance() {
		if(instance == null) {
			instance = new PanelGestionContrato();
		}
		
		return instance;
	}

	/**
	 * Create the panel.
	 */
	public PanelGestionContrato() {
		setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);

		JButton jbtnPrimero = new JButton("");
		jbtnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPrimero();
			}
		});
		jbtnPrimero.setIcon(new ImageIcon(PanelGestionContrato.class.getResource("/res/gotostart.png")));
		toolBar.add(jbtnPrimero);

		JButton jbtnAnterior = new JButton("");
		jbtnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarAnterior(contrato);
			}
		});
		jbtnAnterior.setIcon(new ImageIcon(PanelGestionContrato.class.getResource("/res/previous.png")));
		toolBar.add(jbtnAnterior);

		JButton jbtnSiguiente = new JButton("");
		jbtnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSiguiente(contrato);

			}
		});
		jbtnSiguiente.setIcon(new ImageIcon(PanelGestionContrato.class.getResource("/res/next.png")));
		toolBar.add(jbtnSiguiente);

		JButton jbtnUltimo = new JButton("");
		jbtnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarUltimo();
			}
		});
		jbtnUltimo.setIcon(new ImageIcon(PanelGestionContrato.class.getResource("/res/gotoend.png")));
		toolBar.add(jbtnUltimo);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 103, 86, 64, 51, 149, 0 };
		gridBagLayout.rowHeights = new int[] { 51, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel.setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Gestión de contratos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 7;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_7 = new JLabel("Fecha de firma: ");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 2;
		panel.add(lblNewLabel_7, gbc_lblNewLabel_7);

		jtfFechaFirma = getJFormattedTextFieldDatePersonalizado();
		GridBagConstraints gbc_jtfFechaFirma = new GridBagConstraints();
		gbc_jtfFechaFirma.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFechaFirma.gridwidth = 6;
		gbc_jtfFechaFirma.insets = new Insets(0, 0, 5, 5);
		gbc_jtfFechaFirma.gridx = 1;
		gbc_jtfFechaFirma.gridy = 2;
		panel.add(jtfFechaFirma, gbc_jtfFechaFirma);

		JLabel lblNewLabel_6 = new JLabel("Limite (€): ");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 3;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);

		jsLimite = new JSpinner();
		jsLimite.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				jsliderSaldo.setMaximum((int) jsLimite.getValue());
				jsliderSaldo.revalidate();
				jsliderSaldo.repaint();
			}
		});
		jsLimite.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				jsliderSaldo.setMaximum((int) jsLimite.getValue());
				jsliderSaldo.revalidate();
				jsliderSaldo.repaint();
			}
		});
		GridBagConstraints gbc_jsLimite = new GridBagConstraints();
		gbc_jsLimite.fill = GridBagConstraints.HORIZONTAL;
		gbc_jsLimite.insets = new Insets(0, 0, 5, 5);
		gbc_jsLimite.gridx = 1;
		gbc_jsLimite.gridy = 3;
		panel.add(jsLimite, gbc_jsLimite);

		JLabel lblNewLabel_5 = new JLabel("Saldo (€): ");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 4;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);

		jsliderSaldo = new JSlider();
		GridBagConstraints gbc_jsliderSaldo = new GridBagConstraints();
		gbc_jsliderSaldo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jsliderSaldo.gridwidth = 6;
		gbc_jsliderSaldo.insets = new Insets(0, 0, 5, 5);
		gbc_jsliderSaldo.gridx = 1;
		gbc_jsliderSaldo.gridy = 4;
		panel.add(jsliderSaldo, gbc_jsliderSaldo);

		JLabel lblNewLabel_3 = new JLabel("Descripcion: ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 5;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtfDescripcion = new JTextField();
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.gridwidth = 6;
		gbc_jtfDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.gridx = 1;
		gbc_jtfDescripcion.gridy = 5;
		panel.add(jtfDescripcion, gbc_jtfDescripcion);
		jtfDescripcion.setColumns(10);

		lblNewLabel_1 = new JLabel("Tipo Contrato: ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 6;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfTipoContrato = new JTextField();
		jtfTipoContrato.setEditable(false);
		GridBagConstraints gbc_jtfTipoContrato = new GridBagConstraints();
		gbc_jtfTipoContrato.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTipoContrato.gridwidth = 3;
		gbc_jtfTipoContrato.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTipoContrato.gridx = 1;
		gbc_jtfTipoContrato.gridy = 6;
		panel.add(jtfTipoContrato, gbc_jtfTipoContrato);
		jtfTipoContrato.setColumns(10);

		jbtnTipoContrato = new JButton("Gestion tipo contrato");
		GridBagConstraints gbc_jbtnTipoContrato = new GridBagConstraints();
		gbc_jbtnTipoContrato.gridwidth = 3;
		gbc_jbtnTipoContrato.insets = new Insets(0, 0, 5, 5);
		gbc_jbtnTipoContrato.gridx = 4;
		gbc_jbtnTipoContrato.gridy = 6;
		panel.add(jbtnTipoContrato, gbc_jbtnTipoContrato);

		JLabel lblNewLabel_4 = new JLabel("Usuario: ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 7;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);

		JButton btnNewButton = new JButton("Gestionar Usuario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JDialog dialogo = UtilsBBDD.crearJDialog(
						new PanelUsuario(contrato),
						"Gestion Usuario");
				dialogo.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						mostrarEntidad(contrato);
					}

				});
			}
		});

		jtfUsuario = new JTextField();
		jtfUsuario.setEditable(false);
		GridBagConstraints gbc_jtfUsuario = new GridBagConstraints();
		gbc_jtfUsuario.gridwidth = 3;
		gbc_jtfUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_jtfUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfUsuario.gridx = 1;
		gbc_jtfUsuario.gridy = 7;
		panel.add(jtfUsuario, gbc_jtfUsuario);
		jtfUsuario.setColumns(10);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 7;
		panel.add(btnNewButton, gbc_btnNewButton);

		JButton btnNewButton_1 = new JButton("Guardar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				guardar();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridwidth = 7;
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 9;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);

		mostrarPrimero();
	}

	@SuppressWarnings("serial")
	private JFormattedTextField getJFormattedTextFieldDatePersonalizado() {
		JFormattedTextField jtfFecha = new JFormattedTextField(new JFormattedTextField.AbstractFormatter() {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			@Override
			public String valueToString(Object value) throws ParseException {
				if (value != null && value instanceof Date) {
					return sdf.format(((Date) value));
				}
				return "";
			}

			@Override
			public Object stringToValue(String text) throws ParseException {
				try {
					jtfFechaFirma.setBackground(Color.WHITE);
					return sdf.parse(text);

				} catch (Exception e) {
					jtfFechaFirma.setBackground(Color.RED);
					return null;
				}
			}
		});
		jtfFecha.setValue(new Date());
		return jtfFecha;
	}

	private void mostrarPrimero() {
		Contrato cont = (Contrato) ControladorContrato.getInstance().findPrimero();
		if (cont != null) {
			contrato = cont;
		}
		mostrarEntidad(contrato);
	}

	private void mostrarAnterior(Contrato c) {
		if (c != null) {
			Contrato cont = (Contrato) ControladorContrato.getInstance().findAnterior(c.getId());
			if (cont != null) {
				contrato = cont;
			}

			mostrarEntidad(contrato);
		}
	}

	private void mostrarSiguiente(Contrato c) {
		if (c != null) {

			Contrato cont = (Contrato) ControladorContrato.getInstance().findSiguiente(c.getId());
			if (cont != null) {
				contrato = cont;
			}
			mostrarEntidad(contrato);
		}
	}

	private void mostrarUltimo() {
		Contrato cont = (Contrato) ControladorContrato.getInstance().findUltimo();
		if (cont != null) {
			contrato = cont;
		}
		mostrarEntidad(contrato);
	}

	public void mostrarEntidad(Contrato c) {
		if (c != null) {
			jtfDescripcion.setText(c.getDescripcion());
			jsLimite.setValue((int) c.getLimite());

			jsliderSaldo.setMaximum((int) c.getLimite());
			jsliderSaldo.setValue((int) c.getSaldo());

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			String strFecha = "";

			Date fecha = c.getFechaFirma();
			try {
				strFecha = sdf.format(fecha);
			} catch (Exception ex) {
			}

			jtfFechaFirma.setText(strFecha);

			jtfTipoContrato.setText(ControladorTipoContrato.getInstance().find(c.getIdTipoContrato().getId()).toString());
			
			int idUsuario = c.getIdUsuario().getId();
			
			c.setIdUsuario(ControladorUsuario.getInstance().find(idUsuario));
			
			jtfUsuario.setText("");
			
			jtfUsuario.setText(c.getIdUsuario().toString());
			
			
			System.out.println(c.getId() + " " + c.getDescripcion() + " " + c.getIdUsuario().toString());
			
			revalidate();
			repaint();

		}

	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
	
	

}
