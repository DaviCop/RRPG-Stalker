package Logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class StalkerBot {
	private File arquivo;
	public static boolean stopTheCount = false;
	
	public static String StalkerBot(String nickPlayer, int iniciarProcuraID) throws IOException {
		boolean emExecucao = true;
		String pageContent = "";
		String [] botArray;
		String workingLine;
		String result = "0";
		
		for (int i = iniciarProcuraID ; emExecucao == true ; i++) {
			
			if (stopTheCount == true) {
				result = "A Busca foi encerrada antes do esperado.";
				break;
			}
			
			String page = "https://rest.firecastrpg.com/a?a=pagRWEMesaInfo.actInfoMesa&mesaid="+i;
		      //Connecting to the web page
		    Connection conn = Jsoup.connect(page);
		      //executing the get request
		      try {
		    	  Document doc = conn.get();
			      //Retrieving the contents (body) of the web page
		    	  pageContent = doc.body().text();
		      } catch (Exception e) {
		    	 System.out.println("erro 1 no id: "+i);
		    	 continue;
		      }
			
		      botArray = pageContent.split("Entrar na Mesa É necessário ter o RRPG FireCastwww.rrpg.com.br"); 
		      workingLine = botArray[0];
		      botArray = new String[0];
		      botArray = workingLine.split("Usuários Online: ");
		      
		      if(botArray.length >= 2) {
		    	  workingLine = ", "+botArray[1];
			      }else {
			       continue;
			      }
		      botArray = new String[0];
		      botArray = workingLine.split(", ");
		      
		      for(int i2=0 ;i2<=(botArray.length-1); i2++) {
		    	  if (botArray[i2].equals(nickPlayer) == true || botArray[i2].equals(nickPlayer+ " (Mestre)") == true) {
		    		  result = "O jogador procurado está na mesa: "+page;
		    		  emExecucao = false;
		    	  }
		 
		      }
		      
		      
			
			
			
		}

		
		return result;
		
	}
	
	public static String StalkerBotPrio(String nickPlayer, int iniciarProcuraID) throws IOException {
		
		
		File arquivo = new File("ids conhecidos.txt");
		String [] idsConhecidos = new String [0];
		
		try {
			FileReader leitura = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(leitura);
			String linha = "";
			while((linha = br.readLine()) != null){
				idsConhecidos = linha.split(";;");
				//textPane.setText("Escrito");
			}
			leitura.close();
			br.close();
		} catch (Exception e) {
			
		}
		
		
		boolean emExecucao = true;
		String pageContent = "";
		String [] botArray;
		String workingLine;
		String result = "0";
		String [] resultDef = new String[0];
		
		for (int i = 0 ; i <= (idsConhecidos.length-1) ; i++) {
			
			if (emExecucao == false) {
				break;
			}
			
			String page = "https://rest.firecastrpg.com/a?a=pagRWEMesaInfo.actInfoMesa&mesaid="+idsConhecidos[i];
		      //Connecting to the web page
		    Connection conn = Jsoup.connect(page);
		      //executing the get request
		      try {
		    	  Document doc = conn.get();
			      //Retrieving the contents (body) of the web page
		    	  pageContent = doc.body().text();
		      } catch (Exception e) {
		    	 System.out.println("erro 1 no id: "+idsConhecidos[i]);
		    	 continue;
		      }
			
		      botArray = pageContent.split("Entrar na Mesa É necessário ter o RRPG FireCastwww.rrpg.com.br"); 
		      workingLine = botArray[0];
		      botArray = new String[0];
		      botArray = workingLine.split("Usuários Online: ");
		      
		      if(botArray.length >= 2) {
		    	  workingLine = ", "+botArray[1];
			      }else {
			       continue;
			      }
		      botArray = new String[0];
		      botArray = workingLine.split(", ");
		      
		      for(int i2=0 ;i2<=(botArray.length-1); i2++) {
		    	  if (botArray[i2].equals(nickPlayer) == true || botArray[i2].equals(nickPlayer+ " (Mestre)") == true) {
		    		  result += " O jogador procurado está na mesa: "+page;
		    		  
		    		  //emExecucao = false;
		    	  }
		 
		      }
		      
		      
			
			
			
		}
		/*
		for(int i3 = 0; i3 <= resultDef.length; i3++) {
			result += resultDef[i3];
		}*/

		
		return result;
		
	}
}
