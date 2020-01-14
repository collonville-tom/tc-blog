package projet9.main;

import java.util.List;

import projet9.react.ConcretProcessor;
import projet9.react.ConcretPublisher;
import projet9.react.ConcretSubscriber;

public class Main {

	public static void main(String[] args) {
		
		ConcretPublisher concretPublisher= new ConcretPublisher();
		ConcretSubscriber concretSubscriber=new ConcretSubscriber();
		ConcretProcessor concretProcessor=new ConcretProcessor();
		
		concretPublisher.subscribe(concretProcessor);
		concretProcessor.subscribe(concretSubscriber);
		
		List<String> items = List.of("1", "2", "3", "4", "5", "6");
		items.forEach(concretPublisher);
		

	}

}
