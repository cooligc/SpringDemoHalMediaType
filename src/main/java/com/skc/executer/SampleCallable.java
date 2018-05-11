/**
 * 
 */
package com.skc.executer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author chaudhsi
 *
 */
public class SampleCallable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13);
		
		List<Callable<Integer>> result= new ArrayList<Callable<Integer>>();
		
		//boolean isDone = false;
		
		ExecutorService executerService = Executors.newScheduledThreadPool(5);

		
		for (int i = 0; i < 3; i++) {
			Callable<Integer> call = new MyIntegerSumCallable(numbers, i*4, i*4);
			result.add(call);
		}
		
		List<Future<Integer>> result2 = executerService.invokeAll(result);
		 
		
		int sum = 0;
		for (Future<Integer> future : result2) {
			if(future.isDone()) {
				System.out.println("Wait....");
			}
			sum+= future.get();
		}
		
		System.out.println("My result ===> "+sum);
		
		
	}
	
	
}

class MyIntegerSumCallable implements Callable<Integer>{
	
	private List<Integer> numbers;
	private int index = 0;
	private int times = 0;
	
	public MyIntegerSumCallable(List<Integer> number, int index,int times) {
		this.numbers = number;
		this.index = index;
		this.times = times;
	}
	
	@Override
	public Integer call() throws Exception {
		int sum = 0;
		System.out.println("index "+index);
		for (int i = index,j=0; j < times; i++, ++j) {
			System.out.println("i Value "+i);
			sum += numbers.get(i);
			System.out.println("SUM => "+sum);
		}
		
		return sum;
	}
}
