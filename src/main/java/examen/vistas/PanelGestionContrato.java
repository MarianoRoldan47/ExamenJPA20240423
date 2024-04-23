package examen.vistas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.Font;
import javax.swing.JTextField;

import examen.controllers.ControladorContrato;
import examen.controllers.ControladorTipoContrato;
import examen.controllers.ControladorUsuario;
import examen.models.Contrato;
import examen.models.Usuario;
import examen.utils.UtilsBBDD;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class PanelGestionContrato extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfDescripcion;
	private JTextField jtfSaldo;
	private JTextField jtfLimite;
	private JTextField jtfFechaFirma;
	private JComboBox<Usuario> jcbUsuarios;
	JRadioButton rdbCuentaBancaria;
	JRadioButton rdbTarjetaCredito;
	JRadioButton rdbTarjetaDebito;
	JRadioButton rdbPrestamo;
	

	/**
	 * Create the panel.
	 */
	public PanelGestionContrato() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Gestión de contratos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 5;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.gridwidth = 4;
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		rdbCuentaBancaria = new JRadioButton("Cuenta Bancaria");
		GridBagConstraints gbc_rdbCuentaBancaria = new GridBagConstraints();
		gbc_rdbCuentaBancaria.anchor = GridBagConstraints.WEST;
		gbc_rdbCuentaBancaria.insets = new Insets(0, 0, 5, 5);
		gbc_rdbCuentaBancaria.gridx = 1;
		gbc_rdbCuentaBancaria.gridy = 2;
		add(rdbCuentaBancaria, gbc_rdbCuentaBancaria);
		
		rdbTarjetaCredito = new JRadioButton("Tarjeta crédito");
		GridBagConstraints gbc_rdbTarjetaCredito = new GridBagConstraints();
		gbc_rdbTarjetaCredito.anchor = GridBagConstraints.WEST;
		gbc_rdbTarjetaCredito.insets = new Insets(0, 0, 5, 5);
		gbc_rdbTarjetaCredito.gridx = 3;
		gbc_rdbTarjetaCredito.gridy = 2;
		add(rdbTarjetaCredito, gbc_rdbTarjetaCredito);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo de contrato: ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		rdbTarjetaDebito = new JRadioButton("Tarjeta débito");
		GridBagConstraints gbc_rdbTarjetaDebito = new GridBagConstraints();
		gbc_rdbTarjetaDebito.anchor = GridBagConstraints.WEST;
		gbc_rdbTarjetaDebito.insets = new Insets(0, 0, 5, 5);
		gbc_rdbTarjetaDebito.gridx = 1;
		gbc_rdbTarjetaDebito.gridy = 3;
		add(rdbTarjetaDebito, gbc_rdbTarjetaDebito);
		
		rdbPrestamo = new JRadioButton("Préstamo");
		GridBagConstraints gbc_rdbPrestamo = new GridBagConstraints();
		gbc_rdbPrestamo.anchor = GridBagConstraints.WEST;
		gbc_rdbPrestamo.insets = new Insets(0, 0, 5, 5);
		gbc_rdbPrestamo.gridx = 3;
		gbc_rdbPrestamo.gridy = 3;
		add(rdbPrestamo, gbc_rdbPrestamo);
		
		JLabel lblNewLabel_3 = new JLabel("Descripcion: ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 5;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfDescripcion = new JTextField();
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.gridwidth = 4;
		gbc_jtfDescripcion.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.gridx = 1;
		gbc_jtfDescripcion.gridy = 5;
		add(jtfDescripcion, gbc_jtfDescripcion);
		jtfDescripcion.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Usuario: ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 6;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jcbUsuarios = new JComboBox<Usuario>();
		GridBagConstraints gbc_jcbUsuarios = new GridBagConstraints();
		gbc_jcbUsuarios.gridwidth = 3;
		gbc_jcbUsuarios.insets = new Insets(0, 0, 5, 5);
		gbc_jcbUsuarios.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbUsuarios.gridx = 1;
		gbc_jcbUsuarios.gridy = 6;
		add(jcbUsuarios, gbc_jcbUsuarios);
		
		JButton btnNewButton = new JButton("Gestionar Usuario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JDialog dialogo = UtilsBBDD.crearJDialog(new PanelUsuario(ControladorUsuario.getInstance().find(((Usuario) jcbUsuarios.getSelectedItem()).getId())), "Gestion Usuario");
				dialogo.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						cargarUsuarios();
						mostrarEntidad(ControladorContrato.getInstance().find(Integer.parseInt(jtfId.getText())));
						
						
						
					}
					
				});
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 6;
		add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Saldo (€): ");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 7;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfSaldo = new JTextField();
		GridBagConstraints gbc_jtfSaldo = new GridBagConstraints();
		gbc_jtfSaldo.gridwidth = 4;
		gbc_jtfSaldo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfSaldo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSaldo.gridx = 1;
		gbc_jtfSaldo.gridy = 7;
		add(jtfSaldo, gbc_jtfSaldo);
		jtfSaldo.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Limite (€): ");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 8;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jtfLimite = new JTextField();
		GridBagConstraints gbc_jtfLimite = new GridBagConstraints();
		gbc_jtfLimite.gridwidth = 4;
		gbc_jtfLimite.insets = new Insets(0, 0, 5, 0);
		gbc_jtfLimite.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLimite.gridx = 1;
		gbc_jtfLimite.gridy = 8;
		add(jtfLimite, gbc_jtfLimite);
		jtfLimite.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Fecha de firma: ");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 9;
		add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		jtfFechaFirma = new JTextField();
		GridBagConstraints gbc_jtfFechaFirma = new GridBagConstraints();
		gbc_jtfFechaFirma.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFechaFirma.gridwidth = 4;
		gbc_jtfFechaFirma.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFechaFirma.gridx = 1;
		gbc_jtfFechaFirma.gridy = 9;
		add(jtfFechaFirma, gbc_jtfFechaFirma);
		jtfFechaFirma.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Guardar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridwidth = 5;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 10;
		add(btnNewButton_1, gbc_btnNewButton_1);
		
		cargarUsuarios();
		
		ButtonGroup btnG = new ButtonGroup();
		btnG.add(rdbTarjetaDebito);
		btnG.add(rdbTarjetaCredito);
		btnG.add(rdbPrestamo);
		btnG.add(rdbCuentaBancaria);
		
	}
	
	private void guardar() {
		if (jtfDescripcion.getText().length() >= 4) {
			if (UtilsBBDD.isFloat(jtfSaldo.getText())) {
				if(UtilsBBDD.isFloat(jtfLimite.getText())) {
					Contrato c = new Contrato();
					c.setId(Integer.parseInt(jtfId.getText()));
					if(rdbCuentaBancaria.isSelected()) {
						c.setIdTipoContrato(ControladorTipoContrato.getInstance().find(1));
						
					}
					if(rdbTarjetaDebito.isSelected()) {
						c.setIdTipoContrato(ControladorTipoContrato.getInstance().find(2));
						
					}
					if(rdbTarjetaCredito.isSelected()) {
						c.setIdTipoContrato(ControladorTipoContrato.getInstance().find(3));
						
					}
					if(rdbPrestamo.isSelected()) {
						c.setIdTipoContrato(ControladorTipoContrato.getInstance().find(4));
						
					}
					
					
					c.setDescripcion(jtfDescripcion.getText());
					c.setIdUsuario(ControladorUsuario.getInstance().find(((Usuario)jcbUsuarios.getSelectedItem()).getId()));
					c.setSaldo(Float.parseFloat(jtfSaldo.getText()));
					c.setLimite(Float.parseFloat(jtfLimite.getText()));
					
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					
					String strFecha = jtfFechaFirma.getText();

					Date fecha = null;
					try {
						fecha = sdf.parse(strFecha);
						c.setFechaFirma(fecha);
						
						
					} catch (Exception ex) {
					}
					
					ControladorContrato.getInstance().actualizacion(c);
					
				}
			}
		}
		
		
		
	}
	
	@SuppressWarnings("unchecked")
	private void cargarUsuarios() {
		List<Usuario> usuarios = (List<Usuario>) ControladorUsuario.getInstance().findAll();
		
		jcbUsuarios.removeAllItems();
		
		for (Usuario usuario : usuarios) {
			jcbUsuarios.addItem(usuario);
		}
		
		
		
		
	}
	
	
	public void mostrarEntidad(Contrato c) {
		if (c != null) {
			jtfId.setText("" + c.getId());
			jtfDescripcion.setText(c.getDescripcion());
			jtfSaldo.setText("" + c.getSaldo());
			jtfLimite.setText("" + c.getLimite());
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			String strFecha = "";

			Date fecha = c.getFechaFirma();
			try {
				strFecha = sdf.format(fecha);
			} catch (Exception ex) {
			}
			
			jtfFechaFirma.setText(strFecha);
			
			
			if(c.getIdTipoContrato().getId() == 1) {
				rdbCuentaBancaria.setSelected(true);
			}
			if(c.getIdTipoContrato().getId() == 2) {
				rdbTarjetaDebito.setSelected(true);
			}
			if(c.getIdTipoContrato().getId() == 3) {
				rdbTarjetaCredito.setSelected(true);
			}
			if(c.getIdTipoContrato().getId() == 4) {
				rdbPrestamo.setSelected(true);
			}
			
			
			for (int i = 0; i < jcbUsuarios.getItemCount(); i++) {
				if (jcbUsuarios.getItemAt(i).getId() == c.getIdUsuario().getId()) {
					jcbUsuarios.setSelectedIndex(i);
				}
			}
			
			
			
		}
		
	}

}
