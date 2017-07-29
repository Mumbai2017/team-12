<?php
require('init.php');

$doctor_id = $_POST['doctor_id'];
$vol_id = $_POST['vol_id'];
$wish1 = $_POST['wish1'];
$wish2 = $_POST['wish2'];
$wish3 = $_POST['wish3'];
$date_submit = $_POST['date_submit'];
$approved_wish = $_POST['approved_wish'];
$date_approve = $_POST['date_approve'];
$donor_id = $_POST['donor_id'];
$family = $_POST['family'];
$friends = $_POST['friends'];
$color = $_POST['color'];
$book = $_POST['game'];
$game = $_POST['game'];
$food = $_POST['food'];
$muisc_movie = $_POST['muisc_movie'];
$hobby = $_POST['hobby'];
$cartoon = $_POST['cartoon'];
$actor = $_POST['actor'];
$trip = $_POST['trip'];
$ambition = $_POST['ambition'];
$bigwish1 = $_POST['bigwish1'];
$bigwish2= $_POST['bigwish2'];
$bigwish3 = $_POST['bigwish3'];

$sql = "insert into childprofile(doctor_id, vol_id,wish1, wish2, wish3, date_submit, approved_wish, date_approve, donor_id, family, friends, color, book, game, food, muisc_movie, hobby, cartoon, actor, trip, ambition, bigwish1, bigwish2, bigwish3) values ('$doctor_id', '$vol_id', '$wish1', '$wish2', '$wish3', '$date_submit', '$approved_wish', '$date_approve', '$donor_id', '$family', '$friends', '$color', '$book','$game','$food','$muisc_movie','$hobby', '$cartoon' '$actor','$trip', '$ambition', '$bigwish1', '$bigwish2', '$bigwish3')"

echo $sql;
echo "Rajat did this";

$response = array();
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