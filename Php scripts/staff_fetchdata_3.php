<?php
require('init.php');

$sql = "SELECT * from childprofile where status==5"
$response=array();

if($result=mysqli_query($con,$sql)){
	while($row=mysqli_fetch_assoc($result)){
        array_push($response,array("child_name"=>$row['child_name'],"id"=>$row['id'],"hospital"=>$row['hospital'],"contact_no"=>$row['contact_no'],"approved_wish"=>$row['approved_wish'],"status"=>$row['status']),"donor"=>$row['donor_id'],);
          }
	}
echo json_encode($response);



?>