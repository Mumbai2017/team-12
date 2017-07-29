<?php

include "init.php";

if($_POST['volunteer_id'])
{
	$sql = $sql = "Select * from childprofile WHERE vol_id = ".$_POST['volunteer_id'];
	$result = $conn->query($sql);
	if ($result->num_rows > 0) {
		
		while($row = $result->fetch_assoc()){
			
			echo row;
	
		}
		
	}
	
}


?>