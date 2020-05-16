package DataBase.TableModel;

public class Student {

	private int id;
	private String group_id;
	
	public Student(String group_id) {
		this.group_id = group_id;
	}
	
	public Student() { }
	
	public int getId() {return this.id; }
	public String getGroupId () { return this.group_id; };
	
	public void setId(int id) { this.id = id; }
	public void setGroupId(String group_id) { this.group_id = group_id; }
	
}
