<?php
require('init.php');

//$name=$_POST['name'];
$name=$_POST['name'];
$area=$_POST['area'];
$govtid=$_POST['govtid'];
$idno=$_POST['idno'];
$hospital='hospital';
$email=$_POST['email'];
$password=$_POST['password'];

/*$name='name';
$area='area';
$govtid='govtid';
$idno='5';
$hospital='hospital';*/


//$lat="54";
//$lon="1";

$sql="insert into volunteer(email,password,Name,Area,GovtID,IDno,Hospital,Approved,Points) values('$email','$password','$name','$area','$govtid','$idno','$hospital','0','0');";

/*$sql="INSERT INTO `volunteer` ( `Name`, `Area`, `GovtID`, `IDno`, `Hospital`, `Approved`, `Points`) VALUES ( 'rr', 'rr', '22', '323', 'dfsdf', '0', '1');";*/


/*$sql="insert into volunteer(IDno) values(5);";*/
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