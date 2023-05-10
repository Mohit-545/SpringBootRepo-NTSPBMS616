//EmployeeExcelView.java
package com.nt.views;

import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.nt.model.Employee;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("excelReport")
public class EmployeeExcelView extends AbstractXlsView {
	
	private int i=0;
	
	@Override
	protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// get Model attribute
		Iterable<Employee> empList = (Iterable<Employee>) map.get("empList");
		//create Sheet
		Sheet sheet1 = workbook.createSheet("Sheet1");
		
		//add rows to sheet
		empList.forEach(emp->{
			Row row = sheet1.createRow(0);
			row.createCell(0).setCellValue("EmpNo");
			row.createCell(1).setCellValue("Ename");
			row.createCell(2).setCellValue("Job");
			row.createCell(3).setCellValue("Sal");
			row.createCell(4).setCellValue("DeptNo");
			//add Row sheet representing Employee Record
			Row row1 = sheet1.createRow(i);
			//add cells to Row
			row1.createCell(0).setCellValue(emp.getEmpno());
			row1.createCell(1).setCellValue(emp.getEname());
			row1.createCell(2).setCellValue(emp.getJob());
			row1.createCell(3).setCellValue(emp.getSal());
			if(emp.getDeptno()!=null) {
				row1.createCell(4).setCellValue(emp.getEmpno());
			}
			i++;
		});
		
	}//method

}//class
