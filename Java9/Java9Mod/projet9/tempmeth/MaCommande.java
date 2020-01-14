package projet9.tempmeth;

public class MaCommande extends AbstractCommand {

	@Override
	protected void precond() {
		System.out.println("precond");
	}

	@Override
	protected void execute() {
		System.out.println("execute");
	}

	@Override
	protected void postcond() {
		System.out.println("postcond");
	}

}
