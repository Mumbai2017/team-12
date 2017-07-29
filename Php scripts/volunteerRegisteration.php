<?php

include "init.php";

if($_GET['uname']!=NULL && $_GET['password']!=NULL && $_GET['email']!=NULL && $_GET['address']!=NULL){
	$sql = "INSERT INTO `users`(`name`, `password`, `email`, `address`) VALUES ('".$_GET['uname']."','".$_GET['password']."','".$_GET['email']."','".$_GET['address']."')";
	if ($conn->query($sql) === TRUE) {
		
		
		$sql = "CREATE TABLE {$_GET['uname']}bag\n"
    . "(\n"
    . "product_id int,\n"
    . "product_gender varchar(20),\n"
    . "product_type varchar(20),\n"
    . "product_name varchar(100),\n"
    . "product_price int,\n"
    . "product_description varchar(300),\n"
    . "product_pic varchar(100)\n"
    . ")";
	
	
		if($conn->query($sql) === TRUE){
			echo '<script language="javascript">';
			echo 'alert("User registration Complete Welcom to LetsBuy")';
			echo '</script>';
		
			echo "<script> window.location.assign('index.php'); </script>";
			exit();
		}
		
		
		
		
		
	} else {
		echo "Error: " . $sql . "<br>" . $conn->error;
		echo '<script language="javascript">';
		echo 'Error: ' . $sql . '<br>';
		echo '</script>';
	}
}

?>