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

3. The execution of SARDE required an instance of a LifeCycleConfiguration model. The details on how to configure SARDE are explained later in more detail. An example LifeCycleConfiguration can be found [here](/tools.descartes.librede.rrde/resources/test/validation/lifecycle/tstore/tstore.lifecycle).


### Execution

You can call SARDE by calling the `startLifeCycle(LifeCycleConfiguration lifeCycleConfiguration, LibredeConfiguration libredeConfiguration, LibredeConfiguration allConf, String logFolder)` method in the `tools.descartes.librede.rrde.lifecycle.LifeCycleController` class.
This methods starts the online estimation and learning cycle. It requires the life cycle configuration to execute, the librede Configuration to execute, the configuration containing all estimation approaches used for caching, as well as a folder to log intermediate information file to.

Alternatively you could use any test classes from the `tools.descartes.librede.rrde.eval` packages, or just start the application in standard mode  application via `tools.descartes.librede.rrde.Plugin.start(IApplicationContext context)`.

## Configuration
SARDE relies on EMF models to define run configurations for executions. The respective meta-model definition can be found [here](/tools.descartes.librede.rrde.model/model/lifecycle.ecore).



















### OptimizationConfiguration

The main class `OptimizationConfiguration` serves as a container for one or several `RunCall` instances. 
Each of those instances represent one specific optimization run.
Several `RunCall`s can be executed consecutively in order to use several equal or different algorithms in a row if required. 
One RunCall is composed of four key configuration elements: The `EstimationSpecification` to optimize, the `OptimizationSettings` to determine parameters for the optimization, the `TrainingData` to specify the training set and the `ConfigurationOptimizationAlgorithmSpecifier` to define the used algorithm and its parameters. 
The following image visualizes the meta-model graphically.

![OptimizationConfiguration](/tools.descartes.librede.rrde/resources/docs/optimization.png)

#### 1. `EstimationSpecification` 

