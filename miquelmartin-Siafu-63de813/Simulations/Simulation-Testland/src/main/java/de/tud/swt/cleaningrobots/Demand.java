package de.tud.swt.cleaningrobots;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import de.tud.swt.cleaningrobots.exceptions.AgentHasNoSuchComponent;
import de.tud.swt.cleaningrobots.exceptions.AgentNumberOfComponentsFalse;
import de.tud.swt.cleaningrobots.exceptions.RuntimeErrorMessage;
import de.tud.swt.cleaningrobots.hardware.ComponentTypes;
import de.tud.swt.cleaningrobots.hardware.HardwareComponent;

/**
 * Contains the hardware components a behavior need to run.
 * 
 * @author Christopher Werner
 *
 */
public class Demand {

	private Map<ComponentTypes, Integer> hardware;
	private AgentCore robot;
	private List<HardwareComponent> hcList;
	private boolean correct;
	
	public Demand (AgentCore robotCore)
	{
		this.robot = robotCore;	
		this.correct = true;
		this.hardware = new EnumMap<ComponentTypes, Integer> (ComponentTypes.class);
		this.hcList = new ArrayList<HardwareComponent>();
	}
	
	/**
	 * Add the Number of Component Types.
	 * @param comp (Component Type which is needed.)
	 * @param value (Number of Components from this type.)
	 */
	public void addDemandPair (ComponentTypes comp, int value)
	{
		if (value <= 0)
		{
			throw new RuntimeErrorMessage("Number of Hardwarecomponent must be bigger than zero!");
		}
		else
		{
			Integer i = hardware.get(comp);
			if (i == null)
			{
				hardware.put(comp, value);
				for (HardwareComponent hc : robot.getHardwarecomponents()) {
					//add if it isn't in
					if (comp == hc.getComponentType() && !hcList.contains(hc))
					{
						hcList.add(hc);
						value--;
						if (value == 0)
							return;
					}
				}
			}
			else if (i < value) 
			{
				hardware.put(comp, value);
				value -= i;
				for (HardwareComponent hc : robot.getHardwarecomponents()) {
					//add if it isn't in
					if (comp == hc.getComponentType() && !hcList.contains(hc))
					{
						hcList.add(hc);
						value--;
						if (value == 0)
							return;
					}
				}
			}
			else
			{
				return;
			}
			this.correct = false;
			throw new AgentNumberOfComponentsFalse();
		}
	}
	
	/**
	 * Add a hardware component with this name.
	 * @param name
	 */
	public void addHardwareComponentWithName (String name)
	{
		for (HardwareComponent hc : robot.getHardwarecomponents()) {
			//add if it isn't in
			if (hc.getName().equals(name) && !hcList.contains(hc))
			{
				if (!hcList.contains(hc))
				{
					hcList.add(hc);
					Integer i = hardware.get(hc.getComponentType());
					if (i == null)
					{
						hardware.put(hc.getComponentType(), 1);
					}
					else
					{
						i++;
						hardware.put(hc.getComponentType(), i);
					}
					return;
				}
				else
				{
					return;
				}
			}
		}
		this.correct = false;
		throw new AgentHasNoSuchComponent(name);
	}
	
	/**
	 * Get a hardware component with this name.
	 * @param name
	 * @return
	 */
	public HardwareComponent getHardwareComponentFromName (String name)
	{
		for (HardwareComponent hc : this.hcList) {
			if (hc.getName().equals(name))
			{
				return hc;
			}
		}
		return null;
	}
	
	/**
	 * Get hardware component form the component type.
	 * @param comp
	 * @return
	 */
	public HardwareComponent getHardwareComponent (ComponentTypes comp)
	{
		for (HardwareComponent hc : this.hcList) {
			if (hc.getComponentType() == comp)
			{
				return hc;
			}
		}
		return null;
	}
	
	/**
	 * Switch all components on.
	 */
	public void switchAllOn ()
	{
		for (HardwareComponent hc : this.hcList)
		{
			hc.switchOn();
		}
	}
	
	/**
	 * Switch all components off.
	 */
	public void switchAllOff ()
	{
		for (HardwareComponent hc : this.hcList)
		{
			hc.switchOff();
		}
	}

	/**
	 * Agent has all neede components.
	 * @return
	 */
	public boolean isCorrect() {
		return this.correct;
	}
	
	
}
