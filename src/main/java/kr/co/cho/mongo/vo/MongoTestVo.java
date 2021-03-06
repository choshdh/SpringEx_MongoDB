package kr.co.cho.mongo.vo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//MonoTestVo는 정보를 spring_ex 컬렉션에 집어 넣겠다.
@Document(collection="spring_ex")
public class MongoTestVo {
	
	//MongoTestVo의 _id 필드가 MongoDB의 pk 역할을 하는 _id 라는 것을 미리 알려준다.
	@Id
	private String _id;
	private String data1;
	private String data2;
	
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getData1() {
		return data1;
	}
	public void setData1(String data1) {
		this.data1 = data1;
	}
	public String getData2() {
		return data2;
	}
	public void setData2(String data2) {
		this.data2 = data2;
	}
	
	@Override
	public String toString() {
		return "MongoTestVo [_id=" + _id + ", data1=" + data1 + ", data2=" + data2 + "]";
	}
	
}
