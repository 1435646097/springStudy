//package com.paigu.interview.es;
//
//import org.apache.http.HttpHost;
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestHighLevelClient;
//
//public class CreateIndex {
//	public static void main(String[] args) throws Exception{
//		RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200)));
////		CreateIndexResponse response = client.indices().create(new CreateIndexRequest("shopping"), RequestOptions.DEFAULT);
////		DeleteIndexRequest request = new DeleteIndexRequest("shopping");
////		AcknowledgedResponse response = client.indices()
////		                                    .delete(request, RequestOptions.DEFAULT);
////		System.out.println(response.isAcknowledged());
//		client.close();
//	}
//}
