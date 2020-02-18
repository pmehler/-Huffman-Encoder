/* Peter Mehler
 * Programming Assignment 2
 * Standard
 * I did not work with anyone
 * Credit for idea to use a queue and recursive traversal:  Aashish Barnwal 
 * https://www.geeksforgeeks.org/huffman-coding-greedy-algo-3/
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Huffman {
	
	public static void main(String[] args) throws IOException { 
		
		read("/Users/petermehler/Desktop/CompSci/CS302_assignment1/src/sample_text.txt");
		
    }
	
	public static void read(String filename) throws IOException{
		
		// Read File
	
		String s = "";
		File myFile = new File(filename);
		Scanner scan = new Scanner(myFile);
		while(scan.hasNext()) {					//Reads until end
			s += scan.nextLine();
		}
		
		encode.findCodes(encode.findFreq(s));	//Creates code of each letter and writes to file
		
		scan.close();
		
		String[] encoding = new String[27];
		
		String w = "";
		File code_file = new File("code_key.txt");
		Scanner scan_1 = new Scanner(code_file);
		while(scan_1.hasNext()) {					//Reads until end
			w = scan_1.nextLine();
			if (w.charAt(0)==' ') {
				encoding[26] = w.substring(2, w.length());
			}
			else {
				encoding[w.charAt(0)-97] = w.substring(2, w.length());
			}
		}
		
		//Read file and replace characters with encoding, write out to new file
		
		File again = new File(filename);
		Scanner scan_2 = new Scanner(again);
		String outfile = "encoded.txt";
		BufferedWriter out = new BufferedWriter(new FileWriter(outfile));
		while(scan_2.hasNext()) {
			String b = scan_2.nextLine().toLowerCase();
			for(int i=0; i<b.length(); i++) {
				if (b.charAt(i)==' ') {
					out.write(encoding[26]);
				}
				else if (Character.isLetter(b.charAt(i))) {
					out.write(encoding[b.charAt(i)-97]);
				}
			}
		}
		
		scan_1.close();
		scan_2.close();
		out.close();
	}
	
}
