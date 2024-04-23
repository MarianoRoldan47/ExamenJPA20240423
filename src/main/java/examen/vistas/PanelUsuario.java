package examen.vistas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import examen.controllers.ControladorUsuario;
import examen.models.Usuario;
import examen.utils.UtilsBBDD;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfUsuario;
	private JPasswordField jpfContrasena;
	private JTextField jtfEmail;
	JComboBox<String> jcbColorPreferido;
	Usuario usuario;

	/**
	 * Create the panel.
	 */
	public PanelUsuario(Usuario u) {
		usuario = u;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Gestión de usuarios");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id: ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 2;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario: ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfUsuario = new JTextField();
		GridBagConstraints gbc_jtfUsuario = new GridBagConstraints();
		gbc_jtfUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_jtfUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfUsuario.gridx = 1;
		gbc_jtfUsuario.gridy = 3;
		add(jtfUsuario, gbc_jtfUsuario);
		jtfUsuario.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Contraseña: ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jpfContrasena = new JPasswordField();
		GridBagConstraints gbc_jpfContrasena = new GridBagConstraints();
		gbc_jpfContrasena.insets = new Insets(0, 0, 5, 0);
		gbc_jpfContrasena.fill = GridBagConstraints.HORIZONTAL;
		gbc_jpfContrasena.gridx = 1;
		gbc_jpfContrasena.gridy = 4;
		add(jpfContrasena, gbc_jpfContrasena);
		
		JLabel lblNewLabel_4 = new JLabel("Email: ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 5;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Color preferido: ");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jcbColorPreferido = new JComboBox<String>();
		jcbColorPreferido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBackground(Color.decode(jcbColorPreferido.getSelectedItem().toString()));
			}
		});
		GridBagConstraints gbc_jcbColorPreferido = new GridBagConstraints();
		gbc_jcbColorPreferido.insets = new Insets(0, 0, 5, 0);
		gbc_jcbColorPreferido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbColorPreferido.gridx = 1;
		gbc_jcbColorPreferido.gridy = 6;
		add(jcbColorPreferido, gbc_jcbColorPreferido);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 8;
		add(btnNewButton, gbc_btnNewButton);
		
		cargarColores();
		
		mostrarEntidad(usuario);

	}
	
	private void cargarColores() {
		jcbColorPreferido.removeAllItems();
		jcbColorPreferido.addItem("#FF00FF");
		jcbColorPreferido.addItem("#9890A5");
		jcbColorPreferido.addItem("#765456");
		jcbColorPreferido.addItem("#879876");
	}
	
	public void mostrarEntidad(Usuario u) {
		jtfId.setText("" + u.getId());
		jtfUsuario.setText(u.getNombreUsuario());
		jpfContrasena.setText(u.getPassword());
		jtfEmail.setText(u.getEmail());
		for (int i = 0; i < jcbColorPreferido.getItemCount(); i++) {
			if (jcbColorPreferido.getItemAt(i).toString().equals(u.getColorPreferido())) {
				jcbColorPreferido.setSelectedIndex(i);
				this.setBackground(Color.decode(jcbColorPreferido.getSelectedItem().toString()));
			}
		}
	}
	
	private void guardar() {
		if(!jtfUsuario.getText().trim().equals("")) {
			if(!jpfContrasena.getText().trim().equals("")) {
				if(UtilsBBDD.isValorValidoConMatches(jtfEmail.getText(), ".*[@].*[.].*")) {
					Usuario u = new Usuario(); 
					u.setId(Integer.parseInt(jtfId.getText()));
					u.setNombreUsuario(jtfUsuario.getText());
					u.setPassword(jpfContrasena.getText());
					u.setEmail(jtfEmail.getText());
					u.setColorPreferido(jcbColorPreferido.getSelectedItem().toString());
					
					ControladorUsuario.getInstance().actualizacion(u);
				}
				else {
					JOptionPane.showMessageDialog(null, "El email no tiene el formato correcto");
				}
				
			}
			else {
				JOptionPane.showMessageDialog(null, "La contraseña no puede estar vacia");
			}
			
		}
		else {
			JOptionPane.showMessageDialog(null, "El usuario no puede estar vacio");
		}
	}

}
