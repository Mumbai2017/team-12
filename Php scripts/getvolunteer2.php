<?php

require 'init.php';

$user_id = "1";
$date="2016-07-09 01:18:25";

$sql="select * from volunteer where volunteer_id='1';";
//echo $sql;
$res=mysqli_query($con,$sql);

$response=array();
while($row=mysqli_fetch_assoc($res)){

	array_push($response,array("lat"=>$row['lat'],"lon"=>$row['lon']));
}

echo json_encode($response);
?>