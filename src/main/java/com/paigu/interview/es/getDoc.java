package com.paigu.interview.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class getDoc {
	public static void main(String[] args) throws Exception{
		RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200)));
//		GetRequest request = new GetRequest();
//		request.index("shopping").id("10001");
//		request.index("shopping").id("10001");
//		Book book = new Book("小红书", BigDecimal.valueOf(200));
//		String bookJson = JSON.toJSONString(book);
//		request.source(bookJson, XContentType.JSON);
//		client.index(request, RequestOptions.DEFAULT);
//		GetResponse response = client.get(request, RequestOptions.DEFAULT);
//		String sourceAsString = response.getSourceAsString();
//		Book book = JSON.parseObject(sourceAsString, Book.class);
//		System.out.println(sourceAsString);
//		System.out.println(response.isAcknowledged());
		client.close();
	}
}
