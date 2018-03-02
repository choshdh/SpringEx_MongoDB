package kr.co.cho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.cho.mongo.dao.MongoDao;
import kr.co.cho.mongo.vo.MongoTestVo;

@Controller
public class MongoTestController {
	
	@Autowired
	MongoDao mongoDao;

	@RequestMapping(value="/save")
	@ResponseBody
	public String saveTest() {
		
		MongoTestVo mongoTestVo = new MongoTestVo();
		mongoTestVo.set_id("1");
		mongoTestVo.setData1("데이터1");
		mongoTestVo.setData2("myData2");
		
		mongoDao.saveMongoData(mongoTestVo);
		
		return mongoTestVo.toString() + " 저장완료!";
	}
	
	@RequestMapping(value="/find")
	@ResponseBody
	public String findTest() {
		return mongoDao.findMongoData("_id", "1").toString()+" find complete";
	}
}
