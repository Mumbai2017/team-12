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

$id = $_POST['id'];
$hospital = $_POST['hospital'];

/*$name='name';
$area='area';
$govtid='govtid';
$idno='5';
$hospital='hospital';*/

$sql = "UPDATE TABLE childprofile set wish1=".$wishType1.' '.$wish1.",wish2=".$wishType2.' '.$wish2.",wish3=".$wishType3.' '.$wish3.", bigwish1=".$wish_desc1.", bigwish2=".$wish_desc2.", bigwish3=".$wish_desc3." where id=".$id."; ";

$response=array();

if(mysqli_query($con,$sql)){
	$code="reg_success";
	$message="Registered Successfully";
}else{
	 
	$code="reg_fail";
	$message="Registration Failed";
}


$sql = "select * from volunteer where hospital like '{$hospital}' ORDER BY date ASC";
$res = mysqli_query($con,$sql);
$row=mysqli_fetch_assoc($res)//get first row only


$sql = "Update childprofile set vol_id='{$row['volunteer_id']}', status = 3 where id='{$id}'";

array_push($response, array("code"=>$code,"message"=>$message));

echo json_encode($response);

mysqli_close($con);

?>