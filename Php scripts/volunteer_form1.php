<?php
require('init.php');

        /*$id = $_POST['id'];
        $aboutFamily= $_POST['aboutFamily'];
        $aboutFriends= $_POST['aboutFriends'];
        $parentId = $_POST['parentId'];
        $color= $_POST['color'];
        $game= $_POST['game'];
        $food= $_POST['food'];
        $music= $_POST['music'];
        $hobby= $_POST['hobby'];
        $tv_show= $_POST['tv_show'];
        $actor= $_POST['actor'];
        $trip= $_POST['trip'];
        $describePlan= $_POST['describePlan'];*/
		
		$id = 1;
        $aboutFamily= "cool";
        $aboutFriends= "cool1";
        $parentId = "cool12";
        $color= "cobol";
        $game= "cool78";
        $food= "cool782";
        $music= "cool6458";
        $hobby= "cool7214";
        $tv_show = "cool3247";
        $actor= "cool203";
        $trip= "cool7842";
        $describePlan= "cool187";


$sql = "UPDATE TABLE childprofile set family=".$aboutFamily.", friends=".$aboutFriends.", color=".$color.", game=".$game.", food=".$game.", music=".$music.", hobby=".$hobby.", cartoon=".$tv_show.", trip=".$trip." WHERE id = ".$id;

echo $sql;

$response=array();

if(mysqli_query($con,$sql)){
	$code="reg_success";
	$message="Registered Successfully";
}else{
	$code="reg_fail";
	$message="Registration Failed";
}
array_push($response, array("code"=>$code,"message"=>$message));

echo json_encode($response);

mysqli_close($con);


?>