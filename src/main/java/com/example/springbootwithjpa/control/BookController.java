package com.example.springbootwithjpa.control;


import com.example.springbootwithjpa.entity.Book;
import com.example.springbootwithjpa.entity.BookQuery;
import com.example.springbootwithjpa.entity.CommonResult;
import com.example.springbootwithjpa.service.BookQueryService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 分页控制器
 *
 * @author 廖聪聪
 * @version 1.0
 * 创建时间 2020/10/15 9:55
 */
@Controller
@RequestMapping(value = "/queryBook")
public class BookController {

	private static final Logger _log = LoggerFactory.getLogger(BookController.class);
	@Autowired
	BookQueryService bookQueryService;
	

	@RequestMapping("/findBookNoQuery")
	public String findBookNoQuery(ModelMap modelMap, @RequestParam(value = "page", defaultValue = "0") Integer page,
								  @RequestParam(value = "size", defaultValue = "5") Integer size){
		Page<Book> datas = bookQueryService.findBookNoCriteria(page, size);
		modelMap.addAttribute("datas", datas);
		return "index1";
	}

	@RequestMapping(value = "/findBookQuery",method = {RequestMethod.GET,RequestMethod.POST})
	public String findBookQuery(ModelMap modelMap, @RequestParam(value = "page", defaultValue = "0") Integer page,
								@RequestParam(value = "size", defaultValue = "5") Integer size, BookQuery bookQuery){
		Page<Book> datas = bookQueryService.findBookCriteria(page, size,bookQuery);
		modelMap.addAttribute("datas", datas);
		return "index2";
	}

	//_log.error("新增或修改活动配置异常 请求参数 {} ",articleSectionDto,e);
	@ResponseBody
	@GetMapping("/book/{name}")
	@ApiOperation(value = "查看书信息",notes = "查看书信息",httpMethod = "GET")
	public Object ByName(@PathVariable("name")String name){
		Book nameLike = null;
        try {
			 nameLike = bookQueryService.findByName(name);
		}catch (Exception e){
            _log.error("查看书信息配置异常 请求参数{}",name);
		}
        return new CommonResult().success("查询成功",nameLike);
	}
}
