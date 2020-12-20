package com.t2s.resourses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.t2s.services.MovementReportService;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping(path = "/movementreport")
public class MovementReportResource {
	
	@Autowired
	MovementReportService reportService;

	@GetMapping
	public String getReport() throws FileNotFoundException, JRException, ParseException{
		
		List<String> info = reportService.exportReport();
		info.get(0);
		String filepath = info.get(0);
		
		
		
		//return result.getAbsoluteFile(); 
		
		File result = ResourceUtils.getFile(filepath);
		StringBuilder contentBuilder = new StringBuilder();
		try {
		    BufferedReader in = new BufferedReader(new FileReader(result));
		    String str;
		    while ((str = in.readLine()) != null) {
		        contentBuilder.append(str);
		    }
		    str = "<h1> IMPORT = "+info.get(1)+" EXPORT = "+info.get(2)+" </h1>";
		    contentBuilder.append(str);
		    in.close();
		} catch (IOException e) {
		}
		String content = contentBuilder.toString();
		return content;
		
		
		
		
	}
}