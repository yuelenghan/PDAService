package com.ghtn.controller;

import com.ghtn.service.PlaceManager;
import com.ghtn.vo.PlaceAreaVO;
import com.ghtn.vo.PlaceVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lihe on 14/9/15.
 */
@Controller
@RequestMapping("/place")
public class PlaceController extends BaseController {

    private PlaceManager placeManager;

    @Resource
    public void setPlaceManager(PlaceManager placeManager) {
        this.placeManager = placeManager;
    }

    @RequestMapping("/areas")
    @ResponseBody
    public List<PlaceAreaVO> getAreas(String mainDeptId) {
        return placeManager.getAreasOracleDataSource3(mainDeptId);
    }

    @RequestMapping("/places")
    @ResponseBody
    public List<PlaceVO> getPlaces(int areaId) {
        return placeManager.getPlacesOracleDataSource3(areaId);
    }
}
