# Related Work

The problem of a good simulation framework is that there must be a lot of possibilities to modify the simulator for new test case and give evaluation information as much and detailed output. There are existing much simulator for different specific scenario. For example, the SUMO [1] simulator simulate traffic in an urban area. SUMO can be used to test traffic light control algorithms to get the best light control system for a city. It takes therefor respect to traffic tips which can be controlled with characteristics. UdelModels [2] is another simulation framework for urban networks. It takes care on realistic propagation and gives a user interface for city creation. The OMNeT++ [3] simulation sweet includes different tool and simulates network protocols in varying areas.

For our simulator, we use Siafu [4] time simulation framework. Siafu provides random walk algorithms on a basic map and has a user interface to observe all agents with their actual states. Because of the open source code and its implementation in java we use it in our application. It is possible to easily change the map on which the agents work and we expand Siafu with a new robot architecture behind to simulate various arts of robots and algorithms.

There are although other simulators like Siafu for example JAS [5]. JAS is implemented in JAVA and gets his complete functional scope from third party libraries. It represents agents in components and brings a variety of collections from components and rules for the simulation.

For the knowledge exchange, different strategies could be used. For example, the FIPA [6] produces software specifications for multi-agent systems like communication protocols to maximize the compatibility of MAS. JADE [7] for example is a platform for peer-to-peer agent based applications. It describes a middleware which uses the FIPA specifications for the communication between agents. Therefor it provides a graphic tool and facilitate the troubleshooting and deployment phase of the system. The platform is implemented in JAVA and could be used to realize different kinds of agent architectures. In the background for the representation of an agent it uses containers. The commercial tool is JACK [8] which is although implemented in java. JACK is developed from the Agent Oriented Software Pty, Ltd. (AOS) and is a progression of the Procedural Reasoning System (PRS) and the Distributed Multi-Agent Reasoning System (dMARS). As JADE it helps to create MAS. Every agent works in JACK in accordance with the BDI (Belief, Desire and Intentions) principle, which say that every agent can be described with its goals, his knowledge and his social skills and acts from the environmental input.

For our simulator, we use only a simple information exchange based on the real data objects. To get a some various exchange strategies we look on the paper of G&ouml;tz et al. [9] where three different strategies are mentioned. This are the total exchange strategy where all agents collaborate with each other and exchange their complete knowledge. Then the partial complete method where each subsystem exchange his complete knowledge with his direct collaborators and the third strategy the partial-subset where the agents only change part of their own knowledge with her direct collaborators. These strategies give the template for our strategies and implementations.

Knowledge exchange is important in all kinds of MAS and is therefore often use in different ways. For example, DEECo [10], SeSaMe [11] and DECIDE [12] are frameworks to create multi agent systems. DEECo is self-named as an ensemble-based component system where an ensemble represents dynamic binding of a set of components and thus determines their composition and interaction. The ensemble component describes the collaboration and data connection. Although when only some data is used in the other component it proactive share all his information. SeSaMe coordinates distributed components in various self organizing inter-composed groups based on the types of roles they can play and make a direct interaction between the supervisors and followers. DECIDE splits the control-loops on many nodes of a distributed self-adaptive system. This gives more flexibility and reduces the single point error when a master node fail. The goal of DECIDE is to proof the system at runtime to guarantee the quality requirements of critical self-adaptive software.

## References

<table id="qs_table" border="0">
<tr id="sumo" class="entry">
	<td><b>[1]</b> Behrisch M, Bieker L, Erdmann J and Krajzewicz D (2011), <i>"SUMO--Simulation of Urban MObility"</i>, In The Third International Conference on Advances in System Simulation (SIMUL 2011), Barcelona, Spain. 
	</td>
</tr>
<tr id="udelmodels" class="entry">
	<td><b>[2]</b> Kim J, Sridhara V and Bohacek S (2009), <i>"Realistic mobility simulation of urban mesh networks"</i>, Ad Hoc Networks.  Vol. 7(2), pp. 411 - 430.
	</td>
