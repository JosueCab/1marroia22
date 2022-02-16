package dataAcess;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


import domain.ConcreteFlight;
import domain.Flight;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

public class Flight_objectdbAccess {
	private EntityManager db;
	private EntityManagerFactory emf;
	String fileName = "flight.odb";

	public Flight_objectdbAccess() {
		emf = Persistence.createEntityManagerFactory("objectdb:" + fileName);
		db = emf.createEntityManager();
		System.out.println("DataBase opened");
	}

	// klaseko datubase metodoak
	public void close() {
		db.close();
		System.out.println("DataBase closed");
	}

	public void storeFlight(String flightCode, String departingCity, String arrivingCity) {
		db.getTransaction().begin();
		Flight flight = new Flight(flightCode, departingCity, arrivingCity);
		db.persist(flight);
		db.getTransaction().commit();

		System.out.println("Gordeta " + flight);
	}

	public void getConcreteFlight(String departingCity, String arrivingCity, Date date) {
		ArrayList<String> res = new ArrayList<String>();
		TypedQuery<Flight> query = db.createQuery("SELECT f FROM Flight p WHERE  f.departingCity='" + departingCity + "'",
				Flight.class);

		List<Flight> flights = query.getResultList();
		System.out.println("Datu basearen edukia");
		for (Flight f : flights)
			res.add(f.toString());

	}

}
