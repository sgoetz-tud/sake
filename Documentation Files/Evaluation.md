# Evaluation Step-by-Step

Some Grafics which show some sample output of the agent.

## 1. Configure a Simulation

At the main page of the GUI you can configure all information that SAKE could handle.

At first we configure the used map for the first test we choose the "Quadratic Map".

To get one simulation run which goes very fast we choose the second strategy "Complete controlling Master".

As number of agents we choose 7 "Explore Agents", 5 "Vacuum (Hoover) Agents" and 0 "Wiper Agents".

To see what the agents do we also activate the "PNG Save" to get an outcome of the local models of each agent and the "Graphical user interface" to see it in the GUI. 

If we deactivate the GUI the hole simulations runs faster but it is easier to locate bootle nacks at run times by seeing the moving of each agent.

For more runs at the same time it is possible to create an XML File like (Siafu-Sake-Simulator/Simulations/SAKE-Framework/Configuration/SimulationInformation.xml) and give it on start to the program. This will extract all configs from the file and run them after one another.

## 2. Start a Simulation

To start the simulation choose "Simulation->Open unpacked Simulation" and choose the File "simulations/SAKE-Framework-1.0.6-SNAPSHOT.jar". The simulations with the predefined configuration will start now.

## 3. Evaluation output data

As an outcome text files will be created in the result folder and png files in the dump/png folder. The picture show in this configuration tha only the master gets more data in his local model because the other agents only send their new information to the master and do not save it on their own.

In the result folder the measurement data about the energy consumption and needed time of each agent is saved. And one document has all information about each data exchange between two agents.

To reuse this information all data is saved in JSON format and could easily be read by a program to create diagram of specific values on the fly. The tool to do this is not well implemented actually but however could implement von every one on their own. 

## 4. Example output from more runs

Here you see some output diagrams of the overall needed time, energy consumption and knowledge exchange.

![Average number of timesteps on the hall map](/image/timesteps.jpg "Timesteps")
![Average energy consumption on the hall map](/image/energy.jpg "Energy Consumption")
![Average knowledge exchange on the hall map](/image/exchange.jpg "Knowledge Exchange")