</tr>
<tr id="omnet" class="entry">
	<td><b>[3]</b> Varga A and Hornig R (2008), <i>"An Overview of the OMNeT++ Simulation Environment"</i>, In Proceedings of the 1st International Conference on Simulation Tools and Techniques for Communications, Networks and Systems &amp; Workshops. ICST, Brussels, Belgium, Belgium , pp. 60:1-60:10. ICST (Institute for Computer Sciences, Social-Informatics and Telecommunications Engineering).
	</td>
</tr>
<tr id="Siafu" class="entry">
	<td><b>[4]</b> Martin M and Nurmi P (2006), <i>"A Generic Large Scale Simulator for Ubiquitous Computing"</i>, In Third Annual International Conference on Mobile and Ubiquitous Systems: Networking &amp; Services, 2006 (MobiQuitous 2006). San Jose, California, USA, July, 2006.  IEEE Computer Society.
	</td>
</tr>
<tr id="jas" class="entry">
	<td><b>[5]</b> Sonnessa M (2004), <i>"JAS: Java Agent-based Simulation Library, an Open Framework for Algorithm-Intensive Simulations"</i>, Industry and Labor Dynamics: The Agent-Based Computational Economics Approach, World Scientific, Singapore.
	</td>
</tr>
<tr id="fipa" class="entry">
	<td><b>[6]</b> Poslad S (2007), <i>"Specifying Protocols for Multi-agent Systems Interaction"</i>, ACM Trans. Auton. Adapt. Syst.. New York, NY, USA, November, 2007.  Vol. 2(4), pp. 15. ACM.
	</td>
</tr>
<tr id="jade" class="entry">
	<td><b>[7]</b> Bellifemine F, Poggi A and Rimassa G (1999), <i>"JADE--A FIPA-compliant agent framework"</i>, In Proceedings of PAAM.  Vol. 99(97-108), pp. 33.
	</td>
</tr>
<tr id="jack" class="entry">
	<td><b>[8]</b> Howden N, R&ouml;nnquist R, Hodgson A and Lucas A (2001), <i>"JACK intelligent agents-summary of an agent infrastructure"</i>, In 5th International conference on autonomous agents. 
	</td>
</tr>
<tr id="datenaustausch" class="entry">
	<td><b>[9]</b> G&ouml;tz S, Gerostathopoulos I, Krikava F, Shahzada A and Spalazzese R (2015), <i>"Adaptive Exchange of Distributed Partial Models@run.time for Highly Dynamic Systems"</i>, In Proceedings of 10th International Symposium on Software Engineering for Adaptive and Self-Managing Systems. Firenze, Italy, May, 2015. 
	</td>
</tr>
<tr id="deeco" class="entry">
	<td><b>[10]</b> Bures T, Gerostathopoulos I, Hnetynka P, Keznikl J, Kit M and Plasil F (2013), <i>"DEECO: An Ensemble-based Component System"</i>, In Proceedings of the 16th International ACM Sigsoft Symposium on Component-based Software Engineering. New York, NY, USA , pp. 81-90. ACM.
	</td>
</tr>
<tr id="sesame" class="entry">
	<td><b>[11]</b> Broekstra J, Kampman A and van Harmelen F (2002), <i>"Sesame: A Generic Architecture for Storing and Querying RDF and RDF Schema"</i>, In The Semantic Web — ISWC 2002.  Vol. 2342, pp. 54-68. Springer Berlin Heidelberg.
	</td>
</tr>
<tr id="decide2015" class="entry">
	<td><b>[12]</b> Calinescu R, Gerasimou S and Banks A (2015), <i>"Self-adaptive software with decentralised control loops"</i>, In Fundamental Approaches to Software Engineering. , pp. 235-251. Springer.
</tr>
</table>
