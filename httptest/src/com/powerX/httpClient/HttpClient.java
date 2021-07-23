package com.powerX.httpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpClient {
	public static String doGet(String httpurl) {
		HttpURLConnection connection = null;
		InputStream is = null;
		BufferedReader br = null;
		String result = null;// ���ؽ���ַ���
		try {
			// ����Զ��url���Ӷ���
			URL url = new URL(httpurl);
			// ͨ��Զ��url���Ӷ����һ�����ӣ�ǿת��httpURLConnection��
			connection = (HttpURLConnection) url.openConnection();
			// �������ӷ�ʽ��get
			connection.setRequestMethod("GET");
			// �������������������ĳ�ʱʱ�䣺15000����
			connection.setConnectTimeout(15000);
			// ���ö�ȡԶ�̷��ص�����ʱ�䣺60000����
			connection.setReadTimeout(60000);
			// ��������
			connection.connect();
			// ͨ��connection���ӣ���ȡ������
			if (connection.getResponseCode() == 200) {
				is = connection.getInputStream();
				// ��װ������is����ָ���ַ���
				br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				// �������
				StringBuffer sbf = new StringBuffer();
				String temp = null;
				while ((temp = br.readLine()) != null) {
					sbf.append(temp);
					sbf.append("\r\n");
				}
				result = sbf.toString();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// �ر���Դ
			if (null != br) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			connection.disconnect();// �ر�Զ������
		}
		return result;
	}

	public static String doPost(String httpUrl, String param) {
		HttpURLConnection connection = null;
		InputStream is = null;
		OutputStream os = null;
		BufferedReader br = null;
		String result = null;
		try {
			URL url = new URL(httpUrl);
			// ͨ��Զ��url���Ӷ��������
			connection = (HttpURLConnection) url.openConnection();
			// ������������ʽ
			connection.setRequestMethod("POST");
			// ��������������������ʱʱ�䣺15000����
			connection.setConnectTimeout(15000);
			// ���ö�ȡ�����������������ݳ�ʱʱ�䣺60000����
			connection.setReadTimeout(60000);
			// Ĭ��ֵΪ��false������Զ�̷�������������/д����ʱ����Ҫ����Ϊtrue
			connection.setDoOutput(true);
			// Ĭ��ֵΪ��true����ǰ��Զ�̷����ȡ����ʱ������Ϊtrue���ò������п���
			connection.setDoInput(true);
			// ���ô�������ĸ�ʽ:�������Ӧ���� name1=value1&name2=value2 ����ʽ��
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			// ���ü�Ȩ��Ϣ��Authorization: Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0
			connection.setRequestProperty("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");
			// ͨ�����Ӷ����ȡһ�������
			os = connection.getOutputStream();
			// ͨ����������󽫲���д��ȥ/�����ȥ,����ͨ���ֽ�����д����
			os.write(param.getBytes());
			// ͨ�����Ӷ����ȡһ������������Զ�̶�ȡ
			if (connection.getResponseCode() == 200) {
				is = connection.getInputStream();
				// ��������������а�װ:charset���ݹ�����Ŀ���Ҫ��������
				br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				StringBuffer sbf = new StringBuffer();
				String temp = null;
				// ѭ������һ��һ�ж�ȡ����
				while ((temp = br.readLine()) != null) {
					sbf.append(temp);
					sbf.append("\r\n");
				}
				result = sbf.toString();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// �ر���Դ
			if (null != br) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != os) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// �Ͽ���Զ�̵�ַurl������
			connection.disconnect();
		}
		return result;
	}

	public static void main(String[] args) {

		String auth = "\"INITKEYMKBdPDph\"";
		System.out.println(doPost("http://0.0.0.0:8080/auth", "{\"authKey\":" + auth + "}"));
		String sessionKey="zHuhDt7I";
		
		System.out.println(doPost("http://0.0.0.0:8080/verify", "{\r\n"
				+ "    \"sessionKey\": \""+sessionKey+"\",\r\n"
				+ "    \"qq\": 2473537565\r\n"
				+ "}"));
		
		System.out.println(doPost("http://0.0.0.0:8080/sendGroupMessage", "{\r\n"
				+ "    \"sessionKey\": \""+sessionKey+"\",\r\n"
				+ "    \"target\": 317109237,\r\n"
				+ "    \"messageChain\": [\r\n"
				+ "        { \"type\": \"Plain\", \"text\": \"����\" },\r\n"
				+ "        { \"type\": \"Plain\", \"text\": \"\" },\r\n"
				+ "	{ \"type\": \"Image\", \"url\": \"https://i0.hdslb.com/bfs/album/67fc4e6b417d9c68ef98ba71d5e79505bbad97a1.png\" }\r\n"
				+ "    ]\r\n"
				+ "}"));
		
//		System.out.println(doPost("http://0.0.0.0:8080/about", ""));
	}
}
