package com.example.springbootwithjpa.control;

import com.example.springbootwithjpa.configuration.FileManagerConfiguration;
import com.example.springbootwithjpa.model.ActivityLotteryCKeyModel;
import com.example.springbootwithjpa.service.ActivityService;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import static com.example.springbootwithjpa.utils.StringsUtil.getRandomFileName;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/11/10 16:13
 */
@RestController
@RequestMapping("/cvs")
public class ActivityControl {
	@Autowired
	private ActivityService activityService;

	@Autowired
	private FileManagerConfiguration fileConfig;

	@RequestMapping(value = "/exproCvs/{number}",method = RequestMethod.GET)
	public void gocvs(@PathVariable("number") Integer number, HttpServletResponse response) throws Exception {
		 /*String tmpDir = fileConfig.getSaveLinuxPath() + File.separator + getRandomFileName() + File.separator;
		 //activityService.fingExpro(number,response);
		List<ActivityLotteryCKeyModel> activityLotteryCKeyModelList=activityService.fingExpro(number);
		activityService.generateActivityCsv(activityLotteryCKeyModelList,tmpDir);*/
		//activityService.fingExpro(number,response);

		List<ActivityLotteryCKeyModel> activityLotteryCKeyModelList=activityService.fingExpro(number);
		//String path = memSalespersonService.exportDatasCsv(mobile, nickname, type, cate, center, name);
		String path= activityService.exportDatasCsv(activityLotteryCKeyModelList);
		InputStream in = null;
		File file = null;
		try {
			OutputStream output = response.getOutputStream();
			response.reset();

			// 读取字符编码
			String utf = "UTF-8";
			response.setContentType("application/ms-txt.numberformat:@");
			response.setCharacterEncoding(utf);
			response.setHeader("Pragma", "public");
			response.setHeader("Cache-Control", "max-age=30");
			response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("销代售后名单.csv", utf));
			if (StringUtils.isNotBlank(path)) {
				file = new File(path);
				in = new FileInputStream(file);
				IOUtils.copy(in, output);
				output.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
			}
			if (file != null) {
				try {
					file.delete();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
