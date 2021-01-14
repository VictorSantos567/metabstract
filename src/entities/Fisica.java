package entities;

public class Fisica extends Pessoa {
	private double gastosSaude;

	public Fisica() {
	}

	public Fisica(String nome, Double rendaAnual, double gastosSaude) {
		super(nome, rendaAnual);
		this.setGastosSaude(gastosSaude);
	}

	public double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}

	@Override
	public double imposto() {

		if (getRendaAnual() < 20000) {
			return getRendaAnual() * 0.15 - gastosSaude * 0.5;
		} else {
			return getRendaAnual() * 0.25 - gastosSaude * 0.5;
		}

	}

	@Override
	public String toString() {
		return super.getNome() + ": $ " + String.format("%.2f", imposto());
	}

}
