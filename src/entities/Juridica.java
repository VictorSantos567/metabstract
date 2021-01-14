package entities;

public class Juridica extends Pessoa {
	private int numeroFuncionarios;

	public Juridica() {
	}

	public Juridica(String nome, Double rendaAnual, int numeroFuncionarios) {
		super(nome, rendaAnual);
		this.setNumeroFuncionarios(numeroFuncionarios);
	}

	public int getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(int numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}

	@Override
	public double imposto() {
		double taxa;
		if (numeroFuncionarios > 10) {
			taxa = super.getRendaAnual() * 0.14;
		} else {
			taxa = super.getRendaAnual() * 16;
		}

		return taxa;
	}

	@Override
	public String toString() {
		return super.getNome() + ": $ " + String.format("%.2f", imposto());
	}

}
