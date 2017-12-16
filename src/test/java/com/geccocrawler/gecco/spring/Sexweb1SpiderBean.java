package com.geccocrawler.gecco.spring;

import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * 处理	http://w3.afulyu.rocks/pw/htm_data/14/1712/916063.html 的spiderBean
 */
//@Gecco(matchUrl="http://w3.afulyu.rocks/pw/htm_data/{date}/{yearmonth}/{theone}.html", pipelines="consolePipeline")
//@PipelineName("sexweb1SpiderBean")
@Service("sexweb1SpiderBean")
@Gecco(matchUrl="http://w3.afulyu.rocks/pw/htm_data/{date}/{yearmonth}/{theone}.html", pipelines="sexweb1SpiderBean")
public class Sexweb1SpiderBean implements HtmlBean, Pipeline<Sexweb1SpiderBean> {


	private static final long serialVersionUID = -7127412585200687225L;
	
	@Request
	private HttpRequest request;
	
	@RequestParameter("date")
	private String date;
	
	@RequestParameter("yearmonth")
	private String yearmonth;

	@RequestParameter("theone")
	private String theone;
	
	@Text
	@HtmlField(cssPath="#subject_tpc")
	private String title;


	//抓取图片的src地址.
	// 图片的src的List.
	@Image
	@HtmlField(cssPath = "#read_tpc > img")
	public List<String> pics;


	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getYearmonth() {
		return yearmonth;
	}

	public void setYearmonth(String yearmonth) {
		this.yearmonth = yearmonth;
	}

	public String getTheone() {
		return theone;
	}

	public void setTheone(String theone) {
		this.theone = theone;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public List<String> getPics() {
		return pics;
	}

	public void setPics(List<String> pics) {
		this.pics = pics;
	}

	@Override
	public void process(Sexweb1SpiderBean sexweb1SpiderBean) {
		List<String> pics = sexweb1SpiderBean.getPics();
		for (int i = 0; i < pics.size(); i++) {
			System.out.println(pics.get(i));
		}
	}
}
