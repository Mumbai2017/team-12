<?php
require 'init.php';
$_POST['wish'];

$sql="SELECT * from plan where wish like '%".$wish."%'";

$response=array();

if($response=mysqli_query($con,$sql)){
	$code="reg_success";
	$message="found plan";
}else{
	$message="Not found";
}
array_push($response, array("plan-id"=>$response[0]['plan_id'],"plan"=>$response[0]['plan']));

echo json_encode($response);

mysqli_close($con);


?>