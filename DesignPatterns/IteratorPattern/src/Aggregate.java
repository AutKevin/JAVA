/**
 * 聚集类接口
 */
public interface Aggregate {
    public void add(Object obj);
    public Iterator creatIterator();
}
