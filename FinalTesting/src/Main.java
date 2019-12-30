import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		//System.out.println("Please type: "+"\n"+"URL Keyword:");
		//Scanner sc = new Scanner(System.in);
		//while(sc.hasNextLine()){
		 //  String urlStr = sc.next();
		 // String keyword = sc.next();
		   
		 //   WordCounter counter = new WordCounter(urlStr);
		//  System.out.println(counter.countKeyword(keyword));
		   
		   
		   
		   WebPage rootPage = new WebPage("https://www.nba.com/?34", "NBA.com");		
			WebTree tree = new WebTree(rootPage);
					
			tree.root.addChild(new WebNode(new WebPage("https://www.nba.com/?34", "NBA.com")));
			tree.root.children.get(0).addChild(new WebNode(new WebPage("https://www.nba.com/news","NBA News")));
			tree.root.children.get(0).addChild(new WebNode(new WebPage("https://www.nba.com/scores#/","NBA scores")));				
			tree.root.addChild(new WebNode(new WebPage("https://www.espn.com/nba/","ESPN NBA")));
			tree.root.children.get(1).addChild(new WebNode(new WebPage("https://www.espn.com/nba/stats","ESPN NBA Stat")));
			Scanner scanner = new Scanner(System.in);
			while(scanner.hasNextLine()){
				//int numOfKeywords = scanner.nextInt();
				int numOfKeywords = 1;
				ArrayList<Keyword> keywords = new ArrayList<Keyword>();
				
				for(int i =0;i<numOfKeywords;i++)
				{
					//String name = scanner.next();
					String name = scanner.next();
					//String name2 = scanner.next();
					//double weight = scanner.nextDouble();
					double weight=3;
					//Keyword k = new Keyword(name, weight);
					//double weight = scanner.nextDouble();
					Keyword k = new Keyword(name, weight);
					//Keyword k2 = new Keyword(name2, 2);
					keywords.add(k);
					//keywords.add(k2);
				}
				/*for(int i =0;i<numOfKeywords;i++)
				{
					String name = scanner.next();
					double weight = scanner.nextDouble();
					Keyword k = new Keyword(name, weight);
					//double weight = scanner.nextDouble();
					keywords.add(k);
					
				}*/
				
				tree.setPostOrderScore(keywords);
				tree.eularPrintTree();
			}
			scanner.close();
		   
		}
	}
//}
