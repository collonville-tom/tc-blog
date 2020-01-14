package projet9.tempmeth;

public abstract class AbstractCommand {

	protected abstract void precond();
	protected abstract void execute();
	protected abstract void postcond();
	
	public final void operate()
	{
		this.precond();
		this.execute();
		this.postcond();
	}
	
}
