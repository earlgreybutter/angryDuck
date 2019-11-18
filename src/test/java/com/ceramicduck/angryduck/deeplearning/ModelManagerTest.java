package com.ceramicduck.angryduck.deeplearning;

import com.ceramicduck.angryduck.deeplearning.ModelManager;
import com.ceramicduck.angryduck.deeplearning.ModelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ModelManager.class, ModelService.class})
public class ModelManagerTest {
    @Autowired
    private ModelManager modelManager;

    @Test
    public void trainAndSave(){
        modelManager.trainAndSave();
    }

    @Test
    public void loadAndTest(){
        List<Double> data = new ArrayList<>();
        //0.39,1,0,1,0,
        // 1,0,0,0,0,
        // 0,0,1,1,0,
        // 0,0,0,0,0,
        // 11
        data.add(0.2); data.add(0.0); data.add(0.0); data.add(0.0); data.add(0.0);
        data.add(0.0); data.add(0.0); data.add(0.0); data.add(0.0); data.add(0.0);
        data.add(0.0); data.add(0.0); data.add(1.0); data.add(0.0); data.add(0.0);
        data.add(0.0); data.add(0.0); data.add(0.0); data.add(0.0); data.add(0.0);
        int index = modelManager.test(data);
        System.out.println(index);
    }
}
