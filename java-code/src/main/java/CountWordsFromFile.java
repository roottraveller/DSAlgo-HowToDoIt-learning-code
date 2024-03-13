import java.io.*;
import java.util.*;
import java.lang.*;

/*
 * This code should work with all the possible cases 
 * If not, go take a bath and return (1).
 */
 
 // @author : rootTraveller, June 2017
 
 
class CountWordsFromFile {
	private static final String filePath = "C:/Users/r.maurya/Desktop/keyboard.txt"; // file path
	
	CountWordsFromFile() {
	}
	
	public static void main(String args[]) throws IOException {
		String file = CountWordsFromFile.readFile(filePath);
		System.out.print(file); // this will print whole file content
		
		HashMap<String, Integer> wordHashMap = CountWordsFromFile.createMapFromFile(file);
		// wordHashMap = (HashMap<String, Integer>)SortHashMap.sortOnValue(wordHashMap);
		wordHashMap = (HashMap<String, Integer>)SortHashMap.sortOnKey(wordHashMap);
		
		System.out.printf("\n%1$-20s  %2$-5s\n", "WORD", "COUNT");
		CountWordsFromFile.printHashMap(wordHashMap);
	}
	
	public static String readFile(String filePathIn) throws IOException {
		// Using try-with-resource (auto close features) to read a file Java 7
		try (BufferedReader br = new BufferedReader(new FileReader(filePathIn))) {
		  // read file line by line and convert it into StringBuilder i.e No method to read line in StringBuilder Class
			String line = null;
			StringBuilder sbline = null;
			
			while((line = br.readLine()) != null) {
				sbline.append(line);
				sbline.append(System.lineSeparator());
			}
			
			return new String(sbline); // this is whole file
		}
	}
	
	public static HashMap<String, Integer> createMapFromFile(String fileIn) {
		HashMap<String, Integer> wordMap = new HashMap<>();
		Scanner sc = new Scanner (fileIn);
		
		while(sc.hasNextLine()) {
			String line = sc.nextLine();  // this is a line of words
			
			for(String word : line.split("\\s+")) {  // space based split
				int value = wordMap.containsKey(word) ? wordMap.get(word) : 0; // get already present value or 0
				wordMap.put(word, value + 1);
			} 
		}
		
		return wordMap;
	}
	
	public static void printHashMap(HashMap<String, Integer> hashmapIn) {
			for(Map.Entry<String, Integer> entry : hashmapIn.entrySet()) {
				System.out.printf("%1$-20s  %2$-5s\n", entry.getKey(), entry.getValue()); // %[index$][flags][width][.precision]conversion
			}
		}
		
		
		//INNER CLASS
		static class SortHashMap<K, V> {
			// <K, V extends Comparable<? super V>> is IMPORTANT for using compareTo 
			
			public  static <K, V extends Comparable<? super V>>   Map<K, V> sortOnValue(HashMap<K, V> map) {
				/* 
				 * convert HashMap to list, sort and restore to HashMap 
				 * Collections.sort() only takes list as input, so we need 
				 * to pass a list for sorting
				 */
				
				List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
				Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
					@Override
					public int compare(Map.Entry<K, V> obj1, Map.Entry<K, V> obj2) {
						return (obj2.getValue()).compareTo(obj1.getValue()); 	// Reverse Order
					}
				});
				
				//Reconstruct Hashmap 
				Map<K, V> tempMap = new LinkedHashMap<>();
				for(Map.Entry<K, V> entry : list) {
					tempMap.put(entry.getKey(), entry.getValue());
				}
				return tempMap;
			}
			
			public  static <K extends Comparable<? super K>, V>   Map<K, V> sortOnKey(HashMap<K, V> map) {
				/* convert HashMap to list, sort and restore to HashMap */
				
				List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
				Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
					@Override
					public int compare(Map.Entry<K, V> obj1, Map.Entry<K, V> obj2) {
						return (obj1.getKey()).compareTo(obj2.getKey()); 	
					}
				});
				
				//Reconstruct Hashmap 
				Map<K, V> tempMap = new LinkedHashMap<>();
				for(Map.Entry<K, V> entry : list) {
					tempMap.put(entry.getKey(), entry.getValue());
				}
				return tempMap;
			}	
		}
}
