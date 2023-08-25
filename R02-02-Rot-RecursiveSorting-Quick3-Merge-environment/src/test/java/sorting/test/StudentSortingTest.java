package sorting.test;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.divideAndConquer.MergeSort;
import sorting.divideAndConquer.QuickSort;
import sorting.divideAndConquer.hybridMergesort.HybridMergeSort;
import sorting.divideAndConquer.quicksort3.QuickSortMedianOfThree;


public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		// TODO O aluno deve instanciar sua implementação abaixo ao invés de
		// null
		this.implementation = new MergeSort<>();
		//Assert.fail("Implementation not provided");
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */

	 @Test
	 public void testBase(){
		Integer[] array  = new Integer[]{30, 28, 7, 29, 11, 26, 4, 22, 23, 31};
		implementation.sort(array, 0, array.length-1);
		Integer[] esperado = new Integer[]{4, 7, 11, 22, 23, 26, 28, 29, 30, 31};
		assertArrayEquals(esperado, array);
	 }

	 @Test
	 public void testBase2(){
		Integer[] array  = new Integer[]{11, 7, 4, 22};
		implementation.sort(array, 0, array.length-1);
		Integer[] esperado = new Integer[]{4, 7, 11, 22};
		assertArrayEquals(esperado, array);
	 }

	 @Test
	 public void testBase3(){
		Integer[] array  = new Integer[]{5, 4, 3, 2};
		implementation.sort(array, 0, array.length-1);
		Integer[] esperado = new Integer[]{2, 3, 4, 5};
		assertArrayEquals(esperado, array);
	 }

	 @Test
	 public void testArrayNull(){
		Integer[] array = new Integer[]{null};
		implementation.sort(array, 0, array.length-1);
		assertArrayEquals(array, array);
	 }

	 @Test
	 public void testLeftIndexInvalido(){
		Integer[] array  = new Integer[]{30, 28, 7, 29, 11, 26, 4, 22, 23, 31};
		implementation.sort(array, -1, array.length-1);
		assertArrayEquals(array, array);
	 }

	 @Test
	 public void testRightIndexInvalido(){
		Integer[] array  = new Integer[]{30, 28, 7, 29, 11, 26, 4, 22, 23, 31};
		implementation.sort(array, 0, array.length+1);
		assertArrayEquals(array, array);
	 }

	 @Test
	 public void testIndexInvalido(){
		Integer[] array  = new Integer[]{30, 28, 7, 29, 11, 26, 4, 22, 23, 31};
		implementation.sort(array, -1, array.length+1);
		assertArrayEquals(array, array);
	 }

	 @Test
	 public void testMetadeArray1(){
		Integer[] array  = new Integer[]{30, 28, 7, 29, 11, 26, 4, 22, 23, 31};
		Integer[] esperado  = new Integer[]{7, 11, 26, 28, 29, 30, 4, 22, 23, 31};
		implementation.sort(array, 0, array.length/2);
		assertArrayEquals(esperado, array);
	 }

	 @Test
	 public void testMetadeArray2(){
		Integer[] array  = new Integer[]{30, 28, 7, 29, 11, 26, 4, 22, 31, 23};
		Integer[] esperado  = new Integer[]{30, 28, 7, 29, 11, 4, 22, 23, 26, 31};
		implementation.sort(array, array.length/2, array.length-1);
		assertArrayEquals(esperado, array);
	 }
}