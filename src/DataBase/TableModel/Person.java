package DataBase.TableModel;

public class Person {

	private int id;
	private String name;
	private String surname;
	private String gender;
	private int age;
	private String town;
	
	public Person(String name, String surname, String gender, int age, String town) {
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.age = age;
		this.town = town;
	}
	
	public Person() { }
	
	public int getId() {return this.id; }
	public String getName() { return this.name; }
	public String getSurname() { return this.surname; }
	public String getGender() { return this.gender; }
	public int getAge() { return this.age; }
	public String getTown() { return this.town; }
	
	public void setId(int id) { this.id = id; }
	public void setName(String name) { this.name = name; }
	public void setSurname(String surname) { this.surname = surname; }
	public void setGender(String gender) { this.gender = gender; }
	public void setAge(int age) { this.age = age; }
	public void setTown(String town) { this.town = town; }
	
}
