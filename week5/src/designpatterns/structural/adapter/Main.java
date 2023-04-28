package designpatterns.structural.adapter;

/*
 * we have an existing object which provides the functionality 
 *	that client needs. But client code can't use this object because 
 *	it expects an object with different interface
 *	eg: input stream reader and output streamwriter 
 * pitfall: two adapter type has both methods of adaptee and target which 
 * is basically code pollution. Which may lead to using both classes 
 * methods alternatively which is not desired
 */
public class Main {

	public static void main(String[] args) {
		/** Using Class/Two-way adapter **/ 
		EmployeeClassAdapter adapter  = new EmployeeClassAdapter();
		populateEmployeeData(adapter);
		BusinessCardDesigner designer = new BusinessCardDesigner();
		String card  = designer.designCard(adapter);
		System.out.println(card);
		
		System.out.println("************************************************************");
		/** Using Object Adapter **/
		Employee employee = new Employee();
		populateEmployeeData(employee);
		EmployeeObjectAdapter objectAdapter = new EmployeeObjectAdapter(employee); 
		card = designer.designCard(objectAdapter);
		System.out.println(card);
	}

	private static void populateEmployeeData(Employee employee) {
		employee.setFullName("vishnu vinoth");
		employee.setJobTitle("Software Engineer");
		employee.setOfficeLocation("Bangalore");
	}
}
