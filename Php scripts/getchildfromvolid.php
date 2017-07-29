<?php

require 'init.php';

$user_id = "1";
$date="2016-07-09 01:18:25";

$volun_id = $_POST['id'];


$sql="select * from childprofile where vol_id='$volun_id';";
//echo $sql;
$res=mysqli_query($con,$sql);

$response=array();
while($row=mysqli_fetch_assoc($res)){
	array_push($response,array("child_name"=>$row['child_name'],"hospital"=>$row['hospital'],"contact_no"=>$row['contact_no'],"disease"=>$row['disease'],"status"=>$row['status']));
}

echo json_encode($response);
?>