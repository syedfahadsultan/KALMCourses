package main.java.edu.stonybrook.cs.util;
import java.util.Arrays;
import java.io.*;

public class PrologConnector {
	
	// private static String XSBBin = "/Users/tiantiangao/Documents/Research/KnowledgeAqcuisition/Software/Knowledge Acquisition Machine/kam/runxsb.sh";
	private static String XSBBin = "/Users/Fahad/NewWorkspace/kalm/runxsb.sh";

	public static void ExecutePrologQuery() {
		Process p;
		String s = null;
		try {
			// String[] cmd = { "/bin/bash"  , XSBBin };

			// p = Runtime.getRuntime().exec(cmd);
			// p = Runtime.getRuntime().exec("bash /Users/Fahad/NewWorkspace/kalm/runxsb.sh");

			String[] cmd = new String[]{"sudo", "/bin/bash", "-c", "/Users/fahad/NewWorkspace/kalm/runxsb.sh"};
			// System.out.println(Arrays.toString(cmd));
			p = Runtime.getRuntime().exec(cmd);
			// p = Runtime.getRuntime().exec(new String[]{"/bin/echo", "Yo Sup?"});
			// p = Runtime.getRuntime().exec("/Users/fahad/NewWorkspace/kalm/runxsb.sh");
			// p = new ProcessBuilder("sudo /bin/bash /Users/Fahad/NewWorkspace/kalm/runxsb.sh").start();
			// p = new ProcessBuilder("pwd").start();
			
			// p = new ProcessBuilder("./runxsb.sh").start();


			p.waitFor();
            BufferedReader stdInput = new BufferedReader(new 
             	InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new 
                 InputStreamReader(p.getErrorStream()));

            // read the output from the command
            // System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
            
            // read any errors from the attempted command
            // System.out.println("Here is the standard error of the command (if any):\n");
            // while ((s = stdError.readLine()) != null) {
            //     System.out.println(s);
            // }

			p.destroy();
		} catch (Exception e) {
			System.out.println("Prolog Exception: ");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		ExecutePrologQuery();
		System.out.println("End.");
	}
}
