package examen.vistas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import examen.controllers.ControladorUsuario;
import examen.models.Contrato;
import examen.models.Usuario;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class PanelUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	Usuario usuario;
	private JTextField jtfBusqueda;
	private JList<Usuario> jlist;
	private DefaultListModel<Usuario> listaUsuarios;
	private ButtonGroup grupoOpciones = new ButtonGroup();
	private JCheckBox jchkCaseSensitive;
	private JRadioButton jrbNieDni;
	private JRadioButton jrbNombre;
	private JRadioButton jrbEmail;
	private Contrato actual;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("unchecked")
	public PanelUsuario(Contrato c) {
		this.actual = c;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 75, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 137, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Gestión de usuarios");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

		JButton jbtnOk = new JButton("OK");
		jbtnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usoBtnOk();
			}
		});

		JLabel lblNewLabel_1 = new JLabel("Busqueda: ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.BELOW_BASELINE_TRAILING;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfBusqueda = new JTextField();
		GridBagConstraints gbc_jtfBusqueda = new GridBagConstraints();
		gbc_jtfBusqueda.insets = new Insets(0, 0, 5, 0);
		gbc_jtfBusqueda.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfBusqueda.gridx = 1;
		gbc_jtfBusqueda.gridy = 2;
		add(jtfBusqueda, gbc_jtfBusqueda);
		jtfBusqueda.setColumns(10);

		jrbEmail = new JRadioButton("Email");
		GridBagConstraints gbc_jrbEmail = new GridBagConstraints();
		gbc_jrbEmail.anchor = GridBagConstraints.WEST;
		gbc_jrbEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jrbEmail.gridx = 1;
		gbc_jrbEmail.gridy = 3;
		add(jrbEmail, gbc_jrbEmail);

		jrbNombre = new JRadioButton("Nombre");
		GridBagConstraints gbc_jrbNombre = new GridBagConstraints();
		gbc_jrbNombre.anchor = GridBagConstraints.WEST;
		gbc_jrbNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jrbNombre.gridx = 1;
		gbc_jrbNombre.gridy = 4;
		add(jrbNombre, gbc_jrbNombre);

		jrbNieDni = new JRadioButton("NIE / DNI");
		GridBagConstraints gbc_jrbNieDni = new GridBagConstraints();
		gbc_jrbNieDni.anchor = GridBagConstraints.WEST;
		gbc_jrbNieDni.insets = new Insets(0, 0, 5, 0);
		gbc_jrbNieDni.gridx = 1;
		gbc_jrbNieDni.gridy = 5;
		add(jrbNieDni, gbc_jrbNieDni);

		jchkCaseSensitive = new JCheckBox("Case-sensitive");
		GridBagConstraints gbc_jchkCaseSensitive = new GridBagConstraints();
		gbc_jchkCaseSensitive.anchor = GridBagConstraints.WEST;
		gbc_jchkCaseSensitive.insets = new Insets(0, 0, 5, 0);
		gbc_jchkCaseSensitive.gridx = 1;
		gbc_jchkCaseSensitive.gridy = 6;
		add(jchkCaseSensitive, gbc_jchkCaseSensitive);

		JButton jbtnBuscar = new JButton("Buscar");
		jbtnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarUsuarios();
			}
		});
		GridBagConstraints gbc_jbtnBuscar = new GridBagConstraints();
		gbc_jbtnBuscar.gridwidth = 2;
		gbc_jbtnBuscar.insets = new Insets(0, 0, 5, 0);
		gbc_jbtnBuscar.gridx = 0;
		gbc_jbtnBuscar.gridy = 7;
		add(jbtnBuscar, gbc_jbtnBuscar);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 8;
		add(scrollPane, gbc_scrollPane);

		jlist = new JList<Usuario>(this.getDefaultListModelUsuarios());
		scrollPane.setViewportView(jlist);
		GridBagConstraints gbc_jbtnOk = new GridBagConstraints();
		gbc_jbtnOk.gridwidth = 2;
		gbc_jbtnOk.gridx = 0;
		gbc_jbtnOk.gridy = 9;
		add(jbtnOk, gbc_jbtnOk);

		grupoOpciones.add(jrbEmail);
		grupoOpciones.add(jrbNombre);
		grupoOpciones.add(jrbNieDni);
		
		

	}
	
	@SuppressWarnings("rawtypes")
	private DefaultListModel getDefaultListModelUsuarios() {
		this.listaUsuarios = new DefaultListModel<Usuario>();
		return this.listaUsuarios;
	}

	@SuppressWarnings("unchecked")
	private void cargarUsuarios() {
		List<Usuario> usuarios = (List<Usuario>) ControladorUsuario.getInstance().findAll();
		listaUsuarios.removeAllElements();
		for (Usuario usuario : usuarios) {
			if (jrbNombre.isSelected()) {
				if (usuario.getNombreUsuario().contains(jtfBusqueda.getText())) {
					listaUsuarios.addElement(usuario);
				}
			}

			if (jrbEmail.isSelected()) {
				if (usuario.getEmail().contains(jtfBusqueda.getText())) {
					listaUsuarios.addElement(usuario);
				}
			}
		}
	}
	
	private void usoBtnOk() {
		actual.setIdUsuario(jlist.getSelectedValue());
		PanelGestionContrato.getInstance().setContrato(actual);
		PanelGestionContrato.getInstance().mostrarEntidad(actual);
		
	}

}
