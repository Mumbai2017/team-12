<?php
$db="freeecom_cfg";
$host="103.233.76.243";
$password="worldmart123";
$user="freeecom_gps";

/*$user="root";
$password="";
$db="gps";
$host="localhost";*/


$con=mysqli_connect($host,$user,$password,$db);

if($con){
//echo "Connection successful";
}else{
	//echo "Error in conncetion";
}

?>