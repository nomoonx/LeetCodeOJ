import java.util.*;

/**
 * Created by noMoon on 2016-02-10.
 */
public class ReconstructItinerary {

    public static void main(String[] args) {
//        System.out.println(findItinerary(new String[][]{{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}}));
//        System.out.println(findItinerary(new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}}));
//        System.out.println(findItinerary(new String[][]{{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}}));
        System.out.println(findItinerary(new String[][]{{"CBR","JFK"},{"TIA","EZE"},{"AUA","TIA"},{"JFK","EZE"},{"BNE","CBR"},{"JFK","CBR"},{"CBR","AUA"},{"EZE","HBA"},{"AXA","ANU"},{"BNE","EZE"},{"AXA","EZE"},{"AUA","ADL"},{"OOL","JFK"},{"BNE","AXA"},{"OOL","EZE"},{"EZE","ADL"},{"TIA","BNE"},{"EZE","TIA"},{"JFK","AUA"},{"AUA","EZE"},{"ANU","ADL"},{"TIA","BNE"},{"EZE","OOL"},{"ANU","BNE"},{"EZE","ANU"},{"ANU","AUA"},{"BNE","ANU"},{"CNS","JFK"},{"TIA","ADL"},{"ADL","AXA"},{"JFK","OOL"},{"AUA","ADL"},{"ADL","TIA"},{"ADL","ANU"},{"ADL","JFK"},{"BNE","EZE"},{"ANU","BNE"},{"JFK","BNE"},{"EZE","AUA"},{"EZE","AXA"},{"AUA","TIA"},{"ADL","CNS"},{"AXA","AUA"}}));





    }

    public static List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<String>();
        Set<String> airports = new HashSet<String>();
        Map<String, Integer> ticketMap = new HashMap<String, Integer>();

        for (String[] ticket : tickets) {
            String ticketCode = ticket[0] + ticket[1];
            if (ticketMap.containsKey(ticketCode)) {
                int num = ticketMap.get(ticketCode);
                num++;
                ticketMap.put(ticketCode, num);
            } else {
                ticketMap.put(ticketCode, 1);
            }
            airports.add(ticket[0]);
            airports.add(ticket[1]);
        }

        List<String> airportList = new ArrayList<String>();
        airportList.addAll(airports);
        Collections.sort(airportList);
        result.add("JFK");
        int current = 1;
        int[] itinerary = new int[tickets.length + 1];
        for (int i = 0; i < airportList.size(); i++) {
            if (airportList.get(i).equals("JFK")) {
                itinerary[0] = i;
                break;
            }
        }
        itinerary[current] = -1;
        while (current > 0 && current < tickets.length + 1) {
            itinerary[current]++;
            String tempTicketToken = "" ;
            if(itinerary[current] < airportList.size()){
                tempTicketToken=airportList.get(itinerary[current - 1]) + airportList.get(itinerary[current]);
            }
            while (!(ticketMap.containsKey(tempTicketToken) && ticketMap.get(tempTicketToken) > 0)&&(itinerary[current] < airportList.size())) {
                itinerary[current]++;
                if(itinerary[current] < airportList.size()){
                    tempTicketToken = airportList.get(itinerary[current - 1]) + airportList.get(itinerary[current]);
                }
            }
            if (itinerary[current] < airportList.size()) {
                int num = ticketMap.get(tempTicketToken);
                num--;
                ticketMap.put(tempTicketToken, num);
                current++;
                if(current<tickets.length+1){
                    itinerary[current]=-1;
                }
            } else {
                current--;
                if (current > 0) {
                    tempTicketToken = airportList.get(itinerary[current - 1]) + airportList.get(itinerary[current]);
                    if (ticketMap.containsKey(tempTicketToken)) {
                        int num = ticketMap.get(tempTicketToken);
                        num++;
                        ticketMap.put(tempTicketToken, num);
                    }
                }
            }
        }
        if (current == tickets.length+1) {
            for (int i = 1; i < tickets.length + 1; i++) {
                result.add(airportList.get(itinerary[i]));
            }
            return result;
        } else {
            return result;
        }

    }
}
