package FramesAlunos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import com.toedter.calendar.JDateChooser;
import Default.FramePrincipal;
import FramesUtilitarios.FrameFileSearch;
import FramesUtilitarios.FrameUtil;
import FramesUtilitarios.FrameWebCam;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.TextArea;
import java.awt.Panel;
import java.awt.BorderLayout;

public class FrameAluno extends JFrame
{
	private static final long serialVersionUID = 1L;
	FrameUtil util = new FrameUtil();
	//------------------------ Componetes do InternalFrame ------------------------//
	public JInternalFrame internalFrameAluno;
	

	public static JButton btnIniciarCam,
	                      btnAdicionarFoto;
	JTextField txtCodAluno,
	          txtNome;
	public static JLabel labelFoto;
	public static byte[] fotoEmByte;

	
	//---------------------------------------------------- ------------------------//
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FrameAluno()
	{
		setSize(700,751);
		setLocation(100,100);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(FrameAluno.DISPOSE_ON_CLOSE);
		
		Font font =new Font("Lucida Console", Font.BOLD,13);
		internalFrameAluno = new JInternalFrame();
		internalFrameAluno.setClosable(true);
		internalFrameAluno.setSize(650,679);
		internalFrameAluno.setLocation(0, 0);
		internalFrameAluno.getContentPane().setBackground(Color.LIGHT_GRAY);
		internalFrameAluno.setVisible(true);
		getContentPane().add(internalFrameAluno);
		
		JTabbedPane jTabbedPane = new JTabbedPane();
		internalFrameAluno.getContentPane().add(jTabbedPane);
			
			JPanel panelPrincipal = new JPanel();
			panelPrincipal.setBackground(Color.LIGHT_GRAY);
			panelPrincipal.setLayout(null);
			jTabbedPane.add("Dados",panelPrincipal);
			
				JPanel panelFotoArea= new JPanel();
				panelFotoArea.setSize(200,250);
				panelFotoArea.setLocation(10,10);
				panelFotoArea.setLayout(null);
				panelFotoArea.setBackground(Color.LIGHT_GRAY);
				panelFotoArea.setBorder(util.criarBorda("Foto", 2, 2, 1));
				panelPrincipal.add(panelFotoArea);
				
					labelFoto = new JLabel();
					labelFoto.setSize(180,190);
					labelFoto.setLocation(10,20);
					labelFoto.setOpaque(true);
					labelFoto.setVisible(true);
					labelFoto.setIcon(util.inputImageIcon("Imagens/imgSemFoto.png", null, 180, 190));
					labelFoto.setBorder(util.criarBorda(null,null,null, 2));
					panelFotoArea.add(labelFoto);
				
						btnIniciarCam = new JButton();
						btnIniciarCam.setToolTipText("Tirar Foto");
						btnIniciarCam.setSize(30,30);
						btnIniciarCam.setLocation(150,213);
						btnIniciarCam.setBackground(Color.CYAN);
						btnIniciarCam.setIcon(new ImageIcon("Imagens/imgTirarFoto.png"));
						panelFotoArea.add(btnIniciarCam);
						btnIniciarCam.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent arg0)
							{
								new Thread()
								{
									public void run()
									{
										new FrameWebCam().setVisible(true);
									}
								}.start();
							}});
						
						btnAdicionarFoto = new JButton();
						btnAdicionarFoto.setToolTipText("Adicionar Foto");
						btnAdicionarFoto.setSize(30,30);
						btnAdicionarFoto.setLocation(20,213);
						btnAdicionarFoto.setBackground(Color.CYAN);
						btnAdicionarFoto.setIcon(util.redimensionarIcon(30, 30,"Imagens/imgAdicionarFoto.png"));
						panelFotoArea.add(btnAdicionarFoto);
						btnAdicionarFoto.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e)
							{
								new FrameFileSearch("aluno").setVisible(true);
							}});
						
						JButton btnRemoverFoto = new JButton();
						btnRemoverFoto.setToolTipText("Remover Foto");
						btnRemoverFoto.setSize(30,30);
						btnRemoverFoto.setLocation(85,213);
						btnRemoverFoto.setBackground(Color.CYAN);
						btnRemoverFoto.setIcon(new ImageIcon("Imagens/imgRemoverFoto.png"));
						panelFotoArea.add(btnRemoverFoto);
						btnRemoverFoto.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent arg0)
							{
								labelFoto.setIcon(util.inputImageIcon("Imagens/imgSemFoto.png", null, 180, 190));
								fotoEmByte=null;
							}});
				//================================================================================================= INFO DE CADASTRO
				JPanel panelInfoCadastro = new JPanel();
				panelInfoCadastro.setSize(370,85);
				panelInfoCadastro.setLocation(235,10);
				panelInfoCadastro.setLayout(null);
				panelInfoCadastro.setBackground(Color.LIGHT_GRAY);
				panelInfoCadastro.setBorder(util.criarBorda("Info Cadastro", 1, 2, 1));
				panelPrincipal.add(panelInfoCadastro);
				
					JLabel lblCodAluno = new JLabel("Código do Aluno:");
					lblCodAluno.setSize(95,15);
					lblCodAluno.setLocation(10,15);
					panelInfoCadastro.add(lblCodAluno);
				
					txtCodAluno = new JTextField();
					txtCodAluno.setSize(100,17);
					txtCodAluno.setLocation(110,15);
					txtCodAluno.setFont(font);
					txtCodAluno.setEditable(false);
					panelInfoCadastro.add(txtCodAluno);
				
					JLabel lblDataDeCadastro = new JLabel("Data De Cadastro:");
					lblDataDeCadastro.setSize(105,15);
					lblDataDeCadastro.setLocation(10,50);
					panelInfoCadastro.add(lblDataDeCadastro);
				
					JFormattedTextField txtDataDeCadastro = new JFormattedTextField();
					txtDataDeCadastro.setSize(110,20);
					txtDataDeCadastro.setLocation(115,50);
					txtDataDeCadastro.setEditable(false);
					txtDataDeCadastro.setFont(new Font("Lucida Console", Font.BOLD, 13));
					Date date = new Date();
					SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/YYYY");
					txtDataDeCadastro.setText(dataFormatada.format(date));
					panelInfoCadastro.add(txtDataDeCadastro);
				
					JLabel lblSituacao = new JLabel("Situação");
					lblSituacao.setSize(70,14);
					lblSituacao.setLocation(290, 15);
					panelInfoCadastro.add(lblSituacao);
				
					ButtonGroup jCheckBoxGroup = new ButtonGroup();
					JCheckBox boxAtivo = new JCheckBox("Ativo");
					boxAtivo.setSize(60,14);
					boxAtivo.setBackground(Color.LIGHT_GRAY);
					boxAtivo.setLocation(290, 35);
					boxAtivo.setSelected(true);
					jCheckBoxGroup.add(boxAtivo);
					panelInfoCadastro.add(boxAtivo);
				
					JCheckBox boxInativo = new JCheckBox("Inativo");
					boxInativo.setSize(70,14);
					boxInativo.setBackground(Color.LIGHT_GRAY);
					boxInativo.setLocation(290, 55);
					jCheckBoxGroup.add(boxInativo);
					panelInfoCadastro.add(boxInativo);
				
				//================================================================================================= DADOS
				JPanel panelDadosPessoais = new JPanel();
				panelDadosPessoais.setSize(370,138);
				panelDadosPessoais.setLocation(235,120);
				panelDadosPessoais.setLayout(null);
				panelDadosPessoais.setBackground(Color.LIGHT_GRAY);
				panelDadosPessoais.setBorder(util.criarBorda("Dados Pessoais", 1, 2, 1));
				panelPrincipal.add(panelDadosPessoais);
				
					JLabel lblNome = new JLabel("Nome:");
					lblNome.setSize(40,20);
					lblNome.setLocation(20,20);
					panelDadosPessoais.add(lblNome);
				
					txtNome = new JTextField();
					txtNome.setSize(300,20);
					txtNome.setLocation(60,21);
					txtNome.setFont(font);
					panelDadosPessoais.add(txtNome);
				
					JLabel lblIdade = new JLabel("Idade:");
					lblIdade.setSize(35,15);
					lblIdade.setLocation(20,50);
					panelDadosPessoais.add(lblIdade);
				
					JSpinner spinIdade = new JSpinner();
					spinIdade.setModel(new SpinnerNumberModel(1,1,null,1));
					spinIdade.setSize(50,20);
					spinIdade.setLocation(60,48);
					panelDadosPessoais.add(spinIdade);
				
					JLabel lblDataNascimento = new JLabel("Data de Nascimento:");
					lblDataNascimento.setSize(120,15);
					lblDataNascimento.setLocation(120,50);
					panelDadosPessoais.add(lblDataNascimento);
				
					JDateChooser dateDeNacimento = new JDateChooser();
					dateDeNacimento.setFont(new Font("Lucida Console", Font.BOLD,13));
					dateDeNacimento.setSize(120,20);
					dateDeNacimento.setLocation(240,48);
					panelDadosPessoais.add(dateDeNacimento);
				
					JLabel lblSexo = new JLabel("Sexo:");
					lblSexo.setSize(35,14);
					lblSexo.setLocation(20, 80);
					panelDadosPessoais.add(lblSexo);
				
					JComboBox<?> boxSexo = new JComboBox();
					boxSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino","..."}));
					boxSexo.setSize(120, 20);
					boxSexo.setLocation(60,78);
					boxSexo.setFont(font);
					panelDadosPessoais.add(boxSexo);
				
					JLabel lblCPF = new JLabel("CPF:");
					lblCPF.setSize(25, 14);
					lblCPF.setLocation(20,110);
					panelDadosPessoais.add(lblCPF);
				
					JFormattedTextField txtCPF = new JFormattedTextField();
					txtCPF.setSize(132,20);
					txtCPF.setLocation(50, 110);
					txtCPF.setFont(font);
					panelDadosPessoais.add(txtCPF);
				
					JLabel lblRG = new JLabel("RG:");
					lblRG.setSize(20, 14);
					lblRG.setLocation(200, 80);
					panelDadosPessoais.add(lblRG);
				
					JFormattedTextField txtRG = new JFormattedTextField();
					txtRG.setSize(132,20);
					txtRG.setLocation(225, 77);
					txtRG.setFont(font);
					panelDadosPessoais.add(txtRG);
				
				//================================================================================================= ENDERECO
				JPanel panelEndereco = new JPanel();
				panelEndereco.setBackground(Color.LIGHT_GRAY);
				panelEndereco.setSize(595,129);
				panelEndereco.setLocation(10,285);
				panelEndereco.setLayout(null);
				panelEndereco.setBorder(util.criarBorda("Endereço", 1, 2, 1));
				panelPrincipal.add(panelEndereco);
					
					JLabel lblEstado = new JLabel("Estado:");
					lblEstado.setSize(45,14);
					lblEstado.setLocation(200,30);
					panelEndereco.add(lblEstado);
					
					JComboBox boxEstado = new JComboBox();
					boxEstado.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", "DF"}));
					boxEstado.setSize(50,20);
					boxEstado.setLocation(245,28);
					boxEstado.setSelectedIndex(23);
					panelEndereco.add(boxEstado);
					
					JLabel lblCidade = new JLabel("Cidade:");
					lblCidade.setSize(45,14);
					lblCidade.setLocation(310,30);
					panelEndereco.add(lblCidade);
					
					JTextField txtCidade = new JTextField();
					txtCidade.setSize(215,20);
					txtCidade.setLocation(360,27);
					txtCidade.setFont(font);
					panelEndereco.add(txtCidade);
				
					JLabel lblBairro = new JLabel("Bairro:");
					lblBairro.setSize(40,14);
					lblBairro.setLocation(20,70);
					panelEndereco.add(lblBairro);
				
					JTextField txtBairro = new JTextField();
					txtBairro.setSize(150,20);
					txtBairro.setLocation(65,67);
					txtBairro.setFont(font);
					panelEndereco.add(txtBairro);
					
					JLabel lblLogradouro = new JLabel("Logradouro:");
					lblLogradouro.setSize(70,14);
					lblLogradouro.setLocation(220,70);
					panelEndereco.add(lblLogradouro);
					
					JTextField txtLogradouro = new JTextField();
					txtLogradouro.setSize(280,20);
					txtLogradouro.setLocation(295,67);
					txtLogradouro.setFont(font);
					panelEndereco.add(txtLogradouro);
					
					JLabel lblNumero = new JLabel("Número:");
					lblNumero.setSize(50,14);
					lblNumero.setLocation(20,100);
					panelEndereco.add(lblNumero);
					
					JTextField txtNumero = new JTextField();
					txtNumero.setSize(70,20);
					txtNumero.setLocation(74,97);
					panelEndereco.add(txtNumero);
					
					JLabel lblComplemento = new JLabel("Complemento:");
					lblComplemento.setSize(85,14);
					lblComplemento.setLocation(155,100);
					panelEndereco.add(lblComplemento);
					
					JTextField txtComplemento = new JTextField();
					txtComplemento.setSize(285,20);
					txtComplemento.setLocation(243,97);
					txtComplemento.setFont(font);
					panelEndereco.add(txtComplemento);
				
				JPanel panelCEP = new JPanel();
				panelCEP.setBackground(Color.lightGray);
				panelCEP.setSize(155,36);
				panelCEP.setLocation(20,20);
				panelCEP.setLayout(null);
				panelCEP.setBorder(util.criarBorda(null,0,0,0));
				panelEndereco.add(panelCEP);
					
					JLabel lblCEP = new JLabel("CEP:");
					lblCEP.setSize(27,14);
					lblCEP.setLocation(10,10);
					panelCEP.add(lblCEP);
					
					JFormattedTextField txtCEP = new JFormattedTextField("09851-631");
					txtCEP.setSize(70,20);
					txtCEP.setLocation(40,7);
					panelCEP.add(txtCEP);
					
					JButton btnProcurarCEP = new JButton();
					btnProcurarCEP.setSize(25,25);
					btnProcurarCEP.setLocation(115,5);
					btnProcurarCEP.setIcon((util.redimensionarIcon(20,20, "Imagens/imgPesquisar.png")));
					btnProcurarCEP.setBackground(Color.CYAN);
					panelCEP.add(btnProcurarCEP);
					btnProcurarCEP.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e)
						{
							String[] endereco = util.buscaCep(txtCEP.getText());
							if (endereco!=null)
							{
								txtLogradouro.setText(endereco[0]);
								txtComplemento.setText(endereco[1]);
								txtBairro.setText(endereco[2]);
								txtCidade.setText(endereco[3]);
								for (int i = 0; i <boxEstado.getModel().getSize(); i++)
								{
									if (endereco[4].equals(boxEstado.getItemAt(i)))
									{
									boxEstado.setSelectedIndex(i);
									}
								}
							}
						}});
						
				JPanel panelContatos = new JPanel();
				panelContatos.setSize(278,121);
				panelContatos.setLocation(10,438);
				panelContatos.setLayout(null);
				panelContatos.setBorder(util.criarBorda("Contatos", 1, 2, 1));
				panelContatos.setBackground(Color.LIGHT_GRAY);
				panelPrincipal.add(panelContatos);
					
					JLabel lblTelefone = new JLabel("Telefone:");
					lblTelefone.setSize(55,14);
					lblTelefone.setLocation(10,20);
					panelContatos.add(lblTelefone);
					
					JFormattedTextField txtTelefone = new JFormattedTextField(util.setMask("(##) ####-####"));
					txtTelefone.setSize(140,20);
					txtTelefone.setLocation(67,18);
					txtTelefone.setColumns(15);
					txtTelefone.setFont(font);
					panelContatos.add(txtTelefone);
					
					JLabel lblCelular = new JLabel("Celular:");
					lblCelular.setSize(45,14);
					lblCelular.setLocation(10,50);
					panelContatos.add(lblCelular);
					
					JFormattedTextField txtCelular = new JFormattedTextField(util.setMask("(##) #####-####"));
					txtCelular.setSize(150,20);
					txtCelular.setLocation(57,48);
					txtCelular.setFont(font);
					panelContatos.add(txtCelular);
					
					JLabel lblEmail = new JLabel("Email:");
					lblEmail.setSize(35,14);
					lblEmail.setLocation(10,80);
					panelContatos.add(lblEmail);
					
					JTextField txtEmail = new JTextField("TesteTeste@gmail.com");
					txtEmail.setSize(220,20);
					txtEmail.setLocation(50,78);
					txtEmail.setFont(font);
					panelContatos.add(txtEmail);
					
					JLabel lblObs = new JLabel("Observações:");
					lblObs.setSize(80,14);
					lblObs.setLocation(303, 425);
					panelPrincipal.add(lblObs);
					
					TextArea txtObservacoes = new TextArea();
					txtObservacoes.setSize(302, 115);
					txtObservacoes.setLocation(303, 444);
					panelPrincipal.add(txtObservacoes);
					
				Panel panelButtons = new Panel();
				panelButtons.setBounds(396, 565, 209, 46);
				panelPrincipal.add(panelButtons);
					
					JButton btnLimpar = new JButton();
					btnLimpar.setToolTipText("LIMPAR");
					btnLimpar.setBounds(109, 5, 40, 40);
					btnLimpar.setBackground(Color.RED);
					btnLimpar.setIcon((util.redimensionarIcon(btnLimpar.getWidth()-10,btnLimpar.getHeight()-10,"Imagens/imgLimpar.png")));
					btnLimpar.setFont(new Font("Lucida Console", Font.BOLD, 11));
					btnLimpar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e)
						{
							
						}});
					panelButtons.setLayout(null);
					panelButtons.add(btnLimpar);
					
					JButton btnAdicionar = new JButton();
					btnAdicionar.setToolTipText("SALVAR");
					btnAdicionar.setBounds(159, 5, 40, 40);
					btnAdicionar.setBackground(Color.GREEN);
					btnAdicionar.setIcon(util.redimensionarIcon(btnAdicionar.getWidth()-10, btnAdicionar.getHeight()-10, "Imagens/imgSalvar.png"));
					btnAdicionar.setFont(new Font("Lucida Console", Font.BOLD, 11));
					btnAdicionar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e)
						{
							
						}});
					panelButtons.add(btnAdicionar);
					
					JButton btnAlterar = new JButton();
					
					btnAlterar.setFont(new Font("Lucida Console", Font.BOLD, 11));
					btnAlterar.setBackground(Color.GREEN);
					btnAlterar.setBounds(159, 5, 40, 40);
					btnAlterar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						}
					});
					panelButtons.add(btnAlterar);
					
		JPanel panelAvaliacaoFisica = new JPanel();
		jTabbedPane.add("Avaliação", panelAvaliacaoFisica);
		panelAvaliacaoFisica.setLayout(new BorderLayout(0, 0));
			
			JPanel panelPrincipalAvaliacao = new JPanel();
			panelPrincipalAvaliacao.setBackground(Color.lightGray);
			panelAvaliacaoFisica.add(panelPrincipalAvaliacao);
			panelPrincipalAvaliacao.setLayout(null);
				
				JPanel panelAdicionarAvalicao = new JPanel();
				panelAdicionarAvalicao.setBackground(Color.LIGHT_GRAY);
				panelAdicionarAvalicao.setSize(593, 104);
				panelAdicionarAvalicao.setLocation(10, 11);
				panelAdicionarAvalicao.setBorder(util.criarBorda("Adicionar avaliação", 1, 2, 1));
				panelPrincipalAvaliacao.add(panelAdicionarAvalicao);
				panelAdicionarAvalicao.setLayout(null);
					
					JLabel lblDataInicio = new JLabel("Data Inicio:");
					lblDataInicio.setSize(67, 14);
					lblDataInicio.setLocation(10, 15);
					panelAdicionarAvalicao.add(lblDataInicio);
						
					JFormattedTextField dateInicioAvaliacao = new JFormattedTextField();
					dateInicioAvaliacao.setSize(117, 20);
					dateInicioAvaliacao.setLocation(10, 30);
					dateInicioAvaliacao.setFont(font);
					dateInicioAvaliacao.setText(dataFormatada.format(date));
					dateInicioAvaliacao.setEditable(false);
					panelAdicionarAvalicao.add(dateInicioAvaliacao);
						
					JLabel lblDataFim = new JLabel("Data Fim:");
					lblDataFim.setSize(60, 14);
					lblDataFim.setLocation(135, 15);
					panelAdicionarAvalicao.add(lblDataFim);
						
					JDateChooser dateFimAvalicao = new JDateChooser();
					dateFimAvalicao.setSize(117, 20);
					dateFimAvalicao.setLocation(135, 30);
					dateFimAvalicao.setFont(font);
					dateFimAvalicao.setMinSelectableDate(date);
					panelAdicionarAvalicao.add(dateFimAvalicao);
						
					JButton btnAdicionarAvalicao = new JButton("Adicionar");
					btnAdicionarAvalicao.setSize(93,22);
					btnAdicionarAvalicao.setLocation(362,60);
					panelAdicionarAvalicao.add(btnAdicionarAvalicao);
					btnAdicionarAvalicao.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent arg0)
						{
							FramePrincipal framePrincipal = new FramePrincipal();

						
							
						}});
				
					
					JComboBox comboBox = new JComboBox();
					comboBox.setModel(new DefaultComboBoxModel(new String[] {"Protocolo de 7 dobras para homens", "Protocolo de 3 dobras para homens", "Protocolo de 7 dobras para mulheres", "Protocolo de 3 dobras para mulheres", "Protocolo de 2 dobras para crianças e adolescentes"}));
					comboBox.setBounds(10, 61, 342, 20);
					panelAdicionarAvalicao.add(comboBox);
						
				JPanel panelAvaliacao = new JPanel();
				panelAvaliacao.setBackground(Color.LIGHT_GRAY);
				panelAvaliacao.setSize(552, 326);
				panelAvaliacao.setLocation(10,140);
				panelAvaliacao.setBorder(util.criarBorda("Avaliações", 1, 2, 1));
				panelPrincipalAvaliacao.add(panelAvaliacao);
				panelAvaliacao.setLayout(null);
						
					JPanel panelCompararAvaliaçoes = new JPanel();
					panelCompararAvaliaçoes.setBackground(Color.LIGHT_GRAY);
					panelCompararAvaliaçoes.setSize(516, 86);
					panelCompararAvaliaçoes.setLocation(26, 195);
					panelAvaliacao.add(panelCompararAvaliaçoes);
					panelCompararAvaliaçoes.setBorder(util.criarBorda("Comparar avaliações", 1, 2, 1));
					panelCompararAvaliaçoes.setLayout(null);
							
						JComboBox comboBoxComparacaoAvaliacao1 = new JComboBox();
						comboBoxComparacaoAvaliacao1.setSize(243, 20);
						comboBoxComparacaoAvaliacao1.setLocation(10, 22);
						panelCompararAvaliaçoes.add(comboBoxComparacaoAvaliacao1);
						comboBoxComparacaoAvaliacao1.setModel(new DefaultComboBoxModel(new String[] {"Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/#### "}));
							
						JComboBox comboBoxComparacaoAvaliacao2 = new JComboBox();
						comboBoxComparacaoAvaliacao2.setModel(new DefaultComboBoxModel(new String[] {"Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/#### "}));
						comboBoxComparacaoAvaliacao2.setSize(243, 20);
						comboBoxComparacaoAvaliacao2.setLocation(257, 22);
						panelCompararAvaliaçoes.add(comboBoxComparacaoAvaliacao2);
							
						JButton btnCompararAvaliacoes = new JButton("Comparar");
						btnCompararAvaliacoes.setSize(95, 23);
						btnCompararAvaliacoes.setLocation(214, 52);
						panelCompararAvaliaçoes.add(btnCompararAvaliacoes);
							
					JPanel panelAlterarAvalicao = new JPanel();
					panelAlterarAvalicao.setSize(374, 64);
					panelAlterarAvalicao.setLocation(26, 106);
					panelAvaliacao.add(panelAlterarAvalicao);
					panelAlterarAvalicao.setBackground(Color.LIGHT_GRAY);
					panelAlterarAvalicao.setBorder(util.criarBorda("Alterar avaliação", 1, 2, 1));
					panelAlterarAvalicao.setLayout(null);
							
						JComboBox comboBoxAlterarAvaliacao = new JComboBox();
						comboBoxAlterarAvaliacao.setModel(new DefaultComboBoxModel(new String[] {"Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/####", "Avaliacao ##/##/#### até ##/##/#### "}));
						comboBoxAlterarAvaliacao.setSize(243, 20);
						comboBoxAlterarAvaliacao.setLocation(10, 22);
						panelAlterarAvalicao.add(comboBoxAlterarAvaliacao);
							
						JButton btnAlterarAvalicao = new JButton("Alterar");
						btnAlterarAvalicao.setSize(89, 23);
						btnAlterarAvalicao.setLocation(263, 21);
						panelAlterarAvalicao.add(btnAlterarAvalicao);
							
						JButton btnBuscarAvaliacoes = new JButton("Buscar");
						btnBuscarAvaliacoes.setSize(89, 23);
						btnBuscarAvaliacoes.setLocation(453, 292);
						panelAvaliacao.add(btnBuscarAvaliacoes);
						
					JPanel panelConsultarAvaliacao = new JPanel();
					panelConsultarAvaliacao.setLayout(null);
					panelConsultarAvaliacao.setBorder(util.criarBorda("Consultar avaliação", 1, 2, 1));
					panelConsultarAvaliacao.setBackground(Color.LIGHT_GRAY);
					panelConsultarAvaliacao.setBounds(26, 31, 374, 64);
					panelAvaliacao.add(panelConsultarAvaliacao);
							
						JComboBox comboBoxConsultarAvaliacao = new JComboBox();
						comboBoxConsultarAvaliacao.setBounds(10, 22, 243, 20);
						panelConsultarAvaliacao.add(comboBoxConsultarAvaliacao);
							
						JButton btnConsultarAvaliacao = new JButton("Consultar");
						btnConsultarAvaliacao.setBounds(263, 21, 89, 23);
						panelConsultarAvaliacao.add(btnConsultarAvaliacao);
	}
	
	public static void main(String args[])
	{
		new Thread() {
			@Override
			public void run() {
				new FrameAluno().setVisible(true);
			}
		}.start();
		
	}
}






