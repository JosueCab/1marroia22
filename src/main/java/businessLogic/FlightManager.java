package businessLogic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import dataAcess.Flight_objectdbAccess;
import domain.ConcreteFlight;
import domain.Flight;

public class FlightManager implements FlightManagerInterface{
ArrayList<Flight> flightsDB;

//		public FlightManager () {
//			flightsDB = new ArrayList<Flight>();
//			
//			Flight f1 = new Flight("F1","Donostia","Bilbo");
//			
//			f1.addConcreteFlight("CF1",newDate(2022,1,22),1,2,3,"12:00");
//			f1.addConcreteFlight("CF2",newDate(2022,1,23),3,0,3,"12:00");
//			f1.addConcreteFlight("CF3",newDate(2022,1,23),1,2,2,"13:00");
//			f1.addConcreteFlight("CF4",newDate(2022,1,23),3,3,0,"14:00");
//			f1.addConcreteFlight("CF5",newDate(2022,1,23),3,3,0,"15:00");
//			f1.addConcreteFlight("CF6",newDate(2022,1,23),3,3,0,"16:00");
//			f1.addConcreteFlight("CF7",newDate(2022,1,23),3,3,0,"17:00");
//																								
//			
//			Flight f2 = new Flight("F2","Bilbo","Donostia");
//			f2.addConcreteFlight("CF1",newDate(2022,1,21),3,3,0,"12:00");
//			f2.addConcreteFlight("CF2",newDate(2022,1,22),3,3,0,"12:00");
//			f2.addConcreteFlight("CF3",newDate(2022,1,23),3,3,0,"12:00");
//
//			
//			flightsDB.add(f1);	
//			flightsDB.add(f2);		
//			
//		}
	
	 public static void main(String[] args) { 
		 Flight_objectdbAccess flight_dataMng=new Flight_objectdbAccess(); 
		 flight_dataMng.storeFlight("F1","Donostia","Bilbo"); 
		 flight_dataMng.close(); 
	  }
	
		public Collection<ConcreteFlight> getConcreteFlights(String departingCity, String arrivingCity, Date date) {
				ArrayList<ConcreteFlight> res = new ArrayList<ConcreteFlight>();
				for (Flight a : flightsDB) {
					if ((a.getArrivingCity().equals(arrivingCity))&&(a.getDepartingCity().equals(departingCity)))
						for (ConcreteFlight c : a.getConcreteFlights())
							if (c.getDate().equals(date)) res.add(c);
							
				}
				return res;
				
				
		}
		

		private Date newDate(int year,int month,int day) {

		     Calendar calendar = Calendar.getInstance();
		     calendar.set(year, month, day,0,0,0);
		     calendar.set(Calendar.MILLISECOND, 0);

		     return calendar.getTime();
		}
		
		
}
