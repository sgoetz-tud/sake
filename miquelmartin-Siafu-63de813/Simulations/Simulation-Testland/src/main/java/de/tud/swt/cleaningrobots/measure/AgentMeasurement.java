/**
 * Measurement classes and evaluation classes to process the out JSON information.
 */
package de.tud.swt.cleaningrobots.measure;

import java.util.LinkedList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import de.tud.swt.evaluation.EvaluationConstants;

/**
 * Measurement information about an agent for one complete test case.
 * 
 * @author Christopher Werner
 *
 */
public class AgentMeasurement {
	
	@SerializedName("MemoryConsumption")
	public int memory;	
	@SerializedName("AgentName")
	public String name;	
	@SerializedName("BenchmarkTime")
	public long benchmarkTime;
	
	@SerializedName("CompleteEnergyConsumption")
	public double completeEnergie;
	@SerializedName("CompleteIterations")
	public int completeTicks;
	@SerializedName("CompleteTime")
	public double completeTime;
	
	@SerializedName("WattHourPerIteration")
	public List<Double> energieProTick;
	@SerializedName("NanoSecondsPerIteration")
	public List<Double> timeProTick;
	
	public AgentMeasurement (String name) {
		this.name = name;
		energieProTick = new LinkedList<Double>();
		timeProTick = new LinkedList<Double>();
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public AgentMeasurement fromJson(String json) {
        return EvaluationConstants.gson.fromJson(json, AgentMeasurement.class);
    }

	public String toJson() {
        return EvaluationConstants.gson.toJson(this);
    }	
}
