package com.detect.face.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.detect.face.API.DetectFaceAPI;
import com.detect.face.Util.Param;


@Controller
public class ViewController {
	
	private Param param = new Param();
	private DetectFaceAPI detectFaceAPI = new DetectFaceAPI();

	@GetMapping("/")
	public ModelAndView indexShow() {
		ModelAndView modelAndView = new ModelAndView();

		param.setUri("https://westcentralus.api.cognitive.microsoft.com/face/v1.0/detect");
		param.setKey("f1d09115c4374094bf813ab9e9298762");
		param.setImage("C://Users//Nokia3310//Desktop//gg.jpg");
		param.setFaceAttributes("age,gender,headPose,smile,facialHair,glasses,emotion,hair,makeup,occlusion,accessories,blur,exposure,noise");
		detectFaceAPI.DetectFaceAPIs(param);
		
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
}
