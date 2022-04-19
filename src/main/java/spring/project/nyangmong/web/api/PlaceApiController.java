package spring.project.nyangmong.web.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import spring.project.nyangmong.domain.places.Places;
import spring.project.nyangmong.service.PlaceService;

@RequiredArgsConstructor
@RestController
public class PlaceApiController {

    private final PlaceService placeService;

    @GetMapping("/api/place/points")
    public ResponseEntity<?> loadPoints(@RequestParam(defaultValue = "") String category) {
        List<List<String>> points = new ArrayList<>();

        List<Places> places = placeService.전체보기();

        for (Places place : places) {
            List<String> point = new ArrayList<>();
            point.add(place.getLatitude());
            point.add(place.getLongitude());
            points.add(point);
        }

        return new ResponseEntity<>(points, HttpStatus.OK);
    }

    @GetMapping("/api/place/search")
    public ResponseEntity<?> totalSearch(@RequestParam(defaultValue = "") String keyword) {

        List<Places> places = placeService.총검색(keyword);

        return new ResponseEntity<>(places, HttpStatus.OK);
    }
}
