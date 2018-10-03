import java.util.Arrays;

public class Data {

    public Double[] input;
    public Double output;


    public Data(Double[] input,Double output)
    {
        this.input=input;
        this.output=output;

    }

    public String toPandas()
    {
        StringBuilder b=new StringBuilder(String.valueOf(output));
        Arrays.stream(input).forEach(x -> b.append("\t").append(String.valueOf(x)));
        return b.toString();
    }
}
