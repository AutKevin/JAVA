import com.demo.impl.ConcreteCompany;
import com.demo.impl.Employee;
import com.demo.inf.Company;


public class DemoClient {
	public static void main(String[] args) {
		//CEO
		ConcreteCompany root = new ConcreteCompany("李彦宏", "男", "CEO", 1000000);
		//部门经理
		ConcreteCompany developDep = new ConcreteCompany("郑亮", "男", "研发部经理", 9999999);
		ConcreteCompany salesDep = new ConcreteCompany("逍遥", "男", "销售部经理", 8888888);
		ConcreteCompany financeDep = new ConcreteCompany("小颖", "女", "财务不经理", 6666666);
		//部门员工
		Employee e1 = new Employee("程序甲", "男", "java开发工程师", 10000);
		Employee e2 = new Employee("素材乙", "女", "素材师", 8888);
		Employee e3 = new Employee("UI丙", "男", "UI设计师", 8888);
		Employee e4 = new Employee("销售员甲", "男", "销售员", 6666);
		Employee e5 = new Employee("销售员乙", "男", "销售员", 6666);
		Employee e6 = new Employee("会计甲", "男", "会计", 5000);
		//生成树
		root.add(developDep);
		root.add(salesDep);
		root.add(financeDep);
		developDep.add(e1);
		developDep.add(e2);
		developDep.add(e3);
		salesDep.add(e4);
		salesDep.add(e5);
		financeDep.add(e6);
		//递归树
		display(root);
	}
	//遍历树(递归)
	public static void display(ConcreteCompany root){
		for (Company c:root.getChild()) {
			if (c instanceof Employee) {
				System.out.println(c.getInfo());
			}else {    //树枝节点
				System.out.println("\n"+c.getInfo());
				display((ConcreteCompany) c);
			}
		}
	} 
	
}
