import java.util.Vector;

/**
 * 具体聚集类
 */
public class ConcreteAggregate implements Aggregate {
    private Vector vector = new Vector();
    @Override
    public void add(Object obj) {
        this.vector.add(obj);
    }

    public Object getElement(int index){
        if (index < vector.size()){
            return vector.get(index);
        }else {
            return null;
        }
    }

    public int size(){
        return vector.size();
    }

    @Override
    public Iterator creatIterator() {
        return new ConcreteIterator(this);
    }
}
