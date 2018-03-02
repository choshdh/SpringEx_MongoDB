package kr.co.cho.mongo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import kr.co.cho.mongo.vo.MongoTestVo;

@Component
public class MongoDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void saveMongoData(MongoTestVo mongoTestVo) {
		mongoTemplate.save(mongoTestVo); //save로 저장하기
	}
	
	public MongoTestVo findMongoData(String key,String value) {
		//MongoTemplate에서 조건을 검색하기 위해서 Criteria 클래스 사용
		Criteria criteria = new Criteria(key);
		criteria.is(value); //일치하는 값을 찾기위해 is 메소드사용
		
		//쿼리 객체 작성
		Query query = new Query(criteria);
		
		//쿼리를 사용한 조회
		MongoTestVo vo = mongoTemplate.findOne(query, MongoTestVo.class); //반환 캐스팅 될 타입 지정 을 .class 라고 지정해줌
		
		return vo;
	}
}
