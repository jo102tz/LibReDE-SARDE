package tools.descartes.librede.rrde;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;

import tools.descartes.librede.Librede;
import tools.descartes.librede.LibredeResults;
import tools.descartes.librede.ResultTable;
import tools.descartes.librede.approach.IEstimationApproach;
import tools.descartes.librede.configuration.EstimationSpecification;
import tools.descartes.librede.configuration.LibredeConfiguration;
import tools.descartes.librede.configuration.ModelEntity;
import tools.descartes.librede.configuration.ResourceDemand;
import tools.descartes.librede.exceptions.EstimationException;
import tools.descartes.librede.linalg.LinAlg;
import tools.descartes.librede.linalg.Matrix;
import tools.descartes.librede.linalg.MatrixBuilder;
import tools.descartes.librede.linalg.Vector;
import tools.descartes.librede.registry.Registry;
import tools.descartes.librede.rrde.optimization.util.Discovery;
import tools.descartes.librede.validation.IValidator;

public class Logging {
	
	private static Map<String, Integer> approachidmap = new HashMap<>();

	/**
	 * LOG THE EXECUTION TIMES---------------------------------------------------
	 */
	
	public static void logOptimizationExecutionTime(long starttime,long endtime){
		try {
			File outputfile = new File(ThreadHandler.folderInfo+"/opt_time.csv");
			PrintStream outputStream;
			outputStream = new PrintStream(new FileOutputStream(outputfile, true));
			//write the output here
			String line = ""+ starttime+", "+endtime+", "+(endtime-starttime)+"\n";
			outputStream.print(line);
			//end
			outputStream.flush();
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("LOGGING FAILED!!!");
		}
	}
	public static void logRecommendationExecutionTime(long starttime,long endtime){
		try {
			File outputfile = new File(ThreadHandler.folderInfo+"/rec_time.csv");
			PrintStream outputStream;
			outputStream = new PrintStream(new FileOutputStream(outputfile, true));
			//write the output here
			String line = ""+ starttime+", "+endtime+", "+(endtime-starttime)+"\n";
			outputStream.print(line);
			//end
			outputStream.flush();
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("LOGGING FAILED!!!");
		}
	}
	public static void logSelectionExecutionTime(long starttime,long endtime){
		try {
			File outputfile = new File(ThreadHandler.folderInfo+"/sel_time.csv");
			PrintStream outputStream;
			outputStream = new PrintStream(new FileOutputStream(outputfile, true));
			//write the output here
			String line = ""+ starttime+", "+endtime+", "+(endtime-starttime)+"\n";
			outputStream.print(line);
			//end
			outputStream.flush();
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("LOGGING FAILED!!!");
		}
	}
	public static void logEstimationExecutionTime(long starttime,long endtime){
		try {
			File outputfile = new File(ThreadHandler.folderInfo+"/est_time.csv");
			PrintStream outputStream;
			outputStream = new PrintStream(new FileOutputStream(outputfile, true));
			//write the output here
			String line = ""+ starttime+", "+endtime+", "+(endtime-starttime)+"\n";
			outputStream.print(line);
			//end
			outputStream.flush();
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("LOGGING FAILED!!!");
		}
	}
	/**
	 * -------------------------------------------------------------------------------------
	 */
	
