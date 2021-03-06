/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lucxor;

import java.util.concurrent.Callable;
import org.apache.commons.math3.util.FastMath;


/**
 *
 * @author dfermin
 */


public class NormalDensityWorkerThread implements Callable<Double>{
	
	private double[] ary;
	private double tic;
	private double bw;
	private final double NORMAL_CONSTANT = 1.0 / Math.sqrt(2.0 * Math.PI);

	
	public NormalDensityWorkerThread(double[] dataAry, double tic_, double bandWidth) {
		this.ary = dataAry;
		this.bw = bandWidth;
		this.tic = tic_;
	}
		
	
	@Override
	public Double call() throws Exception {
		double sum = 0;
		double x = 0;
		
		for(double d : ary) {
			x = (tic - d) / this.bw;
			sum += NORMAL_CONSTANT * FastMath.exp( (-0.5 * x * x) );
		}
		
		return sum;
	}
	
}
