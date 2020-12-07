package Logic;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class Stalkerbot2 {
	private boolean debugMode = false;
	private boolean emExecução = true;
	private int porcentagemDaBusca;
	private String result = "";
	private String nickBusca;
	private int startNumber;
	private int stopNumber;
	private int objectId;
	
	public Stalkerbot2(String nickBusca, int startNumber, int stopNumber,int objectId) {
		this.nickBusca = nickBusca;
		this.startNumber = startNumber;
		this.stopNumber = stopNumber;
		new Thread(Busca).start();
	}
	
	public Stalkerbot2() {
	}
	
	private Runnable Busca  = new Runnable() {
		public void run() {
			try{
				String pageContent = "";
				String [] botArray;
				String workingLine;
				
				for (int i = startNumber ; i < stopNumber && emExecução == true ; i++) {
					porcentagemDaBusca +=1;
					String page = "https://rest.firecastrpg.com/a?a=pagRWEMesaInfo.actInfoMesa&mesaid="+i;
					
					//System.out.println("Rodando na mesa: "+i);
					
					
				    Connection conn = Jsoup.connect(page);
				      
				      try {
				    	  Document doc = conn.get();
					      
				    	  pageContent = doc.body().text();
				      } catch (Exception e) {
				    	  if(debugMode==true) {System.out.println("A Mesa ID: "+i+" Não existe");}
				    	  
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
				    	  if (botArray[i2].equals(nickBusca) == true || botArray[i2].equals(nickBusca+ " (Mestre)") == true) {
				    		  result += " O jogador procurado está na mesa: "+page;
				    		  
				    	  }
				 
				      }
				      
				      
				}
				
			} catch (Exception e){
				if(debugMode==true) {
					System.out.println("Um erro ocorreu na Busca de id: "+ objectId);
				}
				
			}
		}
	};
	
	
	
	
	
	
	public boolean isEmExecução() {
		return emExecução;
	}

	public void setEmExecução(boolean emExecução) {
		this.emExecução = emExecução;
	}
	
	public String getResult() {
		return this.result;
	}

	public int getPorcentagemDaBusca() {
		return porcentagemDaBusca;
	}

	public void setPorcentagemDaBusca(int porcentagemDaBusca) {
		this.porcentagemDaBusca = porcentagemDaBusca;
	}

	public int getStartNumber() {
		return startNumber;
	}

	public void setStartNumber(int startNumber) {
		this.startNumber = startNumber;
	}

	public int getStopNumber() {
		return stopNumber;
	}

	public void setStopNumber(int stopNumber) {
		this.stopNumber = stopNumber;
	}
	
	
	
	
	
	
}
