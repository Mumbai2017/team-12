<?php
require('init.php');

$case_no=$_POST['case_no'];
$hospital=$_POST['hospital'];
$child_name=$_POST['child_name'];
$gender=$_POST['gender'];
$dob=$_POST['dob'];
$contact_no=$_POST['contact_no'];
$father_name=$_POST['father_name'];
$mother_name=$_POST['mother_name'];
$disease=$_POST['disease'];


/*$case_no="CSE11";
$hospital="Dsrv";
$child_name="Rahul";
$gender="M";
$dob="1999-12-25";
$contact_no=98767;
$father_name="uejd";
$mother_name="wejied";
$disease="cdi dowd";*/


$sql = "SELECT * FROM childprofile WHERE child_name like '{$child_name}%' and father_name like '{$father_name}%' and mother_name like '{$mother_name}%'";
//echo $sql."<br>";
$res = mysqli_query($con,$sql);

$response=array();

if (mysqli_num_rows($res) > 0) {
    $code="reg_fail";
	$message="Re-Registration ";
	array_push($response, array("code"=>$code,"message"=>$message));
}
else{
	
	$sql="insert into childprofile(case_no,hospital,child_name,sex,dob,contact_no,father_name,mother_name,disease) values('$case_no','$hospital','$child_name','$gender','$dob','$contact_no','$father_name','$mother_name','$disease');";
	//echo $sql;
	$response=array();

	if(mysqli_query($con,$sql)){
		$code="reg_success";
		$message="Registered Successfully";
	}else{
		$code="reg_fail";
		$message="Registration Failed";
	}
	array_push($response, array("code"=>$code,"message"=>$message));
}
echo json_encode($response);
mysqli_close($con);

?>