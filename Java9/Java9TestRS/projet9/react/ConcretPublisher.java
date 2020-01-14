package projet9.react;

import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.function.Consumer;

public class ConcretPublisher implements Publisher<String>,Consumer<String>{

	public Subscriber<String> arg0;

	@Override
	public void accept(String arg0) {
		this.arg0.onNext(arg0);
		
	}

	@Override
	public void subscribe(Subscriber<? super String> arg0) {
		this.arg0=(Subscriber<String>) arg0;
		
	}
}
