import java.util.*;
import java.util.concurrent.TimeUnit;
import java.lang.System;

//Dumpify --> Main Class (main function call)
//Anime   --> Custom Class (Animation purpose)

public class Dumpify{
	//main()
	//menu()
	public static void main(String laf[]){  //Main Function call here
		Anime load=new Anime();         
		load.welcome("dumpify...");     
		load.LoadingCli("dumpify... ");
		menu();
	}


	public static void menu(){		//Menu implementation here
		int x=1;
		Scanner input=new Scanner(System.in);
		while(x!=0){
			System.out.println("\n\t\tDumpify\n");
			System.out.println("\t\t1.(E)ncode");
			System.out.println("\t\t2.(D)ecode");
			System.out.println("\t\t3.(C)heck (F)iles");
			System.out.println("\t\t4.(P)roof (O)f (c)oncept");
			System.out.println("\t\t0.(E)xit\n");
			System.out.print("\n\n\t[+]Enter your choice : ");
			int choice=input.nextInt();
			x=0;
		}
	}
}




class Anime{ 
	//welcome(String text)
	//LoadingCli(String text)
	//CLin(String cmd)
	 public static void welcome(String text) { //Lower to upper string manipulation animation
		try{
		StringBuilder lowerBuilder = new StringBuilder(text.toUpperCase());
		for (int i = 0; i < text.length(); i++) {
		    StringBuilder sBuilder = new StringBuilder();
		    for (int x = 0; x <= i; x++) {
			if(x < text.length()) { 
			    sBuilder.append(text.substring(x, x + 1));
			}
		    }
		    System.out.print(sBuilder.toString() + lowerBuilder.charAt(i) + "\r");
		    System.out.flush();
		    TimeUnit.MILLISECONDS.sleep(100); // 0.1 seconds delay
		}
	    	} catch (Exception e){ System.out.println("Intro skipped!");}
	 }


	public static void LoadingCli(String text){  //loading bar animation
		final var bar = new char[] {'⢿', '⣻', '⣽', '⣾', '⣷', '⣯', '⣟', '⡿'};

		try{
			for(int i=0;i<=3;i++){
				for(int j=0;j<=bar.length-1;j++){
				System.out.print("\r"+text+bar[j]);
				Thread.sleep(70);
				System.out.print("\r                   ");

				}
		 }
		}catch (InterruptedException e) {
			 System.out.println(e);
		 }
			}
	public static void CLin(String cmd){ //function to run linux command in background
		try{
		ProcessBuilder pb = new ProcessBuilder("/bin/bash", "-c", cmd);
		pb.start().waitFor();
		}catch (Exception e){
			System.out.println(e);
		}
	}

}
