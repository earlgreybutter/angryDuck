package com.ceramicduck.angryduck.deeplearning;

import org.apache.commons.lang3.RandomUtils;
import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
import org.datavec.api.split.FileSplit;
import org.datavec.api.util.ClassPathResource;
import org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.util.ModelSerializer;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.api.DataSet;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.learning.config.Adam;
import org.nd4j.linalg.lossfunctions.LossFunctions;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class ModelManager {
	private final int INPUT_SIZE = 20;
	private final int HIDDEN_LAYER_1_SIZE = 100;
	private final int HIDDEN_LAYER_2_SIZE = 100;
	private final int HIDDEN_LAYER_3_SIZE = 50;
	private final int HIDDEN_LAYER_4_SIZE = 20;
	private final int OUTPUT_SIZE = 11;

	private final String TRAIN_DATA_PATH = "train_data.csv";
	private final String SAVED_MODEL_PATH = "TRAINED_MODEL";
	private final int EPOCH_SIZE = 1024; // 반복 학습 횟수
	private final int BATCH_SIZE = 32; // 학습 단위
	private final double LEARNING_RATE = 0.005;
	private MultiLayerNetwork multiLayerNetwork;
	
	public ModelManager() {
		try {
			System.out.println("[ModelManager] : 학습된 모델을 불러옵니다.");
			multiLayerNetwork = load();
		} catch (Exception e) {
			System.out.println("[ModelManager] : 학습된 모델을 찾을 수 없어 새로 모델을 만들고 학습 시킵니다.");
			multiLayerNetwork = createModel();
			trainAndSave();
		}
	}
	
	private MultiLayerNetwork createModel() {
		MultiLayerConfiguration multiLayerConfiguration = new NeuralNetConfiguration.Builder()
				.seed(RandomUtils.nextInt())
				.updater(new Adam(LEARNING_RATE))
				.l2(1e-4)
				.list()
				.layer(new DenseLayer.Builder()
						.nIn(INPUT_SIZE)
						.nOut(HIDDEN_LAYER_1_SIZE)
						.activation(Activation.RELU)
						.weightInit(WeightInit.XAVIER)
						.build())
				.layer(new DenseLayer.Builder()
						.nIn(HIDDEN_LAYER_1_SIZE)
						.nOut(HIDDEN_LAYER_2_SIZE)
						.activation(Activation.RELU)
						.weightInit(WeightInit.XAVIER)
						.build())
				.layer(new DenseLayer.Builder()
						.nIn(HIDDEN_LAYER_2_SIZE)
						.nOut(HIDDEN_LAYER_3_SIZE)
						.activation(Activation.RELU)
						.weightInit(WeightInit.XAVIER)
						.build())
				.layer(new DenseLayer.Builder()
						.nIn(HIDDEN_LAYER_3_SIZE)
						.nOut(HIDDEN_LAYER_4_SIZE)
						.activation(Activation.RELU)
						.weightInit(WeightInit.XAVIER)
						.build())
				.layer(new OutputLayer.Builder(LossFunctions.LossFunction.MSE)
						.activation(Activation.SOFTMAX)
						.weightInit(WeightInit.XAVIER)
						.nIn(HIDDEN_LAYER_4_SIZE)
						.nOut(OUTPUT_SIZE).build())
				.build();
		MultiLayerNetwork multiLayerNetwork = new MultiLayerNetwork(multiLayerConfiguration);
		multiLayerNetwork.init();
		return multiLayerNetwork;
	}
	
	public void trainAndSave() {
		try {
			DataSet dataSet = loadDataSet();
			train(dataSet);
			save();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private DataSet loadDataSet() throws Exception {
		RecordReader recordReader = new CSVRecordReader(0, ',');
		recordReader.initialize(new FileSplit(new ClassPathResource(TRAIN_DATA_PATH).getFile()));
		DataSetIterator dataSetIterator = new RecordReaderDataSetIterator(recordReader, BATCH_SIZE, 20, OUTPUT_SIZE);
		DataSet dataSet = dataSetIterator.next();
		dataSet.shuffle();
		return dataSet;
	}

	private void train(DataSet dataSet){
		for(int i = 0; i < EPOCH_SIZE; i++)
			multiLayerNetwork.fit(dataSet);
	}

	private void save() throws IOException {
		ModelSerializer.writeModel(multiLayerNetwork, SAVED_MODEL_PATH,true);
	}

	private MultiLayerNetwork load() throws IOException {
		MultiLayerNetwork multiLayerNetwork = ModelSerializer.restoreMultiLayerNetwork(SAVED_MODEL_PATH,true);
		return multiLayerNetwork;
	}
	
	public int test(List<Double> data) {
		double[][] dataArray = new double[1][data.size()];
		for(int i = 0; i < dataArray.length; i++)
			dataArray[0][i] = data.get(i);

		INDArray testData = Nd4j.create(dataArray);
		List<INDArray> testResult = multiLayerNetwork.feedForward(testData);
		INDArray lastLayerResult = testResult.get(testResult.size() - 1);
		INDArray result = lastLayerResult.getRow(0);
		return findMaxIndex(result);
	}

	private int findMaxIndex(INDArray result){
		int maxIndex = 0;
		double max = result.getDouble(0);
		for(int i = 1; i < OUTPUT_SIZE; i++){
			double value = result.getDouble(i);
			if(value > max){
				maxIndex = i;
				max = value;
			}
		}
		return maxIndex;
	}
}

