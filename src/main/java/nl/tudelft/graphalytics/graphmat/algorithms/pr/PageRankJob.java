/*
 * Copyright 2015 Delft University of Technology
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.tudelft.graphalytics.graphmat.algorithms.pr;

import nl.tudelft.graphalytics.graphmat.GraphMatJob;
import nl.tudelft.graphalytics.graphmat.config.JobConfiguration;
import org.apache.commons.exec.CommandLine;

import java.nio.file.Paths;

/**
 * PR
 *
 * @author Wing Lung Ngai
 * @author Tim Hegeman
 */
public final class PageRankJob extends GraphMatJob {

	/**
	 * Creates a new PageRankJob object with all mandatory parameters specified.
	 *
	 * @param jobConfiguration the generic GraphMat configuration to use for this job
	 * @param graphInputPath   the path of the input graph
	 * @param graphOutputPath  the path of the output graph
	 */
	public PageRankJob(JobConfiguration jobConfiguration, String graphInputPath, String graphOutputPath) {
		super(jobConfiguration, graphInputPath, graphOutputPath);
	}

	@Override
	protected void appendAlgorithmParameters(CommandLine commandLine) {
		//TODO check if supported
//		commandLine.addArgument("-e=1e-15")
//				.addArgument("-d=" + parameters.getDampingFactor())
//				.addArgument("-max_iterations=" + parameters.getNumberOfIterations());
	}

	@Override
	protected void appendAlgorithm(CommandLine commandLine) {
		commandLine.addArgument(Paths.get(jobConfiguration.getExecutableDirectory(), getExecutableName()).toString(), false);
	}

	@Override
	protected String getExecutableName() {
		return "PageRank";
	}

	@Override
	protected boolean usesEdgeProperties() {
		return false;
	}

}
