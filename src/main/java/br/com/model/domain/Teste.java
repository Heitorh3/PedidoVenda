package br.com.model.domain;

public class Teste {

	public double getPreco(){
		return 10.45;
	}
	
	public double calcularPreco(int quantidade, double valorUnitario){
		return quantidade * valorUnitario;
	}
}
