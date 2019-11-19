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
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.learning.config.Adam;
import org.nd4j.linalg.learning.config.Sgd;
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

	private final String TRAIN_DATA_PATH = "train_data_shuffle.csv";
	private final String SAVED_MODEL_PATH = "TRAINED_MODEL";
	private final int EPOCH_SIZE = 1024 * 1; // 반복 학습 횟수 : 학습된 모델은 32736
	private final int BATCH_SIZE = 32; // 학습 단위
	private final double LEARNING_RATE = 0.1;
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
				.updater(new Sgd(LEARNING_RATE))
				.list()
				.layer(new DenseLayer.Builder()
						.nIn(INPUT_SIZE)
						.nOut(HIDDEN_LAYER_1_SIZE)
						.activation(Activation.TANH)
						.weightInit(WeightInit.XAVIER)
						.build())
				.layer(new DenseLayer.Builder()
						.nIn(HIDDEN_LAYER_1_SIZE)
						.nOut(HIDDEN_LAYER_2_SIZE)
						.activation(Activation.TANH)
						.weightInit(WeightInit.XAVIER)
						.build())
				.layer(new DenseLayer.Builder()
						.nIn(HIDDEN_LAYER_2_SIZE)
						.nOut(HIDDEN_LAYER_3_SIZE)
						.activation(Activation.TANH)
						.weightInit(WeightInit.XAVIER)
						.build())
				.layer(new DenseLayer.Builder()
						.nIn(HIDDEN_LAYER_3_SIZE)
						.nOut(HIDDEN_LAYER_4_SIZE)
						.activation(Activation.TANH)
						.weightInit(WeightInit.XAVIER)
						.build())
				.layer(new OutputLayer.Builder(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
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
			DataSetIterator dataSetIterator = loadDataSet();
			train(dataSetIterator);
			save();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private DataSetIterator loadDataSet() throws Exception {
		RecordReader recordReader = new CSVRecordReader(',');
		recordReader.initialize(new FileSplit(new ClassPathResource(TRAIN_DATA_PATH).getFile()));
		return new RecordReaderDataSetIterator
				.Builder(recordReader, BATCH_SIZE)
				.classification(20, OUTPUT_SIZE) // result 가 시작되는 인덱스 번호, result 로 분류 가능한 데이터 갯수 
				.build();
	}

	private void train(DataSetIterator dataSetIterator){

		System.out.println("[ModelManager] : 모델을 학습 시킵니다.");
		for(int i = 0; i < EPOCH_SIZE; i++) {
			System.out.println("[ModelManager] : Epoch - " + i);
			multiLayerNetwork.fit(dataSetIterator);
		}
		System.out.println("[ModelManager] : 모델이 학습 완료 되었습니다.");
	}

	private void save() throws IOException {
		ModelSerializer.writeModel(multiLayerNetwork, SAVED_MODEL_PATH,true);
	}

	private MultiLayerNetwork load() throws IOException {
		MultiLayerNetwork multiLayerNetwork = ModelSerializer.restoreMultiLayerNetwork(SAVED_MODEL_PATH,true);
		return multiLayerNetwork;
	}
	
	// input : 테스트를 원하는 데이터
	// output : 가장 추천할만한 output 의 인덱스 값 반환 (0 ~ 10)
	public int test(List<Double> data) {
		double[][] dataArray = new double[1][data.size()];
		for(int i = 0; i < dataArray[0].length; i++)
			dataArray[0][i] = data.get(i);

		INDArray testData = Nd4j.create(dataArray);
		List<INDArray> testResult = multiLayerNetwork.feedForward(testData);
		System.out.println(testResult);

		INDArray lastLayerResult = testResult.get(testResult.size() - 1);
		INDArray result = lastLayerResult.getRow(0);
		System.out.println(result);
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
