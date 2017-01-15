# Configuration

We illustrate the results of our simulator based on a specific running example. Three different strategies are used to test and get comparable values for the evaluation. The easiest way is a complete collaboration between each agent. This mean that if an agent meet another agent he gives him his complete local model of the world. To get a higher hierarchical collaboration we use in the other strategies a master agent which handle the communication and makes work decisions.

The environment of the test-case scenario includes different parameters. For example, the size and the nature of the environment change in a different context. Otherwise the dependencies of agent types influence the result of each test-case. To get representative result in each test-case we run it five times and use the average values for the shown diagrams. 

The first part of this section contains the running example with different start parameters and agent dependencies and the used strategies. The last parts show the evaluation results based on the time measurement, the energy consumption and the knowledge exchange of a strategy in the different test case scenarios.  

## Running Example

Every company has different building with other structures and characteristics and must clean them every week. Therefor different agents can be used to clean the building after the offices hour. But they have every day the deadline, because they must be finished before the work starts in the morning. The easiest way is to use one agent which must do it alone but it could easily be that he does not finish in time. Then it is important that different agents share the work and communicate about the areas they already clean. Therefor we create three different strategies:

1. <b>Complete Collaboration</b>

  Every agent exchange his complete model with a near agent, but with a delay for not always exchange the local model (Configuration 1).

2. <b>Communication with Master</b>

  A master coordinate and handle the communication with near agents. The master stand at the load-station and exchange the models if the agents are loading. The agent creates his drive destinations on its own information. This approach reduces the local needed memory and minimize the knowledge exchange (Configuration 2). 

3. <b>Communication and Coordination with Master</b>

  The masters always communicate with the agents and say them always what to do. The working agent only need a communication structure and less logic (Configuration 3).

In figure 1 we show the different maps on which we test the three strategies. The centered points in the maps represent the load station and with it the location of the master agent. The first map represents only a big hall, where the probability that two agents met is very high. The second map is a labyrinth which is predefined in Siafu [1]. This is the biggest map we use with a lot of dead end and small ways. In figure 2 the last map represents a floor of the computer science faculty of the TU Dresden. It gives the best real world example with little rooms and big corridors that is why we only show the results from this map. The results of the other maps and agent types are shown in the master thesis [2]. In the maps, each white pixel represents a point which should be cleaned and the black walls show the borders.

<div class="image" align="center">
<img src="../DocumentationFiles/image/allcards.png" alt="The three test maps" title="Maps" style="width: 700px;"/>
<div><b>Fig1. - The three test maps.</b></div>
</div>

To create dependencies between the agent we use three different types of them. Before for example a hoover (vacuum) agent can clean the world he need a map of the area. To realize that a hierarchical structure is used. A master agent communicates with the explore agents about the world and exchange his knowledge with the hoover agents. This three-stage pyramid visualize the agent dependencies. The three steps of the cleaning process are now (a) create the map with explore agents, (b) hoover the area with (hoover) agents and (c) wipe the environment after hooving it with (wipe) agents. This step dependencies mean that every agent need parts of the information from a agent one step before to start with his work. This part brings waiting period for agents from a later step and have influence on the deadline.

<div class="image" align="center">
<img src="../DocumentationFiles/image/Roboterhierarchie.jpg" alt="Agent dependencies" title="Agent dependencies" style="width: 500px;"/>
<div><b>Fig2. - Agent dependencies.</b></div>
</div>

The number of agents influence the deadline too, because of that we decrease first the number of explore agents from one to ten and add then hoover agents and decrease them from one to ten too. This creates a comparable mass of data for conclusion.

## Save local Model

There are three different ways to save the local model of one agent. First a PNG image which represent the world. Second a CSV Document which shows the world the same way. And at least an XML file to show what Field has which state.

## References

<table id="qs_table" border="0">
<tr id="Siafu" class="entry">
	<td><b>[1]</b> Martin M and Nurmi P (2006), <i>"A Generic Large Scale Simulator for Ubiquitous Computing"</i>, In Third Annual International Conference on Mobile and Ubiquitous Systems: Networking &amp; Services, 2006 (MobiQuitous 2006). San Jose, California, USA, July, 2006.  IEEE Computer Society.
	</td>
</tr>
<tr id="W16" class="entry">
	<td><b>[2]</b> Werner C (2016), <i>"Adaptive Knowledge Exchange with Distributed Partial Models@Run.time"</i>. Thesis at: Technische Universit&auml;t Dresden., January, 2016. 	
	</td>
</tr>
</table>
