<?php
require('init.php');

$sql="select * from childprofile where status == 5";
//echo $sql;
$res=mysqli_query($con,$sql);

$response=array();
while($row=mysqli_fetch_assoc($res)){
	array_push($response,array("name"=>$row['child_name'],"status"=>$row['status'],"hospital"=>$row['hospital'],"contact_no"=>$row['contact_no']));
}

echo json_encode($response);



?>