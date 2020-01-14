package projet9.react;

import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class ConcretProcessor implements Processor<String,Integer>{

	private Subscriber<? super Integer> arg0;
	
	@Override
	public void onComplete() {
		System.out.println("Processor Complete");
		
	}

	@Override
	public void onError(Throwable arg0) {
		arg0.printStackTrace();
		
	}

	@Override
	public void onNext(String arg0) {
		System.out.println("On passe la main apres avoir string to int");
		this.arg0.onNext(Integer.parseInt(arg0));
	}

	@Override
	public void onSubscribe(Subscription arg0) {
		// TODO
	}


	@Override
	public void subscribe(Subscriber<? super Integer> arg0) {
		this.arg0=arg0;
		
	}

}
