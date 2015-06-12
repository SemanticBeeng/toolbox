/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements.  See the NOTICE file distributed with this work for additional information regarding copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package eu.amidst.dynamic.inference;

import eu.amidst.corestatic.distribution.UnivariateDistribution;
import eu.amidst.dynamic.models.DynamicBayesianNetwork;
import eu.amidst.dynamic.variables.DynamicAssignment;
import eu.amidst.corestatic.variables.Variable;

/**
 * Created by andresmasegosa on 30/01/15.
 */
public interface InferenceAlgorithmForDBN {

    void runInference();

    void setModel(DynamicBayesianNetwork model);

    DynamicBayesianNetwork getOriginalModel();

    void addDynamicEvidence(DynamicAssignment assignment);

    void reset();

    <E extends UnivariateDistribution> E getFilteredPosterior(Variable var);

    <E extends UnivariateDistribution> E getPredictivePosterior(Variable var, int nTimesAhead);

    int getTimeIDOfLastEvidence();

    int getTimeIDOfPosterior();

}