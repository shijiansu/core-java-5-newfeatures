package tarena.day13_collection.compare;

public class Student implements Comparable<Object>{
	private String name;
	private int age;
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String toString(){
		return name+":"+age;
	}
	public int hashCode(){
		System.out.println("hashCode:"+name);
		return 1;
	}
	
	public boolean equals(Object o){
		if(o==null){
			return false;
		}
		if(this==o){
			return true;
		}
		if(!(o instanceof Student)){
			return false;
		}
		Student s = (Student)o;
		System.out.println(s.getName()+".equals("+name+")");
		if(s.getName().equals(this.name)&&s.getAge()==this.age){
			return true;
		}
		return false;
	}
	public int compareTo(Object o) {
		Student s = (Student)o;
		if(age>s.getAge()){
			return 1;
		}else if(age<s.getAge()){
			return -1;
		}
		return 0;
	}
	
}
