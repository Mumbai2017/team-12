<?php

require 'init.php';

$user_id = "1";
$date="2016-07-09 01:18:25";

$sql="select * from childprofile where vol_id='1';";
//echo $sql;
$res=mysqli_query($con,$sql);

$response=array();
while($row=mysqli_fetch_assoc($res)){

	array_push($response,array("id"=>$row['id'],"case_no"=>$row['case_no']));
}

echo json_encode($response);
?>