public class MonObject implements MyInterface{

    public MonObject moiDirect()
    {
        return this;
    }

    public MyInterface moiParInterface()
    {
        return this;
    }
}
