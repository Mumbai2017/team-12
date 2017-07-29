<?php

require 'init.php';

$user_id = "1";
$date="2016-07-09 01:18:25";

$doc_id = $_POST['doc_id'];
//$doc_id="1";


$sql="select * from childprofile where doctor_id='$doc_id';";
//echo $sql;
$res=mysqli_query($con,$sql);

$response=array();
while($row=mysqli_fetch_assoc($res)){
	array_push($response,array("name"=>$row['child_name'],"status"=>$row['status'],"hospital"=>$row['hospital'],"contact_no"=>$row['contact_no']));
}

echo json_encode($response);
?>