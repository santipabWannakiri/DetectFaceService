package com.detect.face.API;

import java.io.File;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.detect.face.Util.Param;



public class DetectFaceAPI {

	public void DetectFaceAPIs(Param param) {
		HttpClient httpclient = HttpClients.createDefault();
		try {
			URIBuilder builder = new URIBuilder(param.getUri());

			// Request parameters. All of them are optional.
			builder.setParameter("returnFaceId", "true");
			builder.setParameter("returnFaceLandmarks", "false");
			builder.setParameter("returnFaceAttributes", param.getFaceAttributes());

			// Prepare the URI for the REST API call.
			URI uri = builder.build();
			HttpPost request = new HttpPost(uri);

			// Request headers.
			request.setHeader("Ocp-Apim-Subscription-Key", param.getKey());

			File file = new File(param.getImage());
			FileEntity reqEntity = new FileEntity(file, ContentType.APPLICATION_OCTET_STREAM);
			request.setEntity(reqEntity);

			HttpResponse response = httpclient.execute(request);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				// Format and display the JSON response.
				System.out.println("REST Response:\n");
				
//				String jsonString = EntityUtils.toString(entity).trim();
				System.out.println(EntityUtils.toString(entity));
//				if (jsonString.charAt(0) == '[') {
//					JSONArray jsonArray = new JSONArray(jsonString);
//					System.out.println(jsonArray.toString(2));
//				} else if (jsonString.charAt(0) == '{') {
//					JSONObject jsonObject = new JSONObject(jsonString);
//					System.out.println(jsonObject.toString(2));
//				} else {
//					System.out.println(jsonString);
//				}
			}
		} catch (Exception e) {
			// Display error message.
			System.out.println(e.getMessage());
		}
	}
}
