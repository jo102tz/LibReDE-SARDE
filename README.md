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

In addition, when using the development environment, make sure that the Eclipse version you are using has the [Eclipse Modeling Framework (EMF)](https://www.eclipse.org/modeling/emf/), [Maven](https://maven.apache.org/), and the [Rich Client Platform (RCP)](https://wiki.eclipse.org/Rich_Client_Platform) installed. 
You can use the [User Guide](https://se.informatik.uni-wuerzburg.de/fileadmin/10030200/user_upload/librede/LibReDE_UserGuide_01.pdf) to help with installation, and to verify that the installation is working correctly. 

### Prerequisites

For the proper execution of SARDE, a few Prerequisites are required.

- [LibReDE](http://descartes.tools/librede) at least version 1.1 required. (however we recommend that you check out the current development branch).
- [An R interpreter](https://www.r-project.org/) version 3.3 or higher. Make sure, that both R and your Java version are 64-Bit installations (or both 32-Bit). Furthermore, ensure that both Java and the R interpreter are added to the PATH of your system. Furthermore, install the `rJava` package for the R installation. (SARDE works with [rJava](https://www.rforge.net/rJava/), which enables the optimization engine to run R scripts.)

### Installation

1. Download the source code from [GitLab](https://gitlab2.informatik.uni-wuerzburg.de/descartes/librede-rrde) and integrate it into eclipse.
2. Make sure that all dependent packages (including LibReDE) can be found, by switching the target build platform to the `Librede Update Site`.
3. Define the application runtime: 
    1. If not running a 64-Bit version, add `-Dos.name=win32` as argument to the JVM.
    2. Link R, the downloaded JRI package, and the JRE binary in the `PATH` as environment variable to the JVM. 
    3. Furthermore, link the path to the R installation as `R_HOME` as environment variable to the JVM. 

If you are having troubles with running rJava, check out [this website](http://www.studytrails.com/rjava-eclipse-plugin/rjava-eclipse-plugin/) for troubleshooting.

## Using and Executing SARDE
Once SARDE is successfully installed, there are multiple ways to execute.
You can call SARDE programmatically via Java, or just execute from console.
However, it is recommended to execute SARDE from within Eclipse, as both Librede and SARDE come with nice graphical editors to create or update  configurations and execute the estimation.
However, we first need test data for execution and a valid configuration.

### Input Data
As SARDE is relying on the LibReDE framework, the system measurements follow the same interface as standard LibReDE. 

Therefore, we need a set of monitoring traces together with a valid LibReDE configuration in order to execute a standard estimation.

1. Monitoring traces: The monitoring data must be available as time series data with associated timestampsfor each sample. The library can work on time series with individual events (e.g., arrival times and response times of individual requests) or on fixed sampled time-aggregated data (e.g., average response times or average throughput).  If the input data consists of time series with individual events, the library automatically computes the required time-aggregated data.
2. Configuration: The configuration defines six different estimation properties: workload description, data sources, traces, estimation approaches, validation, and output specifications. More details on the required specification can be found in the [User Guide](https://se.informatik.uni-wuerzburg.de/fileadmin/10030200/user_upload/librede/LibReDE_UserGuide_01.pdf).

An example of such measurements can be downloaded [here](https://bitbucket.org/librede/librede/downloads/LibredeExamples.zip).

### Configuration

### Execution

Once SARDE is successfully installed, there are multiple ways to execute.
You can call SARDE programmatically via Java, or just execute from console.
However, 
