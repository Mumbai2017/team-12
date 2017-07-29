<?php
require('init.php');

//$name=$_POST['name'];
$wishType1=$_POST['wishtype1'];
$wish1=$_POST['wish1'];
$wish_desc1=$_POST['wish_desc1'];

$wishType2=$_POST['wishtype2'];
$wish2=$_POST['wish2'];
$wish_desc2=$_POST['wish_desc2'];

$wishType3=$_POST['wishtype3'];
$wish3=$_POST['wish3'];
$wish_desc3=$_POST['wish_desc3'];


/*$name='name';
$area='area';
$govtid='govtid';
$idno='5';
$hospital='hospital';*/


//$lat="54";
//$lon="1";

$sql="insert into childprofile(wish1,wish2,wish3,bigwish1,bigwish2,bigwish3) values('$email','$password','$name','$area','$govtid','$idno','$hospital','0','0');";

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