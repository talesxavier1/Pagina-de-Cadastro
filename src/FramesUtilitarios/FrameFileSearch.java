package FramesUtilitarios;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

import FramesAlunos.FrameAluno;

public class FrameFileSearch extends JFileChooser
{
	private static final long serialVersionUID = 1L;
	
	public FrameFileSearch(String origemDaChamada)
	{
		FrameUtil util = new FrameUtil();
		
		try 
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(0);
			fileChooser.setFileFilter(new FileNameExtensionFilter("Image files", "bmp", "png", "jpg"));
			FrameAluno.btnAdicionarFoto.setEnabled(false);
			
			if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION )
			{
				File file = fileChooser.getSelectedFile().getAbsoluteFile();
				byte[] imagemEmBytes = Files.readAllBytes(file.toPath());
				if(origemDaChamada.equals("aluno"))
				{
					FrameAluno.labelFoto.setIcon(util.inputImageIcon(null,imagemEmBytes,FrameAluno.labelFoto.getWidth(),FrameAluno.labelFoto.getHeight()));
					FrameAluno.fotoEmByte=imagemEmBytes;
				}
			}
		}
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException | IOException e)
		{
			JOptionPane.showMessageDialog(null, "Erro na inserção manual da foto. classe FrameFileSearch. Erro: "+e);
		}
		finally
		{
			FrameAluno.btnAdicionarFoto.setEnabled(true);
		}
	}
}
