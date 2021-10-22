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

public class Sha256_comp {

	private static final String FICHERO = "SGSSI-21.CB.04.txt";
	private static final String FICHERO1 = "Copia_SGSSI-21.CB.04.txt";
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
			checksum = tarea2(md5Digest);
		String check = "";
		File file1 = new File("Copia_"+FICHERO);
		check = tarea1(md5Digest,file1);
		/*	if(checksum.startsWith("00"))
				break;*/
			if(checksum.equals("FALSE"))
				{
				System.out.println("FALSE");
				return;
				}
				if(check.startsWith("0"))
				{
					String res = contarCeros(checksum);
					System.out.println(res);
				}
				else
					System.out.println("FALSE");
		
		
		//see checksum
		//System.out.println(checksum);
	
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
		if(hash.startsWith("0")) {
			//num0s = 6;
			return true;
		}else
			return false;
	}
	
	
	private static String contarCeros(String hash) {
		if(hash.length()<17)
		{
			for(int i = 0; i < hash.length(); i++) {
				if(i<8) {
					char c = hash.charAt(i);
					if (((c >= 'A' && c <= 'Z') || c == ' ')) {
			            return "FALSE";
			        }
				}else if (i == 8) {
					char c = hash.charAt(i);
					if (c != ' ') {
			            return "FALSE";
			        }
				}
				else if (i == 9) {
					char c = hash.charAt(i);
					if (c != 'G') {
			            return "FALSE";
			        }
				}
				else {
					char c = hash.charAt(i);
					if (((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
			            return "FALSE";
			        }
				}
			}
			return "TRUE";
		}else 
			return "FALSE";
		
	}
	
	
	
	private static String tarea2(MessageDigest digest) throws IOException{
		//Copia del fichero
		//Files.copy(Paths.get(FICHERO), Paths.get("Copia_"+FICHERO), StandardCopyOption.REPLACE_EXISTING);
		BufferedReader br = new BufferedReader(new FileReader(FICHERO));
		BufferedReader br1 = new BufferedReader(new FileReader(FICHERO1));
		String line = br.readLine();
		String line1 = br1.readLine();
		
		//Copia del fichero original.
		while(line != null & line1 != null) {
			if (line.equals(line1));else return "FALSE";
			line = br.readLine();
			line1 = br1.readLine();
			
		}
		String fin = br1.readLine();
		if (fin != null) return "FALSE";
		br.close();
		br1.close();
		return line1;
		
		
	}
	

}
