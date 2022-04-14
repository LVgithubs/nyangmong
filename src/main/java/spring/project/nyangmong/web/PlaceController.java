package spring.project.nyangmong.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import spring.project.nyangmong.domain.places.PlaceRespository;
import spring.project.nyangmong.domain.places.Places;

@Controller
public class PlaceController {

    private PlaceRespository placeRespository;

    @GetMapping("/")
    public String main() {

        return "places/download";
    }

    @GetMapping("/list")
    public String download(Model model) {

        // 1. DB 연결
        RestTemplate rt = new RestTemplate();
        String url = "http://www.pettravel.kr/api/detailSeqPart.do?partCode=PC02&contentNum=1";

        Places[] response = rt.getForObject(url, Places[].class);

        List<Places> placesList = Arrays.asList(response);

        // DB에 saveAll() 호출
        placeRespository.saveAll(placesList);

        // 1. HospitalRepository의 findAll() 호출
        // 2. model에 담기
        model.addAttribute("hospitals", placeRespository.findAll());
        // model.addAttribute("hospitals", hosList);

        return "hospital/list";
    }

}