	/**
	 * LOG OPTIMIZATION OUTPUT-------------------------------------------------------------------
	 */
	public static void logOptimizationOutput(long starttime, Collection<EstimationSpecification> estimations, LibredeConfiguration librede) {
		File outputfolder = new File(ThreadHandler.folderInfo+"/opt_output");
		if(!outputfolder.exists() || !outputfolder.isDirectory()){
			outputfolder.mkdir();
		}
		File outputfolder2 = new File(ThreadHandler.folderInfo+"/opt_output/"+starttime);
		if(!outputfolder2.exists() || !outputfolder2.isDirectory()){
			outputfolder2.mkdir();
		}
		//write the output here
		int i = 0;
		for (EstimationSpecification spec : estimations) {
			String name = outputfolder2.getAbsolutePath() + File.separator + "Optimized_RunCall" + i++ + "_"
					+ spec.getApproaches().get(0).getType().replace("tools.descartes.librede.approach.", "")
					+ ".librede";
			store(spec, librede, name);
		}
	}
	/**
	 * Stores the given {@link LibredeConfiguration}, but removes its
	 * {@link EstimationSpecification} with the given one.
	 * 
	 * @param result
	 *            The {@link EstimationException} to use
	 * @param conf
	 *            The {@link LibredeConfiguration} as skeleton
	 * @param file
	 *            The path to be used as output
	 * @throws RuntimeException
	 *             If the storing fails for some reason
	 */
	private static void store(EstimationSpecification result, LibredeConfiguration conf, String file) {
		// create configuration
		LibredeConfiguration output = EcoreUtil.copy(conf);
		output.setEstimation(EcoreUtil.copy(result));
		// fix timestamps for valid output
		Discovery.fixTimeStamps(output);

		// write to file
		ResourceSet rs = new ResourceSetImpl();
		URI uri = URI.createFileURI(file);
		Resource resource = rs.createResource(uri);

		resource.getContents().add(output);
		Map<Object, Object> saveOptions = ((XMLResource) resource).getDefaultSaveOptions();
		saveOptions.put(XMLResource.OPTION_CONFIGURATION_CACHE, Boolean.TRUE);
		saveOptions.put(XMLResource.OPTION_USE_CACHED_LOOKUP_TABLE, new ArrayList<Object>());
		try {
			resource.save(saveOptions);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ---------------------------------------------------------------------------------------------------------------
	 */
	/**
	 * Log SELECTION OUTPUT--------------------------------------------------------------------------------------------
	 */
	public static void logSelectionOutput(Long starttime, long endtime, EstimationSpecification estimationSpecification){
		if(!approachidmap.containsKey(estimationSpecification.getApproaches().get(0).getType().replace("tools.descartes.librede.approach.", "").toString())){
			putToMapping(estimationSpecification.getApproaches().get(0).getType().replace("tools.descartes.librede.approach.", "").toString());
		}
		int mapid = approachidmap.get(estimationSpecification.getApproaches().get(0).getType().replace("tools.descartes.librede.approach.", "").toString());
		try {
			File outputfile = new File(ThreadHandler.folderInfo+"/selection_approach.csv");
			PrintStream outputStream;
			outputStream = new PrintStream(new FileOutputStream(outputfile, true));
			//write the output here
			String line = ""+starttime+", "+endtime+", "+(endtime-starttime)+", "+mapid;
			outputStream.println(line);
			//end
			outputStream.flush();
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("LOGGING FAILED!!!");
		}
	}
	private static void putToMapping(String approachname) {
		try {
			approachidmap.put(approachname, approachidmap.size()+1);
			File outputfile = new File(ThreadHandler.folderInfo+"/appraochmap.txt");
			PrintStream outputStream;
			outputStream = new PrintStream(new FileOutputStream(outputfile, true));
			//write the output here
			String line = ""+approachidmap.get(approachname).intValue()+", "+approachname;
			outputStream.println(line);
			//end
			outputStream.flush();
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("LOGGING FAILED!!!");
		}
	}
	/**
	 * LOG THE ESTIMATION RESULTS
	 */
	public static void logBestEstimationOutput(long starttime, long endtime, LibredeResults results) {
		if(results.getApproaches().size()<=0){
			//print the info to the file 
			try {
				File outputfile = new File(ThreadHandler.folderInfo+"/estimation_output.csv");
				PrintStream outputStream;
				outputStream = new PrintStream(new FileOutputStream(outputfile, true));
				//write the output here
				String outline = "We have no result here :-(\n";
				outputStream.print(outline);
				//end
				outputStream.flush();
				outputStream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("LOGGING FAILED!!!");
			}
		}
		// Aggregate results
		ResourceDemand[] variables = null;
		List<Class<? extends IEstimationApproach>> approaches = new ArrayList<>(results.getApproaches());

		Set<Class<? extends IValidator>> validators = new HashSet<Class<? extends IValidator>>();
		for (Class<? extends IEstimationApproach> approach : approaches) {
			for (int i = 0; i < results.getNumberOfFolds(); i++) {
				ResultTable curFold = results.getEstimates(approach, i);
				if (variables == null) {
					variables = curFold.getStateVariables();
				} else {
					if (!Arrays.equals(variables, curFold.getStateVariables())) {
						throw new IllegalStateException();
					}
				}
				validators.addAll(curFold.getValidators());
			}
		}

		// Print approaches legend
		//System.out.println("Approaches");
		//System.out.println("==========");
		//for (int i = 0; i < approaches.size(); i++) {
		//	System.out.printf("[%d] %s\n", i + 1, Registry.INSTANCE.getDisplayName(approaches.get(i)));
		//}
		//System.out.println();

		Map<Class<? extends IValidator>, MatrixBuilder> meanErrors = new HashMap<Class<? extends IValidator>, MatrixBuilder>();
		Map<Class<? extends IValidator>, MatrixBuilder> meanPredictions = new HashMap<Class<? extends IValidator>, MatrixBuilder>();
		Map<Class<? extends IValidator>, List<ModelEntity>> validatedEntities = new HashMap<Class<? extends IValidator>, List<ModelEntity>>();
		
		if (variables != null) {
			MatrixBuilder meanEstimates = MatrixBuilder.create(variables.length);
			for (Class<? extends IEstimationApproach> approach : approaches) {
				MatrixBuilder lastEstimates = MatrixBuilder.create(variables.length);
				for (int i = 0; i < results.getNumberOfFolds(); i++) {
					ResultTable curFold = results.getEstimates(approach, i);
					lastEstimates.addRow(curFold.getLastEstimates());
				}
				Matrix lastEstimatesMatrix = lastEstimates.toMatrix();
				if (lastEstimatesMatrix.isEmpty()) {
					System.out.println("LOGGING RESULTS EXCEPTION: No estimates found for approach " + Registry.INSTANCE.getDisplayName(approach));
				} else {
					meanEstimates.addRow(LinAlg.mean(lastEstimatesMatrix));
				}
	
				for (Class<? extends IValidator> validator : validators) {
					MatrixBuilder errorsBuilder = null;
					MatrixBuilder predictionsBuilder = null;
					for (int i = 0; i < results.getNumberOfFolds(); i++) {
						ResultTable curFold = results.getEstimates(approach, i);
						Vector curErr = curFold.getValidationErrors(validator);
						if (errorsBuilder == null) {
							errorsBuilder = MatrixBuilder.create(curErr.rows());
							validatedEntities.put(validator, curFold.getValidatedEntities(validator));
						}
						errorsBuilder.addRow(curErr);
						Vector curPred = curFold.getValidationPredictions(validator);
						if (predictionsBuilder == null) {
							predictionsBuilder = MatrixBuilder.create(curPred.rows());
						}
						predictionsBuilder.addRow(curPred);
					}
	
					Matrix errors = errorsBuilder.toMatrix();
					Matrix predictions = predictionsBuilder.toMatrix();
					if (!errors.isEmpty() && !predictions.isEmpty()) {
						Vector curMeanErr = LinAlg.mean(errors);
						Vector curMeanPred = LinAlg.mean(predictions);
						if (!meanErrors.containsKey(validator)) {
							meanErrors.put(validator, MatrixBuilder.create(curMeanErr.rows()));
							meanPredictions.put(validator, MatrixBuilder.create(curMeanPred.rows()));
						}
						meanErrors.get(validator).addRow(curMeanErr);
						meanPredictions.get(validator).addRow(curMeanPred);
					}
				}
	
			}


			// Estimates
			//System.out.println("Estimates");
			//System.out.println("=========");
			//printEstimatesTableOriginal(variables, approaches, meanEstimates.toMatrix());
			//System.out.println();

			String errorsstring = null;
		int approachidx =-1;
			if (validators.size() > 0) {
				// Cross-Validation Results
				//System.out.println("Cross-Validation Results:");
				//System.out.println("=========================");
	
				for (Class<? extends IValidator> validator : validators) {
					String name = Registry.INSTANCE.getDisplayName(validator);
					//System.out.println(name + ":");
					if (meanErrors.containsKey(validator)) {
	
						Matrix errors = meanErrors.get(validator).toMatrix();
						Matrix predictions = meanPredictions.get(validator).toMatrix();
						approachidx = getMinimumIdx(validatedEntities.get(validator), approaches, predictions, errors);
						errorsstring = printValidationResultsTableIdx(validatedEntities.get(validator), approaches, predictions, errors, approachidx);
						//System.out.println();
					} else {
						//System.out.println("No results.");
					}
				}
			}
			
			String line = printEstimatesTableIdx(variables, approaches, meanEstimates.toMatrix(), approachidx);
			
			//get the approachid
			Class<? extends IEstimationApproach> a = approaches.get(approachidx);
			String approachname = a.getTypeName().replace("tools.descartes.librede.approach.", "");
			if(!approachidmap.containsKey(approachname)){
				putToMapping(approachname);
			}
			int mapid = approachidmap.get(approachname);
			
			//add the strings
			if(errorsstring!=null){
				line = errorsstring+line;
			}
			//print the info to the file 
			try {
				File outputfile = new File(ThreadHandler.folderInfo+"/estimation_output.csv");
				PrintStream outputStream;
				outputStream = new PrintStream(new FileOutputStream(outputfile, true));
				//write the output here
				String outline = ""+ starttime+", "+endtime+", "+(endtime-starttime)+", "+mapid+", "+line+"\n";
				outputStream.print(outline);
				//end
				outputStream.flush();
				outputStream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("LOGGING FAILED!!!");
			}
		}
	}
	private static String printValidationResultsTableIdx(List<ModelEntity> entities,
			List<Class<? extends IEstimationApproach>> approaches, Matrix predictions, Matrix errors, int approachidx) {
		int idx = 0;
		double errorsum=0;
		double errorprecentagesum = 0;
		double count = 0;
		for (ModelEntity entity : entities) {
			errorsum = errorsum + predictions.get(approachidx, idx);
			errorprecentagesum = errorprecentagesum + (errors.get(approachidx, idx) * 100);
			count++;
			idx++;
		}
		String line = ""+ (errorsum/count)+", "+(errorprecentagesum/count)+", ";
		return line;
	}
	private static String printEstimatesTableIdx(ResourceDemand[] variables,
			List<Class<? extends IEstimationApproach>> approaches, Matrix values, int approachidx) {
		
		Resource last = null;
		
		String line = "";
		int idx = 0;
		for (ResourceDemand var : variables) {
			if(idx != variables.length-1){
				line = line + values.get(approachidx, idx)+", ";
			}else{
				line = line + values.get(approachidx, idx);
			}
			idx++;
		}
		return line;
	}
	private static int getMinimumIdx(List<ModelEntity> entities,
			List<Class<? extends IEstimationApproach>> approaches, Matrix predictions, Matrix errors) {
		//System.out.printf("%-80.80s | ", "Resource or service");
		//for (int i = 0; i < approaches.size(); i++) {
		//	System.out.printf("%-9.9s", "[" + (i + 1) + "]");
		//}
		//System.out.println("|");

		//for (int i = 0; i < (87 + approaches.size() * 9); i++) {
		//	System.out.print("-");
		//}
		//System.out.println();

		Double[] errorsum = new Double[approaches.size()];
		boolean[] takeit = new boolean[approaches.size()];
		for (int i = 0; i < approaches.size(); i++) {
			errorsum[i] = 0.0;
			takeit[i]=false;
		}
		int idx = 0;
		for (ModelEntity entity : entities) {
		//	System.out.printf("%-80.80s | ", limitOutput(entity.getName(), 80));
			for (int i = 0; i < approaches.size(); i++) {
				if((errors.get(i, idx) * 100)!=100.0){
					takeit[i] = true;
				}
			}
			//System.out.println("|");
			idx++;
		}
		idx = 0;
		for (ModelEntity entity : entities) {
		//	System.out.printf("%-80.80s | ", limitOutput(entity.getName(), 80));
			for (int i = 0; i < approaches.size(); i++) {
				errorsum[i] = errorsum[i]+(errors.get(i, idx) * 100);
			}
			//System.out.println("|");
			idx++;
		}
		Double min = Double.MAX_VALUE;
		int minidx = -1;
		for (int i = 0; i < approaches.size(); i++) {
			if(errorsum[i]<min && takeit[i]==true){
				min=errorsum[i];
				minidx=i;
			}
		}
		if(minidx==-1){
			System.out.println("FATAL ERRORWE HAVE A -1 AS A IDX!!!");
		}
		
		
		return minidx;
	}
	public static void logEstimationOutput(long starttime, long endtime, LibredeResults results) {
		if(results.getApproaches().size()!=1){
			//print the info to the file 
			try {
				File outputfile = new File(ThreadHandler.folderInfo+"/estimation_output.csv");
				PrintStream outputStream;
				outputStream = new PrintStream(new FileOutputStream(outputfile, true));
				//write the output here
				String outline = "The next line does have "+results.getApproaches().size()+" approach selected in reality :-(\n";
				outputStream.print(outline);
				//end
				outputStream.flush();
				outputStream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("LOGGING FAILED!!!");
			}
		}
		// Aggregate results
		ResourceDemand[] variables = null;
		List<Class<? extends IEstimationApproach>> approaches = new ArrayList<>(results.getApproaches());

		Set<Class<? extends IValidator>> validators = new HashSet<Class<? extends IValidator>>();
		for (Class<? extends IEstimationApproach> approach : approaches) {
			for (int i = 0; i < results.getNumberOfFolds(); i++) {
				ResultTable curFold = results.getEstimates(approach, i);
				if (variables == null) {
					variables = curFold.getStateVariables();
				} else {
					if (!Arrays.equals(variables, curFold.getStateVariables())) {
						throw new IllegalStateException();
					}
				}
				validators.addAll(curFold.getValidators());
			}
		}
		//get the approachid
		Class<? extends IEstimationApproach> a = results.getApproaches().iterator().next();
		String approachname = a.getTypeName().replace("tools.descartes.librede.approach.", "");
		if(!approachidmap.containsKey(approachname)){
			putToMapping(approachname);
		}
		int mapid = approachidmap.get(approachname);

		Map<Class<? extends IValidator>, MatrixBuilder> meanErrors = new HashMap<Class<? extends IValidator>, MatrixBuilder>();
		Map<Class<? extends IValidator>, MatrixBuilder> meanPredictions = new HashMap<Class<? extends IValidator>, MatrixBuilder>();
		Map<Class<? extends IValidator>, List<ModelEntity>> validatedEntities = new HashMap<Class<? extends IValidator>, List<ModelEntity>>();
		
		if (variables != null) {
			MatrixBuilder meanEstimates = MatrixBuilder.create(variables.length);
			for (Class<? extends IEstimationApproach> approach : approaches) {
				MatrixBuilder lastEstimates = MatrixBuilder.create(variables.length);
				for (int i = 0; i < results.getNumberOfFolds(); i++) {
					ResultTable curFold = results.getEstimates(approach, i);
					lastEstimates.addRow(curFold.getLastEstimates());
				}
				Matrix lastEstimatesMatrix = lastEstimates.toMatrix();
				if (lastEstimatesMatrix.isEmpty()) {
					System.out.println("LOGGING RESULTS EXCEPTION: No estimates found for approach " + Registry.INSTANCE.getDisplayName(approach));
				} else {
					meanEstimates.addRow(LinAlg.mean(lastEstimatesMatrix));
				}
	
				for (Class<? extends IValidator> validator : validators) {
					MatrixBuilder errorsBuilder = null;
					MatrixBuilder predictionsBuilder = null;
					for (int i = 0; i < results.getNumberOfFolds(); i++) {
						ResultTable curFold = results.getEstimates(approach, i);
						Vector curErr = curFold.getValidationErrors(validator);
						if (errorsBuilder == null) {
							errorsBuilder = MatrixBuilder.create(curErr.rows());
							validatedEntities.put(validator, curFold.getValidatedEntities(validator));
						}
						errorsBuilder.addRow(curErr);
						Vector curPred = curFold.getValidationPredictions(validator);
						if (predictionsBuilder == null) {
							predictionsBuilder = MatrixBuilder.create(curPred.rows());
						}
						predictionsBuilder.addRow(curPred);
					}
	
					Matrix errors = errorsBuilder.toMatrix();
					Matrix predictions = predictionsBuilder.toMatrix();
					if (!errors.isEmpty() && !predictions.isEmpty()) {
						Vector curMeanErr = LinAlg.mean(errors);
						Vector curMeanPred = LinAlg.mean(predictions);
						if (!meanErrors.containsKey(validator)) {
							meanErrors.put(validator, MatrixBuilder.create(curMeanErr.rows()));
							meanPredictions.put(validator, MatrixBuilder.create(curMeanPred.rows()));
						}
						meanErrors.get(validator).addRow(curMeanErr);
						meanPredictions.get(validator).addRow(curMeanPred);
					}
				}
	
			}


			// Estimates --> Resource demands "rd, rd, rd"
			String line =printEstimatesTable(variables, approaches, meanEstimates.toMatrix());

			String errorsstring = null;
			if (validators.size() > 0) {
				// Cross-Validation Results
	
				for (Class<? extends IValidator> validator : validators) {
					String name = Registry.INSTANCE.getDisplayName(validator);
					if (meanErrors.containsKey(validator)) {
	
						Matrix errors = meanErrors.get(validator).toMatrix();
						Matrix predictions = meanPredictions.get(validator).toMatrix();
						//Errors "error, error%, 
						errorsstring = printValidationResultsTable(validatedEntities.get(validator), approaches, predictions, errors);
					} else {
						System.out.println("LOGGING ERROR - No results.");
					}
				}
			}
			//add the strings
			if(errorsstring!=null){
				line = errorsstring+line;
			}
			//print the info to the file 
			try {
				File outputfile = new File(ThreadHandler.folderInfo+"/estimation_output.csv");
				PrintStream outputStream;
				outputStream = new PrintStream(new FileOutputStream(outputfile, true));
				//write the output here
				String outline = ""+ starttime+", "+endtime+", "+(endtime-starttime)+", "+mapid+", "+line+"\n";
				outputStream.print(outline);
				//end
				outputStream.flush();
				outputStream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("LOGGING FAILED!!!");
			}
		}
	}
	private static String printEstimatesTable(ResourceDemand[] variables,
			List<Class<? extends IEstimationApproach>> approaches, Matrix values) {
		String line = "";
		int idx = 0;
		for (ResourceDemand var : variables) {
			int i=0;
			if(idx != variables.length-1){
				line = line + values.get(i, idx)+", ";
			}else{
				line = line + values.get(i, idx);
			}
			idx++;
		}
		return line;
		/*try {
			File outputfile = new File(ThreadHandler.folderInfo+"/resourcedemands.csv");
			PrintStream outputStream;
			outputStream = new PrintStream(new FileOutputStream(outputfile, true));
			//write the output here
			outputStream.print(line);
			//end
			outputStream.flush();
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("LOGGING FAILED!!!");
		}*/
	}
	private static String printValidationResultsTable(List<ModelEntity> entities,
			List<Class<? extends IEstimationApproach>> approaches, Matrix predictions, Matrix errors) {
		int idx = 0;
		double errorsum=0;
		double errorprecentagesum = 0;
		double count = 0;
		for (ModelEntity entity : entities) {
			int i=0;//the appraoch
			errorsum = errorsum + predictions.get(i, idx);
			errorprecentagesum = errorprecentagesum + (errors.get(i, idx) * 100);
			count++;
			idx++;
		}
		String line = ""+ (errorsum/count)+", "+(errorprecentagesum/count)+", ";
		return line;
	}
}
