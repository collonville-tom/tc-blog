import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestNeurone {

    public static void main(String[] args) {
        //neurStreamMethodSimple();
        neurStreamMethodBruite();

    }

    private static void neurStreamMethodSimple()
    {

        Neurone n=new Neurone(1);
        Set<Data> dataSet=getSimpleModel(-100.0,20.0, 30.0);
        //Set<Data>  dataSet=getBruiteModel(-100.0,20.0, 30.0);
        generateMaeMap(n,dataSet);
        n.reset(1);
        apprentissage(n,dataSet);

    }

    private static void neurStreamMethodBruite()
    {

        Neurone n=new Neurone(1);
        Set<Data>  dataSet=getSimpleModel(-100.0,20.0, 30.0);
        //Set<Data>  dataSet=getBruiteModel(-100.0,20.0, 30.0);
        generateMaeMap(n,dataSet);
        n.reset(1);
        apprentissage(n,dataSet);

    }

    private static void  toData2File(String path,Set<Data> datas)
    {
        File f= Paths.get(path).toFile();
        if(f.exists())
            f.delete();
        try(PrintWriter writer=new PrintWriter(Files.newBufferedWriter(Paths.get(path), StandardCharsets.UTF_8)))
        {
            f.createNewFile();
            writer.println("output\tinput");
            datas.stream().forEach(x-> writer.println(x.toPandas()));
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private static void saveResult(String path,StringBuilder b)
    {
        File f= Paths.get(path).toFile();
        if(f.exists())
            f.delete();
        try(BufferedWriter writer=Files.newBufferedWriter(Paths.get(path), StandardCharsets.UTF_8))
        {
            f.createNewFile();
            writer.write(b.toString(),0,b.length());
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static Set<Data> getSimpleModel(Double initValue,Double pente,Double ori)
    {
        Set<Data> dataSet= Stream.iterate(initValue, x -> x+1).limit(200)
                .map(x->new Data(Stream.<Double>builder().add(x).build().toArray(Double[]::new),pente*x+ori))
                .collect(Collectors.toSet());

        toData2File("out/learnSet.csv",dataSet);
        return dataSet;
    }

    public static Set<Data> getBruiteModel(Double initValue,Double pente,Double ori)
    {
        Supplier<Double> bruit=() -> (Math.random()-0.5)*200;
        Set<Data> dataSet=Stream.iterate(initValue,x -> x+1).limit(200)
                .map(x->new Data(Stream.<Double>builder().add(x).build().toArray(Double[]::new),(pente*x+ori)+bruit.get()))
                .collect(Collectors.toSet());

        toData2File("out/learnSet.csv",dataSet);
        return dataSet;
    }



    public static void apprentissage(Neurone n,Set<Data>  dataSet)
    {
        System.out.println("Phase d'apprentissage");
        Double eccart=Double.MAX_VALUE;
        //n.setParameter(-40.0,-40.0); // ca c'est si on souhaite donner des valeur de depart specifique et non aleatoire
        int iteration=0;
        StringBuilder mae=new StringBuilder("pente\t").append("biais").append("\t").append("maeEvol").append("\n");
        while(eccart> 0.001 && iteration <100000)
        {
            System.out.println("Iteration:"+iteration++);
            n.learnStep(dataSet);
            eccart=Math.abs(n.MAE(dataSet));
            mae.append(n.dendrites[0]).append("\t").append(n.dendrites[1]).append("\t").append(eccart).append("\n");
        }

        saveResult("out/maeDerEvol.csv",n.getDescent());
        saveResult("out/maeEvol.csv",mae);
    }





    public static void generateMaeMap(Neurone n,Set<Data>  dataSet)
    {
        StringBuilder maeMap=new StringBuilder();
        maeMap.append("pente").append("\t");
        maeMap.append("bias").append("\t");
        maeMap.append("maePente").append("\t");
        maeMap.append("maebiais").append("\t");
        maeMap.append("mae").append("\n");
        for(int i=-50;i<50;i++)
        {
            for(int j=-50;j<50;j++)
            {
                n.setParameter(Double.valueOf(i),Double.valueOf(j));
                Double maePente=n.MAEpente(dataSet);
                Double maebiais=n.MAEbiais(dataSet);
                Double mae=n.MAE(dataSet);
                maeMap.append(i).append("\t");
                maeMap.append(j).append("\t");
                maeMap.append(Math.abs(maePente)).append("\t");
                maeMap.append(Math.abs(maebiais)).append("\t");
                maeMap.append(Math.abs(mae)).append("\n");
            }
        }
        saveResult("out/maeMap.csv",maeMap);
    }


}
