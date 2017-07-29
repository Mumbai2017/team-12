<?php

require 'init.php';

$name=$_POST['name'];
$pass=$_POST['pass'];

$name='email';
$pass='password';



$sql="select * from volunteer where email='$name' and password='$pass';";
//echo $sql;
$res=mysqli_query($con,$sql);

$response=array();
while($row=mysqli_fetch_assoc($res)){

	echo "Login success";
}

//echo json_encode($response);
?>