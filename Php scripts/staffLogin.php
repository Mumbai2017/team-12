<?php

require 'init.php';

$name=$_POST['name'];
$pass=$_POST['pass'];

$sql="select * from staff where email='$name' and phone_no='$pass';";
//echo $sql;
$res=mysqli_query($con,$sql);

$response=array();
if($row=mysqli_fetch_assoc($res)){

	echo "Login success";
}

//echo json_encode($response);
?>