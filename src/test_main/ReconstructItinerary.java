package test_main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ReconstructItinerary {
	Map<String, LinkedList<Ticket>> nodeMap = new HashMap<String, LinkedList<Ticket>>();
    List<String> order = new ArrayList<String>();
    int size = 0;
    public List<String> findItinerary(String[][] tickets) {
         size = tickets.length;
         for(String[] ss : tickets){
        	 if(!nodeMap.containsKey(ss[0])){
        		 nodeMap.put(ss[0], new LinkedList<Ticket>());
        	 }
        	 addTicket(nodeMap.get(ss[0]), new Ticket(ss[0], ss[1]));
		 }
         order.add("JFK");
         List<Ticket> list = nodeMap.get("JFK");
         if(list != null){
             for(Ticket t : list){
                 if(useTicket(t))
                	 break;
             }
         }
         return order;
     }
    
    public static void main(String[] args) {
    	String[][] tickets2 = {{"AXA","EZE"},{"EZE","AUA"},{"ADL","JFK"},{"ADL","TIA"},{"AUA","AXA"},{"EZE","TIA"},{"EZE","TIA"},{"AXA","EZE"},
   	    	 {"EZE","ADL"},{"ANU","EZE"},{"TIA","EZE"},{"JFK","ADL"},{"AUA","JFK"},{"JFK","EZE"},{"EZE","ANU"},{"ADL","AUA"},
   	    	 {"ANU","AXA"},{"AXA","ADL"},{"AUA","JFK"},{"EZE","ADL"},{"ANU","TIA"},{"AUA","JFK"},{"TIA","JFK"},{"EZE","AUA"},
   	    	 {"AXA","EZE"},{"AUA","ANU"},{"ADL","AXA"},{"EZE","ADL"},{"AUA","ANU"},{"AXA","EZE"},{"TIA","AUA"},{"AXA","EZE"},
   	    	 {"AUA","SYD"},{"ADL","JFK"},{"EZE","AUA"},{"ADL","ANU"},{"AUA","TIA"},{"ADL","EZE"},{"TIA","JFK"},{"AXA","ANU"},
   	    	 {"JFK","AXA"},{"JFK","ADL"},{"ADL","EZE"},{"AXA","TIA"},{"JFK","AUA"},{"ADL","EZE"},{"JFK","ADL"},{"ADL","AXA"},
   	    	 {"TIA","AUA"},{"AXA","JFK"},{"ADL","AUA"},{"TIA","JFK"},{"JFK","ADL"},{"JFK","ADL"},{"ANU","AXA"},{"TIA","AXA"},
   	    	 {"EZE","JFK"},{"EZE","AXA"},{"ADL","TIA"},{"JFK","AUA"},{"TIA","EZE"},{"EZE","ADL"},{"JFK","ANU"},{"TIA","AUA"},
   	    	 {"EZE","ADL"},{"ADL","JFK"},{"ANU","AXA"},{"AUA","AXA"},{"ANU","EZE"},{"ADL","AXA"},{"ANU","AXA"},{"TIA","ADL"},
   	    	 {"JFK","ADL"},{"JFK","TIA"},{"AUA","ADL"},{"AUA","TIA"},{"TIA","JFK"},{"EZE","JFK"},{"AUA","ADL"},{"ADL","AUA"},
   	    	 {"EZE","ANU"},{"ADL","ANU"},{"AUA","AXA"},{"AXA","TIA"},{"AXA","TIA"},{"ADL","AXA"},{"EZE","AXA"},{"AXA","JFK"},
   	    	 {"JFK","AUA"},{"ANU","ADL"},{"AXA","TIA"},{"ANU","AUA"},{"JFK","EZE"},{"AXA","ADL"},{"TIA","EZE"},{"JFK","AXA"},
   	    	 {"AXA","ADL"},{"EZE","AUA"},{"AXA","ANU"},{"ADL","EZE"},{"AUA","EZE"}};
    	String[][] tickets = {{"JFK","ADL"},{"ADL","JFK"},{"ADL","TIA"},{"TIA","EZE"},
   	 {"EZE","ADL"}};
		System.out.println(new ReconstructItinerary().findItinerary(tickets2));
	}

		private boolean useTicket(Ticket t) {
			if(t != null && !t.isUsed){
				t.isUsed = true;
				order.add(t.end);
				if(order.size() == size + 1)
					return true;
				List<Ticket> list = nodeMap.get(t.end);
				if(list != null){
					for(Ticket ticket : nodeMap.get(t.end)){
						if(useTicket(ticket)){
							return true;
						}
					}
				}
				t.isUsed = false;
				order.remove(order.size() - 1);
				return false;
			}
			return false;
		}

		private void addTicket(LinkedList<Ticket> list, Ticket ticket) {
			for(int i = 0; i < list.size(); i ++){
				Ticket t = list.get(i);
				if(t.compareTo(ticket) >= 0){
					list.add(i, ticket);
					return;
				}
			}
			list.addLast(ticket);
		}
	class Ticket implements Comparable<Ticket>{
		String start;
		String end;
		boolean isUsed;
		
		public Ticket(String start, String end){
			this.start = start;
			this.end = end;
			isUsed = false;
		}

		@Override
		public int compareTo(Ticket t) {
			return this.end.compareTo(t.end);
		}

	}
}
