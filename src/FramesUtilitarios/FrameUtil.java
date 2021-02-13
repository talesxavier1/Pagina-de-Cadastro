package FramesUtilitarios;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import javax.print.attribute.standard.RequestingUserName;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.text.Document;
import javax.swing.text.MaskFormatter;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class FrameUtil
{
	//// cria bordas;
	public Border criarBorda(String titulo, Integer posicaoXTitle, Integer posicaoYTitle, Integer tipo)
	{
		if (tipo==1)
		{			
			Border border = BorderFactory.createLineBorder(Color.BLACK);
			Border borda = BorderFactory.createTitledBorder(border, titulo, posicaoXTitle, posicaoYTitle, new Font("Lucida Console", Font.BOLD, 13), Color.black);
			return borda;
		}
		else
		{
			Border borda = BorderFactory.createEtchedBorder(Color.black,Color.DARK_GRAY);
			return borda;
		}
	}
	
	public ImageIcon redimensionarIcon(int xComponete, int yComponete, String endereco)
	{
		ImageIcon icon = new ImageIcon(endereco);
		Image image = icon.getImage();
		Image newImage = image.getScaledInstance(xComponete, yComponete,  java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newImage);
		return icon;
	}
	
	public ImageIcon inputImageIcon(String endereco,byte[] imagemEmByte, int larguraDoLabal, int alturaDoLabel)
	{
		if (endereco != null)
		{
			ImageIcon icon = new ImageIcon(endereco); //busco a imagem
			Image image = icon.getImage(); //passo de icon para Image
			Image imageRedimensionada = image.getScaledInstance(larguraDoLabal, alturaDoLabel, java.awt.Image.SCALE_SMOOTH);// redimenciono
			icon = new ImageIcon(imageRedimensionada); //coloco de volta no icon
			return icon;
		}
		else if (imagemEmByte != null)
		{
			Image image = new ImageIcon(imagemEmByte).getImage();//passo de Byte para image
			Image imageRedimensionada = image.getScaledInstance(larguraDoLabal, alturaDoLabel, java.awt.Image.SCALE_SMOOTH);// redimenciono
			ImageIcon icon = new ImageIcon(imageRedimensionada);//de image para imageicon
			return icon;
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Imagem Nula");
			return null;
		}
	}
	
	public String[] buscaCep(String CEP)
	{
		
		String urlString="https://viacep.com.br/ws/"+CEP+"/json/";
		String[] retorno = new String[5];
		try
		{
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			JSONParser parser = new JSONParser();
			
			JSONObject enderecoOjb = (JSONObject) parser.parse(rd);
				retorno[0]=(String) enderecoOjb.get("logradouro");
				retorno[1]=(String) enderecoOjb.get("complemento");
				retorno[2]=(String) enderecoOjb.get("bairro");
				retorno[3]=(String) enderecoOjb.get("localidade");
				retorno[4]=(String) enderecoOjb.get("uf");
				
		}
		catch (IOException | ParseException e)
		{
			JOptionPane.showMessageDialog(null, "Erro na consulta do cep. Erro: "+e);
			return null;
		}
		return retorno;
	}
	
	public MaskFormatter setMask(String mask)
	{
		
		MaskFormatter formatter = new MaskFormatter();
		if (mask != null)
		{
			try
			{
				formatter.setMask(mask);
			}
			catch (java.text.ParseException e)
			{
				e.printStackTrace();
			}
		}
		return formatter;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
