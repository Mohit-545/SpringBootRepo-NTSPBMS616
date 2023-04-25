
function doValidation(frm) {
		
	//empty the old error messages after every request processing
	document.getElementById("enameErr").innerHTML = "";
	document.getElementById("jobErr").innerHTML = "";
	document.getElementById("salErr").innerHTML = "";
	document.getElementById("deptnoErr").innerHTML = "";
	
	//declare variable and read from data
	let name = frm.ename.value;
	let job = frm.job.value;
	let salary = frm.sal.value;
	let deptno = frm.deptno.value;
	
	let isValid = true;
	
	//client-side validation logic
	// for name prop
	if(name=="") {	//required rule
		document.getElementById("enameErr").innerHTML = "Employee name is required***";
		isValid = false;
	} //if
	else if(name.length<5 || name.length>15){ 	//length rule
		document.getElementById("ename.Err").innerHTML = "Employee name mush contain >5 and <15 characters***";
		isValid = false;
	}//esle if
	
	// for job prop
	if(job=="") {	//required rule
		document.getElementById("jobErr").innerHTML = "Employee Designation is required***";
		isValid = false;
	} //if
	else if(job.length<5 || job.length>15){ 	//length rule
		document.getElementById("job.Err").innerHTML = "Employee Designation mush contain >5 and <15 characters***";
		isValid = false;
	}//esle if

	// for sal prop
	if(salary=="") {	//required rule
		document.getElementById("salErr").innerHTML = "Employee Salary is required***";
		isValid = false;
	} //if
	else if(salary<10000 || salary>200000){ 	//range rule
		document.getElementById("salErr").innerHTML = "Employee Salary mush be between 10000 to 200000***";
		isValid = false;
	}//esle if
	else if(isNaN(salary)){ 	//numeric value rule
		document.getElementById("salErr").innerHTML = "Employee Salary mush be only Numeric Value***";
		isValid = false;
	}//esle if
	
	// for deptno prop
	if(deptno=="") {	//required rule
		document.getElementById("jobErr").innerHTML = "Employee Department is required***";
		isValid = false;
	} //if
	
	alert("Client side validations performed");
	//for confirming that client side validations are performed and server side validations are not required 
	frm.vflag.value = "yes";
	return isValid;

}//function