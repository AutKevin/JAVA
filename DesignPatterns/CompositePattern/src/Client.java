import com.qy.impl.Composite;
import com.qy.impl.Leaf;
import com.qy.inf.Component;

/**
 * 调用 
 */
public class Client {

	public static void main(String[] args) {
		//创建一个跟节点
		Composite root = new Composite();
		root.operation();
		//创建树枝节点
		Composite branch = new Composite();
		//创建叶子节点
		Leaf leaf = new Leaf();
		//创建树形结构
		root.add(branch);
		branch.add(leaf);
		
		display(root);
	}
	
	//遍历树(递归)
	public static void display(Composite root){
		for (Component c:root.getChild()) {
			if (c instanceof Leaf) {    //如果节点类型是叶子节点
				c.operation();
			}else {    //树枝节点
				c.operation();
				display((Composite)c);
			}
		}
	}
}
