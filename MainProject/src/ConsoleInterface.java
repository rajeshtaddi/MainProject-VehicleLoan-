import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleInterface {
	public static void main(String[] args) {
		
		Customer.takeInput();
	}
}
class Customer{
	
	static ArrayList<String> userNameList=new ArrayList<String>();
	static ArrayList<String> passWordList=new ArrayList<String>();
	static int count=0;
	private String name;
	private String userName;
	private String passWord;
	public Customer(){}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public static void takeInput() {
		Scanner scan =new Scanner(System.in);
		System.out.println("             ");
		System.out.println("---------------WELCOME FOR VEHICLE LOAN SYSTEM-------------");
		System.out.println("             ");
		System.out.println("Enter 1 for new user to SignUp :");
		System.out.println("Enter 2 for existing user to LogIn:");
		Customer cust=new Customer();
		int option=scan.nextInt();
		if(option==1) {
			Scanner scanner =new Scanner(System.in);
			System.out.println("---------CREATE ACCOUNT--------");
			System.out.println("Enter the Name to Register :");
			String nameOfCustomer=scanner.nextLine();
			System.out.println("Enter the UserName :");
			String newUserName=scanner.nextLine();
			System.out.println("Enter the new PassWord :");
			String newPassWord=scanner.nextLine();
			System.out.println("Account is created Succesfully");
			cust.name=nameOfCustomer;
			cust.passWord=newPassWord;
			cust.userName=newUserName;
			userNameList.add(newUserName);
			passWordList.add(newPassWord);
			Eligibilty obj1=new Eligibilty();
			Application obj2=obj1.fillApplication(cust);
			System.out.println(obj2.toString());
			
			if(obj1.checkEligibility(obj2)==true) {
				System.out.println("Loan is Granted");
			}
			else {
				System.out.println("Loan is not granted ");
			}
		}
		else if(option==2) {
		
			System.out.println("----------LOG IN-------------");
			Scanner scanner =new Scanner(System.in);
			System.out.println("Enter the UserName :");
			String userName=scanner.nextLine();
			System.out.println("Enter the PassWord :");
			String passWord=scanner.nextLine();
			if(userNameList.contains(userName)&&passWordList.contains(passWord))
			{
				System.out.println("You are Logged In Succesful :");
				System.out.println("--------------------------");
				Eligibilty obj1=new Eligibilty();
				Application obj2=obj1.fillApplication(cust);
				System.out.println(obj2.toString());
				if(obj1.checkEligibility(obj2)==true) {
					System.out.println("Loan is Granted");
				}
				else {
					System.out.println("Loan is not granted ");
				}
	
			}
			else {
				System.out.println("You Entered wrong UserId and Password :");
				takeInput();
			}
			
		}
		else {
			System.out.println("You Entered the Incorrect Option...!");
			System.out.println("Please Enter the Correct Option :");
			takeInput();
		}
	}
	
}
class Application{
	
	private String name;
	private int age;
	private String gender;
	private int yearlySalary;
	private int existingEMIs;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getYearlySalary() {
		return yearlySalary;
	}
	public void setYearlySalary(int yearlySalary) {
		this.yearlySalary = yearlySalary;
	}
	public int getExistingEMIs() {
		return existingEMIs;
	}
	public void setExistingEMIs(int existingEMI) {
		this.existingEMIs = existingEMI;
	}
	@Override
	public String toString() {
		return "Application [name=" + name + ", age=" + age + ", gender=" + gender + ", yearlySalary=" + yearlySalary
				+ ", existingEMIs=" + existingEMIs + "]";
	}
	
	
	
}
class Eligibilty{
	
	Application fillApplication(Customer obj) {
		Application app=new Application();
		//app.name=obj.getName();
		System.out.println("-----------------------");
		System.out.println("Filling Application");
		Scanner scann =new Scanner(System.in);
		app.setName(obj.getName());
		System.out.println("Enter the Age :");
		int ageOfCustomer=scann.nextInt();
		scann.nextLine();
		app.setAge(ageOfCustomer);
		System.out.println("Enter the Gender :");
		String genderOfCustomer=scann.nextLine();
		app.setGender(genderOfCustomer);
		System.out.println("Enter your Yearly Salary :");
		int salary=scann.nextInt();
		app.setYearlySalary(salary);
		System.out.println("Enter the number of EMIs you have previously :");
		int emi=scann.nextInt();
		app.setExistingEMIs(emi);
		
		return app;
	}
	boolean checkEligibility(Application obj) {
		if(obj.getExistingEMIs()>=1) {
			return false;
		}
		else if(obj.getYearlySalary()<50000) {
			return false;
		}
		else
		{
			return true;
		}
	}
}
