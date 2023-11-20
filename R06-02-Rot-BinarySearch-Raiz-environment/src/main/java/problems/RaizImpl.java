package problems;

/**
 * Classe com metodos para calcular raiz n-esima de um numero com aproximacao
 * e para encontrar os limites que dividem um array em 3 partes de mesmo tamanho
 * 
 * @author adalbertocajueiro
 *
 */
public class RaizImpl implements Raiz {
	public double raiz(int numero, int raiz, double erro){
		return buscaBinaria(0, numero, numero, raiz, erro);
	}
  
  	private double buscaBinaria(int left, int right, int num, int potencia, double erro){
  		int middle = (right+left)/2;
  		if (left < right){
  			double valor = calculaPotencia(middle, potencia);
  
  			if (valor == num){
  				return middle;
  			} else if ((valor >= num-calculaModulo(erro)) && (valor <= num+calculaModulo(erro))){
  				return middle;
  			} else if (valor > num){
  				return buscaBinaria(left, middle-1, num, potencia, erro);
  			} else {
  				return buscaBinaria(middle+1, right, num, potencia, erro);
  			}
  		}
  		return middle;
  	}
  
  	private double calculaModulo(double num){
  		if (num < 0){
  			return num*(-1);
  		} else {
  			return num;
  		}
  	}
  
  	private double calculaPotencia(double num, int potencia){
  		if (potencia == 0){
  			return 1;
  		} else if (potencia == 1){
  			return num;
  		} else {
  			potencia -= 1;
  			return num*calculaPotencia(num, potencia);
  		}
  	}
  }