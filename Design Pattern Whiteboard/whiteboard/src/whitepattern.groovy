package whiteboard

interface IService{
    def serve(Event e)
}

class ServiceRegister{
    Map services=new HashMap<String,IService>()
}

class Event{
    String message

    Event(String m){
        this.message=m
    }
}

class TrucQuiEcoute implements IService{
    def serve(Event e){
        println("Reception d'un message")
        println(">>"+e.message)
    }
}

class TrucQuiFait implements IService{
    ServiceRegister register;

    TrucQuiFait(ServiceRegister register)
    {
        this.register=register;
    }

    def serve(Event serviceNameEvent) {
        def e = new Event("Ceci est le message")
        println("Envoie d'un message")
        this.register.services.get(serviceNameEvent.getMessage()).serve(e)
    }
}

def reg=new ServiceRegister()
reg.services.put("TrucQuiEcoute",new TrucQuiEcoute())
reg.services.put("TrucQuiFait",new TrucQuiFait(reg))

reg.services.get("TrucQuiFait").serve(new Event("TrucQuiEcoute"))