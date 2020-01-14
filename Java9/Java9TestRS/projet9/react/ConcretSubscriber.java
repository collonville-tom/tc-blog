package projet9.react;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class ConcretSubscriber implements Subscriber<Integer>{

	@Override
	public void onComplete() {
		System.out.println("ConcretSubscriber Complete");
		
	}

	@Override
	public void onError(Throwable arg0) {
		arg0.printStackTrace();
		
	}



	@Override
	public void onSubscribe(Subscription arg0) {
		// TODO
		
	}

	@Override
	public void onNext(Integer arg0) {
		System.out.println("Vla ma valeur "+arg0);
		
	}

}
