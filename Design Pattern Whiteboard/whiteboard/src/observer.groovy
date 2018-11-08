package listener

class Event{
    String message

    Event(String m){
        this.message=m
    }
}

interface IObserver{
    def update(Event e)
}

interface IObserved{
    def notifyAll(Event e)
}

class TrucQuiEcoute implements IObserver{
    def update(Event e){
        println("Reception d'un message")
        println(">>"+e.message)
    }
}

class TrucQuiFait implements IObserved{
    List obs=new ArrayList<Observer>()

    def notifyAll(Event e) {
        for( Observer o in obs){
            o.update(e)
        }
    }

    def makeSomething() {
        def e = new Event("Ceci est le message")
        println("Envoie d'un message")
        this.notifyAll(e)
    }
}


def ob=new TrucQuiEcoute()
def obd=new TrucQuiFait()
obd.obs.add(ob)
obd.makeSomething()
