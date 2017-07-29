<?php
require('init.php');

//$name=$_POST['name'];
/*$name=$_POST['name'];
$area=$_POST['area'];
$govtid=$_POST['govtid'];
$idno=$_POST['idno'];
$hospital=$_POST['hospital'];*/

$name='name';
$area='area';
$govtid='govtid';
$idno='idno';
$hospital='hospital';

//$lat="54";
//$lon="1";

$sql="insert into volunteer(Name,Area,GovtID,IDno,Hospital,Approved,Points) values('name','$area','$govtid','$idno','$hospital','0','0');";
$response=array();

if(mysqli_query($con,$sql)){
	$code="reg_success";
	$message="Registered Successfully";
}else{
	$code="reg_fail";
	$message="Registration Failed";
}
array_push($response, array("code"=>$code,"message"=>$message));

echo json_encode($response);

mysqli_close($con);

?>