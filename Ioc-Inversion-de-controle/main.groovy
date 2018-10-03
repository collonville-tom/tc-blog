class Voiture{

    Moteur moteur;

    def Voiture(Moteur m)
    {
        this.moteur=m;
    }

    def drive() {
        this.moteur.active()
        println("la voiture avance")
    }
}

abstract class Moteur{
    def abstract active()
}

class MoteurX extends Moteur{
    def active() {
        println("le moteur X tourne");
    }
}
class MoteurY extends Moteur{
    def active() {
        println("le moteur Y tourne");
    }
}

class MoteurFactory
{
    def buildMoteurX()
    {
        return new MoteurX()
    }

    def buildMoteurY()
    {
        return new MoteurY()
    }
}

class VoitureFactory
{
    MoteurFactory facto

    def VoitureFactory(MoteurFactory facto)
    {
        this.facto=facto
    }

    def buildWithMoteurX()
    {
        return new Voiture(this.facto.buildMoteurX())
    }

    def buildWithMoteurY()
    {
        return new Voiture(this.facto.buildMoteurY())
    }
}

class MetaFactory
{
    def buildFactoryForCar()
    {
        return new VoitureFactory(new MoteurFactory())
    }
}

def mf=new MetaFactory()

mf.buildFactoryForCar().buildWithMoteurX().drive()
mf.buildFactoryForCar().buildWithMoteurY().drive()
