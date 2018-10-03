import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;




public class Neurone {

    public Double[] dendrites;
    private StringBuilder maeDescent=new StringBuilder("pente\t").append("biais\t").append("MAEpentre\t").append("maeBiais\n");
    private Double lastMAEPente=0.0;
    private Double lastMAEbiais=0.0;

    public Neurone(int inSize)
    {
        this.reset(inSize);
        System.out.println(this);
    }

    public void setParameter(Double v,Double b)
    {
        this.dendrites[0]=v;
        this.dendrites[1]=b;
    }


    public void reset(int inSize)
    {
        this.dendrites= Stream.generate(() -> Math.random()/1000).limit(inSize+1).toArray(Double[]::new);
    }

    public Double linearInfer(Double[] stepInputs)
    {
        Stream.Builder<Double> sum=Stream.<Double>builder();
        for(int i=0;i<dendrites.length;i++)
        {
            if(i<stepInputs.length)
                sum.add(dendrites[i]*stepInputs[i]);
            else
                sum.add(dendrites[i]);
        }
        Double result=sum.build().reduce((x,y)-> x+y).get();
        //System.out.println("resultat d'inference:\t"+result);
        return result;

    }

    public Double MAE(Set<Data> datasSet)
    {
        Double eccartAbsolue=datasSet.stream()
                .map(x ->x.input[0]*Math.abs( this.linearInfer(x.input)-(x.output)))
                .reduce((x,y) -> x+y).get();
        System.out.println("Calcul MAE : "+eccartAbsolue/datasSet.size());
        return eccartAbsolue/datasSet.size();
    }


    public Double MAEpente(Set<Data> datasSet)
    {
        Double eccartAbsolue=datasSet.stream()
                .map(x ->x.input[0]*( this.linearInfer(x.input)-(x.output)))
                .reduce((x,y) -> x+y).get();
        System.out.println("Calcul MAEpentre : "+eccartAbsolue/datasSet.size());
        return eccartAbsolue/datasSet.size();
    }

    public Double MAEbiais(Set<Data> datasSet)
    {
        Double eccartAbsolue=datasSet.stream()
                .map(x ->(  this.linearInfer(x.input)-(x.output)))
                .reduce((x,y) -> x+y).get();
        System.out.println("Calcul MAEbiais : "+eccartAbsolue/datasSet.size());
        return eccartAbsolue/datasSet.size();
    }

    private Double ammortissement=0.0001;//0.0003 c'est bien en mode corection direct ->


    public void learnStep(Set<Data> datasSet)
    {
        Double MAEpente=this.MAEpente(datasSet);
        Double MAEbiais=this.MAEbiais(datasSet);
        maeDescent.append(dendrites[0]).append("\t")
                .append(dendrites[1]).append("\t").append(MAEpente).append("\t").append(MAEbiais).append("\n");
        dendrites[0] = dendrites[0] - ammortissement*MAEpente;
        dendrites[1] = dendrites[1] - 1000*ammortissement*MAEbiais;// alors pourquoi on doit utiliser un amortissement different ici que sur l'entrée, probablement a cause de la difference de dimenssionnement
        ammortissement=ammortissement/1.01;
        System.out.println(this);
    }

    public StringBuilder getDescent()
    {
        return this.maeDescent;
    }

    public String toString()
    {
        StringBuilder b=new StringBuilder("Neurone(");
        for(int i=0;i<dendrites.length;i++)
        {
            b.append(dendrites[i]).append(",");
        }
        return b.append(")").toString();
    }





}
