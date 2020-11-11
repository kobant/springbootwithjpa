package com.example.springbootwithjpa.service.Impl;

import com.csvreader.CsvWriter;
import com.example.springbootwithjpa.consts.ActivityReportConstants;
import com.example.springbootwithjpa.dao.ActivityRepository;
import com.example.springbootwithjpa.model.ActivityLotteryCKeyModel;
import com.example.springbootwithjpa.service.ActivityService;
import com.example.springbootwithjpa.utils.CsvUtil;
import com.example.springbootwithjpa.utils.MapPojoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/11/10 14:39
 */
@Service
public class ActivityServiceImpl implements ActivityService {

	private static final Logger log = LoggerFactory.getLogger(ActivityServiceImpl.class);

	@Autowired
	private ActivityRepository activityRepository;

	/**
	 * 输入的数字导出csv文件
	 * @param number
	 * @return
	 */
	@Override
	public void fingExpro(Integer number, HttpServletResponse response) throws Exception {
		List<ActivityLotteryCKeyModel> lotteryCKeyModels= activityRepository.fingExpro(number);
		List<Map<String, Object>> dataList = new ArrayList<>();
		Map<String, Object> data;

		for (ActivityLotteryCKeyModel lotteryCKeyModel:lotteryCKeyModels){
			lotteryCKeyModel.setId(lotteryCKeyModel.getId());
			lotteryCKeyModel.setCode(lotteryCKeyModel.getCode());
			lotteryCKeyModel.setCreTime(lotteryCKeyModel.getCreTime());
		//	String isDelete= lotteryCKeyModel.getIsDelete().equals("1")?"有效":"无效";
			//lotteryCKeyModel.setIsDelete(Integer.valueOf(isDelete).intValue());
			String ModTime=lotteryCKeyModel.getModTime()==null?"": String.valueOf(lotteryCKeyModel.getModTime());
            lotteryCKeyModel.setModTime(Long.valueOf(ModTime));
			lotteryCKeyModel.setNineLatticesID(lotteryCKeyModel.getNineLatticesID());
			lotteryCKeyModel.setSsoid(lotteryCKeyModel.getSsoid());
			//String status=lotteryCKeyModel.getStatus()==0?"未开始":"进行中";
			//lotteryCKeyModel.setStatus(Integer.valueOf(status).intValue());
			//bodyArray[8]=lotteryCKeyModel.getTxTime();

			data = MapPojoUtils.object2Map(lotteryCKeyModel);
			System.out.println("测试数据："+data);
			dataList.add(data);
		}
		String title = "Excel-";
		String titles = "序号,兑换码,创建时间,是否有效,编辑,活动id,用户id,状态,生成时间";
		String keys = "id,code,creTime,isDelete,modTime,nineLatticesID,ssoid,status,txTime";

		// 文件导出
		OutputStream os = response.getOutputStream();
		CsvUtil.responseSetProperties(title, response);
		CsvUtil.doExport(dataList, titles, keys, os);
		os.close();
		//return null;
	}

	@Override
	public List<ActivityLotteryCKeyModel> fingExpro(Integer number) {
		return activityRepository.fingExpro(number);
	}

	@Override
	public void generateActivityCsv(List<ActivityLotteryCKeyModel> list, String path) {
		CsvWriter csvWriter = new CsvWriter(path + "【活动数据】.csv", ',', Charset.forName("GBK"));
		String[] bodyArray = new String[ActivityReportConstants.CUSTOMER_HEADER.length];
		try {
           csvWriter.writeRecord(ActivityReportConstants.CUSTOMER_HEADER);
           //int i = 1;
           for (ActivityLotteryCKeyModel lotteryCKeyModel :list){
           	   bodyArray[0] = String.valueOf(lotteryCKeyModel.getId());
               bodyArray[1]=lotteryCKeyModel.getCode();
               bodyArray[2]= String.valueOf(lotteryCKeyModel.getCreTime());
               bodyArray[3]=lotteryCKeyModel.getIsDelete().equals("1")?"有效":"无效";
               bodyArray[4]=lotteryCKeyModel.getModTime()==null?"": String.valueOf(lotteryCKeyModel.getModTime());
               bodyArray[5]= String.valueOf(lotteryCKeyModel.getNineLatticesID());
               bodyArray[6]= String.valueOf(lotteryCKeyModel.getSsoid());
               bodyArray[7]=lotteryCKeyModel.getStatus()==0?"未开始":"进行中";
               bodyArray[8]=lotteryCKeyModel.getTxTime();
               csvWriter.writeRecord(bodyArray);
		   }
           csvWriter.flush();
		}catch (Exception e){
           log.error("活动数据csv文件生成异常",e);
		}finally {
			csvWriter.close();
		}
	}

	@Override
	public String exportDatasCsv(List<ActivityLotteryCKeyModel> list) {
		CsvWriter writer = null;
		FileOutputStream out = null;

		try {
			File tmpFile = new File(System.getProperty("java.io.tmpdir") + File.separator + UUID.randomUUID().toString() + ".csv");
			if (!tmpFile.exists()) {
				tmpFile.createNewFile();
			}
			String[] headers = {"序号", "兑换码", "创建时间", "是否有效", "编辑", "活动id",
					"用户id", "状态", "生成时间"};
			out = new FileOutputStream(tmpFile, true);
			writer = new CsvWriter(out, ',', Charset.forName("GBK"));
			writer.writeRecord(headers);
			String[] row;
			for (ActivityLotteryCKeyModel lotteryCKeyModel : list) {
				row = new String[headers.length];
				int j = 0;
				row[j++] = String.valueOf(lotteryCKeyModel.getId());
				row[j++] = lotteryCKeyModel.getCode();
				//SalespersonTypeEnum stype = SalespersonTypeEnum.parse(String.valueOf(item.getType()));
				row[j++] =String.valueOf(lotteryCKeyModel.getCreTime());
				row[j++] = lotteryCKeyModel.getIsDelete().equals("1")?"有效":"无效";
				row[j++] = lotteryCKeyModel.getModTime()==null?"": String.valueOf(lotteryCKeyModel.getModTime());
				row[j++] = String.valueOf(lotteryCKeyModel.getNineLatticesID());
				row[j++] =  String.valueOf(lotteryCKeyModel.getSsoid());
				row[j++] =  lotteryCKeyModel.getStatus()==0?"未开始":"进行中";
				row[j++] =  lotteryCKeyModel.getTxTime();
				writer.writeRecord(row);
			}
			return tmpFile.getAbsolutePath();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (null != writer) {
				writer.close();
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
