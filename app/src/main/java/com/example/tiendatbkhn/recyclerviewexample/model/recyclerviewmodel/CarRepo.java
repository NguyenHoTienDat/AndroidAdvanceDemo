package com.example.tiendatbkhn.recyclerviewexample.model.recyclerviewmodel;

import com.example.tiendatbkhn.recyclerviewexample.model.main.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tiendatbkhn on 19/04/2018.
 */

public class CarRepo {

    public static List<Car> getCars() {
            List<Car> cars;
            cars = new ArrayList<>();
            cars.add(new Car("Lamborghini","https://www.lamborghini.com/sites/it-en/files/DAM/it/models_gateway/blocks/special.png"));
            cars.add(new Car("Ferari","http://corporate.ferrari.com/sites/ferrari15ipo/files/home_slide_images/img_ferrari_6_5.jpg"));
            cars.add(new Car("Rolls Royce","https://icdn-6.motor1.com/images/mgl/0kQM9/s1/2018-rolls-royce-phantom-first-drive.jpg"));
            cars.add(new Car("Bungati","https://cdn.images.express.co.uk/img/dynamic/24/590x/Bugatti-Chiron-2017-852747.jpg"));
            cars.add(new Car("Porchers","https://s.aolcdn.com/dims-global/dims3/GLOB/legacy_thumbnail/916x515/quality/95/http://www.blogcdn.com/autos.aol.com/media/import/479e5ec2-001c0-00bfa-400cb8e1-1.jpg"));
            cars.add(new Car("Aston Martin","https://aml-prod-cdn.azureedge.net/aml-prod-sitefinity-custom/images/default-source/models/db11/db11_05_asset_019b9d02b9cf8b697fbc60ff00000f1b3f.jpg?sfvrsn=ab166bf9_2&w=1080&quality=60"));
            cars.add(new Car("BWM","http://mochamanstyle.com/wp-content/uploads/2015/10/2016-BMW-M2-Coupe.jpg"));
            cars.add(new Car("Audi","https://pbs.twimg.com/media/DZVSuX8VAAEra3K.jpg"));



        return cars;
    }
}
