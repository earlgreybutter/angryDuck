package com.ceramicduck.angryduck.deeplearning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.deeplearning4j.nn.weights.WeightInit;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.lossfunctions.LossFunctions.LossFunction;

import java.util.List;

@Service
public class ModelService {

	@Autowired
	private ModelManager modelManager;

	public int recommend(List<Double> data) {
		return modelManager.test(data);
	}
}
