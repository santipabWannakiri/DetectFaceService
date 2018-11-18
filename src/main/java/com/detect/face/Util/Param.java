package com.detect.face.Util;

public class Param {
	
	String uri;
	String key;
	String image;
	String faceAttributes;
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getFaceAttributes() {
		return faceAttributes;
	}
	public void setFaceAttributes(String faceAttributes) {
		this.faceAttributes = faceAttributes;
	}
	
	@Override
	public String toString() {
		return "Param [uri=" + uri + ", key=" + key + ", image=" + image + ", faceAttributes=" + faceAttributes + "]";
	}
	
	
	

}
