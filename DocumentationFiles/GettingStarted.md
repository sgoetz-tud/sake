# Getting Started Guide

This instruction shows the installation of the program and the output data of an example simulation.

## 1. Installation

For the start, you can decide between three installation methods. Either the start of the program from three pre-compiled jars, the download from GitHub and the installation on your own computer or start from a virtual machine with Ubuntu. 

### 1. Installation of Simulator from GitHub

1. Download the GitHub Repository as ZIP file or clone it from [https://github.com/sgoetz-tud/sake](https://github.com/sgoetz-tud/sake).

2. Pre-requisites:

   For the Simulator the installation of a Java Virtual Machine is important for example from [this page]   (http://www.oracle.com/technetwork/java/javase/downloads/index.html). And also a running installation of maven from [this page](http://maven.apache.org/).

3. Compiling Siafu and SAKE to simply run

		mvn package

   in the /Siafu-Sake-Simulator folder.
   If that gives you trouble, make sure mvn is in your PATH and that 
   JAVA_HOME is defined (more info at http://maven.apache.org/)

4. Once you've compiled Siafu and SAKE (with mvn package), simply go to the target folder (/Siafu-Sake-Simulator/target/Siafu-1.0.6-SNAPSHOT), where you'll find scripts to run Siafu and SAKE for each supported platform.

5. Start the Simulation Framework using the batch script for your platform.

### 2. Start the Simulator over the precompiled JARs

1. Download the GitHub Repository as ZIP or clone it from [https://github.com/sgoetz-tud/sake](https://github.com/sgoetz-tud/sake).

2. Open the folder (SiafuSakeSimulationRun) and start the script for your operating system.

### 3. Installation of the VM

1. Download the VM from [here](https://1drv.ms/u/s!Avb96pedgTo5hmLgI2yWZql-WwEC).

2. Install VirtualBox for example from [this page (virtualbox.org)](https://www.virtualbox.org/).

3. Import the VM into VirtualBox.

	<b>"Datei->Appliance import..."</b> 

   and choose the downloaded ova document (must be around 1.3GB).

4. Start the Virtual Machine.

5. The program starts automatically.

## 2. Evaluation Step-by-Step

Now the installation is finished and you could follow the [Step-by-Step Evaluation guide](md__documentation_files__evaluation.html "Step-by-Step Evaluation").
