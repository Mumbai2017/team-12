<?php
require 'init.php';
$wish=$_POST['wish'];

$sql="SELECT * from plan where wish like '%".$wish."%'";

$response=array();

if($result=mysqli_query($con,$sql)){
	while($row=mysqli_fetch_assoc($result)){
	array_push($response, array("plan-id"=>$row['plan_id'],"plan"=>$row['plan']));
	    }
	}
echo json_encode($response);
mysqli_close($con);

?>