First, an existing `EstimationSpecification` for a LibReDE configuration file has to be specified. 
This configuration will be altered in the configuration process and the returning result will be an `EstimationSpecification` with optimized values. 
For the lack of space, a detailed description of the different elements of one `EstimationSpecification` is omitted here, we refer to the [LibReDE User Guide](https://se.informatik.uni-wuerzburg.de/fileadmin/10030200/user_upload/librede/LibReDE_UserGuide_01.pdf).

#### 2. `OptimizationSettings`

The optimization is configured by the `OptimizationSettings`. 
Next to the `ValidationSpecification` which contains information on how the results should be validated, the `OptimizationSettings` contain a list of `IOptimizableParameter`.

This list contains information about the parameters which should be optimized during the process. 
The interface `IOptimizableParameter` defines key information which is crucial for the optimization algorithm, such as the minimum value `lowerBound`, the maximum value `upperBound` and a default value or `startValue`.
The `startValue` defines where the algorithm should start the exploration and might be ignored by the executing algorithm. 
All implementing classes contain particulars about the specific parameter itself. 

Instances of `StepSize` and `WindowSize` in the list `parametersToOptimize` for example specify that the step size and the window size are subject to optimization.
Now, each instance contains information about lower and upper bounds as well as a start value for the given parameter. 

Similarly a `GenericParameter` contains a reference to a `Parameter` object of the LibReDE configuration, ideally already specified in the given `EstimationSpecification`.


#### 3. `TrainingData`
The optimization is performed on the so called trainingData set which is composed of different instances of `InputData`. 
One `InputData` instance contains a `WorkloadDescription` and an `InputSpecification`. 
Both classes are again referenced from the standard LibReDE configuration and they, together with the given `EstimationSpecification` and the `ValidationSpecification` defined in the `OptimizationSettings`, are used to compose a set of LibReDE configuration files which can then be executed and evaluated.

The string parameter `rootFolder` defines the location of the traces.
Starting in the root folder, the directory is recursively scanned for folders that match the given `InputSpecification` and `WorkloadDescription`.
If one is found, a LibReDE configuration is created and its `InputSpecification` is properly adapted to match the found file paths. 
The `Boolean` parameter `multiFolderStructes` defines, if the single files of one trace might be spread among different folders themselves. 
This is appropriate for more complex `WorkloadDescriptions`, but the default setting is false.

Several `InputData` objects can be included and form the training set together. 
This way, training on a variety of different `WorkloadDescriptions` can be done at once. 

#### 4. `ConfigurationOptimizationAlgorithmSpecifier`
Finally, every `RunCall` needs to contain a `ConfigurationOptimizationAlgorithmSpecifier`. 
Here, the actual algorithm used for optimization is chosen and configured. 

All of the algorithms do have an `algorithmName` which contains the fully qualified class name of the algorithm as string and a `timeOut` value qualifying the maximum number of milliseconds the algorithm should use for computation. 
This number is not binding, however, and no algorithm is obligated to terminate within the given bounds. 
The default value of `-1` corresponds to unlimited execution time.

All algorithms implementing the `IConfigurationOptimizer` interface in the `tools.descartes.librede.rrde.optimization.algorithm` package can be used as algorithms by inserting the fully qualified class name in the `algorithmName` parameter.
However, since inheriting specifiers define different specific parameters for special types of algorithms, the chosen algorithm must accept the actual sub-class of `ConfigurationOptimizationAlgorithmSpecifier`. 

The method `isSpecifierSupported(ConfigurationOptimizationAlgorithmSpecifier)` returns true, if the algorithm can support the `ConfigurationOptimizationAlgorithmSpecifier`, i.e. interpret the given parameters, and false otherwise. 
Similarly, if the algorithm needs a more specific `ConfigurationOptimizationAlgorithmSpecifier` with more parameters, it also returns false.

As of now, the tool currently supports three types of algorithms. 
All of them define their own specifier inheriting from `ConfigurationOptimizationAlgorithmSpecifier`.

An instance of `LocalSearchSpecifier` defines the solution tolerance as the `tolerance` Double, the maximum number of steps per iteration as a long value named `maximumNumberOfSteps`, and the step size to be used as a Double value named `stepSize`. 
The `LocalSearchSpecifier` is currently used by a set of our local search implementations.
The brute force approach also requires an instance of `LocalSearchSpecifier`, but ignores all parameters but `stepSize`.

The class `IterativeParameterOptimizationAlgorithm` implements the Stepwise Sampling Search (S3). 
It requires the three Integer parameters `numberOfSplits`, `numberOfExplorations`, and `numberOfIterations` as the number of splits done in each iteration, the number of exploration points to store at once and the number of iterations to perform in total, which can be specified using the `IterativeParameterOptimizerSpecifier`.

The third sub-classing specifier is called `DataExportSpecifier` and it can be used for algorithms, exporting different kinds of information about the traces and their optimization into a folder configured by the String `outputDirectory`. 
We used this specifier for some algorithms exporting the behavior of the traces for further manual analysis. 
The Double parameter `stepSize` defines the resolution of the exported traces, while the two Boolean parameters `multidimensional` and `splitConfigurations` define the aggregation level of the export algorithms, i.e., if multiple dimensions and configurations should be plotted individually or aggregated and averaged for the export.

All RunCalls return one - or many, since the given `EstimationSpecification` might be split up at some point during the optimization - optimized `EstimationSpecification`.
The results of all `RunCalls` are aggregated and form the output of the total `OptimizationConfiguration`.














## Project Overview

Finally, we give an overview over the project structure in order to ease further development.

| Packet Name                                          | Description                                                                                                                                              |
|------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------|
| tools.descartes.librede.rrde               | The main plug-in controlling all sub-packages and the life-cycle as well as the integration of the plug-in. Also contains verification and evaluation.   |
| tools.descartes.librede.rrde.optimization   | The plug-in for containing and controlling the optimization process.                                                                                     |
| tools.descartes.librede.rrde.recommendation | The plug-in for containing and controlling the recommendation process.                                                                                   |
| tools.descartes.librede.rrde.model          | Contains the EMF ecore meta-models as well as the model code for configuration of the different tools. Mostly generated by the EMF. |
| tools.descartes.librede.rrde.model.edit     | Used for manipulation of the configuration files and its resulting object structures. Mostly generated by the EMF.                                 |
| tools.descartes.librede.rrde.model.editor   | Graphical editor to simplify creating and editing configuration files for the end-user. Mostly generated by the EMF.                               |
| tools.descartes.librede.rrde.model.tests}    | Contains unit tests for the different EMF modules. Mostly generated by the EMF.                                                              |
| tools.descartes.librede.rrde.rinterface     | Bridge used for calls and call-backs from Java to R.                                                                                               |

