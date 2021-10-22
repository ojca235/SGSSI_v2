package SGSSI;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Sha256_Min {

	private static final String FICHERO = "SGSSI-21.CB.04.txt";
	private static final String GRUPO_ID = "G112029";
	private static int num0s = 0;
	private static String hex = "FFFFFFFF";
	private static String mejorHash = "00000000000000000000000000000000";
	

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
	
		
		File file = new File(FICHERO);
			
		MessageDigest md5Digest = MessageDigest.getInstance("SHA-256");
		 
		//Get the checksum
		//String checksum = tarea1(md5Digest, file);
		
		//String checksum = tarea2(md5Digest);
		String checksum = "";
		int a=0;
		while(true) {
			checksum = tarea2(md5Digest);
		/*	if(checksum.startsWith("00"))
				break;*/
			if(esMejor(checksum)) {
				contarCeros(checksum);
				System.out.println("------------------------");
				System.out.println(checksum+" // Numero de 0s // "+num0s);
				System.out.println("El hex a�adido es --> "+hex);
				
				return;
				
			}
		}
		
		
		//see checksum
		//System.out.println(checksum);
	
	}
	
	private static boolean esMejor(String hash) {
		
	/*	int y = 0;
		String aux = hash.substring(0,0);
		for(int i = 1; i < hash.length(); i++) {
			if(hash.substring(0, i).equals(mejorHash.substring(0, i))) {
				y++;
			}else
				break;
		}
		if(y>num0s) {
			num0s = y;
			return true;
		}else
			return false;*/
		if(hash.startsWith("0000")) {
			//num0s = 6;
			return true;
		}else
			return false;
	}
	
	
	private static void contarCeros(String hash) {
		int y = 0;
		for(int i = 0; i < hash.length(); i++) {
			if(hash.substring(i).equals("0")){
				y++;
			}else {
				num0s = y;
				return;
			}
		}
		
		
	}
	
	public static String tarea1(MessageDigest digest, File file) throws IOException{
		FileInputStream fis = new FileInputStream(file);
		
		byte[] byteArray = new byte[1024];
		int bytesCount = 0;
		
		//Lectura del fichero
		while ((bytesCount = fis.read(byteArray)) != -1) {
	        digest.update(byteArray, 0, bytesCount);
	    };
	     
	    fis.close();
	    
	    byte[] bytes = digest.digest();
	     
	    //Conversion de cadena de bytes a hexadecimal.
	    StringBuilder sb = new StringBuilder();
	    for(int i=0; i< bytes.length ;i++)
	    {
	        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	    }
	     
	    //return complete hash
	   return sb.toString();
	    
	    
	}
	
	
	private static String tarea2(MessageDigest digest) throws IOException{
		//Copia del fichero
		//Files.copy(Paths.get(FICHERO), Paths.get("Copia_"+FICHERO), StandardCopyOption.REPLACE_EXISTING);
		BufferedReader br = new BufferedReader(new FileReader(FICHERO));
		FileWriter fw = new FileWriter("Copia_"+FICHERO);
		
		String oldContent = "";
		String line = br.readLine();
		
		//Copia del fichero original.
		while(line != null) {
			oldContent = oldContent + line + System.lineSeparator();
			line = br.readLine();
		}
		String hexStr = getRandomHexString(8);
		//String hexStr = "a6c30eac";
		oldContent = oldContent + hexStr + " "+GRUPO_ID;
		hex = hexStr;
		fw.write(oldContent);
		fw.close();
		br.close();
		
		
		File file = new File("Copia_"+FICHERO);
		return tarea1(digest, file);
		
	}
	
	
    private static String getRandomHexString(int numchars){
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while(sb.length() < numchars){
            sb.append(Integer.toHexString(r.nextInt()));
        }

        return sb.toString().substring(0, numchars);
    }

}
