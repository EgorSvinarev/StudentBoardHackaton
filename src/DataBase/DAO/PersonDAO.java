package DataBase.DAO;

import java.sql.*;
import DataBase.DAO.DAO;
import DataBase.TableModel.Person;
import DataBase.TableModel.Student;

import java.util.HashMap;
import java.util.ArrayList;

public class PersonDAO extends DAO {

	public PersonDAO(Connection connection) {
		super(connection);
	}

	public PersonDAO() {
		super();
	}

	public void setNewEntry(Person person) {
		try {
			String sql = "INSERT INTO person (person_name, person_surname, person_gender) VALUES(?, ?, ?);";
			PreparedStatement statement = this.connection.prepareStatement(sql);
			
			statement.setString(1, person.getName());
			statement.setString(2, person.getSurname());
			statement.setString(3, person.getGender());
			
			statement.executeUpdate();
		}
		catch (Exception ex) {
			ex.fillInStackTrace();
			System.out.println(ex);
		}
	}
	
	public Person getEntryByPrimaryKey(int primaryKey) {
		Person person = null;
		try {
			String sql = "SELECT * FROM person WHERE id = ?";
			PreparedStatement statement = this.connection.prepareStatement(sql);
			
			statement.setInt(1, primaryKey);
			
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				person = new Person();
				person.setId(result.getInt("id"));
				person.setName(result.getString("name"));
				person.setSurname(result.getString("surname"));
				person.setGender(result.getString("gender"));
				person.setAge(result.getInt("age"));
				person.setTown(result.getString("town"));
			}
		}
		catch (Exception ex) {
			ex.fillInStackTrace();
			System.out.println(ex);
		}
		return person;
	}
	
	public Person[] getEntriesByArrayOfPrimaryKeys(int[] primaryKeys) {
		Person[] persons = null;
		try {
			String sql = "";
			if (primaryKeys.length > 0) {
				for (int i = 0; i < primaryKeys.length; i++) {
					if (i == 0) {
						sql = "SELECT * FROM student WHERE id = ?";
					}
					else {
						sql += " OR id = ?";
					}
				}
				sql += ";";
			}
			else {
				persons = new Person[0];
				return persons;
			}	
			PreparedStatement statement = this.connection.prepareStatement(sql);
			
			for (int i = 0; i < primaryKeys.length; i++) {
				statement.setInt(i + 1, primaryKeys[i]);
			}
			
			ResultSet result = statement.executeQuery();
			persons = new Person[primaryKeys.length];
			HashMap<Integer, Person> personsKey = new HashMap<>();
			
			while (result.next()) {
				Person person = new Person();
				person.setId(result.getInt("id"));
				person.setName(result.getString("name"));
				person.setSurname(result.getString("surname"));
				person.setGender(result.getString("gender"));
				person.setAge(result.getInt("age"));
				person.setTown(result.getString("town"));
				
				if (personsKey.get(person.getId()) == null) {
					personsKey.put(person.getId(), person);
				}
			}
			
			for (int i = 0; i < primaryKeys.length; i++) {
				persons[i] = personsKey.get(primaryKeys[i]);
			}
		}
		catch(Exception ex) {
			ex.fillInStackTrace();
			System.out.println(ex);
		}
		return persons;
	}
	
	public Person[] getEntriesByName(String name) {
		Person[] persons = null;
		try {
			String sql = "SELECT * FROM person WHERE name = ?;";
			
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, name);
			
			ResultSet result = statement.executeQuery();
			ArrayList<Person> personList = new ArrayList<>();
			
			while (result.next()) {
				Person person = new Person();
				person.setId(result.getInt("id"));
				person.setName(result.getString("name"));
				person.setSurname(result.getString("surname"));
				person.setGender(result.getString("gender"));
				person.setAge(result.getInt("age"));
				person.setTown(result.getString("town"));
				
				personList.add(person);
			}
			
			persons = new Person[personList.size()];
			for (int i = 0; i < persons.length; i++) {
				persons[i] = personList.get(i);
			}
		}
		catch (Exception ex) {
			ex.fillInStackTrace();
			System.out.println(ex);
		}
		return persons;
	}
	
	public Person[] getEntriesBySurname(String name) {
		Person[] persons = null;
		try {
			String sql = "SELECT * FROM person WHERE surname = ?;";
			
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, name);
			
			ResultSet result = statement.executeQuery();
			ArrayList<Person> personList = new ArrayList<>();
			
			while (result.next()) {
				Person person = new Person();
				person.setId(result.getInt("id"));
				person.setName(result.getString("name"));
				person.setSurname(result.getString("surname"));
				person.setGender(result.getString("gender"));
				person.setAge(result.getInt("age"));
				person.setTown(result.getString("town"));
				personList.add(person);
			}
			
			persons = new Person[personList.size()];
			for (int i = 0; i < persons.length; i++) {
				persons[i] = personList.get(i);
			}
		}
		catch (Exception ex) {
			ex.fillInStackTrace();
			System.out.println(ex);
		}
		return persons;
	}
	
	public Person[] getAllEntries() {
		Person[] persons = null;
		try {
			String sql = "SELECT * FROM person;";
			PreparedStatement statement = this.connection.prepareStatement(sql);
			
			ResultSet result = statement.executeQuery();
			ArrayList<Person> personsList = new ArrayList<>();
			while (result.next()) {
				Person person = new Person();
				person.setId(result.getInt("id"));
				person.setName(result.getString("name"));
				person.setSurname(result.getString("surname"));
				person.setGender(result.getString("gender"));
				person.setAge(result.getInt("age"));
				person.setTown(result.getString("town"));
				personsList.add(person);
			}
			persons = new Person[personsList.size()];
			
			for(int i = 0; i < persons.length; i++) {
				persons[i] = personsList.get(i);
			}
			
		}
		catch (Exception ex) {
			ex.fillInStackTrace();
			System.out.println(ex);
		}
		return persons;
	}
	
	public void updateEntryById(int id, Person person) {
		try {
			String sql = "UPDATE person SET name = ?, surname = ?, gender = ?, age = ?, town = ? WHERE id = ?";
			
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, person.getName());
			statement.setString(2, person.getSurname());
			statement.setString(3, person.getGender());
			statement.setInt(4, person.getAge());
			statement.setString(5, person.getTown());
			statement.setInt(6, person.getId());
			
			statement.executeUpdate();
		}
		catch (Exception ex) {
			ex.fillInStackTrace();
			System.out.println(ex);
		}
	}
	
}
