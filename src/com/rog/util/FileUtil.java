package com.rog.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class FileUtil {
	private final static byte[] buff = new byte[65536];
    public static String getFromStore(String uri) throws FileNotFoundException,IOException{
    	String result = "";
    	File file = new File(uri);
    	if(!file.exists())
    		return result;
    	
	    if(file.length() < buff.length){
	        FileInputStream fis = null;
	        try{
	            fis = new FileInputStream(file);
	            int length = fis.read(buff);
	            return new String(buff,0,length);
	        }finally{
	            if(null != fis){
	                fis.close();
	            }
	        }
	    }else{
	        BufferedInputStream inputStream = null;
	        try{
	            inputStream = new BufferedInputStream(new FileInputStream(file));
	            return readAll(inputStream);
	        }catch(FileNotFoundException e){
	            return "";
	        }
	        finally{
	            if(null != inputStream){
	                inputStream.close();
	            }
	        }
	    }
    }
    
	public static String readAll(InputStream inputStream) throws IOException{
	    StringBuilder text;
	    BufferedReader buffReader = null;
	    try{
	        buffReader = new BufferedReader(new InputStreamReader(inputStream));
	        String line;
	        text = new StringBuilder();
	        
	        while((line = buffReader.readLine()) != null){
	            text.append(line);
	            text.append('\n');
	        }
	    }
	    catch(IOException e){
	        return "";
	    }finally{
	        if(null != buffReader){
	            buffReader.close();
	        }
	    }
	    return text.toString();
	}
	
	public static boolean SaveFileUTF8(String fullPath, String content) {
		boolean result = false;
		FileOutputStream fos = null;
		Writer out = null;
		try {
			fos = new FileOutputStream(fullPath);
			out = new OutputStreamWriter(fos, "utf-8");
			out.write(content);
			out.close();
			fos.close();
			result = true;
		} catch (FileNotFoundException e) {
		} catch (UnsupportedEncodingException e) {
		} catch (IOException e) {
		}

		return result;
	}
}
