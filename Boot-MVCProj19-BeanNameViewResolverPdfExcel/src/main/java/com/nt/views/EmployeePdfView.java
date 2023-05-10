//EmployeePdfView.java
package com.nt.views;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.model.Employee;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("pdfReport")
public class EmployeePdfView extends AbstractPdfView {
	
	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get Model Attribute
		Iterable<Employee> empList = (Iterable<Employee>) map.get("empList");
		//add Paragraph
		Paragraph paragraph = new Paragraph("Employee Report", new Font(Font.BOLD));
		paragraph.setAlignment("CENTER");
		document.add(paragraph);
		//add Table
		Table table = new Table(5, ((ArrayList)empList).size());
		table.addCell("EmpNo");
		table.addCell("Ename");
		table.addCell("Job");
		table.addCell("Sal");
		table.addCell("DeptNo");
		for(Employee emp:empList) {
			table.addCell(String.valueOf(emp.getEmpno()));
			table.addCell(emp.getEname());
			table.addCell(emp.getJob());
			table.addCell(String.valueOf(emp.getSal()));
			if(emp.getDeptno()!=null)
				table.addCell(String.valueOf(emp.getDeptno()));
			else
				table.addCell("");
		}//for
		document.add(table);
		
	}//method

}//class
