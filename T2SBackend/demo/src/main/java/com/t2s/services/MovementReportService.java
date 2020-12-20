package com.t2s.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.t2s.entities.MovementReport;
import com.t2s.repositories.MovementRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class MovementReportService {

	@Autowired
	MovementRepository mr;

	public List<String> exportReport() throws FileNotFoundException, JRException, ParseException {

		Path currentWorkingDir = Paths.get("").toAbsolutePath();
        String static_dir = currentWorkingDir.normalize().toString()+"\\src\\main\\resources\\static";
		int EXPORT = 0;
		int IMPORT = 0;
		
		List<String> teste = mr.innverJoinMovementReport();
		List<MovementReport> movements = new ArrayList<>();
		for (String obj : teste) {
			String[] values = obj.split(",");
			if(values[1].equals("0")) {
				IMPORT++;
			}
			else {
				EXPORT++;
			}
			movements.add(new MovementReport(values[0], Integer.parseInt(values[1]), Integer.parseInt(values[2]),
					values[3], values[4], values[5]));
		}

		for (MovementReport movementReport : movements) {
			System.out.println(movementReport.toString());
		}

		// cria o arquivo
		File file = ResourceUtils.getFile("classpath:movements.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(movements);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("createdBy", "allan");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		JasperExportManager.exportReportToHtmlFile(jasperPrint, static_dir+"\\MovementReport.html");
		
		
		
		List<String> elements = new ArrayList<>();
		elements.add(static_dir+"\\MovementReport.html");
		elements.add(String.valueOf(IMPORT));
		elements.add(String.valueOf(EXPORT));
		
		return elements;


	}
}
