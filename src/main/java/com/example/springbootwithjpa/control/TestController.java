/*
package com.example.springbootwithjpa.control;

import com.example.springbootwithjpa.service.GoodsStoreFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/")
public class TestController {

	@Autowired
	private GoodsStoreFacade goodsStoreService;

	*/
/**
	 * 进入测试页面
	 * @param model
	 * @return
	 *//*

	@GetMapping("test")
	public ModelAndView stepOne(Model model){
		return new ModelAndView("test", "model", model);
	}

	*/
/**
	 * 秒杀提交
	 * @param code
	 * @param num
	 * @return
	 *//*

	@PostMapping("secKill")
	@ResponseBody
	public String secKill(@RequestParam(value="code",required=true) String code,@RequestParam(value="num",required=true) Integer num){
		String reString = goodsStoreService.updateGoodsStore(code, num);
		return reString;
	}
}
*/
