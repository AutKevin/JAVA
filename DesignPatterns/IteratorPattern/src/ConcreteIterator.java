/**
 * 具体迭代器
 */
public class ConcreteIterator implements Iterator{
    private ConcreteAggregate agg;
    private int index = 0;    //下标
    private int size = 0;    //大小

    public ConcreteIterator(ConcreteAggregate agg) {
        this.agg = agg;
        size = agg.size();
        index = 0;
    }

    /**
     * 返回下一个元素
     */
    @Override
    public Object next() {
        if (index<size) {
            return agg.getElement(index++);
        }
        return null;
    }

    /**
     * 是否有下一个元素,即是否遍历结束
     */
    @Override
    public boolean hasNext() {
        return index<size;
    }
}
