<?php
$db="cfg";
$host="localhost:3306";
$password="root";
$user="root";

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