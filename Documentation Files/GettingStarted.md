# Getting Started Guide {#labelid}

This instruction shows the installation of the programm and the output data of an excample simulation.

## 1. Installation

For the start you can decide between two installation methods. Either the start of the program from a virtual machine or the download from Github and the installation on your own computer.

### 1. Installation of the VM

1. Download the VM from [hier](http://example.net/).
2. Install VirtualBox for example from [this page](http://example.net/).
3. Import the VM into VirtualBox.
   Datei->Appliance import... and choose the downloaded ova document (must be around 2GB).
4. Start the Virtual Machine
5. Run the sake-simulator.bh document on the desktop.

Now go to step 2.

### 2. Installation of Simulator from Github

1. Download the Github Repository as ZIP or clone it.
2. Pre-requisites:
   For the Simulator the installation of a Java Virtual Machine ist important for example from [this page](http://example.net/). And although a running installation from maven for example from [hier](http://maven.apache.org/).
3. Compiling Siafu and SAKE to simply run
	mvn package
   in the /.../.../.. folder.
   If that gives you trouble, make sure mvn is in your PATH and that 
   JAVA_HOME is defined (more info at http://maven.apache.org/)
4. Once you've compiled Siafu and SAKE (with mvn package), simply go to the target
   folder, where you'll find a Siafu-<version_number>. In there, there are
   scripts to run Siafu and SAKE for each supported platform.
5. Start the Simulation Framework using the batch script for your platform.

## 2. Simulation run

## 3. Evaluation output data



3. First steps
==============================
In the same folder where the compiled Siafu is, you will find also
a collection of example simulations. Try one out!

- Start Siafu using the batch script for your platform
- Go to the "Simulation" menu, then "Open Packed Simulation"
- Locate and load a simulation in the "simulations" folder where you
  compiled Siafu (e.g. Simulation-Leimen-<version>.jar
 
Have fun! Make sure to read the tutorial to get you started creating
your own simulation. You'll find it here:
http://siafusimulator.org/tutorial/1.html

\tableofcontents

## Installation

## Start

## Configure Simulation

## Show output raw data

> Blockquotes
> multiple lines

0  if ok
>1 if not

- Item 1

  Itemtext

- Item 2
 + nested list item
 + another item

- item 3

1. First item.
2. Second item.

	Code Block

--------

single asterisks*
_single underscores_
double asterisks**
__double underscores__


[The link text](http://example.net/)
[The link text](http://example.net/ "Link title")
[The link text](/relative/path/to/index.html "Link title")
[The link text](somefile.html)



[The link text](@ref MyClass)

![Caption text](/path/to/img.jpg "Image title")

[Link text](@ref labelid)