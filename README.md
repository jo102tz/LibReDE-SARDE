# Self-adaptive Resource Demand Estimation (SARDE) Framework

This is the repository for the Self-adaptive Resource Demand Estimation (SARDE) framework. SARDE enables continuous resource demand estimations, while constantly adapting and optimizing its used estimators.
SARDE is designed as an AddOn to the classic [LibReDE](http://descartes.tools/librede) library. 
Therefore, the project name `librede-rrde` stands for Reliable Resource Demand Estimation AddOn for LibReDE.

For more information, please refer to the official website: [LibReDE](http://descartes.tools/librede)

The tool is currently under submission at ACM Transactions on Autonomous and Adaptive Systems (TaaS). 
Some results can also be viewed on the respective [Code Ocean Capsule](https://doi.org/10.24433/CO.8429465.v1), providing a one-click reproducability of the presented results.

## Setting up SARDE

### System Requirements 

As SARDE is an AddOn to the main project [LibReDE](http://descartes.tools/librede), similar restrictions apply to its use.

- Operation System: Windows 10 or higher 32-bit or 64-bit, Linux 64-bit required. (MacOS X and Linux32-bit are currently not supported)
- Java Runtime Environment: at least 1.8. (on Linux only 64-bit version supported)
- Eclipse: Eclipse Standard 4.4 or higher. (download from [here](http://www.eclipse.org/downloads/))
- Fortran: On Linux, please ensure that the library `gfortran` is installed. On Windows, Librede comes with its own version.

In addition, when using the development environment, make sure that the Eclipse version you are using has the [Eclipse Modeling Framework (EMF)](https://www.eclipse.org/modeling/emf/), and the [Rich Client Platform (RCP)](https://wiki.eclipse.org/Rich_Client_Platform) installed. 
You can use the [User Guide](https://se.informatik.uni-wuerzburg.de/fileadmin/10030200/user_upload/librede/LibReDE_UserGuide_01.pdf) to help with installation, and to verify that the installation is working correctly. 

### Prerequisites

For the proper execution of SARDE, a few Prerequisites are required.

- [LibReDE](http://descartes.tools/librede) at least version 1.1 required. (however we recommend that you check out the current development branch).
- [An R interpreter](https://www.r-project.org/) version 3.3 or higher. Make sure, that both R and your Java version are 64-Bit installations (or both 32-Bit). Furthermore, ensure that both Java and the R interpreter are added to the PATH of your system. (SARDE comes with [rJava](https://www.rforge.net/rJava/), which enables the optimization engine to run R scripts.)

Just add R_HOME with the Path to the R installation on the system (e.g. C:\Program Files\R\R-3.3.1) and PATH with the path to the libraries (e.g. C:\Program Files\R\R-3.3.1\bin\x64;C:\Program Files\Java\jre1.8.0_77\bin\server;C:\Users\Johannes Grohmann\git\ma\tools.descartes.librede.rrde.rinterface\lib;C:\Users\Johannes Grohmann\git\ma\tools.descartes.librede.rrde.rinterface\R\win-library\3.3\rJava\jri\x64) to the EnvironmentVariables in the RunConfiguration

### Installation

Download the source code from [GitLab](https://gitlab2.informatik.uni-wuerzburg.de/descartes/librede-rrde). 

## Using and Executing SARDE

### Input Data

### Configuration

### Execution
