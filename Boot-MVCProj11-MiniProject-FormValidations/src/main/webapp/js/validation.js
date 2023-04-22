
function doValidation(frm) {
	
	//empty the error messages after every request processing
	document.getElementById("ename.Err").innerHTML = "";
	document.getElementById("job.Err").innerHTML = "";
	document.getElementById("sal.Err").innerHTML = "";
	document.getElementById("deptno.Err").innerHTML = "";
	
	//declare variable and read from data
	let name = frm.ename.value;
	let job = frm.job.value;
	let sal = frm.sal.value;
	let deptno = frm.deptno.value;
	
	let isValid = true;
	
	//client-side validation logic
	// for name prop
	if(name=="") {	//required rule
		document.getElementById("enameErr").innerHTML = "Employee name is required***";
	} //if
	else if(name.length<5 || name.length>15){ 	//length rule
		document.getElementById("ename.Err").innerHTML = "Employee name mush contain >5 and <15 characters***"
	}//esle if
	
	// for job prop
	if(job=="") {	//required rule
		document.getElementById("jobErr").innerHTML = "Employee Designation is required***";
	} //if
	else if(job.length<5 || job.length>15){ 	//length rule
		document.getElementById("job.Err").innerHTML = "Employee Designation mush contain >5 and <15 characters***"
	}//esle if

	// for sal prop
	if(sal=="") {	//required rule
		document.getElementById("salErr").innerHTML = "Employee Salary is required***";
	} //if
	else if(sal<10000 || sal>200000){ 	//range rule
		document.getElementById("sal.Err").innerHTML = "Employee Salary mush be between 10000 to 200000***"
	}//esle if
	else if(isNaN(sal)){ 	//numeric value rule
		document.getElementById("sal.Err").innerHTML = "Employee Salary mush be only Numeric Value***"
	}//esle if
	
	// for deptno prop
	if(deptno=="") {	//required rule
		document.getElementById("jobErr").innerHTML = "Employee Department is required***";
	} //if
	
	return isValid;

}//function