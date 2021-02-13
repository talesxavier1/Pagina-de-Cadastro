package FramesUtilitarios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.github.sarxos.webcam.WebcamUtils;

import FramesAlunos.FrameAluno;



public class FrameWebCam extends JFrame 
{
	private static final long serialVersionUID = 1L;
	FrameUtil util = new FrameUtil();
	//CadastrarAlunos alunos = new CadastrarAlunos();
	//----------- componentes da camera -----------//
	public WebcamPanel webcamPanel;
	public Webcam webcam;
	//---------------------------------------------//

	public  FrameWebCam()
	{
		this.setSize(300,300);
		this.setLocation(10,20);
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(FrameWebCam.DISPOSE_ON_CLOSE);
		this.setVisible(true);

		try
		{
			webcam = Webcam.getDefault();
			webcam.setViewSize(WebcamResolution.VGA.getSize());
			webcamPanel = new WebcamPanel(webcam);
			webcamPanel.setFPSDisplayed(true);
			webcamPanel.setDisplayDebugInfo(true);
			webcamPanel.setImageSizeDisplayed(true);
			webcamPanel.setMirrored(true);
		}
		catch (Exception e)
		{
			System.out.println("erro:"+e);
		}


		if (webcamPanel != null)
		{
			
			FrameAluno.btnIniciarCam.setEnabled(false);
			this.add(webcamPanel);
		}
		else
		{
			this.setVisible(false);
			JOptionPane.showMessageDialog(null,"Erro ao iniciar a camera");
		}
		
		
		JButton btnTirarFoto = new JButton();
		btnTirarFoto.setSize(30,30);
		btnTirarFoto.setLocation(150,213);
		btnTirarFoto.setBackground(Color.CYAN);
		btnTirarFoto.setIcon(new ImageIcon("Imagens/imgTirarFoto.png"));
		add(btnTirarFoto, BorderLayout.SOUTH);
		btnTirarFoto.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				byte[] bytes = WebcamUtils.getImageBytes(webcam, "jpg");
				FrameAluno.labelFoto.setIcon(util.inputImageIcon(null, bytes, FrameAluno.labelFoto.getWidth(), FrameAluno.labelFoto.getHeight()));
				FrameAluno.fotoEmByte = bytes;
			}});
		
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosed(WindowEvent e)
			{
				if (e.getID()==202)
				{
					FrameAluno.btnIniciarCam.setEnabled(true);
					webcam.close();
				}
			}
		});
	}
}