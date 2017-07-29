<?php
$db="cfg";
$host="localhost";
$password="root";
$user="force";

/*$user="root";
$password="";
$db="gps";
$host="localhost";*/


$con=mysqli_connect($host,$user,$password,$db);

if($con){
echo "Connection successful";
}else{
	echo "Error in conncetion";
}

?>