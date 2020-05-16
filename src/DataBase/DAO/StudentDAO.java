package DataBase.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import DataBase.TableModel.Person;
import DataBase.TableModel.Student;
import DataBase.DAO.DAO;
import java.util.HashMap;
import java.util.ArrayList;

public class StudentDAO extends DAO{

	public StudentDAO(Connection connection) {
		super(connection);
	}

	public StudentDAO() {
		super();
	}
	
	public void setNewEntry(Student student) {
		try {
			String sql = "INSERT INTO student (id, group_id) VALUES(?, ?);";
			PreparedStatement statement = this.connection.prepareStatement(sql);
			
			statement.setInt(1, student.getId());
			statement.setString(2, student.getGroupId());
			
			statement.executeUpdate();
		}
		catch (Exception ex) {
			ex.fillInStackTrace();
			System.out.println(ex);
		}
	}
	
	public Student getEntryByPrimaryKey(int primaryKey) {
		Student student = null;
		try {
			String sql = "SELECT * FROM student WHERE id = ?";
			PreparedStatement statement = this.connection.prepareStatement(sql);
			
			statement.setInt(1, primaryKey);
			
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				student = new Student();
				student.setId(result.getInt("id"));
				student.setGroupId(result.getString("group_id"));
			}
		}
		catch (Exception ex) {
			ex.fillInStackTrace();
			System.out.println(ex);
		}
		return student;
	}
	
	public Student[] getEntriesByArrayOfPrimaryKeys(int[] primaryKeys) {
		Student[] students = null;
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
				students = new Student[0];
				return students;
			}	
			PreparedStatement statement = this.connection.prepareStatement(sql);
			
			for (int i = 0; i < primaryKeys.length; i++) {
				statement.setInt(i + 1, primaryKeys[i]);
			}
			
			ResultSet result = statement.executeQuery();
			students = new Student[primaryKeys.length];
			HashMap<Integer, Student> studentKey = new HashMap<>();
			
			while (result.next()) {
				Student student = new Student();
				student.setId(result.getInt("id"));
				student.setGroupId(result.getString("group_id"));
				
				if (studentKey.get(student.getId()) == null) {
					studentKey.put(student.getId(), student);
				}
			}
			
			for (int i = 0; i < primaryKeys.length; i++) {
				students[i] = studentKey.get(primaryKeys[i]);
			}
		}
		catch(Exception ex) {
			ex.fillInStackTrace();
			System.out.println(ex);
		}
		return students;
	}
	
	public Student[] getAllEntries() {
		Student[] students = null;
		try {
			String sql = "SELECT * FROM person;";
			PreparedStatement statement = this.connection.prepareStatement(sql);
			
			ResultSet result = statement.executeQuery();
			ArrayList<Student> studentsList = new ArrayList<>();
			while (result.next()) {
				Student student = new Student();
				student.setId(result.getInt("id"));
				student.setGroupId(result.getString("group_id"));
				studentsList.add(student);
			}
			
			students = new Student[studentsList.size()];
			for (int i = 0; i < students.length; i++) {
				students[i] = studentsList.get(i);
			}
			
		}
		catch (Exception ex) {
			ex.fillInStackTrace();
			System.out.println(ex);
		}
		return students;
	}
	
}
