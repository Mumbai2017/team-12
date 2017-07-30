<?php

require 'init.php';

$name=$_POST['name'];
$pass=$_POST['pass'];

$sql="select * from donor where email='$name' and password='$pass';";
//echo $sql;
$res=mysqli_query($con,$sql);

$response=array();
if($row=mysqli_fetch_assoc($res)){

	echo "Login success";
}

//echo json_encode($response);
?>