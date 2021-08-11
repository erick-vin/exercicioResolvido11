package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String path = "C:\\temp\\in.csv";
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			Map<String, Integer> vote = new TreeMap<>();
			
			String line = br.readLine();
			
			while(line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				int numberOfVotes = Integer.parseInt(fields[1]);
				
				if(vote.containsKey(name)) {
					int voteAdder = vote.get(name) + numberOfVotes;
					vote.put(name, voteAdder);
				}
				else {
					vote.put(name, numberOfVotes);
				}
				
				line = br.readLine();
				
			}
			
			for(String key : vote.keySet()) {
				System.out.println(key + ":" + vote.get(key));
			}
			
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();

	}

}
