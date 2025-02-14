package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import adt.stack.StackOverflowException;

public class StudentQueueTest {

	public Queue<Integer> queue1;
	public Queue<Integer> queue2;
	public Queue<Integer> queue3;

	@Before
	public void setUp() throws QueueOverflowException {

		getImplementations();

		// Fila com 3 elementos não cheia.
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);

		// Fila com 2 elementos de tamanho 2. Fila cheia.
		queue2.enqueue(1);
		queue2.enqueue(2);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		queue1 = new CircularQueue<>(4);
		queue2 = new CircularQueue<>(2);
		queue3 = new CircularQueue<>(1);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testHead() {
		assertEquals(new Integer(1), queue1.head());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(queue1.isEmpty());
		assertTrue(queue3.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(queue1.isFull());
	}

	@Test
	public void testEnqueue() {
		try {
			queue1.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro() throws QueueOverflowException {
		queue2.enqueue(new Integer(5)); // vai depender do tamanho que a fila
										// foi iniciada!!!
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(new Integer(1), queue3.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComErro() throws QueueUnderflowException {
		assertEquals(new Integer(1), queue3.dequeue()); // vai depender do
														// tamanho que a fial
														// foi iniciada!!!
	}

	@Test
	public void testEmptyTrue(){
		assertTrue(queue3.isEmpty());
	}

	@Test
	public void testEmptyFalse(){
		assertFalse(queue1.isEmpty());
	}

	@Test
	public void testFullTrue(){
		assertTrue(queue2.isFull());
	}

	@Test
	public void testFullFalse(){
		assertFalse(queue1.isFull());
	}

	@Test
	public void testHeadNormal(){
		assertEquals(new Integer(1), queue1.head());
	}

	@Test
	public void testHeadFull(){
		assertEquals(new Integer(1), queue2.head());
	}

	@Test
	public void testHeadEmpty(){
		assertEquals(null, queue3.head());
	}

	@Test
	public void testHeadShift(){
		try {
			queue1.dequeue();
			assertEquals(new Integer(2), queue1.head());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Test
	public void testEnqueueNormal(){
		try {
			queue1.enqueue(4);
			assertTrue(queue1.isFull());
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test (expected = QueueOverflowException.class)
	public void testEnqueueFull() throws QueueOverflowException {
		queue2.enqueue(3);
	}

	@Test
	public void testEnqueueEmpty(){
		try {
			queue3.enqueue(1);
			assertEquals(new Integer(1), queue3.head());
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testEnqueueNull(){
		try {
			queue1.enqueue(null);
			assertFalse(queue1.isFull());
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDequeueNormal(){
		try {
			assertEquals(new Integer(1), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDequeueFull(){
		try {
			assertEquals(new Integer(1), queue2.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test (expected = QueueUnderflowException.class)
	public void testDequeueEmpty() throws QueueUnderflowException {
		queue3.dequeue();
	}
}