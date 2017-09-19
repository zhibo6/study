package org.study.demo.csdn;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.study.util.HttpClientUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class RequestTask extends TimerTask {
	private static Logger logger = LoggerFactory.getLogger(RequestTask.class);
	private String urlFilePath = "/data/url.txt";
	private int i = 0;
	private List<String> urlList = new ArrayList<String>();
	@Override
	public void run() {
		try{
			String url = urlList.get(i);
			System.out.println(i + "--" + url);
			HttpClientUtil.httpGet(url);
			i = (++i % urlList.size());
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String [] args){
		RequestTask rt = new RequestTask();
	}

	public RequestTask(){
		initUrlList();
	}
	private void initUrlList() {
		File file = null;
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try{
			file = new File(RequestTask.class.getResource(urlFilePath).getFile());
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis, "UTF-8");
			br = new BufferedReader(isr);
			String line = "";
			while((line = br.readLine()) != null){
				if(line != null && line.length() > 0) {
					urlList.add(line);
					System.out.println(line);
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			IOUtils.closeQuietly(br);
			IOUtils.closeQuietly(isr);
			IOUtils.closeQuietly(fis);
		}
	}
}
