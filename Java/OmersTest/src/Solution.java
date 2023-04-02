import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String ar[]) {

		Solution sln = new Solution();
		
		System.out.println("Solution -"+sln.solution("photo.jpg, Warsaw, 2013-09-05 14:08:15\nJay.png, London, 2015-06-20 15:13:22\nmyFriends.png, Warsaw, 2013-09-05 14:07:13\nEiffel.jpg, Paris, 2015-07-23 08:03:02\npisatower.jpg, Paris, 2015-07-22 23:59:59\nBOB.jpg, London, 2015-08-05 00:02:03\nnotredame.png, Paris, 2015-09-01 12:00:00\nme.jpg, Warsaw, 2013-09-06 15:40:22\na.png, Warsaw, 2016-02-13 13:33:50\nb.jpg, Warsaw, 2016-01-02 15:12:22\nc.jpg, Warsaw, 2016-01-02 14:34:30\nd.jpg, Warsaw, 2016-01-02 15:15:01\ne.png, Warsaw, 2016-01-02 09:49:09\nf.png, Warsaw, 2016-01-02 10:55:32\ng.jpg, Warsaw, 2016-02-29 22:13:11"));
		


		
	}

	public String solution(String s) {
		String ret="";
		
		HashMap<Integer,String> map = new HashMap<Integer, String>();
		HashMap<String, Integer> loc = new HashMap<String, Integer>();
		HashMap<Integer,String> newmap = new HashMap<Integer, String>();
		HashMap<Date,String> newmapSorted = new HashMap<Date,String>();
		
		String[] split= s.split("\n");
		int i =0;
		for (String string : split) {
			String newName = "";
			int numOfPhotos = 0;
			
			System.out.println("------------------------");
			System.out.println("Processing ----"+string);
		
			map.put(i++, string);
			String[] commaSplit=string.split(",");
			String[] dotSplit=commaSplit[0].split("\\.");
			
			System.out.println(commaSplit[0]);
			System.out.println(commaSplit[2].trim());
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		
			
			Date date=new Date();
			try {
				date = df.parse(commaSplit[2].trim());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(date);
			
			
			
			if(loc.containsKey(commaSplit[1])){
				loc.put(commaSplit[1], loc.get(commaSplit[1])+1);
				
				System.out.println("----"+commaSplit[1]);
				System.out.println(numOfPhotos);
				
				numOfPhotos= loc.get(commaSplit[1]);
				System.out.println("----"+newName);
				
				newName= commaSplit[1]+numOfPhotos+"."+dotSplit[1];
				
			} else
			{
				loc.put(commaSplit[1], 1);
				newName= commaSplit[1]+1+"."+dotSplit[1];
			}
			
			System.out.println("New Name:"+newName);
			newmap.put(i, newName);
			newmapSorted.put(date,newName);
			
			System.out.println(map.toString());
			System.out.println(newmap.toString());
			System.out.println("Location ---"+loc.toString());
			
			
			
			
		}
		
		
		newmap.size();
		
		int ne=1;
		while(ne<=newmap.size()) {
			System.out.println(newmap.get(ne));
			int nw=1;
			
			Iterator<String> vl=newmapSorted.values().iterator();
			
			while (vl.hasNext()) {
				String string = (String) vl.next();
				
			
				newmapSorted.values();
				if(newmap.get(ne).equalsIgnoreCase(string)) {
					
				};
			}
			
			ret=ret.concat(newmap.get(ne)).concat("\n");
			ne++;
		}
		
		
		
			return ret;
	}
}
