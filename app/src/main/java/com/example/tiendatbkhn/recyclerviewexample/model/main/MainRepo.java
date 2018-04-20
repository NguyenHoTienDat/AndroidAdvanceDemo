package com.example.tiendatbkhn.recyclerviewexample.model.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tiendatbkhn on 19/04/2018.
 */

public class MainRepo {
    private static List<Example> examples;

    public static List<Example> getExamples() {
        if (examples == null) {
            examples = new ArrayList<>();
            examples.add(new Example(1,"RecyclerView Example"));
            examples.add(new Example(2,"ViewPager Example"));
            examples.add(new Example(3,"AsyncTask Example"));
            examples.add(new Example(4,"Broadcast receiver Example"));
            examples.add(new Example(5,"Serivce Example"));
            examples.add(new Example(6,"Content Provider Example"));
        }

        return examples;
    }
}
