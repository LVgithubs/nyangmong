package spring.project.nyangmeong.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import spring.project.nyangmeong.domain.image.ImageRepository;
import spring.project.nyangmeong.places.Places;
import spring.project.nyangmeong.places.PlacesRepository;

@RequiredArgsConstructor
@Service
public class PlacesService {
    private final PlacesRepository placesRepository;
    private final ImageRepository imageRepository;

    public Places 상세보기(Integer contentSeq) {
        Optional<Places> placesOp = placesRepository.findById(contentSeq);

        if (placesOp.isPresent()) {
            return placesOp.get();
        } else {
            throw new RuntimeException("해당 관광정보를 찾을 수 없습니다");
        }
    }

    public List<Places> 분류검색(String partName) {
        List<Places> pList = placesRepository.searchPartName(partName);
        return pList;
    }

    public List<Places> 전체보기() {
        List<Places> plist = placesRepository.findAll();
        return plist;
    }

    public boolean 옵션표시(String yesOrNO) {
        if (yesOrNO.equals("Y")) {
            return true;
        }
        return false;
    }
}