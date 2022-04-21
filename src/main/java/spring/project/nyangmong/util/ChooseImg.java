package spring.project.nyangmong.util;

import java.util.ArrayList;
import java.util.List;

import spring.project.nyangmong.domain.places.Places;

public class ChooseImg {

    public static List<String> imgList(List<Places> places) {
        List<String> images = new ArrayList<>();
        for (Places place : places) {
            images.add(place.getImageList().get(0).getImgurl());
        }
        return images;
    }
}
