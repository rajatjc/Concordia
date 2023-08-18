
public class Sample<T extends Object>
{
    private T data;

    public void setData(T newData){
        data = newData;
    }

    public T getData( )    {
        return data;
    }
}
