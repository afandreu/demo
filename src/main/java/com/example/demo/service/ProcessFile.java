package com.example.demo.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.JSONTokener;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Service
public class ProcessFile {

    private MetricsDto metricsDto;
	
	public Boolean readFile(String date) throws Exception {
		
		URL url = new  URL("https://raw.githubusercontent.com/vas-test/test1/master/logs/MCP_" + date + ".json");
		InputStream is = url.openStream();
		
		InputStreamReader isReader = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isReader);
        StringBuffer sb = new StringBuffer();
        String str;
        JSONParser parser = new JSONParser();
        metricsDto = new MetricsDto();
        metricsDto.setOriginDestination(new HashMap<String, Integer>());
        while((str = reader.readLine())!= null){
        	process(str, parser);
        }
        System.out.println(sb.toString());	

        return true;
	}
	
	private void process(String str, JSONParser parser) throws Exception {
		JSONObject json = (JSONObject) parser.parse(str);
        if(json.get("message_type") == null || json.get("message_type").toString().equals("") ){
        	metricsDto.setMissingFields(metricsDto.getMissingFields() + 1);
        };
        if(json.get("destination") != null) {
        	if(metricsDto.getOriginDestination().containsKey(json.get("destination").toString())) {
        		int num = metricsDto.getOriginDestination().get(json.get("destination").toString());
        		metricsDto.getOriginDestination().put(json.get("destination").toString(), num + 1);
        	} else {
        		metricsDto.getOriginDestination().put(json.get("destination").toString(), 1);
      	    }
        }
        
	}

	public MetricsDto getMetricsDto() {
		return metricsDto;
	}

	public void setMetricsDto(MetricsDto metricsDto) {
		this.metricsDto = metricsDto;
	}
}
